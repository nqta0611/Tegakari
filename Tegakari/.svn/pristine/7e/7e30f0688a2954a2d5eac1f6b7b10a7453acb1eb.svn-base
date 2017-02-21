/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;
import allguis.LobbyGUI;
import tegakari.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controller for chooseTheme
 * @author anhnguyen
 */
public class ChooseThemeController implements ActionListener, KeyListener
{
    private ThemeType theme;
    private String imagePaths;
    private I_ChooseTheme view;
    private boolean isConsole;
    private LobbyGUI gui;
    
    private ActionEvent greek;
    private ActionEvent pirate;
    private ActionEvent washington;
    private ActionEvent choose;
    private Lobby lobby;
    /**
     * Sets up the controller
     * @param aConsole console?
     * @param aView the view to use
     * @param aLobby the lobby
     */
    public void setup(boolean aConsole, I_ChooseTheme aView, Lobby aLobby)
    {
        this.view = aView;
        this.theme = ThemeType.GREEK;
        this.imagePaths = "Greek";
        this.isConsole = aConsole;
        this.lobby = aLobby;
        this.gui = aView.getGUI();
        
        this.greek = new ActionEvent(this, 0, "G");
        this.pirate = new ActionEvent(this, 0, "P");
        this.washington = new ActionEvent(this, 0, "W");
        this.choose = new ActionEvent(this, 0, "OK");
    }
    /**
     * called if action performed
     * @param e the action
     */ 
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if greek 
        if (cmd.equals("G") || e.equals(greek) || cmd.equals("g"))
        {
            this.theme = ThemeType.GREEK;
            this.imagePaths = "Greek";
            
            view.okEnable(true);
            
            view.setGreekImages();
        }
        // if pirate
        else if (cmd.equals("P") || cmd.equals("p"))
        {
            this.theme = ThemeType.PIRATE;
            this.imagePaths = "Pirate";
            
            view.okEnable(true);
            
            view.setPirateImages();
        }
        // if washington
        else if (cmd.equals("W") || cmd.equals("w"))
        {
            this.theme = ThemeType.WHITEHOUSE;
            this.imagePaths = "Washington";
            
            view.okEnable(true);
            
            view.setWashingtonImages();
        }
        else
        {
            lobby.setThemeType(theme);
            view.dispose();
        }
    }
    /**
     * Show the dialog
     * @return the image paths
     */
    public String showDialog()
    {
        return this.imagePaths;
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
        // if greek
        if(e.getKeyCode() == KeyEvent.VK_G)
        {
            this.actionPerformed(greek);
        }
        // if pirate
        else if (e.getKeyCode() == KeyEvent.VK_P)
        {
            this.actionPerformed(pirate);
        }
        // if washington
        else if (e.getKeyCode() == KeyEvent.VK_W)
        {
            this.actionPerformed(washington);
        }
        // if space
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(choose);
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
