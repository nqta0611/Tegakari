/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;
import java.awt.event.ActionEvent;
import tegakari.*;
import java.util.*;

/**
 * The console of the accusation confirm.
 * @author anhnguyen
 */
public class AccusationConfirmConsole  implements I_AccusationConfirm
{
    private AccusationConfirmController ctrl;
    private Solution accuse;
    private Scanner input;
    private GameTableConsole console;
    
    /**
     * The constructor
     * @param ctrl the controller to use
     * @param accuse the solution attempted
     * @param input the scanner to use
     * @param console  the GameTableConsole
     */
    public AccusationConfirmConsole(AccusationConfirmController ctrl, 
            Solution accuse, Scanner input, GameTableConsole console)
    {
        this.ctrl = ctrl;
        this.accuse = accuse;
        this.input = input;
        this.console = console;
    }
    /**
     * This is the starting text of the console.
     */
    public void startDialogue()
    {
        
        System.out.println("Are you sure to make this accusation: [" + 
                accuse.getSuspect().getName()
                + "] in a [" + accuse.getVehicle().getName() + "] at [" + 
                accuse.getDestination().getName() +"]");
        System.out.println("Enter (y) to confirm, (n) to cancel");
        String line = input.nextLine();
        
        ActionEvent evt = new ActionEvent(this, 0, line);
        ctrl.actionPerformed(evt);
    }

    /**
     * Disposes of the view
     */
    @Override
    public void disposeView() 
    {
    }
    /**
     * Restarts the turn
     */
    public void restartTurn()
    {
        console.turn();
    }
}
