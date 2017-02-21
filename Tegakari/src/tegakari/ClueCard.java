package tegakari;

import java.util.List;

/**
 * ClueCard is a type of Card, it represent the clue card in Clue Game
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public interface ClueCard extends Card 
{

    /**
     * Access to the clue type of this card
     *
     * @return the ClueType represent this card
     */
    public ClueType getClueType();

    /**
     * Access to the name of the card
     *
     * @return the name of this destination card as a string
     */
    @Override
    public String getName();

    /**
     * Access to the attribute of this card
     *
     * @return the attribute of this card as a list of Attribute
     */
    public List<Attribute> getAttribute();
    
    /**
     * Access to the image path of this card
     * @return the string of the image path associated with this card
     */
    public String getImagePath();
}
