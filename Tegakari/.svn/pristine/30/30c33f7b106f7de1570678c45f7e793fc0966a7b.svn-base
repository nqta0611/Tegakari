package tegakari;

import java.util.List;

/**
 * VehicleCard is the type of
 * <code>ClueCard</code>, representing the
 * <code>Vehicle</code>.
 *
 * @author Lohit
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Adding java doc (draft)
 */
public class VehicleCard implements ClueCard 
{
    /**
     * Type of this clue card is Vehicle clue card
     */
    private ClueType type;
    /**
     * The <code>Vehicle</code> which this card represent
     */
    private Vehicle vehicle;
    /**
     * indicates if this card is face up
     */
    private boolean isFaceUp;

    /**
     * Constructing a VehicleCard with an instant of vehicle.
     *
     * @param vehicle is the specific vehicle which this card represent
     */
    public VehicleCard(Vehicle vehicle) 
    {
        // SET vehicle of card to the vehicle provided
        this.vehicle = vehicle;
        // SET ClueType of this card to Vehicle
        type = ClueType.VEHICLE;
        // SET isFaceUp to false
        isFaceUp = false;
    }

    /**
     * Access to the attribute of this card.
     *
     * @return the attribute of this card as a list of Attribute
     */
    @Override
    public List<Attribute> getAttribute() 
    {
        // RETURN the atributes using vehicles accessor method
        return vehicle.getAttributes();
    }

    /**
     * Access to the clue type of this card.
     *
     * @return the ClueType represent this card
     */
    @Override
    public ClueType getClueType() 
    {
        // RETURN the ClueType of this card
        return type;
    }

    /**
     * Checking method to check if the card is showing or not.
     *
     * @return the boolean indicate if the card is showing or not
     */
    @Override
    public boolean isShowing() 
    {
        return isFaceUp;
    }

    /**
     * Access to the name of the card.
     *
     * @return the name of this vehicle card as a string
     */
    @Override
    public String getName() 
    {
        // RETURN the name using vehicles accessor method
        return vehicle.getName();
    }
    
    /**
     * Set this card to face up.
     */
    public void makeFaceUp() 
    {
        // SET isFaceUp to true
        isFaceUp = true;
    }

    /**
     * Set this card to face down.
     */
    public void makeFaceDown() 
    {
        // SET isFaceUp to false
        isFaceUp = false;
    }

    /**
     * Returns the fileName of the image.
     * The Theme contains the path to the folder it is in.
     * @return the image path
     */
    public String getImagePath() 
    {
        return this.vehicle.getImagePath();
    }
    
    /**
     * Checks if the two cards are equal.
     * @param o the <code>VehicleCard</code> to compare to
     * @return if they are equal or not
     */
    public boolean equals(Object o) 
    {
        boolean out = false;
        // checks if null and instance of
        if (o != null && o instanceof VehicleCard) 
        {
            VehicleCard veh = (VehicleCard) o;
            out = this.vehicle.equals(veh.vehicle);
        }
        return out;
    }
     /**
     * Retrieve the suspect of this card
     * @return the suspect
     */
    public Vehicle getVehicle() 
    {
        return this.vehicle;
    }
}
