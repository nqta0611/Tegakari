package integration_test;

import java.util.List;
import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for DMPile.
 * @author roh
 */
public class ActionCardTest extends TestCase 
{
    SnoopCard snoop;
    PrivateTipCard tip;
    SuggestionCard suggest;
    SuperSleuthCard sleuth;
    
    public ActionCardTest(String testName) 
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        snoop = new SnoopCard("snoop");
        sleuth = new SuperSleuthCard(ClueType.DESTINATION, 
                Attribute.NORTHERN, "hi");
        tip = new PrivateTipCard(ClueType.SUSPECT, "tip");
        suggest = new SuggestionCard(true, "suggest");
        
    }
    
    public void testSetterGetter()
    {
        System.out.println("test Snoop Card");
        snoop.makeFaceUp();
        assertTrue(snoop.isShowing());
        snoop.makeFaceDown();
        assertFalse(snoop.isShowing());
        assertEquals("Snoop Card", snoop.getName());
        
        System.out.println("test PrivateTip Card");
        tip.makeFaceUp();
        assertTrue(tip.isShowing());
        tip.makeFaceDown();
        assertFalse(tip.isShowing());
        assertEquals("Private Tip Card", tip.getName());
        
        System.out.println("test Sleuth Card");
        sleuth.makeFaceUp();
        assertTrue(sleuth.isShowing());
        sleuth.makeFaceDown();
        assertFalse(sleuth.isShowing());
        assertEquals("Super Sleuth Card", sleuth.getName());
        
        System.out.println("test Suggestion Card");
        suggest.makeFaceUp();
        assertTrue(suggest.isShowing());
        suggest.makeFaceDown();
        assertFalse(suggest.isShowing());
        assertEquals("Suggestion Card", suggest.getName());
    }
}