package integration_test;

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
import java.awt.event.KeyEvent;
import org.uispec4j.interception.WindowInterceptor;
import junit.framework.TestCase;

/**
 *
 * @author DeionLaw
 */
public class ScreenNameControllerTest extends UISpecTestCase
{

    private ScreenNameDialog view;
    private ScreenNameController ctrl;
    private LobbyGUI parent;
    private Lobby lobby;
    private String invalidCharText = "Please use only alphanumeric characters and "
            + "underscores.";
    private String invalidLengthText = "Size of screen name must be within 1 to 16 "
            + "characters.";
    private String sameNameText = "Screen name already in use. Choose another.";
    private String fullLobbyText = "Lobby is full. Try again later.";
    private String titlePrefix = "Tegakari: ";
    private Queue<Player> fakeQ = new LinkedList<Player>();

    public ScreenNameControllerTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
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

    public void testKeyPressed()
    {
        Window window = new Window(view);
        ctrl.keyReleased(null);
        ctrl.keyTyped(null);

        TextBox errorText = window.getTextBox("ErrorText");
        TextBox nameEntry = window.getInputTextBox("ScreenNameField");
        nameEntry.setText("!");

        JButton btn = new JButton("");

        ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_ENTER,
                KeyEvent.VK_ENTER, '0'));

        assertEquals(invalidCharText, errorText.getText());
        Window mainWindow = WindowInterceptor.run(new Trigger()
        {
            public void run()
            {
                JButton btn = new JButton("");
                ctrl.keyPressed(new KeyEvent(btn, 0, 0, KeyEvent.VK_ESCAPE,
                KeyEvent.VK_ESCAPE, '0'));
            }
        });
        
        assertTrue(mainWindow.isVisible());
        assertFalse(window.isVisible());
    }
}
