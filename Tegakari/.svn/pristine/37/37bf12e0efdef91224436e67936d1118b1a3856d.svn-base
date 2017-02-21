/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;
import java.util.ArrayList;
import tegakari.*;
import java.util.List;
import junit.framework.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author anhnguyen
 */
public class HistoryLogTest extends TestCase{
    
    public HistoryLogTest() {
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public void testAddToLog() {
        HistoryLog log = new HistoryLog();
        
        log.addToLog("line1");
        log.addToLog("line2");
        log.addToLog("line3");
        log.addToLog("line4");
        log.addToLog("line5");
        assertEquals("line5\nline4\nline3\nline2\nline1\n", log.toString());
        log.addToLog("line6");
        assertEquals("line6\nline5\nline4\nline3\nline2\n", log.toString());
        log.addToLog("line7");
        assertEquals("line7\nline6\nline5\nline4\nline3\n", log.toString());
        
    }
    public void testClearLog() {
        HistoryLog log = new HistoryLog();
        
        log.addToLog("line1");
        log.addToLog("line2");
        log.addToLog("line3");
        log.addToLog("line4");
        log.addToLog("line5");
        assertEquals("line5\nline4\nline3\nline2\nline1\n", log.toString());
        
        log.clearLog();
        assertEquals("", log.toString());
    }
    public void testIsEmpty() {
        HistoryLog log = new HistoryLog();
        assertTrue(log.isEmptyLog());
        
        log.addToLog("line1");
        log.addToLog("line2");
        log.addToLog("line3");
        log.addToLog("line4");
        log.addToLog("line5");
        
        assertEquals("line5\nline4\nline3\nline2\nline1\n", log.toString());
        assertFalse(log.isEmptyLog());
        
    }
}