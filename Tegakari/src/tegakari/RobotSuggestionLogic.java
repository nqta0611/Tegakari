
package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will compute all logic of playing suggestion
 * in different level of intelligent, it also calculate the
 * benefit of playing suggestion, so that the robot can 
 * decide to play this action or not.
 * 
 * @author Tarrant Starck
 * @author anhnguyen
 * @version 2.0
 *       1/12/2016 proposed skeleton.
 */
public class RobotSuggestionLogic implements Serializable
{
    /**
     * the level of intelligent of this robot,
     * ranging from 1 to 3, as 3 is smartest. 
     */
    private int intelligentLevel;
    
    /**
     * The self player to use with the given Notepad
     */
    private Player self;
    
    /**
     * The Notepad to use in order to make decisions
     */
    private Notepad note;
    
    /**
     * Constructor, since every method will use the Notepad and need
     * the self player to use the Notepad.
     * @param note the Notepad to use
     * @param self the player to use with the Notepad
     */
    public RobotSuggestionLogic(Notepad note, Player self) 
    {
        this.note = note;
        this.self = self;
    }
    /**
     * Responds to the Suggestion Action Card played by another 
     * <code>Player</code> or <code>Robot</code>, determining which
     * <code>ClueCard</code> to disprove, or update the destination.
     * @param logic The represented <code>SuggestionCard</code>
     * @param turn The player that played the <code>SuggestionCard</code>
     * @param level determine how smart this robot is. 
     * @return <code>ClueCard</code> responding to the 
     *         <code>SuggestionCard</code>
     *         if none found return null
     */
    public List<ClueCard> responseToActionRequest(SuggestionCardLogic logic, 
            Player turn, AILevel level) 
    {
        // CALL logic's isDisprovable
        //boolean check = logic.isDisprovable(null);
        // Initialize OUT as a new List of Clue Cards to NULL
        List<ClueCard> out = null;
        
        List<ClueCard> disproveList = logic.disprove(self);
        
        // IF Disprovable
        if (disproveList != null && disproveList.size() > 0) 
        { 
            out = new ArrayList<ClueCard>();
            // IF intelligentLevel == AILevel.BASIC (level 1)
            if (level == AILevel.BASIC) 
            {
                // DON't USE NOTEPAD
                // OUT == first card in Disprove list
                out.add(disproveList.get(0));
            // END IF
            }
            // IF intelligentLevel == AILevel.SMART (level 2)
            else 
            {
                // USE NOTEPAD
                // IF list size > 1
                if (disproveList.size() > 1) 
                {
                    // COMPARE cards in Disprove with NOTEPAD
                    ClueCard shown = null;
                    // goes through the disprove list
                    for(ClueCard clue: disproveList) 
                    {
                        // checking for cards not shown to Player turn
                        if (NoteEntry.SHOWN == note.getEntry(clue, turn)) 
                        {
                            shown = clue;
                        }
                    }
                    // IF card already shown to Player turn
                    if (shown != null) 
                    {
                        // OUT == card already shown in Disproves list
                        out.add(shown);
                    // END IF
                    }
                    // ELSE no cards already shown
                    else 
                    {
                        shown = disproveList.get(0);
                        // OUT == first card in Disprove list
                        out.add(shown);
                        // mark shown card as shown
                        note.mark(shown, turn, NoteEntry.SHOWN);
                    // END ELSE
                    }
                // END IF
                }
                // ELSE
                else 
                {
                    // OUT == first card in Disprove list
                    out.add(disproveList.get(0));
                // END ELSE
                }
            // END IF
            }
        // END IF
        }
        // RETURN OUT
        return out;
    }
    
    /**
     * Pre-calculate the benefit of playing an specific <code>ActionCard</code>
     * so that the <code>Robot</code> can decide which <code>ActionCard</code>
     * is going to be played. 
     * @param action is the <code>ActionCard</code> that <code>Robot</code>
     *        want to calculate the benefit from playing it.
     * 
     * @return the beneficial amount of playing an <code>ActionCard</code> 
     *         the return value is ranging from 0 to 5 as 0 means no benefit,
     *         and 5 means the <code>Robot</code> can gain a lot of benefit.
     *         The return value also depend on how smart the <code>Robot</code>
     *         is. if the <code>Robot</code> had intelligent level 1, than this
     *         method should always return 0 because this <code>Robot</code> 
     *         isn't smart enough to calculate the benefit of playing an 
     *         <code>ActionCard</code>
     */
    public int benefitFromAction(ActionCard action) 
    {
        // INITIALIZE OUT to 0
        int out = 0;
        
        //List<SuspectCard> su = note.getSuspects();
        
        List<ClueCard> suspects = new ArrayList<ClueCard>(note.getSuspects());
        List<ClueCard> vehicles = new ArrayList<ClueCard>(note.getVehicles());
        List<ClueCard> destinations = new ArrayList<ClueCard>(note.getDestinations());
        
        int unknownSuspects = 0;
                //(findUnknown(note, s, self).size() > 0) ? 1 : 0;
        if (findUnknown(note, suspects, self).size() > 0)
        {
            unknownSuspects = 1;
        }
        int unknownVehicles = 0;
                //(findUnknown(note, v, self).size() > 0) ? 1 : 0;
        if (findUnknown(note, vehicles, self).size() > 0)
        {
            unknownVehicles = 1;
        }
        int unknownDestinations = 0;
        //(findUnknown(note, d, self).size() > 0) ? 1 : 0;
        if (findUnknown(note, destinations, self).size() > 0)
        {
            unknownDestinations = 1;
        }
        
        int totalUnknown = unknownSuspects + unknownVehicles + unknownDestinations;
        // IF NOTEPAD has 1 suspect, 1 vehicle, 1 destination not seen
        if (totalUnknown == 3) 
        {
            // OUT == 3
            out = 3;
        // END IF
        }
        // ELSE IF NOTEPAD has 2/3 not seen
        else if (totalUnknown == 2) 
        {
            // OUT == 2
            out = 2;
        // END ELSE IF
        }
        // ELSE IF NOTEPAD has 1/3 not seen
        else if(totalUnknown == 1) 
        {
            // OUT == 1
            out = 1;
        // END ELSE IF
        }
        
        SuggestionCard suggestion = (SuggestionCard) action;
        // IF action == SUGGESTION CURRENT DESTINATION
        if (suggestion.isCurrentSuggestion()) 
        {
            // OUT-- if > 0
            //out = (out > 0) ? out-- : out;
            if (out > 0) 
            {
                out--;
            }
        // END IF
        }
        // RETURN OUT
        return out;
    }
    
