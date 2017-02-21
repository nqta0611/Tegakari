/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;

/**
 * The Console for ShowCardDialog
 * @author roh
 */
public class ShowCardDialogConsole implements I_ShowCardDialog
{
    private ShowCardDialogController ctr;
    private String playerFrom;
    private ClueCard card;
    
    /**
     * The Constructor for this COnsole
     * @param aCtrl the controller
     * @param recievedCardList the list of card messages
     */
    public ShowCardDialogConsole(ShowCardDialogController aCtrl, 
            List<CardMessage> recievedCardList)
    {
        this.ctr = aCtrl;
        this.playerFrom = recievedCardList.get(0).getFromPlayer().getName();
        this.card = (ClueCard) recievedCardList.get(0).getCards().get(0);
    }
    
    /**
     * starts the console
     */
    public void startDialogue()
    {
        System.out.println(playerFrom + " has: " + card.getName());
    }

    /**
     * disposes of the view
     */
    @Override
    public void dispose() 
    {
    }
    
}
