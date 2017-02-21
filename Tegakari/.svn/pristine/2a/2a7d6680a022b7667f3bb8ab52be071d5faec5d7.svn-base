
package tegakari;
import java.io.Serializable;
import java.util.*;
/**
 * Helper class for RobotEngine
 * @author anhnguyen
 */
public class RobotEngineMethods2 implements Serializable
{
    
    /**
     * A Helper method to help responseToServerMessage handling all type of 
     * <code>CardMessage</code>, This method will divide <code>CardMessage</code>
     * into two categories (active and idle) and pass that message to either
     * <code>RobotEngineInActive</code> or <code>RobotEngineInIdle</code> to 
     * handle.
     * @param message is the card message received from <code>GameServer</code>
     * @param engine is the mother engine
     * @return a list of object to return to the <code>GameServer</code>.
     */
    public List<Object> handleCardMessage(CardMessage message, RobotEngine engine)
    {
        // INIT a list of Object to contain objects to return
        List<Object> toReturn = new ArrayList<Object>();
        // if message equals for self then
        if (message.getToPlayer().getName().equals(
                engine.getState().getSelf().getName()))
        {
            Card card = message.getCards().get(0);
            // IF the Card is Clue Card
            if(card instanceof ClueCard)
            {
                // CALL handleClueCard in RobotEngineInActive.
                toReturn = engine.getEngineActive().handleClueCard(message);
            }
            // ELSE
            else
            {
                // CALL handleActionRequest in RobotEngineInIdle.
                toReturn = engine.getEngineIdle().handleActionRequest(message,
                        engine.getIntelligentLevel());
            // ENDIF
            }
            // RETURN robot's response
            if(toReturn == null)
            {
                toReturn = new ArrayList<Object>();
            }
        }
        return toReturn;
    }
}
