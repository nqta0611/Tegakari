package guiConsoleController;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Scanner;
import tegakari.*;

/**
 * The disprove console
 * @author DeionLaw
 */
public class DisproveConsole implements I_Disprove
{
    private List<ClueCard> list;
    private DisproveController ctrl;
    private Scanner input;
    
    /**
     * The constructor
     * @param ctrl the controller
     * @param disproveList the cards to disprove
     * @param input the scanner to use
     */
    public DisproveConsole(DisproveController ctrl, 
            List<ClueCard> disproveList, Scanner input)
    {
        this.list = disproveList;
        this.input = input;
        this.ctrl = ctrl;
    }
    /**
     * starts the console
     */
    public void startDialogue()
    {
        ctrl.getSuggestion();
        int xConstant = 0;
        // for all cards in list
        for (ClueCard card : list)
        {
            xConstant++;
            System.out.println(xConstant + ": " + card.getName());
        }
        
        System.out.println("Pick a card to choose");
        String in = input.nextLine();
        // if 1
        if (in.equals("1"))
        {
            ActionEvent evt = new ActionEvent(this, 0, "suspectButton");
            ctrl.actionPerformed(evt);
        }
        // if 2
        else if (in.equals("2"))
        {
            ActionEvent evt = new ActionEvent(this, 0, "vehicleButton");
            ctrl.actionPerformed(evt);
        }
        else
        {
            ActionEvent evt = new ActionEvent(this, 0, "DestinationButton");
            ctrl.actionPerformed(evt);
        }
    }
    /**
     * disposes of the console
     */
    public void dispose()
    {
        
    }
    /**
     * sets the disprove enabled
     * @param choice the choice
     * @param set what to set it to
     */
    public void setEnabled(String choice, boolean set)
    {
        
    }
}
