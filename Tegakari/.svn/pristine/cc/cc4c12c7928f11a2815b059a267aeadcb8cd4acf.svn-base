package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JButton;
import tegakari.*;

/**
 * Controller class for SuggestionDialogController.
 * 
 * @author Jonathan Molina
 */
public class AccusationController implements ActionListener, KeyListener
{
    /**
     * The view
     */
    private I_Accusation dialog;
    private final int kNumSuspectButtons = 6;
    private final int kNumVehicleButtons = 6;
    private final int kNumDestinationButtons = 9;
    /**
     * The suspect chosen for the suggestion
     */
    private Suspect suspectChosen;
    /**
     * The vehicle chosen for the suggestion
     */
    private Vehicle vehicleChosen;
    /**
     * The destination chosen for the suggestion
     */
    private Destination destinationChosen;
    /**
     * True if player selects to move destinations
     */
    private boolean move = false;
    /**
     * The game state of the game
     */
    private GameState state;
    /**
     * List of all suspect cards
     */
    private List<Suspect> suspectCards;
    /**
     * List of all vehicle cards
     */
    private List<Vehicle> vehicleCards;
    /**
     * List of all destination cards
     */
    private List<Destination> destinationCards;
    private Solution result;
    
    private ActionEvent reset;
    private ActionEvent cancel;
    private ActionEvent confirm;
    
    /**
     * Creates an instance of this controller class.
     * @param parent the GameState
     * @param aDialog the SnoopOnMeDialog
     */
    public void setup(I_Accusation aDialog, GameState parent)
    {
        this.dialog = aDialog;
        suspectCards = parent.getTable().getTheme().getSuspects();
        vehicleCards = parent.getTable().getTheme().getVehicles();
        destinationCards = parent.getTable().getTheme().getDestinations();
        state = parent;
        result = null;
        
        reset = new ActionEvent(this, 0, "reset");
        cancel = new ActionEvent(this, 0, "cancel");
        confirm = new ActionEvent(this, 0, "ok");
    }

    /**
     * The actions performed but the JButtons from the SuggestionDialog class.
     * 
     * @param event the certain action event
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String buttonName = event.getActionCommand();
        
        // check if ok button
        if (buttonName.equals("ok"))
        {
            // check if the button is clickable
            if (completeSolutionChosen())
            {
                Solution accusation = new Solution(suspectChosen, 
                        vehicleChosen, destinationChosen);
                result = accusation;
                dialog.getOKButton().setEnabled(false);
                dialog.dispose();
            }
        }
        // check if reset button
        else if (buttonName.equals("reset"))
        {
            helperResetAction();
        }
        // if cancel
        else if (buttonName.equals("cancel"))
        {
            dialog.dispose();
        }
        else
        {
            int num = 0;
            num = Character.getNumericValue(
                    (buttonName.charAt(buttonName.length() - 1)));

            // check if the ok button was pressed
            switch (buttonName.substring(0, buttonName.length()-1))
            {
                case "suspect":
                    selectButton(0, num);
                    break;
                case "vehicle":
                    selectButton(1, num);
                    break;
                case "destination":
                    selectButton(2, num);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void helperResetAction()
    {
        // reset suspect buttons
        for (int button = 1; button <= kNumSuspectButtons; button++)
        {
            dialog.getSuspectButton(button).setEnabled(true);
        }
        // reset vehicle buttons
        for (int button = 1; button <= kNumVehicleButtons; button++)
        {
            dialog.getVehicleButton(button).setEnabled(true);
        }
        // reset destination buttons
        for (int button = 1; button <= kNumDestinationButtons; button++)
        {
            dialog.getDestinationButton(button).setEnabled(true);
        }
        resetChoices();
        dialog.getOKButton().setEnabled(false);
    }
    /**
     * Selects the appropriate button.
     * 
     * @param buttonType 0 for suspects, 1 for vehicles, 2 for destinations
     * @param button the button number starting from the left at 1
     */
    private void selectButton(int buttonType, int button)
    {
        // determine which button to select
        switch (buttonType)
        {
            case 0:
                setChosenSuspect(button);
                disableButtonTypes(buttonType);
                dialog.getSuspectButton(button).setEnabled(true);
                break;
            case 1:
                setChosenVehicle(button);
                disableButtonTypes(buttonType);
                dialog.getVehicleButton(button).setEnabled(true);
                break;
            case 2:
                setChosenDestination(button);
                disableButtonTypes(buttonType);
                dialog.getDestinationButton(button).setEnabled(true);
                break;
            default:
                break;
        }
        
        // set ok to be clickable if all fields chosen        
        if (completeSolutionChosen())
        {
            dialog.getOKButton().setEnabled(true);
        }
    }
    
