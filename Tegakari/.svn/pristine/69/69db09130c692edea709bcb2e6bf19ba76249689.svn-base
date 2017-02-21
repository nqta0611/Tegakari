package integration_test;

import java.util.List;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import tegakari.Vehicle;
import tegakari.VehicleCard;

/**
 *
 * @author cathibod
 */
public class VehicleCardTest extends TestCase {
    
    public VehicleCardTest(String testName) {
        super(testName);
    }

    /**
     * Test of getAttribute method, of class VehicleCard.
     */
    /*public void testGetAttribute() {
        System.out.println("getAttribute");
        VehicleCard instance = null;
        List expResult = null;
        List result = instance.getAttribute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getClueType method, of class VehicleCard.
     */
    /*public void testGetClueType() {
        System.out.println("getClueType");
        VehicleCard instance = null;
        ClueType expResult = null;
        ClueType result = instance.getClueType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of makeFaceUp, makeFaceDown, isShowing method, 
     * of class VehicleCard.
     */
    public void testIsShowing() {
        System.out.println("isShowing");
        VehicleCard instance = new VehicleCard(null);
        assertFalse(instance.isShowing());
        instance.makeFaceUp();
        assertTrue(instance.isShowing());
        instance.makeFaceDown();
        assertFalse(instance.isShowing());
    }

    /**
     * Test of getName method, of class VehicleCard.
     */
    /*public void testGetName() {
        System.out.println("getName");
        VehicleCard instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getImagePath method, of class VehicleCard.
     */
    public void testGetImagePath() {
        System.out.println("getImagePath");
        VehicleCard instance = new VehicleCard(new Vehicle("vehicle",null,"imgPath"));
        assertEquals("imgPath", instance.getImagePath());
    }

    /**
     * Test of equals method, of class VehicleCard.
     */
    /*public void testEquals() {
        System.out.println("equals");
        Object o = null;
        VehicleCard instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getVehicle method, of class VehicleCard.
     */
    /*public void testGetVehicle() {
        System.out.println("getVehicle");
        VehicleCard instance = null;
        Vehicle expResult = null;
        Vehicle result = instance.getVehicle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
