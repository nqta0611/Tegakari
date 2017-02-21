package tegakari;

import java.io.Serializable;
import java.util.*;
/**
 * Using result computed from <code>RobotActionLogic</code> to respond to 
 * server's message and make action decision.
 * 
 * @author anhnguyen
 * @author Jonathan Molina
 * @version 2.0
 *       1/12/2016 proposed skeleton.
 *       1/14/2016 add javadocs
 *       2/16/2016 complete implementing
 */
public class RobotEngine implements Serializable
{
    /**
     * Partial engine of the robot which responsible for Active state.
     */
    private RobotEngineInActive engineActive;
    /**
     * Partial engine of the robot which responsible for Idle state.
     */
    private RobotEngineInIdle engineIdle;
    /**
     * The state of the robot.
     */
    private RobotState state;
    /**
     * The owner of this engine.
     */
    private Robot owner;
    /**
     * The solution of the game.
     */
    private Solution solution;
    /**
     * Determine how smart this robot is
     */
    private AILevel intelligentLevel;
    /**
     * The table containing action cards and destination marks
     */
    private Table table;
    
    private RobotEngineMethods methods = new RobotEngineMethods();
    private RobotEngineHandleProtocols handleP = 
            new RobotEngineHandleProtocols();
    private RobotEngineMethods2 method2 = new RobotEngineMethods2();
    
    /**
     * Construct the Robot engine for a specific <code>Robot</code> owner,
     * Also initiate the <code>RobotEngineInActive</code> and the 
     * <code>RobotEngineInIdl</code> of this Robot Engine.
     * @param owner is the owner of this RobotEngine.
     * @param intelligentLevel is how smart this robot is
     */
    public RobotEngine(Robot owner, AILevel intelligentLevel)
    {
        //SET owner & intelligentLevel.
        this.owner = owner;
        this.intelligentLevel = intelligentLevel;
    }
    
    /**
     * Construct the Robot engine for a specific <code>Robot</code> owner,
     * Also initiate the <code>RobotEngineInActive</code> and the 
     * <code>RobotEngineInIdl</code> of this Robot Engine.
     * @param owner is the owner of this RobotEngine.
     * @param queuePlayers is the queue of players
     * @param intelligentLevel is how smart this robot is
     */
    public RobotEngine(Queue<Player> queuePlayers, Robot owner, AILevel intelligentLevel)
    {
        // CAUTION: the order of setting variables 
        // in this constructor is essential & fragile, do not swap
        //SET owner & intelligentLevel.
        this.owner = owner;
        Queue<Player> tempPlayers = new LinkedList<Player>();
        
        // build player list
        for (Player player : queuePlayers)
        {
            tempPlayers.add(player);
        }
        this.intelligentLevel = intelligentLevel;
        this.state = new RobotState(tempPlayers, owner, tempPlayers.peek());
        this.engineActive = new RobotEngineInActive(this, state);
        this.engineIdle = new RobotEngineInIdle();
        
        state.setSelf(owner);
        state.setPlayers(tempPlayers);
        
        engineActive.setEngineInIdle(engineIdle);
        
        engineIdle.setEngine(this);
        engineIdle.setEngineActive(engineActive);
        engineIdle.setState(state);
    }
    
