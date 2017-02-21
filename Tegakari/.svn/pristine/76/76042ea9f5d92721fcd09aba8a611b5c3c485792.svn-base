package tegakari;

import java.io.Serializable;

/**
 * A solution of which suspect, vehicle, and destination.
 *
 * @author Lohit
 * @author Tarrant Starck - pseudocode
 */
public class Solution implements Serializable 
{

    /**
     * The <code>Suspect</code> chosen.
     */
    private Suspect suspect;
    /**
     * The <code>Vehicle</code> chosen.
     */
    private Vehicle vehicle;
    /**
     * The <code>Destination</code> chosen.
     */
    private Destination destination;

    /**
     * Constructs the solution of the game from given variables.
     *
     * @param suspect the <code>Suspect</code> of the solution
     * @param vehicle the <code>Vehicle</code> of the solution
     * @param destination the <code>Destination</code> of the solution
     */
    public Solution(Suspect suspect, Vehicle vehicle, Destination destination) 
    {
        // CREATE the Solution with the given paramiters by
        // SETTING the private variables equal to them
        this.suspect = suspect;
        this.vehicle = vehicle;
        this.destination = destination;
    }

    /**
     * Gets the <code>Suspect</code> of the solution.
     *
     * @return the <code>Suspect</code>
     */
    public Suspect getSuspect() 
    {
        //RETURN the Suspect of this solution
        return this.suspect;
    }

    /**
     * Gets the <code>Vehicle</code> of the solution.
     *
     * @return the <code>Vehicle</code>
     */
    public Vehicle getVehicle() 
    {
        //RETURN the Vehicle of this solution
        return this.vehicle;
    }

    /**
     * Gets the <code>Destination</code> of the solution.
     *
     * @return the <code>Destination</code>
     */
    public Destination getDestination() 
    {
        //RETURN the Destination of this solution
        return this.destination;
    }

    /**
     * Compares <code>Solution</code>s to see if the cards in them are equal
     * @param solution to compare to
     * @return if they are equal or not
     */
    @Override
    public boolean equals(Object solution) 
    {
        boolean out = false;
        // check for type
        if (solution != null && solution instanceof Solution) 
        {
            Solution sol = (Solution) solution;
            // comparing suspect
            if (this.suspect.equals(sol.getSuspect())) 
            {
                // compare vehicles
                if (this.vehicle.equals(sol.getVehicle())) 
                {
                    // compare destinations
                    if (this.destination.equals(sol.getDestination())) 
                    {
                        // if it got in here they are equal
                        out = true;
                    }
                }
            }
        }
        return out;
    }
    /**
     * To string method to print out this solution
     * @return the string represent this solution
     */
    @Override
    public String toString() 
    {
        return suspect.getName() + 
               ", " + vehicle.getName() + 
               ", " + destination.getName();
    }
}
