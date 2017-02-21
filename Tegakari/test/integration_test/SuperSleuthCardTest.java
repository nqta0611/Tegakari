package integration_test;

import junit.framework.TestCase;
import tegakari.Attribute;
import tegakari.ClueType;
import tegakari.SuperSleuthCard;

/**
 *
 * @author cathibod
 */
public class SuperSleuthCardTest extends TestCase {
    
    public SuperSleuthCardTest(String testName) {
        super(testName);
    }

    /**
     * Test of getActionText method, of class SuperSleuthCard.
     */
    /*public void testGetActionText() {
        System.out.println("getActionText");
        SuperSleuthCard instance = null;
        String expResult = "";
        String result = instance.getActionText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getClueType method, of class SuperSleuthCard.
     */
    /*public void testGetClueType() {
        System.out.println("getClueType");
        SuperSleuthCard instance = null;
        ClueType expResult = null;
        ClueType result = instance.getClueType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getAttribute method, of class SuperSleuthCard.
     */
    /*public void testGetAttribute() {
        System.out.println("getAttribute");
        SuperSleuthCard instance = null;
        Attribute expResult = null;
        Attribute result = instance.getAttribute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getName method, of class SuperSleuthCard.
     */
    public void testGetName() {
        System.out.println("getName");
        SuperSleuthCard instance = new SuperSleuthCard(ClueType.DESTINATION,
                null,"");
        assertEquals("Super Sleuth Card", instance.getName());
    }

    /**
     * Test of makeFaceUp, makeFaceDown, isShowing method, 
     * of class SuperSleuthCard.
     */
    public void testIsShowing() {
        System.out.println("isShowing");
        SuperSleuthCard instance = new SuperSleuthCard(ClueType.DESTINATION,
                null,"");
        assertFalse(instance.isShowing());
        instance.makeFaceUp();
        assertTrue(instance.isShowing());
        instance.makeFaceDown();
        assertFalse(instance.isShowing());
    }
    
    /**
     * Test of getImagePath method, of class SuperSleuthCard.
     */
    /*public void testGetImagePath() {
        System.out.println("getImagePath");
        SuperSleuthCard instance = null;
        String expResult = "";
        String result = instance.getImagePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
