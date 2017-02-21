package tegakari;

import java.util.Queue;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * The Notepad is a visual reference to a player to help
 * them keep track of the game and it's moves.  This class also stores
 * all the information inputted from the <code>NotePadDialogue</code>
 * 
 * @author Josh Choi - pseudocode
 * @author Josh Choi - implementation
 */
public class Notepad implements Serializable
{

    /**
     * a 2d array that represents cells in notepad.
     */
    private NoteEntry[][] notepad;
    /**
     * number of all players in the game.
     */
    private static int playerSize;
    /**
     * number of all possible clue cards in the <code>Theme</code>
     */
    private static int clueCardSize;
    /**
     * The <code>Queue</code> of <code>Players</code> currently in the game.
     */
    private List<Player> players;
    /**
     * The <code>Theme</code> that was set in the <code>Lobby</code> before
     * the game started.
     */
    private Solution solution;
    /**
     * All possible <code>Suspect</code> names given by the <code>Theme</code>.
     */
    private List<SuspectCard> suspects;
    /**
     * All possible <code>Vehicle</code> names given by the <code>Theme</code>.
     */
    private List<VehicleCard> vehicles;
    /**
     * All possible <code>Destination</code> names given by the 
     * <code>Theme</code>.
     */
    private List<DestinationCard> destinations;
    /**
     * Constructs the table that stores marks from player.
     * 
     * @param players Queue of players in the game
     * @param suspects List of suspects in the theme
     * @param vehicles List of vehicles in the theme
     * @param destinations List of destinations in the theme
     * @param solution The current solution in the game
     */
    public Notepad(Queue<Player> players, List<SuspectCard> suspects, 
            List<VehicleCard> vehicles, List<DestinationCard> destinations, 
            Solution solution) 
    {
        this.playerSize = players.size();
        this.clueCardSize = suspects.size() + vehicles.size() + destinations.size();
        // CREATE a 2 dimentional notepad using the number of players and cards
        notepad = new NoteEntry[this.playerSize][this.clueCardSize];
        // CREATE a 2 dimentional notepad using the number of players
        for (int fdex = 0; fdex < this.playerSize; fdex++)
        {
            // CREATE a 2 dimentional notepad using the number of players and cards
            for (int sdex = 0; sdex < this.clueCardSize; sdex++)
            {
                notepad[fdex][sdex] = NoteEntry.BLANK;
            }
        }
        this.solution = solution;
        this.players = new ArrayList(players);
        this.suspects = suspects;
        this.vehicles = vehicles;
        this.destinations = destinations;
    }
    
    private boolean findSuspect(int fdex, ClueCard clue, NoteEntry entry)
    {
        //FOR each suspect in themes
        for (int sdex = 0; sdex < suspects.size(); sdex++)
        {
            //IF CALL getSuspect of clue is equal to current suspect
            if (((SuspectCard)clue).getSuspect().equals(
                    suspects.get(sdex).getSuspect()))
            {
                //SET 2nd dimension of table of current array index
                notepad[fdex][sdex] = entry;
                //RETURN true
                return true;
            //ENDIF
            }
        //ENDFOR
        }
        return false;
    }
    
    private boolean findVehicle(int fdex, ClueCard clue, NoteEntry entry)
    {
        //FOR each vehicle in themes
        for (int sdex = 0; sdex < vehicles.size(); sdex++)
        {
            //IF CALL getVehicle of clue is equal to current vehicle
            if (((VehicleCard)clue).getVehicle().equals(
                    vehicles.get(sdex).getVehicle()))
            {
                //SET 2nd dimension of table of current array index
                notepad[fdex][sdex + suspects.size()] = entry;
                //RETURN true
                return true;
            //ENDIF
            }
        //ENDFOR
        }
        return false;
    }
    
    private boolean findDestination(int fdex, ClueCard clue, NoteEntry entry)
    {
        //FOR each destination in themes
        for (int sdex = 0; sdex < destinations.size(); sdex++)
        {
            //IF CALL getDestination of clue is equal to current
            if (((DestinationCard)clue).getDestination().equals(
                    destinations.get(sdex).getDestination()))
            {
                //SET 2nd dimension of table of current array index
                notepad[fdex][sdex + suspects.size() + vehicles.size()] = entry;
                //RETURN true
                return true;
            //ENDIF
            }
        //ENDFOR
        }
        return false;
    }
    
