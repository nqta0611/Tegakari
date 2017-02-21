package tegakari;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Hold all the live states of the game
 * @author JMo
 * @author Anh Nguyen
 * 
 * @version 11/17/2015 Adding field endTurn
 * @version 11/28/2015 Finished version 1.0
 */
public class GameState extends Observable implements Serializable 
{
    // MODEL

    /**
     * The players are grouped together in a
     * <code>List</code> to represent the collection of players.
     */
    private Queue<Player> players;
    private Queue<CardMessage> messages;
    /**
     * the Player this GameState represents
     */
    private Player self;
    /**
     * the current Player
     */
    private Player turnPlayer;
    /**
     * the table containing action cards and destination marks
     */
    private final Table table;
    /**
     * an up to date history log
     */
    private HistoryLog historyLog;
    /**
     * indicates if the game is over
     */
    private boolean gameOver = false;
    
    
    private boolean hasDrawn = false;
    
    private boolean endTurn = false;
    /**
     * indicates if the self player is still playing his turn
     */
    private boolean inAction = false;
    private Solution accusation = null;
    private ActionCard chosenActionCard = null;
    
    private ClueCard randomClueCard;
    private ClueCard chosenClueCard;
    private boolean hasChosenClueCard = false;
    private Player targetPlayer;
    private List<Player> targetPlayers;
    private List<ClueCard> cardsToBeChosen;
    private AtomicBoolean flag = new AtomicBoolean(true);
    
    /**
     * Constructs an instance of this class.
     * 
     * @param players is the Queue of players in the game
     * @param self is self player
     * @param table is the table of the game
     */
    public GameState(Queue<Player> players, Player self, Table table)
    {
        this.players = players;
        // set self player
        List<Player> list = new ArrayList<Player>(players);
        // For each player
        for (Player player : list) 
        {
            //Check for name to set self player
            if (player.equalsName(self)) 
            {
                this.self = player;
            }
        }
        this.turnPlayer = this.players.peek();
        this.table = table;
        this.historyLog = new HistoryLog();
        this.messages = new ArrayDeque<CardMessage>();
        // deal out cards from table to all players 
        dealClueCardsToPlayers();
        //(Clue Cards and First Action Card) in Player Queue Order
        dealActionCardsToPlayers();
        // deal out random DM's to all players
        dealDMtoPlayers();
    }
    /**
     * Method to deal ClueCards
     */
    public void dealClueCardsToPlayers() 
    {
        List<Player> list = new ArrayList<Player>(players);
        ClueCard card = null;
        int index = 0;
        //Keep deling card til run out
        while ((card = table.dealClueCard()) != null)
        {
            Player player = list.get(index++);
            Hand hand = player.getHand();
            hand.addToHand(card);
            //Reset index 
            if (index == list.size()) 
            {
                index = 0;
            }
        }
    }
    /** 
     * Method to deal Action Card (each player has 1 action card)
     */
    public void dealActionCardsToPlayers() 
    {
        List<Player> list = new ArrayList<Player>(players);
        //For each player
        for (Player player : list) 
        {
            player.getHand().addToHand(table.dealActionCard());
        }
    }
    /**
     * Deal each player a DM
     */
    public void dealDMtoPlayers() 
    {
        List<Player> list = new ArrayList<Player>(players);
        //For each player
        for (Player player : list) 
        {
            player.setDestination(table.dealDM());
        }
    }
    /** 
     * Retrieve the queue of player
     * @return the queue of player (references)
     */
    public Queue<Player> getPlayers()
    {
        // RETURN references copy of players
        return players;
    }
    
