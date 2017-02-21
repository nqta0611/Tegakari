
package integration_test;
import java.util.*;
import junit.framework.*;
import tegakari.*;

/**
 *
 * @author anhnguyen
 */
public class RobotEngineInIdleTest extends TestCase {

    Player turn;
    Player pTwo;
    Robot bot;
    Player pThree;
    
    AILevel basic = AILevel.BASIC;
    AILevel smart = AILevel.SMART;
    
    Hand hand;
    Hand hand2;
    Hand hand3; 
    Hand hand4;
    
    
    List<Attribute> list1;
    List<Attribute> list2;
    List<Attribute> list3;
    
    SnoopCard snoopC;
    SuperSleuthCard sleuthC;
    PrivateTipCard tipC;
    SuggestionCard suggestC;
    
    Theme theme;
    Table table;
    
    Solution solution;
    
    ActionCard action1;
    ActionCard action2;
    ActionCard action3;
    ActionCard action4;
    
    private List<SuspectCard> suspects = new ArrayList<SuspectCard>();
    private List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
    private List<DestinationCard> destinations = new ArrayList<DestinationCard>();
        
    Queue<Player> players;
    
    Notepad note;
    RobotEngine engine;
    RobotEngineInActive engineActive;
    RobotEngineInIdle engineIdle;
    RobotState state;
    
