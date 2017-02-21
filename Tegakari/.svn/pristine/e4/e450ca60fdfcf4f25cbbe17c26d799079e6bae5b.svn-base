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
public class DisproveControllerTest extends UISpecTestCase
{
    private JFrame parent;
    private Disprove view;
    private Window window;
    private List<ClueCard> clueCardList;
    private SuggestionCardLogic logic;
    private SuggestionCard any;
    private SuggestionCard current;
    private Theme theme;
    private Player self;
    private DisproveController ctrl;

    public DisproveControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        theme = new Theme();
        parent = new JFrame();
        any = new SuggestionCard(true, "image/Action-SuggestionAny.jpg");
        current = new SuggestionCard(false, 
                "image/Action-SuggsetionCurrent.jpg");
        self = new HumanPlayer("self");
        clueCardList = new ArrayList<ClueCard>();
        ctrl = new DisproveController();
        Solution guess = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        logic = new SuggestionCardLogic(any, self, 
                theme.getDestinations().get(0), guess);
        clueCardList.add(new SuspectCard(theme.getSuspects().get(0)));
        clueCardList.add(new VehicleCard(theme.getVehicles().get(0)));
        clueCardList.add(new DestinationCard(theme.getDestinations().get(0)));
        view = new Disprove(ctrl, parent, true, logic, clueCardList);
        ctrl.setup(view, logic, clueCardList);
    }
    
    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_S,
                KeyEvent.VK_S, '0'));
        assertEquals(clueCardList.get(0), ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_V,
                KeyEvent.VK_V, '0'));
        assertEquals(clueCardList.get(1), ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_D,
                KeyEvent.VK_D, '0'));
        assertEquals(clueCardList.get(2), ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_R,
                KeyEvent.VK_R, '0'));
        assertNull(ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_D,
                KeyEvent.VK_D, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
        assertEquals(clueCardList.get(2), ctrl.showDialog());
        
    }
}
