package tegakari;

/**
 * A Private Tip Card models a Private Tip Action Card in the Clue card game. A
 * Private Tip may be used to show all Suspect Cards, all Vehicle Cards, all
 * Destination Cards, one female Suspect Card, one red Vehicle Card, or one
 * northern Destination Card of another player. There exists one Private Tip
 * Card of each effect.
 *
 * @author Lohit
 */
public class PrivateTipCard implements ActionCard 
{

    /**
     * Prefix text that all Private Tip Cards share. 
     */
    private final String preText = "Show me ";
    /**
     * Text that represents the effect of the specific Private Tip. 
     */
    private String description;
    /**
     * The path to the image of this suspect.
     */
    private final String imagePath;
    /**
     * The enum of the type of card that the Private Tip asks for. 
     */
    private ClueType clueTypeEnum;
    /**
     * The enum of the type of Clue Card that the Private Tip asks for. Private
     * Tips asking for "all" will not have an Attribute associated.
     */
    private Attribute attrEnum;
    /**
     * True if the Private Tip asks for all of a certain Clue Card type. 
     */
    private boolean isAll;
    /**
     * true if this card is face up, false if not
     */
    private boolean showing;

    /**
     * Constructor for Private Tip Cards that have no Attribute. i.e. Show me
     * all Suspect Cards, Show me all Vehicle Cards, and Show me all Destination
     * Cards.
     *
     * @param clueTypeEnum the Clue Card of the Private Tip
     * @param imagePath the path of image file
     */
    public PrivateTipCard(ClueType clueTypeEnum, String imagePath) 
    {
        // SET isAll as true
        // look at the javadoc above - all Suspect, all Vehicle, all Destination
        this.isAll = true;
        // SET this object's clueTypeEnum to the parameter's clueTypeEnum
        this.clueTypeEnum = clueTypeEnum;
        this.imagePath = imagePath;
        // SET attEnum to null
        this.attrEnum = null;
        // SET showing to false
        this.showing = false;
        // SET description as a String with the characters "All "
        this.description = "all your ";
        // CALL clueTypeEnum getDescription method ADD the returned String to description
        this.description += clueTypeEnum.getDescription();
        // ADD a String with the characters " Cards" to description
        this.description += " Cards";
    }

    /**
     * Constructor for Private Tip Cards that have an Attribute associated. i.e.
     * Show me one female Suspect Card, Show me one red Vehicle Card, Show me
     * one northern Destination Card.
     *
     * @param clueTypeEnum the Clue Card of the Private Tip
     * @param attrEnum the attribute of the Clue Card
     * @param imagePath the image path of file
     */
    public PrivateTipCard(ClueType clueTypeEnum, Attribute attrEnum,
     String imagePath)
    {
        // SET isAll as false
        // look at the javaDoc above, only one card
        this.isAll = false;
        // SET this object's clueTypeEnum to the parameter's clueTypeEnum
        this.clueTypeEnum = clueTypeEnum;
        // SET this object's attrEnum to the parameter's attrEnum
        this.attrEnum = attrEnum; 
        this.imagePath = imagePath;
        // SET showing to false
        this.showing = false;
        // SET description to a String with the characters "One "
        this.description = "one ";
        // CALL attrEnum getDescription method ADD the returned String to description
        this.description += attrEnum.getDescription();
        // ADD a String with a single space " " to description
        this.description += " ";
        // CALL clueTypeEnum getDescription method ADD the returned String to description
        this.description += clueTypeEnum.getDescription();
        // ADD a String with the characters " Card" to description
        this.description += " Card";
    }

    /**
     * Returns true if this Private Tip Card asks for all of a certain Clue
     * Card.
     *
     * @return true if this Private Tip asks for all
     */
    public boolean isAll() 
    {
        // RETURN isAll field
        return this.isAll;
    }

    /**
     * Returns the textual description of this Private Tip Card.
     *
     * @return a String of this Private Tip Card's description
     */
    public String getActionText() 
    {
        // ADD preText and description then RETURN
        return preText + this.description;
    }

    /**
     * Returns the Clue Card type that this Private Tip asks for.
     *
     * @return the Clue Card type this card asks for
     */
    public ClueType getClueType() 
    {
        // RETURN clueTypeEnum
        return clueTypeEnum;
    }

    /**
     * Returns the Attribute of the Clue Card of this Private Tip. May return
     * null if not applicable.
     *
     * @return the Attribute of this card
     */
    public Attribute getAttribute() 
    {
        // RETURN attrEnum
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
        // RETURN a String with the characters "Private Tip Card"
        return "Private Tip Card";
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
     * @return the path as as a string
     */
    @Override
    public String getImagePath() 
    {
        return imagePath;
    }
    /**
     * Compare the Private Tip card with other
     * @param other is the other card to be compare with this
     * @return the result as a boolean
     */
    @Override
    public boolean equals(Object other)
    {
        boolean out = false;
        // checks if null and instance of
        if (other != null && other instanceof PrivateTipCard) 
        {
            PrivateTipCard card = (PrivateTipCard) other;
            // CHECK for action text equality
            if (this.getActionText().equals(card.getActionText())) 
            {
                // CHECK for clue type equality
                if (this.clueTypeEnum == card.clueTypeEnum) 
                {
                    // CHECK for attribute equality
                    if (this.attrEnum == card.attrEnum)
                    {
                        // CHECK for all cards
                        if (this.isAll == card.isAll)
                        {
                            out = true;
                        }
                    }
                }
            }
        }
        return out;
    }
}
