package integration_test;

import java.util.List;
import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for DMPile.
 * @author roh
 */
public class DMPileTest extends TestCase 
{
    private DMPile pile;
    private Theme theme;
    
    public DMPileTest(String testName) 
    {
        super(testName);
        
        theme = new Theme();
        pile = new DMPile(theme);
    }

    /**
     * Test of addDM method, of class DMPile.
     */
    public void testAddDM() 
    {
        System.out.println("addDM");
        
        assertEquals(theme.getDestinations(), pile.getPile());
        pile.cleanPile();
        assertFalse(pile.getPile().contains(theme.getDestinations().get(0)));
        pile.addDM(theme.getDestinations().get(0));
        assertTrue(pile.getPile().contains(theme.getDestinations().get(0)));
    }

    /**
     * Test of removeFromPile method, of class DMPile.
     */
    public void testRemoveFromPile() 
    {
        System.out.println("removeFromPile");
        
        assertEquals(9, pile.getPile().size());
        pile.removeFromPile(theme.getDestinations().get(0));
        
        assertEquals(8, pile.getPile().size());
        assertFalse(pile.getPile().contains(theme.getDestinations().get(0)));
    }

    /**
     * Test of removeTopCard method, of class DMPile.
     */
    public void testRemoveTopCard() 
    {
        System.out.println("removeTopCard");
        
        assertEquals(9, pile.getPile().size());
        pile.removeTopCard();
        
        assertEquals(8, pile.getPile().size());
        assertFalse(pile.getPile().contains(theme.getDestinations().get(0)));
    }

    /**
     * Test of containsDestination method, of class DMPile.
     */
    public void testContainsDestination() 
    {
        System.out.println("containsDestination");
        
        assertTrue(pile.containsDestination(theme.getDestinations().get(0)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(1)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(2)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(3)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(4)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(5)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(6)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(7)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(8)));
        
        pile.cleanPile();
        
        assertFalse(pile.containsDestination(theme.getDestinations().get(0)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(1)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(2)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(3)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(4)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(5)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(6)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(7)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(8)));
    }

    /**
     * Test of getPile method, of class DMPile.
     */
    public void testGetPile() 
    {
        System.out.println("getPile");
        
        assertEquals(theme.getDestinations(), pile.getPile());
    }

    /**
     * Test of cleanPile method, of class DMPile.
     */
    public void testCleanPile() 
    {
        System.out.println("cleanPile");
        
        assertTrue(pile.containsDestination(theme.getDestinations().get(0)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(1)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(2)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(3)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(4)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(5)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(6)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(7)));
        assertTrue(pile.containsDestination(theme.getDestinations().get(8)));
        
        pile.cleanPile();
        
        assertFalse(pile.containsDestination(theme.getDestinations().get(0)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(1)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(2)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(3)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(4)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(5)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(6)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(7)));
        assertFalse(pile.containsDestination(theme.getDestinations().get(8)));
    }

    /**
     * Test of equals method, of class DMPile.
     */
    public void testEquals() 
    {
        System.out.println("equals");
        
        DMPile diffPile = new DMPile(theme);
        diffPile.removeTopCard();
        
        assertFalse(pile.equals(null));
        assertFalse(pile.equals(this));
        assertFalse(pile.equals(diffPile));
        assertTrue(pile.equals(pile));
    }
    
    public void testShuffle()
    {
        System.out.println("shuffle");
        
        DMPile diffPile = new DMPile(theme);
        diffPile.shuffle();
        assertEquals(9, diffPile.getPile().size());
    }
}
