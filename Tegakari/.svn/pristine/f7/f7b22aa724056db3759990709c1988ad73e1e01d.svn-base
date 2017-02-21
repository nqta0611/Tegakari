package integration_test;

import junit.framework.TestCase;
import tegakari.Protocol;

/**
 *
 * @author cathibod
 */
public class ProtocolTest extends TestCase {
    
    public ProtocolTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class Protocol.
     */
    /*public void testValues() {
        System.out.println("values");
        Protocol[] expResult = null;
        Protocol[] result = Protocol.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of valueOf method, of class Protocol.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        assertEquals(Protocol.GAME_READY, Protocol.valueOf("GAME_READY"));
        assertEquals(Protocol.BEGIN_TURN, Protocol.valueOf("BEGIN_TURN"));
        assertEquals(Protocol.END_TURN, Protocol.valueOf("END_TURN"));
        assertEquals(Protocol.GAME_OVER, Protocol.valueOf("GAME_OVER"));
        assertEquals(Protocol.GAME_START, Protocol.valueOf("GAME_START"));
        assertEquals(Protocol.ORDERED_ACTION_DECK, Protocol.valueOf("ORDERED_ACTION_DECK"));
        assertEquals(Protocol.ORDERED_CLUE_DECK, Protocol.valueOf("ORDERED_CLUE_DECK"));
        assertEquals(Protocol.PLAYER_DISCONNECTED_FROM_LOBBY, Protocol.valueOf("PLAYER_DISCONNECTED_FROM_LOBBY"));
        assertEquals(Protocol.PLAYER_OUT, Protocol.valueOf("PLAYER_OUT"));
        assertEquals(Protocol.SEND_PLAYERS, Protocol.valueOf("SEND_PLAYERS"));
        assertEquals(Protocol.SUGGESTION_END, Protocol.valueOf("SUGGESTION_END"));
        assertEquals(Protocol.SUGGESTION_INVALID, Protocol.valueOf("SUGGESTION_INVALID"));
        assertEquals(Protocol.SUGGESTION_START, Protocol.valueOf("SUGGESTION_START"));
        assertEquals(Protocol.SUGGESTION_VALID, Protocol.valueOf("SUGGESTION_VALID"));
        assertEquals(Protocol.TESTING_MODE, Protocol.valueOf("TESTING_MODE"));
    }
}
