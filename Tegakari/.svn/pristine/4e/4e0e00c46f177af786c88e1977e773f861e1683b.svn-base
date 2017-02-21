package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.AbstractButton;
import tegakari.*;

/**
 * Controller class for SuggestionAndMoveDialogController.
 * 
 * @author Jonathan Molina
 */
public class SuggestionAndMoveDialogController implements ActionListener, 
        KeyListener
{
    /**
     * The view
     */
    private I_SuggestionAndMove dialog;
    private final int kNumSuspectButtons = 6;
    private final int kNumVehicleButtons = 6;
    private final int kNumDestinationButtons = 9;
    private ActionEvent ok;
    private ActionEvent reset;
    private ActionEvent moved;
    private ActionEvent suggest;
    
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
     * User's current destination
     */
    private Destination dm;
    /**
     * The played suggestion card
     */
    private SuggestionCard suggestionCard;
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
    
    private Player turnPlayer;

    /**
     * Creates an instance of this controller class.
     * 
     * @param view the SnoopOnMeDialog
     * @param theme selected theme of the game 
     * @param marker destination 
     * @param card the suggestion card played
     * @param player player whose turn it is
     */
    public void setup(I_SuggestionAndMove view, Theme theme, Destination marker, 
            SuggestionCard card, Player player)
    {
        this.dialog = view;
        suspectCards = theme.getSuspects();
        vehicleCards = theme.getVehicles();
        destinationCards = theme.getDestinations();
        this.dm = marker;
        this.suggestionCard = card;
        this.turnPlayer = player;
        
        this.ok = new ActionEvent(this, 0, "ok");
        this.reset = new ActionEvent(this, 0, "reset");
        this.moved = new ActionEvent(this, 0, "move");
        this.suggest = new ActionEvent(this, 0, "suggestion");
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

        // ok button
        if (buttonName.equals("ok"))
        {
            // validate appropriate fields have been set
            if (isReadyToDispose())
            {
                dialog.dispose();
            }
        }
        // reset button
        else if (buttonName.equals("reset"))
        {
            // reset change destination
            if (isMove() && dialog.getMoveRadioButton().isSelected())
            {
                selectMove();
            }
            // reset suggestion
            else if (!isMove() && dialog.getSuggestionRadioButton().isSelected())
            {
                selectSuggestion();
            }
            resetChoices();
            dialog.getOKButton().setEnabled(false);
        }
        // move selection
        else if (buttonName.equals("move"))
        {
            selectMove();
        }
        // suggestion selection
        else if (buttonName.equals("suggestion"))
        {
            selectSuggestion();
        }
        else
        {
            chooseButton(buttonName);
        }
    }
    
    private void selectMove()
    {
        setButtonTypes(0, false);
        setButtonTypes(1, false);
        setButtonTypes(2, true);
        dialog.getCurrDestination().setEnabled(false);
        dialog.getMoveRadioButton().setSelected(true);
        dialog.getSuggestionRadioButton().setSelected(false);
        setMove(true);
    }
    
    private void selectSuggestion()
    {
        setButtonTypes(0, true);
        setButtonTypes(1, true);
        setButtonTypes(2, false);
        dialog.getMoveRadioButton().setSelected(false);
        dialog.getSuggestionRadioButton().setSelected(true);
        setMove(false);
    }
    
    private void chooseButton(String buttonName)
    {
        int num = Character.getNumericValue(
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
                setButtonTypes(buttonType, false);
                dialog.getSuspectButton(button).setEnabled(true);
                break;
            case 1:
                setChosenVehicle(button);
                setButtonTypes(buttonType, false);
                dialog.getVehicleButton(button).setEnabled(true);
                break;
            case 2:
                setChosenDestination(button);
                setButtonTypes(buttonType, false);
                dialog.getDestinationButton(button).setEnabled(true);
                break;
            default:
                break;
        }
        // set ok to be clickable if all fields chosen        
        if (isReadyToDispose())
        {
            dialog.getOKButton().setEnabled(true);
        }
    }
    
    private void setButtonTypes(int buttonType, boolean visible)
    {
        // figure out which button types are they
        switch (buttonType)
        {
            case 0:
                // disable all suspect buttons
                for (int suspect = 1; suspect <= kNumSuspectButtons; 
                        suspect++)
                {
                    dialog.getSuspectButton(suspect).setEnabled(visible);
                }
                break;
            case 1:
                // disable all vehicle buttons
                for (int vehilce = 1; vehilce <= kNumVehicleButtons; 
                        vehilce++)
                {
                    dialog.getVehicleButton(vehilce).setEnabled(visible);
                }
                break;
            case 2:
                // disable all destination buttons
                for (int destination = 1; destination <= kNumDestinationButtons; 
                        destination++)
                {
                    dialog.getDestinationButton(destination).setEnabled(visible);
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
    public SuggestionCardLogic showDialog() 
    {
        //IF player selected move
        if (move) 
        {
            return new SuggestionCardLogic(
                    suggestionCard, turnPlayer, destinationChosen, null);
        }
        else 
        {
            return new SuggestionCardLogic(
                    suggestionCard, turnPlayer, 
                    null, new Solution(suspectChosen, vehicleChosen, dm));
        }
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
    private boolean isReadyToDispose()
    {
        return (move && destinationChosen !=null) || 
            ((!move) && suspectChosen != null && vehicleChosen != null);
    }
    
    /**
     * Returns true if moving to another destination and false if making
     * a suggestion.
     * 
     * @return true for relocating, false for suggestion
     */
    private boolean isMove()
    {
        return move;
    }
    
    /**
     * Sets whether the choice is to move to another destination or to make
     * a suggestion.
     * 
     * @param move true to move to another destination, or to make a suggestion
     */
    private void setMove(boolean move)
    {
        this.move = move;
    }
    
    /**
     * Determines if a suspect has been chosen.
     * 
     * @return true if chosen, false if not
     */
    private boolean hasChosenSuspect()
    {
        return suspectChosen != null;
    }
    
    /**
     * Determines if a vehicle has been chosen.
     * 
     * @return true if chosen, false if not
     */
    private boolean hasChosenVehicle()
    {
        return vehicleChosen != null;
    }
    
    /**
     * Determines if a destination has been chosen.
     * 
     * @return true if chosen, false if not
     */
    private boolean hasChosenDestination()
    {
        return destinationChosen != null;
    }

    /**
     * Can't remove this method as it is needed to implement keyListener
     * 
     * @param e keyEvent
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * Handles keyEvents to trigger ok, reset, moved, and suggestion actions.
     * 
     * @param e keyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        //if OK is selected
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(ok);
        }
        //if reset is selected
        else if (e.getKeyCode() == KeyEvent.VK_C)
        {
            this.actionPerformed(reset);
        }
        //if moved is selected
        else if (e.getKeyCode() == KeyEvent.VK_X)
        {
            this.actionPerformed(moved);
        }
        //if suggest is selected
        else if (e.getKeyCode() == KeyEvent.VK_Z)
        {
            this.actionPerformed(suggest);
        }
        else
        {
            helperKeyPressedSuspect(e);
        }
    }

    private void helperKeyPressedSuspect(KeyEvent e)
    {
        String button = "suspect";
        // 1
        if(e.getKeyCode() == KeyEvent.VK_1 && 
                dialog.getSuspectButton(1).isEnabled())
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_2 && 
                dialog.getSuspectButton(2).isEnabled())
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_3 && 
                dialog.getSuspectButton(3).isEnabled())
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else 
        {
            helperKeyPressedSuspectTwo(e);
        }
    }
    
    private void helperKeyPressedSuspectTwo(KeyEvent e)
    {
        String button = "suspect";
        
        // 4
        if (e.getKeyCode() == KeyEvent.VK_4 && 
                dialog.getSuspectButton(4).isEnabled())
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_5 && 
                dialog.getSuspectButton(5).isEnabled())
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 6
        else if (e.getKeyCode() == KeyEvent.VK_6 && 
                dialog.getSuspectButton(6).isEnabled())
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
        if(e.getKeyCode() == KeyEvent.VK_Q &&
                dialog.getVehicleButton(1).isEnabled())
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_W &&
                dialog.getVehicleButton(2).isEnabled())
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_E &&
                dialog.getVehicleButton(3).isEnabled())
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else 
        {
            helperKeyPressedVehicleTwo(e);
        }
    }
    
    private void helperKeyPressedVehicleTwo(KeyEvent e)
    {
        String button = "vehicle";
        // 4
        if (e.getKeyCode() == KeyEvent.VK_R &&
                dialog.getVehicleButton(4).isEnabled())
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_T &&
                dialog.getVehicleButton(5).isEnabled())
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 6
        else if (e.getKeyCode() == KeyEvent.VK_Y &&
                dialog.getVehicleButton(6).isEnabled())
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
        if(e.getKeyCode() == KeyEvent.VK_A && 
                dialog.getDestinationButton(1).isEnabled())
        {
            button+= "1";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 2
        else if (e.getKeyCode() == KeyEvent.VK_S && 
                dialog.getDestinationButton(2).isEnabled())
        {
            button+= "2";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 3
        else if (e.getKeyCode() == KeyEvent.VK_D && 
                dialog.getDestinationButton(3).isEnabled())
        {
            button+= "3";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 4
        else 
        {
            helperKeyPressedDestinationTwo(e);
        }
    }
    
    private void helperKeyPressedDestinationTwo(KeyEvent e)
    {
        String button = "destination";
        
        // 
        if (e.getKeyCode() == KeyEvent.VK_F && 
                dialog.getDestinationButton(4).isEnabled())
        {
            button+= "4";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 5
        else if (e.getKeyCode() == KeyEvent.VK_G && 
                dialog.getDestinationButton(5).isEnabled())
        {
            button+= "5";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        //6
        else if (e.getKeyCode() == KeyEvent.VK_H && 
                dialog.getDestinationButton(6).isEnabled())
        {
            button+= "6";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 7
        else 
        {
            helperKeyPressedDestinationThree(e);
        }
    }
    
    private void helperKeyPressedDestinationThree(KeyEvent e)
    {
        String button = "destination";
        // 7
        if (e.getKeyCode() == KeyEvent.VK_J && 
                dialog.getDestinationButton(7).isEnabled())
        {
            button+= "7";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 8
        else if (e.getKeyCode() == KeyEvent.VK_K && 
                dialog.getDestinationButton(8).isEnabled())
        {
            button+= "8";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // 9
        else if (e.getKeyCode() == KeyEvent.VK_L && 
                dialog.getDestinationButton(9).isEnabled())
        {
            button+= "9";
            this.actionPerformed(new ActionEvent(this, 0, button));
        }
        // no valid button
    }
    
    /**
     * Can't remove this method as it is needed to implement keyListener
     * 
     * @param e keyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
