package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;

/**
 *
 * @author DeionLaw
 */
public class SleuthResultTest extends UISpecTestCase {
    private SleuthResultDialog view;
    private SleuthResultDialogController ctrl;
    private List<CardMessage> messages;
    private CardMessage message1;
    private CardMessage message2;
    private SuspectCard card1;
    private SuspectCard card2;
    private String player1 = "player1";
    private String player2 = "player2";
    
    
    public SleuthResultTest(String testName) {
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

    public void testResults()
    {
         Window window = new Window(view);
         TextBox name1 = window.getTextBox("name1");
         TextBox name2 = window.getTextBox("name2");
         TextBox name3 = window.getTextBox("name3");
         
         assertEquals(player1, name1.getText());
         assertEquals(player2, name2.getText());
         assertEquals("", name3.getText());
    }
    
    public void testOK()
    {
        Window window = new Window(view);
        Button okButton = window.getButton();
        
        okButton.click();
        assertFalse(view.isVisible());
    }
}
