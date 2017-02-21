package tegakari;

import java.io.Serializable;

/**
 * Attribute of a <code>ClueCard</code>. 
 * These are characteristics of a <code>ClueCard</code>
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public enum Attribute implements Serializable 
{

    /**
     * Attribute for <code>Suspect</code>
     */
    MALE("male"), 
    /**
     * Attribute for <code>Suspect</code>
     */
    FEMALE("female"),
    /**
     * Attribute for <code>Vehicle</code>
     */
    FLYING("flying"),
    /**
     * Attribute for <code>Vehicle</code>
     */
    GROUND("ground"), 
    /**
     * Attribute for <code>Vehicle</code>
     */
    BLUE("blue"), 
    /**
     * Attribute for <code>Vehicle</code>
     */
    RED("red"),
    /**
     * Attribute for <code>Destination</code>
     */
    SOUTHERN("southern"),
    /**
     * Attribute for <code>Destination</code>
     */
    WESTERN("western"), 
    /**
     * Attribute for <code>Destination</code>
     */
    NORTHERN("northern"), 
    /**
     * Attribute for <code>Destination</code>
     */
    EASTERN("eastern");
    /**
     * The description of the characteristic.
     */
    private String description;

    /**
     * Constructor of the Attribute which take in the description
     *
     * @param description is a string which describe this Attribute
     */
    private Attribute(String description) 
    {
        // SET the description of each Attribute based on enum declaration
        this.description = description;
    }

    /**
     * Access to the description of this Attribute
     *
     * @return the description of this Attribute as a string
     */
    public String getDescription() 
    {
        //GET the description of the attribute set in Enum
        return description;
    }
}
