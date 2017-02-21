package integration_test;

import allguis.*;
import guiConsoleController.*;
import java.awt.event.KeyEvent;
import junit.framework.TestCase;
import javax.swing.*;

/**
 * Test for ReplayController events
 * 
 * @author Chris Thibodeau - cathibod
 */
public class ReplayControllerTest extends TestCase {
    
    ReplayGame replay = new ReplayGame(null,false);
    
    public ReplayControllerTest(String testName) {
        super(testName);
    }

    /**
     * Test of keyTyped method and keyReleased, of class ReplayController.
     */
    public void testKeyTypedAndReleased() {
        System.out.println("keyTypedandReleased");
        ReplayController instance = new ReplayController(replay);
        
        instance.keyTyped(null);
        instance.keyReleased(null);
    }

    /**
     * Test of keyPressed, actionPerformed, and showDialog
     * methods, of class ReplayController.
     */
    public void testController() {
        System.out.println("controller");
        JButton btn = new JButton("");
        KeyEvent y = new KeyEvent(btn,0,0,KeyEvent.VK_Y,KeyEvent.VK_Y,'y');
        KeyEvent n = new KeyEvent(btn,0,0,KeyEvent.VK_N,KeyEvent.VK_N,'n');
        ReplayController instance = new ReplayController(replay);;
        instance.keyPressed(y);
        assertEquals(true, instance.showDialog());
        instance.keyPressed(n);
        assertEquals(false, instance.showDialog());
    }
}
