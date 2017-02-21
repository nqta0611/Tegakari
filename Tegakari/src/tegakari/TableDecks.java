package tegakari;

import java.io.Serializable;

/**
 * Handles Decks in Table
 * @author roh
 */
public class TableDecks implements Serializable
{
    /**
     * <code>Deck</code> of
     * <code>ClueCard</code>s that is dealt out at start of game
     */
    private Deck<ClueCard> clueDeck;
    /**
     * <code>Deck</code> of
     * <code>ActionCard</code>s dealt throughout the game
     */
    private Deck<ActionCard> actionDeck;
    /**
     * Pile of
     * <code>ActionCard</code>s that were played
     */
    private Deck<ActionCard> discardPile;
    
    /**
     * Constructor for <code>TableDecks</code>
     */
    public TableDecks()
    {
        //INIT clueDeck
        this.clueDeck = new Deck<ClueCard>();
        //INIT actionDeck
        this.actionDeck = new Deck<ActionCard>();
        //INIT discardPile
        this.discardPile = new Deck<ActionCard>();
    }
    
    /**
     * Gets the <code>ClueCard</code> <code>Deck</code>.
     * @return clueCardDeck
     */
    public Deck<ClueCard> getClueDeck()
    {
        return this.clueDeck;
    }
    
    /**
     * Gets the <code>ActionCard</code> <code>Deck</code>.
     * @return actionDeck
     */
    public Deck<ActionCard> getActionDeck()
    {
        return this.actionDeck;
    }
    
    /**
     * Gets the discard pile <code>Deck</code>.
     * @return discard pile
     */
    public Deck<ActionCard> getDiscardPile()
    {
        return this.discardPile;
    }
    
    /**
     * Set the <code>ClueCard</code> <code>Deck</code> with given 
     * <code>ClueCard</code> <code>Deck</code>.
     * @param deck the deck to set to.
     */
    public void setClueDeck(Deck<ClueCard> deck)
    {
        this.clueDeck = deck;
    }
    
    /**
     * Set the <code>ActionCard</code> <code>Deck</code> with given 
     * <code>ActionCard</code> <code>Deck</code>.
     * @param deck the deck to set to.
     */
    public void setActionDeck(Deck<ActionCard> deck)
    {
        this.actionDeck = deck;
    }
    
    /**
     * Set the discard pile <code>Deck</code> with given 
     * <code>ActionCard</code> <code>Deck</code>.
     * @param deck the deck to set to.
     */
    public void setDiscardPile(Deck<ActionCard> deck)
    {
        this.discardPile = deck;
    }
    
    /**
     * Initialize ActionDeck.
     */
    public void initActionDeck()
    {
        this.actionDeck = new Deck<ActionCard>();
    }
    
    /**
     * Initialize ClueDeck.
     */
    public void initClueDeck()
    {
        this.clueDeck = new Deck<ClueCard>();
    }
    /**
     * Initialize Discard Pile.
     */
    public void initDisCardPile()
    {
        this.discardPile = new Deck<ActionCard>();
    }
    
    /**
     * Adds an <code>ActionCard</code> to the <code>ActionCard</code> <code>Deck</code>.
     * @param card the card to add.
     */
    public void addCardToActionDeck(ActionCard card)
    {
        this.actionDeck.addCardToDeck(card);
    }
    
    /**
     * Shuffles <code>ActionCard</code> <code>Deck</code>.
     */ 
    public void shuffleActionDeck()
    {
        this.actionDeck.shuffle();
    }
    
    /**
     * Deals an <code>ActionCard</code>.
     * @return dealt ActionCard
     */
    public ActionCard dealActionDeck()
    {
        return this.actionDeck.dealCard();
    }
    
    /**
     * Add card to the ClueCard Deck
     * @param card card to add.
     */
    public void addCardToClueDeck(ClueCard card)
    {
        this.clueDeck.addCardToDeck(card);
    }
    
    /**
     * Shuffles the ClueCard Deck
     */
    public void shuffleClueDeck()
    {
        this.clueDeck.shuffle();
    }
    
    /**
     * Deal ClueCard from the Deck.
     * @return dealt Clue Card.
     */
    public ClueCard dealClueDeck()
    {
        return this.clueDeck.dealCard();
    }
    
    /**
     * Adds an ActionCard to the DiscardPile.
     * @param card card to add.
     */
    public void addCardToDisCardPile(ActionCard card)
    {
        this.discardPile.addCardToDeck(card);
    }
    
    /**
     * Makes a SnoopCard.
     * @return SnoopCard.
     */
    public SnoopCard makeSnoop()
    {
        return new SnoopCard("/image/Action-Snoop.jpg");
    }
    
    /**
     * Makes an All SnoopCard with given direction and imagePath.
     * @param direction direction of the SnoopCard.
     * @param imgPath location of the Image.
     * @return SnoopCard.
     */
    public SnoopCard makeSnoop(Direction direction, String imgPath)
    {
        return new SnoopCard(direction, imgPath);
    }
    
    /**
     * Makes an is all PrivateTipCard with given attribute.
     * @param type the type of PrivateTipCard.
     * @param imgPath image path of the private tip card
     * @return PrivateTipCard.
     */
    public PrivateTipCard makePrivate(ClueType type, String imgPath)
    {
        return new PrivateTipCard(type, imgPath);
    }
    
    /**
     * Makes a PrivateTipCard with given ClueType and Attribute.
     * @param type the ClueType of the PrivateTipCard.
     * @param attribute Attribute of the PrivateTipCard.
     * @param imgPath image path of the PrivateTipCard.
     * @return PrivateTipCard.
     */
    public PrivateTipCard makePrivate(ClueType type, Attribute attribute, String imgPath)
    {
        return new PrivateTipCard(type, attribute, imgPath);
    }
    
    /**
     * Returns if this TableDecks is equal to the parameter TableDecks.
     *
     * @param obj object to check if equals 
     * @return if the two TableDecks objects are equal to each other or not
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean ret = true;
        TableDecks decks = (TableDecks) obj;
        
        // if decks are not equals return false
        if (!this.actionDeck.equals(decks.getActionDeck()) || 
                !this.clueDeck.equals(decks.getClueDeck()) ||
                !this.discardPile.equals(decks.getDiscardPile()))
        {
            ret = false;
        }
        
        return ret;
    }
}
