/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;
import java.util.ArrayList;
import tegakari.*;
import java.util.List;
import junit.framework.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author anhnguyen
 */
public class SolutionTest extends TestCase {
    
    public SolutionTest() {
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    
    public void testConstructor () {
        Suspect suspect = mock(Suspect.class);
        Vehicle vehicle = mock(Vehicle.class);
        Destination dest = mock(Destination.class);
        
        Solution solution = new Solution (suspect, vehicle, dest);
        assertEquals(suspect, solution.getSuspect());
        assertEquals(vehicle, solution.getVehicle());
        assertEquals(dest, solution.getDestination());
    }
    
    public void testEquals () 
    {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.FEMALE);
        
        Suspect suspect = new Suspect("Aphrodite", attributes, "pathS1");
        Vehicle vehicle = new Vehicle("Aphrodite", attributes, "pathS1");
        Destination dest = new Destination("Aphrodite", attributes, "pathS1");
        
        attributes.remove(Attribute.FEMALE);
        attributes.add(Attribute.MALE);
        Suspect suspect2 = new Suspect("Aphrodite2", attributes, "pathS2");
        Vehicle vehicle2 = new Vehicle("Aphrodite2", attributes, "pathS2");
        Destination dest2 = new Destination("Aphrodite2", attributes, "pathS2");
        
        Solution solution = new Solution(suspect, vehicle, dest);
        
        Solution solution2 = new Solution(suspect, vehicle, dest);
        assertEquals(solution, solution2);
        
        solution2 = null;
        assertFalse(solution.equals(solution2));
        
        solution2 = new Solution(suspect2, vehicle, dest);
        assertFalse(solution.equals(solution2));
        
        solution2 = new Solution(suspect, vehicle2, dest);
        assertFalse(solution.equals(solution2));
        
        solution2 = new Solution(suspect, vehicle, dest2);
        assertFalse(solution.equals(solution2));
        
    }
    public void testToString () {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.FEMALE);
        
        Suspect suspect = new Suspect("Mr.A", attributes, "pathS1");
        Vehicle vehicle = new Vehicle("limo", attributes, "pathS1");
        Destination dest = new Destination("CalPoly", attributes, "pathS1");
        
        Solution solution = new Solution (suspect, vehicle, dest);
        assertEquals("Mr.A, limo, CalPoly",solution.toString());
        
    }
    
}