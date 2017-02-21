/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import java.io.*;
import java.util.*;
import junit.framework.TestCase;
import tegakari.*;
import static org.mockito.Mockito.*;
import com.lloseng.ocsf.client.AbstractClient;

/**
 *
 * @author DeionLaw
 */
public class LobbyTest extends TestCase
{
    GameEngine engine = mock(GameEngine.class);
    GameClient client = mock(GameClient.class);
    Lobby zeroLobby = new Lobby(0, 0);
    Lobby fiveLobby = new Lobby(3, 5);
    Player p1 = mock(HumanPlayer.class);
    Player p2 = mock(HumanPlayer.class);
    Player p3 = mock(HumanPlayer.class);
    Player p4 = mock(HumanPlayer.class);
    Player p5 = mock(HumanPlayer.class);
    
    public LobbyTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        zeroLobby.setEngine(engine);
        zeroLobby.setClient(client);
        fiveLobby.setEngine(engine);
        fiveLobby.setClient(client);
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    public void testGameStart() 
    {
        assertFalse(zeroLobby.isStartGame());
        when(engine.isTurn()).thenReturn(true);
        
        zeroLobby.setStartGame();
        
        assertTrue(zeroLobby.isStartGame());
    }
        
    public void testThemeType() 
    {
        //assertNull(zeroLobby.getThemeType());
        assertEquals(ThemeType.GREEK, zeroLobby.getThemeType());
        
        zeroLobby.setThemeType(ThemeType.WESTERN);
        assertEquals(ThemeType.WESTERN, zeroLobby.getThemeType());
        
        zeroLobby.setThemeType(ThemeType.GREEK);
        assertEquals(ThemeType.GREEK, zeroLobby.getThemeType());
    }
    
    public void testGetPlayers()
    {
        Queue<Player> players = new LinkedList<Player>();
        assertEquals(0, fiveLobby.getPlayers().size());
        
        players.add(p1);
        fiveLobby.updatePlayers(players);
        assertEquals(players, fiveLobby.getPlayers());
        players.add(p2);
        fiveLobby.updatePlayers(players);
        assertEquals(players, fiveLobby.getPlayers());
        players.add(p3);
        fiveLobby.updatePlayers(players);
        assertEquals(players, fiveLobby.getPlayers());
        players.add(p4);
        fiveLobby.updatePlayers(players);
        assertEquals(players, fiveLobby.getPlayers());
        players.add(p5);
        fiveLobby.updatePlayers(players);
        assertEquals(players, fiveLobby.getPlayers());
        
    }
    
    public void testGetGameEngine() 
    {
        assertEquals(engine, zeroLobby.getGameEngine());
    }
    
    public void testGetNumPlayersToStart() 
    {
        assertEquals(0, zeroLobby.getNumPlayersToStart());
        assertEquals(3, fiveLobby.getNumPlayersToStart());
        
        Queue<Player> players = new LinkedList<Player>();
        
        players.add(p1);
        fiveLobby.updatePlayers(players);
        assertEquals(2, fiveLobby.getNumPlayersToStart());
        players.add(p2);
        fiveLobby.updatePlayers(players);
        assertEquals(1, fiveLobby.getNumPlayersToStart());
        players.add(p3);
        fiveLobby.updatePlayers(players);
        assertEquals(0, fiveLobby.getNumPlayersToStart());
        players.add(p4);
        fiveLobby.updatePlayers(players);
        assertEquals(0, fiveLobby.getNumPlayersToStart());
        players.add(p5);
        fiveLobby.updatePlayers(players);
        assertEquals(0, fiveLobby.getNumPlayersToStart());
    }
    
    public void testReadyGame() 
    {
        assertFalse(fiveLobby.isGameReady());
        fiveLobby.readyGame();
        assertTrue(fiveLobby.isGameReady());
    }
    
    
    public void testIsFirstPlayer()
    {
        GameClient p1Client = mock(GameClient.class);
        GameClient p2Client = mock(GameClient.class);
        
        Lobby p1Lobby = new Lobby(2, 2);
        p1Lobby.setClient(p1Client);
        p1Lobby.setEngine(engine);
        Lobby p2Lobby = new Lobby(2, 2);
        p2Lobby.setClient(p2Client);
        p2Lobby.setEngine(engine);
        Queue<Player> players = new LinkedList<Player>();
        players.add(p1);
        players.add(p2);
        p1Lobby.updatePlayers(players);
        p2Lobby.updatePlayers(players);
        when(p1Client.getSelfPlayer()).thenReturn(p1);
        when(p2Client.getSelfPlayer()).thenReturn(p2);
        when(p1.equalsName(players.peek())).thenReturn(true);
        when(p2.equalsName(players.peek())).thenReturn(false);
        
        assertTrue(p1Lobby.isFirstPlayer());
        assertFalse(p2Lobby.isFirstPlayer());
    }
    
    public void testCheckPlayers()
    {
        Queue<Player> players = new LinkedList<Player>();
        players.add(p1);
        players.add(p2);
        
        fiveLobby.updatePlayers(players);
        when(p1.getName()).thenReturn("Shiro");
        when(p2.getName()).thenReturn("Sora");
        
        assertFalse(fiveLobby.checkPlayers("Shiro"));
        assertTrue(fiveLobby.checkPlayers("Izuna"));
    }
        
    public void testGetSelfName()
    {
        Queue<Player> players = new LinkedList<Player>();
        players.add(p1);
        
        fiveLobby.updatePlayers(players);
        when(p1.getName()).thenReturn("Shiro");
        when(client.getSelfPlayer()).thenReturn(p1);
        
        assertEquals("Shiro", fiveLobby.getSelfName());
    }
    
}
