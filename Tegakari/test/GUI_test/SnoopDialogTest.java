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
public class SnoopDialogTest extends UISpecTestCase {
    private SnoopDialog view;
    private SnoopDialogController ctrl;
    private SnoopCard actionCard;
    private String showText1;
    private String showText2;
    private List<ClueCard> cards;
    
    public SnoopDialogTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
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

    public void testTexts()
    {
        Window window = new Window(view);
        
        TextBox text1 = window.getTextBox("text1");
        TextBox text2 = window.getTextBox("text2");
                
        assertEquals(showText1 + ".", text1.getText());
        assertEquals(showText2 + ".", text2.getText());
    }
    
    public void testButtons()
    {
        Window window = new Window(view);
        Button[] hand = new Button[6];
        Button okButton = window.getButton("okButton");
        
        assertFalse(okButton.isEnabled());
        for(int card = 0 ; card < 6 ; card++)
        {
            hand[card] = window.getButton("card" + (card+1));
            assertTrue(hand[card].isEnabled());
        }
        
        hand[5].click();
        assertTrue(okButton.isEnabled());
        for(int card = 0 ; card < 5 ; card++)
        {
            assertFalse(hand[card].isEnabled());
        }
        
        assertTrue(hand[5].isEnabled());
    }
}
