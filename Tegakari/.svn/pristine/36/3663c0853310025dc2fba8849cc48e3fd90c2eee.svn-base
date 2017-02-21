package guiConsoleController;

import tegakari.*;
import java.util.*;
/**
 * The console for for SleuthResultDialog.
 * 
 * @author jchoi30
 */
public class SleuthResultDialogConsole implements I_SleuthResultDialog
{
    private SleuthResultDialogController ctrl;
    private List<CardMessage> toShow;

    /**
     * The constructor for this class.
     * 
     * @param ctrl the controller for this view
     * @param toShow the card(s) to show
     */
    public SleuthResultDialogConsole(SleuthResultDialogController ctrl, 
            List<CardMessage> toShow)
    {
        this.ctrl = ctrl;
        this.toShow = toShow;
    }
    
    /**
     * Print out the appropriate dialog.
     */
    public void startDialog()
    {
        // Print out all given action cards
        for (int ndx = 0; ndx < toShow.size(); ndx++)
        {
            System.out.println("Recieved from: " + 
                    toShow.get(ndx).getFromPlayer().getName());
            System.out.println("The Card " + 
                    ((ClueCard)(toShow.get(ndx).getCards().get(0))).getName());
        }
    }
    
    /**
     * Disposes this view.
     */
    public void dispose()
    {
    }
}
