/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import tegakari.*;
import java.util.*;
/**
 * Console for SnoopOnMeDialog used for system tests.
 * 
 * @author jchoi30
 */
public class SnoopOnMeConsole implements I_SnoopOnMeDialog
{
    private SnoopOnMeDialogController ctrl;
    private CardMessage toShow;

    /**
     * Creates a new console with a controller and card.
     * 
     * @param ctrl controller, eventHandler for SuggestionandMoveDialog
     * @param toShow message with card information
     */
    public SnoopOnMeConsole(SnoopOnMeDialogController ctrl, CardMessage toShow)
    {
        this.ctrl = ctrl;
        this.toShow = toShow;
    }
    
    /**
     * Game dialog used for snoop on me.
     */
    public void startDialog()
    {
        System.out.println("Showed to the player " + 
                toShow.getFromPlayer().getName());
        System.out.println("The Card " + 
                ((ClueCard)(toShow.getCards().get(0))).getName());
    }
    
    /**
     * Disposes of the view.
     */
    public void dispose()
    {
    }
}
