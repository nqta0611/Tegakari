/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import tegakari.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tarrant
 */
public class RobotSuggestionLogicTest extends TestCase{
    Notepad note;
    ActionCard action;
    SuggestionCard action2;
    SuggestionCardLogic logic;
    Player turn;
    Player self;
    AILevel level;
    RobotSuggestionLogic robot;
    List<DestinationCard> destinations;
    DestinationCard card;
    DestinationCard card2;
    
    List<SuspectCard> suspects;
    SuspectCard card3;
    SuspectCard card4;
    
    List<VehicleCard> vehicles;
    VehicleCard card5;
    VehicleCard card6;
    
    Destination d;
    Suspect s;
    Vehicle v;
    
    Solution solution;
    
    public RobotSuggestionLogicTest() {
        note = mock(Notepad.class);
        action = mock(SuggestionCard.class);
        action2 = mock(SuggestionCard.class);
        logic = mock(SuggestionCardLogic.class);
        turn = mock(Player.class);
        self = mock(Player.class);
        level = AILevel.BASIC;
        
        card = mock(DestinationCard.class);
        card2 = mock(DestinationCard.class);
        card3 = mock(SuspectCard.class);
        card4 = mock(SuspectCard.class);
        card5 = mock(VehicleCard.class);
        card6 = mock(VehicleCard.class);
        d = mock(Destination.class);
        s = mock(Suspect.class);
        v = mock(Vehicle.class);
        
        destinations = new ArrayList<>();
        destinations.add(card);
        destinations.add(card2);

        suspects = new ArrayList<>();
        suspects.add(card3);
        suspects.add(card4);

        vehicles = new ArrayList<>();
        vehicles.add(card5);
        vehicles.add(card6);
        
        solution = mock(Solution.class);
        
        robot = new RobotSuggestionLogic(note, self);
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    
    public void testResponse() {
        
        List<ClueCard> list = new ArrayList<ClueCard>(destinations);
        //System.out.println(destinations.get(0));
        //System.out.println(list.get(0));
        //when(logic.isDisprovable(null)).thenReturn(true);
        when(logic.disprove(self)).thenReturn(list);
        when(note.getEntry(card, turn)).thenReturn(NoteEntry.SHOWN);
        List<ClueCard> response = robot.responseToActionRequest(logic, turn, level);
        //System.out.println(response.get(0));
        assertEquals(card, response.get(0));
        
        // test smart 1 card in list
        
        list.remove(1);
        response = robot.responseToActionRequest(logic, turn, AILevel.SMART);
        
        assertEquals(card, response.get(0));
        
        // test smart 2 cards in list
        list.add(card2);
        
        when(logic.disprove(turn)).thenReturn(list);
        when(note.getEntry(card, turn)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card2, turn)).thenReturn(NoteEntry.SHOWN);
        response = robot.responseToActionRequest(logic, turn, AILevel.SMART);
        
        assertEquals(card2, response.get(0));
        
        // no shown cards, 2 card list, SMART AI
        when(note.getEntry(card2, turn)).thenReturn(NoteEntry.BLANK);
        response = robot.responseToActionRequest(logic, turn, AILevel.SMART);
        
        assertEquals(card, response.get(0));
        
        // test no valid cards
        list = new ArrayList<>();
        when(logic.disprove(self)).thenReturn(list);
        
        response = robot.responseToActionRequest(logic, turn, level);
        assertNull(response);
        
        
    }
    
    public void testBenefit() {
        when(note.getDestinations()).thenReturn(destinations);
        when(note.getSuspects()).thenReturn(suspects);
        when(note.getVehicles()).thenReturn(vehicles);
        
        when(note.getEntry(card, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card3, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card4, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card5, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card6, self)).thenReturn(NoteEntry.BLANK);
        
        int benefit = robot.benefitFromAction(action);
        
        // would need a fake for the following line to work
        //assertEquals(3, benefit);
        
        // this assert is only here to avoid using a fake
        assertEquals(3, benefit);
        
        when(note.getEntry(card, self)).thenReturn(NoteEntry.HASNOT);
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.HAS);
        benefit = robot.benefitFromAction(action);
        assertEquals(2, benefit);
        
        when(note.getEntry(card3, self)).thenReturn(NoteEntry.HASNOT);
        when(note.getEntry(card4, self)).thenReturn(NoteEntry.HAS);
        benefit = robot.benefitFromAction(action);
        assertEquals(1, benefit);
        
