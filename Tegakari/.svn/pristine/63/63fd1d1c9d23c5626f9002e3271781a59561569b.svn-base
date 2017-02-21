package tegakari;

/**
 * A Super Sleuth Card represents a Super Sleuth Action Card in the Clue Card
 * game. This Action Card is played on all players in the current game. A Super
 * Sleuth Card may ask to Show me one female Suspect Card, Show me one male
 * Suspect Card, Show me one flying Vehicle Card, Show me one souther
 * Destination Card, or Show me one western Destination Card. There exists one
 * card for each description.
 *
 * @author Lohit
 */
public class SuperSleuthCard implements ActionCard 
{
    /**
     * Prefix text for every card description 
     */
    private static final String kPreText = "Show me";
    /**
     * The description of this card 
     */
    private String description;
    /**
     * The Clue Card type that is asked for 
     */
    private ClueType clueTypeEnum;
    /**
     * The Type of Clue Card that is asked for 
     */
    private Attribute attrEnum;
    /**
     * true if this card is face up, false if not
     */
    private boolean showing;
    /**
     * The path to the image of this suspect.
     */
    private final String kImagePath;

    /**
     * Constructor for a Super Sleuth Action Card.
     *
     * @param clueTypeEnum the Clue Card type being asked for
     * @param attrEnum the attribute of the Clue Card being asked for
     * @param imagePath is the path to the image
     */
    public SuperSleuthCard(ClueType clueTypeEnum, Attribute attrEnum, 
     String imagePath) 
    {
        // SET this object's clueTypeEnum as the parameter's clueTypeEnum
        this.clueTypeEnum = clueTypeEnum;
        // SET this object's attrEnum as the parameter's attrEnum
        this.attrEnum = attrEnum;
        this.showing = false;
        this.kImagePath = imagePath;
    }

    /**
     * Returns the description of this card.
     *
     * @return a String description of this card
     */
    public String getActionText() 
    {
        // INIT a new empty String called returnString
        String returnString = "";
        // ADD a preText to returnString
        returnString += kPreText;
        returnString += " one ";

        // CALL this object's attEnum getDescription method and 
        // ADD the returned String to returnString
        returnString += this.attrEnum.getDescription();
        // ADD a String with a single space " " to returnString
        returnString += " ";
        // CALL this object's clueTypeEnum getDescription method 
        // ADD the returned String to returnString
        returnString += this.clueTypeEnum.getDescription();
        returnString += " Card";
        // RETURN returnString
        return returnString;
    }

    /**
     * Returns the Clue Type associated with this card.
     *
     * @return the Clue Type that is being asked for
     */
    public ClueType getClueType() 
    {
        // RETURN this object's clueTypeEnum
        return this.clueTypeEnum;
    }

    /**
     * Returns the Attribute associated with this card.
     *
     * @return the Attribute that is being asked for
     */
    public Attribute getAttribute() 
    {
        // RETURN this object's attrEnum
        return this.attrEnum;
    }

    
    /**
     * Access to the name of this card
     * 
     * @return the name of this card as a string
     */
    @Override
    public String getName() 
    {
        // RETURN a String with the characters "Super Sleuth Card"
        return "Super Sleuth Card";
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
     * Retrieve the image path
     * @return the path
     */
    @Override
    public String getImagePath() 
    {
        return kImagePath;
    }
}
