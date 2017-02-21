package tegakari;

import java.io.Serializable;
import java.util.List;

/**
 * Suspect is a datatype, represent a suspect of the Clue game.
 *
 * @author Lohit
 * @author Anh Nguyen
 * @author Tarrant Starck - pseudocode
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class Suspect implements Serializable 
{
    /**
     * The name of the suspect.
     */
    private final String name;
    /**
     * The list of characteristics of this suspect.
     */
    private List<Attribute> attributes;

    /**
     * The path to the image of this suspect.
     */
    private final String imagePath;

    /**
     * Constructor with a specific name of the suspect and its <code>Attribute</code>.
     *
     * @param name is the name of the suspect
     * @param attributes is the <code>Attribute</code> of this suspect
     * @param imagePath name to the image of the <code>Suspect</code>
     */
    public Suspect(String name, List<Attribute> attributes, String imagePath) 
    {
        // CREATE the Suspect with the given parameters
        // SET the name of this class with the name provided
        this.name = name;
        // SET the attributes of this class with attributes provided
        this.attributes = attributes;
        // SET the imagePath of this class with the string provided
        this.imagePath = imagePath;
    }

    /**
     * Access to the name of this suspect.
     *
     * @return the name of this suspect as a string
     */
    public String getName() 
    {
        // RETURN the name of the Suspect
        return name;
    }
    
    /**
     * Returns the image path of the vehicle.
     * 
     * @return the image path
     */
    public String getImagePath()
    {
        return imagePath;
    }

    /**
     * Access to the <code>Attribute</code> of the suspect.
     *
     * @return the <code>Attribute</code> of this suspect as a list of attributeEnum
     */
    public List<Attribute> getAttributes() 
    {
        // RETURN the list of Attributes
        return attributes;
    }
    
    /**
     * Sees if two <code>Suspect</code>s are equal to eachother
     * @param sct Suspect to compare to
     * @return if they are equal or not
     */
    public boolean equals(Object sct) 
    {
        boolean out = false;
        int count = 0;
        // check if null and instanceof
        if (sct != null && sct instanceof Suspect) 
        {
            Suspect sus = (Suspect) sct;
            // make sure that they have the same name
            if (this.name.equals(sus.name)) 
            {
                // make sure that they have the same imagePath
                if (this.imagePath.equals(sus.imagePath)) 
                {
                    // make sure that they have the same number of attributes
                    if (this.attributes.size() == sus.attributes.size()) 
                    {
                        // make sure the attributes are the same
                        for (int iLoop = 0; iLoop < this.attributes.size(); iLoop++) 
                        {
                            // compare attributes
                            if (this.attributes.contains(sus.attributes.get(iLoop))) 
                            {
                                count++;
                            }
                        }
                        // check to make sure all attributes were the same
                        if (count == this.attributes.size()) 
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
