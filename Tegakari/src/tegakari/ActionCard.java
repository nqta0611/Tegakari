package tegakari;

/**
 * The Action Card interface represents an Action Card used in the game of clue.
 * Each player starts the game with one Action Card, drawing another Action Card 
 * when the player's turn is up. Players use Action Cards to uncover information 
 * in order to create a correct accusation.
 *
 * @author Lohit 
 */
public interface ActionCard extends Card 
{
    
    /**
     * Returns a description of the Action Card.
     * @return a String of the implemented Action Card.
     */
    public String getActionText();
    
    /**
     * Access to the image path of this card
     * @return the string of the image path associated with this card
     */
    public String getImagePath();
    
}
