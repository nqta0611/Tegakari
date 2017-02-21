package tegakari;

import java.io.Serializable;
import java.util.List;

/**
 * Destination is a datatype, represent a destination of the Clue game
 *
 * @author Lohit
 * @author Anh Nguyen
 * @author Tarrant Starck - pseudocode
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class Destination implements Serializable 
{

    /**
     * The name of the destination.
     */
    private final String name;
    /**
     * The list of characteristics of this destination.
     */
    private List<Attribute> attributes;

    /**
     * The path to the image of this destination.
     */
    private final String imagePath;

    /**
     * Constructor with a specific name of the destination and 
     * its <code>Attribute</code>.
     *
     * @param name is the name of the destination
     * @param attributes is the <code>Attribute</code> of this destination
     * @param imagePath  the path to the image
     */
    public Destination(String name, List<Attribute> attributes, String imagePath) 
    {
        // CREATE the Destination with the given paramiters
        // SET the name of this class with the name provided
        this.name = name;
        // SET the attributes of this class with attributes provided
        this.attributes = attributes;
        // SET the imagePath of this class with the String provided
        this.imagePath = imagePath;
    }

    /**
     * Access to the name of this destination.
     *
     * @return the name of this destination as a string
     */
    public String getName() 
    {
        // RETURN the name
        return name;
    }
    
    /**
     * Returns the image path for this destination.
     * 
     * @return the image path
     */
    public String getImagePath()
    {
        return imagePath;
    }

    /**
     * Access to the <code>Attribute</code> of the destination.
     *
     * @return the <code>Attribute</code> of this destination as a list of attributeEnum
     */
    public List<Attribute> getAttributes() 
    {
        // RETURN the list of Attributes
        return attributes;
    }
    
    /**
     * Sees if two <code>Destination</code>s are equal to eachother
     * @param destination Destination to compare to
     * @return if they are equal or not
     */
    public boolean equals(Object destination) 
    {
        boolean out = false;
        int count = 0;
        // check if null and instanceof
        if (destination != null && destination instanceof Destination) 
        {
            Destination dest = (Destination) destination;
            // make sure that they have the same name
            if (this.name.equals(dest.name)) 
            {
                // check if they have the same imagePaths
                if (this.imagePath.equals(dest.imagePath)) 
                {
                    // make sure that they have the same number of attributes
                    if (this.attributes.size() == dest.attributes.size()) 
                    {
                        // make sure the attributes are the same
                        for (int iLoop = 0; iLoop < this.attributes.size(); iLoop++) 
                        {
                            // compare attributes
                            if (this.attributes.contains(dest.attributes.get(iLoop))) 
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
