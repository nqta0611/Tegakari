
package tegakari;

import java.io.Serializable;
import java.util.*;

/**
 * Partial engine of the the <code>Robot</code> which will collaborate with the
 * <code>RobotEngine</code> and the <code>RobotEngineInIdle</code> to perform
 * all action when the <code>Robot</code> having turn.
 * 
 * @author anhnguyen
 * @version 1.2
 *          1/14/2016 proposed class skeleton and javadocs
 */
public class RobotEngineInActive implements Serializable
{
    /**
     * the main engine of the robot.
     */
    private RobotEngine engine;
    /**
     * partial engine of the robot which responsible for Idle state .
     */
    private RobotEngineInIdle engineIdle;
    /**
     * the state of the robot .
     */
    private RobotState state;
    
    private RobotActionLogic robotLogic;
    private RobotSuggestionLogic robotSLogic;
    
    private int expectedCard = 0;
    private int receivedCard = 0;
    
    private RobotEngineInActivePerformAction engineAction =
            new RobotEngineInActivePerformAction();

    /**
     * Getter method of RobotLogic
     * @return the robotLogic
     */
    public RobotActionLogic getRobotLogic() 
    {
        return robotLogic;
    }

    /**
     * Setter method to set Robot Logic
     * @param robotLogic is the logic to set
     */
    public void setRobotLogic(RobotActionLogic robotLogic) 
    {
        this.robotLogic = robotLogic;
    }

    /**
     * Getter method to the RobotSuggestionLogic
     * @return the robotSLogic field
     */
    public RobotSuggestionLogic getRobotSLogic() 
    {
        return robotSLogic;
    }

    /**
     * Setter method to the robotSLogic
     * @param robotSLogic is the robotSLogic to set
     */
    public void setRobotSLogic(RobotSuggestionLogic robotSLogic) 
    {
        this.robotSLogic = robotSLogic;
    }

    /**
     * Getter method to the ExpectedCard
     * @return field ExpectedCard
     */
    public int getExpectedCard() 
    {
        return expectedCard;
    }

    /**
     * Setter method to the ExpectedCard
     * @param expectedCard is the number to set ExpectedCard
     */
    public void setExpectedCard(int expectedCard) 
    {
        this.expectedCard = expectedCard;
    }

    /**
     * Getter method to the ReceivedCard
     * @return the ReceivedCard
     */
    public int getReceivedCard() 
    {
        return receivedCard;
    }

    /**
     * Setter method of RecevedCard
     * @param receivedCard is the number of receivedCard to set
     */
    public void setReceivedCard(int receivedCard) 
    {
        this.receivedCard = receivedCard;
    }
    
    
    /**
     * Returns the state of the InActive
     * @return the state
     */
    public RobotState getState() 
    {
        return state;
    }
    /**
     * Sets the state of the InActive
     * @param state the state
     */
    public void setState(RobotState state) 
    {
        this.state = state;
    }

