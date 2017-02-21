package integration_test;

import junit.framework.TestCase;
import tegakari.AILevel;

/**
 *
 * @author cathibod
 */
public class AILevelTest extends TestCase {
    
    public AILevelTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class AILevel.
     */
    /*public void testValues() {
        System.out.println("values");
        AILevel[] expResult = null;
        AILevel[] result = AILevel.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of valueOf method, of class AILevel.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        assertEquals(AILevel.BASIC, AILevel.valueOf("BASIC"));
        assertEquals(AILevel.SMART, AILevel.valueOf("SMART"));
    }

    /**
     * Test of getDescription method, of class AILevel.
     */
    /*public void testGetDescription() {
        System.out.println("getDescription");
        AILevel instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
