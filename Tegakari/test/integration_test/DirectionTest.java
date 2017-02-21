package integration_test;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import tegakari.Direction;

/**
 *
 * @author cathibod
 */
public class DirectionTest extends TestCase {
    
    public DirectionTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class Direction.
     */
    public void testValues() {
        System.out.println("values");
        List<Direction> result = Arrays.asList(Direction.values());
        
        assertTrue(result.contains(Direction.LEFT));
        assertTrue(result.contains(Direction.RIGHT));
    }

    /**
     * Test of valueOf method, of class Direction.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
    }

    /**
     * Test of isRight method, of class Direction.
     */
    /*public void testIsRight() {
        System.out.println("isRight");
        Direction instance = null;
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toString method, of class Direction.
     */
    /*public void testToString() {
        System.out.println("toString");
        Direction instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