    /**
     * Determines the best possible suggestion to make based on the 
     * <code>Notepad</code> that the <code>Robot</code> has.
     * @return The <code>Solution</code> to Suggest.
     */
    public SuggestionCardLogic playSuggestion() 
    {
        // SOLUTION is the solution for SuggestionCardLogic
        SuggestionCardLogic out;
        Solution solution;
        SuspectCard suspect = null;
        VehicleCard vehicle = null;
        DestinationCard destination = null;
       /* 
        List<SuspectCard> s = note.getSuspects();
        List<VehicleCard> v = note.getVehicles();
        List<DestinationCard> d = note.getDestinations();
        */
        List<ClueCard> susp = new ArrayList<ClueCard>(note.getSuspects());
        List<ClueCard> vehi = new ArrayList<ClueCard>(note.getVehicles());
        List<ClueCard> dest = new ArrayList<ClueCard>(note.getDestinations());
        
        List<ClueCard> suspects = findUnknown(note, susp, self);
        List<ClueCard> vehicles = findUnknown(note, vehi, self);
        List<ClueCard> destinations = findUnknown(note, dest, self);
        
        // CHECK the notepad for the first suspect card that isn't known
        if (suspects.size() > 0) 
        { 
            // ADD that suspect card to SOLUTION
            suspect = (SuspectCard)suspects.get(0);
        }
        // ELSE
        else 
        {
            // ADD First Suspect on Notepad 
            suspect = note.getSuspects().get(0);
        }
        // CHECK the notepad for the first vehicle card that isn't known
        if (vehicles.size() > 0) 
        {
            // ADD that vehicle card to SOLUTION
            vehicle = (VehicleCard)vehicles.get(0);
        }
        else 
        {
        // ELSE ADD First Vehicle on Notepad
            vehicle = note.getVehicles().get(0);
        }
        // CHECK the notepad for the first destination card that isn't known
        if (destinations.size() > 0)
        {
            // ADD that destination card to SOLUTION
            destination = (DestinationCard)destinations.get(0);
        }
        else
        {
        // ELSE ADD First Destination on Notepad
            destination = note.getDestinations().get(0);
        }
        solution = new Solution(suspect.getSuspect(), vehicle.getVehicle(),
                                destination.getDestination());
        
        // CREATE OUT, the SuggestionCardLogic to return
        SuggestionCard suggestion = new SuggestionCard(false, "path");
        out = new SuggestionCardLogic(suggestion, self, null, solution);
        // RETURN OUT
        return out;
    }
    
    /**
     * Determines the best destination to move to if the robot needs to as it 
     * knows everything but the destination.
     * @return the <code>Destination</code> where <code>Robot</code> want to move to.
     */
    public Destination playMove() 
    {
        // INITIALIZE OUT == First Destination on Notepad
        Destination out = note.getDestinations().get(0).getDestination();
        List<ClueCard> dest = new ArrayList<ClueCard>(note.getDestinations());
        // CHECK the notepad for the first destination card that isn't known
        List<ClueCard> unknown = findUnknown(note, dest, self);
        // if there is more than one unknown destinations
        if (unknown.size() > 0) 
        {
            // OUT == destination that isn't known
            DestinationCard get = (DestinationCard)unknown.get(0);
            out = (Destination)get.getDestination();
        }
        // RETURN OUT
        return out;
    }
    
    /**
     * Takes in a list of Clue Cards and finds which ones are not known 
     * according to the Notepad given
     * @param note the Notepad of the robot
     * @param list the list of ClueCards
     * @param p the player to check against
     * @return list of unknown ClueCards according to notepad
     */
    public static List<ClueCard> findUnknown(Notepad note, 
            List<ClueCard> list, Player p) 
    {
        List<ClueCard> out = new ArrayList<ClueCard>();
        
        // FOR all items in list
        for (ClueCard clue: list) 
        {
            // element = note.getEntry(item, p);
            NoteEntry  element = note.getEntry(clue, p);
            // IF element == NoteEntry.BLANK
            if (element == NoteEntry.BLANK) 
            {
                // add element to out
                out.add(clue);
            }
            // END IF
        }
        // END FOR
        
        return out;
    }
}
