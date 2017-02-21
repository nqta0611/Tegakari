package integration_test;

import java.util.List;
import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for Hand
 * @author roh
 */
public class HandTest extends TestCase 
{
    private Hand hand;
    private Theme theme;
    
    public HandTest(String testName) 
    {
        super(testName);
        
        theme = new Theme();
        hand = new Hand();
    }

    /**
     * Test of addToHand method, of class Hand.
     */
    public void testAddToHand() 
    {
        System.out.println("addToHand");
        
        
    }

    /**
     * Test of getClueCards method, of class Hand.
     */
    public void testGetClueCards() 
    {
        System.out.println("getClueCards");
        
    }

    /**
     * Test of getActionCards method, of class Hand.
     */
    public void testGetActionCards() 
    {
        System.out.println("getActionCards");
        
    }

    /**
     * Test of getActionCardTotal method, of class Hand.
     */
    public void testGetActionCardTotal() 
    {
        System.out.println("getActionCardTotal");
        
    }

    /**
     * Test of getClueCardTotal method, of class Hand.
     */
    public void testGetClueCardTotal() 
    {
        System.out.println("getClueCardTotal");
        
    }

    /**
     * Test of remove method, of class Hand.
     */
    public void testRemove() 
    {
        System.out.println("remove");
        
        PrivateTipCard card1 = new PrivateTipCard(ClueType.SUSPECT, null);
        SuggestionCard card2 = new SuggestionCard(true, null);
        SuspectCard card3 = new SuspectCard(theme.getSuspects().get(0));
        
        hand.addToHand(card1);
        hand.addToHand(card3);
        
        assertEquals(1, hand.getActionCardTotal());
        assertEquals(1, hand.getClueCardTotal());
        
        assertFalse(hand.remove(card2));
        assertEquals(1, hand.getActionCardTotal());
        assertEquals(1, hand.getClueCardTotal());
        assertTrue(hand.remove(card1));
        assertEquals(0, hand.getActionCardTotal());
        assertEquals(1, hand.getClueCardTotal());
        assertTrue(hand.remove(card3));
        assertEquals(0, hand.getActionCardTotal());
        assertEquals(0, hand.getClueCardTotal());
    }

    /**
     * Test of equals method, of class Hand.
     */
    public void testEquals() 
    {
        System.out.println("equals");
        
        PrivateTipCard card1 = new PrivateTipCard(ClueType.SUSPECT, null);
        SuspectCard card3 = new SuspectCard(theme.getSuspects().get(0));
        Hand diffHand = new Hand();
        Hand diffHand2 = new Hand();
        diffHand2.addToHand(card3);
        diffHand.addToHand(card1);
        
        assertFalse(hand.equals(null));
        assertFalse(hand.equals(card1));
        assertFalse(hand.equals(diffHand));
        assertFalse(hand.equals(diffHand2));
        assertTrue(hand.equals(hand));
    }
}
