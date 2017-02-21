package tegakari;

import java.io.Serializable;
import java.util.Stack;
import java.util.Collections;

/**
 * The Deck is responsible for holding a stack of <code>Card</code>s
 * manipulating the stack to shuffle, count, and deal.
 *
 * @param <T> T is either an ActionCard or ClueCard
 * @author Lohit
 */
public class Deck<T extends Card> implements Serializable 
{

    /**
     * The deck of <code>Card</code>s.
     */
    private Stack<T> deck;

    /**
     * Initialize an empty deck of <code>Card</code>s.
     */
    public Deck() 
    {
        //INIT deck stack
        deck = new Stack<T>();
    }

    /**
     * Add the given <code>Card</code> to the Deck.
     *
     * @param card The card to add
     */
    public void addCardToDeck(T card) 
    {
        //ADD card to top of deck stack
        deck.push(card);
    }

    /**
     * Removes and returns the top <code>Card</code> of deck
     *
     * @return the top <code>CARD</code>
     */
    public T dealCard() 
    {
        //REMOVE top card on the stack
        //RETURN card
        if (deck.size() > 0) 
        {
            return deck.pop();
        } 
        else 
        {
            return null;
        }
    }

    /**
     * Shuffle all the <code>Card</code>s in the deck
     */
    public void shuffle() 
    {
        //CALL shuffle method on stack
        Collections.shuffle(deck);
    }

    /**
     * Check if the Deck is empty
     *
     * @return true if deck is empty, false otherwise
     */
    public boolean isEmpty() 
    {
        //RETURN isEmpty method call on stack
        return deck.empty();
    }

    /**
     * Count the number of <code>Card</code>s in deck
     *
     * @return The number of cards
     */
    public int getCardCount() 
    {
        //RETURN size method call on stack
        return deck.size();
    }

    /**
     * Return but do not remove the top <code>Card</code>
     *
     * @return The <code>Card</code> that is at the top
     */
    public T peekTopCard() 
    {
        //RETURN peek method call on stack
        return deck.peek();
    }
    
    /**
     * Return this deck stack of cards
     *
     * @return The reference of the stack the deck uses
     */
    public Stack<T> getDeck() 
    {
        //RETURN peek method call on stack
        return this.deck;
    }
    /**
     * Returns if this Deck is equal to the given one
     * @param o the deck to check
     * @return if equal
     */
    @Override
    public boolean equals(Object o) 
    {
        // check if null
        if (o == null) 
        {
            return false;
        }
        // check if instanceof
        if (!(o instanceof Deck)) 
        {
            return false;
        }
        Deck test = (Deck)o;
        // check if equal
        if (!this.deck.equals(test.getDeck())) 
        {
            return false;
        }
        return true;
    }
}
