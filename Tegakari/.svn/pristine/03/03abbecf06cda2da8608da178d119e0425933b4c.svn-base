package integration_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import guiConsoleController.*;
import java.awt.event.KeyEvent;
import org.uispec4j.interception.WindowInterceptor;
import junit.framework.TestCase;

/**
 *
 * @author DeionLaw
 */
public class SuggestionAndMoveDialogControllerTest extends UISpecTestCase
{

    private SuggestionAndMoveDialog view;
    private SuggestionAndMoveDialogController ctrl;
    private Destination dm;
    private SuggestionCard suggestion;
    private Theme theme = new Theme();
    private Player turnPlayer;

    public SuggestionAndMoveDialogControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        suggestion = new SuggestionCard(true,
                "/image/Action-SuggestionCurrent.jpg");
        dm = theme.getDestinations().get(7);
        turnPlayer = new HumanPlayer("turn");

        ctrl = new SuggestionAndMoveDialogController();
        view = new SuggestionAndMoveDialog(ctrl, new JFrame(), true, dm, suggestion, theme);
        ctrl.setup(view, theme, dm, suggestion, turnPlayer);
    }
    
    public void testKeys()
    {
        Window window = new Window(view);
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_S,
                KeyEvent.VK_S, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_R,
                KeyEvent.VK_R, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        window.getRadioButton("suggestion").click();
        window.getButton("suspect1").click();
        window.getButton("vehicle1").click();
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
        assertEquals(theme.getSuspects().get(0), ctrl.showDialog().getGuess().getSuspect());
        assertEquals(theme.getVehicles().get(0), ctrl.showDialog().getGuess().getVehicle());
        assertEquals(theme.getDestinations().get(7), ctrl.showDialog().getGuess().getDestination());
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
        
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_1,
                KeyEvent.VK_1, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_Q,
                KeyEvent.VK_Q, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_S,
                KeyEvent.VK_S, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_2,
                KeyEvent.VK_2, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_W,
                KeyEvent.VK_W, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_D,
                KeyEvent.VK_D, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_3,
                KeyEvent.VK_3, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_E,
                KeyEvent.VK_E, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_F,
                KeyEvent.VK_F, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_4,
                KeyEvent.VK_4, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_R,
                KeyEvent.VK_R, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_G,
                KeyEvent.VK_G, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_5,
                KeyEvent.VK_5, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_T,
                KeyEvent.VK_T, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_H,
                KeyEvent.VK_H, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_6,
                KeyEvent.VK_6, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_Y,
                KeyEvent.VK_Y, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_A,
                KeyEvent.VK_A, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_J,
                KeyEvent.VK_J, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_K,
                KeyEvent.VK_K, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_L,
                KeyEvent.VK_L, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_C,
                KeyEvent.VK_C, '0'));
        
        assertFalse(view.isVisible());
    }
}
