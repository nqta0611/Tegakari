package unit_test;

import java.util.*;
import junit.framework.TestCase;
import tegakari.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author DeionLaw
 */
public class RobotStateTest extends TestCase
{
    Queue<Player> players = new LinkedList<Player>();
    
    HumanPlayer p1 = mock(HumanPlayer.class);
    Robot r1 = mock(Robot.class);
    Robot r2 = mock(Robot.class);
    Robot r3 = mock(Robot.class);
    Robot r4 = mock(Robot.class);
    
    public RobotStateTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        players.add(p1);
        players.add(r1);
        when(p1.isRobot()).thenReturn(false);
        when(r1.isRobot()).thenReturn(true);
        when(r2.isRobot()).thenReturn(true);
        when(r3.isRobot()).thenReturn(true);
        when(r4.isRobot()).thenReturn(true);
    }
    
    @Override
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
        assertNull(state.getSelf());
        state.updateTurnPlayer();
        assertNull( state.getSelf());
    }
    
    public void testTurnPlayer()
    {
        players.add(r2);
        players.add(r3);
        players.add(r4);
        RobotState state = new RobotState(players, r1, p1);
        when(p1.isInGame()).thenReturn(true);
        when(r1.isInGame()).thenReturn(true);
        when(r2.isInGame()).thenReturn(true);
        when(r3.isInGame()).thenReturn(true);
        when(r4.isInGame()).thenReturn(true);
        
        assertEquals(p1, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r1, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r2, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r3, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r4, state.getTurnPlayer());
        assertTrue(state.updateTurnPlayer());
        assertEquals(p1, state.getTurnPlayer());
    }
    
    public void testTurnsWithPlayersOut()
    {
        players.add(r2);
        players.add(r3);
        players.add(r4);
        RobotState state = new RobotState(players, r1, p1);
        when(p1.isInGame()).thenReturn(true);
        when(r1.isInGame()).thenReturn(false);
        when(r2.isInGame()).thenReturn(true);
        when(r3.isInGame()).thenReturn(true);
        when(r4.isInGame()).thenReturn(true);
        
        assertEquals(p1, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r2, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r3, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r4, state.getTurnPlayer());
        assertTrue(state.updateTurnPlayer());
        assertEquals(p1, state.getTurnPlayer());
        
        
        when(r2.isInGame()).thenReturn(false);
        
        assertEquals(p1, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r3, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r4, state.getTurnPlayer());
        assertTrue(state.updateTurnPlayer());
        assertEquals(p1, state.getTurnPlayer());
        
        when(r3.isInGame()).thenReturn(false);
        
        assertEquals(p1, state.getTurnPlayer());
        assertFalse(state.updateTurnPlayer());
        assertEquals(r4, state.getTurnPlayer());
        assertTrue(state.updateTurnPlayer());
        assertEquals(p1, state.getTurnPlayer());
        
        when(r4.isInGame()).thenReturn(false);
        
        assertEquals(p1, state.getTurnPlayer());
        assertTrue(state.updateTurnPlayer());
        assertEquals(p1, state.getTurnPlayer());
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
        HistoryLog log = mock(HistoryLog.class);
        RobotState state = new RobotState(players, r1, p1);
        state.setLog(log);
        assertEquals(log, state.getLog());
    }
}
