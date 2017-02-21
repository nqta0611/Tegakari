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
public class SleuthResultControllerTest extends UISpecTestCase {
    private SleuthResultDialog view;
    private SleuthResultDialogController ctrl;
    private List<CardMessage> messages;
    private CardMessage message1;
    private CardMessage message2;
    private SuspectCard card1;
    private SuspectCard card2;
    private String player1 = "player1";
    private String player2 = "player2";
    
    public SleuthResultControllerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Theme theme = new Theme();
        
        ctrl = new SleuthResultDialogController();
        
        card1 = new SuspectCard(theme.getSuspects().get(0));
        List<Card> content1 = new ArrayList<Card>();
        content1.add(card1);
        card2 = new SuspectCard(theme.getSuspects().get(1));
        List<Card> content2 = new ArrayList<Card>();
        content2.add(card2);
        message1 = new CardMessage(null, new HumanPlayer(player1), content1);
        message2 = new CardMessage(null, new HumanPlayer(player2), content2);
        messages = new ArrayList<CardMessage>();
        messages.add(message1);
        messages.add(message2);
        
        view = new SleuthResultDialog(ctrl, new JFrame(), true, messages);
        ctrl.setup(false, view);
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
