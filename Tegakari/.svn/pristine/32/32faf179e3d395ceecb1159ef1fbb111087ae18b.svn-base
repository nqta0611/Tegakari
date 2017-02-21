package tegakari;

import java.io.Serializable;

/**
 * The ActionCardLogic represents the necessary actions each
 * <code>ActionCard</code> must simulate.
 *
 * @author Jonathan Molina
 */
public class ActionCardLogic implements Serializable 
{

    /**
     * the represented ActionCard
     */
    private ActionCard card;
    /**
     * the Player that played the ActionCard
     */
    private Player turnPlayer;

    /**
     * Constructs the
     * <code>ActionCardLogic</code> instance.
     *
     * @param card the represented <code>ActionCard</code>
     * @param turnPlayer the <code>Player</code> that played
     * the <code>ActionCard</code>
     */
    public ActionCardLogic(ActionCard card, Player turnPlayer) 
    {
        //SET card
        this.card = card;
        //SET turn player
        this.turnPlayer = turnPlayer;
    }

    /**
     * Retrieves the
     * <code>Player</code> that played the
     * <code>ActionCard</code>.
     *
     * @return the turn <code>Player</code>
     */
    public Player getTurnPlayer() 
    {
        //RETURN turn player
        return turnPlayer;
    }

    /**
     * Retrieves the represented
     * <code>ActionCard</code>.
     *
     * @return the represented <code>ActionCard</code>.
     */
    public ActionCard getActionCard() 
    {
        //RETURN card
        return card;
    }
}
