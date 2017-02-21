package integration_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.*;
import tegakari.*;

/**
 *
 * @author Tarrant
 */
public class RobotSnoopLogicTest extends TestCase{
    RobotSnoopLogic logic;
    Player turn;
    Player self;
    Queue<Player> list;
    Notepad note;
    AILevel basic = AILevel.BASIC;
    AILevel smart = AILevel.SMART;
    
    Hand hand;
    Hand hand2;
    Destination dm;
    Destination dm2;
    DestinationCard card;
    DestinationCard card2;
    
    List<Attribute> list1;
    List<Attribute> list2;
    
    ActionCard action;
    
    SuspectCard sCard;
    VehicleCard vCard;
    
    List<SuspectCard> suspects;
    List<VehicleCard> vehicles;
    List<DestinationCard> destinations;
    
    Solution solution;
    
    public RobotSnoopLogicTest() {
        logic = new RobotSnoopLogic();
        
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(Attribute.EASTERN);
        list2.add(Attribute.NORTHERN);
        
        Suspect s = new Suspect("hera", list1, "path1");
        Vehicle v = new Vehicle("card", list2, "path2");
        
        dm = new Destination("dm", list1, "path");
        dm2 = new Destination("dm2", list2, "path");
        card = new DestinationCard(dm);
        card2 = new DestinationCard(dm2);
        sCard = new SuspectCard(s);
        vCard = new VehicleCard(v);
        hand = new Hand();
        hand.addToHand(card);
        
        turn = new HumanPlayer("turn", hand, dm2);
        hand2 = new Hand();
        hand2.addToHand(card2);
        self = new Robot("self", hand2, dm, AILevel.SMART);
        
        action = new SnoopCard("snoopPath");
        
        list = new LinkedList<>();
        list.add(turn);
        list.add(self);
        
        suspects = new ArrayList<>();
        suspects.add(sCard);
        vehicles = new ArrayList<>();
        vehicles.add(vCard);
        destinations = new ArrayList<>();
        destinations.add(card);
        destinations.add(card2);
        
        solution = new Solution(s, v, dm);
        note = new Notepad(list, suspects, vehicles, destinations, solution);
    }
    
    
    
    public void testResponse() {
         List<ClueCard> out;
         
         out = logic.responseToActionRequest(action, note, turn, self, basic);
         
         DestinationCard cardOut = (DestinationCard)out.get(0);
         
         DestinationCard check = card2;
         
         // why are we snooping on turn player?
         // aren't we suppose to snoop on the next player in the list?
         // right now the method snoops on the param turn player
         assertEquals(cardOut, card);
         
         NoteEntry entry = note.getEntry(card, turn);
         
         assertEquals(NoteEntry.HAS, entry);
         
         entry = note.getEntry(card, self);
         
         assertEquals(NoteEntry.HASNOT, entry);
         
         ClueCard put = logic.playSnoop((SnoopCard) action, note, turn, (Robot)self, basic);
         
         assertEquals(card, (DestinationCard) put);
         
    }
    
    public void testBenefit() {
        SnoopCard snoop = (SnoopCard) action;
        
        int out = logic.benefitFromAction(note, action);
        
        snoop = new SnoopCard(Direction.LEFT, "thePath");
        int out2 = logic.benefitFromAction(note, action);
        
        note.mark(card, self, NoteEntry.HAS);
        int out4 = logic.benefitFromAction(note, action);
        
        action = new PrivateTipCard(ClueType.DESTINATION, "path");
        
        int out3 = logic.benefitFromAction(note, action);
        
        
        assertEquals(5, out);
        assertEquals(5, out2);
        assertEquals(-1, out3);
        assertEquals(1, out4);
    }
}