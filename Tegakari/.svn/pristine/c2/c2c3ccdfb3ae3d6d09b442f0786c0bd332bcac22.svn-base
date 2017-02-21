package integration_test;

import junit.framework.TestCase;
import tegakari.Direction;
import tegakari.SnoopCard;

/**
 *
 * @author cathibod
 */
public class SnoopCardTest extends TestCase {
    
    public SnoopCardTest(String testName) {
        super(testName);
    }

    /**
     * Test of getDirection method, of class SnoopCard.
     */
    /*public void testGetDirection() {
        System.out.println("getDirection");
        SnoopCard instance = null;
        Direction expResult = null;
        Direction result = instance.getDirection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getActionText method, of class SnoopCard.
     */
    public void testGetActionText() {
        System.out.println("getActionText");
        SnoopCard instance = new SnoopCard(Direction.RIGHT, "");
        assertEquals("All Snoop on player's hand to RIGHT", instance.getActionText());
    }

    /**
     * Test of isAllSnoop method, of class SnoopCard.
     */
    /*public void testIsAllSnoop() {
        System.out.println("isAllSnoop");
        SnoopCard instance = null;
        boolean expResult = false;
        boolean result = instance.isAllSnoop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getName method, of class SnoopCard.
     */
    public void testGetName() {
        System.out.println("getName");
        SnoopCard instance = new SnoopCard("");
        SnoopCard instance1 = new SnoopCard(Direction.RIGHT, "");
        assertEquals("Snoop Card", instance.getName());
        assertEquals("All Snoop Card", instance1.getName());
    }

    /**
     * Test of makeFaceUp, makeFaceDown, isShowing method, 
     * of class SnoopCard.
     */
    public void testIsShowing() {
        System.out.println("isShowing");
        SnoopCard instance = new SnoopCard("");
        assertFalse(instance.isShowing());
        instance.makeFaceUp();
        assertTrue(instance.isShowing());
        instance.makeFaceDown();
        assertFalse(instance.isShowing());
    }

    /**
     * Test of getImagePath method, of class SnoopCard.
     */
    /*public void testGetImagePath() {
        System.out.println("getImagePath");
        SnoopCard instance = null;
        String expResult = "";
        String result = instance.getImagePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
