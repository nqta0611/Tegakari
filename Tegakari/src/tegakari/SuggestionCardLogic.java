package tegakari;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
/**
 * The SuggestionCardLogic represents the necessary actions each
 * <code>SuggestionCard</code> must simulate.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 11/4/2015 - Write java doc
 * @version 11/11/2015 - Implement code
 * @version 11/17/2015 - Adding method disprove
 */
public class SuggestionCardLogic extends ActionCardLogic 
{

    private Player disprover;
    /**
     * the turnPlayer's guess for the Solution
     */ 
    private Solution guess;
    /**
     * the turnPlayer's desired destination
     */ 
    private Destination destination;
    /**
     * the turnPlayer want to move instead of making suggestion
     */
    private boolean moved;
    /**
     * Constructs the
     * <code>SuggestionCardLogic</code> instance meant to store
     * desired destination or guess
     *
     * @param card the represented <code>SuggestionCard</code>
     * @param turnPlayer the <code>Player</code> that played
     * the <code>SuggestionCard</code>
     * @param destination the <code>Destination</code> the turnPlayer wants to
     * switch to on the <code>Table</code>
     * @param guess is the set of <code>Suspect</code>, <code>Vehicle</code>,
     *  <code>Destination</code> which user suggest.
     */
    public SuggestionCardLogic(SuggestionCard card, 
        Player turnPlayer, Destination destination, Solution guess) 
    {
        // SET card
        // SET turn player
        super(card, turnPlayer);
        // SET destination
        this.destination = destination;
        this.guess = guess;
        // Check if this is a move or suggest
        if (destination == null)
        {
            moved = false;
        }
        else
        {
            moved = true;
        }    
    }

    /**
     * Swaps the turnPlayer's
     * <code>Destination</code> with the received
     * <code>Player</code>'s
     * <code>Destination</code>.
     * @param turn is the turn player
     * @param other player to swap dm with
     */
    public void swapDMWithPlayer(Player turn, Player other)
    {
        SuggestionCard card = (SuggestionCard)(super.getActionCard());
        //IF this Suggestion card is current suggestion card
        if (card.isCurrentSuggestion()) 
        {
            //GET the destination of Player received and store in temp
            Destination desiredDest = other.getDestination();
            //SET Player received destination with turnPlayer's destination
            other.setDestination(turn.getDestination());
            //SET turnPlayer's destination with temp
            turn.setDestination(desiredDest);
        }
        //ENDIF
    }

    /**
     * Check if other <code>Player</code> can disprove the turnPlayer.
     * Also set that <code>Player</code> to disprover.
     *
     * @param playersQ is the <code>Queue</code> of players
     * @return a boolean indicate if anyone can disprove me
     */
    public boolean isDisprovable(Queue<Player> playersQ) 
    {
        List<Player> players = new ArrayList<Player>(playersQ);
        // FOR each players in the queue, except self
        for (Player player : players) 
        {
            // Check for turn player
            if (!(player.equals(super.getTurnPlayer()))) 
            {
                List<ClueCard> clues = player.getClueCards();
                //System.out.println("\t who has " + clues.size() + " Clue Card");
                // FOR each clue card
                for(ClueCard clue : clues)
                {
                    //System.out.println("Clue 1: " + clue.getImagePath());
                    // IF the guess containing the cluecard
                    if ((clue instanceof SuspectCard && 
                        ((SuspectCard)clue).getSuspect().equals(guess.getSuspect())) ||
                        (clue instanceof VehicleCard && 
                        ((VehicleCard)clue).getVehicle().equals(guess.getVehicle())) ||
                        (clue instanceof DestinationCard && 
                        ((DestinationCard)clue).getDestination().equals(
                            guess.getDestination()))) 
                    {
                        disprover = player;
                        // RETURN true
                        return true;
                    }
                    // END IF
                }
            }
            // END FOR
        }
        // RETURN true means this guess is not disprovable
        return false;
    }
    /**
     * Get the list of Clue card on a player's hand which can be use to disprove
     * @param disprove is the player who will disprove the suggestion
     * @return  the list of card use to disprove
     */
    public List<ClueCard> disprove(Player disprove) 
    {
        List<ClueCard> disproveCards = new ArrayList<ClueCard>();
        // GET the list of clue card from disprove's hand
        List<ClueCard> clues = disprove.getClueCards();
        // FOR each clue card
        for(ClueCard clue : clues) 
        {
            // IF the guess containing the cluecard
            if ((clue instanceof SuspectCard && 
                ((SuspectCard)clue).getSuspect().equals(guess.getSuspect())) ||
                (clue instanceof VehicleCard && 
                ((VehicleCard)clue).getVehicle().equals(guess.getVehicle())) ||
                (clue instanceof DestinationCard && 
                ((DestinationCard)clue).getDestination().equals(
                    guess.getDestination()))) 
            {
                // add to the returnList
                disproveCards.add(clue);
            }
            // END IF
            System.out.println();
        }
        return disproveCards;
    }

    /**
     * Retrieve the disprover
     * @return the disprover
     */
    public Player getDisprover() 
    {
        return disprover;
    }
    
    
    /**
     * Swaps the turnPlayer's <code>Destination</code> with the desired
     * <code>Destination</code> from the receiving
     * <code>Player</code>'s
     * <code>Table</code>.
     *
     * @param table the receiving <code>Player</code>'s <code>Table</code>
     * of <code>Player</code>s.
     * @param turn is the turn player
     */
    public void swapDMWithTable(Table table, Player turn) 
    {
        // CALL exchangeDM in Table with turnPlayer and destination
        table.exchangeDM(turn, destination);
    }

    /**
     * Retrieves the turnPlayer's guess.
     *
     * @return the proposed <code>Solution</code>
     */
    public Solution getGuess() 
    {
        //RETURN guess
        return guess;
    }
    /**
     * Retrieves the turnPlayer's decision of move or suggest.
     *
     * @return true when turnPlayer move, false when turn player suggest
     */
    public boolean isMoved() 
    {
        return moved;
    }

    /**
     * Retrieves the desired
     * <code>Destination</code> the turnPlayer wants to be at.
     *
     * @return the desired <code>Destination</code>
     */
    public Destination getDestination() 
    {
        //RETURN destination
        return destination;
    }
}
