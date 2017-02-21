package integration_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author DeionLaw
 */
public class SuggestionDialogControllerTest extends UISpecTestCase
{

    private SuggestionDialog view;
    private SuggestionDialogController ctrl;
    private Theme theme = new Theme();
    private SuggestionCard action = new SuggestionCard(false,
            "/image/Action-SuggestionAny.jpg");
    private List<Suspect> suspects = theme.getSuspects();
    private List<Vehicle> vehicles = theme.getVehicles();
    private List<Destination> destinations = theme.getDestinations();
    private Player turnPlayer = new HumanPlayer("turn");

    public SuggestionDialogControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ctrl = new SuggestionDialogController();
        view = new SuggestionDialog(ctrl, new JFrame(), true, action, theme);
        Queue<Player> players = new LinkedList<Player>();
        players.add(turnPlayer);
        ctrl.setup(view, new GameState(players, turnPlayer, new tegakari.Table(theme)), action);
    }
    
    public void testKeys()
    {
        
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
