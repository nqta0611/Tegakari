package integration_test;

import allguis.*;
import tegakari.*;
import org.uispec4j.*;
import org.uispec4j.interception.*;
import static org.mockito.Mockito.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import guiConsoleController.*;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author DeionLaw
 */
public class CreateRobotControllerTest extends UISpecTestCase
{
    private JFrame parent;
    private CreateRobotDialog view;
    private Window window;
    private GameEngine engine;
    private Lobby lobby;
    private CreateRobotController ctrl;

    public CreateRobotControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        parent = new JFrame();
        engine = mock(GameEngine.class);
        lobby = new Lobby(4, 4);
        ctrl = new CreateRobotController();
        view = mock(CreateRobotDialog.class);
        ctrl.setup(true, view);
        window = new Window(view);
    }
    
    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_B,
                KeyEvent.VK_B, '0'));
        verify(view).setToBasic();
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_S,
                KeyEvent.VK_S, '0'));
        verify(view).setToSmart();
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
        verify(view).addRobot();
        
    }
}