    /**
     * Handling server's message, This method will cast server's message to an
     * appropriate class type, then call appropriate private helper method to
     * handle that message.
     * @param obj is the message from <code>GameServer</code>
     * @return the list of object that would be send back to the 
     *         <code>GameyServer</code>.
     */
    public List<Object> responseToServerMessage(Object obj)
    {
        //INIT a list to contain returned Objects.
        List<Object> toReturn = new ArrayList<Object>();
        
        //Case SuggestionCardLogic
        if (obj instanceof SuggestionCardLogic)
        {
            //SuggestionCardLogic, call handleSuggestion in RobotEngineInIdle
            toReturn = engineIdle.handleSuggestion(
                    (SuggestionCardLogic)obj, intelligentLevel);
        }
        // IF msg is a Queue of Players and the game has not started or client
        // has not yet created a player.
        else if (obj instanceof Queue && ((((Queue) obj).peek() instanceof Player) ))
        {
            // UPDATE Lobby's queue of Players
            state.setPlayers((Queue)obj);
            //this.printState();
        }
        // IF msg is Table && lobby has been signaled game ready
        else if (obj instanceof Table)
        {
            // SET the table for lobby 
            this.table = table;
            methods.prepareGame((Table) obj, this);
        }
        //ELSE
        else 
        {
            toReturn = responseToServerMessage2(obj);
        }
        //RETURN the list of objects received from calling helper method.
        return toReturn;
    }
    /**
     * Handling server's message, This method will cast server's message to an
     * appropriate class type, then call appropriate private helper method to
     * handle that message.
     * @param obj is the message from <code>GameServer</code>
     * @return the list of object that would be send back to the 
     *         <code>GameServer</code>.
     */
    private List<Object> responseToServerMessage2(Object obj)
    {
        //INIT a list to contain returned Objects.
        List<Object>  toReturn = new ArrayList<Object>();
        //CASE obj
        if (obj instanceof Protocol)
        {
            //Protocol, pass obj to method handleProtocol.
            toReturn = handleP.handleProtocol((Protocol)obj, this);
        }
        //Case Solution
        else if (obj instanceof Solution)
        {
            //Solution, pass obj to method handleSolution.
            toReturn = methods.handleSolution((Solution)obj, this);
        }
        //Case HistoryLog
        if (obj instanceof HistoryLog)
        {
            //HistoryLog, pass obj to method handleHistoryLog.
            toReturn = methods.handleHistoryLog((HistoryLog)obj, this);
        }
        //Case AccusationMessage
        if (obj instanceof AccusationMessage)
        {
            //AccusationMessage, pass obj to method handleAccusation.
            toReturn = methods.handleAccusation((AccusationMessage)obj, this);
        }
        //Case CardMessage
        if (obj instanceof CardMessage)
        {
            //CardMessage, pass obj to method handleCardMessage.
            toReturn = method2.handleCardMessage((CardMessage)obj, this);
        }
        return toReturn;
    }
    
    
    /**
     * Getter method
     * @return the active engine
     */
    public RobotEngineInActive getEngineActive() 
    {
        return engineActive;
    }
    /**
     * Setter method
     * @param engineActive is the active engine to set
     */
    public void setEngineActive(RobotEngineInActive engineActive)
    {
        this.engineActive = engineActive;
    }
    /**
     * Getter method
     * @return the idle engine
     */
    public RobotEngineInIdle getEngineIdle()
    {
        return engineIdle;
    }
    /**
     * Setter method
     * @param engineIdle is the idle engine to set
     */
    public void setEngineIdle(RobotEngineInIdle engineIdle) 
    {
        this.engineIdle = engineIdle;
    }
    /**
     * Getter method
     * @return the state engine
     */
    public RobotState getState()
    {
        return state;
    }
    /**
     * Setter method
     * @param state is the state engine to set
     */
    public void setState(RobotState state) 
    {
        this.state = state;
    }
    /**
     * Getter method
     * @return the owner robot
     */
    public Robot getOwner() 
    {
        // if message is not for self
        if (state.getSelf() != null)
        {
            this.owner = (Robot)state.getSelf();
        }
        return owner;
    }
    /**
     * Getter method
     * @return the solution of game
     */
    public Solution getSolution() 
    {
        return solution;
    }

    /**
     * Getter method
     * @return the intelligent level of robot
     */
    public AILevel getIntelligentLevel() 
    {
        return intelligentLevel;
    }
    
    /**
     * Setter for the robot using this engine
     * @param owner the robot to use this engine
     */
    public void setOwner(Robot owner) 
    {
        // if message is not self
        if (state.getSelf() != null)
        {
            this.owner = (Robot)state.getSelf();
        }
        this.owner = owner;
    }

    /**
     * Setter for the solution of this game
     * @param solution the solution of the game
     */
    public void setSolution(Solution solution) 
    {
        this.solution = solution;
    }

    /**
     * Setter for the AI level of the robot
     * @param intelligentLevel the AI level
     */
    public void setIntelligentLevel(AILevel intelligentLevel) 
    {
        this.intelligentLevel = intelligentLevel;
    }

    /**
     * Assessor to the queue of players.
     * 
     * @return the queue of players
     */
    public Queue<Player> getPlayers() 
    {
        return state.getPlayers();
    }

    /**
     * Returns the <code>Table</code> for this <code>RobotEngine</code>.
     * @return the table of the RObotEngine.
     */
    public Table getTable() 
    {
        return table;
    }

    /**
     * Sets the <code>Table</code> for the <code>RobotEngine</code>.
     * @param table the table to set the RobotEngine's table.
     */
    public void setTable(Table table) 
    {
        this.table = table;
    }
    /*public void printState()
    {
        System.out.println("[---------------" + state.getSelf().getName() 
         + "---------------------");
        
        List<Player> pList = new ArrayList<Player>(state.getPlayers());
        System.out.print("other players(" + pList.size() + ") :");
        for (Player p : pList) 
            if (p != null)
                System.out.print(p.getName() + "(" + 
                 p.getDestination().getName() + ")" +p + ", ");
            else
                System.out.println("nullPlayer, ");
        System.out.println("\nState ref: " + state);
        System.out.println("self ref : " + state.getSelf());
        
        System.out.println("\tmy self: " + state.getSelf().getName());
        System.out.println("\tmy DM: " +state.getSelf().getDestination().getName());
        
        System.out.print("\t my clue: ");
        List<ClueCard> clues = state.getSelf().getClueCards();
        for (ClueCard c : clues)
            System.out.print(c.getName() + ", ");
        
        System.out.print("\n\t action : ");
        List<ActionCard> actions = state.getSelf().getActionCards();
        for (ActionCard c : actions)
            System.out.print(c.getName() + ", ");
        System.out.println("\n-------------*----------------*------------]");
    }*/
}
