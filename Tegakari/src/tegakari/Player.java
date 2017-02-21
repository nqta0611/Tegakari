package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Player is at a <code>Destination</code> and is the one playing the game and has a
 * name, <code>Hand</code>, and a <code>Notepad</code>. The class 
 * responds to action cards and also plays
 * action cards.
 *
 * @author Lohit
 */
public abstract class Player implements Serializable 
{

    /**
     * The name of the player.
     */
    private final String name;
    /**
     * The <code>Hand</code> that player has.
     */
    private Hand hand;
    /**
     * The <code>Destination</code> the player is at.
     */
    private Destination dm;
    /**
     * The <code>Notepad</code> of the player.
     */
    //private Notepad notepad;
    /**
     * Whether or not player is in game.
     */
    private boolean isInGame;
    /**
     * Whether or not the player has lost the game.
     */
    private boolean hasLost;
    /**
     * Whether or not this player is a robot. Workaround for getClass when mocking
     */
    private boolean isRobot = false;
    
    /**
     * Constructs a player with given name, <code>Hand</code>,
     * and <code>Destination</code>.
     *
     * @param name The name of the player
     * @param hand The <code>Hand</code> that player has
     * @param dm the <code>Destination</code> of player
     */
    public Player(String name, Hand hand, Destination dm) 
    {
        //SET name of player
        this.name = name;
        //SET hand of player
        this.hand = hand;
        //SET dm of player
        this.dm = dm;
        //SET isInGame true
        this.isInGame = true;
        //SET hasLost false
        this.hasLost = false;
        //INIT notepad
        //notepad = new Notepad();
    }
    
    /**
     * Constructs a player with the given name, an empty hand, and a null
     * destination.
     * @param name the name of the player to create
     */
    public Player(String name) 
    {
        // SET name of player
        this.name = name;
        // CREATE hand for player
        this.hand = new Hand();
        // SET dm of player to null;
        this.dm = null;
        // SET isInGame true
        this.isInGame = true;
        // SET hasLost false
        this.hasLost = false;
        // INIT notepad
        //notepad = new Notepad();
    }
    
    /**
     * Returns the name of the player.
     * 
     * @return player name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Check if your <code>Hand</code> has cards that meet condition.
     *
     * @param condition The cards being looked for
     * @return empty list if no cards, or all cards that are valid
     */
    public List<Card> getValidCardsSuggestion(Solution condition) 
    {
        //INIT new list to return
        List<Card> out = new ArrayList<Card>();
        //GET cluecard list from hand
        List<ClueCard> clueCards = hand.getClueCards();
        //GET suspect from condition
        Suspect suspect = condition.getSuspect();
        // CREATE a suspectCard
        SuspectCard sc = new SuspectCard(suspect);
        //IF contains on hand cluecardlist
        if (clueCards.contains(sc)) 
        {
            //ADD card to list to return
            out.add(sc);
        //ENDIF
        }
        //GET vehicle from condition
        Vehicle vehicle = condition.getVehicle();
        // CREATE a vehicleCard
        VehicleCard vc = new VehicleCard(vehicle);
        //IF contains on hand cluecardlist
        if (clueCards.contains(vc)) 
        {
            //ADD card to list to return
            out.add(vc);
        //ENDIF
        }
        //GET destination from condition
        Destination destination = condition.getDestination();
        // CREATE a destinationCard
        DestinationCard dc = new DestinationCard(destination);
        //IF contains on hand cluecardlist
        if (clueCards.contains(dc)) 
        {
            //ADD card to list to return
            out.add(dc);
        //ENDIF
        }
        //RETURN list
        return out;
    }

    /**
     * Check if your <code>Hand</code> has cards that meet Private Tip.
     *
     * @param card The card type being looked for
     * @return empty list if no cards, or all cards that are valid
     */
    public List<Card> getValidCardsPrivateTip(PrivateTipCard card) 
    {
        //INIT a return list
        List<Card> out = new ArrayList<Card>();
        //GET the Hand of received player
        //GET the list of clue cards from Hand
        List<ClueCard> clueCards = hand.getClueCards();
        //IF this card isAll card
        if (card.isAll()) 
        {
            //FOR each clue card
            for (int iLoop = 0; iLoop < clueCards.size(); iLoop++) 
            {
                //IF this clue card match cluetype with the private tip card
                if (clueCards.get(iLoop).getClueType() == card.getClueType()) 
                {
                    //ADD clue card to the return list
                    out.add((Card) clueCards.get(iLoop));
                //ENDIF
                }
            //ENDFOR
            }
        }
        //ELSE this card is not All card
        else 
        {
            //FOR each clue card
            for (int iLoop = 0; iLoop < clueCards.size(); iLoop++) 
            {
                //IF this clue card match cluetype and attribute 
                //with the private tip card
                if (clueCards.get(iLoop).getClueType() == card.getClueType()
                        && clueCards.get(iLoop).getAttribute()
                        .contains(card.getAttribute())) 
                {
                    //ADD clue card to the return list
                    out.add((Card) clueCards.get(iLoop));
                //ENDIF
                }
            //ENDFOR
            }
        //ENDIF
        }
        //RETURN the return list
        return out;
    }

