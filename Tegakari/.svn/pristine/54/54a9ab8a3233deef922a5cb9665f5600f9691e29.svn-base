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
public class SnoopDialogControllerTest extends UISpecTestCase
{

    private SnoopDialog view;
    private SnoopDialogController ctrl;
    private SnoopCard actionCard;
    private String showText1;
    private String showText2;
    private List<ClueCard> cards;

    public SnoopDialogControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        Theme theme = new Theme();

        cards = new ArrayList<ClueCard>();
        cards.add(new SuspectCard(theme.getSuspects().get(0)));
        cards.add(new SuspectCard(theme.getSuspects().get(1)));
        cards.add(new SuspectCard(theme.getSuspects().get(2)));
        cards.add(new SuspectCard(theme.getSuspects().get(3)));
        cards.add(new SuspectCard(theme.getSuspects().get(4)));
        cards.add(new SuspectCard(theme.getSuspects().get(5)));

        showText1 = "text1";
        showText2 = "text2";

        actionCard = new SnoopCard("/image/Action-Snoop.jpg");

        ctrl = new SnoopDialogController();
        view = new SnoopDialog(ctrl, new JFrame(), true, cards, actionCard, showText1, showText2);
        ctrl.setup(view, cards);
    }
    
    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_1,
                KeyEvent.VK_1, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_2,
                KeyEvent.VK_2, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_3,
                KeyEvent.VK_3, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_4,
                KeyEvent.VK_4, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_5,
                KeyEvent.VK_5, '0'));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_6,
                KeyEvent.VK_6, '0'));        
        assertTrue(cards.contains(ctrl.showDialog()));
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
    }
}
