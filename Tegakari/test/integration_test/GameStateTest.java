/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import junit.framework.TestCase;
import sun.security.krb5.internal.PAData;
import tegakari.*;

/**
 *
 * @author ericroh
 */
public class GameStateTest extends TestCase 
{
    private GameState state;
    private Queue<Player> players;
    private Player self;
    private Player p2;
    private Player p3;
    private Player p4;
    private Theme theme;
    private Table table;
    
            
    public GameStateTest(String testName) 
    {
        super(testName);
        theme = new Theme();
    }
    
    @Override
    protected void setUp() throws Exception
    {
        Hand hand = new Hand();
        self = new HumanPlayer("self", hand, null);
        p2 = new HumanPlayer("player2");
        p3 = new Robot("robot1", AILevel.SMART);
        p4 = new HumanPlayer("player4");
        
        players = new ArrayDeque<Player>();
        players.add(self);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        table = new Table(theme);
        
        state = new GameState(players, self, table);
    }

    /**
     * Test of dealClueCardsToPlayers method, of class GameState.
     */
    public void testDealClueCardsToPlayers() {
        System.out.println("dealClueCardsToPlayers");
        
        table.buildOrderedClueDeck("./src/testsetup/t1clue");
        
        state.dealClueCardsToPlayers();
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        expected.add(new SuspectCard(theme.getSuspects().get(0)));
        expected.add(new SuspectCard(theme.getSuspects().get(5)));
        expected.add(new VehicleCard(theme.getVehicles().get(2)));
        expected.add(new VehicleCard(theme.getVehicles().get(5)));
        expected.add(new DestinationCard(theme.getDestinations().get(1)));
        expected.add(new DestinationCard(theme.getDestinations().get(2)));

        assertEquals(expected, self.getClueCards());
        
        expected = new ArrayList<ClueCard>();
        expected.add(new VehicleCard(theme.getVehicles().get(0)));
        expected.add(new SuspectCard(theme.getSuspects().get(1)));
        expected.add(new DestinationCard(theme.getDestinations().get(3)));
        expected.add(new DestinationCard(theme.getDestinations().get(4)));
        expected.add(new DestinationCard(theme.getDestinations().get(5)));
        assertEquals(expected, p2.getClueCards());
        
        expected = new ArrayList<ClueCard>();
        expected.add(new DestinationCard(theme.getDestinations().get(0)));
        expected.add(new SuspectCard(theme.getSuspects().get(3)));
        expected.add(new DestinationCard(theme.getDestinations().get(6)));
        expected.add(new DestinationCard(theme.getDestinations().get(7)));
        expected.add(new DestinationCard(theme.getDestinations().get(8)));
        assertEquals(expected, p3.getClueCards());
        
        expected = new ArrayList<ClueCard>();
        expected.add(new SuspectCard(theme.getSuspects().get(2)));
        expected.add(new SuspectCard(theme.getSuspects().get(4)));
        expected.add(new VehicleCard(theme.getVehicles().get(4)));
        expected.add(new VehicleCard(theme.getVehicles().get(3)));
        expected.add(new VehicleCard(theme.getVehicles().get(1)));
        assertEquals(expected, p4.getClueCards());
    }

    /**
     * Test of dealActionCardsToPlayers method, of class GameState.
     */
    public void testDealActionCardsToPlayers() {
        System.out.println("dealActionCardsToPlayers");

    }

    /**
     * Test of dealDMtoPlayers method, of class GameState.
     */
    public void testDealDMtoPlayers() {
        System.out.println("dealDMtoPlayers");
        
    }

    /**
     * Test of getPlayers method, of class GameState.
     */
    public void testGetPlayers() {
        System.out.println("getPlayers");
        
    }

    /**
     * Test of addToHistoryLog method, of class GameState.
     */
    public void testAddToHistoryLog() {
        System.out.println("addToHistoryLog");
        String text = "addToHistoryLogTest";
        
        state.addToHistoryLog(text);
        
        assertEquals(text + "\n", state.getHistoryLog().toString());
    }

