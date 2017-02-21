package tegakari;

import java.io.Serializable;
import java.util.List;

/**
 * The HumanPlayer is an instance of <code>Player</code> representing a Human.
 * 
 * @author Jonathan Molina
 */
public class HumanPlayer extends Player implements Serializable
{

    /**
     * Constructs an instance with given name, hand, and destination
     *
     * @param name The name of the player
     * @param hand The hand that player has
     * @param dm the destination of player
     */
    public HumanPlayer(String name, Hand hand, Destination dm) 
    {
        super(name, hand, dm);
    }
    /**
     * Creates a <code>Player</code> with just a name.
     * @param name the name of the human player
     */
    public HumanPlayer(String name)
    {
        super(name);
    }
    
}
