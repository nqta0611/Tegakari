package integration_test;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import tegakari.NoteEntry;

/**
 *
 * @author cathibod
 */
public class NoteEntryTest extends TestCase {
    
    public NoteEntryTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class NoteEntry.
     */
    public void testValues() {
        System.out.println("values");
        List<NoteEntry> result = Arrays.asList(NoteEntry.values());
        
        assertTrue(result.contains(NoteEntry.BLANK));
        assertTrue(result.contains(NoteEntry.HAS));
        assertTrue(result.contains(NoteEntry.HASNOT));
        assertTrue(result.contains(NoteEntry.SHOWN));
    }

    /**
     * Test of valueOf method, of class NoteEntry.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        assertEquals(NoteEntry.BLANK, NoteEntry.valueOf("BLANK"));
        assertEquals(NoteEntry.HAS, NoteEntry.valueOf("HAS"));
        assertEquals(NoteEntry.HASNOT, NoteEntry.valueOf("HASNOT"));
        assertEquals(NoteEntry.SHOWN, NoteEntry.valueOf("SHOWN"));
    }
}
