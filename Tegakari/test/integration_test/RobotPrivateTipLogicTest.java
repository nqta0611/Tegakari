package integration_test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import static junit.framework.Assert.assertEquals;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;
import tegakari.*;

/**
 *
 * @author Chris Thibodeau - cathibod
 */
public class RobotPrivateTipLogicTest extends TestCase 
{
    private RobotPrivateTipLogic logic;
    private PrivateTipCard privateCard;
    private Notepad notepad;
    private HumanPlayer humanPlayer;
    private HumanPlayer player2;
    private HumanPlayer player3;
    private Robot robotPlayer;
    private Hand hand;
    private String[] playerNames = {"P1", "P2", "P3", "P4"};
    private List<Player> players;
    private Map<String, ClueCard> cards;
    
    private List<SuspectCard> suspects;
    private List<VehicleCard> vehicles;
    private List<DestinationCard> destinations;
    
    
    
    /**
     * The method called before every test method.
     * 
     * @throws Exception 
     */
    @Override
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
    
    public void testResponseToActionRequest()
    {
        System.out.println("responseToActionRequest");
        humanPlayer = new HumanPlayer("user");
        robotPlayer = new Robot("cpu", AILevel.SMART);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.FEMALE,"");
        List<Player> players = new ArrayList<Player>();
        players.add(humanPlayer);
        players.add(robotPlayer);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(humanPlayer);
        queue.add(robotPlayer);
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        
        
        // Add cards to hand
        Hand hand = robotPlayer.getHand();
        List<ClueCard> cards =  hand.getClueCards();
        for (ClueCard card : cards)
        {
            hand.remove(card);
        }
        
        hand.addToHand(suspects.get(0));
        hand.addToHand(suspects.get(1));
        hand.addToHand(suspects.get(4));
        hand.addToHand(suspects.get(5));
        hand.addToHand(destinations.get(2));
        hand.addToHand(vehicles.get(0));
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        expected.add(suspects.get(0));
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        List<ClueCard> results = logic.responseToActionRequest(privateCard, 
                notepad, humanPlayer, robotPlayer, AILevel.SMART);

