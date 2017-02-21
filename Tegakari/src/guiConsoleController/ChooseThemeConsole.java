/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import allguis.LobbyGUI;
import java.awt.event.ActionEvent;
import java.util.Scanner;

/**
 * The chooseTheme console
 * @author anhnguyen
 */
public class ChooseThemeConsole implements I_ChooseTheme
{
    private ChooseThemeController ctrl;
    private Scanner input;
    
    /**
     * The constructor
     * @param ctrl the controller
     * @param input the scanner to use
     */
    public ChooseThemeConsole(ChooseThemeController ctrl, Scanner input)
    {
        this.ctrl = ctrl;
        this.input = input;
    }
    
    /**
     * starts the console
     */
    public void startDialogue()
    {   
        System.out.println("Please Choose a theme:"
                + " Greek(G), Washington(W), or Pirate(P)");
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, line);
        ctrl.actionPerformed(evt);
        
        evt = new ActionEvent(this, 0, "OK");
        ctrl.actionPerformed(evt);
    }

    /**
     * Disposes of the console
     */
    @Override
    public void dispose() 
    {
    }
    
    /**
     * enables the ok button
     * @param visible enable?
     */
    public void okEnable(boolean visible)
    {
        
    }
    
    /**
     * get the gui
     * @return the gui
     */
    public LobbyGUI getGUI()
    {
        return null;
    }
    /**
     * sets the greek images
     */
    public void setGreekImages()
    {
        
    }
    /**
     * sets the pirate images
     */
    public void setPirateImages()
    {
        
    }
    /**
     * sets the washington images
     */
    public void setWashingtonImages() 
    {
        
    }
    
    /**
     * sets blank images
     */
    public void setBlankImages()
    {
        
    }
}
