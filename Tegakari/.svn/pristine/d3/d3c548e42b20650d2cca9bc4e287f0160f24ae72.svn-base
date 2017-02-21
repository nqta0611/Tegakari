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
public class SleuthOnMeTest extends UISpecTestCase
{
    private SleuthOnMeDialog view;
    private SleuthOnMeDialogController ctrl;
    private SuperSleuthCard actionCard;
    private List<ClueCard> cards;
    private String playerName;
    private String expectedText = " played this Super Sleuth.";
    private ClueCard card1;
    private Theme theme;
    
    public SleuthOnMeTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        theme = new Theme();
        
        playerName = "from";
        cards = new ArrayList<ClueCard>();
        card1 = new DestinationCard(theme.getDestinations().get(0));
        cards.add(card1);
        Player player = mock(Player.class);
        GameState state = mock(GameState.class);
        
        actionCard = new SuperSleuthCard(ClueType.VEHICLE, 
                                 Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg");
        
        ctrl = new SleuthOnMeDialogController();
        
    }
    
    public void testFromText()
    {
        view = new SleuthOnMeDialog(ctrl, new JFrame(), true, actionCard, cards, playerName);
        Window window = new Window(view);
        TextBox fromText = window.getTextBox("fromText");
        assertEquals(playerName + expectedText, fromText.getText());
    }
    
    public void testSelectingAndOK()
    {
        DestinationCard card2 = new DestinationCard(theme.getDestinations().get(0));
        cards.add(card2);
        view = new SleuthOnMeDialog(ctrl, new JFrame(), true, actionCard, cards, playerName);
        ctrl.setup(false, view, cards);
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        assertFalse(okButton.isEnabled());
        Button card2Button = window.getButton("card2");
        card2Button.click();
        assertTrue(okButton.isEnabled());
        okButton.click();
        assertEquals(card2, ctrl.showDialog());
    }
    
    public void testOneCard()
    {
        view = new SleuthOnMeDialog(ctrl, new JFrame(), true, actionCard, cards, playerName);
        ctrl.setup(false, view, cards);
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        assertTrue(okButton.isEnabled());
        okButton.click();
        assertFalse(view.isVisible());
        assertEquals(card1, ctrl.showDialog());
    }
}