        assertEquals(expected, results);
    }
    
    public void testResponseToAllActionRequest()
    {
        System.out.println("responseToAllActionRequest");
        humanPlayer = new HumanPlayer("user");
        robotPlayer = new Robot("cpu", AILevel.SMART);
        privateCard = new PrivateTipCard(ClueType.SUSPECT,"");
        List<Player> players = new ArrayList<Player>();
        players.add(humanPlayer);
        players.add(robotPlayer);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(humanPlayer);
        queue.add(robotPlayer);
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        
        // Add cards to hand
        Hand hand = robotPlayer.getHand();
        List<ClueCard> cards =  hand.getClueCards();
        for (ClueCard card : cards)
        {
            hand.remove(card);
        }
        
        hand.addToHand(suspects.get(0));
        hand.addToHand(suspects.get(1));
        hand.addToHand(suspects.get(4));
        hand.addToHand(suspects.get(5));
        hand.addToHand(destinations.get(2));
        hand.addToHand(vehicles.get(0));
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        expected.add(suspects.get(0));
        expected.add(suspects.get(1));
        expected.add(suspects.get(4));
        expected.add(suspects.get(5));
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        List<ClueCard> results = logic.responseToActionRequest(privateCard, 
                notepad, humanPlayer, robotPlayer, AILevel.SMART);

        assertEquals(expected, results);
    }
    
    public void testBenefitFromActionSuspects()
    {
        System.out.println("testBenefitFromActionSuspects"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.FEMALE,"");
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(4, results);
    }

    public void testBenefitFromActionSuspects1() 
    {
        System.out.println("testBenefitFromActionSuspects1");
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.FEMALE,"");
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(suspects.get(0), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(1), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(2), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(3), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(4), self, NoteEntry.SHOWN);
        
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(1, results);
    }
    
    public void testBenefitFromActionSuspects2() 
    {
        System.out.println("testBenefitFromActionSuspects2"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.FEMALE,"");
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(suspects.get(0), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(1), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(2), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(3), self, NoteEntry.SHOWN);
        
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(1, results);
    }
    
    public void testBenefitFromActionSuspects3() 
    {
        System.out.println("testBenefitFromActionSuspects3"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.FEMALE,"");
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(suspects.get(0), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(1), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(2), self, NoteEntry.SHOWN);
        
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(1, results);
    }
    
    public void testBenefitFromActionSuspects4() 
    {
        System.out.println("testBenefitFromActionSuspects4"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.SUSPECT, 
                Attribute.MALE,"");
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(suspects.get(0), self, NoteEntry.SHOWN);
        notepad.mark(suspects.get(1), self, NoteEntry.SHOWN);
        
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(4, results);
    }
    
    public void testBenefitFromActionDestinations() 
    {
        System.out.println("testBenefitFromActionDestinations"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.DESTINATION, 
                Attribute.EASTERN,"");
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(destinations.get(1), self, NoteEntry.SHOWN);
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(3, results);
    }
    
    public void testBenefitFromActionDestinations3() 
    {
        System.out.println("testBenefitFromActionDestinations3"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.DESTINATION, 
                Attribute.EASTERN,"");
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(destinations.get(0), self, NoteEntry.SHOWN);
        notepad.mark(destinations.get(1), self, NoteEntry.SHOWN);
        notepad.mark(destinations.get(2), self, NoteEntry.SHOWN);
        notepad.mark(destinations.get(3), self, NoteEntry.SHOWN);
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(2, results);
    }
    
    public void testBenefitFromActionVehicles() 
    {
        System.out.println("testBenefitFromActionVehicles"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.VEHICLE, 
                Attribute.GROUND,"");
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(vehicles.get(1), self, NoteEntry.SHOWN);
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(3, results);
    }
    
    public void testBenefitFromActionVehicles3() 
    {
        System.out.println("testBenefitFromActionVehicles3"); 
        Player self = new Robot("cpu", AILevel.SMART);
        List<Player> players = new ArrayList<Player>();
        players.add(self);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(self);
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        privateCard = new PrivateTipCard(ClueType.VEHICLE, 
                Attribute.GROUND,"");
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
        notepad.mark(vehicles.get(0), self, NoteEntry.SHOWN);
        notepad.mark(vehicles.get(1), self, NoteEntry.SHOWN);
        notepad.mark(vehicles.get(2), self, NoteEntry.SHOWN);
        
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, privateCard);
        assertEquals(2, results);
    }
    
    public void testPlayPrivateTip() 
    {
        System.out.println("playPrivateTip");       
        Player target = new HumanPlayer("user");
        privateCard = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE,"");
        players = new ArrayList<Player>();
        players.add(target);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(target);
        // Set up target player's hand
        Hand hand = target.getHand();
        List<ClueCard> cards =  hand.getClueCards();
        for (ClueCard card : cards)
        {
            hand.remove(card);
        }
        hand.addToHand(suspects.get(0));
        hand.addToHand(suspects.get(4));
        hand.addToHand(suspects.get(5));
        hand.addToHand(destinations.get(2));
        hand.addToHand(vehicles.get(0));
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        expected.add(suspects.get(4));
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
                
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        List<ClueCard> results = logic.playPrivateTip(notepad, target, privateCard);
        assertEquals(expected, results);
    }
    
    public void testPlayAllPrivateTip() 
    {
        System.out.println("playAllPrivateTip");       
        Player target = new HumanPlayer("user");
        privateCard = new PrivateTipCard(ClueType.SUSPECT, "");
        players = new ArrayList<Player>();
        players.add(target);
        Queue<Player> queue = new ArrayDeque<Player>();
        queue.add(target);
        // Set up target player's hand
        Hand hand = target.getHand();
        List<ClueCard> cards =  hand.getClueCards();
        for (ClueCard card : cards)
        {
            hand.remove(card);
        }
        hand.addToHand(suspects.get(0));
        hand.addToHand(suspects.get(4));
        hand.addToHand(suspects.get(5));
        hand.addToHand(destinations.get(2));
        hand.addToHand(vehicles.get(0));
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        expected.add(suspects.get(0));
        expected.add(suspects.get(4));
        expected.add(suspects.get(5));
        
        
        notepad = new Notepad(queue, suspects, vehicles, destinations, null);
                
        logic = new RobotPrivateTipLogic(AILevel.SMART, players);
        List<ClueCard> results = logic.playPrivateTip(notepad, target, privateCard);
        assertEquals(expected, results);
    }
}