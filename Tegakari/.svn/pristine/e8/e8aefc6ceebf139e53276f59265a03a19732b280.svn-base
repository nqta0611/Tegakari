package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;
import guiConsoleController.*;


/**
 * UISpec4J GUI Unit test for MainWindow.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class MainWindowTest extends UISpecTestCase
{
    
    private MainWindow view;
    private MainWindowController ctrl;
    private JFrame parent;
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        
        ctrl = mock(MainWindowController.class);
        parent = new JFrame();
        view = new MainWindow(ctrl);
    }

    public void testOpenHelp()
    {
        System.out.println("testOpenHelp");
        //view.openHelp();
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        view.openHelp();
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("About").
                triggerButtonClick("quitButton")).run();
    }
    
    /*public void testImage()
    {
        System.out.println("testImage");
        Window window = new Window(view);
        
        
        ImageIcon il;
        //window.getTextBox("titleIMG")
        
        assertEquals("\"Clue\" in Japanese", 
                subText.getText());
    }*/
    
    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view);
        
        TextBox subText = 
                window.getTextBox("descText");
        assertEquals("\"Clue\" in Japanese", 
                subText.getText());
    }
    
    public void testPlayButton()
    {
        System.out.println("testPlayButton");
        Window window = new Window(view);
        Button playButton = window.getButton("playButton");
        
        playButton.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    
    static
    {
        UISpec4J.init();
    }
    
    public void testHelpButton()
    {
        System.out.println("testHelpButton");
        Window window = new Window(view);
        Button helpButton = window.getButton("helpButton");
        
        helpButton.click();
        ArgumentCaptor<ActionEvent> argument = 
                ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
}