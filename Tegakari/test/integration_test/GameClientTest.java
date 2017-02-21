package integration_test;
import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import junit.framework.TestCase;
import tegakari.AccusationMessage;
import tegakari.ActionCard;
import tegakari.Attribute;
import tegakari.Card;
import tegakari.CardMessage;
import tegakari.ClueCard;
import tegakari.ClueType;
import tegakari.Direction;
import tegakari.GameClient;
import tegakari.GameEngine;
import tegakari.GameState;
import tegakari.Hand;
import tegakari.HistoryLog;
import tegakari.HumanPlayer;
import tegakari.Lobby;
import tegakari.Player;
import tegakari.PrivateTipCard;
import tegakari.Protocol;
import tegakari.SnoopCard;
import tegakari.Solution;
import tegakari.SuggestionCard;
import tegakari.SuggestionCardLogic;
import tegakari.SuperSleuthCard;
import tegakari.Suspect;
import tegakari.SuspectCard;
import tegakari.Table;
import tegakari.Theme;
/**
 * 
 * @author Jonathan Molina
 */
public class GameClientTest extends TestCase
{
    private int kPort = 8080;
    private GameClient client;
    private DummyServer server;
    private Player self, fromPlayer;
    private GameEngine engine;
    private GameState state;
    
    public GameClientTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {   
        server = new DummyServer(kPort);
        client = new GameClient("localhost", kPort);
        self = new HumanPlayer("self", new Hand(), null);
        fromPlayer = new HumanPlayer("from", new Hand(), null);
        Queue<Player> players = new ArrayDeque<Player>();
        players.add(self);
        players.add(fromPlayer);
        Table table = new Table(new Theme());
        table.buildActionDeck();
        table.buildClueDeck();
        state = new GameState(players, self, table);
        engine = new GameEngine(state, client, true);
        client.setPlayer(self);
        client.setGameEngine(engine);
    }
    
    public void testHandleCardClueCard()
    {
        System.out.println("Testing game client handle card for clue card");
        ClueCard card = new SuspectCard(new Suspect("test", null, null));
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        CardMessage msg = new CardMessage(self, fromPlayer, list);
        engine.setExpectSleuth(1);
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendCardMessage(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(1, server.msgs.size());
        assertTrue(server.msgs.remove() instanceof HistoryLog);
    }
    
    public void testHandleCardSnoopCard()
    {
        System.out.println("Testing game client handle card for snoop card");
        ActionCard card = new SnoopCard(Direction.LEFT, "testing.img");
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        CardMessage msg = new CardMessage(self, fromPlayer, list);
        engine.setScanner(new Scanner("1"));
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendCardMessage(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(1, server.msgs.size());
        assertTrue(server.msgs.remove() instanceof CardMessage);
    }
    
    public void testHandleCardPrivateTipCard()
    {
        System.out.println("Testing game client handle card for private tip card");
        ActionCard card = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "testing.img");
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        CardMessage msg = new CardMessage(self, fromPlayer, list);
        engine.setScanner(new Scanner("1\n1"));
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendCardMessage(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(2, server.msgs.size());
        assertTrue(server.msgs.remove() instanceof CardMessage);
        assertTrue(server.msgs.remove() instanceof HistoryLog);
    }
    
    public void testHandleCardSuperSleuthCard()
    {
        System.out.println("Testing game client handle card for sleuth card");
        ActionCard card = new SuperSleuthCard(ClueType.SUSPECT, Attribute.MALE, "image.img");
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        CardMessage msg = new CardMessage(self, fromPlayer, list);
        engine.setScanner(new Scanner("1"));
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendCardMessage(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(1, server.msgs.size());
        assertTrue(server.msgs.remove() instanceof CardMessage);
    }
    
    public void testHandleProtocolGameReady()
    {
        System.out.println("Testing game client handle card for game ready protocol");
        Lobby lobby = new Lobby(3, 5);
        client.setLobby(lobby);
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(Protocol.GAME_READY);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertTrue(lobby.isGameReady());
    }
    
    public void testHandleProtocolGameStart()
    {
        System.out.println("Testing game client handle card for game start protocol");
        Lobby lobby = new Lobby(3, 5);
        client.setLobby(lobby);
        lobby.setEngine(engine);
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(Protocol.GAME_START);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertTrue(lobby.isStartGame());
    }
    
    public void testHandleProtocolEndTurn()
    {
        System.out.println("Testing game client handle card for end turn protocol");
        Lobby lobby = new Lobby(3, 5);
        client.setLobby(lobby);
        lobby.setEngine(engine);
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(Protocol.END_TURN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(fromPlayer, state.getTurnPlayer());
    }
    
    public void testHandleOtherSuggestionCardLogic()
    {
        System.out.println("Testing game client handle other for suggestion logic");
        SuggestionCard card = new SuggestionCard(true, "card.img");
        Theme theme = new Theme();
        SuggestionCardLogic logic = new SuggestionCardLogic(
                card, self, theme.getDestinations().get(0), 
                new Solution(theme.getSuspects().get(0), 
                    theme.getVehicles().get(0), 
                    theme.getDestinations().get(0)));
        engine.setScanner(new Scanner("1"));
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(logic);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals(0, server.msgs.size());
    }
    
    public void testHandleOtherAccusationMessage()
    {
        System.out.println("Testing game client handle ther for Accusation Message");
        SuggestionCard card = new SuggestionCard(true, "card.img");
        Theme theme = new Theme();
        AccusationMessage msg = new AccusationMessage(
                new Solution(theme.getSuspects().get(0), 
                    theme.getVehicles().get(0), 
                    theme.getDestinations().get(0)), 
                new Solution(theme.getSuspects().get(0), 
                    theme.getVehicles().get(0), 
                    theme.getDestinations().get(1)),
                self);
        msg.setIsCorrect(false);
        engine.setScanner(new Scanner("1"));
        System.err.close();
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertFalse(state.getTurnPlayer().isInGame());
    }
    
    public void testHandleOtherHistoryLog()
    {
        System.out.println("Testing game client handle other for History Log");
        HistoryLog log = new HistoryLog();
        log.addToLog("testing log");
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients(log);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals("testing log\n", state.getHistoryLog().toString());
    }
    
    public void testHandleOtherString()
    {
        System.out.println("Testing game client handle other for String");
        try {
            server.listen();
            client.openConnection();
        } catch (IOException ex) {
            fail();
        }
        server.sendToAllClients("testing log");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            fail();
        }
        server.stopListening();
        try {
            server.close();
            client.closeConnection();
        } catch (IOException ex) {
            fail();
        }
        assertEquals("testing log\n", state.getHistoryLog().toString());
    }
    
    public void testSetterGetter()
    {
        assertNull(client.getTurnPlayer());
        assertFalse(client.isGameReady());
    }
    
    class DummyServer extends AbstractServer implements Serializable
    {
        public Queue<Object> msgs;
        
        public DummyServer(int port)
        {
            super(port);
            msgs = new ArrayDeque<Object>();
        }
        
        public void sendCardMessage(CardMessage msg)
        {
            sendToAllClients(msg);
        }

        @Override
        protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
            msgs.add(msg);
        }
        
    }
}
