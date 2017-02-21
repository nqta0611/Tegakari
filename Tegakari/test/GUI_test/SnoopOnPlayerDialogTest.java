package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;

/**
 *
 * @author DeionLaw
 */
public class SnoopOnPlayerDialogTest extends UISpecTestCase {
    private SnoopOnPlayerDialog view;
    private SnoopOnPlayerDialogController ctrl;
    private List<Player> players;
    
    
    public SnoopOnPlayerDialogTest(String testName) {
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

    public void testPlayers()
    {
        Window window = new Window(view);
        Button p1 = window.getButton("seat1");
        Button p2 = window.getButton("seat2");
        Button p3 = window.getButton("seat3");
        Button okButton = window.getButton("ok");
        assertFalse(okButton.isEnabled());
        assertTrue(p1.isEnabled());
        assertTrue(p2.isEnabled());
        assertTrue(p3.isEnabled());
        
        assertEquals("player1", p1.getLabel());
        assertEquals("player2", p2.getLabel());
        assertEquals("player3", p3.getLabel());
        
        p3.click();
        assertTrue(okButton.isEnabled());
        
        assertFalse(p1.isEnabled());
        assertFalse(p2.isEnabled());
        assertTrue(p3.isEnabled());
        okButton.click();
        assertEquals(players.get(3).getName(), ctrl.showDialog().getName());
    }
}
