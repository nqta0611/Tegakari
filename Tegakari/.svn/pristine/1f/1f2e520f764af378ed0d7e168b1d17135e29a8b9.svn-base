package tegakari;

import com.lloseng.ocsf.client.AbstractClient;
import java.io.IOException;
import java.io.Serializable;
import java.util.Queue;
import java.util.List;
/**
 * The GameClient represents a
 * <code>Player</code> and his or her means to communicate to other
 * <code>Players</code>. This class facilitates the state of the game and
 * connects to
 * <code>GameServer</code>.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 *
 * @version 12/5/2015 Version 1.0
 */
public class GameClient extends AbstractClient implements Serializable
{
    /**
     * The player represented by this client.
     */ 
    private Player self;
    /**
     * The current turn player.
     */ 
    private Player turnPlayer;
    /**
     * Indicates if this was the first connected client to the server.
     */ 
    private boolean isFirstPlayer;
    /**
     * Indicates if the game is ready.
     */ 
    private boolean gameReady;
    /**
     * Indicates if the game has started.
     */ 
    private boolean startedGame;
    /**
     * Indicates if the game is over.
     */ 
    private boolean gameOver;
    /**
     * Indicates if the client needs to disconnect a player given by the server.
     */
    private boolean disconnectingPlayer;
    /**
     * The type of theme for the current game.
     */ 
    private ThemeType themeType;
    /**
     * The object containing all suspects, vehicles, and destinations.
     */ 
    private Theme theme;
    /**
     * The object conducting the player turn and actions.
     */ 
    private GameEngine engine;
    /**
     * The <code>Lobby</code> the self <code>Player</code> is in.
     */
    private Lobby lobby;
    
    /**
     * The solution to the current game.
     */
    private Solution solution;

    /**
     * Class constructor that specifies which
     * <code>Player</code> this GameClient represents. This client does not
     * connect to
     * <code>GameServer</code> until joinLobby() is called.
     *
     * @param host the server's host name
     * @param port the port the server is located on
     */
    public GameClient(String host, int port)
    {
        super(host, port);
        this.self = null;
    }
    
    /**
     * Sets this client's
     * <code>Lobby</code> to the passed parameter.
     * 
     * @param lobby the
     * <code>Lobby</code> the self
     * <code>Player</code> is in
     */
    public void setLobby(Lobby lobby)
    {
        this.lobby = lobby;
    }
    
    /**
     * Sets the client's GameEngine reference to the parameter. Once this has
     * been set, calling this method again would not make a new reference.
     * 
     * @param gameEngine the GameEngine of reference
     */
    public void setGameEngine(GameEngine gameEngine)
    {
        this.engine = gameEngine;
    }

    /**
     * Returns the
     * <code>Player</code> this client represents.
     *
     * @return the represented player
     */
    public Player getSelfPlayer()
    {
        return self;
    }

    /**
     * Returns the
     * <code>Player</code> who's turn it is currently.
     *
     * @return the Player who's turn it is
     */
    public Player getTurnPlayer()
    {
        return turnPlayer;
    }


    /**
     * Determines if the game is ready to begin.
     *
     * @return the boolean indicating the game readiness
     */
    public boolean isGameReady()
    {
        return gameReady;
    }

    /*
     * handleCard specifically deals with cardMessages received from the server.
     * 
     * @param msg CardMessage to be handled
     */
    private void handleCard(Object msg)
    {
        CardMessage message = (CardMessage) msg;
        Card card = message.getCards().get(0);

        // IF the message is directed to the self player
        if (message.getToPlayer().equalsName(self))
        {
            // CALL GameEngine's addMessage(msg) in order to be displayed
            engine.addCardMessage(message);
            // IF msg is ClueCard
            if (card instanceof ClueCard)
            {
                // CALL handleShowCard with ClueCard(for the Snoop)
                engine.handleShowCard(message);
            }
            // IF msg is SnoopCard
            if (card instanceof SnoopCard)
            {
                // CALL handleSnoop with this SnoopCard
                List<Object> toSend =
                    engine.handleSnoop((SnoopCard)card);
                // SEND card from handleSnoop
                sendListToServer(toSend);
            }
            // IF msg is PrivateTipCard
            if (card instanceof PrivateTipCard)
            {
                // CALL handlePrivateTip
                List<Object> toSend =
                    engine.handlePrivateTip((PrivateTipCard)card);
                // IF handlePrivateTip return list is not empty
                    //SEND card message in that list
                sendListToServer(toSend);
            }
            // IF msg is Sleuth card
            if (card instanceof SuperSleuthCard) 
            {
                // CALL handleSleuth
                List<Object> toSend =
                    engine.handleSleuth((SuperSleuthCard)card);
                // SEND card message return from handleSleuth
                sendListToServer(toSend);
            }
        }
    }
    
