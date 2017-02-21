package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import tegakari.ClueCard;
import tegakari.*;

/**
 * The controller for disprove
 * @author DeionLaw
 */
public class DisproveController implements ActionListener, KeyListener
{
    private I_Disprove view;
    private ClueCard result;
    private ActionEvent reset;
    private ActionEvent confirm;
    private ActionEvent suspect;
    private ActionEvent vehicle;
    private ActionEvent destination;
    
    private SuggestionCardLogic logic;
    /**
     * True if player is able to disprove the suspect
     */
    private boolean hasSuspect = false;
    /**
     * True if player is able to disprove the vehicle
     */
    private boolean hasVehicle = false;
    /**
     * True if player is able to disprove the destination
     */
    private boolean hasDestination = false;
    
    /**
     * Sets up the controller
     * @param aView the view
     * @param aLogic the logic to use
     * @param list the list of cards
     */
    public void setup(I_Disprove aView, SuggestionCardLogic aLogic, List<ClueCard> list)
    {
        this.view = aView;
        this.result = list.get(0);
        this.logic = aLogic;
        this.confirm = new ActionEvent(this, 0, "confirmButton");
        this.reset = new ActionEvent(this, 0, "resetButton");
        this.suspect = new ActionEvent(this, 0, "suspectButton");
        this.vehicle = new ActionEvent(this, 0, "vehicleButton");
        this.destination = new ActionEvent(this, 0, "DestinationButton");
        // for all cards in list
        for (ClueCard card : list)
        {
            //System.out.print("Card: " + card.getName());
            if (card instanceof SuspectCard)
            {
                //System.out.println(" is Suspect: " + card.getImagePath());
                hasSuspect = true;
            }
            // if vehicle card
            else if (card instanceof VehicleCard)
            {
                hasVehicle = true;
                //System.out.println(" is Vehicle: " + card.getImagePath());
            }
            // if destination card
            else if (card instanceof DestinationCard)
            {
                hasDestination = true;
                //System.out.println(" is Destination: " + card.getImagePath());
            }
        }
    }
    /**
     * action performed
     * @param event the action
     */
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        // if suspect button
        if(cmd.equals("suspectButton"))
        {
            view.setEnabled("vehicle", false);
            view.setEnabled("destination", false);
            result = new SuspectCard(this.logic.getGuess().getSuspect());
            view.setEnabled("ok", true);
        }
        // if vehicle button
        else if (cmd.equals("vehicleButton"))
        {
            view.setEnabled("suspect", false);
            view.setEnabled("destination", false);
            result = new VehicleCard(this.logic.getGuess().getVehicle());
            view.setEnabled("ok", true);
        }
        // if destination button
        else if (cmd.equals("DestinationButton"))
        {
            view.setEnabled("vehicle", false);
            view.setEnabled("suspect", false);
            result = new DestinationCard(this.logic.getGuess().getDestination());
            view.setEnabled("ok", true);
        }
        // if reset button
        else if (cmd.equals("resetButton"))
        {
            view.setEnabled("suspect", hasSuspect);
            view.setEnabled("destination", hasDestination);
            view.setEnabled("vehicle", hasVehicle);
            result = null;
            view.setEnabled("ok", false);
        }
        else
        {
            view.dispose();
        }
    }
    /**
     * Shows the dialog
     * @return the clue card
     */
    public ClueCard showDialog()
    {
        // if null
        return result;
    }

    /**
     * key typed
     * @param e the key
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if r
        if(e.getKeyCode() == KeyEvent.VK_R)
        {
            this.actionPerformed(reset);
        }
        // if space
        else if (e.getKeyCode() == KeyEvent.VK_SPACE && result != null)
        {
            this.actionPerformed(confirm);
        }
        // if s
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            this.actionPerformed(suspect);
        }
        // if d
        else if (e.getKeyCode() == KeyEvent.VK_D)
        {
            this.actionPerformed(destination);
        }
        //if v
        else if (e.getKeyCode() == KeyEvent.VK_V)
        {
            this.actionPerformed(vehicle);
        }
    }

    /**
     * key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
    
    /**
     * Returns the logic to print out the suggestion to disprove 
     * for console
     */
    public void getSuggestion()
    {
        System.out.println(logic.getTurnPlayer().getName() + "played this suggestion");
        System.out.println(logic.getGuess().toString());
    }
}
