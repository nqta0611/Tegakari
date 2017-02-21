/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import tegakari.ThemeType;

/**
 *
 * @author cathibod
 */
public class ThemeTypeTest extends TestCase {
    
    public ThemeTypeTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class ThemeType.
     */
    public void testValues() {
        System.out.println("values");
        List<ThemeType> result = Arrays.asList(ThemeType.values());
        
        assertTrue(result.contains(ThemeType.FAKE));
        assertTrue(result.contains(ThemeType.GREEK));
        assertTrue(result.contains(ThemeType.PIRATE));
        assertTrue(result.contains(ThemeType.WESTERN));
        assertTrue(result.contains(ThemeType.WHITEHOUSE));
    }

    /**
     * Test of valueOf method, of class ThemeType.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        
        assertEquals(ThemeType.FAKE, ThemeType.valueOf("FAKE"));
        assertEquals(ThemeType.GREEK, ThemeType.valueOf("GREEK"));
        assertEquals(ThemeType.PIRATE, ThemeType.valueOf("PIRATE"));
        assertEquals(ThemeType.WESTERN, ThemeType.valueOf("WESTERN"));
        assertEquals(ThemeType.WHITEHOUSE, ThemeType.valueOf("WHITEHOUSE"));
    }

    /**
     * Test of getFilePath method, of class ThemeType.
     */
    /*public void testGetFilePath() {
        System.out.println("getFilePath");
        ThemeType instance = null;
        String expResult = "";
        String result = instance.getFilePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
