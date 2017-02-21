package unit_test;

import junit.framework.TestCase;
import tegakari.SuggestionCard;

/**
 *
 * @author roh
 */
public class SuggestionCardTest extends TestCase 
{
    private SuggestionCard fromCurrent;
    private SuggestionCard anyDestination;
    
    public SuggestionCardTest(String testName) 
    {
        super(testName);
        
        fromCurrent = new SuggestionCard(true, 
                "/image/Action-SuggestionCurrent.jpg");
        anyDestination = new SuggestionCard(false, 
                "/image/Action-SuggestionAny.jpg");
    }

    /**
     * Test of getActionText method, of class SuggestionCard.
     */
    public void testGetActionText() 
    {
        System.out.println("getActionText");
        
        String kAnyDMText = "Make a Suggestion from ANY Destination";
        String kCurrentDMText = "Make a Suggestion from Current Destination "
            + "or Move to Another Destination";
        
        assertEquals(kCurrentDMText, fromCurrent.getActionText());
        assertEquals(kAnyDMText, anyDestination.getActionText());
    }

    /**
     * Test of isCurrentSuggestion method, of class SuggestionCard.
     */
    public void testIsCurrentSuggestion() 
    {
        System.out.println("isCurrentSuggestion");
        
        assertTrue(fromCurrent.isCurrentSuggestion());
        assertFalse(anyDestination.isCurrentSuggestion());
    }

    /**
     * Test of getName method, of class SuggestionCard.
     */
    public void testGetName() 
    {
        System.out.println("getName");
        
        String name = "Suggestion Card";
        
        assertEquals(name, fromCurrent.getName());
        assertEquals(name, anyDestination.getName());
    }

    /**
     * Test of isShowing method, of class SuggestionCard.
     */
    public void testIsShowing() 
    {
        System.out.println("isShowing");
        
        assertFalse(fromCurrent.isShowing());
        assertFalse(anyDestination.isShowing());
    }

    /**
     * Test of makeFaceUp method, of class SuggestionCard.
     */
    public void testMakeFaceUp() 
    {
        System.out.println("makeFaceUp");
        
        assertFalse(fromCurrent.isShowing());
        assertFalse(anyDestination.isShowing());
        
        fromCurrent.makeFaceUp();
        anyDestination.makeFaceUp();
        
        assertTrue(fromCurrent.isShowing());
        assertTrue(anyDestination.isShowing());
    }

    /**
     * Test of makeFaceDown method, of class SuggestionCard.
     */
    public void testMakeFaceDown() 
    {
        System.out.println("makeFaceDown");
        
        assertFalse(fromCurrent.isShowing());
        assertFalse(anyDestination.isShowing());
        
        fromCurrent.makeFaceUp();
        anyDestination.makeFaceUp();
        
        assertTrue(fromCurrent.isShowing());
        assertTrue(anyDestination.isShowing());
        
        fromCurrent.makeFaceDown();
        anyDestination.makeFaceDown();
        
        assertFalse(fromCurrent.isShowing());
        assertFalse(anyDestination.isShowing());
    }

    /**
     * Test of getImagePath method, of class SuggestionCard.
     */
    public void testGetImagePath() {
        System.out.println("getImagePath");
        
        String currentPath = "/image/Action-SuggestionCurrent.jpg";
        String anyPath = "/image/Action-SuggestionAny.jpg";
        
        assertEquals(currentPath, fromCurrent.getImagePath());
        assertEquals(anyPath, anyDestination.getImagePath());
    }
}
