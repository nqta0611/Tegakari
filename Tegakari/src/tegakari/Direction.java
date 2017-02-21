package tegakari;

import java.io.Serializable;

/**
 * The Direction enum class represents the direction of an All-Snoop Action
 * Card.
 *
 * @author Lohit
 */
public enum Direction implements Serializable 
{

    /**
     * The direction that the All-Snoop Action Card will be in.
     *
     */
    LEFT(false),
    /**
     * The direction that the All-Snoop Action Card will be in.
     */
    RIGHT(true);
    /**
     * True if the direction is to the right. False if the direction is to the
     * left.
     */
    private boolean direction;

    /**
     * Constructor for a direction.
     *
     * @param direction true if direction is to the right
     */
    Direction(boolean direction)
    {
        // SET this object's direction to the parameter's direction
        this.direction = direction;
    }
    
    /**
     * Method in enum to find out if the direction is right
     * 
     * @return boolean that says if the current direction is right or not
     */
    public boolean isRight()
    {
        return direction;
    }
    
    /**
     * The String form of the enum.
     * 
     * @return String form of the enum
     */
    public String toString()
    {
        // CHECK if the RIGHT enum
        if (this == RIGHT)
        {
            return "Right";
        }
        else
        {
            return "Left";
        }
    }
    
}
