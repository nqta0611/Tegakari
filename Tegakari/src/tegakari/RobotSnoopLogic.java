package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This class will compute all logic of playing snoop
 * in different levels of intelligence. It also calculates the
 * benefit of playing the snoop, so that the robot can 
 * decide to play this action or not.
 * 
 * @author Jonathan Molina
 * @version 2.0
 *       1/12/2016 proposed skeleton.
 */
public class RobotSnoopLogic implements RobotActionLogic, Serializable
{
    /**
     * the level of intelligent of this robot,
     * ranging from 1 to 3, as 3 is smartest.   
     */
    private int intelligentLevel;
    /**
     * the player corresponding to the returned benefit integer for snoop
     */
    private Player targetPlayerForSnoop;
    
    /**
     * Responds to the snoop action (all snoop) played by the turn <code>Player</code>,
     * This Robot will perform the snoop action on the next player on the queue. 
     * @param action the snoop action card that has been played
     * @param note the notepad for keeping track of suspects, vehicles, and destinations
     * @param turn the target player for this robot to snoop on.
     * @param self the self Robot player
     * @param level determine how smart this robot is. 
     * @return a list of <code>ClueCard</code> responding to the <code>SnoopCard</code>
     *      return null if nothing to respond
     */
    @Override
    public List<ClueCard> responseToActionRequest(ActionCard action, Notepad note, 
        Player turn, Player self, AILevel level)
    {
        // OBTAIN random clue card from turn player
        Random gen = new Random();
        int ndx = gen.nextInt(turn.getClueCards().size());
        List<ClueCard> cards = new ArrayList<ClueCard>();
        ClueCard card = turn.getClueCards().get(ndx);

        // MARK the cell to HAS for the clue card into the notepad
        note.mark(card, turn, NoteEntry.HAS);
        // MARK the other player's cell to NOT_HAS
        for (Player player : note.getPlayers())
        {
            // check if a different player
            if (!player.equals(turn))
            {
                note.mark(card, player, NoteEntry.HASNOT);
            }
        }
        // RETURN the clue card chosen inside a List<ClueCard>
        cards.add(card);
        return cards;
    }
    
    private void obtainKnownCards(Notepad note, Map<Player, List<ClueCard>> knownCards)
    {
        // OBTAIN list of known cards from each player column in notepad
        for (Player player : note.getPlayers())
        {
            knownCards.put(player, new ArrayList<ClueCard>());
            // LOOK for matching suspects
            for (SuspectCard suspect : note.getSuspects())
            {
                // CHECK if they have it
                if (note.getEntry(suspect, player) == NoteEntry.HAS)
                {
                    knownCards.get(player).add(suspect);
                }
            }
            // LOOK for matching vehicles
            for (VehicleCard vehicle : note.getVehicles())
            {
                // CHECK if they have it
                if (note.getEntry(vehicle, player) == NoteEntry.HAS)
                {
                    knownCards.get(player).add(vehicle);
                }
            }
            // LOOK for matching destinations
            for (DestinationCard destination : note.getDestinations())
            {
                // CHECK if they have it
                if (note.getEntry(destination, player) == NoteEntry.HAS)
                {
                    knownCards.get(player).add(destination);
                }
            }
        }
    }
    
    private int calcBenefit(double percentKnown)
    {
        // IF 0 <= percentKnown at index <= 20%
        if (0 <= percentKnown && percentKnown <= 0.20)
        {
            return 5;
        }
        // ELSE 20 < percentKnown at index <= 40%
        else if (0.2 < percentKnown && percentKnown <= 0.40)
        {
            return 4;
        }
        // ELSE 40 < percentKnown at index <= 60%
        else if (0.4 < percentKnown && percentKnown <= 0.60)
        {
            return 3;
        }
        // ELSE 60 < percentKnown at index <= 80%
        else if (0.6 < percentKnown && percentKnown <= 0.80)
        {
            return 2;
        }
        // ELSE 80 < percentKnown at index <= 100%
        else
        {
            return 1;
        }
    }
    
    private void determineAllSnoopTarget(SnoopCard snoopCard, Notepad note)
    {
        // SET targetPlayerForSnoop = right or left player according
        if (snoopCard.getDirection() == Direction.LEFT)
        {
            targetPlayerForSnoop = note.getPlayers().get(0);
        }
        else
        {
            targetPlayerForSnoop = note.getPlayers().get(
                    note.getPlayers().size() - 1);
        }
    }
    
