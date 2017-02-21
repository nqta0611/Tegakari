package integration_test;

import allguis.NoOneDisproveDialog;
import guiConsoleController.NoOneDisproveController;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import tegakari.Destination;
import tegakari.Solution;
import tegakari.Suspect;
import tegakari.Vehicle;

/**
 *
 * @author cathibod
 */
public class NoOneDisproveControllerTest extends TestCase {
    
    NoOneDisproveController ctrl;
    //NoOneDisproveDialog view = mock(NoOneDisproveDialog.class);
    Solution solution = mock(Solution.class);
    Suspect suspect = mock(Suspect.class);
    Vehicle vehicle = mock(Vehicle.class);
    Destination destination = mock(Destination.class);
    NoOneDisproveDialog view;
    
    
    public NoOneDisproveControllerTest(String testName) {
        super(testName);
    }
    
    /**
     * Test of keyTyped method and keyReleased, of class NoOneDisproveController.
     */
    public void testKeyTypedAndReleased() {
        System.out.println("keyTypedandReleased");
        ctrl = new NoOneDisproveController();
        ctrl.keyTyped(null);
        ctrl.keyReleased(null);
    }
    
    /**
     * Test of keyPressed, actionPerformed, and setup
     * methods, of class NoOneDisproveController.
     */
    public void testController() {
        System.out.println("keyPressed");
        ctrl = new NoOneDisproveController();
        
        when(solution.toString()).thenReturn("");
        when(solution.getSuspect()).thenReturn(suspect);
        when(solution.getVehicle()).thenReturn(vehicle);
        when(solution.getDestination()).thenReturn(destination);
        when(suspect.getImagePath()).thenReturn("");
        when(vehicle.getImagePath()).thenReturn("");
        when(destination.getImagePath()).thenReturn("");
        view = new NoOneDisproveDialog(new JFrame(), true,
            solution, ctrl);
        
        JButton btn = new JButton("");
        KeyEvent space = new KeyEvent(btn,0,0,KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE,'0');
        ctrl.setup(solution, view);
        ctrl.keyPressed(space);
        assertFalse(view.isVisible());
    }

}
