/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.*;
import tegakari.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tarrant
 */
public class RobotEngineInIdleTest extends TestCase {
    RobotEngineInIdle robot = new RobotEngineInIdle();
    RobotEngine engine;
    RobotEngineInActive active;
    RobotState state;
    
    RobotSnoopLogic snoop;
    RobotSleuthLogic sleuth;
    RobotSuggestionLogic suggestion;
    RobotPrivateTipLogic tip;
    
    CardMessage message;
    AILevel level;
    
    List<Card> list;
    
    List<ClueCard> cards;
    SuspectCard suspect;
    
    Player self;
    Player turn;
    
    Hand hand;
    
    Notepad note;
    ActionCard aCard;
    Queue<Player> queue;
    
    public RobotEngineInIdleTest() {
        engine = mock(RobotEngine.class);
        active = mock(RobotEngineInActive.class);
        state = mock(RobotState.class);
        
        snoop = mock(RobotSnoopLogic.class);
        sleuth = mock(RobotSleuthLogic.class);
        suggestion = mock(RobotSuggestionLogic.class);
        tip = mock(RobotPrivateTipLogic.class);
        
        message = mock(CardMessage.class);
        level = AILevel.BASIC;
        
        list = new ArrayList<>();
        cards = new ArrayList<>();
        
        suspect = mock(SuspectCard.class);
        when(suspect.getClueType()).thenReturn(ClueType.SUSPECT);
        cards.add(suspect);
        
        self = mock(Robot.class);
        turn = mock(Player.class);
        
        note = mock(Notepad.class);
        aCard = mock(ActionCard.class);
        
        queue = new LinkedList<Player>();
        queue.add(self);
        queue.add(turn);
        
        hand = mock(Hand.class);
        
        when(engine.getState()).thenReturn(state);
        when(state.getPlayers()).thenReturn(queue);
        when(state.getNote()).thenReturn(note);
        when(self.getHand()).thenReturn(hand);
        when(hand.getClueCards()).thenReturn(cards);
        
        
        robot.setEngine(engine);
        robot.setState(state);
        //testSetEngine();
        //testSetEngineActive();
    }
    
    public void testSetEngine() {
        robot.setEngine(engine);
        
        assertEquals(engine, robot.getEngine());
    }
    
    public void testSetEngineActive() {
        robot.setEngineActive(active);
        
        assertEquals(active, robot.getEngineActive());
    }
    
    public void testHandleAction() {
        // snoop card test
        
        
        when(message.getFromPlayer()).thenReturn(turn);
        when(message.getToPlayer()).thenReturn(self);
        when(state.getSelf()).thenReturn(self);
        when(self.isInGame()).thenReturn(true);
        when(turn.getClueCards()).thenReturn(cards);
        SnoopCard card = mock(SnoopCard.class);
        list.add(card);
        when(message.getCards()).thenReturn(list);
        when(snoop.responseToActionRequest(aCard, note, turn, self, level)).thenReturn(cards);
        when(card.isAllSnoop()).thenReturn(true);
        when(card.getDirection()).thenReturn(Direction.LEFT);
        List<Object> out = robot.handleActionRequest(message, level);
        //assertEquals(out.get(0), suspect);
        //assertNull(out)
        //System.out.println(out);
        CardMessage mess = (CardMessage)out.get(0);
        int size = mess.getCards().size();
        assertEquals(size, 1);
        verify(card).isAllSnoop();
        // sleuth card test
        list.remove(0);
        SuperSleuthCard card2 = mock(SuperSleuthCard.class);
        list.add(card2);
        when(message.getCards()).thenReturn(list);
        when(sleuth.responseToActionRequest(aCard, note, turn, self, level)).thenReturn(cards);
        out = robot.handleActionRequest(message, level);
        //assertEquals(out.get(0), suspect);
        //System.out.println(out);
        //System.out.println(out.get(0));
        //System.out.println(out.size());
        //Object hi = out.get(0);
        //assertEquals(h, null);
        //System.out.println(hi);
        //assertNull(out.get(0));
        //mess = (CardMessage)out.get(0);
        //assertEquals(0, message.getCards().size());
        assertEquals(0, out.size());
        //assertEquals(0, mess.getCards().size());
        //verify(sleuth).responseToActionRequest(aCard, note, turn, self, level);
        
        // private tip card test
        list.remove(0);
        PrivateTipCard card3 = mock(PrivateTipCard.class);
        list.add(card3);
        when(message.getCards()).thenReturn(list);
        when(tip.responseToActionRequest(aCard, note, turn, self, level)).thenReturn(cards);
        out = robot.handleActionRequest(message, level);
        //assertEquals(out.get(0), suspect);
        //System.out.println(out);
        //System.out.println(out.size());
        //assertNull(out);
        //mess = (CardMessage)out.get(0);
        //assertEquals(0, mess.getCards().size());
        assertEquals(0, out.size());
        
        // suggestion card test
        list.remove(0);
        SuggestionCard card4 = mock(SuggestionCard.class);
        list.add(card3);
        when(message.getCards()).thenReturn(list);
        when(snoop.responseToActionRequest(aCard, note, turn, self, level)).thenReturn(cards);
        out = robot.handleActionRequest(message, level);
        assertEquals(out.size(), 0);
        //assertNull(out);
        //message = (CardMessage)out.get(0);
        //assertEquals(0, message.getCards().size());
        //assertTrue(true);
    }
    