    /**
     * Pre-calculate the benefit of playing an specific <code>ActionCard</code>
     * so that the <code>Robot</code> can decide which <code>ActionCard</code>
     * is going to be played. 
     * @param note is the <code>Notepad</code> of this <code>Robot</code>.
     * @param action is the <code>ActionCard</code> that <code>Robot</code>
     *        want to calculate the benefit from playing it.
     * 
     * @return the beneficial amount of playing an <code>ActionCard</code> 
     *         the return value is ranging from 1 to 5 as 1 means no benefit,
     *         and 5 means the <code>Robot</code> can gain a lot of benefit.
     *         The return value also depend on how smart the <code>Robot</code>
     *         is. if the <code>Robot</code> had intelligent level 1, than this
     *         method should always return 1 because this <code>Robot</code> 
     *         isn't smart enough to calculate the benefit of playing an 
     *         <code>ActionCard</code>
     */
    @Override
    public int benefitFromAction(Notepad note, ActionCard action)
    {
        // IF action is not a snoop card
        if (!(action instanceof SnoopCard))
        {
            return -1;
        }

        SnoopCard snoopCard = (SnoopCard) action;
        Map<Player, List<ClueCard>> knownCards = 
                new HashMap<Player, List<ClueCard>>();
        obtainKnownCards(note, knownCards);
        double knownPercent = 0;

        // IF action is regular snoop
        if (!snoopCard.isAllSnoop())
        {

            List<Integer> totalCards = new ArrayList<Integer>();
            // OBTAIN list of total clue cards from each players' hands
            for (Player player : note.getPlayers())
            {
                totalCards.add(player.getHand().getClueCardTotal());
            }
            // CREATE percentKnownList of the percentage of
            // knowledge of other player's hands
            List<Double> percentKnownList = new ArrayList<Double>();

            // FOR EACH player
            for (int ndx = 0; ndx < totalCards.size(); ndx++)
            {
                // CALCULATE the percent and add to percentKnownList
                percentKnownList.add(((double) knownCards
                        .get(note.getPlayers().get(ndx)).size())
                        / ((double) totalCards.get(ndx)));
            }

            int maxIndex = 0;
            // OBTAIN index = highest percentKnown in percentKnownList
            for (int ndx = 1; ndx < percentKnownList.size(); ndx++)
            {
                // compare current percent to max percent
                if (percentKnownList.get(ndx) > percentKnownList.get(maxIndex))
                {
                    maxIndex = ndx;
                }
            }
            // SET targetPlayerForSnoop to be the player at index
            targetPlayerForSnoop = note.getPlayers().get(maxIndex);
            knownPercent = percentKnownList.get(maxIndex);
        }
        else // HANDLE all snoop
        {
            determineAllSnoopTarget(snoopCard, note);
            // GET totalClueCards = player's hand size
            int totalClueCards = targetPlayerForSnoop.getHand().getClueCardTotal();
            // GET knownClueCards = number of cards known by that player
            int knownClueCards = knownCards.get(targetPlayerForSnoop).size();
            // GET percentKnown = knownClueCards / totalClueCards
            knownPercent = (double) knownClueCards / (double) totalClueCards;
        }
        return calcBenefit(knownPercent);
    }
    
    /**
     * Performs the snoop action and will return the <code>Player</code> to be
     * chosen. Must be called after benefitFromAction() is called.
     * 
     * @param note the notepad for keeping track of suspects, vehicles, and destinations
     * @param action the snoop action card
     * @return the <code>Player</code> to be snooped on
     */
    public Player chooseTargetPlayer(Notepad note, ActionCard action) 
    {
        benefitFromAction(note, action);
        return targetPlayerForSnoop;
    }
    
    /**
     * Play the <code>SnoopCard</code> on the target <code>Player</code>.
     * @param card the action card played
     * @param note The <code>Notepad</code> of the <code>Robot</code> player
     * @param target the target <code>Player</code> to snoop on.
     * @param self the robot player performing the snoop
     * @param level the AIlevel of the robot
     * @return the <code>ClueCard</code> revealed from playing snoop .
     */
    public ClueCard playSnoop(SnoopCard card, Notepad note, 
            Player target, Robot self, AILevel level) 
    {
        // OBTAIN random clue card from target player
        // MARK the appropriate value for the clue card into the notepad
        List<ClueCard> cards = target.getClueCards();
        // RETURN the clue card chosen
        
        Random gen = new Random();
        int ndx = gen.nextInt(target.getClueCards().size());
        return cards.get(ndx);
    }
}
