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
public class ChooseThemeDialogControllerTest extends UISpecTestCase
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
    
    public ChooseThemeDialogControllerTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        mockClient = mock(GameClient.class);
        players = new ArrayDeque<Player>();
        p1 = new HumanPlayer("player1");
        lobby = new Lobby(4, 4);
        lobbyCtrl = new LobbyController();
        lobby.setClient(mockClient);
        lobbyCtrl.setup(view, lobby, false);
        parent = new LobbyGUI(lobby, lobbyCtrl);
        ctrl = new ChooseThemeController();
        view = new ChooseThemeDialog(parent, true, ctrl);
        ctrl.setup(true, view, lobby);
        window = new Window(view);
    }
    
    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_G,
                KeyEvent.VK_G, '0'));
        assertEquals("Greek", ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_P,
                KeyEvent.VK_P, '0'));
        assertEquals("Pirate", ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_W,
                KeyEvent.VK_W, '0'));
        assertEquals("Washington", ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_O,
                KeyEvent.VK_O, '0'));
        assertEquals("Washington", ctrl.showDialog());
        
    }
}
