package tegakari;

/**
 * A snoop Card represents the snoop Action Card in the Clue Card game. This
 * class encompasses both a regular snoop Card(snoop on any player's hand) and
 * the All-snoop Card. There exists four regular snoop cards, two All snoop on
 * player's hand to the Left Cards, and two All snoop on player's hand to the
 * Right Cards.
 *
 * @author Lohit
 */
public class SnoopCard implements ActionCard 
{
    /**
     * Description of a regular snoop Card 
     */
    private final String snoop = "Snoop on any player's hand";
    /**
     * Description of an All snoop on player's to the Left Card 
     */
    private final String leftAllSnoop = "All Snoop on player's hand to LEFT";
    /**
     * Description of an All snoop on player's to the Right Card 
     */
    private final String rightAllSnoop = "All Snoop on player's hand to RIGHT";
    /**
     * Direction of an All snoop Action Card. Null if regular snoop Card 
     */
    private Direction direction;
    /**
    * true if this card is face up, false if not
    */
    private boolean showing;
    /**
     * The path to the image of this suspect.
     */
    private final String imagePath;
    
    /**
     * Default Constructor for a regular snoop Action Card.
     * 
     * @param imagePath file path to the image
     */
    public SnoopCard(String imagePath) 
    {
        this.imagePath = imagePath;
        // SET direction to NULL
        this.direction = null;
        // SET showing as false
        this.showing = false;
    }

    /**
     * Constructor for an All snoop Action Card.
     *
     * @param direction the Direction of the All snoop.
     * @param imagePath the file path to the image 
     */
    public SnoopCard(Direction direction, String imagePath) 
    {
        this(imagePath);
        // SET this object's direction to the parameter's direction
        this.direction = direction;
    }

    /**
     * Returns the Direction of this snoop Card.
     *
     * @return the Direction of the snoop Card. Null if not applicable, i.e.
     * regular snoop Card
     */
    public Direction getDirection() 
    {
        // RETURN direction
        return this.direction;
    }

    /**
     * Returns the description of this snoop Card.
     *
     * @return a String of this Card's description
     */
    public String getActionText() 
    {
        // IF direction is null THEN
        if (this.direction == null) 
        {
            // RETURN snoop
            return snoop;
        }
        // ELSE IF direction is left THEN
        else if (!this.direction.isRight()) 
        {
            // RETURN LeftAllSnoop
            return leftAllSnoop;
        }
        // ELSE
        else 
        {
            // RETURN RightAllSnoop
            return rightAllSnoop;
        }
        //ENDIF
    }

    /**
     * Returns if this snoop Card is an All snoop.
     *
     * @return true if this card is an All snoop
     */
    public boolean isAllSnoop() 
    {
        return this.direction != null;
    }

    /**
     * Access to the name of this card
     * 
     * @return the name of this card as a string
     */
    @Override
    public String getName() 
    {
        // IF direction is null THEN
        if (this.direction == null) 
        {
            // RETURN a string with the characters "snoop Card"
            return "Snoop Card";
        }
        // ELSE
        else 
        {
            // RETURN a string with the characters "All snoop Card"
            return "All Snoop Card";
        }
        // END IF
        // IF direction is null THEN
            // RETURN a string with the characters "snoop Card"
        // ELSE
            // RETURN a string with the characters "All snoop Card"
        // END IF
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
     * Returns the image path for the snoop card
     * @return the file path string if the image
     */
    @Override
    public String getImagePath() 
    {
        return imagePath;
    }
}
