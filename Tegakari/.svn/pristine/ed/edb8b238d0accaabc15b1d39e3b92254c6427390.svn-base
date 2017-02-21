package GUI_test;

import org.uispec4j.*;
import allguis.*;
import guiConsoleController.PrivateTipResponseController;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

/**
 * UISpec4J GUI Unit test for PrivateTipResponseDialog.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class PrivateTipResponseDialogTest extends UISpecTestCase
{
    private PrivateTipResponseDialog view;
    private PrivateTipResponseDialog viewNone;
    private PrivateTipResponseController ctrl;
    private PrivateTipCardLogic logic;
    private Player player;
    private List<ClueCard> cluesNone;
    private List<ClueCard> clues;
    private JFrame parent;
    
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        ctrl = mock(PrivateTipResponseController.class);
        logic = mock(PrivateTipCardLogic.class);
        player = mock(Player.class);
        when(player.getName()).thenReturn("player3");
        when(logic.getTargetPlayer()).thenReturn(player);
        
        clues = new ArrayList<ClueCard>();
        cluesNone = new ArrayList<ClueCard>();
        Theme theme = new Theme();
        clues.add(new SuspectCard(theme.getSuspects().get(0)));
        parent = new JFrame();
        view = new PrivateTipResponseDialog(ctrl, parent, true, clues, logic);
        viewNone = new PrivateTipResponseDialog(ctrl, parent, true, cluesNone, 
                logic);
    }

    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view);
        Window windowNone = new Window(viewNone);
        
        TextBox titleText = window.getTextBox("titleText");
        TextBox descText = window.getTextBox("descText");
        TextBox descNoneText = windowNone.getTextBox("descText");
        
        assertEquals("Private Tip Response", titleText.getText());
        assertEquals("player3 shows you:", descText.getText());
        assertEquals("player3 has no cards to show you.", 
                descNoneText.getText());
    }
    
    public void testOKButton()
    {
        System.out.println("testNoButton");
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        
        okButton.click();
        ArgumentCaptor<ActionEvent> argument = 
                ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
        assertFalse(view.isVisible());
    }
}
