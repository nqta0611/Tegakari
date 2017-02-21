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
public class SuggestionDialogTest extends UISpecTestCase {
    private SuggestionDialog view;
    private SuggestionDialogController ctrl;
    private Theme theme = new Theme();
    private SuggestionCard action = new SuggestionCard(false, 
                                    "/image/Action-SuggestionAny.jpg");
    private List<Suspect> suspects = theme.getSuspects();
    private List<Vehicle> vehicles = theme.getVehicles();
    private List<Destination> destinations = theme.getDestinations();
    private Player turnPlayer = new HumanPlayer("turn");
    
    public SuggestionDialogTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ctrl = new SuggestionDialogController();
        view = new SuggestionDialog(ctrl, new JFrame(), true, action, theme);
        Queue<Player> players = new LinkedList<Player>();
        players.add(turnPlayer);
        ctrl.setup(view, new GameState(players, turnPlayer, new tegakari.Table(theme)), action);
    }
    
    public void testReset()
    {
        Window window = new Window(view);
        for(int card = 0 ; card < 6 ; card++)
        {
            Button currCard = window.getButton("suspect" + (card + 1));
            assertTrue(currCard.isEnabled());
            currCard = window.getButton("vehicle" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        for(int card = 0 ; card < 9 ; card++)
        {
            Button currCard = window.getButton("destination" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        assertFalse(window.getButton("ok").isEnabled());
        assertTrue(window.getButton("reset").isEnabled());
        
        window.getButton("suspect1").click();
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("vehicle1").click();
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("destination1").click();
        assertTrue(window.getButton("ok").isEnabled());
        
        for(int card = 0 ; card < 6 ; card++)
        {
            Button currCard = window.getButton("suspect" + (card + 1));
            if(card == 0)
            {
                assertTrue(currCard.isEnabled());
            }
            else
            {
                assertFalse(currCard.isEnabled());
            }
            currCard = window.getButton("vehicle" + (card + 1));
            if(card == 0)
            {
                assertTrue(currCard.isEnabled());
            }
            else
            {
                assertFalse(currCard.isEnabled());
            }
        }
        for(int card = 0 ; card < 9 ; card++)
        {
            Button currCard = window.getButton("destination" + (card + 1));
            if(card == 0)
            {
                assertTrue(currCard.isEnabled());
            }
            else
            {
                assertFalse(currCard.isEnabled());
            }
        }
        
        window.getButton("reset").click();
        
        for(int card = 0 ; card < 6 ; card++)
        {
            Button currCard = window.getButton("suspect" + (card + 1));
            assertTrue(currCard.isEnabled());
            currCard = window.getButton("vehicle" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        for(int card = 0 ; card < 9 ; card++)
        {
            Button currCard = window.getButton("destination" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        assertFalse(window.getButton("ok").isEnabled());
        assertTrue(window.getButton("reset").isEnabled());
    }
    
    public void testMakingSuggestion()
    {
        Window window = new Window(view);
        assertFalse(window.getButton("ok").isEnabled());
        assertTrue(window.getButton("reset").isEnabled());
        
        for(int card = 0 ; card < 6 ; card++)
        {
            Button currCard = window.getButton("suspect" + (card + 1));
            assertTrue(currCard.isEnabled());
            currCard = window.getButton("vehicle" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        for(int card = 0 ; card < 9 ; card++)
        {
            Button currCard = window.getButton("destination" + (card + 1));
            assertTrue(currCard.isEnabled());
        }
        
        window.getButton("suspect1").click();
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("vehicle2").click();
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("destination3").click();
        assertTrue(window.getButton("ok").isEnabled());
        
        window.getButton("ok").click();
        
        assertFalse(view.isVisible());
        
        assertEquals(suspects.get(0), ctrl.showDialog().getGuess().getSuspect());
        assertEquals(vehicles.get(1), ctrl.showDialog().getGuess().getVehicle());
        assertEquals(destinations.get(2), ctrl.showDialog().getGuess().getDestination());
    }
}
