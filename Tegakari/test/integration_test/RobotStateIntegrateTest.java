package integration_test;

import java.util.*;
import junit.framework.*;
import tegakari.*;

/**
 *
 * @author Josh Choi
 */
public class RobotStateIntegrateTest extends TestCase
{
    Queue<Player> players = new LinkedList<Player>();
    
    HumanPlayer p1;
    Robot r1;
    Robot r2;
    Robot r3;
    Robot r4;
    
    public RobotStateIntegrateTest(String testName)
    {
        super(testName);
    }
    
    protected void setUp() throws Exception
    {
        super.setUp();
        p1 = new HumanPlayer("Josh");
        r1 = new Robot("Rob1", AILevel.SMART);
        r2 = new Robot("Rob2", AILevel.SMART);
        r3 = new Robot("Rob3", AILevel.SMART);
        r4 = new Robot("Rob4", AILevel.SMART);
        players.add(p1);
        players.add(r1);
    }
    
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    public void testPlayerQueue()
    {
        RobotState state = new RobotState(players, r1, p1);
        
        assertEquals(players, state.getPlayers());
        assertEquals(2, state.getPlayers().size());
        players.add(r2);
        state.setPlayers(players);
        assertEquals(players, state.getPlayers());
        assertEquals(3, state.getPlayers().size());
        players.add(r3);
        state.setPlayers(players);
        assertEquals(players, state.getPlayers());
        assertEquals(4, state.getPlayers().size());
        players.add(r4);
        state.setPlayers(players);
        assertEquals(players, state.getPlayers());
        assertEquals(5, state.getPlayers().size());
    }
    
    public void testSelfPlayer() 
    {
        RobotState state = new RobotState(players, r1, p1);
        //assertTrue((state.getSelf().equalsName((Player)r1)));
        state.updateTurnPlayer();
        //assertTrue((state.getSelf().equalsName((Player)r1)));
    }
    
    public void testTurnPlayer()
    {
        players.add(r2);
        players.add(r3);
        players.add(r4);
        RobotState state = new RobotState(players, r1, p1);
        
        assertTrue((state.getTurnPlayer().equalsName((Player)p1)));
        assertFalse(state.updateTurnPlayer());
        assertTrue((state.getTurnPlayer().equalsName((Player)r1)));
        assertFalse(state.updateTurnPlayer());
        assertTrue((state.getTurnPlayer().equalsName((Player)r2)));
        assertFalse(state.updateTurnPlayer());
        assertTrue((state.getTurnPlayer().equalsName((Player)r3)));
        assertFalse(state.updateTurnPlayer());
        assertTrue((state.getTurnPlayer().equalsName((Player)r4)));
        assertTrue(state.updateTurnPlayer());
        assertTrue((state.getTurnPlayer().equalsName((Player)p1)));
    }
    
    public void testGameReady()
    {
        RobotState state = new RobotState(players, r1, p1);
        assertFalse(state.isGameReady());
        state.setGameReady();
        assertTrue(state.isGameReady());
    }
    
    public void testGameOver()
    {
        RobotState state = new RobotState(players, r1, p1);
        assertFalse(state.isGameOver());
        state.setGameOver();
        assertTrue(state.isGameOver());
    }
    
    public void testGameStart()
    {
        RobotState state = new RobotState(players, r1, p1);
        assertFalse(state.isGameStart());
        state.setGameStart();
        assertTrue(state.isGameStart());
    }
    
    public void testSetWinner()
    {
        RobotState state = new RobotState(players, r1, p1);
        assertFalse(state.isGameOver());
        state.setGotWinner();
        assertTrue(state.isGameOver());
    }
    
    public void testHistoryLog()
    {
        HistoryLog log = new HistoryLog();
        RobotState state = new RobotState(players, r1, p1);
        state.setLog(log);
        assertEquals(log, state.getLog());
    }
}