    /**
     * Test of getSelfPlayer method, of class GameState.
     */
    public void testGetSelfPlayer() {
        System.out.println("getSelfPlayer");
        
    }

    /**
     * Test of setHistoryLog method, of class GameState.
     */
    public void testSetHistoryLog() {
        System.out.println("setHistoryLog");
       
    }

    /**
     * Test of isEndTurn method, of class GameState.
     */
    public void testIsEndTurn() {
        System.out.println("isEndTurn");
        
        assertFalse(state.isEndTurn());
        
        state.setEndTurn(true);
        assertTrue(state.isEndTurn());
    }

    /**
     * Test of setEndTurn method, of class GameState.
     */
    public void testSetEndTurn() {
        System.out.println("setEndTurn");
        
        state.setEndTurn(true);
        assertTrue(state.isEndTurn());
        
        state.setEndTurn(false);
        assertFalse(state.isEndTurn());
    }

    /**
     * Test of makeGameOver method, of class GameState.
     */
    public void testMakeGameOver() {
        System.out.println("makeGameOver");
       
    }

    /**
     * Test of setPlayerOut method, of class GameState.
     */
    public void testSetPlayerOut() {
        System.out.println("setPlayerOut");
        
        assertTrue(self.isInGame());
        state.setPlayerOut(self);
        assertFalse(self.isInGame());
        
    }

    /**
     * Test of isGameOver method, of class GameState.
     */
    public void testIsGameOver() {
        System.out.println("isGameOver");
        
        assertFalse(state.isGameOver());
        state.makeGameOver();
        assertTrue(state.isGameOver());
    }

    /**
     * Test of isInAction method, of class GameState.
     */
    public void testIsInAction() {
        System.out.println("isInAction");
        
        assertFalse(state.isInAction());
        state.setInAction(true);
        assertTrue(state.isInAction());
        state.setInAction(false);
        assertFalse(state.isInAction());
    }

    /**
     * Test of getTurnPlayer method, of class GameState.
     */
    public void testGetTurnPlayer() {
        System.out.println("getTurnPlayer");

    }

    /**
     * Test of updateQueueForNextTurn method, of class GameState.
     */
    public void testUpdateQueueForNextTurn() {
        System.out.println("updateQueueForNextTurn");
        
        assertEquals(players, state.getPlayers());
        
        state.updateQueueForNextTurn();
        players.add(players.remove());
        
        assertEquals(players, state.getPlayers());
        
        state.setPlayerOut(p2);
        state.updateQueueForNextTurn();
        players.add(players.remove());
        assertEquals(players, state.getPlayers());
        for (int count = 0; count < 4; count++)
        {
            state.updateQueueForNextTurn();
        }
        assertEquals(players, state.getPlayers());
        
        state.updateQueueForNextTurn();
        players.add(players.remove());
        assertEquals(players, state.getPlayers());
    }

    /**
     * Test of setChangedGameState method, of class GameState.
     */
    public void testSetChangedGameState() {
        System.out.println("setChangedGameState");
        state.setChangedGameState();
    }

    /**
     * Test of getTable method, of class GameState.
     */
    public void testGetTable() {
        System.out.println("getTable");

    }

    /**
     * Test of getHistoryLog method, of class GameState.
     */
    public void testGetHistoryLog() {
        System.out.println("getHistoryLog");

    }

    /**
     * Test of hasDrawn method, of class GameState.
     */
    public void testHasDrawn() {
        System.out.println("hasDrawn");

    }

    /**
     * Test of setHasDrawn method, of class GameState.
     */
    public void testSetHasDrawn() {
        System.out.println("setHasDrawn");
        
        assertFalse(state.hasDrawn());
        state.setHasDrawn(true);
        assertTrue(state.hasDrawn());
        state.setHasDrawn(false);
        assertFalse(state.hasDrawn());
    }

