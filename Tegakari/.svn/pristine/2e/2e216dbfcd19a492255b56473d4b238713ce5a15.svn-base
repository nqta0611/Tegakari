package integration_test;

import junit.framework.TestCase;
import tegakari.*;
import java.util.*;

/**
 *
 * @author DeionLaw
 */
public class RobotEngineTest extends TestCase
{
    
    private Queue<Player> players;
    private HumanPlayer human;
    private Robot basicRobot;
    private Robot smartRobot;
    
    private RobotEngine basicEngine;
    private RobotEngine smartEngine;
    
    private RobotState basicState;
    private RobotState smartState;
    
    private Notepad basicNotepad;
    private Notepad smartNotepad;
    
    private ArrayList<SuspectCard> suspects;
    private ArrayList<VehicleCard> vehicles;
    private ArrayList<DestinationCard> destinations;
    
    private Table table;
    
    public RobotEngineTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        Theme theme = new Theme();
        suspects = new ArrayList<>();
        vehicles = new ArrayList<>();
        destinations = new ArrayList<>();
        
        for (Suspect suspect : theme.getSuspects())
        {
            suspects.add(new SuspectCard(suspect));
        }
        
        for (Vehicle vehicle : theme.getVehicles())
        {
            vehicles.add(new VehicleCard(vehicle));
        }
        
        for (Destination destination : theme.getDestinations())
        {
            destinations.add(new DestinationCard(destination));
        }
        
        Hand humanHand = new Hand();
        Hand basicHand = new Hand();
        Hand smartHand = new Hand();
        
        human = new HumanPlayer("human1", humanHand, 
                destinations.get(0).getDestination());
        basicRobot = new Robot("robot1_basic", basicHand, 
                destinations.get(1).getDestination(), AILevel.BASIC);
        smartRobot = new Robot("robot2_basic", smartHand, 
                destinations.get(2).getDestination(), AILevel.SMART);
        
        players = new LinkedList<>();
        players.add(human);
        players.add(basicRobot);
        players.add(smartRobot);
        
        for(int player = 0 ; player < players.size() ; player++)
        {
            Player currPlayer = players.peek();
            //System.out.println(player + " Hand making " + currPlayer.getName());
            players.remove();
            currPlayer.getHand().addToHand(suspects.get(player));
            currPlayer.getHand().addToHand(vehicles.get(player));
            currPlayer.getHand().addToHand(destinations.get(player));
            players.add(currPlayer);
        }
        
        basicEngine = new RobotEngine(players, basicRobot, AILevel.BASIC);
        smartEngine = new RobotEngine(players, smartRobot, AILevel.SMART);
        
        basicState = basicEngine.getState();
        smartState = smartEngine.getState();
        