    public RobotEngineInIdleTest() 
    {
        System.out.println("--------Set up test");
        action1 = new SnoopCard("snoop");
        action2 = new SuperSleuthCard(ClueType.DESTINATION, 
                Attribute.NORTHERN, "sleuth");
        action3 = new PrivateTipCard(ClueType.SUSPECT, "tip");
        action4 = new SuggestionCard(true, "suggest");
        
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(Attribute.EASTERN);
        list2.add(Attribute.NORTHERN);
        
        theme = new Theme();
        suspects = new ArrayList<SuspectCard>();
        vehicles = new ArrayList<VehicleCard>();
        destinations = new ArrayList<DestinationCard>();
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
        solution = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), 
                destinations.get(0).getDestination());
        
        hand = new Hand();
        hand.addToHand(destinations.get(0));
        hand.addToHand(suspects.get(0));
        hand.addToHand(vehicles.get(0));
        hand2 = new Hand();
        hand2.addToHand(destinations.get(1));
        hand2.addToHand(suspects.get(1));
        hand2.addToHand(suspects.get(1));
        hand2.addToHand(suspects.get(1));
        hand2.addToHand(vehicles.get(2));
        hand3 = new Hand();
        hand3.addToHand(destinations.get(2));
        hand3.addToHand(suspects.get(2));
        hand3.addToHand(vehicles.get(2));
        hand4 = new Hand();
        hand4.addToHand(destinations.get(3));
        hand4.addToHand(suspects.get(3));
        hand4.addToHand(vehicles.get(3));
        
        
        turn = new HumanPlayer("playerturn", hand, theme.getDestinations().get(0));
        bot = new Robot("robot1_basic", hand2, theme.getDestinations().get(1), smart);
        pTwo = new HumanPlayer("player2", hand3, theme.getDestinations().get(2));
        pThree = new HumanPlayer("player3", hand4, theme.getDestinations().get(3));
        
        players = new LinkedList<Player>();
        players.add(turn);
        players.add(bot);
        players.add(pTwo);
        players.add(pThree);
        note = new Notepad(players, suspects, vehicles, destinations, solution);
        
        engine = new RobotEngine(players, bot, smart);
        engineActive = engine.getEngineActive();
        engineIdle = engine.getEngineIdle();
        state = engine.getState();
        state.setNote(note);
        table = new Table(theme);
        engine.setTable(table);
        HistoryLog log = new HistoryLog();
        state.setLog(log);
        
        System.out.println("players size: " + players.size() + " " + players.peek().getName());
        System.out.println("ref state2: " + state);
        System.out.println("ref noteP1: " + note);
        System.out.println("ref noteP2: " + state.getNote());
        System.out.println("done set up");
    }
    
    public void testHandleSnoopRegular() 
    {
        System.out.println("Test handleSnoopRegular - no card to show");
        List<Card> listCard = new ArrayList<Card>();
        listCard.add(snoopC);
        CardMessage mess = new CardMessage(bot, turn, listCard);
        
        List<Object> out = engineIdle.handleActionRequest(mess, basic);
        assertEquals(0, out.size());
    }
    
    public void testHandleAllSnoopLeft() 
    {
        System.out.println("Test handleSnoopLeft");
        snoopC = new SnoopCard(Direction.LEFT, "snoopPath");
        List<Card> listCard = new ArrayList<Card>();
        listCard.add(snoopC);
        CardMessage mess = new CardMessage(bot, turn, listCard);
        
        List<Object> out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertEquals(pTwo,((CardMessage)(out.get(0))).getToPlayer() );
        
        out = engineIdle.handleActionRequest(mess, basic);
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertEquals(pTwo,((CardMessage)(out.get(0))).getToPlayer() );
    }
    
    public void testHandleAllSnoopRight() 
    {
        System.out.println("Test handleSnoopRight");
        snoopC = new SnoopCard(Direction.RIGHT, "snoopPath");
        List<Card> listCard = new ArrayList<Card>();
        listCard.add(snoopC);
        CardMessage mess = new CardMessage(bot, turn, listCard);
        
        List<Object> out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertEquals(turn,((CardMessage)(out.get(0))).getToPlayer() );
        
        out = engineIdle.handleActionRequest(mess, basic);
        assertEquals(1, out.size());
        assertTrue(out.get(0) instanceof CardMessage);
        assertEquals(turn,((CardMessage)(out.get(0))).getToPlayer() );
    }
    
    public void testHandleTip()
    {
        //Test this robot not has a card to show
        System.out.println("Test handleTip - no card to show");
        List<Card> listCard = new ArrayList<Card>();
        tipC = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "tip");
        listCard.add(tipC);
        CardMessage mess = new CardMessage(bot, turn, listCard);
        List<Object> out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(0, out.size());
        //assertNull(out);
       
        System.out.println("Test handleTip - has a card to show");
        listCard = new ArrayList<Card>();
        tipC = new PrivateTipCard(ClueType.SUSPECT, Attribute.FEMALE, "tip");
        listCard.add(tipC);
        mess = new CardMessage(bot, turn, listCard);
        out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(2, out.size());
        assertTrue(bot.getHand().getClueCards().contains(((CardMessage)(out.get(0))).getCards().get(0) ));
        
        System.out.println("Test handleTip - show all");
        listCard = new ArrayList<Card>();
        tipC = new PrivateTipCard(ClueType.SUSPECT, "tip");
        listCard.add(tipC);
        mess = new CardMessage(bot, turn, listCard);
        out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(0, out.size());
    }
    
    public void testHandleSleuth()
    {
        System.out.println("Test handleSleuth - has a card to show");
        List<Card> listCard = new ArrayList<Card>();
        sleuthC = new SuperSleuthCard(ClueType.DESTINATION, Attribute.EASTERN, "sleuth");
        listCard.add(sleuthC);
        CardMessage mess = new CardMessage(bot, turn, listCard);
        List<Object> out = engineIdle.handleActionRequest(mess, smart);
        assertEquals(1, out.size());
        assertTrue(bot.getHand().getClueCards().contains(((CardMessage)(out.get(0))).getCards().get(0) ));
        
        System.out.println("Test handleSleuth - no card to show");
        listCard = new ArrayList<Card>();
        sleuthC = new SuperSleuthCard(ClueType.SUSPECT, Attribute.MALE, "sleuth");
        listCard.add(sleuthC);
        mess = new CardMessage(bot, turn, listCard);
        out = engineIdle.handleActionRequest(mess, smart);
        //assertNull(out);
        assertEquals(out.size(), 0);
    }
    
    public void testHandleSuggestion()
    {
        System.out.println("Test handleSuggestion - swap with table");
        suggestC = new SuggestionCard(true, "suggestion");
        table = new Table(theme);
        for(int card = 0 ; card < 4 ; card++)
        {
            table.dealDM();
        }
        table.buildActionDeck();
        engine.responseToServerMessage(table);
        SuggestionCardLogic logic = new SuggestionCardLogic(suggestC, turn, theme.getDestinations().get(5), null);
        System.out.println("turn before: " + turn.getDestination().getName());
        assertEquals("Athena's Forest", turn.getDestination().getName());
        List<Object> out = engineIdle.handleSuggestion(logic, basic);
        assertEquals(theme.getDestinations().get(5).getName(), turn.getDestination().getName());
        assertEquals(0, out.size());
        
        
        System.out.println("Test handleSuggestion - to Disprove a suggestion");
        suggestC = new SuggestionCard(true, "suggestion");
        logic = new SuggestionCardLogic(suggestC, turn, null, 
                new Solution(suspects.get(1).getSuspect(),
                vehicles.get(1).getVehicle(), destinations.get(1).getDestination()));
        logic.isDisprovable(players);
        out = engineIdle.handleSuggestion(logic, basic);
        assertEquals(2, out.size());
        assertTrue(bot.getHand().getClueCards().contains(((CardMessage)(out.get(0))).getCards().get(0)));
        assertEquals("robot1_basic disproved playerturn's suggestion.\n\n",((HistoryLog)(out.get(1))).toString());
        
        System.out.println("Test handleSuggestion - swap with other player");
        suggestC = new SuggestionCard(true, "suggestion");
        
        logic = new SuggestionCardLogic(suggestC, turn, pTwo.getDestination(), null);
        table.getPile();
        assertEquals("Atlas' Sky", pTwo.getDestination().getName());
        assertEquals("Hephaestus' Volcano", turn.getDestination().getName());
        out = engineIdle.handleSuggestion(logic, smart);
        assertEquals("Hephaestus' Volcano", pTwo.getDestination().getName());
        assertEquals("Atlas' Sky", turn.getDestination().getName());
        assertEquals(0, out.size());
    }
    
    
    public void testGetState()
    {
        System.out.println("Test getState");
        assertEquals(state, engineIdle.getState());
    }
}
