
package tegakari;

import java.io.Serializable;
import java.util.*;

/**
 * Controlling the state of the robot including keep track of turn, 
 * winning status, inaction status.
 * 
 * @author Deion Law
 * @version 2.0
 *       1/12/2016 proposed skeleton.
 */
public class RobotState implements Serializable
{
    /**
     * A Queue of all players in the game in turn taking order.
     */
    private Queue<Player> players;
    
    /**
     * The Robot player.
     */
    private Player self = null;
    /**
     * The current Player that is taking a turn.
     */
    private Player turn;
    
    /**
     * Status of the game's prerequisites to start
     */
    private boolean gameReady = false;
    
    /**
     * Status of the game's start
     */
    private boolean gameStart = false;
    
    /**
     * Status of the game's completion
     */
    private boolean gameOver = false;
    
    /**
     * This game's history log of past actions
     */
    private HistoryLog log = new HistoryLog();
    
    /**
     * The notepad the associated robot using this state has
     */
    private Notepad notepad;
    
    /**
     * The state of the players in the game for the robot to use for actions.
     * @param players The Queue of players in order of turn taking
     * @param self The instance of the robot player using this state
     * @param turn The player taking the first turn
     */
    public RobotState(Queue<Player> players, Player self, Player turn) 
    {
        //SET queue of players
        this.players = players;
        
        //SET self robot player with the reference in the Q
        // don't use pass in self player
        
        //SET first player taking turn
        this.turn = turn;
        //this.notepad = notepad;
    }
    
    /**
     * Method used to advance to the next player taking a turn.
     * @return True if the new turn <code>Player</code> is not a 
     * <code>Robot</code>. return false if next turn is a <code>Robot</code>.
     */
    public boolean updateTurnPlayer() 
    {
        System.out.println("State updating turnplayer");
        System.out.println("turn in State before: " + turn.getName());
        //Debug print
        List<Player> pList = new ArrayList<Player>(players);
        
        // for all players in the list
        for (Player player : pList)
        {
            System.out.print(player.getName() + " , ");
        }
        System.out.println();
        //End debug print
        //INIT queue counter to 1 
        int counter = 1;
        //REMOVE first player from player queue
        //ADD removed player to queue
        players.add(players.remove());
        
        //WHILE player peeked from player queue is out and counter has not 
            //exceeded size of players
        while(!(players.peek().isInGame()) && counter < players.size())
        {
            System.out.println("checking: " + players.peek().getName());
            //REMOVE player from queue
            //ADD removed player to queue
            players.add(players.remove());
            //INCREMENT counter
            counter++;
        }
        //ENDWHILE
        
        //SET new turn player as the player peeked player from queue
        turn = players.peek();
        System.out.println("turn in State after: " + turn.getName());
        //RETURN if turn player is not a robot player
        return !turn.isRobot();
    }
    
    /**
     * Getter method for the current player taking a turn.
     * @return the player who has the current turn
     */
    public Player getTurnPlayer() 
    {
        turn = players.peek();
        //RETURN turn player
        return turn;
    }

    /** 
     * Retrieve the queue of player.
     * @return the queue of player (references)
     */
    public Queue<Player> getPlayers() 
    {
        return players;
    }

    /**
     * Sets the current game's players in the order of turn taking.
     * @param players a queue of players in the order of turn taking. The first
     * player being the player who has the current turn.
     */
    public void setPlayers(Queue<Player> players) 
    {
        this.players = players;
        
        List<Player> pList = new ArrayList<Player>(players);
        // for all players in the list
        for (Player aPlayer : pList)
        {
            // if self is not null and player is self then self found
            if (self != null && aPlayer.getName().equals(self.getName()))
            {
                this.self = aPlayer;
            }
        }
    }

    /**
     * Sets self for the robot.
     * @param self the self player to set for the robot.
     */
    public void setSelf(Player self) 
    {
        this.self = self;
    }

    
    /**
     * Getter for the robot using this particular instance of the state.
     * @return the robot player who is using an instance of this state
     */
    public Player getSelf() 
    {
        // if self is not null then return self
        if (self != null) 
        {
            return self;
        }
        List<Player> pList = new ArrayList<Player>(players);
        // for all players in the list
        for (Player aPlayer : pList)
        {
            // if self is not null and player equals self
            if (self != null && aPlayer.getName().equals(self.getName()))
            {
                this.self = aPlayer;
            }
        }
        return self;
    }

    /**
     * Returns if the game is ready to be played.
     * @return True if prerequisites of the game to start has been met
     */
    public boolean isGameReady() 
    {
        return gameReady;
    }

    /**
     * Returns if the game has already been started.
     * @return True if game is being played, ie players are taking turns
     */
    public boolean isGameStart() 
    {
        return gameStart;
    }

    /**
     * Returns if the game has ended.
     * @return True if the game has finished, ie solution found or all players out
     */
    public boolean isGameOver() 
    {
        return gameOver;
    }

    /**
     * Getter for the history log.
     * @return the history log of the game
     */
    public HistoryLog getLog() 
    {
        return log;
    }

    /**
     * Sets an updated history log.
     * @param log a refreshed history log that includes the latest action taken
     */
    public void setLog(HistoryLog log) 
    {
        this.log = log;
    }
        
    /**
     * Changes the status of the game to be ready
     */
    public void setGameReady()
    {
        gameReady = true;
    }
    
    /**
     * Indicates that the game has started
     */
    public void setGameStart()
    {
        gameStart = true;
    }
    
    /**
     * Indicates that the game has be completed
     */
    public void setGameOver() 
    {
        gameOver = true;
    }
    
    /**
     * Indicates that the winner has been found
     */
    public void setGotWinner() 
    { //is this needed?
        setGameOver();
    }
    
    /**
     * Getter method for this state's notepad.
     * @return the notepad of this state
     */
    public Notepad getNote()
    {
        return notepad;
    }
    
    /**
     * Setter for notepad
     * @param npad the new notepad to use
     */
    public void setNote(Notepad npad)
    {
        this.notepad = npad;
    }
}
