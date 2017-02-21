package tegakari;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * The hand represents that <code>Card</code>s that the player has
 *
 * @author Lohit
 */
public class Hand implements Serializable 
{

    /**
     * The <code>ClueCard</code>s that are held
     */ 
    private List<ClueCard> clueCard;
    /**
     * The <code>ActionCard</code>s that are held
     */ 
    private List<ActionCard> actionCard;

    /**
     * Initialize an empty list of <code>ClueCard</code>s and <code>ActionCard</code>s
     */
    public Hand() 
    {
        //INIT clueCard list
        this.clueCard = new ArrayList<ClueCard>();
        //INIT actionCard list
        this.actionCard = new ArrayList<ActionCard>();
    }

    /**
     * Determines which list to add <code>Card</code> to and then adds it
     *
     * @param card The <code>Card</code> to be added
     */
    public void addToHand(Card card)
    {
        //IF card is an instance fo Clue Card
        if (card instanceof ClueCard) 
        {
            //ADD to clueCard list
            this.clueCard.add((ClueCard)card);
        //ELSE
        }
        else 
        {
            //ADD to actionCard list
            this.actionCard.add((ActionCard)card);
        //ENDIF
        }
    }

    /**
     * Gets the list of <code>ClueCard</code>s
     *
     * @return the list of <code>ClueCard</code>s
     */
    public List<ClueCard> getClueCards() 
    {
        //RETURN new list of clue cards
        return clueCard;
    }

    /**
     * Gets the list of <code>ActionCard</code>s
     *
     * @return the list of <code>ActionCard</code>s
     */
    public List<ActionCard> getActionCards() 
    {
        return actionCard;
    }

    /**
     * Counts the number of <code>ActionCard</code>s in hand
     *
     * @return the number of <code>Card</code>s
     */
    public int getActionCardTotal() 
    {
        //RETURN size method call on actionCard list
        return this.actionCard.size();
    }

    /**
     * Counts the number of <code>ClueCard</code>s in hand
     *
     * @return the number of <code>Card</code>s
     */
    public int getClueCardTotal()
    {
        //RETURN size method call on clueCard list
        return this.clueCard.size();
    }

    /**
     * Determines what type of <code>Card</code> is given and then removes it from
     * appropriate list
     *
     * @param card The <code>Card</code> to remove from hand
     * @return true if <code>Card</code> exists and is removed, false otherwise
     */
    public boolean remove(Card card) 
    {
        //IF remove method call on clueCard list
        if (this.clueCard.remove(card)) 
        {
            //RETURN true
            return true;
        }
        //ELSEIF remove method call on actionCard list
        else if (this.actionCard.remove(card)) 
        {
            //RETURN true
            return true;
        }
        
        //RETURN false
        return false;
        
    }
    
    
    /**
     * Returns if this Table is equal to the parameter Table
     * @param other the other Hand to be compare
     * @return if the two Table objects are equal to each other or not
     */
    @Override
    public boolean equals(Object other) 
    {
        // check null
        if (other == null)
        {
            return false;
        }
        // check type
        if (!(other instanceof Hand)) 
        {
            return false;
        }
        Hand test = (Hand)other;
        // check clue cards
        if (!this.clueCard.equals(test.getClueCards())) 
        {
            return false;
        }
        //check action cards
        if (!this.actionCard.equals(test.getActionCards())) 
        {
            return false;
        }
        return true;
    }
}
