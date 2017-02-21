package integration_test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import junit.framework.*;
import tegakari.*;

/**
 * Integration test class for RobotSleuthLogic.
 * @author Jonathan Molina
 */
public class RobotSleuthLogicTest extends TestCase
{
    private List<SuspectCard> suspects = new ArrayList<SuspectCard>();
    private List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
    private List<DestinationCard> destinations = new ArrayList<DestinationCard>();
        
    protected void setUp() throws Exception
    {
        Theme theme = new Theme();
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
    }
    
    /**
     * Test of responseToActionRequest method, of class RobotSleuthLogic.
     */
    public void testResponseToActionRequest() {
        System.out.println("responseToActionRequest");
        Player turn = new HumanPlayer("user");;
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(turn);
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(turn);
        queue.add(self);
        
        Notepad note = new Notepad(queue, suspects, vehicles, destinations, null);
        // One card matching the ClueCard
        DestinationCard dc = destinations.get(4);
        Hand oneReturn = new Hand();
        oneReturn.addToHand(dc);
        
        // Add cards to hand
        Hand hand = self.getHand();
        List<ClueCard> cards =  hand.getClueCards();
        for (ClueCard card : cards)
        {
            hand.remove(card);
        }
        for (ClueCard card : oneReturn.getClueCards())
        {
            hand.addToHand(card);
        }
        
        AILevel level = AILevel.SMART;
        RobotSleuthLogic instance = new RobotSleuthLogic(AILevel.SMART, players);
        List<ClueCard> expResult = new ArrayList<ClueCard>();
        expResult.add(dc);
        note.mark(dc, turn, NoteEntry.SHOWN);
        ActionCard action = new SuperSleuthCard(dc.getClueType(), dc.getAttribute().get(0), "/image/Action-SuperSleuthSouth.jpg");
        List result = instance.responseToActionRequest(action, note, turn, self, AILevel.SMART);
        List result1 = instance.responseToActionRequest(action, note, turn, self, AILevel.BASIC);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of benefitFromAction method, of class RobotSleuthLogic.
     */
    public void testBenefitFromAction() {
        System.out.println("benefitFromAction");
        Player turn = new HumanPlayer("user");
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(turn);
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(turn);
        queue.add(self);
        
        Notepad note = new Notepad(queue, suspects, vehicles, destinations, null);
        
        // Empty List No information on Destination
        List<DestinationCard> destList = new ArrayList<DestinationCard>();
        List<Attribute> att = new ArrayList<Attribute>();
        att.add(Attribute.NORTHERN);

        DestinationCard dc = destinations.get(0);
        destList.add(dc);
        note.mark(dc, turn, NoteEntry.BLANK);
        note.mark(dc, self, NoteEntry.HASNOT);

        ActionCard action = new SuperSleuthCard(dc.getClueType(), dc.getAttribute().get(0), null);
        RobotSleuthLogic instance = new RobotSleuthLogic(AILevel.SMART, players);
        int expResult = 5;
        int result = instance.benefitFromAction(note, action);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of playSleuth method, of class RobotSleuthLogic.
     */
    public void testPlaySleuth() {
        System.out.println("playSleuth");
        Player turn = new HumanPlayer("user");
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(turn);
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(turn);
        queue.add(self);
        
        Notepad note = new Notepad(queue, suspects, vehicles, destinations, null);
        ActionCard action = new SuperSleuthCard(ClueType.DESTINATION, Attribute.NORTHERN, "/image/Action-SuperSleuthSouth.jpg");
        RobotSleuthLogic instance = new RobotSleuthLogic(AILevel.SMART, players);
        
        List expResult = new ArrayList<CardMessage>();
        expResult.add(new CardMessage(turn, self, action));
        List result = instance.playSleuth(self, action);
        assertEquals(expResult.size(), result.size());
    }
}
