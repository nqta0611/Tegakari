package tegakari;
import java.io.Serializable;
import java.util.*;
/**
 * Helper class for RobotEngine
 * @author anhnguyen
 */
public class RobotEngineHandleProtocols implements Serializable
{
    
    /**
     * Helper method to handle the <code>Protocol</code> message 
     * from <code>GameServer</code>.
     * @param ptc is the protocol receive from server.
     * @param engine is the mother engine
     * @return a list of object to return to the <code>GameServer</code>.
     *         return null if there is nothing to return to server.
     */
    public List<Object> handleProtocol(Protocol ptc, RobotEngine engine)
    {
        //INIT a list to contain returned Objects.
        List<Object> toReturn = null;
        //IF protocol is game_ready, call setGameReady in RobotState.
        if (ptc == Protocol.GAME_READY)
        {
            engine.getState().setGameReady();
        }
        //ELSE IF protocol is game_start, call setGameStart in RobotState.
        else if (ptc == Protocol.GAME_START)
        {
            engine.getState().setGameStart();
        }
        //ELSE IF protocol is game_over, call setGameOver in RobotState.
        else if (ptc == Protocol.GAME_OVER)
        {
            engine.getState().setGameOver();
        }
        //ELSE IF protocol is end_turn, call updateQueuePlayers in RobotState.
        else if (ptc == Protocol.END_TURN)
        {

            // IF this robot's turn, call beginTurn in RobotEngineInActive.
            if (engine.getState().getTurnPlayer().equalsName(
                    engine.getState().getSelf()))
            { 
                ActionCard top = engine.getTable().dealActionCard();
                // check for empty action deck
                if (top == null)
                {
                    // Action card after playd has been add to the discardPile 
                    //  already (in EngineActive/beginTurn),
                    // but rebuildActionDeckFromDiscardPile seem like not working,
                    // use buildActionDeck for temporary
                    // this.table.rebuildActionDeckFromDiscardPile();
                    engine.getTable().buildActionDeck();
                    top = engine.getTable().dealActionCard();
                }
                System.out.println(top.getActionText());

                System.out.println("Robot turn");
                engine.getState().getSelf().getHand().addToHand(top);
                System.out.println("done drawing action card : " + top.getClass());
                toReturn = engine.getEngineActive().beginTurn();
            // ENDIF
            }
            //this else printing for debugging only
            else if (!engine.getState().getTurnPlayer().isRobot())
            {
                engine.getTable().dealActionCard();
            }
        }
        //RETURN the list of objects received from calling other method.
        return toReturn;
    }
    
}