    private void disableButtonTypes(int buttonType)
    {
        // figure out which button types are they
        switch (buttonType)
        {
            case 0:
                // disable all suspect buttons
                for (int suspect = 1; suspect <= kNumSuspectButtons; 
                        suspect++)
                {
                    dialog.getSuspectButton(suspect).setEnabled(false);
                }
                break;
            case 1:
                // disable all vehicle buttons
                for (int vehilce = 1; vehilce <= kNumVehicleButtons; 
                        vehilce++)
                {
                    dialog.getVehicleButton(vehilce).setEnabled(false);
                }
                break;
            case 2:
                // disable all destination buttons
                for (int destination = 1; destination <= kNumDestinationButtons; 
                        destination++)
                {
                    dialog.getDestinationButton(destination).setEnabled(false);
                }
                break;
            default:
                break;
        }
    }
    
    /**
     * Returns the information of the suggestion made
     * @return a SuggestionCardLogic for the engine to use
     */
    public Solution showDialog() 
    {
        return result;
    }
    
    /**
     * Sets the suspect chosen at the given index starting from 1 from the left.
     * 
     * @param suspect the button number, not the index number, 
     * starting from the left at 1
     */
    private void setChosenSuspect(int suspect)
    {
        suspectChosen = suspectCards.get(suspect-1);
    }
    
    /**
     * Sets the vehicle chosen at the given index starting from 1 from the left.
     * 
     * @param vehicle the button number, not the index number, 
     * starting from the left at 1
     */
    private void setChosenVehicle(int vehicle)
    {
        vehicleChosen = vehicleCards.get(vehicle-1);
    }
    
    /**
     * Sets the destination chosen at the given index starting from 1 from the left.
     * 
     * @param destination the button number, not the index number, 
     * starting from the left at 1
     */
    private void setChosenDestination(int destination)
    {
        destinationChosen = destinationCards.get(destination-1);
    }
    
    /**
     * Resets the chosen solution.
     */
    private void resetChoices()
    {
        suspectChosen = null;
        vehicleChosen = null;
        destinationChosen = null;
    }
    
    /**
     * Determine if the appropriate fields are chosen and this dialog is ready
     * to dispose.
     * 
     * @return true if this dialog is ready to dispose
     */
    public boolean completeSolutionChosen()
    {
        return (move && destinationChosen !=null) || 
            ((!move) && suspectChosen != null && vehicleChosen != null);
    }

    /**
     * If key typed
     * @param e the key
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * If key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if R
        if(e.getKeyCode() == KeyEvent.VK_C)
        {
            this.actionPerformed(reset);
            
        }
        //if C
        else if (e.getKeyCode() == KeyEvent.VK_Z)
        {
            this.actionPerformed(cancel);
        }
        // if space
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(confirm);
        }
        // none of the above
        else
        {
            helperKeyPressedSuspect(e);
        }
    }

    private void helperKeyPressedSuspect(KeyEvent e)
    {
        String button = "suspect";
        // 1
        if(e.getKeyCode() == KeyEvent.VK_1)
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_2)
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_3)
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else if (e.getKeyCode() == KeyEvent.VK_4)
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_5)
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 6
        else if (e.getKeyCode() == KeyEvent.VK_6)
        {
            button+= "6";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // not suspect
        else
        {
            helperKeyPressedVehicle(e);
        }
    }
    
    private void helperKeyPressedVehicle(KeyEvent e)
    {
        String button = "vehicle";
        // 1
        if(e.getKeyCode() == KeyEvent.VK_Q)
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_W)
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_E)
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else if (e.getKeyCode() == KeyEvent.VK_R)
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_T)
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 6
        else if (e.getKeyCode() == KeyEvent.VK_Y)
        {
            button+= "6";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // not suspect
        else
        {
            helperKeyPressedDestination(e);
        }
    }
    
    private void helperKeyPressedDestination(KeyEvent e)
    {
        String button = "destination";
        // 1
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_D)
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else if (e.getKeyCode() == KeyEvent.VK_F)
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_G)
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 6
        else if (e.getKeyCode() == KeyEvent.VK_H)
        {
            button+= "6";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 7
        else if (e.getKeyCode() == KeyEvent.VK_J)
        {
            button+= "7";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 8
        else if (e.getKeyCode() == KeyEvent.VK_K)
        {
            button+= "8";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 9
        else if (e.getKeyCode() == KeyEvent.VK_L)
        {
            button+= "9";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // no valid button
    }
    /**
     * If key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