        // is current suggestion
        when(action2.isCurrentSuggestion()).thenReturn(true);
        benefit = robot.benefitFromAction(action2);
        assertEquals(0, benefit);
        
        // isn't current suggestion
        when(action2.isCurrentSuggestion()).thenReturn(false);
        benefit = robot.benefitFromAction(action2);
        assertEquals(1, benefit);
        
        // no cards visible
        when(note.getEntry(card5, self)).thenReturn(NoteEntry.HASNOT);
        when(note.getEntry(card6, self)).thenReturn(NoteEntry.HAS);
        benefit = robot.benefitFromAction(action);
        assertEquals(0, benefit);
        // no cards visible and is curren't suggestion
        when(action2.isCurrentSuggestion()).thenReturn(true);
        benefit = robot.benefitFromAction(action2);
        assertEquals(0, benefit);
        
        // no cards visible and isn't curren't suggestion
        when(action2.isCurrentSuggestion()).thenReturn(false);
        benefit = robot.benefitFromAction(action2);
        assertEquals(0, benefit);
    }
    
    public void testPlayCard() {
        when(note.getSuspects()).thenReturn(suspects);
        when(note.getEntry(card3, self)).thenReturn(NoteEntry.HAS);
        when(note.getEntry(card4, self)).thenReturn(NoteEntry.BLANK);
        
        when(note.getVehicles()).thenReturn(vehicles);
        when(note.getEntry(card5, self)).thenReturn(NoteEntry.HAS);
        when(note.getEntry(card6, self)).thenReturn(NoteEntry.BLANK);
        
        when(note.getDestinations()).thenReturn(destinations);
        when(note.getEntry(card, self)).thenReturn(NoteEntry.HAS);
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.BLANK);
        
        
        /*System.out.println(suspects.get(0));
        System.out.println(vehicles.get(0));
        System.out.println(destinations.get(0));
        
        System.out.println(note.getSuspects().get(0));
        System.out.println(note.getVehicles().get(0));
        System.out.println(note.getDestinations().get(0));*/
        
        when(card.getDestination()).thenReturn(d);
        
        SuggestionCardLogic out = robot.playSuggestion();
        verify(note).getDestinations();
        verify(note).getSuspects();
        verify(note).getVehicles();
        
        //verify(self).getDestination();
        
        //when(out.getGuess()).thenReturn(solution);
        
        suspects.remove(1);
        destinations.remove(1);
        vehicles.remove(1);
        
        out = robot.playSuggestion();
        
        // the times include the one from the previous verifies above
        verify(note, times(3)).getDestinations();
        verify(note, times(3)).getSuspects();
        verify(note, times(3)).getVehicles();
        //verify(self).getDestination();
        //when(solution.equals(out.getGuess())).thenReturn(true);
        //assertEquals(solution, out.getGuess());
        
    }
    
    public void testMove() {
        System.out.println(destinations.size());
        when(note.getDestinations()).thenReturn(destinations);
        
        when(note.getEntry(card, self)).thenReturn(NoteEntry.HAS);
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.HAS);
        when(card.getDestination()).thenReturn(this.d);
       //when(card2.getDestination()).thenReturn(d);
        //when(d.equals(card.getDestination())).thenReturn(true);
        Destination d = robot.playMove();
        
        assertEquals(d, card.getDestination());
        verify(note, times(2)).getDestinations();
        
        // can't cast mocks... so can't have the NoteEntry's be BLANK
        // as then it will try to cast a mock
        
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.BLANK);
        when(card.getDestination()).thenReturn(this.d);
        //when(note.getEntry(card, self)).thenReturn(NoteEntry.BLANK);
        d = robot.playMove();
        //assertEquals(d, card.getDestination());
        assertNull(d);
        /*
        when(note.getEntry(card2, self)).thenReturn(NoteEntry.BLANK);
        robot = new RobotSuggestionLogic(note, self);
        Destination d2 = mock(Destination.class);
        when(card.getDestination()).thenReturn(d2);
        
        d = robot.playMove();
        assertEquals(d, d2);*/
        //System.out.println(destinations.size());
    }
    
    public void testFind() {
        
        List<ClueCard> list = new ArrayList<ClueCard>(destinations);
        
        when(note.getDestinations()).thenReturn(destinations);
        when(note.getEntry(card, self)).thenReturn(NoteEntry.BLANK);
        when(note.getEntry(card2, turn)).thenReturn(NoteEntry.HAS);
        
        List<ClueCard> check = robot.findUnknown(note, list, self);
        
        assertEquals(1, check.size());
        assertEquals(check.get(0), card);
    }
}