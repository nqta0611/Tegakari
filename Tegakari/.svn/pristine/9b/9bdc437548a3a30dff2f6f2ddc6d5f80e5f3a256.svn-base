package tegakari;

/**
 * The SuggestionCard class represents a Suggestion Action Card in the Clue Card
 * game. Suggestion Cards can be played to "Make a Suggestion from ANY
 * Destination" or "Make a Suggestion from Current Destination or Move to
 * another Destination." There exists ten any Destination Suggestion Cards and
 * nine current Destination Suggestion Cards.
 *
 * @author Lohit
 */
public class SuggestionCard implements ActionCard 
{
    /**
     * Description of an any Destination Suggestion Card 
     */
    private static final String kAnyDMText = 
            "Make a Suggestion from ANY Destination";
    /**
     * Description of a current Destination Suggestion Card 
     */
    private static final String kCurrentDMText = 
            "Make a Suggestion from Current Destination "
            + "or Move to Another Destination";
    /**
     * true if this Suggestion Card is for current Destinations 
     */
    private final boolean isCurrentSuggestion;
    /**
     * true if this card is face up, false if not
     */
    private boolean showing;
    /**
     * The path to the image of this suspect.
     */
    private final String imagePath;

    /**
     * Constructor for a Suggestion Card.
     *
     * @param isCurrentSuggestion true if this Card is for current Destination
     * @param imagePath is the path ti the image
     */
    public SuggestionCard(boolean isCurrentSuggestion, String imagePath) 
    {
        // SET this object's isCurrentSuggestion to the parameter's isCurrentSuggestion
        this.isCurrentSuggestion = isCurrentSuggestion;
        this.imagePath = imagePath;
        // SET showing as false
        this.showing = false;
        // SET this object's isCurrentSuggestion to the parameter's isCurrentSuggestion
        // SET showing as false
    }

    /**
     * Returns a textual description of this card.
     *
     * @return a String of this Card's description
     */
    public String getActionText() 
    {
        // IF this object's isCurrentSuggestion is true THEN
        if (this.isCurrentSuggestion()) 
        {
            // RETURN currentDMText
            return kCurrentDMText;
        }
        // ELSE
        else 
        {
            // RETURN andyDMText
            return kAnyDMText;
        // END IF
        }
    }

    /**
     * Returns true if this Card is a current Destination Suggestion Card.
     *
     * @return true if this Card is for current Destination
     */
    public boolean isCurrentSuggestion() 
    {
        // RETURN this object's isCurrentSuggestion
        return this.isCurrentSuggestion;
    }

    
    /**
     * Access to the name of this card
     * 
     * @return the name of this card as a string
     */
    @Override
    public String getName() 
    {
        // RETURN a String with the characters "Suggestion Card"
        return "Suggestion Card";
    }

    
    /**
     * Access to the showing state of this card
     * 
     * @return a boolean indicates if this card is shown or not
     */
    @Override
    public boolean isShowing() 
    {
        // RETURN showing
        return this.showing;
    }
    
    /**
     * Implementation of Card interface, marks the card as showing
     */
    @Override
    public void makeFaceUp() 
    {
        // SET showing as true
        this.showing = true;
    }
    
    /**
     * Implementation of Card interface, marks the card as not showing
     */
    @Override
    public void makeFaceDown() 
    {
        // SET showing as false
        this.showing = false;
    }

    /**
     * Retrieve the path to the image of this card
     * @return the path as a string
     */
    @Override
    public String getImagePath() 
    {
        return imagePath;
    }
}
