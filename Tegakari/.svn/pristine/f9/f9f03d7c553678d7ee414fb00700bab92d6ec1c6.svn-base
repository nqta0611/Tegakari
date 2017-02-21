/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;

/**
 * The Console for PrivateTipToDialog
 * @author jchoi30
 */
public class PrivateTipToDialogConsole implements I_PrivateTipToDialog
{
    private PrivateTipToDialogController ctrl;
    private List<Player> players;
    private Scanner input;
    
    /**
     * the constructor for the console
     * @param aCtrl the controller to use
     * @param listPlayers the list of players in the game
     * @param scanner the scanner to use
     */
    public PrivateTipToDialogConsole(PrivateTipToDialogController aCtrl, 
            List<Player> listPlayers, Scanner scanner)
    {
        this.ctrl = aCtrl;
        this.input = scanner;
        this.players = listPlayers;
    }
    /**
     * starts the console
     */
    public void startDialogue()
    {
        // for all players
        for (int index = 0; index < players.size(); index++)
        {
            System.out.println((index + 1) + ": " + players.get(index).getName());
        }
        
        System.out.println("Input which player you would like to send this card to");
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, line);
        ctrl.actionPerformed(evt);
        
    }
    /**
     * disables all buttons
     */
    public void disableAll()
    {
    }
    /**
     * sets the OK button
     * @param set what to set it to
     */
    public void setOK(boolean set)
    {
    }
    /**
     * Sets the given button
     * @param seat the button
     * @param set what to set it to
     */
    public void setButton(int seat, boolean set)
    {
    }
    /**
     * erases the window
     */
    public void eraseWindow()
    {
    }
}
