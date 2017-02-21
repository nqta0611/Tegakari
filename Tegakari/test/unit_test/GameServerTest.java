package unit_test;

import com.lloseng.ocsf.client.AbstractClient;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import tegakari.*;

/**
 *
 * @author Chris Thibodeau cathibod
 */
public class GameServerTest extends TestCase 
{
    GameServer server;
    DummyClient client;
    
    HumanPlayer player = mock(HumanPlayer.class);
    Robot robot = mock(Robot.class);
    AccusationMessage accuseMessage = mock(AccusationMessage.class);
    
    public GameServerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        server = new GameServer();
        client = new DummyClient("localhost", 51000);
        when(accuseMessage.getAccusation()).thenReturn(null);
        when(player.equalsName(player)).thenReturn(true);
    }
    
    /*
     * 
     */
    public void testHandleMessageFromClient()
    {
        System.out.println("handleMessageFromClient");
        try
        {
            server.listen();
            client.openConnection();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: failed to listen");
        }
        
        //test add player
        try
        {
            client.sendToServer(player);
            /*client.sendToServer(robot);
            //player disconnected from lobby TODO
            
            //code coverage, confirm test??
            client.sendToServer(Protocol.SEND_PLAYERS);
            client.sendToServer(Protocol.TESTING_MODE);
            client.sendToServer(Protocol.ORDERED_CLUE_DECK);
            client.sendToServer("");
            client.sendToServer(Protocol.ORDERED_ACTION_DECK);
            client.sendToServer("");
            
            client.sendToServer(Protocol.GAME_READY);
            client.sendToServer(player);
            
            client.sendToServer(Protocol.GAME_START);
            
            
            client.sendToServer(mock(CardMessage.class));
            client.sendToServer(mock(SuggestionCardLogic.class));
            client.sendToServer(accuseMessage);
            client.sendToServer(Protocol.END_TURN);*/
            client.sendToServer(mock(HistoryLog.class));
        }
        catch (IOException e)
        {
            System.out.println("ERROR: failed to send");
        }
        
        try
        {
            server.close();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: Server failed to close");
        }
        //assertTrue(client.endTurn);
        //assertTrue(client.accusationMessage);
        //assertTrue(client.cardMessage);
        //assertTrue(client.suggestionCard);
        //assertTrue(client.gameStart);
        //assertTrue(client.gameReady);
        //assertTrue(client.log);
        //assertTrue(client.players.contains(player));
        //assertTrue(client.players.contains(robot));
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
     * True assert will be tested in testHandleMessageFromClient
     */
    public void testStartedGame() {
        System.out.println("startedGame");
        
        GameServer instance = new GameServer();
        assertEquals(false, instance.startedGame());
    }

    /**
     * Test of gameOver method, of class GameServer.
     * True assert will be tested in testHandleMessageFromClient
     */
    public void testGameOver() {
        System.out.println("gameOver");
        GameServer instance = new GameServer();
        
        
        assertEquals(false, instance.gameOver());
        instance.setGameOver();
        assertEquals(true, instance.gameOver());
    }
    
    class DummyClient extends AbstractClient
    {
        Player self;
        boolean log;
        boolean endTurn;
        boolean gameOver;
        boolean accusationMessage;
        boolean suggestionCard;
        boolean cardMessage;
        boolean gameStart;
        boolean gameReady;
        boolean playerDisconnected;
        Queue<Player> players;
        
        public DummyClient(String host, int port)
        {
            super(host, port);
            this.self = null;
            players = null;
            log = false;
            endTurn = false;
            gameOver = false;
            accusationMessage = false;
            suggestionCard = false;
            cardMessage = false;
            gameStart = false;
            gameReady = false;
            playerDisconnected = false;
        }
        
        protected void handleMessageFromServer(Object msg)
        {
            if (msg instanceof Queue)
            {
                players = (Queue)msg;
            }
            // IF msg is Protocol.GAME_READY
            else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.GAME_READY)
            {
                gameReady = true;
            }
            // PREPARE lobby to start the game
            else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.GAME_START)
            {
                gameStart = true;
            }
            // IF msg is CardMessaage
            else if (msg instanceof CardMessage)
            {
                cardMessage = true;
            }
            // ENG the game
            else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.GAME_OVER)
            {
                gameOver = true;
            }
            // IF msg is SuggestionLogic
            else if (msg instanceof SuggestionCardLogic) 
            {
                suggestionCard = true;
            }
            // IF msg is Protocol.END_TURN
            else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.END_TURN) 
            {
                endTurn = true;
            }
            // IF msg is an AccusationMessage
            else if (msg instanceof AccusationMessage)
            {
                accusationMessage = true;
            }
            // IF msg is a HistoryLog
            else if (msg instanceof HistoryLog) 
            {
                log = true;
            }
        }
        
        
    }
}
