package tegakari;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;

/**
 * The Lobby class represents the place where
 * <code>Player</code>s connect to the
 * <code>GameServer</code> and wait for other
 * <code>Player</code>s to join to eventually start the game. The
 * <code>Lobby</code> will only allow the first connected
 * <code>Player</code> to signal the start of the game to the other connected
 * <code>Player</code>s. The
 * <code>GameServer</code> will only allow the game to start once the minimum
 * number of
 * <code>Player</code>s needed connect is met.
 *
 * @author Jonathan Molina
 * @version 12/5/15 Version 1.0
 */
public class Lobby extends Observable implements Serializable
{

    /** 
     * A flag to send to server so that Server will shuffle the deck.
     */
    private boolean testingModeFlag = false;
    /**
     * The collection of
     * <code>Player</code>s connected to the
     * <code>GameServer</code>.
     */
    private Queue<Player> players;
    /**
     * The type of
     * <code>Theme</code> for the game.
     */
    private ThemeType themeType;
    /**
     * The client connected to the
     * <code>GameServer</code>.
     */
    private GameClient client;
    /**
     * The minimum number of
     * <code>Player</code>s to start.
     */
    private final int minPlayersToStart;
    /**
     * The minimum number of
     * <code>Player</code>s to play the game.
     */
    private final int maxPlayersAllowed;
    /**
     * The created GameEngine to run the game.
     */
    private GameEngine engine;
    /**
     * Indicates whether to connect to a local server.
     */
    private final int kDefaultPort = 51000;
    /**
     * The location of the target server.
     */
    private String serverIP = "cslvm48.csc.calpoly.edu"; // defaulted to cal poly vm
    /**
     * The file name for the ordered clue deck.
     */
    private String orderedClueDeckFile;
    /**
     * The file name for the ordered action card deck.
     */
    private String orderedActionDeckFile;
    /**
     * 
     * The boolean determining if the host
     * <code>Player</code> wants to begin the game.
     */
    private boolean isGameReady;
    /**
     * Indicates whether the first player signals to start playing the game
     * (closes the lobby GUI window and opens the table GUI window).
     */
    private boolean startGame;
    /**
     * Indicate to quit the lobby.
     */
    private boolean quit;
    /**
     * The number of robots added. Only used by the first player in the lobby.
     */
    private int numRobots = 0;
    /**
     * If view should use console based text or not.
     */
    private boolean isConsole;
    /**
     * The input mode for the game
     */
    private Scanner input;
    
    /**
     * Constructs an instance of this class that will connect to the Cal Poly
     * VM server at "cslvm48.csc.calpoly.edu".
     *
     * @param minPlayersToStart the minimum number of <code>Player</code>s to
     * start
     * @param maxPlayersAllowed the maximum number of <code>Player</code>s to start
     */
    public Lobby(int minPlayersToStart, int maxPlayersAllowed)
    {
        players = new ArrayDeque<Player>();
        this.minPlayersToStart = minPlayersToStart;
        this.maxPlayersAllowed = maxPlayersAllowed;
        this.isGameReady = false;
    }
    
    /**
     * Constructs an instance of this class that will connect to a server
     * running locally on the same machine as the application if the boolean
     * parameter isLocalServer is true. The client will attempt to connect
     * to "localhost".
     * 
     * @param minPlayersToStart the minimum number of <code>Player</code>s to start
     * @param maxPlayersAllowed the maximum number of <code>Player</code>s to start
     * @param isLocalServer indicates if the server to connect to is localhost
     */
    public Lobby(int minPlayersToStart, int maxPlayersAllowed, boolean isLocalServer)
    {
        this(minPlayersToStart, maxPlayersAllowed);
        // CONNECT to localhost
        if (isLocalServer)
        {
            this.serverIP = "localhost";
        }
    }
   
    /**
     * Constructs an instance of this class that will connect a server located
     * at the given IP address.
     * 
     * @param minPlayersToStart the minimum number of <code>Player</code>s to start
     * @param maxPlayersAllowed the maximum number of <code>Player</code>s to start
     * @param serverIP the location of the server
     */
    public Lobby(int minPlayersToStart, int maxPlayersAllowed, String serverIP)
    {
        this(minPlayersToStart, maxPlayersAllowed);
        this.serverIP = serverIP;
    }
    
    /**
     * Returns the String of the server's IP that the Lobby will connect to.
     * 
     * @return the server IP
     */
    public String getServerIP()
    {
        return serverIP;
    }
        
