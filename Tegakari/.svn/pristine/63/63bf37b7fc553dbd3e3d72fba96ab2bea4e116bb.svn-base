/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author roh
 */
public class HelpDialogTest extends UISpecTestCase 
{
    private HelpDialog view;
    private Window window;
    
    public HelpDialogTest(String testName) {
        super(testName);
        JFrame parent = new JFrame();
        
        view = new HelpDialog(parent, true);
        window = new Window(view);
    }

    public void testButton() {
        Button quitButton = window.getButton("quitButton");
        
        quitButton.click();
        assertFalse(view.isVisible());
        
    }
}
