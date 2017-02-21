/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.util.*;
import java.awt.event.ActionEvent;
import tegakari.*;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The console for game table
 * @author jchoi30
 */
public class GameTableConsole implements I_GameTable, Observer
{
    private GameTableController ctrl;
    private GameEngine engine;
    private GameState state;
    private Player selfPlayer;
    private Queue<Player> players;
    private Scanner in;
    private AtomicBoolean lock;
    private Player[] seats;
    private int playerSize;
    
    private boolean accuse = false;
    /**
     * The constructor
     * @param ctrl the controller
     * @param engine the engine
     * @param in the scanner to use
     * @param lock The lock to use to see if a thread is running gamePhase
     */
    public GameTableConsole(GameTableController ctrl, GameEngine engine, 
            Scanner in, AtomicBoolean lock)
    {
        this.ctrl = ctrl;
        this.engine = engine;
        this.state = engine.getGameState();
        this.playerSize = state.getPlayers().size();
        this.selfPlayer = state.getSelfPlayer();
        this.players = state.getPlayers();
        this.state.addObserver(this);
        this.lock = lock;
        seats = new Player[playerSize];
        int counter = 0;
        this.in = in;
        // while not self player
        while (!players.peek().equalsName(selfPlayer))
        {
            players.add(players.remove());
            counter++;
        }
        Queue<Player> temp = new LinkedList<Player>();
        temp.add(players.remove());
        seats[0] = selfPlayer;
        Player currSeatPlayer;
        // until players is empty
        for (int currSeat = 1; !players.isEmpty(); currSeat++)
        {
            currSeatPlayer = players.remove();
            temp.add(currSeatPlayer);
            seats[currSeat] = currSeatPlayer;
        }
        // for all temp players
        for (Player pPlayer : temp)
        {
            players.add(pPlayer);
        }
        // for until playerSize - counter
        for (int iConstant = 0; iConstant < playerSize - counter; iConstant++)
        {
            players.add(players.remove());
        }
    }
    /**
     * starts the game phase
     */
    public void startGamePhase()
    {
        String input = "";
        Hand cards = null;
        List<ClueCard> clues = null;
        List<ActionCard> actions = null;
        
        
        // while not game over
        if (!state.isGameOver() && !accuse)
        {
            // if turn player = self player
            if (state.getTurnPlayer().equalsName(selfPlayer))
            {
                ActionEvent evt = new ActionEvent(this, 0, "DealerActionPile");
                ctrl.actionPerformed(evt);

                System.out.println("Card Drawn");

                System.out.println("The players still in the game are:");
                // for all players
                for (Player pPlayer : seats)
                {
                    // if in game
                    if (pPlayer.isInGame())
                    {
                        System.out.println(pPlayer.getName());
                    }
                }

                turn();
                askEndGame();
            }
        }
        else
        {
            System.out.println("Game Ended!");
        }
        
    }
    /**
     * enables draw
     * @param visable what to set it to 
     */
    public void drawEnable(boolean visable)
    {
        
    }
    /**
     * enables action
     * @param visable what to set it to 
     */
    public void action1Enable(boolean visable)
    {
    }
    /**
     * enables action2
     * @param visable what to set it to
     */
    public void action2Enable(boolean visable)
    {
    }
    /**
     * enables accuse
     * @param visable what to set it to 
     */
    public void accuseEnable(boolean visable)
    {
    }
    /**
     * enables endTurn
     * @param visable what to set it to
     */
    public void endTurnEnable(boolean visable)
    {
    }
    
    /**
     * update
     * @param obs the observable
     * @param obj the object to use
     */
    @Override
    public void update(Observable obs, Object obj)
    {
        //Check if this thread is allowed to start a turn phase
        if (!lock.get() && state.getAtomic())
        { 
            //loop through each seat
            for (int currSeat = 0; currSeat < playerSize; currSeat++)
            {
                Player turnPlayer = state.getTurnPlayer();
                //Check if it is the player's turn
                if (seats[currSeat].equalsName(turnPlayer))
                {
                    // if current player
                    if (currSeat == 0 && !(state.hasDrawn()) && 
                            lock.compareAndSet(false, true)
                            && turnPlayer.isInGame())
                    {
                        currSeat = playerSize;
                        startGamePhase();
                        lock.set(false);
                    }
                }
            }
        }
    }
    
    /**
     * Asks to end the game after every turn is over
     */
    private void askEndGame()
    {   
        System.out.println("Would you like to quit the application? enter "
                + "yes [y] or no [n]");
        
        // Check if application should exit or not.
        if (in.nextLine().equals("y"))
        {
            System.exit(0);
        }
    }
    
    /**
     * enables NotePad
     * @param visable what to set it to
     */
    @Override
    public void notepadEnable(boolean visable) 
    {
        
    }
    
    /**
     * enables rules
     */
    public void rulesEnable()
    {
        
    }
    /**
     * starts the turn
     */
    public void turn()
    {
        ActionEvent evt;
        String input = "";
        
        helperTurn();

        input = in.nextLine();

        boolean goodInput = false;
        // while input is good
        while (!goodInput)
        {
            // if 1
            if (input.equals("1"))
            {
                helperAction("action1");
                goodInput = true;
            }
            // if 2
            else if (input.equals("2"))
            {
                helperAction("action2");
                goodInput = true;
            }
            // if a
            else if (input.equals("a"))
            {
                helperAction("accuse");
                goodInput = true;
                accuse = true;
            }
            else
            {
                System.out.println("invalid input try again");
                input = in.nextLine();
            }
        }
        // if not accuse
        if (!accuse)
        {
            System.out.println("Would you like to accuse? y/n");
            input = in.nextLine();
            // if yes
            if (input.equals("y"))
            {
                helperAction("accuse");
                accuse = true;
            }
        }
        // if not accuse
        if (!accuse)
        {
            System.out.println("Ending turn");
            helperAction("EndTurn");
            state.setAtomic(false);
        }
    }
    
    /**
     * helper for the turn method to reduce line count
     */
    private void helperTurn()
    {
        Hand cards = null;
        List<ClueCard> clues = null;
        List<ActionCard> actions = null;
            
            
        cards = selfPlayer.getHand();
        clues = cards.getClueCards();

        System.out.println("\nYour Clue Cards are: ");
        // for all clue cards
        for (ClueCard clue : clues)
        {
            System.out.println("> " + clue.getName());
        }

        actions = cards.getActionCards();
        int count = 0;
        System.out.println("Your Action Cards are: ");
        // for all action
        for (ActionCard action : actions)
        {
            System.out.println("> ["+ ++count + "] " + action.getName() + ": "
                    + action.getActionText());
        }
        
        System.out.println("What do you want to do? ");
        System.out.println("> Play action 1 [enter 1]");
        System.out.println("> Play action 2 [enter 2]");
        System.out.println("> Accuse [enter 'a']");
    }
    
    private void helperAction(String output)
    {
        ActionEvent evt = new ActionEvent(this, 0, output);
        ctrl.actionPerformed(evt);
    }
}
