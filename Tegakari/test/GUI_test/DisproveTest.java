package GUI_test;

import allguis.*;
import tegakari.*;
import org.uispec4j.*;
import org.uispec4j.interception.*;
import static org.mockito.Mockito.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class DisproveTest extends UISpecTestCase 
{
    private JFrame parent;
    private Disprove view;
    private Window window;
    private List<ClueCard> clueCardList;
    private SuggestionCardLogic logic;
    private SuggestionCard any;
    private SuggestionCard current;
    private Theme theme;
    private Player self;
    private DisproveController ctrl;
    
    public DisproveTest(String testName) 
    {
        super(testName);
        theme = new Theme();
        parent = new JFrame();
        any = new SuggestionCard(true, "image/Action-SuggsetionAny.jpg");
        current = new SuggestionCard(false, 
                "image/Action-SuggsetionCurrent.jpg");
        self = new HumanPlayer("self");
        clueCardList = new ArrayList<ClueCard>();
        ctrl = new DisproveController();
    }

    /**
     * Test of showDialog method, of class Disprove.
     */
    public void testButtonsDestinations() 
    {
        System.out.println("testButtonsDestinations");
        Solution guess = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        logic = new SuggestionCardLogic(any, self, 
                theme.getDestinations().get(0), guess);
        clueCardList.add(new DestinationCard(theme.getDestinations().get(0)));
        view = new Disprove(ctrl, parent, true, logic, clueCardList);
        ctrl.setup(view, logic, clueCardList);
        window = new Window(view);
        
        Button okButton = window.getButton("okButton");
        Button DestinationButton = window.getButton("DestinationButton");
        Button vehicleButton = window.getButton("vehicleButton");
        Button suspectButton = window.getButton("suspectButton");
        Button resetButton = window.getButton("resetButton");
        
        assertTrue(okButton.isEnabled());
        assertTrue(DestinationButton.isEnabled());
        assertFalse(vehicleButton.isEnabled());
        assertFalse(suspectButton.isEnabled());
        assertFalse(resetButton.isEnabled());
        
        
        okButton.click();
        assertFalse(view.isVisible());
    }

    public void testButtonsSuspect() 
    {
        System.out.println("testButtonsSuspect");
        Solution guess = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        logic = new SuggestionCardLogic(any, self, 
                theme.getDestinations().get(0), guess);
        clueCardList.add(new SuspectCard(theme.getSuspects().get(0)));
        view = new Disprove(ctrl, parent, true, logic, clueCardList);
        ctrl.setup(view, logic, clueCardList);
        window = new Window(view);
        
        Button okButton = window.getButton("okButton");
        Button DestinationButton = window.getButton("DestinationButton");
        Button vehicleButton = window.getButton("vehicleButton");
        Button suspectButton = window.getButton("suspectButton");
        Button resetButton = window.getButton("resetButton");
        
        assertTrue(okButton.isEnabled());
        assertFalse(DestinationButton.isEnabled());
        assertFalse(vehicleButton.isEnabled());
        assertTrue(suspectButton.isEnabled());
        assertFalse(resetButton.isEnabled());
        
        
        /**
         * CAUSING AN ERROR NEED TO FIX OK BUTTON
        */
        okButton.click();
        assertFalse(view.isVisible());

    }
    
    public void testButtonsVehicle() 
    {
        System.out.println("testButtonsVehicle");
        Solution guess = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        logic = new SuggestionCardLogic(any, self, 
                theme.getDestinations().get(0), guess);
        clueCardList.add(new VehicleCard(theme.getVehicles().get(0)));
        view = new Disprove(ctrl, parent, true, logic, clueCardList);
        ctrl.setup(view, logic, clueCardList);
        window = new Window(view);
        
        Button okButton = window.getButton("okButton");
        Button DestinationButton = window.getButton("DestinationButton");
        Button vehicleButton = window.getButton("vehicleButton");
        Button suspectButton = window.getButton("suspectButton");
        Button resetButton = window.getButton("resetButton");
        
        assertTrue(okButton.isEnabled());
        assertFalse(DestinationButton.isEnabled());
        assertTrue(vehicleButton.isEnabled());
        assertFalse(suspectButton.isEnabled());
        assertFalse(resetButton.isEnabled());
        
        
        /**
         * CAUSING AN ERROR NEED TO FIX OK BUTTON
        */
        okButton.click();
        assertFalse(view.isVisible());

    }
 /*   */
    public void testButtonsALL() 
    {
        System.out.println("testButtonsALL");
        Solution guess = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        logic = new SuggestionCardLogic(any, self, 
                theme.getDestinations().get(0), guess);
        clueCardList.add(new VehicleCard(theme.getVehicles().get(0)));
        clueCardList.add(new SuspectCard(theme.getSuspects().get(0)));
        clueCardList.add(new DestinationCard(theme.getDestinations().get(0)));
        view = new Disprove(ctrl, parent, true, logic, clueCardList);
        ctrl.setup(view, logic, clueCardList);
        window = new Window(view);
        
        Button okButton = window.getButton("okButton");
        Button DestinationButton = window.getButton("DestinationButton");
        Button vehicleButton = window.getButton("vehicleButton");
        Button suspectButton = window.getButton("suspectButton");
        Button resetButton = window.getButton("resetButton");
        
        assertFalse(okButton.isEnabled());
        assertTrue(DestinationButton.isEnabled());
        assertTrue(vehicleButton.isEnabled());
        assertTrue(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
        
        resetButton.click();
        assertFalse(okButton.isEnabled());
        assertTrue(DestinationButton.isEnabled());
        assertTrue(vehicleButton.isEnabled());
        assertTrue(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
    
        DestinationButton.click();
        assertTrue(okButton.isEnabled());
        assertTrue(DestinationButton.isEnabled());
        assertFalse(vehicleButton.isEnabled());
        assertFalse(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
        
        resetButton.click();
        assertFalse(okButton.isEnabled());
        assertTrue(DestinationButton.isEnabled());
        assertTrue(vehicleButton.isEnabled());
        assertTrue(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
        
        resetButton.click();
        vehicleButton.click();
        assertTrue(okButton.isEnabled());
        assertFalse(DestinationButton.isEnabled());
        assertTrue(vehicleButton.isEnabled());
        assertFalse(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
        
        resetButton.click();
        suspectButton.click();
        assertTrue(okButton.isEnabled());
        assertFalse(DestinationButton.isEnabled());
        assertFalse(vehicleButton.isEnabled());
        assertTrue(suspectButton.isEnabled());
        assertTrue(resetButton.isEnabled());
        
        okButton.click();
        assertFalse(view.isVisible());
    }

}
