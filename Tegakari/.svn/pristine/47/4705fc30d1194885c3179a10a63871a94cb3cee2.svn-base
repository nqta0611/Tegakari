package integration_test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import junit.framework.TestCase;
import tegakari.*;

/**
 *
 * @author cathibod
 */
public class RobotEngineHandleProtocolsTest extends TestCase {
    
    public RobotEngineHandleProtocolsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of handleProtocol method, of class RobotEngineHandleProtocols.
     */
    public void testHandleProtocol() {
        System.out.println("handleProtocol");
        Protocol ptc = Protocol.END_TURN;
        Queue<Player> players = new ArrayDeque<Player>();
        Hand hand = new Hand();
        Robot robot = new Robot("ROBOT", hand, null, AILevel.BASIC);
        players.add(robot);
        players.add(robot);
        RobotEngine engine = new RobotEngine(robot, AILevel.BASIC);
        Table table = new Table(new Theme());
        Deck deck = table.getActionDeck();
        
        hand.addToHand(new PrivateTipCard(ClueType.SUSPECT,""));
        while(!deck.isEmpty())
        {
            deck.dealCard();
        }
        engine.setTable(table);
        RobotState robotState = new RobotState(players, robot, robot);
        robotState.setSelf(robot);
        robotState.setNote(createNotepadFromTheme(players, new Theme()));
        engine.setState(robotState);
        RobotEngineInActive engineActive = new RobotEngineInActive(engine, robotState);
        engineActive.setState(robotState);
        engine.setEngineActive(engineActive);
        
        RobotEngineHandleProtocols instance = new RobotEngineHandleProtocols();
        List<Object> result = instance.handleProtocol(ptc, engine);
        assertFalse(result.isEmpty());
    }
    
    private Notepad createNotepadFromTheme(Queue<Player> players, Theme theme)
    {
        List<SuspectCard> suspects = new ArrayList<SuspectCard>();
        List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
        List<DestinationCard> destinations = new ArrayList<DestinationCard>();

        // create suspect cards
        for (Suspect suspect : theme.getSuspects())
        {
            suspects.add(new SuspectCard(suspect));
        }
        // create vehicle cards
        for (Vehicle vehicle : theme.getVehicles())
        {
            vehicles.add(new VehicleCard(vehicle));
        }
        // create destination cards
        for (Destination destination : theme.getDestinations())
        {
            destinations.add(new DestinationCard(destination));
        }

        return new Notepad(players, suspects, vehicles, destinations, null);
    }
}