    /**
     * Marks down that a <code>ClueCard</code> was found from a 
     * <code>Player</code> and stores the information on this 
     * <code>Notepad</code>
     * 
     * @param clue The card that is to be marked down.
     * @param from Which player was marked down.
     * @param entry The NoteEntry to mark down for the notepad
     * @return true if the <code>ClueCard</code> was found and marked, false
     * otherwise.
     */
    public boolean mark(ClueCard clue, Player from, NoteEntry entry) 
    {
        //FOR each 1st dimension entry in table
        for (int fdex = 0; fdex < this.playerSize; fdex++)
        {
            //IF that entry contains the correct player name
            if (from.equalsName(players.get(fdex)))
            {
                //IF CALL getClueType with card is equal to suspect
                if (clue.getClueType() == ClueType.SUSPECT)
                {
                    //IF Check if suspect was found
                    if (findSuspect(fdex, clue, entry))
                    {
                        return true;
                    }
                }
                //ELSE IF getClueType with card is equal to vehicle
                else if (clue.getClueType() == ClueType.VEHICLE)
                {
                    //IF Check if vehicle was found
                    if (findVehicle(fdex, clue, entry))
                    {
                        return true;
                    }
                }
                //ELSE
                else
                {
                    //IF Check if destination was found
                    if (findDestination(fdex, clue, entry))
                    {
                        return true;
                    }
                //ENDIF
                }
            //ENDIF
            }
        //ENDFOR
        }
        //RETURN false as an invalid player or card was found
        return false;
    }
    
    private boolean hasSuspect(int sdex)
    {
        boolean foundplayer = false;
        //FOR each of the 4 players and foundplayer is false 
        for (int fdex = 0; fdex < this.playerSize && !foundplayer; fdex++)
        {
            //IF that table entry is true
            if (notepad[fdex][sdex] == NoteEntry.HAS)
            {
                //SET foundplayer to true
                foundplayer = true;
            //ENDIF
            }
        //ENDFOR
        }
        return foundplayer;
    }
    
    private boolean hasVehicle(int sdex)
    {
        boolean foundplayer = false;
        //FOR each of the 4 players and foundplayer is false 
        for (int fdex = 0; fdex < this.playerSize && !foundplayer; fdex++)
        {
            //IF that table entry is true
            if (notepad[fdex][sdex + suspects.size()] == NoteEntry.HAS)
            {
                //SET foundplayer to true
                foundplayer = true;
            //ENDIF
            }
        //ENDFOR
        }
        return foundplayer;
    }
    
    private boolean hasDestination(int sdex)
    {
        boolean foundplayer = false;
        //FOR each of the 4 players and foundplayer is false 
        for (int fdex = 0; fdex < this.playerSize && !foundplayer; fdex++)
        {
            //IF that table entry is true
            if (notepad[fdex][sdex + suspects.size() + vehicles.size()] == 
                    NoteEntry.HAS)
            {
                //SET foundplayer to true
                foundplayer = true;
            //ENDIF
            }
        //ENDFOR
        }
        return foundplayer;
    }
    
    /**
     * This method is called to check by the <code>Robot</code> whether or not
     * a correct solution can be obtained by the marked off 
     * <code>ClueCard</code> entries in this <code>Notepad</code>.
     * 
     * @return true if only 1 of each type of <code>ClueCard</code> has not been
     * marked down.
     */
    public boolean hasSolution() 
    {
        //SET foundplayer to false
        boolean foundplayer = false;
        //SET foundcounter to 0
        int foundcounter = 0;
        //FOR each of the first set of 6 clue cards in table
        for (int sdex = 0; sdex < suspects.size(); sdex++)
        {
            foundplayer = hasSuspect(sdex);
            //IF foundplayer is false
            if (!foundplayer)
            {
                //SET foundcounter incremented by 1
                foundcounter++;
            //ENDIF
            }
        //ENDFOR
        }
        //IF foundcounter is not equal to 1
        if (foundcounter != 1)
        {
            //RETURN false
            return false;
        //ENDIF
        }
        //SET foundplayer to false
        foundplayer = false;
        //SET foundcounter to 0
        foundcounter = 0;
        //FOR each of the 2nd set of 6 clue cards in table
        for (int sdex = 0; sdex < vehicles.size(); sdex++)
        {
            foundplayer = hasVehicle(sdex);
            //IF foundplayer is false
            if (!foundplayer)
            {
                //SET foundcounter incremented by 1
                foundcounter++;
            //ENDIF
            }
        //ENDFOR
        }
        //IF foundcounter is not equal to 1
        if (foundcounter != 1 )
        {
            //RETURN false
            return false;
        //ENDIF
        }
        //SET foundplayer to false
        foundplayer = false;
        //SET foundcounter to 0
        foundcounter = 0;
        //FOR each of the last set of 9 clue cards in table
        for (int sdex = 0; sdex < destinations.size(); sdex++)
        {
            foundplayer = hasDestination(sdex);
            //IF foundplayer is false
            if (!foundplayer)
            {
                //SET foundcounter incremented by 1
                foundcounter++;
            //ENDIF
            }
        //ENDFOR
        }
        //IF foundcounter is not equal to 1
        if (foundcounter != 1)
        {
            //RETURN false
            return false;
        //ENDIF
        }
        //RETURN true at end because we filtered that table only has 1 solution
        return true;
    }
    
