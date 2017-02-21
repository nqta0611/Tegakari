/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;
/**
 * The console for PrivateTipDialog
 * @author jchoi30
 */
public class PrivateTipDialogConsole implements I_PrivateTipFrom
{
    private PrivateTipFromDialogController ctrl;
    private List<ClueCard> clues;
    private PrivateTipCard privateTip;
    private Scanner input;
    private String playerName;
    
    /**
     * The constructor for this console
     * @param aCtrl the controller to use
     * @param clueCards the clue cards to use
     * @param pTip the private tip card
     * @param tPlayer the turn player
     * @param scanner the scanner to use
     */
    public PrivateTipDialogConsole(PrivateTipFromDialogController aCtrl, 
            List<ClueCard> clueCards, PrivateTipCard pTip, 
            Player tPlayer, Scanner scanner)
    {
        this.ctrl = aCtrl;
        this.input = scanner;
        this.clues = clueCards;
        this.privateTip = pTip;
        this.playerName = tPlayer.getName();
    }
    
    /**
     * starts the console
     */
    public void startDialogue()
    {   
        // for all cards in clue
        System.out.println("Cards that met the Private Tip condition:");
        // print out choices
        for (int index = 0; index < clues.size(); index++)
        {
            System.out.println("\t"+(index + 1) + ": " + clues.get(index).getName());
        }
        // if size is 0
        if (clues.size() == 0)
        {
            System.out.println(playerName + 
                    " played this Private Tip but you have no cards to show!");
        }
        // size != 0
        else
        {
            // if it is an ALL tip
            if (privateTip.isAll())
            {
                System.out.println(playerName + 
                        " played a Private Tip and you "
                        + "have shown all these cards.");
            }
            else
            {
                System.out.println(playerName
                        + " played the Private Tip: \""+privateTip.getActionText()
                        + "\" on you.\nInput "
                        + "which card you would like to show "
                        + "(as listed above with 1,2,etc.).");
                String line = input.nextLine();
                ActionEvent evt = new ActionEvent(this, 0, line);
                ctrl.actionPerformed(evt);
            }
        }
    }
    
    /**
     * disables all cards
     */
    public void disableCards()
    {
    }
    /**
     * enables the given button
     * @param cmd the button to enable
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
     * Disposes of the view
     */
    public void dispose()
    {
    }
}
