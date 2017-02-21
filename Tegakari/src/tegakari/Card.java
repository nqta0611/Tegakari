package tegakari;

import java.io.Serializable;

/**
 * Card is an interface that specifies the methods that all cards in the game
 * will have to implement and cards are used by the Deck and Hand class to deal
 * and play cards.
 *
 * @author Lohit
 */
public interface Card extends Serializable 
{

    /**
     * Gets the name of this card
     *
     * @return the card's name
     */
    public String getName();
    
    /**
     * Determine if card is faceup or facedown
     *
     * @return true if card if faceup, false otherwise
     */
    public boolean isShowing();
    
    /**
     * Flips the card face up regardless if it is already face up
     */
    public void makeFaceUp();

    /**
     * Flips the card face up regardless if it is already face up
     */
    public void makeFaceDown();
}
