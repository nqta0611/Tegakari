package GUI_test;

import allguis.*;
import tegakari.*;
import org.uispec4j.*;
import org.uispec4j.interception.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class AccusationConfirmTest extends UISpecTestCase {
    private AccusationConfirm view;
    private Suspect suspect;
    private Vehicle vehicle;
    private Destination destination;
    private JFrame parent;
    private GameTable gameTable;
    private Solution accuse;
    private Lobby lobby;
    private Window window;
    private AccusationConfirmController ctrl;
    
    public AccusationConfirmTest(String testName) {
        super(testName);

        Theme theme = new Theme();
        suspect = theme.getSuspects().get(0);
        vehicle = theme.getVehicles().get(0);
        destination = theme.getDestinations().get(0);
        
        lobby = new Lobby(4,4);
        accuse = new Solution(suspect, vehicle, destination);
//        GameTableController ctrl = new GameTableController();

        parent = new JFrame();
        ctrl = new AccusationConfirmController();
        view = new AccusationConfirm(ctrl, parent, true, accuse);
        ctrl.setup(view);
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
     * Test of showDialog method, of class AccusationConfirm.
     */
    public void testOkButtons() 
    {
        System.out.println("testOkButtons");
        Button okButton = window.getButton("okButton");
       
        assertFalse(ctrl.showDialog());
        okButton.click();
        assertTrue(ctrl.showDialog());
        assertFalse(view.isVisible());
    }
    
    public void testCancelButton() 
    {
        System.out.println("testCancelButton");
        Button cancel = window.getButton("cancelButton");
        
        cancel.click();
        assertFalse(view.isVisible());
    }
    
    public void testLables()
    {
        System.out.println("testLables");
        TextBox accusationText = window.getTextBox("accusationText");
        TextBox prefix = window.getTextBox("prefixPromtText");
        
        
        assertEquals("Accuse Aphrodite in a Apollo's Chariot at Athena's "
                + "Forest", accusationText.getText());
        assertEquals("Are you sure you want to:", prefix.getText());
    }
}
