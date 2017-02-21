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
import java.util.Scanner;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class AccusationDialogTest extends UISpecTestCase 
{
    private AccusationDialog view;
    private GameTable parent;
    private Window window;
    private tegakari.Table table;
    private Theme theme;
    private AccusationController ctrl;
    private Scanner sc;

    public AccusationDialogTest(String testName) {
        super(testName);
        
        theme = new Theme();
        table = new tegakari.Table(theme);
        table.buildActionDeck();
        sc = new Scanner("");

        Player self = new HumanPlayer("self");
        Player p2 = new HumanPlayer("p2");
        Player p3 = new HumanPlayer("p3");
        Player p4 = new HumanPlayer("p4");
        Queue<Player> players = new LinkedList();
        players.add(self);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        GameTableController gameTableCtrl = new GameTableController();
        GameState state = new GameState(players, self, table);
        GameClient client = mock(GameClient.class);
        GameEngine engine = new GameEngine(state, client);

        self.setDestination(table.dealDM());
        p2.setDestination(table.dealDM());
        p3.setDestination(table.dealDM());
        p4.setDestination(table.dealDM());
        parent = new GameTable(gameTableCtrl, engine);
        gameTableCtrl.setup(parent, engine, true, sc);
        
        ctrl = new AccusationController();
        view = new AccusationDialog(ctrl, parent, true);
        ctrl.setup(view, state);
    }

    /**
     * The method called before every test method.
     * 
     * @throws Exception 
     */
    @Override
    protected void setUp() throws Exception
    {
        window = new Window(view);
    }
    
    /**
     * Test of showDialog method, of class AccusationDialog.
     */
    public void testSuspects() 
    {
        System.out.println("testSuspects");
        Button suspect1 = window.getButton("suspect1");
        Button suspect2 = window.getButton("suspect2");
        Button suspect3 = window.getButton("suspect3");
        Button suspect4 = window.getButton("suspect4");
        Button suspect5 = window.getButton("suspect5");
        Button suspect6 = window.getButton("suspect6");
        Button reset = window.getButton("buttonReset");
        
        assertTrue(suspect1.isEnabled());
        assertTrue(suspect2.isEnabled());
        assertTrue(suspect3.isEnabled());
        assertTrue(suspect4.isEnabled());
        assertTrue(suspect5.isEnabled());
        assertTrue(suspect6.isEnabled());
        
        suspect1.click();
        assertTrue(suspect1.isEnabled());
        assertFalse(suspect2.isEnabled());
        assertFalse(suspect3.isEnabled());
        assertFalse(suspect4.isEnabled());
        assertFalse(suspect5.isEnabled());
        assertFalse(suspect6.isEnabled());
        
        reset.click();
        assertTrue(suspect1.isEnabled());
        assertTrue(suspect2.isEnabled());
        assertTrue(suspect3.isEnabled());
        assertTrue(suspect4.isEnabled());
        assertTrue(suspect5.isEnabled());
        assertTrue(suspect6.isEnabled());
        
        suspect2.click();
        assertTrue(suspect2.isEnabled());
        assertFalse(suspect1.isEnabled());
        assertFalse(suspect3.isEnabled());
        assertFalse(suspect4.isEnabled());
        assertFalse(suspect5.isEnabled());
        assertFalse(suspect6.isEnabled());
        
        reset.click();
        suspect3.click();
        assertTrue(suspect3.isEnabled());
        assertFalse(suspect1.isEnabled());
        assertFalse(suspect2.isEnabled());
        assertFalse(suspect4.isEnabled());
        assertFalse(suspect5.isEnabled());
        assertFalse(suspect6.isEnabled());
        
        reset.click();
        suspect4.click();
        assertTrue(suspect4.isEnabled());
        assertFalse(suspect1.isEnabled());
        assertFalse(suspect2.isEnabled());
        assertFalse(suspect3.isEnabled());
        assertFalse(suspect5.isEnabled());
        assertFalse(suspect6.isEnabled());
        
        reset.click();
        suspect5.click();
        assertTrue(suspect5.isEnabled());
        assertFalse(suspect1.isEnabled());
        assertFalse(suspect2.isEnabled());
        assertFalse(suspect4.isEnabled());
        assertFalse(suspect3.isEnabled());
        assertFalse(suspect6.isEnabled());
        
        reset.click();
        suspect6.click();
        assertTrue(suspect6.isEnabled());
        assertFalse(suspect1.isEnabled());
        assertFalse(suspect2.isEnabled());
        assertFalse(suspect4.isEnabled());
        assertFalse(suspect5.isEnabled());
        assertFalse(suspect3.isEnabled());
    }
    
    public void testDestinations()
    {
        System.out.println("testDestinations");
        Button destinations1 = window.getButton("destination1");
        Button destinations2 = window.getButton("destination2");
        Button destinations3 = window.getButton("destination3");
        Button destinations4 = window.getButton("destination4");
        Button destinations5 = window.getButton("destination5");
        Button destinations6 = window.getButton("destination6");
        Button destinations7 = window.getButton("destination7");
        Button destinations8 = window.getButton("destination8");
        Button destinations9 = window.getButton("destination9");
        Button reset = window.getButton("buttonReset");
        
        assertTrue(destinations1.isEnabled());
        assertTrue(destinations2.isEnabled());
        assertTrue(destinations3.isEnabled());
        assertTrue(destinations4.isEnabled());
        assertTrue(destinations5.isEnabled());
        assertTrue(destinations6.isEnabled());
        assertTrue(destinations7.isEnabled());
        assertTrue(destinations8.isEnabled());
        assertTrue(destinations9.isEnabled());
        
        destinations1.click();
        assertTrue(destinations1.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations2.click();
        assertTrue(destinations2.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations3.click();
        assertTrue(destinations3.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations4.click();
        assertTrue(destinations4.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations5.click();
        assertTrue(destinations5.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations6.click();
        assertTrue(destinations6.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations7.click();
        assertTrue(destinations7.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations8.click();
        assertTrue(destinations8.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations1.isEnabled());
        assertFalse(destinations9.isEnabled());
        
        reset.click();
        destinations9.click();
        assertTrue(destinations9.isEnabled());
        assertFalse(destinations2.isEnabled());
        assertFalse(destinations3.isEnabled());
        assertFalse(destinations4.isEnabled());
        assertFalse(destinations5.isEnabled());
        assertFalse(destinations6.isEnabled());
        assertFalse(destinations7.isEnabled());
        assertFalse(destinations8.isEnabled());
        assertFalse(destinations1.isEnabled());
    }
    
    public void testVehicles()
    {
        System.out.println("testVehicles");
        Button vehicle1 = window.getButton("vehicle1");
        Button vehicle2 = window.getButton("vehicle2");
        Button vehicle3 = window.getButton("vehicle3");
        Button vehicle4 = window.getButton("vehicle4");
        Button vehicle5 = window.getButton("vehicle5");
        Button vehicle6 = window.getButton("vehicle6");
        Button reset = window.getButton("buttonReset");
        
        assertTrue(vehicle1.isEnabled());
        assertTrue(vehicle2.isEnabled());
        assertTrue(vehicle3.isEnabled());
        assertTrue(vehicle4.isEnabled());
        assertTrue(vehicle5.isEnabled());
        assertTrue(vehicle6.isEnabled());
        
        vehicle1.click();
        assertTrue(vehicle1.isEnabled());
        assertFalse(vehicle2.isEnabled());
        assertFalse(vehicle3.isEnabled());
        assertFalse(vehicle4.isEnabled());
        assertFalse(vehicle5.isEnabled());
        assertFalse(vehicle6.isEnabled());
        
        reset.click();
        vehicle2.click();
        assertTrue(vehicle2.isEnabled());
        assertFalse(vehicle1.isEnabled());
        assertFalse(vehicle3.isEnabled());
        assertFalse(vehicle4.isEnabled());
        assertFalse(vehicle5.isEnabled());
        assertFalse(vehicle6.isEnabled());
        
        reset.click();
        vehicle3.click();
        assertTrue(vehicle3.isEnabled());
        assertFalse(vehicle1.isEnabled());
        assertFalse(vehicle2.isEnabled());
        assertFalse(vehicle4.isEnabled());
        assertFalse(vehicle5.isEnabled());
        assertFalse(vehicle6.isEnabled());
        
        reset.click();
        vehicle4.click();
        assertTrue(vehicle4.isEnabled());
        assertFalse(vehicle1.isEnabled());
        assertFalse(vehicle3.isEnabled());
        assertFalse(vehicle2.isEnabled());
        assertFalse(vehicle5.isEnabled());
        assertFalse(vehicle6.isEnabled());
        
        reset.click();
        vehicle5.click();
        assertTrue(vehicle5.isEnabled());
        assertFalse(vehicle1.isEnabled());
        assertFalse(vehicle3.isEnabled());
        assertFalse(vehicle4.isEnabled());
        assertFalse(vehicle2.isEnabled());
        assertFalse(vehicle6.isEnabled());
        
        reset.click();
        vehicle6.click();
        assertTrue(vehicle6.isEnabled());
        assertFalse(vehicle1.isEnabled());
        assertFalse(vehicle3.isEnabled());
        assertFalse(vehicle4.isEnabled());
        assertFalse(vehicle5.isEnabled());
        assertFalse(vehicle2.isEnabled());
    }
    
    public void testSubmitButtons() 
    {
        System.out.println("testSubmitButtons");
        Button submit = window.getButton("buttonSubmit");
        Button vehicle1 = window.getButton("vehicle1");
        Button destinations1 = window.getButton("destination1");
        Button suspect1 = window.getButton("suspect1");
        
        vehicle1.click();
        destinations1.click();
        suspect1.click();
        submit.click();
        Solution expected = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        assertEquals(expected, ctrl.showDialog());
        assertFalse(view.isVisible());
    }
    
    public void testCancelButton() 
    {
        System.out.println("testCancelButton");
        Button cancel = window.getButton("buttonCancel");
        
        cancel.click();
        assertFalse(view.isVisible());
    }
}
