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
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class LobbyGUITest extends UISpecTestCase 
{
    private Lobby lobby;
    private LobbyController ctrl;
    private LobbyGUI view;
    private Queue<Player> players;
    private Player p1;
    private Window window;
    private GameClient mockClient;
    
    
    public LobbyGUITest(String testName) {
        super(testName);
        
        mockClient = mock(GameClient.class);
        players = new ArrayDeque<Player>();
        p1 = new HumanPlayer("player1");
        lobby = new Lobby(4, 4);
        ctrl = new LobbyController();
        ctrl.setup(view, lobby, false);
        view = new LobbyGUI(lobby, ctrl);
        lobby.setClient(mockClient);
        
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
     * Test of getLobby method, of class LobbyGUI.
     */
    public void testPlayer1Lobby() 
    {
        System.out.println("testPlayer1Lobby");
        TextBox player1Name = window.getTextBox("player1NameText");
        TextBox player2Name = window.getTextBox("player2NameText");
        TextBox player3Name = window.getTextBox("player3NameText");
        TextBox player4Name = window.getTextBox("player4NameText");
        Button robotButton = window.getButton("robotButton");
        Button startButton = window.getButton("startButton");
        Button themeButton = window.getButton("themeButton");
        
        when(mockClient.getSelfPlayer()).thenReturn(p1);
        
        assertEquals(" ", player1Name.getText());
        assertEquals(" ", player2Name.getText());
        assertEquals(" ", player3Name.getText());
        assertEquals(" ", player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
        addPlayer(p1);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals("", player2Name.getText());
        assertEquals("", player3Name.getText());
        assertEquals("", player4Name.getText());
        assertTrue(robotButton.isEnabled());
        assertTrue(themeButton.isEnabled());
        assertFalse(startButton.isEnabled());
        
        Player p2 = new HumanPlayer("player2");
        addPlayer(p2);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals("", player3Name.getText());
        assertEquals("", player4Name.getText());
        assertTrue(robotButton.isEnabled());
        assertTrue(themeButton.isEnabled());
        assertFalse(startButton.isEnabled());
        
        Player p3 = new HumanPlayer("player3");
        addPlayer(p3);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals(p3.getName(), player3Name.getText());
        assertEquals("", player4Name.getText());
        assertTrue(robotButton.isEnabled());
        assertTrue(themeButton.isEnabled());
        assertFalse(startButton.isEnabled());
        
        Player p4 = new HumanPlayer("player4");
        addPlayer(p4);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals(p3.getName(), player3Name.getText());
        assertEquals(p4.getName(), player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertTrue(themeButton.isEnabled());
        assertTrue(startButton.isEnabled());
    }
    
    private void addPlayer(Player player)
    {
        players.add(player);
        lobby.updatePlayers(players);
        view.update(null, null);
    }

    /**
     * Test of update method, of class LobbyGUI.
     */
    public void testNotPlayer1Lobby() {
        System.out.println("testNotPlayer1Lobby");
        TextBox player1Name = window.getTextBox("player1NameText");
        TextBox player2Name = window.getTextBox("player2NameText");
        TextBox player3Name = window.getTextBox("player3NameText");
        TextBox player4Name = window.getTextBox("player4NameText");
        Button robotButton = window.getButton("robotButton");
        Button startButton = window.getButton("startButton");
        Button themeButton = window.getButton("themeButton");
        
        assertEquals(" ", player1Name.getText());
        assertEquals(" ", player2Name.getText());
        assertEquals(" ", player3Name.getText());
        assertEquals(" ", player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
        addPlayer(p1);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals("", player2Name.getText());
        assertEquals("", player3Name.getText());
        assertEquals("", player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
        Player p2 = new HumanPlayer("player2");
        addPlayer(p2);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals("", player3Name.getText());
        assertEquals("", player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
        Player p3 = new HumanPlayer("player3");
        addPlayer(p3);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals(p3.getName(), player3Name.getText());
        assertEquals("", player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
        Player p4 = new HumanPlayer("player4");
        addPlayer(p4);
        
        assertEquals(p1.getName(), player1Name.getText());
        assertEquals(p2.getName(), player2Name.getText());
        assertEquals(p3.getName(), player3Name.getText());
        assertEquals(p4.getName(), player4Name.getText());
        assertFalse(robotButton.isEnabled());
        assertFalse(startButton.isEnabled());
        assertFalse(themeButton.isEnabled());
        
    }
}
