/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;
/**
 * Console for SnoopOnPlayerDialog used for system tests.
 * 
 * @author jchoi30
 */
public class SnoopOnPlayerConsole implements I_SnoopOnPlayerDialog
{
    private SnoopOnPlayerDialogController ctrl;
    private List<Player> list;
    private Scanner input;
    
    /**
     * Creates a new console with a controller and input stream.
     * 
     * @param ctrl controller, eventHandler for SuggestionandMoveDialog
     * @param input input for gameplay.
     * @param list list of players
     */
    public SnoopOnPlayerConsole(SnoopOnPlayerDialogController ctrl, 
            List<Player> list, Scanner input)
    {
        this.ctrl = ctrl;
        this.input = input;
        this.list = list;
    }
    
    /**
     * Game dialog used for snooping on a player.
     */
    public void startDialogue()
    {
        System.out.print("Players:");
        // print out choices
        for (int count = 1; count < list.size(); count++)
        {
            System.out.print(" " + "[" + count + "]" + list.get(count).getName());
        }
        System.out.println();
        System.out.println("Pick a Player to snoop on, integer 1-" + (list.size() - 1));
        
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, "seat" + line);
        ctrl.actionPerformed(evt);
        
        System.out.println("You Snooped on the player " + ctrl.showDialog().getName());
        
    }
    
    /**
     * Sets the seatButton
     * @param num index of seat
     * @param set desired boolean for seat
     */
    public void setSeatButton(int num, boolean set)
    {
        
    }
    
    /**
     * Sets the okButton
     * @param set desired boolean for okButton
     */
    public void setOKButton(boolean set)
    {
        
    }
    
    /**
     * Sets the chosen player
     * @param num index of the player
     */
    public void setChosenPlayer(int num)
    {
        
    }
    
    /**
     * Disposes of the view.
     */
    public void dispose()
    {
        
    }
}
