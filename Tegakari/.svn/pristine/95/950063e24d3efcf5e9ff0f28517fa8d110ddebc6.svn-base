package integration_test;

import allguis.*;
import guiConsoleController.NoWinnerController;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import junit.framework.TestCase;
import tegakari.Solution;
import static org.mockito.Mockito.*;
import tegakari.Destination;
import tegakari.Suspect;
import tegakari.Vehicle;

/**
 *
 * @author cathibod
 */
public class NoWinnerControllerTest extends TestCase 
{
    
    NoWinnerDialog view;
    NoWinnerController ctrl;
    Solution solution = mock(Solution.class);
    Suspect suspect = mock(Suspect.class);
    Vehicle vehicle = mock(Vehicle.class);
    Destination destination = mock(Destination.class);
    
    
    public NoWinnerControllerTest(String testName) {
        super(testName);
    }
    
    /**
     * Test of keyTyped method and keyReleased, of class NoWinnerController.
     */
    public void testKeyTypedAndReleased() {
        System.out.println("keyTypedandReleased");
        ctrl = new NoWinnerController();
        ctrl.keyTyped(null);
        ctrl.keyReleased(null);
    }
    
    /**
     * Test of keyPressed, actionPerformed, and setup
     * methods, of class NoWinnerController.
     */
    public void testController() {
        System.out.println("keyPressed");
        ctrl = new NoWinnerController();
        
        when(solution.toString()).thenReturn("");
        when(solution.getSuspect()).thenReturn(suspect);
        when(solution.getVehicle()).thenReturn(vehicle);
        when(solution.getDestination()).thenReturn(destination);
        when(suspect.getImagePath()).thenReturn("");
        when(vehicle.getImagePath()).thenReturn("");
        when(destination.getImagePath()).thenReturn("");
        view = new NoWinnerDialog(new JFrame(), true,
            solution, ctrl);
        
        JButton btn = new JButton("");
        KeyEvent space = new KeyEvent(btn,0,0,KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE,'0');
        ctrl.setUp(view, solution);
        ctrl.keyPressed(space);
        assertFalse(view.isVisible());
    }
}
