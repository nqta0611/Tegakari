package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import guiConsoleController.*;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author DeionLaw
 */
public class ScreenNameTest extends UISpecTestCase
{
    private ScreenNameDialog view;
    private ScreenNameController ctrl;
    private LobbyGUI parent;
    private Lobby lobby;
    private String invalidCharText = "Please use only alphanumeric characters and "
                        + "underscores.";
    private String invalidLengthText = "Size of screen name must be within 1 to 16 " + 
            "characters.";
    private String sameNameText = "Screen name already in use. Choose another.";
    private String fullLobbyText = "Lobby is full. Try again later.";
    private String titlePrefix = "Tegakari: ";
    private Queue<Player> fakeQ = new LinkedList<Player>();
    
    public void setUp() throws Exception
    {
        super.setUp();
        lobby = mock(Lobby.class);
        parent = new LobbyGUI(lobby, mock(LobbyController.class));
        ctrl = new ScreenNameController();
        view = new ScreenNameDialog(parent, ctrl, true);
        ctrl.setup(view, lobby, false, parent);
        when(lobby.checkPlayers(Mockito.anyString())).thenReturn(true);
        when(lobby.checkPlayers("same")).thenReturn(false);
        when(lobby.getPlayers()).thenReturn(fakeQ);
        when(lobby.getMaxPlayersAllowed()).thenReturn(5);
        when(lobby.getSelfName()).thenReturn("name");
    }
    
    public void testErrorText()
    {
        Window window = new Window(view);
        
        Button okButton = window.getButton("OKButton");
        TextBox errorText = window.getTextBox("ErrorText");
        TextBox nameEntry = window.getInputTextBox("ScreenNameField");
        
        okButton.click();
        assertEquals(invalidLengthText, errorText.getText());
        
        nameEntry.setText("!");
        okButton.click();
        assertEquals(invalidCharText, errorText.getText());
        
        nameEntry.setText("12345678901234567");
        okButton.click();
        assertEquals(invalidLengthText, errorText.getText());
        
        nameEntry.setText("Robot 1 - Smart");
        okButton.click();
        assertEquals(invalidCharText, errorText.getText());
        
        nameEntry.setText("same");
        okButton.click();
        assertEquals(sameNameText, errorText.getText());
        
        
        when(lobby.getMaxPlayersAllowed()).thenReturn(0);
        nameEntry.setText("full");
        okButton.click();
        assertEquals(fullLobbyText, errorText.getText());
    }
    
    public void testValidEntry()
    {
        Window window = new Window(view);
        
        Button okButton = window.getButton("OKButton");
        TextBox nameEntry = window.getInputTextBox("ScreenNameField");
        
        nameEntry.setText("name");
        okButton.click();
        
        verify(lobby).sendPlayerToServer("name");
        assertFalse(view.isVisible());
    }
    
    public void testBack()
    {
        Window nameWindow = new Window(view);
        
        Button back = nameWindow.getButton("BackButton");
        Window mainWindow = WindowInterceptor.run(back.triggerClick());
        
        assertTrue(mainWindow.isVisible());
        assertFalse(nameWindow.isVisible());
    }
}