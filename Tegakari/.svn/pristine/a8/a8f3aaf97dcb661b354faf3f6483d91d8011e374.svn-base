/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;
/**
 * The console for SleuthOnMeDialog
 * @author jchoi30
 */
public class SleuthOnMeDialogConsole implements I_SleuthOnMeDialog
{
    private SleuthOnMeDialogController ctrl;
    private List<ClueCard> clues;
    private Scanner input;
    
    /**
     * The constructor for the console
     * @param aCtrl the controller
     * @param clueCards the clue cards to use
     * @param scanner the scanner to use
     */
    public SleuthOnMeDialogConsole(SleuthOnMeDialogController aCtrl, 
            List<ClueCard> clueCards, Scanner scanner)
    {
        this.ctrl = aCtrl;
        this.input = scanner;
        this.clues = clueCards;
    }
    
    /**
     * Starts the console
     */
    public void startDialogue()
    {
        // for all clue cards
        for (int index = 0; index < clues.size(); index++)
        {
            System.out.println((index + 1) + ": " + clues.get(index).getName());
        }
        
        System.out.println("Input which card you would like to show");
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, line);
        ctrl.actionPerformed(evt);
        
    }
    
    /**
     * sets all buttons off
     */
    public void setOff()
    {
    }
    /**
     * enables the given button
     * @param cmd the button
     */
    public void setEnabledButton(String cmd)
    {
    }
    /**
     * enables the OK button
     */
    public void setEnabledOK()
    {
    }
    /**
     * disposes the view
     */
    public void dispose()
    {
    }
}
