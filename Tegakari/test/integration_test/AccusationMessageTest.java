package integration_test;

import java.util.ArrayList;
import junit.framework.TestCase;
import tegakari.AccusationMessage;
import tegakari.*;

/**
 *
 * @author cathibod
 */
public class AccusationMessageTest extends TestCase {
    
    public AccusationMessageTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    

    /**
     * Test of getAccusation method, of class AccusationMessage.
     */
    /*public void testGetAccusation() {
        System.out.println("getAccusation");
        AccusationMessage instance = null;
        Solution expResult = null;
        Solution result = instance.getAccusation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getCreator method, of class AccusationMessage.
     */
    /*public void testGetCreator() {
        System.out.println("getCreator");
        AccusationMessage instance = null;
        Player expResult = null;
        Player result = instance.getCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    

    /**
     * Test of get/setShowTo method, of class AccusationMessage.
     */
    /*public void testSetShowTo() {
        System.out.println("setShowTo");
        Player showTo = null;
        AccusationMessage instance = null;
        instance.setShowTo(showTo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/


    /**
     * Test of get/setSolution method, of class AccusationMessage.
     */
    public void testSetSolution() {
        System.out.println("setSolution");
        Solution solution = new Solution(new Suspect("suspect",new ArrayList<Attribute>(),""), 
                                        new Vehicle("vehicle",new ArrayList<Attribute>(),""), 
                                        new Destination("dest",new ArrayList<Attribute>(),""));
        AccusationMessage instance = new AccusationMessage(null, null, null);
        instance.setSolution(solution);
        assertEquals(solution, instance.getSolution());
    }

    /**
     * Test of setIsCorrect method, of class AccusationMessage.
     */
    /*public void testSetIsCorrect() {
        System.out.println("setIsCorrect");
        boolean isCorrect = false;
        AccusationMessage instance = null;
        instance.setIsCorrect(isCorrect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