    /**
     * Retrieves a random <code>ClueCard</code> from <code>Hand</code>.
     *
     * @return The random <code>ClueCard</code> retrieved
     */
    public Card giveRandomCardFromHand() 
    {
        //INIT random integer less than size of hand
        Random rn = new Random();
        int num = hand.getClueCardTotal() - 0 + 1;
        int iNT = rn.nextInt() % num;
        //GET list of cluecards from hand
        List<ClueCard> clueCards = hand.getClueCards();
        //GET random card using random integer for index
        Card out = clueCards.get(iNT);
        //RETURN Card
        return out;
    }

    /**
     * Counts the number of cards in your <code>Hand</code>.
     *
     * @return the number of cards
     */
    public int getHandSize() 
    {
        //RETURN hand's actionCardTotal and clueCardTotal
        return hand.getActionCardTotal() + hand.getClueCardTotal();
    }

    /**
     * Gets the list of clue cards player has.
     *
     * @return the list of clue cards
     */
    public List<ClueCard> getClueCards() 
    {
        //RETURN cluecard list from hand
        return hand.getClueCards();
    }

    /**
     * Gets the list of <code>ActionCard</code>s player has.
     *
     * @return the list of <code>ActionCard</code>s
     */
    public List<ActionCard> getActionCards() 
    {
        //RETURN action card list from hand
        return hand.getActionCards();
    }

    /**
     * Determines if player is in game.
     *
     * @return true if player is in game, false otherwise
     */
    public boolean isInGame() 
    {
        //RETURN isInGame
        return isInGame;
    }

    /**
     * Sets the player to have lost the game.
     */
    public void setPlayerLoses() 
    {
        //SET hasLost true
        isInGame = false;
        hasLost = true;
    }
    
    /**
     * Returns the <code>Hand</code> of the player
     * @return the <code>Hand</code> of the player
     */
    public Hand getHand() 
    {
        //RETURN hand
        return hand;
    }
            
    /**
     * Sets the <code>Destination</code> marker and returns previous marker
     * @param destination the destination
     * @return the previous <code>Destination</code> marker
     */
    public Destination setDestination(Destination destination) 
    {
        //SET destinationmarker to destination
        Destination out = dm;
        dm = destination;
        //RETURN old destination marker
        return out;
    }
    
    /**
     * Retrieves the <code>Destination</code> the player is currently at.
     * The returned instance is a deep copy.
     *
     * @return the <code>Destination</code> the player is currently at
     */
    public Destination getDestination() 
    {
        return dm;
    }
    
    /**
     * Compares this player to the one given and sees if
     * they are equal.
     * @param p the player to compare to
     * @return if they were equal or not
     */
    public boolean equals(Object p) 
    {
        boolean out = false;
        // checks if null and instance of
        if (p != null && p instanceof Player) 
        {
            // cast as a player
            Player player = (Player) p;
            // check if the names of the players are equal
            if (this.name.equals(player.name)) 
            {
                // check if the destinations of the players are equal
                if (this.dm != null && this.dm.equals(player.getDestination())) 
                {
                    // check if the hands of the players are equal
                    if (this.hand != null && this.hand.equals(player.getHand())) 
                    {
                        // if it got in here the players are equal
                        out = true;
                    }
                }
            }
        }
        return out;
    }

    /**
     * compares two list of cards
     * @param list1 the first list to compare
     * @param list2 the second list to compare
     * @return the result of the comparison
     */
    public static boolean cardListsEqual(List<Card> list1, List<Card> list2) 
    {
        boolean out = false;
  
        // check if they are null
        if (list1 != null && list2 != null) 
        {
            // compare list size
            //System.out.println("not null");
            if (list1.size() == list2.size()) 
            {
                //System.out.println("equal size");
                int numCardsEqual = 0;
                // compare elements in the lists
                for (int iLoop = 0; iLoop < list1.size(); iLoop++) 
                {
                    // check if the element in list1 is in list2
                    for (int jLoop = 0; jLoop < list2.size(); jLoop++) 
                    {
                        // compare
                        if (list1.get(iLoop).equals(list2.get(jLoop))) 
                        {
                            numCardsEqual++;
                        }
                    }
                }
                // check if all elements were equal
                if (numCardsEqual == list1.size()) 
                {
                    //System.out.println("are equal");
                    out = true;
                }
            }
        }
        return out;
    }

    /**
     * Only compares the names of the players, this is for
     * the 2nd constructor which creates a player with only a name.
     * @param p - the player to compare to
     * @return if they were equal or not
     */
    public boolean equalsName(Player p) 
    {
        boolean out = false;
        // make sure it is a player and has stuff in it
        if (p != null && p instanceof Player) 
        {
            // compare names
            if (this.name.equals(p.name)) 
            {
                // the players are equal
                out = true;
            }
        }
        return out;
    }
    
    /**
     * Getter if a player is a robot.
     * @return True if player is a robot
     */
    public boolean isRobot()
    {
        return isRobot;
    }
    
    /**
     * Sets the player as a robot.
     */
    public void setRobot()
    {
        isRobot = true;
    }
}