        basicNotepad = basicState.getNote();
        smartNotepad = smartState.getNote();
    }
    
    public void testSettersAndGetters()
    {
        RobotEngineInActive active = new RobotEngineInActive(smartEngine, smartState);
        RobotEngineInIdle idle = new RobotEngineInIdle();
        RobotState state = new RobotState(players, smartRobot, smartRobot);
        Solution solution = new Solution(suspects.get(1).getSuspect(), vehicles.get(1).getVehicle(), destinations.get(1).getDestination());
        smartEngine.setEngineActive(active);
        assertEquals(active, smartEngine.getEngineActive());
        smartEngine.setEngineIdle(idle);
        assertEquals(idle, smartEngine.getEngineIdle());
        smartEngine.setState(state);
        assertEquals(state, smartEngine.getState());
        smartEngine.setSolution(solution);
        assertEquals(solution, smartEngine.getSolution());
        assertEquals(players, smartEngine.getPlayers());
        
        
    }
    
    public void testSuggestionResponse() 
    {
        setTable();
        
        SuggestionCard currSuggCard = new SuggestionCard(true, "");
        Solution guess = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        SuggestionCardLogic suggLogic = new SuggestionCardLogic(currSuggCard, human, 
                null, guess);
        suggLogic.isDisprovable(players);
        
        
        assertEquals(suspects.get(0), 
                ((CardMessage)smartEngine.responseToServerMessage(suggLogic).get(0)).getCards().get(0));
                
        guess = new Solution(suspects.get(1).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        
        
        
        suggLogic = new SuggestionCardLogic(currSuggCard, human, null, guess);
        suggLogic.isDisprovable(players);
        
        assertEquals(0, (smartEngine.responseToServerMessage(suggLogic)).size());
    }
    
    public void testUpdatePlayers()
    {
        assertFalse(basicState.isGameStart());
        assertFalse(smartState.isGameStart());
        
        players.add(new Robot("robot1_basic", AILevel.SMART));
        
        assertEquals(0, basicEngine.responseToServerMessage(players).size());
        assertEquals(0, smartEngine.responseToServerMessage(players).size());
        
        assertEquals(players.size(), basicState.getPlayers().size());
        assertEquals(players.size(), smartState.getPlayers().size());
        
        basicState.setGameStart();
        smartState.setGameStart();
        
        //New queue is needed since state references original queue
        //GameServer makes a new queue everytime so this problem is avoided
        Queue<Player> newQ = new LinkedList<>(players);
        newQ.add(new Robot("robot2_basic", AILevel.BASIC));
        
        assertEquals(0, basicEngine.responseToServerMessage(newQ).size());
        assertEquals(0, smartEngine.responseToServerMessage(newQ).size());
        
        assertEquals(players.size()+1, basicState.getPlayers().size());
        assertEquals(players.size()+1, smartState.getPlayers().size());
    }
    
    public void testPrepareGame()
    {
        human = new HumanPlayer("human1");
        basicRobot = new Robot("robot1_basic", AILevel.BASIC);
        smartRobot = new Robot("robot2_basic", AILevel.SMART);
        players = new LinkedList<>();
        players.add(human);
        players.add(basicRobot);
        players.add(smartRobot);
        
        basicEngine = new RobotEngine(players, basicRobot, AILevel.BASIC);
        smartEngine = new RobotEngine(players, smartRobot, AILevel.SMART);
        basicState = basicEngine.getState();
        
        Hand emptyHand = new Hand();
        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(new Hand());
        hands.add(new Hand());
        hands.add(new Hand());
        
        assertEquals(emptyHand, basicRobot.getHand());
        assertEquals(emptyHand, smartRobot.getHand());
        
        assertNull(basicRobot.getDestination());
        assertNull(smartRobot.getDestination());
        assertNull(basicState.getNote());
        
        Table table1 = new Table(new Theme());
        table1.buildActionDeck();
        table1.buildClueDeck();
        Table table2 = new Table(new Theme());
        table2.buildActionDeck();
        table2.buildClueDeck();
        
        Deck<ClueCard> clueDeck = table1.getClueDeck();
        Deck<ActionCard> actionDeck = table1.getActionDeck();
        
        int index = 0;
        
        while(!clueDeck.isEmpty())
        {
            hands.get(index).addToHand(clueDeck.dealCard());
            index = (index + 1) % 3;
        }
        
        table1.buildClueDeck();
        table1.buildActionDeck();
        
        hands.get(0).addToHand(actionDeck.dealCard());
        hands.get(1).addToHand(actionDeck.dealCard());
        hands.get(2).addToHand(actionDeck.dealCard());
        
        assertEquals(0, basicEngine.responseToServerMessage(table1).size());
        assertNotNull(basicState.getNote());
        
        
        assertEquals(hands.get(0).getActionCards().get(0).getActionText(), 
                human.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(0).getClueCards(), human.getHand().getClueCards());
        assertEquals(hands.get(1).getActionCards().get(0).getActionText(), 
                basicRobot.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(1).getClueCards(), basicRobot.getHand().getClueCards());
        assertEquals(hands.get(2).getActionCards().get(0).getActionText(), 
                smartRobot.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(2).getClueCards(), smartRobot.getHand().getClueCards());
        
        human = new HumanPlayer("human1");
        basicRobot = new Robot("robot1_basic", AILevel.BASIC);
        smartRobot = new Robot("robot2_smart", AILevel.SMART);
        players = new LinkedList<>();
        players.add(human);
        players.add(basicRobot);
        players.add(smartRobot);
        
        smartEngine = new RobotEngine(players, smartRobot, AILevel.SMART);
        smartState = smartEngine.getState();
        assertNull(smartState.getNote());
        assertEquals(0, smartEngine.responseToServerMessage(table2).size());
        assertNotNull(smartState.getNote());
        
        
        assertEquals(hands.get(0).getActionCards().get(0).getActionText(), 
                human.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(0).getClueCards(), human.getHand().getClueCards());
        assertEquals(hands.get(1).getActionCards().get(0).getActionText(), 
                basicRobot.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(1).getClueCards(), basicRobot.getHand().getClueCards());
        assertEquals(hands.get(2).getActionCards().get(0).getActionText(), 
                smartRobot.getHand().getActionCards().get(0).getActionText());
        assertEquals(hands.get(2).getClueCards(), smartRobot.getHand().getClueCards());
    }
    
    public void testProtocols()
    {
        assertFalse(smartState.isGameReady());
        assertNull(smartEngine.responseToServerMessage(Protocol.GAME_READY));
        assertTrue(smartState.isGameReady());
        
        assertFalse(smartState.isGameStart());
        assertNull(smartEngine.responseToServerMessage(Protocol.GAME_START));
        assertTrue(smartState.isGameStart());
        
        assertFalse(smartState.isGameOver());
        assertNull(smartEngine.responseToServerMessage(Protocol.GAME_OVER));
        assertTrue(smartState.isGameOver());
        
        setTable();
        
        assertNull(smartEngine.responseToServerMessage(Protocol.END_TURN));
        smartEngine.responseToServerMessage(Protocol.END_TURN);
        
        assertEquals(NoteEntry.BLANK, smartNotepad.getEntry(suspects.get(2), human));
        
    }
    
    public void testSolution()
    {
        Solution sol = new Solution(suspects.get(4).getSuspect(), 
                vehicles.get(4).getVehicle(), destinations.get(0).getDestination());
        assertNull(basicEngine.getSolution());
        assertNull(smartEngine.getSolution());
        assertEquals(0, basicEngine.responseToServerMessage(sol).size());
        assertEquals(sol, basicEngine.getSolution());
        assertEquals(0, smartEngine.responseToServerMessage(sol).size());
        assertEquals(sol, smartEngine.getSolution());
    }
    
    public void testHistoryLog()
    {
        setTable();
        
        HistoryLog log = new HistoryLog();
        assertEquals(0, smartEngine.responseToServerMessage(log).size());
    }
       
    public void testAccusation()
    {
        Solution accusation = new Solution(suspects.get(3).getSuspect(), 
                vehicles.get(2).getVehicle(), destinations.get(1).getDestination());
        Solution solution = new Solution(suspects.get(4).getSuspect(), 
                vehicles.get(4).getVehicle(), destinations.get(0).getDestination());
        AccusationMessage message = new AccusationMessage(accusation, solution, human);
        assertEquals(0, basicEngine.responseToServerMessage(message).size());
        assertFalse(human.isInGame());
        
        message = new AccusationMessage(solution, solution, basicRobot);
        message.setIsCorrect(true);
        assertFalse(smartState.isGameOver());
        assertEquals(0, smartEngine.responseToServerMessage(message).size());
        
        assertTrue(smartState.isGameOver());
    }
    
    public void testCardMessage()
    {
        setTable();
        smartEngine.responseToServerMessage(Protocol.END_TURN);
        smartEngine.responseToServerMessage(Protocol.END_TURN);
        List<Card> cards = new ArrayList<>();
        cards.add(suspects.get(0));
        
        CardMessage cardMessageToSmart = new CardMessage(smartRobot, basicRobot, cards);
        
        assertEquals(0, 
                smartEngine.responseToServerMessage(cardMessageToSmart).size());
        
        assertEquals(NoteEntry.BLANK, smartNotepad.getEntry(suspects.get(2), human));
        assertEquals(NoteEntry.BLANK, smartNotepad.getEntry(suspects.get(0), basicRobot));
        
        
        
    }
    
    private void setTable()
    {
        table = new Table(new Theme());
        
        table.buildOrderedActionDeck("./src/testsetup/EngineAction.in");
        table.buildOrderedClueDeck("./src/testsetup/EngineClue.in");
        human = new HumanPlayer("human1");
        basicRobot = new Robot("robot1_basic", AILevel.BASIC);
        smartRobot = new Robot("robot2_smart", AILevel.SMART);
        players = new LinkedList<>();
        players.add(human);
        players.add(basicRobot);
        players.add(smartRobot);
        
        basicEngine = new RobotEngine(players, basicRobot, AILevel.BASIC);
        basicState = basicEngine.getState();
        smartEngine = new RobotEngine(players, smartRobot, AILevel.SMART);
        smartState = smartEngine.getState();
        
        basicEngine.responseToServerMessage(table);
        smartEngine.responseToServerMessage(table);
        
        basicNotepad = basicState.getNote();
        smartNotepad = smartState.getNote();
    }
}
