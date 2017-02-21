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
public class SnoopOnMeDialogTest extends UISpecTestCase {
    private SnoopOnMeDialog view;
    private SnoopOnMeDialogController ctrl;
    private CardMessage message;
    private ClueCard card;
    private String playerName = "player from";
    
    public SnoopOnMeDialogTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
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
    
    public void testTextAndOK()
    {
        Window window = new Window(view);
        TextBox text = window.getTextBox("snoopText");
        Button okButton = window.getButton("ok");
        
        assertEquals(playerName + " snooped on me and saw:", text.getText());
        okButton.click();
        assertFalse(view.isVisible());
    }

}
