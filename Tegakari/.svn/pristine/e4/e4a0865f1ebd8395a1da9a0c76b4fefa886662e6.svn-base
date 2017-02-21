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
public class SnoopOnMeControllerTest extends UISpecTestCase
{

    private SnoopOnMeDialog view;
    private SnoopOnMeDialogController ctrl;
    private CardMessage message;
    private ClueCard card;
    private String playerName = "player from";

    public SnoopOnMeControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        Theme theme = new Theme();
        card = new SuspectCard(theme.getSuspects().get(0));

        List<Card> content = new ArrayList<Card>();
        content.add(card);
        message = new CardMessage(new HumanPlayer("to"), new HumanPlayer(playerName), content);

        ctrl = new SnoopOnMeDialogController();
        view = new SnoopOnMeDialog(ctrl, new JFrame(), true, message);
        ctrl.setup(view);
    }
    
    public void testKeys()
    {
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        
        ctrl.keyPressed(new KeyEvent(new JButton(""), 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
        
        assertFalse(view.isVisible());
    }
}
