/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;
import javax.swing.JButton;
import javax.swing.JRadioButton;
/**
 * Console for SuggestionDialog used for system tests.
 * 
 * @author jchoi30
 */
public class SuggestionConsole implements I_Suggestion
{
    private SuggestionDialogController ctrl;
    private List<Player> list;
    private JButton button;
    private Scanner input;
    
    /**
     * Creates a new console with a controller and input stream.
     * 
     * @param ctrl controller, eventHandler for SuggestionDialog
     * @param input input for gameplay.
     */
    public SuggestionConsole(SuggestionDialogController ctrl, Scanner input)
    {
        this.ctrl = ctrl;
        this.button = new JButton();
        this.input = input;
    }
    
    /**
     * Game dialog used for suggestion.
     */
    public void startDialogue()
    {
        System.out.println("Pick a suspect according to theme (1-6)");
        String line = input.nextLine();

        ActionEvent evt = new ActionEvent(this, 0, "suspect" + line);
        ctrl.actionPerformed(evt);

        System.out.println("Pick a vehicle according to theme (1-6)");
        line = input.nextLine();

        evt = new ActionEvent(this, 0, "vehicle" + line);
        ctrl.actionPerformed(evt);

        System.out.println("Pick a destination according to theme (1-9)");
        line = input.nextLine();

        evt = new ActionEvent(this, 0, "destination" + line);
        ctrl.actionPerformed(evt);
        
    }
    
    /**
     * Returns the current destination.
     * @return the selected button
     */
    public JButton getCurrDestination()
    {
        return button;
    }
    
    /**
     * Returns the button of the corresponding destination
     * @param destination index of queried destination.
     * @return the button queried for.
     */
    public JButton getDestinationButton(int destination)
    {
        return button;
    }
    
    /**
     * Returns the button of the corresponding vehicle
     * @param vehicle index of queried vehicle.
     * @return the button queried for.
     */
    public JButton getVehicleButton(int vehicle)
    {
        return button;
    }
    
    /**
     * Returns the button of the corresponding suspect
     * @param suspect index of queried suspect.
     * @return the button queried for.
     */
    public JButton getSuspectButton(int suspect)
    {
        return button;
    }
    
    /**
     * Returns the OK
     * @return the button queried for.
     */
    public JButton getOKButton()
    {
        return button;
    }
    
    /**
     * Disposes of the view.
     */
    public void dispose()
    {
        
    }
}
