package tegakari;

import java.util.List;


/**
 * The SnoopCardLogic represents the necessary actions each
 * <code>SnoopCard</code> must simulate.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 11/4/2015 - Write java doc
 * @version 11/11/2015 - Implement code
 */
public class SnoopCardLogic extends ActionCardLogic 
{

    /**
     * the targeted players
     */ 
    private List<Player> players;

    /**
     * Constructs the
     * <code>SnoopCardLogic</code> instance.
     *
     * @param card the represented <code>SnoopCard</code>
     * @param turnPlayer the <code>Player</code> that played
     * the <code>SnoopCard</code>
     */
    public SnoopCardLogic(SnoopCard card, Player turnPlayer) 
    {
        // SET card
        // SET turn player
        super(card, turnPlayer);
        // SET list of players
        //this.players = players;
    }

    /**
     * Performs the action the target
     * <code>Player</code> must do.
     *
     * @param received the target <code>Player</code>
     * @return the appropriate <code>List</code> of <code>ClueCards</code>
     */
    public List<ClueCard> playSnoop(Player received) 
    {
        return received.getClueCards();
    }
}
