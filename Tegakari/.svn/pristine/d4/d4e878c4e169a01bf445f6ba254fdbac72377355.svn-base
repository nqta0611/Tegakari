package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import static junit.framework.Assert.assertEquals;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;

/**
 * UISpec4J GUI Unit test for NotePadDialog.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class NotePadDialogTest extends UISpecTestCase
{
    private NotePadController ctrl;
    private NotePadDialog view;
    private JFrame parent;
    private Theme theme;
             
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        parent = new JFrame();
        theme = new Theme();
        ctrl = new NotePadController();
        view = new NotePadDialog(parent, true, theme, ctrl);
        ctrl.setup(false, view);
    }
    
    public void testText()
    {
        Window window = new Window(view);
        List<Suspect> suspects = theme.getSuspects();
        List<Vehicle> vehicles = theme.getVehicles();
        List<Destination> destinations = theme.getDestinations();
        
        int suspectIndex = 0;
        int vehicleIndex = 0;
        int destinationIndex = 0;
        
        TextBox text1 = window.getTextBox("destination1");
        TextBox text2 = window.getTextBox("destination2");
        TextBox text3 = window.getTextBox("destination3");
        TextBox text4 = window.getTextBox("destination4");
        TextBox text5 = window.getTextBox("destination5");
        TextBox text6 = window.getTextBox("destination6");
        TextBox text7 = window.getTextBox("destination7");
        TextBox text8 = window.getTextBox("destination8");
        TextBox text9 = window.getTextBox("destination9");
        TextBox text10 = window.getTextBox("suspect1");
        TextBox text11 = window.getTextBox("suspect2");
        TextBox text12 = window.getTextBox("suspect3");
        TextBox text13 = window.getTextBox("suspect4");
        TextBox text14 = window.getTextBox("suspect5");
        TextBox text15 = window.getTextBox("suspect6");
        TextBox text16 = window.getTextBox("vehicle1");
        TextBox text17 = window.getTextBox("vehicle2");
        TextBox text18 = window.getTextBox("vehicle3");
        TextBox text19 = window.getTextBox("vehicle4");
        TextBox text20 = window.getTextBox("vehicle5");
        TextBox text21 = window.getTextBox("vehicle6");

        TextBox text22 = window.getTextBox("suspectLabel");
        TextBox text23 = window.getTextBox("suspectPlayerLabel");
        TextBox text24 = window.getTextBox("suspectPlayers");
        TextBox text25 = window.getTextBox("vehicleLabel");
        TextBox text26 = window.getTextBox("vehiclePlayerLabel");
        TextBox text27 = window.getTextBox("vehiclePlayers");
        TextBox text28 = window.getTextBox("destinationLabel");
        TextBox text29 = window.getTextBox("destinationPlayerLabel");
        TextBox text30 = window.getTextBox("destinationPlayers");
        
        
        assertEquals(destinations.get(destinationIndex++).getName(), text1.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text2.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text3.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text4.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text5.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text6.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text7.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text8.getText());
        assertEquals(destinations.get(destinationIndex++).getName(), text9.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text10.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text11.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text12.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text13.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text14.getText());
        assertEquals(suspects.get(suspectIndex++).getName(), text15.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text16.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text17.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text18.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text19.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text20.getText());
        assertEquals(vehicles.get(vehicleIndex++).getName(), text21.getText());
        
        assertEquals("Suspect", text22.getText());
        assertEquals("Players", text23.getText());
        assertEquals("P1    P2     P3    P4    P5", text24.getText());
        assertEquals("Vehicle", text25.getText());
        assertEquals("Players", text26.getText());
        assertEquals("P1    P2    P3    P4    P5", text27.getText());
        assertEquals("Destination", text28.getText());
        assertEquals("Players", text29.getText());
        assertEquals("P1     P2     P3    P4    P5", text30.getText());
    }
    
    public void testCheckBoxes()
    {
        Window window = new Window(view);
        
        List<JButton> susp = view.suspect;
        List<JButton> veh = view.vehicle;
        List<JButton> dest = view.destination;
        
        for (JButton btn: susp)
        {
            btn.doClick();
        }
        for (JButton btn: veh)
        {
            btn.doClick();
        }
        
        for (JButton btn: dest)
        {
            btn.doClick();
        }
        
        for (JButton btn: susp)
        {
            assertEquals(btn.getBackground(), Color.blue);
        }
        for (JButton btn: veh)
        {
            assertEquals(btn.getBackground(), Color.blue);
        }
        
        for (JButton btn: dest)
        {
            assertEquals(btn.getBackground(), Color.blue);
        }
    }
}
