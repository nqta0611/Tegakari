package tegakari;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * CardMessage represents the
 * <code>Card</code>s a
 * <code>Player</code> sends to another
 * <code>Player</code> via the
 * <code>GameServer</code>. Such when a
 * <code>Player</code> show one or more cards to another
 * <code>Player</code>. This class hold information of the
 * <code>Player</code> who sent the cards,
 * <code>Player</code> who receive those
 * <code>Card</code>, and a list of those cards
 *
 * @author Anh Nguyen
 *
 * @version 12/5/2015 Version 1.0
 */
public class CardMessage implements Serializable
{

    /**
     * The source
     * <code>Player</code> who sent out this message.
     */
    private Player toPlayer;
    /**
     * The target
     * <code>Player</code> who will receive this message.
     */
    private Player fromPlayer;
    /**
     * List of
     * <code>Card</code> those are being sent.
     */
    private List<Card> cards;

    /**
     * Construct the CardMessage with all
     * <code>Attribute</code> of this card messenger including source
     * <code>Player</code>, target
     * <code>Player</code> and list of
     * <code>Card</code> that being sent
     *
     * @param toPlayer is the source <code>Player</code> who send these cards
     * @param fromPlayer is the target <code>Player</code> who will receive
     * these cards
     * @param cards is a list of card that will be sent from fromPlayer to
     * toPlayer
     */
    public CardMessage(Player toPlayer, Player fromPlayer, List<Card> cards)
    {
        this.toPlayer = toPlayer;
        this.fromPlayer = fromPlayer;
        this.cards = cards;
    }

    /**
     * Construct the CardMessage with all
     * <code>Attribute</code> of this card messenger including source
     * <code>Player</code>, target
     * <code>Player</code> and list of
     * <code>Card</code> that being sent
     *
     * @param toPlayer is the source <code>Player</code> who send these cards
     * @param fromPlayer is the target <code>Player</code> who will receive
     * these cards
     * @param card a card to be sent from fromPlayer to toPlayer
     */
    public CardMessage(Player toPlayer, Player fromPlayer, Card card)
    {
        this.toPlayer = toPlayer;
        this.fromPlayer = fromPlayer;
        this.cards = new ArrayList<Card>();
        this.cards.add(card);
    }
    
    /**
     * Access to the target
     * <code>Player</code> who will receive these cards
     *
     * @return the the target player which is toPlayer
     */
    public Player getToPlayer()
    {
        // RETURN the CardMessage's toPlayer
        return this.toPlayer;
    }

    /**
     * Access to the source player who sent these cards
     *
     * @return the source player which is fromPlayer
     */
    public Player getFromPlayer()
    {
        // RETURN the CardMessage's fromPlayer
        return this.fromPlayer;
    }

    /**
     * Access to the list of cards those are being sent
     *
     * @return the List of <code>ClueCard</code>
     */
    public List<Card> getCards()
    {
        // RETURN the CardMessage's list of <code>ClueCards</code>
        return this.cards;
    }
}
