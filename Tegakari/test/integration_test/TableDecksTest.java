package integration_test;

import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for TableDecks
 * @author roh
 */
public class TableDecksTest extends TestCase 
{
    private TableDecks decks;
    private Theme theme;
    
    public TableDecksTest(String testName) 
    {
        super(testName);
        
        theme = new Theme();
        decks = new TableDecks();
    }


    /**
     * Test of setClueDeck method, of class TableDecks.
     */
    public void testSetClueDeck() {
        System.out.println("setClueDeck");
        
        Deck<ClueCard> clueDeck = new Deck<ClueCard>();

        assertTrue(decks.getClueDeck().equals(clueDeck));
        
        clueDeck.addCardToDeck(new SuspectCard(theme.getSuspects().get(0)));
        
        assertFalse(decks.getClueDeck().equals(clueDeck));
        
        decks.setClueDeck(clueDeck);
        assertTrue(decks.getClueDeck().equals(clueDeck));
    }

    /**
     * Test of setActionDeck method, of class TableDecks.
     */
    public void testSetActionDeck() {
        System.out.println("setActionDeck");
        
        Deck<ActionCard> actionDeck = new Deck<ActionCard>();
        PrivateTipCard card1 = new PrivateTipCard(ClueType.SUSPECT, null);
        SuggestionCard card2 = new SuggestionCard(true, null);
        assertTrue(decks.getActionDeck().equals(actionDeck));
        
        actionDeck.addCardToDeck(card1);
        actionDeck.addCardToDeck(card2);
        
        //Shuffle
        TableDecks tableDeck = new TableDecks();
        tableDeck.initDisCardPile();
        tableDeck.shuffleActionDeck();
        tableDeck.shuffleClueDeck();
        
        assertFalse(decks.getActionDeck().equals(actionDeck));
        
        decks.setActionDeck(actionDeck);
        assertTrue(decks.getActionDeck().equals(actionDeck));
    }

    /**
     * Test of setDiscardPile method, of class TableDecks.
     */
    public void testSetDiscardPile() {
        System.out.println("setDiscardPile");
        
        Deck<ActionCard> actionDeck = new Deck<ActionCard>();
        PrivateTipCard card1 = new PrivateTipCard(ClueType.SUSPECT, null);
        SuggestionCard card2 = new SuggestionCard(true, null);
        assertTrue(decks.getDiscardPile().equals(actionDeck));
        
        actionDeck.addCardToDeck(card1);
        actionDeck.addCardToDeck(card2);
        
        assertFalse(decks.getDiscardPile().equals(actionDeck));
        
        decks.setDiscardPile(actionDeck);
        assertTrue(decks.getDiscardPile().equals(actionDeck));
    }

}
