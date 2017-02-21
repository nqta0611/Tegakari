package GUI_test;

import allguis.*;
import tegakari.*;
import org.uispec4j.*;
import org.uispec4j.interception.*;
import static org.mockito.Mockito.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class ChooseThemeDialogTest extends UISpecTestCase 
{
    private LobbyGUI parent;
    private ChooseThemeDialog view;
    private Window window;
    private ChooseThemeController ctrl;
    private Lobby lobby;
    private LobbyController lobbyCtrl;
    private Queue<Player> players;
    private Player p1;
    private GameClient mockClient;
    
    
    public ChooseThemeDialogTest(String testName) {
        super(testName);
        
        
        mockClient = mock(GameClient.class);
        players = new ArrayDeque<Player>();
        p1 = new HumanPlayer("player1");
        lobby = new Lobby(4, 4);
        lobbyCtrl = new LobbyController();
        lobbyCtrl.setup(view, lobby, false);
        parent = new LobbyGUI(lobby, lobbyCtrl);
        ctrl = new ChooseThemeController();
        view = new ChooseThemeDialog(parent, true, ctrl);
        ctrl.setup(true, view, lobby);
        window = new Window(view);
    }

    /**
     * Test of main method, of class ChooseThemeDialog.
     */
    public void testButtons()
    {
        System.out.println("testButtons");
        RadioButton chooseGreek = window.getRadioButton("chooseGreek");
        RadioButton choosePirate = window.getRadioButton("choosePirate");
        RadioButton chooseWashington = window.getRadioButton("chooseWashington");
        Button confirmSelectionButton = window.getButton("confirmSelectionButton");
        
        assertTrue(chooseGreek.isEnabled());
        assertTrue(choosePirate.isEnabled());
        assertTrue(chooseWashington.isEnabled());
        
        chooseGreek.click();
        assertTrue(chooseGreek.isSelected());
        assertFalse(choosePirate.isSelected());
        assertFalse(chooseWashington.isSelected());
      
        choosePirate.click();
        assertTrue(choosePirate.isSelected());
        assertFalse(chooseGreek.isSelected());
        assertFalse(chooseWashington.isSelected());
        
        chooseWashington.click();
        assertTrue(chooseWashington.isSelected());
        assertFalse(chooseGreek.isSelected());
        assertFalse(choosePirate.isSelected());
        
//        confirmSelectionButton.click();
//        assertFalse(view.isVisible());
    }
}