    /**
     * Clears all marked <code>ClueCard</code> entries in this 
     * <code>Notepad</code> instance.
     */
    public void clearNotepad()
    {
        //FOR each of the 4 players
        for (int fdex = 0; fdex < this.playerSize; fdex++)
        {
            //FOR each of the 21 clue cards
            for (int sdex = 0; sdex < this.clueCardSize; sdex++)
            {
                //SET as false
                notepad[fdex][sdex] = NoteEntry.BLANK;
            //ENDFOR
            }
        //ENDFOR
        }
    }
    
    private NoteEntry suspectEntry(int fdex, ClueCard clue)
    {
        //FOR each suspect in themes
        for (int sdex = 0; sdex < suspects.size(); sdex++)
        {
            //IF CALL getSuspect of clue is equal to current suspect
            if (((SuspectCard)clue).getSuspect().equals(
                    suspects.get(sdex).getSuspect()))
            {
                //RETURN that index
                return notepad[fdex][sdex];
            //ENDIF
            }
        //ENDFOR
        }
        return null;
    }
    
    private NoteEntry vehicleEntry(int fdex, ClueCard clue)
    {
        //FOR each vehicle in themes
        for (int sdex = 0; sdex < vehicles.size(); sdex++)
        {
            //IF CALL getVehicle of clue is equal to current vehicle
            if (((VehicleCard)clue).getVehicle().equals(
                    vehicles.get(sdex).getVehicle()))
            {
                //RETURN that index
                return notepad[fdex][sdex + suspects.size()];
            //ENDIF
            }
        //ENDFOR
        }
        return null;
    }
    
    private NoteEntry destinationEntry(int fdex, ClueCard clue)
    {
        //FOR each destination in themes
        for (int sdex = 0; sdex < destinations.size(); sdex++)
        {
            //IF CALL getDestination of clue is equal to current
            if (((DestinationCard)clue).getDestination().equals(
                    destinations.get(sdex).getDestination()))
            {
                //RETURN that index
                return notepad[fdex][sdex + suspects.size() + vehicles.size()];
            //ENDIF
            }
        //ENDFOR
        }
        return null;
    }
    
    /**
     * Method to get the correct entry from the notepad
     * 
     * @param clue The clue card to check
     * @param from The player to check from
     * @return The correct NoteEntry enum this notepad assigned, returns null if
     * <code>NoteEntry</code> could not be found.
     */
    public NoteEntry getEntry(ClueCard clue, Player from)
    {
        //FOR each 1st dimension entry in table
        for (int fdex = 0; fdex < this.playerSize; fdex++)
        {
            //IF that entry contains the correct player name
            if (from.equalsName(players.get(fdex)))
            {
                //IF CALL getClueType with card is equal to suspect
                if (clue.getClueType() == ClueType.SUSPECT)
                {
                    return suspectEntry(fdex, clue);
                }
                //ELSE IF getClueType with card is equal to vehicle
                else if (clue.getClueType() == ClueType.VEHICLE)
                {
                    return vehicleEntry(fdex, clue);
                }
                //ELSE
                else
                {
                    return destinationEntry(fdex, clue);
                //ENDIF
                }
            //ENDIF
            }
        //ENDFOR
        }
        return null;
    }
    
    /**
     * Method to get list of suspects from the notepad
     * 
     * @return List of SuspectCards needed
     */
    public List<SuspectCard> getSuspects()
    {
        return this.suspects;
    }
    
    /**
     * Method to get list of vehicles from the notepad
     * 
     * @return List of VehicleCards needed
     */
    public List<VehicleCard> getVehicles()
    {
        return this.vehicles;
    }
    
    /**
     * Method to get list of destinations from the notepad
     * 
     * @return List of DestinationCards needed
     */
    public List<DestinationCard> getDestinations()
    {
        return this.destinations;
    }
    
    /**
     * Method to get the solution if a solution is available, precondition is
     * hasSolution was returned with true.
     * @return the <code>Solution</code> of this <code>Notepad</code>.
     */
    public Solution getSolution()
    {
        return solution;
    }
    
    /**
     * Returns the list of players starting clockwise relative to the robot player
     * on the gameboard.
     * 
     * @return list of other players.
     */
    public List<Player> getPlayers()
    {
        return players;
    }
}
