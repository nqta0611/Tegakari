package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import static junit.framework.Assert.assertFalse;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;


/**
 * UISpec4J GUI Unit test for ReplayGame.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class ReplayGameTest extends UISpecTestCase
{
    
    private ReplayGame view;
    private ReplayController ctrl;
    private JFrame parent;
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        
        ctrl = mock(ReplayController.class);

        parent = new JFrame();
        view = new ReplayGame(parent, true);
    }

    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view);
        
        TextBox titleText = 
                window.getTextBox("titleText");
        
        assertEquals("<HTML>Game Over<br>Play Again?</HTML>", 
                titleText.getText());
    }
    
    public void testNoButton()
    {
        System.out.println("testNoButton");
        Window window = new Window(view);
        Button noButton = window.getButton("noButton");
        
        view.setController(ctrl);
        noButton.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
        assertFalse(view.showDialog());
    }
    
    public void testYesButton()
    {
        System.out.println("testYesButton");
        Window window = new Window(view);
        Button yesButton = window.getButton("yesButton");
        
        view.setController(ctrl);
        yesButton.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
}