    /**
     * Determines if the game has started.
     * 
     * @return indicates the start of a game
     */
    public boolean isStartGame() 
    {
        return startGame;
    }

    /**
     * Tells the Lobby that the game has started, and will notify any observers.
     */
    public void setStartGame()
    {
        
        // Draw an action card if not 1st turn
        if(!engine.isTurn())
        {
            engine.getGameState().drawAnActionCard();
        }
        this.startGame = true;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Sets the game in testing mode where the clue and action deck ordering is
     * specified with the passed parameters.
     * 
     * @param clueDeckName the file name of the ordered clue deck
     * @param actionDeckName the file name of the ordered action deck
     */
    public void setTestingMode(String clueDeckName, String actionDeckName)
    {
        testingModeFlag = true;
        this.orderedClueDeckFile = clueDeckName;
        this.orderedActionDeckFile = actionDeckName;
    }
    
    /**
     * Determines if the application is in testing mode.
     * 
     * @return true if in testing mode, false otherwise
     */
    public boolean isTestingMode()
    {
        return testingModeFlag;
    }

    /**
     * Sets the type of
     * <code>Theme</code> for the game and is the
     * <code>ThemeType</code> for all the connected
     * <code>Player</code>s also. The first connected player should only be the
     * one with the ability to pick the
     * <code>ThemeType</code> for the game.
     *
     * @param themeType the type of <code>Theme</code> for the game
     */
    public void setThemeType(ThemeType themeType)
    {
        this.themeType = themeType;
        // SET changed to observers
        setChanged();
        // NOTIFY observers
        notifyObservers();
        try
        {
            client.sendToServer(this.themeType);
        }
        catch (IOException ex)
        {
            System.out.println("Failed to Send ThemeType to Server");
        }
    }
    
    /**
     * Uses the given
     * <code>Table</code> to be used for preparing the
     * <code>GameState</code> and <code>GameEngine</code>.
     * 
     * @param table the <code>Table</code> to be used for the game
     */
    public void prepareGame(Table table)
    {
        GameState state = new GameState(players, client.getSelfPlayer(), table);
        //CREATE new GameEngine using GameState + client
        this.engine = new GameEngine(state, client, isConsole);
        engine.setLobby(this);
    }

    /**
     * Retrieves the
     * <code>ThemeType</code> for the game.
     *
     * @return the <code>ThemeType</code> for the game
     */
    public ThemeType getThemeType()
    {
        return themeType;
    }

    /**
     * Retrieves the
     * <code>Queue</code> of
     * <code>Player</code>s in turn order.
     *
     * @return the <code>Queue</code> of <code>Player</code>s in turn order
     */
    public Queue<Player> getPlayers()
    {
        return players;
    }
    
    /**
     * Retrieves the <code>GameEngine</code> the Lobby is holding.
     * 
     * @return the held instance of <code>GameEngine</code>
     */
    public GameEngine getGameEngine()
    {
        return engine;
    }

    /**
     * Retrieves the number of
     * <code>Player</code>s needed to begin the game. This is NOT the minimum
     * number needed to begin the game, but rather the difference between the
     * minimum and the number currently connected.
     *
     * @return the number of players needed to start the game
     */
    public int getNumPlayersToStart()
    {   // IF number of players in the queue >= minPlayersToStart
        if (players.size() >= minPlayersToStart)
        {
            return 0;
        }
        else
        {
            // RETURN minPlayers - number of players in the queue
            return minPlayersToStart - players.size();
        }
    }
    
    /**
     * Returns the max number of players allowed to play the game.
     * 
     * @return the max number of players needed to play
     */
    public int getMaxPlayersAllowed()
    {
        return maxPlayersAllowed;
    }
    
    /**
     * Returns the min number of players allowed to play the game.
     * 
     * @return the min number of players needed to play
     */
    public int getMinPlayersAllowed()
    {
        return minPlayersToStart;
    }
    
    /**
     * Sets this queue of players to the passed queue of players.
     *
     * @param newPlayers the players that will play the game
     */
    public void updatePlayers(Queue<Player> newPlayers)
    {
        this.players = newPlayers; 
        // SET changed to observers
        setChanged();
        // NOTIFY observers
        notifyObservers();
    }
    
    /**
     * Indicates the game is ready to start.
     */
    public void readyGame()
    {
        this.isGameReady = true;
    }
    
    /**
     * Retrieves the boolean indicating if the game is ready.
     * 
     * @return the boolean indicating if the game is ready
     */
    public boolean isGameReady()
    {
        return isGameReady;
    }

    /**
     * Returns true if the joining the
     * <code>GameServer</code> was successful and returns false if this
     * <code>Lobby</code> is not able to join because the maximum number of
     * <code>Player</code>s connected to the server has been reached or the game
     * has already started. The
     * <code>GameClient</code> instance is created here and will prompt the user
     * for the name to be used to create the
     * <code>Player</code> instance.
     *
     * @return true for a successful connection to the server and game ready to
     * start, false if unable to connect
     */
    public boolean joinLobby()
    {
        // CREATE the instance of the GameClient using the created player instance
        if(client == null)
        {
            client = new GameClient(serverIP, kDefaultPort); //"129.65.150.243"
        }
        client.setLobby(this);
        
        // CONNECT to the server
        try
        {
            client.openConnection();
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        
        // Once connected, send protocol to send queue of players.
        try
        {
            client.sendToServer(Protocol.SEND_PLAYERS);
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: unable to ask server to send players." + ex);
        }
        return client.isConnected();
    }
    
    /**
     * Takes in a string whose name was successfully verified and renames the
     * <code>GameClient</code> player name to the parameter string.
     *
     * @param playerName the name to be used for the <code>Player</code>
     */
    public void sendPlayerToServer(String playerName) 
    {
        // CREATE the instance of the player
        Player player = new HumanPlayer(playerName);
        client.setPlayer(player);
        client.setLobby(this);
        // Once connected, send the the player to everyone to be added
        try
        {
            client.sendToServer(client.getSelfPlayer());
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: unable to send self player to server." + ex);
        }
    }

    /**
     * Signals the server to tell the connected clients that the game should
     * start. The first connected player should be the one to call this method.
     */
    public void startGame()
    {
        // IF selfPlayer from client == the first player in the queue
        if (isFirstPlayer())
        {
            // CHECK for game in testing mode
            if (testingModeFlag)
            {
                try
                {    
                    client.sendToServer(Protocol.TESTING_MODE);
                    client.sendToServer(Protocol.ORDERED_CLUE_DECK);
                    client.sendToServer(orderedClueDeckFile);
                    client.sendToServer(Protocol.ORDERED_ACTION_DECK);
                    client.sendToServer(orderedActionDeckFile);
                }
                catch (IOException ex)
                {
                    System.out.println("ERROR: unable to send "
                            + "Protocol.TESTING_MODE to server");
                }
            }
            // SEND Protocol.GAME_READY to server
            try
            {    
                
                client.sendToServer(Protocol.GAME_READY);
            }
            catch (IOException ex)
            {
                System.out.println("ERROR: unable to send "
                        + "Protocol.GAME_READY to server");
            }
            // SEND self Player to server to verify the 1st player is readying game
            try
            {    
                client.sendToServer(client.getSelfPlayer());
            }
            catch (IOException ex)
            {
                System.out.println("ERROR: unable to send "
                        + "Protocol.GAME_READY to server");
            }
        }
        // SEND GAME_START to server to signal everyone to start the game
        try
        {
            // sending the current theme to the server
            // for it to use with the robots
            //client.sendToServer(this.themeType);
            client.sendToServer(Protocol.GAME_START);
        }
        catch (IOException exception)
        {
            System.out.println("ERROR: "
                + "Fail to send Protocol.GAME_START to Server from Lobby ");
        }
    }

    /**
     * Disconnects from the server, freeing up a spot for another
     * <code>Player</code> to connect. Will be correctly implemented
     * for version 2.0.
     */
    public void quitLobby()
    {
        // SET lobby ready to quit
        this.quit = true;
        
        // SEND Protocol.PLAYER_DISCONNECTED_FROM_LOBBY
        try
        {
            client.sendToServer(Protocol.PLAYER_DISCONNECTED_FROM_LOBBY);
        } 
        catch (IOException exception) 
        {
            System.out.println("ERROR: unable to send Protocol to server");
        }
        
        // SEND self Player to be removed from queue of players
        try 
        {
            client.sendToServer(client.getSelfPlayer());
        } 
        catch (IOException ex) 
        {
            System.out.println("ERROR: unable to send Protocol to server");
        }
        
        // DISCONNECT client from server
        try 
        {
            client.closeConnection();
        } 
        catch (IOException ex) 
        {
            System.out.println("ERROR: cannot close connection from server from lobby");
        }
        // CLEAN up instance variables by making them null
    }
    
    /**
     * Returns whether this self player is the first player in the lobby
     *
     * @return true if self player is first players
     */
    public boolean isFirstPlayer()
    {
        // prevents null exception
        if (client.getSelfPlayer() == null)
        {
            return false;
        }
        else
        {
            return client.getSelfPlayer().equalsName(players.peek());
        }
    }
    
    /**
     * Returns whether this player's name is in use or not
     *
     * @param screenName is the chosen Name from user
     * @return true if player name is not used, false if used
     */
    public boolean checkPlayers(String screenName)
    {
        //FOR each player
        for (Player player : players)
        {
            //IF names match
            if (screenName.toUpperCase().equals(player.getName().toUpperCase()))
            {
                //RETURN false
                return false;
            }
            //ENDIF
        }
        //ENDFOR
        
        //RETURN true
        return true;
    }
    
    /**
     * Adds <code>Robot</code> to the <code>Lobby</code> with <code>AILevel</code>
     * @param level the AILevel of the Robot to add.
     */
    public void addRobot(AILevel level)
    {
        //CREATE new robot player
        Robot robot = new Robot("Robot" + ++numRobots + "_" + 
                level.getDescription(), level);
        
        try 
        {
            client.sendToServer(robot);
        }
        catch(IOException ex)
        {
            System.out.println("Unable to send robot." + ex);
        }
    }
    
    /**
     * Returns the name of the selfPlayer so the Title bar can be changed
     * in LobbyGUI's update method
     * @return the name of the SelfPlayer
     */
    public String getSelfName() 
    {
        return client.getSelfPlayer().getName();
    }
    
    /**
     * Closes the connection to the server and reinitializes to back to
     * initial constructor settings. This is different from quitLobby() because
     * quitLobby() assumes the player is counted as a game participant. This method
     * exits the lobby without being counted as a game participant.
     */
    public void closeLobby()
    {
        // CLOSE connection before initializing to prevent asynchronous calls
        // of setting variables
        try 
        {
            client.closeConnection();
        } 
        catch (IOException ex) 
        {
            System.out.println("ERROR: cannot close connection from server from lobby");
        }
        
        // Reinitilize lobby
        players = new ArrayDeque<Player>();
        this.client = null;
        this.engine = null;
        this.isGameReady = false;
        this.serverIP = serverIP;
        this.testingModeFlag = testingModeFlag;
        this.orderedClueDeckFile = orderedClueDeckFile;
        this.orderedActionDeckFile = orderedActionDeckFile;
    }
    
    /**
     * Sets the input needed for the application.
     * 
     * @param scanner the medium of handling client input
     */
    public void setInputMode(Scanner scanner)
    {
        this.input = scanner;
    }
    
    /**
     * Returns the input mode for the application.
     * 
     * @return the medium for client input
     */
    public Scanner getInputMode()
    {
        return input;
    }

    /**
     * This method sets this lobby to be in console mode or not.
     * 
     * @param console true if console mode view is to be used.
     */
    public void setConsoleMode(boolean console)
    {
        this.isConsole = console;
    }
    
    /**
     * Returns the boolean for console mode.
     * 
     * @return boolean of isConsole
     */
    public boolean getConsoleMode()
    {
        return this.isConsole;
    }
    
    /**
     * Sets the game engine for the Lobby.
     * @param gameEngine GameEngine to set to.
     */
    public void setEngine(GameEngine gameEngine)
    {
        this.engine = gameEngine;
    }
    
    /**
     * Returns the <code>GameEngine</code> of the lobby.
     * @return the GameEngine of the lobby
     */ 
    public GameEngine getEngine()
    {
        return engine;
    }
    
    /**
     * Sets the <code>GameClient</code> for the <code>Lobby</code>
     * @param client the client to set.
     */
    public void setClient(GameClient client)
    {
        this.client = client;
    }
    
    /**
     * Returns the <code>GameClient</code> of the <code>Lobby</code>
     * @return the client of the lobby
     */
    public GameClient getClient()
    {
        return client;
    }
    
    /**
     * Checks and returns if you can add a robot to the lobby.
     * @return the boolean if you can add a robot.
     */
    public boolean canAddRobot()
    {
        boolean out = true;
        // if the players size is equal to max allowed then make false
        if (players.size() == maxPlayersAllowed)
        {
            out = false;
        }
        return out;
    }
    
    /**
     * Gets the string that is the ordered clue deck file.
     * 
     * @return the String that represents that testing deck file
     */
    public String getClueDeckFile()
    {
        return orderedClueDeckFile;
    }
    
    /**
     * Gets the string that is the ordered action deck file.
     * 
     * @return the String that represents that testing deck file
     */
    public String getActionDeckFile()
    {
        return orderedActionDeckFile;
    }
}
