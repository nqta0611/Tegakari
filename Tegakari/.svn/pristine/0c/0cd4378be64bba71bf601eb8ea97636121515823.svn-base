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
 * UISpec4J GUI Unit test for NoOneDisproveDialog.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class NoOneDisproveDialogTest extends UISpecTestCase
{
    
    private NoOneDisproveDialog view;
    private JFrame parent;
    Solution solution;
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        NoOneDisproveController ctrl = new NoOneDisproveController();
        
        Theme theme = new Theme();
        solution =new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0),
                theme.getDestinations().get(0));
        
        parent = new JFrame();
        view = new NoOneDisproveDialog(parent, true, solution, ctrl);
        ctrl.setup(solution, view);
    }

    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view);
        
        TextBox titleText = 
                window.getTextBox("titleText");
        TextBox descText = 
                window.getTextBox("descText");
        
        assertEquals("Suggestion Result", titleText.getText());
        assertEquals("No one can disprove you suggestion.", 
                descText.getText());
    }
    
    public void testOKButton()
    {
        System.out.println("testNoButton");
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        
        okButton.click();
        assertFalse(view.isVisible());
    }
}