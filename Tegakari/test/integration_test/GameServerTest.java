package integration_test;

import com.lloseng.ocsf.server.ConnectionToClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import static junit.framework.Assert.*;
import junit.framework.TestCase;
import tegakari.*;

/**
 *
 * @author Chris Thibodeau - cathibod
 */
public class GameServerTest extends TestCase 
{
    
    GameServer server;
    GameClient client1;
    GameClient client2;
    GameClient client3;
    GameClient client4;
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Lobby lobby1;
    Lobby lobby2;
    Lobby lobby3;
    Lobby lobby4;
    Theme theme;
    GameState state;
    Table table;
    ThemeType themeType;
    Queue<Player> players;
    private static final int kDefaultPort = 51000;
        
    public GameServerTest(String testName) 
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        server = new GameServer();
        players = new ArrayDeque<Player>();
        player1 = new HumanPlayer("user1");
        player2 = new HumanPlayer("user2");
        player3 = new HumanPlayer("user3");
        player4 = new HumanPlayer("user3");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        
        client1 = new GameClient("localhost", kDefaultPort);
        client2 = new GameClient("localhost", kDefaultPort);
        client3 = new GameClient("localhost", kDefaultPort);
        client4 = new GameClient("localhost", kDefaultPort);
        client1.setPlayer(player1);
        client1.setLobby(lobby1);
        client2.setPlayer(player2);
        client2.setLobby(lobby2);
        client3.setPlayer(player3);
        client3.setLobby(lobby3);
        client4.setPlayer(player4);
        client4.setLobby(lobby4);
        
        
        lobby1 = new Lobby(1, 4);
        lobby1.setClient(client1);
        GameEngine engine1 = new GameEngine(state, client1, false);
        engine1.setScanner(new Scanner("n\nn\nn"));
        lobby1.setEngine(engine1);
        lobby2 = new Lobby(1, 4);
        lobby2.setClient(client2);
        GameEngine engine2 = new GameEngine(state, client1, false);
        engine2.setScanner(new Scanner("n\nn\nn"));
        lobby2.setEngine(engine2);
        lobby3 = new Lobby(1, 4);
        lobby3.setClient(client3);
        GameEngine engine3 = new GameEngine(state, client1, false);
        engine3.setScanner(new Scanner("n\nn\nn"));
        lobby3.setEngine(engine3);
        lobby4 = new Lobby(1, 4);
        lobby4.setClient(client4);
        GameEngine engine4 = new GameEngine(state, client1, false);
        engine4.setScanner(new Scanner("n\nn\nn"));
        lobby4.setEngine(engine4);
        
