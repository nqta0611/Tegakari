
package tegakari;

import java.io.Serializable;
import java.util.List;
import java.util.Queue;

/**
 * This is an automate computer player which will act just like a normal player
 * in different level of intelligent.
 * 
 * @author anhnguyen
 * @version 2.0
 *          1/12/2016 proposed skeleton.
 *          1/14/2016 add javadocs
 */
public class Robot extends Player implements Serializable
{
    /**
     * The level of intelligent of this robot,
     * ranging from 1 to 3, as 3 is smartest. 
     */
    private AILevel level;
    
    /**
     * the engine of this robot.
     */
    private RobotEngine engine;
    
    /**
     * Construct a Robot, which implements a <code>Player</code>, with a name.
     * @param name is the name of this Robot player.
     * @param level AI level of Robot either Basic or Smart
     */
    public Robot(String name, AILevel level)
    {
        // CONSTRUCT new robot with name
        super(name);
        super.setRobot();
        this.level = level;
        this.engine = new RobotEngine(this, level);
    }
    
    /**
     * Construct a Robot, which implements a <code>Player</code>, with a name.
     * @param players list of players in the game
     * @param name is the name of this Robot player.
     * @param level level of the Robot, either Basic or Smart
     */
    public Robot(Queue<Player> players, String name, AILevel level)
    {
        // CONSTRUCT new robot with name
        super(name);
        super.setRobot();
        this.level = level;
        this.engine = new RobotEngine(players, this, level);
    }
    /**
     * Construct a Robot, which implements a <code>Player</code>.
     * @param name is the name of this Robot player.
     * @param hand is the hand of the robot.
     * @param dm is the destination of the robot.
     * @param level level of the Robot, either Basic or Smart
     */
    public Robot(String name, Hand hand, Destination dm, AILevel level) 
    {
        super(name, hand, dm);
        super.setRobot();
        this.level = level;
        this.engine = new RobotEngine(this, level);
    }
    /**
     * Receiving messages from server, pass to the Engine to compute it, and
     * give the return object to the server.
     * @param obj is the object received from server.
     * @return a list of object this Robot response to server
     */
    public List<Object> handleMessageFromServer(Object obj)
    {
        // CALL method responseToServerMessage on the RobotEngine.
        
        return engine.responseToServerMessage(obj);
    }
    
    /**
     * Setter method for AI level of robot. Used to change level in lobby.
     * @param lvl the AI level of the robot
     */
    public void setAILevel(AILevel lvl)
    {
        this.level = lvl;
    }
    
    /**
     * Setter for RobotEngine to use.
     * @param engine the engine to link with the robot.
     */
    public void setEngine(RobotEngine engine)
    {
        this.engine = engine;
    }
    
    /**
     * Getter for AILevel of robot.
     * @return the AILevel of this robot.
     */
    public AILevel getAILevel()
    {
        return level;
    }
    
    /**
     * Getter for the RobotEngine this robot is using.
     * @return the engine that is linked with this robot
     */
    public RobotEngine getEngine()
    {
        return engine;
    }
    
}
