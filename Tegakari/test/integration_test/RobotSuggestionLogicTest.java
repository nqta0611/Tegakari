package integration_test;

import java.util.*;
import tegakari.*;

/**
 *
 * @author DeionLaw
 */
public class RobotSuggestionLogicTest extends junit.framework.TestCase 
{
    private ArrayList<SuspectCard> suspects;
    private ArrayList<VehicleCard> vehicles;
    private ArrayList<DestinationCard> destinations;
    
    public RobotSuggestionLogicTest(String s)
    {
        super(s);
    }
    
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
    
    public void testBasicResponse()
    {
        HumanPlayer human = new HumanPlayer("Human", new Hand(), 
                destinations.get(4).getDestination());
        
        Hand nonDisprovingHand = new Hand();
        nonDisprovingHand.addToHand(suspects.get(1));
        nonDisprovingHand.addToHand(vehicles.get(1));
        nonDisprovingHand.addToHand(destinations.get(1));
        
        Hand vehicleHand = new Hand();
        vehicleHand.addToHand(suspects.get(1));
        vehicleHand.addToHand(vehicles.get(0));
        vehicleHand.addToHand(destinations.get(1));
        
        Robot basicRobot = new Robot("Robot - Basic",nonDisprovingHand, 
                    destinations.get(2).getDestination(), AILevel.BASIC);
        
        SuggestionCard anySuggestion = new SuggestionCard(false,
                    "/image/Action-SuggestionAny.jpg");
        
        Solution solution = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        
        Queue<Player> players = new LinkedList<>();
        players.add(human);
        players.add(basicRobot);
        
        Notepad blankNote = new Notepad(players, suspects, vehicles, destinations, null);
        RobotSuggestionLogic basicRobotLogic = new RobotSuggestionLogic(blankNote, 
                basicRobot);
        SuggestionCardLogic basicLogic = new SuggestionCardLogic(anySuggestion, human, 
                null, solution);
        
        assertNull(basicRobotLogic.responseToActionRequest(basicLogic, human, 
                AILevel.BASIC));
        
        basicRobot = new Robot("Robot - Basic",vehicleHand, 
                    destinations.get(2).getDestination(), AILevel.BASIC);
        basicRobotLogic = new RobotSuggestionLogic(blankNote, basicRobot);
        
        assertEquals(vehicles.get(0), basicRobotLogic.responseToActionRequest(basicLogic,
                human, AILevel.BASIC).get(0));
    }
    
    public void testSmartResponse()
    {
        
        Hand vehicleHand = new Hand();
        vehicleHand.addToHand(suspects.get(1));
        vehicleHand.addToHand(vehicles.get(0));
        vehicleHand.addToHand(destinations.get(1));
        
        Hand suspectDestinationHand = new Hand();
        suspectDestinationHand.addToHand(suspects.get(0));
        suspectDestinationHand.addToHand(vehicles.get(1));
        suspectDestinationHand.addToHand(destinations.get(0));
        
        SuggestionCard anySuggestion = new SuggestionCard(false,
                    "/image/Action-SuggestionAny.jpg");
        
        Solution solution = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        
        
        Robot smartRobot = new Robot("Robot - Smart",vehicleHand, 
                    destinations.get(3).getDestination(), AILevel.SMART);
        HumanPlayer human = new HumanPlayer("Human", new Hand(), 
                destinations.get(4).getDestination());
        
        Queue<Player> players = new LinkedList<>();
        players.add(human);
        players.add(smartRobot);
        
        Notepad blankNote = new Notepad(players, suspects, vehicles, destinations, null);
        RobotSuggestionLogic smartRobotLogic = new RobotSuggestionLogic(blankNote, 
                smartRobot);
        SuggestionCardLogic smartLogic = new SuggestionCardLogic(anySuggestion, human, 
                null, solution);
        
        assertEquals(vehicles.get(0), smartRobotLogic.responseToActionRequest(smartLogic,
                human, AILevel.SMART).get(0));
        
        smartRobot = new Robot("Robot - Smart", suspectDestinationHand, 
                    destinations.get(3).getDestination(), AILevel.SMART);
        smartRobotLogic = new RobotSuggestionLogic(blankNote, smartRobot);
        
        assertEquals(NoteEntry.BLANK, blankNote.getEntry(suspects.get(0), human));
        assertEquals(suspects.get(0), smartRobotLogic.responseToActionRequest(smartLogic,
                human, AILevel.SMART).get(0));
        assertEquals(NoteEntry.SHOWN, blankNote.getEntry(suspects.get(0), human));
        assertEquals(suspects.get(0), smartRobotLogic.responseToActionRequest(smartLogic,
                human, AILevel.SMART).get(0));
        
        blankNote.mark(suspects.get(0), human, NoteEntry.BLANK);
        blankNote.mark(destinations.get(0), human, NoteEntry.SHOWN);
        
        assertEquals(destinations.get(0), 
                smartRobotLogic.responseToActionRequest(smartLogic, human, 
                AILevel.SMART).get(0));
        
        blankNote.mark(suspects.get(0), smartRobot, NoteEntry.SHOWN);
        assertEquals(destinations.get(0), 
                smartRobotLogic.responseToActionRequest(smartLogic, human, 
                AILevel.SMART).get(0));
    }
    
