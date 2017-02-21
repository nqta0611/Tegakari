package integration_test;

import java.io.*;
import java.io.IOException;
import junit.framework.*;
import java.util.*;
import javax.swing.JFrame;
import tegakari.*;
import allguis.*;
import java.io.File;
import org.uispec4j.*;
import static org.mockito.Mockito.*;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author DeionLaw
 */
public class GameEngineTest extends UISpecTestCase 
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream defaultOutstream = System.out;
    
    private GameEngine engineActive;
    private GameEngine engineIdle;
    private GameEngine engineActiveGUI;
    private GameEngine engineIdleGUI;
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
    
    public GameEngineTest(String testName)
    {
        super(testName);
    }
    
    static
    {
        UISpec4J.init();
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
        this.engineActiveGUI = new GameEngine(stateActive, client, false);
        
        stateIdle= new GameState(players2, playerb, table2);
        this.engineIdle = new GameEngine(stateIdle, client, true);
        this.engineIdleGUI = new GameEngine(stateIdle, client, false);
        
        Lobby lobby2 = new Lobby(3, 5, true);
        Lobby lobby3 = new Lobby(3, 5, true);
        lobby3.setConsoleMode(false);
        lobby = new Lobby(3, 5, true);
        lobby.setConsoleMode(true);
        engineActive.setLobby(lobby);
        engineActiveGUI.setLobby(lobby3);
        lobby.setConsoleMode(true);
        engineIdle.setLobby(lobby2);
        engineIdleGUI.setLobby(lobby3);
        
        tableGUI = new JFrame();
        engineActive.setGameTableGUI(tableGUI);
        engineIdle.setGameTableGUI(tableGUI);
        engineActiveGUI.setGameTableGUI(tableGUI);
        engineIdleGUI.setGameTableGUI(tableGUI);
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
    
    public void testAddToLog()
    {
        System.out.println("test Log");
        assertTrue(engineActive.getGameState().getHistoryLog().isEmptyLog());
        engineActive.addToLog("new line");
        assertFalse(engineActive.getGameState().getHistoryLog().isEmptyLog());
    }
    
    public void testUpdateQ()
    {
        System.out.println("test updateQ");
        assertEquals(player1, engineActive.getGameState().getTurnPlayer());
        assertTrue(engineActive.updateQueueForNextTurn());
        assertEquals(player2, engineActive.getGameState().getTurnPlayer());
    }
    
    public void testAddCardMessage()
    {
        System.out.println("test Add Card Message");
        CardMessage message = new CardMessage(player1, player2, player2.getClueCards().get(0));
        engineActive.addCardMessage(message);
        assertEquals(message, engineActive.getGameState().removeCardMessage());
    }
    
    public void testHandleHistoryLog()
    {
        System.out.println("test handle History Log");
        HistoryLog log = new HistoryLog();
        log.addToLog("line1");
        engineActive.handleHistoryLog(log);
        assertEquals(log, engineActive.getGameState().getHistoryLog());
    }
    
    public void testIsTurn()
    {
        System.out.println("test isTurn");
        assertTrue(engineActive.isTurn());
    }
    
    public void testBeginTurn() throws Exception
    {
        System.out.println("test Begin Turn");
        Scanner sc = new Scanner("1");
        engineActive.setScanner(sc);
        engineActive.getGameState().setChosenActionCard(player1.getActionCards().get(0));
        setUpStreams();
        engineActive.beginTurn();
        
        assertTrue(engineActive.getGameState().isInAction());
        cleanUpStreams();
    }
    
    public void testFinishingTurn()
    {
        System.out.println("test Finishing Turn");
        engineActive.getGameState().setHasDrawn(true);
        engineActive.getGameState().setInAction(true);
        engineActive.getGameState().setAccusation(new Solution(null, null, null));
        setUpStreams();
        engineActive.finishingTurn();
        //assertEquals("ERROR: Failed to send to server\n" +
        //             "ERROR: Failed to send to server\n", outContent.toString());
        assertFalse(engineActive.getGameState().hasDrawn());
        assertFalse(engineActive.getGameState().isInAction());
        assertNull(engineActive.getGameState().getAccusation());
        cleanUpStreams();
    }
    
    
    public void testHandleShowCard1()
    {
        System.out.println("test Handle Show Card - Disprove");
        CardMessage message = new CardMessage(player1, player2, player2.getClueCards().get(0));
        setUpStreams();
        engineActive.handleShowCard(message);
        //assertEquals("player2 has: Phoebe's Moon\n", outContent.toString());
        cleanUpStreams();
    }
    
    public void testHandleShowCard2()
    {
        System.out.println("test Handle Show Card - ShowCard");
        CardMessage message = new CardMessage(player1, player2, player1.getClueCards().get(0));
        setUpStreams();
        engineActive.handleShowCard(message);
        //assertEquals("Showed to the player player2\nThe Card Poseidon's Ocean\n", outContent.toString());
        cleanUpStreams();
    }
    
    public void testHandleShowCard3()
    {
        System.out.println("test Handle Show Card - ShowSleuth");
        engineActive.setExpectSleuth(2);
        CardMessage message1 = new CardMessage(player1, player2, player2.getClueCards().get(0));
        CardMessage message2 = new CardMessage(player1, player3, player3.getClueCards().get(0));
        
        setUpStreams();
        engineActive.handleShowCard(message1);
        engineActive.handleShowCard(message2);
        //assertEquals("ERROR: Failed to send to server\n" +
        //            "Recieved from: player2\n" +
        //            "The Card Phoebe's Moon\n" +
        //            "Recieved from: player3\n" +
        //            "The Card Mount Olympus\n", outContent.toString());
        cleanUpStreams();
    }
    
    public void testHandleSolution()
    {
        System.out.println("test Handle Solution - case Wrong accuse");
        Solution accuse = new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0), theme.getDestinations().get(1));
        Solution solution = new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        AccusationMessage accusation1 = new AccusationMessage(accuse, solution, player1);
        accusation1.setIsCorrect(false);
        accusation1.setShowTo(player1);
        
        Scanner sc = new Scanner("");
        engineActive.setScanner(sc);
        setUpStreams();
        engineActive.handleSolution(accusation1);
        //assertEquals("Your accusation:\n" +
        //            "Aphrodite\n" +
        //            "Apollo's Chariot\n" +
        //            "Athens\n" +
        //            "Which does not match the correct solution\n" +
        //            "Aphrodite\n" +
        //            "Apollo's Chariot\n" +
        //            "Athena's Forest\n" +
        //            "You player1 Lost The Game\n", outContent.toString());
        cleanUpStreams();
        assertFalse(player1.isInGame());
    }
   
    public void testRegularSnoop()
    {
        System.out.println("test perform Regular Snoop");
        final SnoopCard snoop = new SnoopCard("/image/Action-Snoop.jpg");
        Scanner sc = new Scanner("1\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(snoop);
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertTrue(out.get(1) instanceof HistoryLog);
        //String expected = "Pick a Player to snoop on, integer 1-3\n" +
        //             "You Snooped on the player player2\n" +
        //             "Pick a number from 1 - 5 to snoop the card on\n";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        cleanUpStreams();
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(snoop);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Snoop on player").
                triggerButtonClick("player2")).run();
    }
    
    public void testAllSnoop()
    {
        System.out.println("test perform All Snoop - right");
        SnoopCard snoop = new SnoopCard(Direction.RIGHT, "regular snooping");
        Scanner sc = new Scanner("1\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(snoop);
        
        String expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        
        assertEquals(5, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
        assertTrue(out.get(2) instanceof CardMessage);
        assertTrue(out.get(3) instanceof CardMessage);
        assertTrue(out.get(4) instanceof CardMessage);
        cleanUpStreams();
    }
    public void testAllSnoop2()
    {
        System.out.println("test perform All Snoop - left");
        SnoopCard snoop = new SnoopCard(Direction.LEFT, "regular snooping");
        Scanner sc = new Scanner("1\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(snoop);
        String expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(5, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
        assertTrue(out.get(2) instanceof CardMessage);
        assertTrue(out.get(3) instanceof CardMessage);
        assertTrue(out.get(4) instanceof CardMessage);
        cleanUpStreams();
    }
    
    public void testPerformSuggestion()
    {
        System.out.println("test perform Suggestion - Current Destination - Move - Swap with Player");
        final SuggestionCard suggest = new SuggestionCard(true, "image/Action-SuggsetionCurrent.jpg");
        Scanner sc = new Scanner("m\n" + "1\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(suggest);
        String expected = "Would you like to move (m) or suggest (s)?\n" +
                          "Pick a destination according to theme (1-9)s\n";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof SuggestionCardLogic);
        cleanUpStreams();
        /*WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(suggest);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Destination").
                triggerButtonClick("(R)eset")).run();*/
    }
    
    public void testPerformSuggestion2()
    {
        System.out.println("test perform Suggestion - Current Destination - Move - Swap with Table");
        final SuggestionCard suggest = new SuggestionCard(true, "some path");
        Scanner sc = new Scanner("m\n" + "8\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(suggest);
        String expected = "Would you like to move (m) or suggest (s)?\n" +
                          "Pick a destination according to theme (1-9)s\n";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof SuggestionCardLogic);
        cleanUpStreams();
        /*WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(suggest);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Destination").
                triggerButtonClick("(R)eset")).run();*/
    }
    
    public void testPerformSuggestion3()
    {
        System.out.println("test perform Suggestion - Current Destination - Suggestion - Disprovable");
        SuggestionCard suggest = new SuggestionCard(true, "some path");
        Scanner sc = new Scanner("s\n" + "1\n" + "1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(suggest);
        String expected = "Would you like to move (m) or suggest (s)?\n" +
                          "Pick a suspect according to theme (1-6)\n" +
                          "Pick a vehicle according to theme (1-6)\n";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof SuggestionCardLogic);
        cleanUpStreams();
        
    }
    
    public void testPerformSuggestion4()
    {
        System.out.println("test perform Suggestion - Current Destination - Suggestion - No One Disprove");
        
        final SuggestionCard suggest = new SuggestionCard(true, "some path");
        Scanner sc = new Scanner("s\n" + "1\n" + "3\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(suggest);
        String expected = "Would you like to move (m) or suggest (s)?\n" +
                        "Pick a suspect according to theme (1-6)\n" +
                        "Pick a vehicle according to theme (1-6)\n" +
                        "Suggestion Result: No one can disprove your suggestion.\n" +
                        "Your guess was: Aphrodite, Eros' Wings, Athena's Forest";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof HistoryLog);
        cleanUpStreams();
        /*WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(suggest);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Destination").
                triggerButtonClick("(R)eset")).run();*/
    }
    
    public void testPerformSuggestion5()
    {
        System.out.println("test perform Suggestion from Any");
        
        SuggestionCard suggest = new SuggestionCard(false, "some path");
        Scanner sc = new Scanner("1\n" + "1\n" + "3\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(suggest);
        String expected = "Pick a suspect according to theme (1-6)\n" +
                          "Pick a vehicle according to theme (1-6)\n" +
                          "Pick a destination according to theme (1-9)\n";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof SuggestionCardLogic);
        cleanUpStreams();
    }
    
    public void testPerformSleuth1()
    {
        System.out.println("test perform Sleuth - Regular");
        
        SuperSleuthCard sleuth = new SuperSleuthCard(ClueType.SUSPECT, Attribute.FEMALE, "some path");
        setUpStreams();
        List<Object> out = engineActive.performAction(sleuth);
        String expected = "ERROR: Failed to send to server\n" +
                        "ERROR: Failed to send to server\n" +
                        "ERROR: Failed to send to server\n" +
                        "You played a Sleuth Card, please wait for players to choose.\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(0, out.size());
        cleanUpStreams();
        
    }
    
    public void testPerformSleuth2()
    {
        System.out.println("test perform Sleuth - No Card To Show");      
        final SuperSleuthCard sleuth = new SuperSleuthCard(ClueType.SUSPECT, Attribute.EASTERN, "some path");
        List<Object> out = engineActive.performAction(sleuth);
       
        assertEquals(2, out.size());
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(sleuth);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Sleuth Result").
                triggerButtonClick("okButton")).run();
    }
    
    public void testPerformPrivateTip1()
    {
        System.out.println("test perform Tip regular");
        final PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "somepath");     
        Scanner sc = new Scanner("1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(tip);
        String expected = "1: player2\n" +
                        "2: player3\n" +
                        "3: player4\n" +
                        "Input which player you would like to send this card to\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
        cleanUpStreams();
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(tip);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Private Tip ").
                triggerButtonClick("player1")).run();
    }
    
    public void testPerformPrivateTip2()
    {
        System.out.println("test perform Tip Is All");
        final PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, "somepath");     
        Scanner sc = new Scanner("1\n");
        engineActive.setScanner(sc);
        setUpStreams();
        List<Object> out = engineActive.performAction(tip);
        String expected = "1: player2\n" +
                        "2: player3\n" +
                        "3: player4\n" +
                        "Input which player you would like to send this card to\n" +
                        "player2 shows you:\n" +
                        "Ares\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(2, out.size());
        assertTrue(out.get(0) instanceof HistoryLog);
        assertTrue(out.get(1) instanceof CardMessage);
        cleanUpStreams();
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.performAction(tip);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Private Tip ").
                triggerButtonClick("player1")).run();
    }
    
    public void testHandleSnoop1()
    {
        System.out.println("test handle Snoop - Left");
        SnoopCard snoop = new SnoopCard(Direction.LEFT, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineIdle.handleSnoop(snoop);
        String expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
        
        System.out.println("test handle Snoop - Left (edge case)");
        snoop = new SnoopCard(Direction.LEFT, "somePath");
        sc = new Scanner("1\n");
        stateIdle = new GameState(players2, playerd, table2);
        this.engineIdle = new GameEngine(stateIdle, client, true);
        engineIdle.setScanner(sc);
        setUpStreams();
        out = engineIdle.handleSnoop(snoop);
        expected = "Pick a number from 1 - 5 to snoop the card on\n" +
                          "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
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
        List<Object> out = engineIdle.handleSnoop(snoop);
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
        out = engineActive.handleSnoop(snoop);
        expected = "Pick a number from 1 - 6 to snoop the card on\n" +
                   "You saw the card";
        //assertEquals(expected, outContent.toString().substring(0, expected.length()));
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        cleanUpStreams();
    }
    
    public void testHandleTip1()
    {
        System.out.println("test Handle Private Tip - Regular - No card to show");
        PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, Attribute.FEMALE, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineIdle.handlePrivateTip(tip);
        String expected = "player1 played this Private Tip but you have no cards to show!\n";
        //assertEquals(expected, outContent.toString());
        assertEquals(0, out.size());
        cleanUpStreams();
    }
    
    public void testHandleTip2()
    {
        System.out.println("test Handle Private Tip - Regular - Has card to show");
        PrivateTipCard tip = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "somePath");
        Scanner sc = new Scanner("1\n");
        engineIdle.setScanner(sc);
        setUpStreams();
        List<Object> out = engineIdle.handlePrivateTip(tip);
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
        List<Object> out = engineIdle.handlePrivateTip(tip);
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
        List<Object> out = engineIdle.handleSleuth(sleuth);
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
        List<Object> out = engineIdle.handleSuggestion(logic);
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
        List<Object> out = engineIdle.handleSuggestion(logic);
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
        List<Object> out = engineIdle.handleSuggestion(logic);
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
    
    
    public void testEndGame()
    {
        System.out.println("test handle end Game");
        Solution solution = new Solution(theme.getSuspects().get(0),
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        client.setSolution(solution);
        setUpStreams();
        engineActive.handleEndGame();
        String expected = "Game Result: No Winner\n" +
                "All players made false accusations or some player disconnected.\n" +
                "\n" +
                "Correct Solution: Aphrodite Apollo's Chariot Athena's Forest\n";
        //assertEquals(expected, outContent.toString());
        cleanUpStreams();
        
        
        System.out.println("test end Game");
        Scanner sc = new Scanner("n\n");
        engineActive.setScanner(sc);
        player2.setPlayerLoses();
        player4.setPlayerLoses();
        setUpStreams();
        engineActive.endGame(true);
        cleanUpStreams();
        
        assertTrue(engineActive.getGameState().isGameOver());
        
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.endGame(true);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Correct Solution:").
                triggerButtonClick("okButton")).run();
    }
    
    public void testHandleReplayGame()
    {
        GameServer server = new GameServer();
        try
        {
            server.listen();
        }
        catch(IOException e)
        {
            System.out.println();
        }
        System.out.println("test handle Replay Game");
        Scanner sc = new Scanner("human");
        lobby.setInputMode(sc);
        engineActive.setScanner(sc);
        setUpStreams();
        engineActive.handleReplayGame(true);
        String expected = "java.net.ConnectException: Connection refused\n" +
            "ERROR: unable to ask server to send players.java.net.SocketException: socket does not exist\n" +
            "java.net.ConnectException: Connection refused\n" +
            "ERROR: unable to ask server to send players.java.net.SocketException: socket does not exist\n" +
            "Player joined game\n" +
            "Insert a username:\n" +
            "ERROR: unable to send self player to server.java.net.SocketException: socket does not exist\n" +
            "Lobby name changed to: Tegakari: human\n" +
            "Player accepted\n";
        //assertEquals(expected, outContent.toString());
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                        engineActiveGUI.handleReplayGame(true);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Tegakari").
                triggerButtonClick("test")).run();
    }
}
