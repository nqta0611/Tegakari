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
 * The accusation console
 * @author jchoi30
 */
public class AccusationConsole implements I_Accusation
{
    private AccusationController ctrl;
    private List<Player> list;
    private JButton button;
    private Scanner input;
    /**
     * The constructor
     * @param ctrl the controller
     * @param input the scanner to use
     */
    public AccusationConsole(AccusationController ctrl, Scanner input)
    {
        this.ctrl = ctrl;
        this.input = input;
        this.button = new JButton();
    }
    /**
     * Starts the console
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
        
        evt = new ActionEvent(this, 0, "ok");
        ctrl.actionPerformed(evt);
        
    }
    /**
     * Gets the button
     * @param destination the destination to get
     * @return the button
     */
    public JButton getDestinationButton(int destination)
    {
        return button;
    }
    /**
     * Gets the vehicle button
     * @param vehicle the button to get
     * @return the button
     */
    public JButton getVehicleButton(int vehicle)
    {
        return button;
    }
    /**
     * Gets the suspect button
     * @param suspect the button to get
     * @return the button
     */
    public JButton getSuspectButton(int suspect)
    {
        return button;
    }
    /**
     * get the ok button
     * @return the button
     */
    public JButton getOKButton()
    {
        return button;
    }
    /**
     * Disposes of the console
     */
    public void dispose()
    {
        
    }
}
