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
import java.util.ArrayList;
import java.util.List;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class CreateRobotDialogTest extends UISpecTestCase 
{
    private JFrame parent;
    private CreateRobotDialog view;
    private Window window;
    private GameEngine engine;
    private Lobby lobby;
    private CreateRobotController ctrl;
    
    public CreateRobotDialogTest(String testName) {
        super(testName);
        parent = new JFrame();
        engine = mock(GameEngine.class);
        lobby = new Lobby(4, 4);
        ctrl = new CreateRobotController();
        view = new CreateRobotDialog(parent, true, lobby, ctrl);
        ctrl.setup(true, view);
        window = new Window(view);
    }

    public void testButtons()
    {
        System.out.println("testButtons");
        Button addRobot = window.getButton("addRobot");
        RadioButton setToBasic = window.getRadioButton("setToBasic");
        RadioButton setToSmart = window.getRadioButton("setToSmart");
        
        assertFalse(setToBasic.isSelected());
        assertTrue(setToSmart.isSelected());
        assertTrue(addRobot.isEnabled());
        
        setToBasic.click();
        assertTrue(setToBasic.isSelected());
        assertFalse(setToSmart.isSelected());
        assertTrue(addRobot.isEnabled());
     
        setToSmart.click();
        assertFalse(setToBasic.isSelected());
        assertTrue(setToSmart.isSelected());
        assertTrue(addRobot.isEnabled());
        
//        addRobot.click();
        assertFalse(view.isVisible());
    }
}
