package guiConsoleController;

import allguis.LobbyGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tegakari.*;

/**
 * The controller for the LobbyGUI and Console
 * @author jchoi30
 */
public class LobbyController implements ActionListener, KeyListener
{
    /**
     * the LobbyGUI
     */
    private Lobby lobby;
    private Object view;
    private boolean isConsole;
    private ActionEvent start;
    private ActionEvent robot;
    private ActionEvent theme;
    private ActionEvent invisible;
    private LobbyGUI gui;

    /**
     * Sets up the controller
     * @param aView the view - GUI or Console
     * @param aLobby the game lobby
     * @param console if it is console or not
     */
    public void setup(Object aView, Lobby aLobby, boolean console)
    {
        this.view = aView;
        this.lobby = aLobby;
        this.isConsole = console;
        
        this.start = new ActionEvent(this, 0, "Start");
        this.robot = new ActionEvent(this, 0, "Robot");
        this.theme = new ActionEvent(this, 0, "Theme");
        this.invisible = new ActionEvent(this, 0, "invisible");
    }
    
    /**
     * Sets up the controller with a gui class.
     * 
     * @param aView the view - GUI or Console
     * @param aLobby the game lobby
     * @param console if it is console or not - should be true
     * @param theGui the corresponding gui
     */
    public void setup(Object aView, Lobby aLobby, boolean console, LobbyGUI theGui)
    {
        setup(aView, aLobby, console);
        this.gui = theGui;
    }

    /**
     * Action Performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if start
        if (cmd.equals("Start"))
        {
            //startButton.setEnabled(false); do i need this?
            lobby.startGame();
            // if it was a console
            if (!isConsole)
            {
                ((LobbyGUI)view).startSetEnabled(false);
            }
        }
        // if robot
        else if (cmd.equals("Robot"))
        {
            // if you can add a robot and you are first player
            if (lobby.canAddRobot() && lobby.isFirstPlayer())
            {
                ((LobbyGUI) view).robotVisible();
            }
        }
        // if theme
        else if (cmd.equals("Theme"))
        {
            // if you are first player
            if (lobby.isFirstPlayer())
            {
                ((LobbyGUI) view).themeVisible();
            }
        }
        // for testing
        else if (cmd.equals("invisible"))
        {
            System.out.println("testing main window");
        }
    }

    /**
     * key typed
     * @param e the key
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if S
        if(e.getKeyCode() == KeyEvent.VK_S && 
                (isConsole || gui.getStartButton().isEnabled()))
        {
            this.actionPerformed(start);
        }
        // if R
        else if (e.getKeyCode() == KeyEvent.VK_R && 
                (isConsole || gui.getRobotButton().isEnabled()))
        {
            this.actionPerformed(robot);
        }
        // if T
        else if (e.getKeyCode() == KeyEvent.VK_T && 
                (isConsole || gui.getThemeButton().isEnabled()))
        {
            this.actionPerformed(theme);
        }
    }

    /**
     * key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
