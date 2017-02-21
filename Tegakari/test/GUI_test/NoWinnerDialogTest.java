package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;


/**
 * UISpec4J GUI Unit test for NoWinnerDialog.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class NoWinnerDialogTest extends UISpecTestCase
{
    
    private NoWinnerDialog view;
    private JFrame parent;
    Solution solution;
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        NoWinnerController ctrl = new NoWinnerController();
        Theme theme = new Theme();
        solution =new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0),
                theme.getDestinations().get(0));
        
        parent = new JFrame();
        view = new NoWinnerDialog(parent, true, solution, ctrl);
        ctrl.setUp(view, solution);
    }

    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view);
        
        TextBox titleText = 
                window.getTextBox("titleText");
        TextBox descText = window.getTextBox("descText");
        TextBox subText = 
                window.getTextBox("subText");
        assertEquals("Game Result: No Winner", titleText.getText());
        assertEquals("<HTML>All players made false " +
                "accusations<br>or some player disconnected</HTML>", 
                descText.getText());
        assertEquals("Correct Solution: ", 
                subText.getText());
    }
    
    public void testOKButton()
    {
        System.out.println("testOKButton");
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        
        okButton.click();
        assertFalse(view.isVisible());
    }
}