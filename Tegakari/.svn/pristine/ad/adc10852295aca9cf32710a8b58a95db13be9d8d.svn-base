package tegakari;

import java.util.List;

/**
 * SuspectCard is type of ClueCard, it represent the suspect card in Clue Game.
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class SuspectCard implements ClueCard 
{
    /**
     * Type of this clue card is Suspect clue card
     */
    private ClueType type;
    /**
     * The Suspect which this card represent
     */
    private Suspect suspect;
    /**
     * indicates if the card is face up
     */
    private boolean isFaceUp;

    /**
     * Constructing a SuspectCard with an instant of suspect.
     *
     * @param suspect is the specific suspect which this card represent
     */
    public SuspectCard(Suspect suspect) 
    {
        // SET suspect of card to the suspect provided
        this.suspect = suspect;
        // SET ClueType of this card to Suspect
        type = ClueType.SUSPECT;
        // SET isFaceUp to false
        isFaceUp = false;
    }

    /**
     * Access to the name of the card.
     *
     * @return the name of this suspect card as a string
     */
    @Override
    public String getName() 
    {
        // RETURN the name using suspects accessor method
        return suspect.getName();
    }

    /**
     * Access to the attribute of this card.
     *
     * @return the attribute of this card as a list of Attribute
     */
    @Override
    public List<Attribute> getAttribute() 
    {
        // RETURN the atributes using suspects accessor method
        return suspect.getAttributes();
    }

    /**
     * Checking method to check if the card is showing or not.
     *
     * @return the boolean indicate if the card is showing or not
     */
    @Override
    public boolean isShowing() 
    {
        return isFaceUp;
    }

    /**
     * Access to the clue type of this card.
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
     * Returns the fileName of the image.
     * The Theme contains the path to the folder it is in.
     * 
     * @return File path to the image
     */
    @Override
    public String getImagePath() 
    {
        return this.suspect.getImagePath();
    }
    
    /**
     * Checks if the two cards are equal.
     * 
     * @param obj the SuspectCard to compare to
     * @return True if both objects are equal
     */
    @Override
    public boolean equals(Object obj) 
    {
        boolean out = false;
        
        //IF obj is not null and is an instance of a suspect card
        if (obj != null && obj instanceof SuspectCard) 
        {
            SuspectCard sus = (SuspectCard) obj;
            out = this.suspect.equals(sus.suspect);
        }
        return out;
    }
    
    /**
     * Retrieve the suspect of this card
     * @return the suspect
     */
    public Suspect getSuspect() 
    {
        return this.suspect;
    }
}
