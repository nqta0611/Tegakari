package integration_test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JFrame;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;
import tegakari.*;

/**
 *
 * @author cathibod
 */
public class GameEngineHandleActionCardHelperTest extends UISpecTestCase {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream defaultOutstream = System.out;
    
    private GameEngine engineActive;
    private GameEngine engineIdle;
    private GameEngineHandleActionCardHelper engineHelperActive;
    private GameEngineHandleActionCardHelper engineHelperIdle;
    private GameState stateActive;
    private GameState stateIdle;
    private GameClient client;
    private GameServer server;
    private Queue<Player> players = new ArrayDeque<Player>();
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    
    private Queue<Player> players2 = new ArrayDeque<Player>();
    private Player playera;
    private Player playerb;
    private Player playerc;
    private Player playerd;
    private Hand hand1;
    private Hand hand2;
    private Hand hand3;
    private Hand hand4;
    private Destination dest1;
    private Destination dest2;
    private Destination dest3;
    private Destination dest4;
    private Player self;
    private tegakari.Table table;
    private tegakari.Table table2;
    private Theme theme;
    private JFrame tableGUI;
    private Lobby lobby;
    
    public GameEngineHandleActionCardHelperTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        theme = new Theme();
        table = new tegakari.Table(theme);
        table.buildActionDeck();
        table.buildClueDeck();
        
        table2 = new tegakari.Table(theme);
        table2.buildActionDeck();
        table2.buildClueDeck();
        
        client = new GameClient("localhost", 51000);
        
        player1 = new HumanPlayer("player1");
        player2 = new HumanPlayer("player2");
        player3 = new HumanPlayer("player3");
        player4 = new HumanPlayer("player4");
        
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        
        playera = new HumanPlayer("player1");
        playerb = new HumanPlayer("player2");
        playerc = new HumanPlayer("player3");
        playerd = new HumanPlayer("player4");
        
        players2.add(playera);
        players2.add(playerb);
        players2.add(playerc);
        players2.add(playerd);
        
        stateActive = new GameState(players, player1, table);
        this.engineActive = new GameEngine(stateActive, client, true);
        engineHelperActive = new GameEngineHandleActionCardHelper(engineActive,true);
        
        stateIdle= new GameState(players2, playerb, table2);
        this.engineIdle = new GameEngine(stateIdle, client, true);
        engineHelperIdle = new GameEngineHandleActionCardHelper(engineIdle,true);
        
        lobby = new Lobby(3, 5, true);
        lobby.setConsoleMode(true);
        engineActive.setLobby(lobby);
        Lobby lobby2 = new Lobby(3, 5, true);
        lobby.setConsoleMode(true);
        engineIdle.setLobby(lobby2);
        
