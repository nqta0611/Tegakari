package integration_test;

import junit.framework.TestCase;
import tegakari.*;

/**
 *
 * @author DeionLaw
 */
public class RobotTest extends TestCase
{
    
    public RobotTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    public void testConstructors()
    {
        Robot robot = new Robot("robot", AILevel.BASIC);
        robot.getEngine();
        assertEquals(AILevel.BASIC, robot.getAILevel());
        assertTrue(robot.isRobot());
        Theme theme = new Theme();
        
        robot = new Robot("robotwo", new Hand(), theme.getDestinations().get(0), AILevel.SMART);
        robot.getEngine();
        assertEquals(AILevel.SMART, robot.getAILevel());
        assertTrue(robot.isRobot());
        assertEquals(0, robot.getHandSize());
        assertEquals(theme.getDestinations().get(0), robot.getDestination());
        
    }
    
    public void testGettersSetters()
    {
        Robot robot = new Robot("Robot", AILevel.BASIC);
        RobotEngine engine = new RobotEngine(robot, AILevel.SMART);
        robot.setEngine(engine);
        assertEquals(engine, robot.getEngine());
        robot.setAILevel(AILevel.SMART);
        assertEquals(AILevel.SMART, robot.getAILevel());
    }
}
