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
public class SnoopOnPlayerControllerTest extends UISpecTestCase {
    private SnoopOnPlayerDialog view;
    private SnoopOnPlayerDialogController ctrl;
    private List<Player> players;
    
    
    public SnoopOnPlayerControllerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        players = new ArrayList<Player>();
        
        players.add(new HumanPlayer("turn player"));
        players.add(new HumanPlayer("player1"));
        players.add(new HumanPlayer("player2"));
        players.add(new HumanPlayer("player3"));
        
        ctrl = new SnoopOnPlayerDialogController();
        view = new SnoopOnPlayerDialog(ctrl, new JFrame(), true, players);
        ctrl.setup(view, players);
    }

    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_1,
                KeyEvent.VK_1, '0'));
        assertEquals(players.get(1).getName(), ctrl.showDialog().getName());
        
        view = new SnoopOnPlayerDialog(ctrl, new JFrame(), true, players);
        ctrl.setup(view, players);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_2,
                KeyEvent.VK_2, '0'));
        assertEquals(players.get(2).getName(), ctrl.showDialog().getName());
        
        view = new SnoopOnPlayerDialog(ctrl, new JFrame(), true, players);
        ctrl.setup(view, players);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_2,
                KeyEvent.VK_3, '0'));
        assertEquals(players.get(3).getName(), ctrl.showDialog().getName());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
    }
    
    public void testKeys2()
    {
        
    }
}
