package tegakari;

import java.io.Serializable;

/**
 * ClueType of a card determine either this clue card is Suspect, Vehicle, 
 * or Destination card.
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public enum ClueType implements Serializable 
{

    /**
     * Type of clue is a suspect
     */
    SUSPECT("Suspect"), 
    /**
     * Type of clue is a vehicle
     */
    VEHICLE("Vehicle"), 
    /**
     * Type of clue is a destination
     */
    DESTINATION("Destination");
    /**
     * The description of the clue type.
     */
    private String description;

    /**
     * Constructor of the ClueType which take in the description
     *
     * @param description is a string which describe this ClueType
     */
    private ClueType(String description) 
    {
        // SET the description of each ClueType based on enum declaration
        this.description = description;
    }

    /**
     * Access to the description of this ClueType
     *
     * @return the description of this ClueType as a string
     */
    public String getDescription() 
    {
        //GET the description of the ClueType set in Enum
        return description;
    }
}
