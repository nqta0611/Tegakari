/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import allguis.LobbyGUI;

/**
 * The interface for ChooseTheme
 * @author anhnguyen
 */
public interface I_ChooseTheme 
{
    /**
     * Disposes of the console
     */
    public void dispose();
    /**
     * enables the ok button
     * @param visable enable?
     */
    public void okEnable(boolean visable);
    /**
     * get the gui
     * @return the gui
     */
    public LobbyGUI getGUI();
    /**
     * sets the greek images
     */
    public void setGreekImages();
    /**
     * sets the pirate images
     */
    public void setPirateImages();
    /**
     * sets the washington images
     */
    public void setWashingtonImages();
    /**
     * sets blank images
     */
    public void setBlankImages();
}