        table = new Table(new Theme());
        state = new GameState(players, client1.getSelfPlayer(), table);
        
    }
    
    /**
     * Test of resetServer method, of class GameServer.
     */
    public void testResetServer() 
    {
        
        System.out.println("resetServer");
        GameServer instance = new GameServer();
        instance.resetServer();
        
        assertEquals(false, instance.startedGame());
        assertEquals(false, instance.gameOver());
    }

    /**
     * Test of startedGame method, of class GameServer.
     * true assert to be tested in handleMessageFrom Client test.
     */
    public void testStartedGame() 
    {
        System.out.println("startedGame");
        GameServer instanceServer = new GameServer();
        assertEquals(false, instanceServer.startedGame());
    }

    /**
     * Test of setGameOver method, of class GameServer.
     */
    public void testSetGameOver() 
    {
        System.out.println("setGameOver");
        GameServer instanceServer = new GameServer();
        GameClient instanceClient = new GameClient("localhost", kDefaultPort);
        HumanPlayer instancePlayer = new HumanPlayer("player");
        Theme instanceTheme = new Theme();
        Table instanceTable = new Table(instanceTheme);
        ArrayDeque<Player> instanceQueue = new ArrayDeque<Player>();
        instanceQueue.add(instancePlayer);
        GameState instanceState = new GameState(instanceQueue, instancePlayer,
                instanceTable);
        GameEngine instanceEngine = new GameEngine(instanceState, 
                instanceClient, true);
        //instanceEngine.setScanner(new Scanner("n\nn\nn"));
        instanceClient.setGameEngine(instanceEngine);
        Solution instanceSolution = new Solution(instanceTheme.getSuspects().get(0),
                instanceTheme.getVehicles().get(0), instanceTheme.getDestinations().get(0));
        try
        {
            assertEquals(false, instanceServer.gameOver());
        }
        catch(Exception e)
        {
            System.out.println("Null caught");
        }
        try
        {
            instanceServer.listen();
            instanceClient.openConnection();
            instanceServer.sendToAllClients(instanceSolution);

        }
        catch(IOException e){
            System.out.println("setGameOver - listen open solution");
        }
        instanceServer.setGameOver();
        try
        {
            instanceServer.close();
        }
        catch(IOException e){
            System.out.println("setGameOver - close");
        }
        assertEquals(true, instanceServer.gameOver());
    }
    
    /**
     * Test of gameOver method, of class GameServer.
     * true assert to be tested in setGameOver test.
     */
    public void testGameOver() 
    {
        System.out.println("setGameOver");
        GameServer instance = new GameServer();
        assertEquals(false, instance.gameOver());
        
    }

    /**
     * Test of handleMessageFromClient method, of class GameServer.
     * Method will also test protected methods clientConnected and 
     * clientDisconnected.
     * Method will also test private methods makeNewPlayerQueue, 
     * sendToAllRobots, getPlayerFromClient, createNotepadFromTheme,
     * replacePlayerWithAI, 
     * 
     * Excludes PLAYER_DISCONNECTED_FROM_LOBBY message to be tested in 
     * testClientDisconnected.
     */
    
    public void testHandleMessageFromClient() 
    {
        System.out.println("handleMessageFromClient");
        try
        {
            server.listen();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //client.sendToServer(Protocol.SEND_PLAYERS);
        assertTrue(lobby1.joinLobby());
        assertTrue(lobby2.joinLobby());
        assertTrue(lobby3.joinLobby());
        assertTrue(lobby4.joinLobby());
        lobby1.setTestingMode("./test/testsetup/t1clue", "./test/testsetup/t1action");
        try
        {
            client1.sendToServer(client1.getSelfPlayer());
            client2.sendToServer(client2.getSelfPlayer());
            client3.sendToServer(client3.getSelfPlayer());
            client4.sendToServer(client4.getSelfPlayer());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            client1.sendToServer(Protocol.TESTING_MODE);
            client1.sendToServer(Protocol.ORDERED_CLUE_DECK);
            client1.sendToServer("./test/testsetup/t1clue");
            client1.sendToServer(Protocol.ORDERED_ACTION_DECK);
            client1.sendToServer("./test/testsetup/t1action");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            client1.sendToServer(Protocol.GAME_READY);
            //client1.sendToServer(Protocol.GAME_START);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            client4.sendToServer(Protocol.PLAYER_DISCONNECTED_FROM_LOBBY);
            client4.sendToServer(client4.getSelfPlayer());
            //client1.sendToServer(Protocol.GAME_START);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        /*
         * client.sendToServer(Protocol.GAME_READY);
         * client.sendToServer(client.getSelfPlayer());
         * client.sendToServer(Protocol.GAME_START);
         */
        //lobby1.startGame();
        //test testing mode. verify cards?
        //Solution solution = client1.getSolution();
        //assertEquals("Athena's Forest", solution.getDestination());
        //assertEquals("Aphrodite", solution.getSuspect());
        //assertEquals("Apollo's Chariot", solution.getVehicle());
        //assertTrue(lobby1.isGameReady());
        
        
        try
        {
            client1.closeConnection();
            client2.closeConnection();
            client3.closeConnection();
            client4.closeConnection();
            server.close();
        }
        catch (IOException ex)
        {
            //System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Test of main method, of class GameServer.
     */
    //public void testMain() 
    //{
        //System.out.println("main");
        /*
        * DISCLAIMER:
        * Written test was approved to test main method in GameServer.
        * 
        * Reason: while(true) loop exists. Suggested that Threads should be used
        *           and that no source code should be modififed specifically 
        *           for testing in this instance. Found that thread.stop() is 
        *           is a deprecated method. thread.interrupt() merely sets a 
        *           flag. On 2/22 @ 12pm Written Test Approved.
        * Test can be found by Honey Badgers wiki --> 
        *           --> Integration Schedule under Project Planning
        *           --> Row: Game Server, Column: Integration Tests Written
        *           --> Click Manual Test
        * 
        * FIXED, MAIN METHOD CHANGED FOR CONSOLE USAGE, WRITTEN TEST 
        * NO LONGER NEEDED.
        * 
        */
        /*String[] args = {" -i", " ./test/integration_test/AppTesttxt.in", 
                            " ./test/integration_test/AppTesttxt.out", 
                            " ./test/integration_test/AppTesttxt.err"};
                    System.out.println("Test5");
        GameServer.main(args);
                    System.out.println("Test6");

        try
        {
            System.out.println("Test");
            client1.openConnection();
            System.out.println("c1");
            client2.openConnection();
            System.out.println("c2");
            client3.openConnection();
            System.out.println("c3");
            client4.openConnection();
            System.out.println("c4");
            client4.closeConnection();
        }
        catch(IOException e)
        {
            fail("failed open connection: main");
        }
        
        try
        {
            client1.sendToServer(Protocol.GAME_START);
        }
        catch(IOException e)
        {
            fail("failed open connection: main");
        }
        server.setStarted();
        server.setGameOver1();
        
        try
        {
            client1.closeConnection();
            client2.closeConnection();
            client3.closeConnection();
        }
        catch(IOException e)
        {
            fail("failed close connection: main");
        }
    }*/
    
}