    public void testBenefit()
    {
        Robot robot = new Robot("Robot - Smart", AILevel.SMART);
        HumanPlayer human = new HumanPlayer("Human");
        Queue<Player> players = new LinkedList<>();
        players.add(human);
        players.add(robot);
        Notepad blankNote = new Notepad(players, suspects, vehicles, destinations, null);
        SuggestionCard anySuggestion = new SuggestionCard(false,
                    "/image/Action-SuggestionAny.jpg");
        SuggestionCard currSuggestion = new SuggestionCard(true,
                    "/image/Action-SuggestionCurrent.jpg");
        
        RobotSuggestionLogic logic = new RobotSuggestionLogic(blankNote, robot);
        
        assertEquals(3, logic.benefitFromAction(anySuggestion));
        assertEquals(2, logic.benefitFromAction(currSuggestion));
        
        for(DestinationCard dest : destinations)
        {
            blankNote.mark(dest, robot, NoteEntry.HAS);
        }
        
        assertEquals(2, logic.benefitFromAction(anySuggestion));
        assertEquals(1, logic.benefitFromAction(currSuggestion));
        
        for(VehicleCard vehicle : vehicles)
        {
            blankNote.mark(vehicle, robot, NoteEntry.HAS);
        }
        
        assertEquals(1, logic.benefitFromAction(anySuggestion));
        assertEquals(0, logic.benefitFromAction(currSuggestion));
        
        for(SuspectCard sus : suspects)
        {
            blankNote.mark(sus, robot, NoteEntry.HAS);
        }
        
        assertEquals(0, logic.benefitFromAction(anySuggestion));
        assertEquals(0, logic.benefitFromAction(currSuggestion));
    }
    
    public void testPlayMove()
    {
        Robot robot = new Robot("Robot - Smart", AILevel.SMART);
        HumanPlayer human = new HumanPlayer("Human");
        Queue<Player> players = new LinkedList<>();
        players.add(human);
        players.add(robot);
        Notepad blankNote = new Notepad(players, suspects, vehicles, destinations, null);
        
        RobotSuggestionLogic logic = new RobotSuggestionLogic(blankNote, robot);
        
        assertEquals(destinations.get(0).getDestination(), logic.playMove());
        
        blankNote.mark(destinations.get(0), robot, NoteEntry.HAS);
        
        assertEquals(destinations.get(1).getDestination(), logic.playMove());
        
        for(DestinationCard dest : destinations)
        {
            blankNote.mark(dest, robot, NoteEntry.HAS);
        }
        
        assertEquals(destinations.get(0).getDestination(), logic.playMove());
    }
    
    public void testPlaySuggestion()
    {
        Robot robot = new Robot("Robot - Smart", new Hand(), 
                destinations.get(0).getDestination(), AILevel.SMART);
        HumanPlayer human = new HumanPlayer("Human");
        Queue<Player> players = new LinkedList<>();
        players.add(human);
        players.add(robot);
        Notepad blankNote = new Notepad(players, suspects, vehicles, destinations, null);
        
        RobotSuggestionLogic logic = new RobotSuggestionLogic(blankNote, robot);
        
        Solution solution1 = new Solution(suspects.get(0).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        
        assertEquals(solution1, logic.playSuggestion().getGuess());
        
        blankNote.mark(suspects.get(0), robot, NoteEntry.HAS);
        
        Solution solution2 = new Solution(suspects.get(1).getSuspect(), 
                vehicles.get(0).getVehicle(), destinations.get(0).getDestination());
        
        assertEquals(solution2, logic.playSuggestion().getGuess());
        
        blankNote.mark(vehicles.get(0), robot, NoteEntry.HAS);
        
        Solution solution3 = new Solution(suspects.get(1).getSuspect(), 
                vehicles.get(1).getVehicle(), destinations.get(0).getDestination());
        
        assertEquals(solution3, logic.playSuggestion().getGuess());
        
        blankNote.mark(destinations.get(0), robot, NoteEntry.HAS);
        
        Solution solution4 = new Solution(suspects.get(1).getSuspect(), 
                vehicles.get(1).getVehicle(), destinations.get(1).getDestination());
        
        assertEquals(solution4, logic.playSuggestion().getGuess());
        
        for(DestinationCard dest : destinations)
        {
            blankNote.mark(dest, robot, NoteEntry.HAS);
        }
                
        for(VehicleCard vehicle : vehicles)
        {
            blankNote.mark(vehicle, robot, NoteEntry.HAS);
        }
        
        for(SuspectCard sus : suspects)
        {
            blankNote.mark(sus, robot, NoteEntry.HAS);
        }
        
        assertEquals(solution1, logic.playSuggestion().getGuess());
    }
}