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
public class AccusationResultControllerTest extends UISpecTestCase
{

    private JFrame parent;
    private AccusationResult view;
    private Window window;
    private AccusationMessage message;
    private Theme theme;
    private Solution solution;
    private Solution wrong;
    private Solution correct;
    private Player self;
    private AccusationResultController ctrl;

    public AccusationResultControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ctrl = new AccusationResultController();
        self = new HumanPlayer("self");
        theme = new Theme();
        correct = new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        solution = new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        wrong = new Solution(theme.getSuspects().get(2),
                theme.getVehicles().get(2), theme.getDestinations().get(2));
        parent = new JFrame();
        message = new AccusationMessage(wrong, solution, self);
        message.setShowTo(self);
        message.setIsCorrect(false);
        view = new AccusationResult(ctrl, parent, false, message);
        ctrl.setup(view);
    }

    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_O,
                KeyEvent.VK_O, '0'));
        assertFalse(view.isVisible());
    }
}