    /**
     * Attention:
     * Don't setChaged/notifyObservers here, 
     * cause it would only update to self Player, not consistent
     * @param text is the text to set in historyLog
     */
    public void addToHistoryLog(String text) 
    {
        historyLog.addToLog(text);
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Retrieve the self Player
     * @return the self player
     */
    public Player getSelfPlayer()
    {   
        return self;
    }

    /**
     * Set new history log and notify GUI
     * 
     * @param historyLog is the new historyLog to set
     */
    public void setHistoryLog(HistoryLog historyLog) 
    {
        this.historyLog = historyLog;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Retrieve the boolean indicate if end turn yet
     * @return the  boolean indicate if end turn yet
     */
    public boolean isEndTurn() 
    {
        return endTurn;
    }

    /**
     * Setter to set endTurn field
     * @param endTurn is the boolean to set
     */
    public void setEndTurn(boolean endTurn) 
    {
        this.endTurn = endTurn;
    }

    /**
     * Set all relate state to game over
     */
    public void makeGameOver() 
    {
        this.gameOver = true;
    }
    /** set a specific player as Out
     * 
     * @param player is the outed player
     */
    public void setPlayerOut(Player player) 
    {
        turnPlayer.setPlayerLoses();
    }
    /**
     * Retrieve the state of the game
     * @return the boolean indicate if game over yet
     */
    public boolean isGameOver() 
    {
        return gameOver;
    }

    /**
     * checking if player is in playing action card
     * @return a boolean indicate if player still playing action card
     */
    public boolean isInAction() 
    {
        return inAction;
    }

    /**
     * Setter to set the field inAction
     * @param inAction is the boolean to set
     */
    public void setInAction(boolean inAction) 
    {
        this.inAction = inAction;
    }
    /**
     * Retrieve the reference of turn player
     * @return the reference of turn player
     */
    public Player getTurnPlayer()
    {
        return turnPlayer;
    }
    
    /**
     * Updates the
     * <code>Player</code> queue for the next <code>Player</code> turn and the
     * other appropriate turn <code>Player</code> query. Returns true for a
     * successful selection of a turn <code>Player</code>. Returns false if every
     * <code>Player</code> is out of the game, signaling that the game should end.
     *
     * @return true for successful player update, and false if all players are out
     */
    public boolean updateQueueForNextTurn() 
    {
        int totalPlayer = players.size();
        int counter = 0;
        boolean toReturn = false;
        
        // DEQUEUE the 1st player from the queue
        // ENQUEUE the previous turn player back to the queue
        players.add(players.remove());
                    
        //SKIP the players who was out
        while(!(players.peek().isInGame()) && (counter < totalPlayer)) 
        {
            counter += 1;
            Player previous = players.remove();
            players.add(previous);
        }
        // Check to see if there is an active player
        if (counter < totalPlayer) 
        {
            // SET turn player to the peeked player from the queue
            turnPlayer = players.peek();
            toReturn = true;
        }
        flag.set(true);
        
        this.setChanged();
        this.notifyObservers();
        
        // discard 1 action if other player's turn
        if (!(self.equals(turnPlayer))) 
        {
            //IF run out of card
            if (table.getActionDeck().isEmpty())
            {
                table.buildActionDeck();
                table.getActionDeck().shuffle();
            }
            table.dealActionCard();
        }
        
        return toReturn;
    }
    /**
     * Notify Observers that someState has change
     */
    public void setChangedGameState()
    {
        this.setChanged();
        this.notifyObservers();
    }
    /**
     * Retrieve the table
     * @return the table
     */
    public Table getTable()
    {
        return table;
    }
    /**
     * Retrieve the history Log
     * @return the history log
     */
    public HistoryLog getHistoryLog()
    {
        return historyLog;
    }
    /**
     * Checking method to see if player drawn an action card yet
     * @return boolean indicate if player drawn yet
     */
    public boolean hasDrawn()
    {
        return hasDrawn;
    }
    /**
     * Setter method to set the filed hasDrawn
     * @param hasDrawn is the boolean use to set has drawn
     */
    public void setHasDrawn(boolean hasDrawn)
    {
        this.hasDrawn = hasDrawn;
        // SET change - notify observers
    }
    
    /**
     * Draws a card from the <code>ActionCard Deck</code> and gives the card
     * to the <code>Hand</code> of the self <code>Player</code>. Will notify
     * the other <code>Observer</code>s observing this class.
     * 
     */
    public void drawActionCard()
    {
        // CALL draw from action deck from table
        // GIVE to first player in queue (turnPlayer)
        
        // too complicate to add that card back to the discardPile 
        // since other dosn't know which card this player played,
        // RECOMMENT: Re-build actionDeck when empty.
        
        // rebuild if needed
        if (table.getActionDeck().isEmpty())
        {
            // this builds a standard action deck only
            table.buildActionDeck();
            table.getActionDeck().shuffle();
            // System.out.println("Action Deck Empty: Reshuffled");
            // the method below doesn't work
            //table.rebuildActionDeckFromDiscardPile();
        }
        turnPlayer.getHand().addToHand(table.dealActionCard());
        this.hasDrawn = true;
        
        this.setChanged();
        this.notifyObservers();
    }
    /**
     * Draw an action card
     */
    public void drawAnActionCard()
    {
        table.addtoDiscardPile(table.dealActionCard());
    }
    /**
     * Retrieve the action card which player just choose to play
     * @return the action card player picked
     */
    public ActionCard getChosenActionCard()
    {
        return chosenActionCard;
    }
    /**
     * Set the chosen action card so that Game Engine will use to compute the action
     * @param card is the chosen card by player
     */
    public void setChosenActionCard(ActionCard card)
    {
        this.chosenActionCard = card;
        // add the choosen card to the discard pile
        table.addtoDiscardPile(card);
        // update player hand's action cards
        List<ActionCard> listAction = players.peek().getHand().getActionCards();
        Card firstCard = listAction.get(0);
        // Check to see which card player pick
        if (card.getActionText().equals(((ActionCard)firstCard).getActionText())) 
        {
            listAction.remove(0);
        }
        else 
        {
            listAction.remove(1);
        } // TODO implement equals method in ActionCard.
    }
    /**
     * Reset the state after a turn is done
     */
    public void reset()
    {
        hasDrawn = false;
        endTurn = false;
        inAction = false;
        accusation = null;
        chosenActionCard = null;
    }
    /**
     * Retrieve the target player when playing snoop or private tip card
     * @return the target player chosen by user
     */
    public Player getTargetPlayer()
    {
        return targetPlayer;
    }
    /**
     * Setter to set the target payer
     * @param targetPlayer is the target player chosen by user
     */
    public void setTargetPlayer(Player targetPlayer)
    {
        this.targetPlayer = targetPlayer;
    }
    /**
     * Retrieve the random clue card
     * @return the random clue card
     */
    public ClueCard getRandomClueCard()
    {
        return randomClueCard;
    }
    /**
     * Set the random clue card, use for snoop
     * @param card is the clue card to be set as random clue card
     */
    public void setRandomClueCard(ClueCard card)
    {
        this.randomClueCard = card;
    }
    /**
     * Set the list of card to choose, use for 
     * responding to suggestion, private tip, and sleuth
     * @param cards is the list of clue card to choose
     */
    public void setCardsToBeChosen(List<ClueCard> cards)
    {
        this.cardsToBeChosen = cards;
        // SET changed
        // notify observers
    }
    /**
     * add a card message to this list of card message
     * @param message is the card message to be added to the list
     */
    public void addCardMessage(CardMessage message)
    {
        messages.add(message);
        // SET changed
        // NOTIFY observers
    }

    /**
     * Retrieve the accusation
     * @return accusation made by user
     */
    public Solution getAccusation() 
    {
        return accusation;
    }

    /**
     * Set the accusation
     * @param accusation is the accusation to be set
     */
    public void setAccusation(Solution accusation) 
    {
        this.accusation = accusation;
    }
    /**
     * Removing the front card message
     * @return the card message which was just removed from the list
     */
    public CardMessage removeCardMessage()
    {
        try 
        {
            return messages.remove();
        } 
        catch(NoSuchElementException exception)
        {
            return null;
        }
    }
    
    /**
     * Setting the thread safe boolean to the boolean in the parameter
     * @param setBoolean the boolean to set the lock to.
     */
    public void setAtomic(boolean setBoolean)
    {
        flag.set(setBoolean);
    }
    
    /**
     * Getting the boolean of the thread safe boolean indicating ENDTURN was set
     * @return the boolean true or false of this flag
     */
    public boolean getAtomic()
    {
        return flag.get();
    }
}
