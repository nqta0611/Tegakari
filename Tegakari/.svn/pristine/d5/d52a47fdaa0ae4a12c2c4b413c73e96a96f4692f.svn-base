package tegakari;

import java.util.List;

/**
 * DestinationCard is type of ClueCard, it represent the destination card in
 * Clue Game
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class DestinationCard implements ClueCard 
{

    /**
     * Type of this clue card is Destination clue card
     */
    private ClueType type;
    /**
     * The Destination which this card represent
     */
    private Destination destination;
    /**
     * indicates if the card is face up
     */
    private boolean isFaceUp;
     

    /**
     * Constructing a DestinationCard with an instant of destination
     *
     * @param destination is the specific suspect which this card represent
     */
    public DestinationCard(Destination destination) 
    {
        // SET destination of card to the destination provided
        this.destination = destination;
        // SET ClueType of this card to Destination
        type = ClueType.DESTINATION;
        // SET isFaceUP to false
        isFaceUp = false;
    }

    /**
     * Access to the name of the card
     *
     * @return the name of this destination card as a string
     */
    @Override
    public String getName() 
    {
       // RETURN the name using destinations accessor method
        return destination.getName();
    }

    /**
     * Checking method to check if the card is showing or not
     *
     * @return the boolean indicate if the card is showing or not
     */
    @Override
    public boolean isShowing() 
    {
        return isFaceUp;
    }

    /**
     * Access to the clue type of this card
     *
     * @return the ClueType represent this card
     */
    @Override
    public ClueType getClueType() 
    {
        // RETURN the ClueType of this card
        return type;
    }

    /**
     * Access to the attribute of this card
     *
     * @return the attribute of this card as a list of Attribute
     */
    @Override
    public List<Attribute> getAttribute() 
    {
        // RETURN the atributes using destinations accessor method
        return destination.getAttributes();
    }

    /**
     * Set this card to face up.
     */
    public void makeFaceUp() 
    {
        // SET isFaceUp to true
        isFaceUp = true;
    }

    /**
     * Set this card to face down.
     */
    public void makeFaceDown() 
    {
        // SET isFaceUp to false
        isFaceUp = false;
    }

    /**
     * Returns the fileName of the image
     * The Theme contains the path to the folder it is in.
     * @return the filename of image
     */
    public String getImagePath() 
    {
        return this.destination.getImagePath();
    }
    
    /**
     * Checks if the two cards are equal.
     * @param o the <code>DestinationCard</code> to compare to
     * @return if they are equal or not
     */
    public boolean equals(Object o) 
    {
        boolean out = false;
        
        // check if object is instance of destinationcard
        if (o != null && o instanceof DestinationCard) 
        {
            DestinationCard dest = (DestinationCard) o;
            out = this.destination.equals(dest.destination);
        }
        return out;
    }
    /**
     * Retrieve the suspect of this card
     * @return the suspect
     */
    public Destination getDestination() 
    {
        return this.destination;
    }
}
