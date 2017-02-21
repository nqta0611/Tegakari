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
import org.uispec4j.assertion.UISpecAssert;

/**
 *
 * @author DeionLaw
 */
public class SleuthOnMeDialogControllerTest extends UISpecTestCase
{

    private SleuthOnMeDialog view;
    private SleuthOnMeDialogController ctrl;
    private SuperSleuthCard actionCard;
    private List<ClueCard> cards;
    private String playerName;
    private String expectedText = " played this Super Sleuth.";
    private ClueCard card1;
    private ClueCard card2;
    private ClueCard card3;
    private ClueCard card4;
    private ClueCard card5;
    private ClueCard card6;
    private Theme theme;

    public SleuthOnMeDialogControllerTest(String testName)
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
        card2 = new DestinationCard(theme.getDestinations().get(1));
        card3 = new DestinationCard(theme.getDestinations().get(2));
        card4 = new DestinationCard(theme.getDestinations().get(3));
        card5 = new DestinationCard(theme.getDestinations().get(4));
        card6 = new DestinationCard(theme.getDestinations().get(5));
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        Player player = mock(Player.class);
        GameState state = mock(GameState.class);

        actionCard = new SuperSleuthCard(ClueType.VEHICLE,
                Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg");

        ctrl = new SleuthOnMeDialogController();
        view = new SleuthOnMeDialog(ctrl, new JFrame(), true, actionCard, cards, playerName);
        ctrl.setup(false, view, cards);
    }
    
    public void testKeys()
    {
        Window window = new Window(view);
        JButton btn = new JButton("");
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_1,
                KeyEvent.VK_1, '0'));
        assertEquals(card1, ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_2,
                KeyEvent.VK_2, '0'));
        assertEquals(card2, ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_3,
                KeyEvent.VK_3, '0'));
        assertEquals(card3, ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_4,
                KeyEvent.VK_4, '0'));
        assertEquals(card4, ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_5,
                KeyEvent.VK_5, '0'));
        assertEquals(card5, ctrl.showDialog());
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_6,
                KeyEvent.VK_6, '0'));
        assertEquals(card6, ctrl.showDialog());
        
        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_SPACE,
                KeyEvent.VK_SPACE, '0'));
    }
}
