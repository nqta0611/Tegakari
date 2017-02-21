package integration_test;

import java.util.Stack;
import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for Deck.
 * @author roh
 */
public class DeckTest extends TestCase 
{
    private Deck deck;
    private Theme theme;
    
    public DeckTest(String testName) 
    {
        super(testName);
        
        deck = new Deck();
        theme = new Theme();
    }

    /**
     * Test of addCardToDeck method, of class Deck.
     */
    public void testAddCardToDeck() 
    {
        System.out.println("addCardToDeck");
        
        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        assertTrue(deck.isEmpty());
        assertEquals(0, deck.getCardCount());
        deck.addCardToDeck(card1);
        assertFalse(deck.isEmpty());
        assertEquals(1, deck.getCardCount());
        assertEquals(card1, deck.peekTopCard());
    }

    /**
     * Test of dealCard method, of class Deck.
     */
    public void testDealCard() 
    {
        System.out.println("dealCard");
        
        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        
        deck.addCardToDeck(card1);
        assertFalse(deck.isEmpty());
        assertEquals(1, deck.getCardCount());
        assertEquals(card1, deck.dealCard());
    }

    /**
     * Test of peekTopCard method, of class Deck.
     */
    public void testPeekTopCard() 
    {
        System.out.println("peekTopCard");
        
        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        deck.addCardToDeck(card1);
        assertFalse(deck.isEmpty());
        assertEquals(1, deck.getCardCount());
        assertEquals(card1, deck.peekTopCard());
    }

    /**
     * Test of getDeck method, of class Deck.
     */
    public void testGetDeck() 
    {
        System.out.println("getDeck");
        
        Stack<Card> cards = new Stack<Card>();
        
        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        
        assertEquals(cards, deck.getDeck());
        deck.addCardToDeck(card1);
        cards.add(card1);
        assertEquals(cards, deck.getDeck());
    }

    /**
     * Test of equals method, of class Deck.
     */
    public void testEquals() 
    {
        System.out.println("equals");

        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        Deck diffDeck = new Deck();
        diffDeck.addCardToDeck(card1);
        
        assertFalse(deck.equals(card1));
        assertTrue(deck.equals(deck));
        assertFalse(deck.equals(null));
        assertFalse(deck.equals(diffDeck));
    }
    
    public void testShuffle () 
    {
        System.out.println("shuffle");
        
        DestinationCard card1 = new DestinationCard(theme.getDestinations().get(0));
        Deck diffDeck = new Deck();
        diffDeck.addCardToDeck(card1);
        diffDeck.addCardToDeck(card1);
        diffDeck.shuffle();
        assertEquals(2, diffDeck.getCardCount());
    }
}