        tableGUI = new JFrame();
        engineActive.setGameTableGUI(tableGUI);  
        engineIdle.setGameTableGUI(tableGUI);
    }
    
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void cleanUpStreams() {
        System.setOut(this.defaultOutstream);
    }

    public void testConstructors()
    {
        System.out.println("test Constructor with default isConsole");
        GameEngine engine2 = new GameEngine(this.stateActive, client);
        assertEquals(stateActive, engine2.getGameState());
    }
    
    public void testGettersSetters()
    {
        System.out.println("test Setters & Getters");
        Scanner scanner = new Scanner(System.in);
        engineActive.setScanner(scanner);
        assertEquals(scanner, engineActive.getScanner());
        scanner.close();
        
        assertEquals(tableGUI, engineActive.getGameTableGUI());
        assertEquals(stateActive, engineActive.getGameState());
    }
    
    public void testHandleSnoop1()
    {
        System.out.println("test handle Snoop - Left");
        SnoopCard snoop = new SnoopCard(Direction.LEFT, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handleSnoop(snoop);
        String expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
        
        /*System.out.println("test handle Snoop - Left (edge case)");
        snoop = new SnoopCard(Direction.LEFT, "somePath");
        sc = new Scanner("1\n");
        stateIdle = new GameState(players2, playerd, table2);
        this.engineIdle = new GameEngine(stateIdle, client, true);
        engineIdle.setScanner(sc);
        setUpStreams();
        out = engineHelperIdle.handleSnoop(snoop);
        expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));*/
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
    }
    
    public void testHandleSnoop2()
    {
        System.out.println("test handle Snoop - Right");
        SnoopCard snoop = new SnoopCard(Direction.RIGHT, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handleSnoop(snoop);
        String expected = "Pick a number from 1 - 6 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
        
        System.out.println("test handle Snoop - Right (edge case)");
        snoop = new SnoopCard(Direction.RIGHT, "somePath");
        sc = new Scanner("1\n");
    
        engineActive.setScanner(sc);
        setUpStreams();
        out = engineHelperActive.handleSnoop(snoop);
        expected = "Pick a number from 1 - 6 to snoop the card on\n" +
                   "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
    }
    
    static
    {
        UISpec4J.init();
    }
    
    public void testHandleSnoopGUI()
    {
        System.out.println("handleSnoopGUI");
        final SnoopCard snoop = new SnoopCard(Direction.LEFT, "/image/Action-PrivateTipRed.jpg");
        Queue<Player> singleList = new ArrayDeque<Player>();
        singleList.add(player1);
        GameState state = new GameState(singleList, player1, table);
        GameEngine engine = new GameEngine(state, client, false);
        final GameEngineHandleActionCardHelper engineHelper = 
                new GameEngineHandleActionCardHelper(engineActive,false);
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineHelper.handleSnoop(snoop);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Snoop").
                triggerButtonClick("card1")).run();
    }
    
    public void testHandleTip1()
    {
        System.out.println("test Handle Private Tip - Regular - No card to show");
        PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, Attribute.FEMALE, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handlePrivateTip(tip);
        String expected = "player1 played this Private Tip but you have no cards to show!\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(0, out.size());
        cleanUpStreams();
    }
    
    public void testHandleTip2()
    {
        System.out.println("test Handle Private Tip - Regular - Has card to show");
        PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "/image/Action-PrivateTipRed.jpg");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handlePrivateTip(tip);
        String expected = "1: Ares\n" +
                "player1 played this Private Tip. Input which card you would like to show.\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(2, out.size());
        assertTrue(out.get(1) instanceof HistoryLog);
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
    }
    
    public void testHandleTip3()
    {
        System.out.println("test Handle Private Tip - Show All");
        PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handlePrivateTip(tip);
        String expected = "1: Ares\n" +
                        "player1 played a Private Tip and you have shown all these cards.\n" ;
        //assertEquals(expected, outContent.toString());
        assertEquals(0, out.size());
        cleanUpStreams();
    }
    
    public void testHandleSleuth()
    {
        System.out.println("test Handle Sleuth");
        SuperSleuthCard sleuth = new SuperSleuthCard(ClueType.SUSPECT, Attribute.MALE, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handleSleuth(sleuth);
        String expected = "1: Ares\n" +
                          "Input which card you would like to show\n" ;
        //assertEquals(expected, outContent.toString());
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
    }
    
    public void testHandleSuggestion1()
    {
        System.out.println("test Handle Suggestion - Move - Swap with table");
        SuggestionCard card = new SuggestionCard(true, "somePath");
        SuggestionCardLogic logic = new SuggestionCardLogic(card, playera, theme.getDestinations().get(7), null);
        Destination moveFrom = playera.getDestination();
        Destination moveTo = theme.getDestinations().get(7);
        List<Object> out = engineHelperIdle.handleSuggestion(logic);
        assertEquals(moveTo, playera.getDestination());
        assertTrue(engineIdle.getGameState().getTable().getPile().contains(moveFrom));
        assertEquals(0, out.size());
    }
    
    public void testHandleSuggestion2()
    {
        System.out.println("test Handle Suggestion - Move - Swap with player");
        SuggestionCard card = new SuggestionCard(true, "somePath");
        SuggestionCardLogic logic = new SuggestionCardLogic(card, playera, playerb.getDestination(), null);
        Destination moveFrom = playera.getDestination();
        Destination moveTo = playerb.getDestination();
        List<Object> out = engineHelperIdle.handleSuggestion(logic);
        assertEquals(moveTo, playera.getDestination());
        assertEquals(moveFrom, playerb.getDestination());
        assertEquals(0, out.size());
    }
    
    
    public void testHandleSuggestion3()
    {
        System.out.println("test Handle Suggestion - for Me to disprove");
        SuggestionCard card = new SuggestionCard(true, "somePath");
        Solution solution = new Solution(((SuspectCard)playerb.getClueCards().get(4)).getSuspect(),
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        SuggestionCardLogic logic = new SuggestionCardLogic(card, playera, null, solution);
        logic.isDisprovable(players2);
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineHelperIdle.handleSuggestion(logic);
        String expected = "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "player1played this suggestion\n" +
                            "Ares, Apollo's Chariot, Athena's Forest\n" +
                            "1: Ares\n" +
                            "Pick a card to choose\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertTrue(out.get(1) instanceof HistoryLog);
        cleanUpStreams();
    }
    
    
}
