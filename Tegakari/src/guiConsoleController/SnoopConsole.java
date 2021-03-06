/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;

/**
 * Console for SnoopDialog used for system tests.
 * 
 * @author jchoi30
 */
public class SnoopConsole implements I_SnoopDialog
{
    private SnoopDialogController ctrl;
    private List<ClueCard> clues;
    private Scanner input;
    
    /**
     * Creates a new console with a controller and input stream.
     * 
     * @param ctrl controller, eventHandler for SuggestionandMoveDialog
     * @param input input for gameplay.
     * @param clues list of cards
     */
    public SnoopConsole(SnoopDialogController ctrl, List<ClueCard> clues, Scanner input)
    {
        this.ctrl = ctrl;
        this.input = input;
        this.clues = clues;
    }
    
    /**
     * Game dialog used for snoop.
     */
    public void startDialogue()
    {
        System.out.println("Pick a number from 1 - " + clues.size() +
                " to snoop the card on");
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, "clue" + line);
        ctrl.actionPerformed(evt);
        
        System.out.println("You saw the card " + ctrl.showDialog().getName());
        
    }
    
    /**
     * Sets the cardButton
     * @param num index of card
     * @param set desired boolean for card
     */
    public void setCardButton(int num, boolean set)
    {
        
    }
    
    /**
     * Sets the Icon of the card
     * @param card index of card
     * @param pickedCard cluecard given
     */
    public void setIcon(int card, ClueCard pickedCard)
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
     * Disposes of the view.
     */
    public void dispose()
    {
        
    }
    
    /**
     * Check if the OK button is set to visible
     * @return true if it is, false if not
     */
    public boolean isOkVisible()
    {
        return true;
    }

}
