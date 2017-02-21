package tegakari;
import java.io.Serializable;
import java.util.*;
/**
 * RobotEngine Helper Class 
 * @author anhnguyen
 */
public class RobotEngineMethods implements Serializable
{
    private int kIndexOfRobotNumber = 5;
    
    /**
     *  Prepare the table, dealt card to all players and robots
     * @param newTable the table to be dealt
     * @param engine the mother engine
     */
    public void prepareGame(Table newTable, RobotEngine engine) 
    {   
        engine.setTable(newTable);
        // Only The first Robot get to deal cards for everyone
        if (newTable.getClueDeck().getCardCount() > 0)
        {
            // deal out cards from table to all players 
            dealClueCardsToPlayers(engine);
            //(Clue Cards and First Action Card) in Player Queue Order
            dealActionCardsToPlayers(engine);
            // account for the first action card drawn
            engine.getTable().dealActionCard();
            // deal out random DM's to all players
            dealDMtoPlayers(engine);
        }
        
        Theme theme = engine.getTable().getTheme();
        
        List<SuspectCard> suspects = new ArrayList<SuspectCard>();
        List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
        List<DestinationCard> destinations = new ArrayList<DestinationCard>();
        
        //FOREACH suspect in the theme
        for (Suspect suspect : theme.getSuspects())
        {
            suspects.add(new SuspectCard(suspect));
        }
        //ENDFOR
        
        //FOREACH vehicles in the theme
        for (Vehicle vehicle : theme.getVehicles())
        {
            vehicles.add(new VehicleCard(vehicle));
        }
        //ENDFOR
        
        //FOREACH destination in the theme
        for (Destination destination : theme.getDestinations())
        {
            destinations.add(new DestinationCard(destination));
        }
        //ENDFOR
        
        Notepad pad = new Notepad(engine.getState().getPlayers(), suspects, 
                vehicles, destinations, engine.getSolution());
        engine.getState().setNote(pad);
    }
    
    /**
     * Dealing all clue card
     * @param engine is the mother engine
     */
    public void dealClueCardsToPlayers(RobotEngine engine) 
    {
        System.out.println("Dealing clues");
        
        List<Player> list = new ArrayList<Player>(engine.getState().getPlayers());
        ClueCard card;
        int index = 0;
        //Keep deling card til run out
        while ((card = engine.getTable().dealClueCard()) != null)
        {
            Player player = list.get(index++);
            System.out.println("\t card: " + card.getName() + " to " + 
                    player.getName()  + " to " + player.getName());
            Hand hand = player.getHand();
            hand.addToHand(card);
            //Reset index 
            if (index == list.size()) 
            {
                index = 0;
            }
        }
    }
    
    /**
     * Dealing all action cards
     * @param engine is the mother engine
     */
    private void dealActionCardsToPlayers(RobotEngine engine) 
    {
        System.out.println("Dealing action");
        List<Player> list = new ArrayList<Player>(engine.getState().getPlayers());
        //For each player
        for (Player player : list) 
        {
            ActionCard card = engine.getTable().dealActionCard();
            System.out.println("\t give actionC(" + card.getActionText() + 
                    ") to " + player.getName());
            player.getHand().addToHand(card);
        }
    }
    
    /**
     * Dealing destination marker 
     * @param engine is the mother engine
     */
    private void dealDMtoPlayers(RobotEngine engine) 
    {
        System.out.println("Dealing dest");
        List<Player> list = new ArrayList<Player>(engine.getState().getPlayers());
        //FOREACH player
        for (Player player : list) 
        {
            System.out.println("\t assign dest to " + 
                    player.getName());
            player.setDestination(engine.getTable().dealDM());
        }
        //ENFOR
    }
    
    
    /**
     * Helper method to handle <code>Solution</code> received from the
     * <code>GameServer</code>. 
     * @param sol is the solution of the game received from the server.
     * @param engine is the mother engine
     * @return a list of object to return to server or null if there is nothing
     *         to return.
     */
    public List<Object> handleSolution(Solution sol, RobotEngine engine)
    {
        // SET solution
        engine.setSolution(sol);
        
        return new ArrayList<Object>();
    }
    
    /**
     * Helper method to handle <code>HistoryLog</code> received from the 
     * <code>GameServer</code>.
     * @param log is the new <code>HistoryLog</code> for <code>RobotState</code>
     *        to update.
     * @param engine is the mother engine
     * @return a list of object to return to server or null if there is nothing
     *         to return.
     */
    public List<Object> handleHistoryLog(HistoryLog log, RobotEngine engine)
    {
        // IF intelligent Level is >= 2
        if (engine.getIntelligentLevel() == AILevel.SMART) 
        {
            // GET the last 2 lines from the log
            log.toString();
            // IF the 2nd last line says someone is playing an action card.
                // IF the last line says someone response to that action card.
                    // CHECK on my NotePad to see if have sufficient 
                    //info to mark off something.
                // ENDIF
            // ENDIF
        // ENDIF
        }
        // UPDATE historyLog in RobotState.
        engine.getState().setLog(log);
        // RETURN null
        return new ArrayList<Object>();
    }
    /**
     * Helper method to handle <code>AccusationMessage</code> received from the 
     * <code>GameServer</code>, This will show the result of turn 
     * <code>Player</code>'s accusation.
     * @param accusation is the <code>AccusationMessage</code> received from the 
     * <code>GameServer</code>.
     * @param engine is the mother engine
     * @return a list of object to return to server or null if there is nothing
     *         to return.
     */
    public List<Object> handleAccusation(AccusationMessage accusation, 
            RobotEngine engine)
    {
        // IF Accusation is incorrect.
        if (!accusation.isCorrect()) 
        {
            // SET the creator as OUT.
            accusation.getCreator().setPlayerLoses();
        }
        // ELSE
        else 
        {
            // SET got winner in RobotState.
            engine.getState().setGotWinner();
        // ENDIF
        }
        // RETURN null
        return new ArrayList<Object>();
    }
    
}
