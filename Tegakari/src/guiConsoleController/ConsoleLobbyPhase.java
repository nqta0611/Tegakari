/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import tegakari.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Console LobbyPhase
 * @author jchoi30
 */
public class ConsoleLobbyPhase implements Observer, I_ScreenName
{
    private MainWindowController ctrl;
    private Lobby lobby;
    private String user;
    private boolean goodName;
    private boolean notPrinted;
    private LobbyController lobbyCtrl;
    private boolean choseTheme = false;
    private Scanner input;
    
    /**
     * The constructor
     * @param ctrl the controller
     * @param lobby the lobby
     * @param input the scanner to use
     */
    public ConsoleLobbyPhase(MainWindowController ctrl, Lobby lobby, Scanner input)
    {
        this.ctrl = ctrl;
        this.lobby = lobby;
        this.input = input;
        this.notPrinted = true;
    }
    /**
     * starts the lobby phase
     */
    public void lobbyPhase()
    {
        ActionEvent evt = new ActionEvent(this, 0, "JOIN LOBBY");
        ctrl.actionPerformed(evt);
        System.out.println("Player joined game");
        
        lobbyCtrl = new LobbyController();
        ScreenNameController screenControl = new ScreenNameController();
        
        lobby.addObserver(this);
        lobbyCtrl.setup(this, lobby, true);

        screenControl.setup(this, lobby, true, null);
        goodName = false;
        // do
        do
        {
            System.out.println("Insert a username:");
            user = input.nextLine();
            evt = new ActionEvent(this, 0, "OK");
            screenControl.actionPerformed(evt);
            //Check if there was an error in entering a user name
            if (!goodName)
            {
                //ask user to exit the application if the user was not entered
                System.out.println("Exit the application? y/n");
                // If yes
                if (input.nextLine().equals("y"))
                {
                    return;
                }
            }
        }
        while (!goodName);
        System.out.println("Player accepted");
        
    }
    /**
     * Set found
     * @param found what to set it to
     */
    public void setFound(boolean found)
    {
        goodName = found;
    }
    /**
     * Set title
     * @param s what to set it to
     */
    public void setParentTitle(String s)
    {
        System.out.println("Lobby name changed to: " + s);
    }
    /**
     * set error text
     * @param s what to set it to
     */
    public void setErrorText(String s)
    {
        System.out.println(s);
    }
    /**
     * get username
     * @return the username
     */
    public String getUsername()
    {
        return user;
    }
    
    /**
     * updates the console
     * @param obs the obervable
     * @param obj the object
     */
    @Override
    public void update(Observable obs, Object obj)
    {
        String line;
        // if first player and not printed
        if (lobby.isFirstPlayer() && notPrinted)
        {
            notPrinted = false;
            String in = null;
            // enables first player only buttons
            if (!choseTheme)
            {
                ChooseThemeController theCtrl = new ChooseThemeController();
                ChooseThemeConsole view = new ChooseThemeConsole(theCtrl, input);
                theCtrl.setup(true, view, lobby);
                view.startDialogue();
                System.out.println("Would you like to add a robot? (y/n)");
                in = input.nextLine();
                // while input is yes
                while (in.equals("y"))
                {
                    CreateRobotController robotCtrl = new CreateRobotController();
                    CreateRobotConsole rview = new 
                            CreateRobotConsole(robotCtrl, lobby, input);
                    robotCtrl.setup(false, rview);
                    rview.startDialogue();
                    System.out.println("Would you like to add another robot? (y/n)");
                    in = input.nextLine();
                }
                choseTheme = true;
            }
        }
        // if right number of players and hasn't started
        if (lobby.getNumPlayersToStart() == 0 && !lobby.isStartGame())
        {
            // if first player
            if (lobby.isFirstPlayer())
            {
                System.out.println(lobby.getPlayers().size() + " is the number "
                        + "of players in the lobby. If that is the correct n"
                        + "umber of players you would like in this game press y"
                        + " (yes) to start or else n (no) to wait for more play"
                        + "ers.");
                line = input.nextLine();
                // if yes
                if (line.equals("y"))
                {
                    ActionEvent evt = new ActionEvent(this, 0, "Start");
                    lobbyCtrl.actionPerformed(evt);
                }
            }
        }
        // if startgame
        if (lobby.isStartGame())
        {
            startGame();
        }  
    }
    
    private void startGame()
    {
        AtomicBoolean lock = new AtomicBoolean();
        GameTableController theController = new GameTableController();
        GameTableConsole gameTable = new GameTableConsole(
                theController, lobby.getGameEngine(), input, lock);
        theController.setup(gameTable, lobby.getGameEngine(), true, input);
        lobby.getGameEngine().setScanner(input);
        gameTable.update(null, null);
    }
}
