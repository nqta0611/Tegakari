
package tegakari;

import java.io.Serializable;

/**
 * Represent the intelligent level of a <code>Robot</code>.
 * @author anhnguyen
 */
public enum AILevel implements Serializable
{
    
    /**
     * Basic AI level
     */
    BASIC("Basic"), 
    /**
     * Smart AI level
     */
    SMART("Smart");
    
    /**
     * The description of the AI level.
     */
    private String description;

    /**
     * Constructor of the IALevel which take in the description
     *
     * @param description is a string which describe this AILevel
     */
    private AILevel(String description) 
    {
        // SET the description of each AILevel based on enum declaration
        this.description = description;
    }

    /**
     * Access to the description of this AILevel
     *
     * @return the description of this AILevel as a string
     */
    public String getDescription() 
    {
        //GET the description of the AILevel set in Enum
        return description;
    }
    
}