    /**
     * Constructor of the engine in active
     * @param engine is the main engine
     * @param state is the state associate with this engine
     */
    public RobotEngineInActive(RobotEngine engine, RobotState state)
    {
        this.engine = engine;
        this.state = state;
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
     * Gets the engine of the InIdle
     * @return the engine
     */
    public RobotEngine getEngine() 
    {
        return engine;
    }
    
    /**
     * Getter method to get the <code>RobotEngineInIdle</code>
     * @return the robot <code>RobotEngineInIdle</code> associate with this class.
     */
    public RobotEngineInIdle getEngineIdle() 
    {
        return engineIdle;
    }
    /**
     * Setter method to set the <code>RobotEngineInIdle</code>.
     * @param engineInIdle is the new <code>RobotEngineInIdle</code> to set.
     */
    public void setEngineInIdle(RobotEngineInIdle engineInIdle) 
    {
        this.engineIdle = engineInIdle;
    }
    /**
     * Let the robot begin turn, choose an actionCard to play, and perform 
     * the action of that action card.
     * @return the object need to send to server after playing an action.
     */
    public List<Object> beginTurn()
    {
        
        // INIT the list to return
        List<Object> toReturn = new ArrayList<Object>();
        
        System.out.println("\nBegin "+ state.getSelf().getName() +"'s turn");
        // Reset data
        this.expectedCard = 0;
        this.receivedCard = 0;
        this.robotLogic = null;
        this.robotSLogic = null;
        // CALL chooseCardToPlay to get the chosen Action Card to play.
        ActionCard cardToPlay =
            this.chooseCardToPlay(engine.getOwner().getHand().getActionCards(), 
                engine.getIntelligentLevel());
        System.out.println(engine.getOwner().getName() + " plays action card: "
                + cardToPlay.getActionText());
        // CALL actionPerform to play that chosen Action Card.
        toReturn = engineAction.actionPerform(cardToPlay, this);
        // Discard the recent played action
        List<ActionCard> robotActionCards = state.getSelf().getHand().getActionCards();
        //IF action card played is the first index of the action card list
        if(cardToPlay.getActionText().equals(robotActionCards.get(0).getActionText()))
        {
            robotActionCards.remove(0);
        }
        //ELSE
        else
        {
            robotActionCards.remove(1);
        }
        //ENDIF
        
        // IF NotePad has recognize the solution
        if (state.getNote().hasSolution()) 
        {
            System.out.println("Found a solution");
            // MAKE an AccusationMessage and ADD it to the return List
            AccusationMessage accuse = new AccusationMessage(
                state.getNote().getSolution(), null, state.getSelf()); 
            toReturn.add(accuse);
        }
        // this ELSE for debug printing purpose only
        else
        {
            System.out.println(engine.getOwner().getName() 
                    + " has not found solution yet.");
        }
        //Don't expect receiving any card
        if(this.expectedCard == 0)
        {
            toReturn.add(Protocol.END_TURN);
        }
        // RETURN the objects to send to server after playing action.
        return toReturn;
    }
    
    /**
     * Choose which card to play.
     * @param cards is the list of action card in this robot hand
     * @param intelligentLevel the AILevel
     * @return the chosen action card to play
     */
    public ActionCard chooseCardToPlay(List<ActionCard> cards, 
            AILevel intelligentLevel) 
    {
        ActionCard toPlay;
   
        // CALL benefitFromAction on each ActionCard
        if (benefitCount(cards.get(1)) > benefitCount(cards.get(0))
                && intelligentLevel == AILevel.SMART) 
        {
            // SET the chosen action card to the one has higher benefit.
            benefitCount(cards.get(1));
            toPlay = cards.get(1);
        }
        else 
        {
            benefitCount(cards.get(0));
            toPlay = cards.get(0);
        }
        // ENDIF
        // RETURN the chosen ActionCard
        return toPlay;
    }
    /**
     * the benefit the robot would have from playing the card
     * @param card the card to get the benefit from
     * @return the benefit (1-5)
     */
    public int benefitCount(ActionCard card)
    {
        int toReturn;
        // Action card
        if (card instanceof SuggestionCard)
        {
            RobotSuggestionLogic logic = new RobotSuggestionLogic(
                    state.getNote(), state.getSelf());
            toReturn = logic.benefitFromAction(card);
            robotSLogic = logic;
        }
        else 
        {
            RobotActionLogic logic = null;
            //Snoop
            if (card instanceof SnoopCard)
            {
                logic = new RobotSnoopLogic();
            }
            //Sleuthcard
            else if (card instanceof SuperSleuthCard)
            {
                logic = new RobotSleuthLogic(engine.getIntelligentLevel(), 
                        new ArrayList<Player>(engine.getPlayers()));
            }
            //PrivateTip
            else if (card instanceof PrivateTipCard)
            {
                logic = new RobotPrivateTipLogic(engine.getIntelligentLevel(), 
                        new ArrayList<Player>(engine.getPlayers()));
            }
            toReturn = logic.benefitFromAction(state.getNote(), card);
            //toReturn = 2;
            robotLogic = logic;
        }
        return toReturn;
    }
   
    /**
     * Handle <code>CardMessage</code> received from the <code>GameServer</code>,
     * This message is clue card from other <code>Player</code> showing to this 
     * <code>Robot</code> in responding to a action request.
     * @param clueCard is the <code>CardMessage</code> received.
     * @return a list of object to return to server or null if there is nothing
     *         to return.
     */
    public List<Object> handleClueCard(CardMessage clueCard)
    {
        System.out.println("Handling clue card:");
        List<Object> toReturn = new ArrayList<Object>();
        
        // IF it is my turn, means other showing me
        if (state.getSelf().getName().equals(state.getTurnPlayer().getName())) 
        {
            System.out.println("\t" + clueCard.getFromPlayer().getName() +" showing me " 
                    + ((ClueCard)(clueCard.getCards().get(0))).getName());
            // CALL takeNote with the shown ClueCard.
            boolean mark1 = state.getNote().mark((ClueCard)clueCard.getCards().get(0), 
                    clueCard.getFromPlayer(), NoteEntry.HAS);
            boolean mark2 = state.getNote().mark((ClueCard)clueCard.getCards().get(0), 
                    clueCard.getFromPlayer(), NoteEntry.SHOWN);
            
            System.out.println("\t marked : " + mark1 + " , " + mark2);
            
            
            // After receiving shown card, robot can end turn or make accusation
            if (state.getNote().hasSolution())
            {
                System.out.println("\tFound solution");
                AccusationMessage accuse = new AccusationMessage(
                    state.getNote().getSolution(), null, state.getSelf()); 
                toReturn.add(accuse);
            }
            // IF receive all expected Clue, 
            if (++receivedCard >= expectedCard)
            {
                System.out.println("\tFinish robot turn");
                // ADD END_TURN to the return list.
                toReturn.add(Protocol.END_TURN);
            }
        }
        
        // IF I have this card, means other snoop on me
        if (state.getSelf().getClueCards().contains(
                (ClueCard)(clueCard.getCards().get(0)))) 
        {
            System.out.println("\tOther snooped on me " + 
                    ((ClueCard)(clueCard.getCards().get(0))).getName());
            // Other player has seen my card, mark it as shown
            state.getNote().mark((ClueCard)clueCard.getCards().get(0), 
                    state.getSelf(), NoteEntry.SHOWN);
        }
        
        return toReturn;
    }
}
