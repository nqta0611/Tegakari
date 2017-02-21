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
public class SuggestionAndMoveTest extends UISpecTestCase {
    private SuggestionAndMoveDialog view;
    private SuggestionAndMoveDialogController ctrl;
    private Destination dm;
    private SuggestionCard suggestion;
    private Theme theme = new Theme();
    private Player turnPlayer;
    
    public SuggestionAndMoveTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        suggestion = new SuggestionCard(true,
                    "/image/Action-SuggestionCurrent.jpg");
        dm = theme.getDestinations().get(7);
        turnPlayer = new HumanPlayer("turn");
        
        ctrl = new SuggestionAndMoveDialogController();
        view = new SuggestionAndMoveDialog(ctrl, new JFrame(), true, dm, suggestion, theme);
        ctrl.setup(view, theme, dm, suggestion, turnPlayer);
    }

    public void testMove()
    {
        Window window = new Window(view);
        assertFalse(window.getButton("ok").isEnabled());
        RadioButton move = window.getRadioButton("move");
        move.click();
        for(int dest = 0 ; dest < 9 ; dest++)
        {
            Button currDest = window.getButton("destination" + (dest + 1));
            if(dest == 7)
            {
                assertFalse(currDest.isEnabled());
            }
            else
            {
                assertTrue(currDest.isEnabled());
            }
        }
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("destination4").click();
        assertTrue(window.getButton("ok").isEnabled());
        window.getButton("ok").click();
        assertTrue(ctrl.showDialog().isMoved());
        assertEquals(theme.getDestinations().get(3), ctrl.showDialog().getDestination());
    }
    
    public void testResetAndDM()
    {
        Window window = new Window(view);
        assertFalse(window.getButton("ok").isEnabled());
        RadioButton move = window.getRadioButton("move");
        move.click();
        for(int dest = 0 ; dest < 9 ; dest++)
        {
            Button currDest = window.getButton("destination" + (dest + 1));
            if(dest == 7)
            {
                assertFalse(currDest.isEnabled());
            }
            else
            {
                assertTrue(currDest.isEnabled());
            }
        }
        window.getButton("destination3").click();
        assertTrue(window.getButton("ok").isEnabled());
        window.getButton("reset").click();
        assertFalse(window.getButton("ok").isEnabled());
        RadioButton suggestionButton = window.getRadioButton("suggestion");
        suggestionButton.click();
        
        assertFalse(window.getButton("destination8").isEnabled());
        for(int index = 0 ; index < 6 ; index++)
        {
            assertTrue(window.getButton("suspect" + (index + 1)).isEnabled());
            assertTrue(window.getButton("vehicle" + (index + 1)).isEnabled());
        }
        for(int dest = 0 ; dest < 9 ; dest++)
        {
            Button currDest = window.getButton("destination" + (dest + 1));
            assertFalse(currDest.isEnabled());
        }
        
    }
    
    public void testSuggestion()
    {
        Window window = new Window(view);
        assertFalse(window.getButton("ok").isEnabled());
        RadioButton suggestionButton = window.getRadioButton("suggestion");
        suggestionButton.click();
        
        assertFalse(window.getButton("destination8").isEnabled());
        for(int index = 0 ; index < 6 ; index++)
        {
            assertTrue(window.getButton("suspect" + (index + 1)).isEnabled());
            assertTrue(window.getButton("vehicle" + (index + 1)).isEnabled());
        }
        for(int dest = 0 ; dest < 9 ; dest++)
        {
            Button currDest = window.getButton("destination" + (dest + 1));
            assertFalse(currDest.isEnabled());
        }
        
        window.getButton("suspect1").click();
        assertFalse(window.getButton("ok").isEnabled());
        window.getButton("vehicle1").click();
        assertTrue(window.getButton("ok").isEnabled());
        window.getButton("ok").click();
        
        assertEquals(theme.getSuspects().get(0), ctrl.showDialog().getGuess().getSuspect());
        assertEquals(theme.getVehicles().get(0), ctrl.showDialog().getGuess().getVehicle());
        assertEquals(theme.getDestinations().get(7), ctrl.showDialog().getGuess().getDestination());
    }
}