    /**
     * sendObjectsToServer takes a list of objects and sends them to the server.
     * 
     * @param  toSend list of objects to be sent to server
     */
    private void sendListToServer(List<Object> toSend)
    {
        //for each object, send individually to the server.
        for (Object obj : toSend) 
        {
            try
            {
                sendToServer(obj);
            }
            catch (IOException e) 
            {
                System.out.println("ERROR: fail to send");
            } 
        }
    }
    
    /*
     * handleProtocol correctly handles all Protocols sen from the GameServer.
     * Called by handleMessageFromServer.
     * 
     * @param msg Protocol sent representing state of game.
     */
    private void handleProtocol(Protocol msg)
    {
        //The game is ready
        if (msg == Protocol.GAME_READY)
        {
            // READY the lobby since the game is ready to begin
            lobby.readyGame();
        }
        // PREPARE lobby to start the game
        else if (msg == Protocol.GAME_START)
        {
            lobby.setStartGame();
        }
        // END the game
        else if (msg == Protocol.GAME_OVER)
        {
            // CALL endGame from GameEngine, with testing flags = false
            engine.endGame(false);
        }
        // IF msg is Protocol.END_TURN
        else if (msg == Protocol.END_TURN) 
        {
            // UPDATE queue of players and turnPlayer in GameState
            if (!engine.updateQueueForNextTurn()) 
            {
                System.out.println("ERROR: isInGame status of Players "
                        + "are not match with Queue in Server");
            }
        }
    }
    
    /**
     * Setter to the solution
     * @param solution is the solution to set
     */
    public void setSolution(Solution solution)
    {
        this.solution = solution;
    }
    
    /**
     * Handles a message sent from the
     * <code>GameServer</code> to this client.
     *
     * @param msg the message sent.
     */
    @Override
    protected void handleMessageFromServer(Object msg)
    {
        // IF msg is a Queue of Players and the game has not started or client
        // has not yet created a player.
        if (msg instanceof Queue && ((((Queue) msg).peek() instanceof Player) ||
                self == null)
                && !startedGame)
        {
            // UPDATE Lobby's queue of Players
            lobby.updatePlayers((Queue)msg);
        }
        // IF msg is Protocol.GAME_READY
        else if (msg instanceof Protocol)
        {
            handleProtocol((Protocol)msg);
        }
        //if cardMessage
        else if (msg instanceof CardMessage)
        {
            handleCard(msg);
        }
        //if Table,Solution,SuggestionLogic, AccusationMessage, or HistoryLog
        else
        {
            handleOther(msg);
        }
        
    }

    /**
     * handleOther takes in object that is not a queue, cardMessage, or Protocol
     * 
     * @param msg object sent from server to be handled.
     */
    private void handleOther(Object msg)
    {
        // IF msg is Table && lobby has been signaled game ready
        if (msg instanceof Table)
        {
            // SET the table for lobby 
            lobby.prepareGame((Table) msg);
        }
        // Make solution readily available to clients when game ends
        else if (msg instanceof Solution) 
        {
            solution = (Solution)msg;
        }
        // IF msg is SuggestionLogic
        else if (msg instanceof SuggestionCardLogic) 
        {
            // CALL handleSuggestion
            List<Object> toSend = 
                engine.handleSuggestion((SuggestionCardLogic)msg);
            // SEND card message(disprove card) to the server
            sendListToServer(toSend);
        }
        // IF msg is an AccusationMessage
        else if (msg instanceof AccusationMessage)
        {
            // CALL handle solution on the engine
            engine.handleSolution((AccusationMessage) msg);
        }
        // IF msg is a HistoryLog
        else if (msg instanceof HistoryLog) 
        {
            // CALL handleHistoryLog
            engine.handleHistoryLog((HistoryLog) msg);
        }
        // if player dropped, message is a string
        else if (msg instanceof String)
        {
            engine.getGameState().addToHistoryLog((String)msg);
        }
    }
    
    /**
     * Changes the <code>Player</code> of this current game client to the
     * parameter since during <code>GameClient</code> construction the player
     * was initialized to null.
     * 
     * @param set is the <code>Player</code> of this client
     */
    public void setPlayer(Player set) 
    {
        self = set;
    }
    
    protected void connectionClosed()
    {
        System.out.println("Client was disconnected");
    }
    
    protected void connectionException(Exception exception) 
    {
        System.out.println("Connection exception: " + exception.getMessage() 
                + ", class type: " + exception.getClass());
        exception.printStackTrace();
    }
    
    /**
     * Getter to get the Solution of the game
     * @return the solution of the game
     */
    public Solution getSolution() 
    {
        return solution;
    }
}
