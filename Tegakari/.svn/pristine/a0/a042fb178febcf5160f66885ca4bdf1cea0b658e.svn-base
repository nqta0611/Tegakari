package tegakari;

import java.io.Serializable;
import java.util.List;
/**
 * Vehicle represents part of the needed <code>Solution</code>.
 * @author Lohit
 * @author Anh Nguyen
 * @author Tarrant Starck - pseudocode
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class Vehicle implements Serializable 
{
    /**
     * The name of the <code>Vehicle</code>.
     */
    private String name;
    /**
     * The list of characteristics of this <code>Vehicle</code>.
     */
    private List<Attribute> attributes;

    /**
     * The path to the image of the <code>Vehicle</code>.
     */
    private final String imagePath;
    
    /**
     * Constructor with a specific name of the <code>Vehicle</code> 
     * and its <code>Attribute</code>.
     * @param name is the name of this <code>Vehicle</code>
     * @param attributes is the characteristic of that <code>Vehicle</code>
     * @param imagePath path to the image of the <code>Vehicle</code>
     */
    public Vehicle(String name, List<Attribute> attributes, String imagePath) 
    {
        // SET the name of this class with the name provided
        this.name = name;
        // SET the attributes of this class with attributes provided
        this.attributes = attributes;
        // SET the imagePath of this class with the String provided
        this.imagePath = imagePath;
    }

    /**
     * Retrieves to the name of the vehicle.
     * @return the name of the vehicle as a string
     */
    public String getName() 
    {
        // RETURN the name of the Vehicle
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
     * Retrieves to the <code>Attribute</code> of the vehicle.
     * @return the <code>Attribute</code> of <code>Vehicle</code> as a 
     * list of <code>Attribute</code>
     */
    public List<Attribute> getAttributes() 
    {
        // RETURN the Attributes
        return attributes;
    }
    
    /**
     * Sees if two <code>Vehicle</code>s are equal to eachother
     * @param vehicle the vehicle to compare to
     * @return if they are equal or not
     */
    public boolean equals(Object vehicle) 
    {
        boolean out = false;
        // checks if null and instance of
        if (vehicle != null && vehicle instanceof Vehicle) 
        {
            Vehicle veh = (Vehicle) vehicle;
            int count = 0;
            // make sure that they have the same name
            if (this.name.equals(veh.name)) 
            {
                // make sure that they have the same imagePath
                if (this.imagePath.equals(veh.imagePath)) 
                {
                    // make sure that they have the same number of attributes
                    if (this.attributes.size() == veh.attributes.size()) 
                    {
                        // make sure the attributes are the same
                        for (int iLoop = 0; iLoop < this.attributes.size(); iLoop++) 
                        {
                            // compare attributes
                            if (this.attributes.contains(veh.attributes.get(iLoop))) 
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
