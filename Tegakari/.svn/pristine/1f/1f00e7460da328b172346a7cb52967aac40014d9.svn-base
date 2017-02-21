package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The DMPile will hold all the <code>Destination</code>s that players can be 
 * located at and will allow for manipulation of this pile such as 
 * Add and Remove. Also contains methods that allow for the 
 * graphical aspect of this Pile
 *
 * @author Lohit
 */
public class DMPile implements Serializable 
{

    /**
     * List of <code>Destination</code>s that represent the markers
     * <code>Player</code>s can have.
     */
    private List<Destination> destinationMarkers;

    /**
     * Will construct an initial list of all the <code>Destination</code>s
     * that are in the game using a <code>Theme</code>
     * object that contains this information.
     *
     * @param theme The <code>Theme</code> has a list of all the
     * <code>Destination</code>s that exist in
     * the game.
     */
    public DMPile(Theme theme) 
    {
        ArrayList<Destination> deepcopy = new ArrayList<Destination>();
        //For each destination
        for (Destination temp : theme.getDestinations()) 
        {
            deepcopy.add(temp);
        }
        //INIT destinationMarkers with theme's getDestination method call
        this.destinationMarkers = deepcopy;
    }
    
    /**
     * Shuffles the destination markers.
     */
    public void shuffle() 
    {
        Collections.shuffle(destinationMarkers);
    }

    /**
     * Adds a <code>Destination</code>s to the list of DestinationMarkers
     *
     * @param destination The <code>Destination</code> to be added
     */
    public void addDM(Destination destination) 
    {
        //ADD destination to destinationMarkers list
        destinationMarkers.add(destination);
    }

    /**
     * Removes a <code>Destination</code> from list of DesitnationMarkers.
     *
     * @param destination The <code>Destination</code> to remove from list
     * @return true if <code>Destination</code> was
     * found and removed, false otherwise
     */
    public boolean removeFromPile(Destination destination) 
    {
        //RETURN remove call on destinationMarkers, using destination
        boolean out = false;
        // check if there is the destination
        if (destinationMarkers.contains(destination))
        {
            out = true;
            destinationMarkers.remove(destination);
        }
        return out;
    }
    
    /**
     * Removes the top card destination the Destination Markers Pile.
     *
     * @return the top Destination marker
     */
    public Destination removeTopCard() 
    {
        return destinationMarkers.remove(0);
    }
    
    /**
     * Checks if <code>Destination</code> is in the DM pile or not
     *
     * @param marker The <code>Destination</code> to check if in the pile
     * @return true or false depending on if marker is in the pile
     */
    public boolean containsDestination(Destination marker) 
    {
        return this.destinationMarkers.contains(marker);
    }
    
    /**
     * Gets the DMPile, mostly used for GUI interface
     *
     * @return list of Destinations stored in the Destination Pile
     */
    public List<Destination> getPile() 
    {
        return new ArrayList<Destination>(destinationMarkers);
    }
    
    /**
     * Clears the DMPile for ordered DMPile construction
     */
    public void cleanPile()
    {
        this.destinationMarkers.clear();
    }
    
    
    /**
     * Returns if this DMPile is equal to the parameter DMPile
     *@param other is the other DMPile to be compare
     * @return if the two DMPile objects are equal to each other or not
     */
    @Override
    public boolean equals(Object other)
    {
        // check null
        if (other == null) 
        {
            return false;
        }
        // check type
        if (!(other instanceof DMPile)) 
        {
            return false;
        }
        DMPile test = (DMPile)other;
        // check markers
        if (!this.destinationMarkers.equals(test.getPile())) 
        {
            return false;
        }
        return true;
    }
}
