
package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Partial engine of the the <code>Robot</code> which will collaborate with the
 * <code>RobotEngine</code> and the <code>RobotEngineInActive</code> to perform
 * all action when the <code>Robot</code> is in Idle.
 * 
 * @author anhnguyen
 * @version 1.2
 *          1/14/2016 Proposed classes skeleton and javadocs.
 */
public class RobotEngineInIdle  implements Serializable
{
    /**
     * the main engine of the robot.
     */
    private RobotEngine engine;
    /**
     * partial engine of the robot which responsible for Active state .
     */
    private RobotEngineInActive engineActive;
    /**
     * the state of the robot .
     */
    private RobotState state;
    
    /**
     * Getter method to get the <code>RobotState</code>.
     * @return the robot State associate with this class.
     */
    public RobotState getState() 
    {
        return state;
    }
    
    /**
     * Setter method to set the <code>RobotState</code>.
     * @param state is the new <code>RobotState</code> to set.
     */
    public void setState(RobotState state) 
    {
        this.state = state;
    }

    /**
     * Getter method to get the <code>RobotEngine</code>
     * @return the robot Engine associate with this class.
     */
    public RobotEngine getEngine() 
    {
        return engine;
    }

    /**
     * Setter method to set the <code>RobotEngine</code>.
     * @param engine is the new <code>RobotEngine</code> to set.
     */
    public void setEngine(RobotEngine engine) 
    {
        this.engine = engine;
    }
    
    /**
     * Getter method to get the <code>RobotEngineInActive</code>
     * @return the robot <code>RobotEngineInActive</code> which 
     * associate with this class.
     */
    public RobotEngineInActive getEngineActive() 
    {
        return engineActive;
    }

    /**
     * Setter method to set the <code>RobotEngineInActive</code>.
     * @param engineActive is the new <code>RobotEngineInActive</code> to set.
     */
    public void setEngineActive(RobotEngineInActive engineActive) 
    {
        this.engineActive = engineActive;
    }
    
    /**
     * Handling method to handle action request from other <code>Player</code>.
     * @param message the message given with the players involved and the
     * action to be played
     * @param intelligentLevel the AI level
     * @return the list of object to return to the server. In most case, 
     *         this list will contain the <code>ClueCard</code> that 
     *         <code>Robot</code> choose to respond to turn 
     *         <code>Player</code>'s action request. Return an Empty List 
     *         if there is no <code>ClueCard</code> to show
     */
    public List<Object> handleActionRequest(CardMessage message, 
            AILevel intelligentLevel)
    {
        // INIT the list of Object to return
        //Notepad note = state.getNote();
        List<Object> out = new ArrayList<Object>();
        
        //Player from = message.getFromPlayer();
        //Player to = message.getToPlayer();
        
        List<Card> action = message.getCards();
        
        RobotEngineInIdleMethods methods = new RobotEngineInIdleMethods(state);
        ActionCard aCard = (ActionCard) action.get(0);
        // IF the Card is SnoopCard
        if (aCard instanceof SnoopCard) 
        {
            out = methods.handleSnoopCard(message, intelligentLevel);
        }
        // ELSE IF the Card is SleuthCard
        else if (aCard instanceof SuperSleuthCard) 
        {
            out = methods.handleSleuthCard(message, intelligentLevel);
        }
        // ELSE IF the Card is PrivateTipCard
        else if (aCard instanceof PrivateTipCard) 
        {
            out = methods.handlePrivateTipCard(message, intelligentLevel);
        // ENDIF
        }
        return out;
    }
    /** 
     * Handling Suggestion method to handle <code>SuggestionCardLogic</code> request.
     * @param logic is the <code>SuggestionCardLogic</code> containing the 
     *        <code>Solution</code> or <code>Destination</code> that other 
     *        <code>Player</code> played with this card.
     * @param intelligentLevel determine how smart this robot is
     * @return the list of object to return to the server. This list will 
     *         contain the <code>ClueCard</code> that <code>Robot</code>
     *         choose to disprove turn <code>Player</code>'s suggestion.
     *         Return an empty list in case this 
     *         <code>SuggestionCardLogic</code> was a change destination.
     */

    public List<Object> handleSuggestion(SuggestionCardLogic logic, 
            AILevel intelligentLevel) 
    {
        //System.out.println("in handle SuggestionCardLogic");
        List<Object> out = new ArrayList<Object>();
        // check if the current player equals the turn player
        if (!state.getSelf().equals(state.getTurnPlayer())) 
        {
            //System.out.println("not my turn, start handling SuggestLogic");
            Notepad note = state.getNote();
            //System.out.println("got note pad: " + note);
            RobotSuggestionLogic robot = new RobotSuggestionLogic(note, state.getSelf());
            //System.out.println("created RobotSuggestionLogic: " + robot);
            // IF this SuggestionCardLogic isMove
            if (logic.isMoved()) 
            {
                //System.out.println("is Moved");
                // if the card is on table
                if (engine.getTable().getPile().contains(logic.getDestination()))
                {
                    //System.out.println("swap with table");
                    logic.swapDMWithTable(engine.getTable(), state.getTurnPlayer());
                }
                // destination on other player's hand
                else 
                {
                    //System.out.println("swap with player");
                    List<Player> playerList = new ArrayList<Player>(engine.getPlayers());
                    // FIND the player with the target destination
                    for (Player targetPlayer : playerList)
                    {
                        // CHECK if the player has the target destination
                        if (targetPlayer.getDestination().equals(logic.getDestination()))
                        {
                            logic.swapDMWithPlayer(state.getTurnPlayer(), targetPlayer);
                            break;
                        }
                    }
                }
            }
            // ELSE if the suggestion was for me to disprove
            else if (logic.getDisprover().getName().equals(state.getSelf().getName()))
            {
                //System.out.println("for me to disprove");
                // CALL disprove on the RobotSuggestionLogic
                List<ClueCard> list = robot.responseToActionRequest(logic, 
                        state.getTurnPlayer(), intelligentLevel);
                //System.out.println("\t called response to Action Request");
                // checking if the list is null
                if (list != null && list.size() > 0) 
                {
                    // MAKE a card message with that a return it
                    out.add(new CardMessage(state.getTurnPlayer(), 
                            state.getSelf(), list.get(0)));      
                    //System.out.println("\t added card message to return list");
                    // WRITE to History "<selfPlayer> disprove <turnPlayer>'s suggestion"
                    HistoryLog log = new HistoryLog(); 
                    log.addToLog(state.getLog().toString());
                    log.addToLog(state.getSelf().getName() 
                            + " disproved " + state.getTurnPlayer().getName() 
                            + "'s suggestion.");
                    //System.out.println("\t added history log to return list");
                    // ADD the History to the return list
                    out.add(log);
                }
            }
        }
        return out;
    }
}