    /**
     * Test of drawActionCard method, of class GameState.
     */
    public void testDrawActionCard() {
        System.out.println("drawActionCard");
        
        assertFalse(state.hasDrawn());
        table.buildOrderedActionDeck("./src/testsetup/t1action");
        state.drawActionCard();
        List<ActionCard> expected = new ArrayList<ActionCard>();
        expected.add(null);
        expected.add(new SnoopCard("/image/Action-Snoop.jpg"));
        
        assertEquals(expected.get(1).getActionText(), 
                self.getActionCards().get(1).getActionText());
    }

    /**
     * Test of drawAnActionCard method, of class GameState.
     */
    public void testDrawAnActionCard() {
        System.out.println("drawAnActionCard");

    }

    /**
     * Test of getChosenActionCard method, of class GameState.
     */
    public void testGetChosenActionCard() {
        System.out.println("getChosenActionCard");
        
    }

    /**
     * Test of setChosenActionCard method, of class GameState.
     */
    public void testSetChosenActionCard() {
        System.out.println("setChosenActionCard");
        
        List<ActionCard> expected = new ArrayList<ActionCard>();
        PrivateTipCard card1 = new PrivateTipCard(ClueType.SUSPECT, null);
        SuggestionCard card2 = new SuggestionCard(true, null);
        expected.add(card1);
        expected.add(card2);
        self.getHand().addToHand(card1);
        self.getHand().addToHand(card2);

        self.getHand().getActionCards().remove(0);
        state.setChosenActionCard(card1);
        assertEquals(card1, state.getChosenActionCard());
        
        self.getHand().addToHand(card1);
        assertEquals(card1, state.getChosenActionCard());
    }

    /**
     * Test of reset method, of class GameState.
     */
    public void testReset() {
        System.out.println("reset");
        
        state.reset();
        assertFalse(state.hasDrawn());
        assertFalse(state.isEndTurn());
        assertFalse(state.isInAction());
    }

    /**
     * Test of setTargetPlayer method, of class GameState.
     */
    public void testSetTargetPlayer() {
        System.out.println("setTargetPlayer");
        
        state.setTargetPlayer(p2);
        assertEquals(p2, state.getTargetPlayer());
        
        state.setTargetPlayer(self);
        assertEquals(self, state.getTargetPlayer());
        
    }

    /**
     * Test of setRandomClueCard method, of class GameState.
     */
    public void testSetRandomClueCard() {
        System.out.println("setRandomClueCard");
       
        SuspectCard card1 = new SuspectCard(theme.getSuspects().get(0));
        VehicleCard card2 = new VehicleCard(theme.getVehicles().get(0));
        state.setRandomClueCard(card1);
        assertEquals(card1, state.getRandomClueCard());
        
        state.setRandomClueCard(card2);
        assertEquals(card2, state.getRandomClueCard());
    }

    /**
     * Test of setCardsToBeChosen method, of class GameState.
     */
    public void testSetCardsToBeChosen() {
        System.out.println("setCardsToBeChosen");
        state.setCardsToBeChosen(null);
    }

    /**
     * Test of addCardMessage method, of class GameState.
     */
    public void testAddCardMessage() {
        System.out.println("addCardMessage");
        
        CardMessage cm = new CardMessage(self, p2, new SnoopCard(null));
        state.addCardMessage(cm);
        state.removeCardMessage();
        state.removeCardMessage();
    }

    /**
     * Test of setAccusation method, of class GameState.
     */
    public void testSetAccusation() {
        System.out.println("setAccusation");
        Solution accusation = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        
        state.setAccusation(accusation);
        assertEquals(accusation, state.getAccusation());
    }

    /**
     * Test of setAtomic method, of class GameState.
     */
    public void testSetAtomic() {
        System.out.println("setAtomic");
        
        assertTrue(state.getAtomic());
        state.setAtomic(false);
        assertFalse(state.getAtomic());
    }

}
