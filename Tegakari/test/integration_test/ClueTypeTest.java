package integration_test;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import tegakari.ClueType;

/**
 *
 * @author cathibod
 */
public class ClueTypeTest extends TestCase {
    
    public ClueTypeTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class ClueType.
     */
    public void testValues() {
        System.out.println("values");
        List<ClueType> result = Arrays.asList(ClueType.values());
        
        assertTrue(result.contains(ClueType.DESTINATION));
        assertTrue(result.contains(ClueType.SUSPECT));
        assertTrue(result.contains(ClueType.VEHICLE));
    }

    /**
     * Test of valueOf method, of class ClueType.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        assertEquals(ClueType.DESTINATION, ClueType.valueOf("DESTINATION"));
        assertEquals(ClueType.SUSPECT, ClueType.valueOf("SUSPECT"));
        assertEquals(ClueType.VEHICLE, ClueType.valueOf("VEHICLE"));
    }

    /**
     * Test of getDescription method, of class ClueType.
     */
    /*public void testGetDescription() {
        System.out.println("getDescription");
        ClueType instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
