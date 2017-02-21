/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import allguis.MainWindow;
import allguis.ScreenNameDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tegakari.*;
import allguis.LobbyGUI;

/**
 * The controller for ScreenName
 * @author jchoi30
 */
public class ScreenNameController implements ActionListener, KeyListener
{
    /**
     * the LobbyGUI
     */
    private Lobby lobby;
    private I_ScreenName view;
    private boolean isConsole;
    private ActionEvent ok;
    private ActionEvent back;
    private LobbyGUI parent;
    
    /**
     * sets up the controller
     * @param aView the view to use - GUI or console
     * @param theLobby the game lobby
     * @param aConsole if it is a console
     * @param lobbyGUI the LobbyGUI
     */
    public void setup(I_ScreenName aView, Lobby theLobby,
            boolean aConsole, LobbyGUI lobbyGUI)
    {
        this.view = aView;
        this.lobby = theLobby;
        this.isConsole = aConsole;
        this.parent = lobbyGUI;
        
        this.ok = new ActionEvent(this, 0, "OK");
        this.back = new ActionEvent(this, 0, "BACK");
    }
    
    /**
     * Helper method that checks whether or not the proposed screen name has
     * valid alphanumeric characters including an underscore.
     * 
     * @param screenName to check for validity
     * @return true if string is valid, false if not.
     */
    private boolean verifyCharacters(String screenName)
    {
        // for all characters in the screen name
        for (int index = 0; index < screenName.length(); index++ )
        {
            // if not a proper character
            if (!Character.isDigit(screenName.charAt(index)) && 
                    !Character.isLetter(screenName.charAt(index)) && 
                    !(screenName.charAt(index) == '_'))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private void helperActionBack()
    {
        // if not console
        if (!isConsole)
        {
            lobby.deleteObserver(parent);
            // DISCONNECT from the server
            lobby.closeLobby();
            // CLOSE lobbygui
            parent.setVisible(false);
            parent.dispose();
            // close this gui
            ((ScreenNameDialog)view).setVisible(false);
            ((ScreenNameDialog)view).dispose();
            // launch main window with same lobby created from Application
            MainWindowController controlMain = new MainWindowController();
            MainWindow mainWindow = new MainWindow(controlMain);
            controlMain.setup(mainWindow, parent.getLobby(), false);
            mainWindow.pack();
            mainWindow.setVisible(true);
        }
        else
        {
            System.exit(0);
        }
    }
    
    private void helperActionUnique(String screenName)
    {
        // IF there's room in the lobby
        if (lobby.getPlayers().size() 
                < lobby.getMaxPlayersAllowed())
        {
            lobby.sendPlayerToServer(screenName);
            view.setParentTitle("Tegakari: " + lobby.getSelfName());
            // if not console
            if (!isConsole)
            {
                ((ScreenNameDialog)view).setVisible(false);
            }
            else
            {
                ((ConsoleLobbyPhase)view).setFound(true);
            }
        }
        else
        {
            view.setErrorText("Lobby is full. Try again later.");
            return;
        }
    }
    
    /**
     * action performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        String screenName = "";
        
        // if OK
        if (cmd.equals("OK"))
        {
            try
            {
                screenName = view.getUsername();
            }
            catch (NullPointerException ex)
            {
                System.out.println(ex);
            }
            // Check if name is alphanumeric or underscore
            if (!verifyCharacters(screenName))
            {
                view.setErrorText("Please use only alphanumeric characters and "
                        + "underscores.");
                return;
            }

            // Check size of name to be within 1 to 16.
            if (screenName.length() > 16 || screenName.length() < 1)
            {
                view.setErrorText("Size of screen name must be within 1 to 16 "
                        + "characters.");
                return;
            }

            // Check if name is unique
            if (lobby.checkPlayers(screenName)) 
            {
                helperActionUnique(screenName);
            }
            else
            {
                view.setErrorText("Screen name already in use. Choose another.");
                return;
            }
        }
        // back
        else if (cmd.equals("BACK"))
        {
            helperActionBack();
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
        // if ENTER
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.actionPerformed(ok);
        }
        // if ESCAPE
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            this.actionPerformed(back);
        }
    }

    /**
     * Key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
