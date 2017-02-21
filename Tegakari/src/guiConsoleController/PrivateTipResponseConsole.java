/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;

/**
 * The console of PrivateTipResponse
 * @author roh
 */
public class PrivateTipResponseConsole implements I_PrivateTipResponse
{
    private PrivateTipResponseController ctr;
    private String playerFrom;
    private List<ClueCard> list;
    
    /**
     * The constructor for this PrivateTipResponseConsole
     * @param aCtrl the controller
     * @param recievedCardList the cards to use
     * @param logic the logic to use
     */
    public PrivateTipResponseConsole(PrivateTipResponseController aCtrl, 
            List<ClueCard> recievedCardList, PrivateTipCardLogic logic)
    {
        this.ctr = aCtrl;
        this.playerFrom = logic.getTargetPlayer().getName();
        this.list = recievedCardList;
    }
    
    /**
     * Starts the console
     */
    public void startDialogue()
    {
        // if list empty
        if (list.isEmpty())
        {
            System.out.println(playerFrom + " has no cards to show you.");
        }
        // list not empty
        else
        {
            System.out.println(playerFrom + " shows you:");
            // for all cards in list
            for (int clue = 0; clue < list.size(); clue++)
            {
                System.out.println(list.get(clue).getName());
            }
        }
    }

    /**
     * dispose of the view
     */
    @Override
    public void dispose() 
    {
    }
    
}