    public void testSuggestion() {
        SuggestionCardLogic logic = mock(SuggestionCardLogic.class);
        
        
        RobotState state = mock(RobotState.class);
        
        robot.setState(state);
        when(state.getSelf()).thenReturn(self);
        //when(suggestion.playMove(note)).thenReturn(null);
        when(logic.disprove(self)).thenReturn(null);
        when(state.getSelf()).thenReturn(self);
        when(self.getName()).thenReturn("a");
        
        //when(logic.isMoved()).thenReturn(true);
        
        
        List<DestinationCard> dest = new ArrayList<DestinationCard>();
        DestinationCard destin = mock(DestinationCard.class);
        
        dest.add(destin);
        when(note.getDestinations()).thenReturn(dest);
        
        //when(note.getDestinations().get(0).getDestination()).thenReturn(null);
        when(destin.getDestination()).thenReturn(null);
        
        when(self.setDestination(null)).thenReturn(null);
        // following line shouldn't be commented
        when(logic.getDisprover()).thenReturn(self);
        when(self.equalsName(self)).thenReturn(true);
        List<Object> out = robot.handleSuggestion(logic, level);
        
        assertEquals(out.size(), 0);
        //CardMessage mess = (CardMessage)out.get(0);
        //assertEquals(0, mess.getCards().size());
        //assertNull(out);
        //assertTrue(true);
        //verify(self.setDestination(null));
        //verify(suggestion.playMove());
        
        /*
        when(logic.isMoved()).thenReturn(false);
        robot.handleSuggestion(logic, level);
        verify(logic.disprove(self));*/
    }
    
    /*public void testSuggestion2() {
        SuggestionCardLogic logic = mock(SuggestionCardLogic.class);
        
        
        RobotState state = mock(RobotState.class);
        
        robot.setState(state);
        when(state.getSelf()).thenReturn(self);
        
        when(logic.isMoved()).thenReturn(true);
        
        //when(state.getSelf().setDestination())
    }*/
    
    public void testSnoop() {
        SnoopCardLogic logic = mock(SnoopCardLogic.class);
        SnoopCard sCard = mock(SnoopCard.class);
        
        when(sCard.getDirection()).thenReturn(Direction.LEFT);
        
        list.add(sCard);
        when(message.getCards()).thenReturn(list);
        when(message.getFromPlayer()).thenReturn(turn);
        when(message.getToPlayer()).thenReturn(self);
        
        //robot.handleActionRequest(message, AILevel.BASIC);
        //verify(snoop).responseToActionRequest(aCard, note, turn, self, level);
        when(state.getSelf()).thenReturn(self);
        when(self.isInGame()).thenReturn(true);
        //when(sCard.getDirection()).thenReturn(null);
        robot.handleActionRequest(message, AILevel.BASIC);
        assertTrue(true);
        // verify not responseToActionRequest?
    }
    
    public void testSleuth() {
        SuperSleuthCard sCard = mock(SuperSleuthCard.class);
        
        list.add(sCard);
        when(message.getCards()).thenReturn(list);
        when(message.getFromPlayer()).thenReturn(turn);
        when(message.getToPlayer()).thenReturn(self);
        
        robot.handleActionRequest(message, AILevel.BASIC);
        assertTrue(true);
        //verify(sleuth.responseToActionRequest(aCard, note, turn, self, level));
    }
    
    public void testTip() {
        PrivateTipCard pCard = mock(PrivateTipCard.class);
        
        list.add(pCard);
        when(message.getCards()).thenReturn(list);
        when(message.getFromPlayer()).thenReturn(turn);
        when(message.getToPlayer()).thenReturn(self);
        
        //when()
        when(state.getSelf()).thenReturn(self);
        when(self.getHand()).thenReturn(hand);
        robot.handleActionRequest(message, AILevel.BASIC);
        assertTrue(true);
        //verify(tip.responseToActionRequest(aCard, note, turn, self, level));
    }
}