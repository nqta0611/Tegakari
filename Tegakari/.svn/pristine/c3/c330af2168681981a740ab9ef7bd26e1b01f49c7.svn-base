package integration_test;

import allguis.LobbyGUI;
import guiConsoleController.LobbyController;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import static org.mockito.Mockito.*;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;
import tegakari.Lobby;
import tegakari.Player;

/**
 *
 * @author cathibod
 */
public class LobbyControllerTest extends UISpecTestCase {
    
    LobbyController ctrl;
    LobbyGUI view;
    Lobby lobby = mock(Lobby.class);
    
    
    public LobbyControllerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ctrl = new LobbyController();
        view = new LobbyGUI(lobby, ctrl);
    }

    /**
     * Test of keyTyped method and keyReleased, of class MainWindowController.
     */
    public void testKeyTypedAndReleased() {
        System.out.println("keyTypedandReleased");
        
        ctrl.keyTyped(null);
        ctrl.keyReleased(null);
    }

    static
    {
        UISpec4J.init();
    }
    
    /**
     * Test of keyPressed, actionPerformed, and showDialog
     * methods, of class MainWindowController.
     */
    public void testController() 
    {
        System.out.println("controller");
        when(lobby.isFirstPlayer()).thenReturn(true);
       // view.update(lobby, lobby);
        
        Player p = mock(Player.class);
        Queue<Player> list = new LinkedList<>();
        list.add(p);
        
        //when(p.)
        when(lobby.getPlayers()).thenReturn(list);
        ctrl.setup(view, lobby, false, view);
        view.update(lobby, view);
        JButton btn = new JButton("");
        final KeyEvent s = new KeyEvent(btn,0,0,KeyEvent.VK_S,
                KeyEvent.VK_S,'j');
        final KeyEvent r = new KeyEvent(btn,0,0,KeyEvent.VK_R,
                KeyEvent.VK_R,'h');
        final KeyEvent t = new KeyEvent(btn,0,0,KeyEvent.VK_T,
                KeyEvent.VK_T,'h');
        
        
        System.out.println("theme");
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        ctrl.keyPressed(t);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("<HTML>Choose<br>Theme<HTNML>").
                triggerButtonClick("OK (SPACE)")).run();
        
        when(lobby.canAddRobot()).thenReturn(true);
        view.enableRobotButton(true);
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        ctrl.keyPressed(r);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Current: ").
                triggerButtonClick("Add Robot Player (SPACE)")).run();

        ctrl.keyPressed(s);
        
        verify(lobby).startGame();
    }
}
