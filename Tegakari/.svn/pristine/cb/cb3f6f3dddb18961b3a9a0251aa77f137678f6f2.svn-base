package tegakari;

import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The GameServer is the server that accepts
 * <code>GameClient</code> connections, regulates
 * <code>Player</code> turns, passes messages to and from the connected clients,
 * and the game state. The server hosts on the default port 51000. The class
 * knows the first
 * <code>Player</code> to connect, the current turn
 * <code>Player</code>, and whether or not the game has started or ended.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 12/5/2015 Version 1.0
 */
public class GameServer extends AbstractServer implements Serializable
{
    /** 
     * Indicator if this game is in testing mode.
     */
    private boolean testingMode = false;
    /**
     * The default port the server hosts on.
     */ 
    private static final int kDefaultPort = 51000;
    /**
     * The minimum number of participating players.
     */ 
    private final int kMinPlayers = 3;
    /**
     * The maximum number of participating players.
     */ 
    private final int kMaxPlayers = 5;
    /**
     * The name of the ordered clue deck file.
     */
    private String orderedClueDeckFile;
    /**
     * The name of the ordered action deck file.
     */
    private String orderedActionDeckFile;
    /**
     * The list of all players in the game.
     */ 
    private Queue<Player> players;
    /**
     * The list of all robot players in the game.
     */
    private List<Robot> robots;
    /**
     * The current turn player.
     */ 
    private Player turnPlayer;
    /**
     * Indicates if the game has started.
     */ 
    private boolean startedGame;
    /**
     * Indicates if the game is over.
     */ 
    private boolean gameOver;
    /**
     * The default <code>ThemeType</code>.
     */
    private final ThemeType defaultThemeType = ThemeType.GREEK;
    /**
     * The default <code>Theme</code> instance.
     */
    private final Theme defaultTheme;
    /**
     * The <code>Table</code> created to be given to all the clients before
     * starting the game.
     */
    private Table table;
    /**
     * The solution of the game.
     */
    private Solution solution;
    /**
     * Indicating the clients that are connected by yet to be added to
     * the queue of players.
     */
    private Queue<ConnectionToClient> connectedClients;
    /**
     * The current protocol being handled.
     */
    private Queue<Protocol> protocols = new ArrayDeque<Protocol>();
     /**
     * Connections with players
     */
    private Map<Player, ConnectionToClient> playerConnections;
    /**
     * The first player of the game.
     */
    private Player firstPlayer;

    /**
     * Constructs a GameServer instance using the default port.
     */
    public GameServer()
    {
        super(kDefaultPort);
        this.defaultTheme = new Theme();
        this.table = new Table(defaultTheme);
        this.table.buildClueDeck();
        this.table.buildActionDeck();
        
        connectedClients = new ArrayDeque<ConnectionToClient>();
        players = new ArrayDeque<Player>();
        robots = new ArrayList<Robot>();
        protocols = new ArrayDeque<Protocol>();
        playerConnections = new HashMap<Player, ConnectionToClient>();
        startedGame = false;
        gameOver = false;
    }

    /**
     * Constructs an instance of itself and starts the server. The server should
     * be continuously running and should start accepting connections when a
     * game has not yet started and should stop accepting connections when a
     * game has started.
     *
     * @param args the command line arguments, not in use
     */
    public static void main(String[] args)
    {
        List<String> listArgs = Arrays.asList(args);
        AtomicBoolean serverActive = new AtomicBoolean(true);
        Scanner input = new Scanner(System.in);
        int counter = 0;
        
        //Set input/output/error flag and which files to output/input to
        if (listArgs.contains("-i"))
        {
            try
            {
                input = new Scanner((new FileInputStream(
                        new File(listArgs.get(listArgs.indexOf("-i")+ 1)))));
                System.setOut(new PrintStream(
                        new File(listArgs.get(listArgs.indexOf("-i")+ 2))));
                System.setErr(new PrintStream(
                        new File(listArgs.get(listArgs.indexOf("-i")+ 3))));
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("file not found, check your arguments");
            }
        }
        
        // Check if the server is in testing mode
        if (listArgs.contains("-i"))
        {
            counter = endServerResponse(input);
        }
        
        
        // LOOP infinitely for active active server
        while (serverActive.get())
        {
            // INIT instance of server using the default port
            GameServer server = new GameServer();
            
            lobbyPhase(server);
            gamePhase(server, listArgs);

            //If the counter is positive, it is in testing mode
            if (--counter > 0 || counter < 0)
            {
                serverActive.set(true);
            }
            else
            {
                serverActive.set(false);
            }
        }
    }
    
    private static int endServerResponse(Scanner input)
    {   
        System.out.println("How many times would you like to run the server?");
        
        return Integer.parseInt(input.nextLine());
    }
    
    private static void lobbyPhase(GameServer server)
    {
        System.out.println("Lobby phase");
        // WHILE !startGame (game hasn't started)
        while (!server.startedGame)
        {
            // IF number of clients connected < maxPlayers && is not listening
            if (server.getNumberOfClients() < server.kMaxPlayers
                    && !server.isListening())
            {
                System.out.println("Started listening for clients");
                try
                {
                    // START listening for clients to connect
                    server.listen();
                } 
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    private static void gamePhase(GameServer server, List<String> listArgs)
    {
        System.out.println("Game phase");
        // WHILE game isn't over
        while (!server.gameOver())
        {
            System.out.print(""); // needed to exit while loop
        }
        try
        {
            server.resetServer();
            server.close();
            Scanner in = new Scanner(System.in);
            // CLOSE server to disconnect all clients
        } 
        catch (IOException ex)
        {
            System.out.println("ERROR: Server failed to close");
        }
    }

    /**
     * Resets the server back to the state prior to starting the game.
     */
    public void resetServer()
    {
        this.connectedClients = null;
        this.gameOver = false;
        this.players = null;
        this.protocols = null;
        this.solution = null;
        this.startedGame = false;
        this.turnPlayer = null;
        this.playerConnections = null;
    }

    /**
     * Returns a boolean value indicating if the game has started.
     *
     * @return the boolean value determining if the game started
     */
    public boolean startedGame()
    {
        //#386
        return startedGame;
    }

    /**
     * Returns a boolean value indicating if the game is over.
     *
     * @return the boolean value determining if the game is over
     */
    public boolean gameOver()
    {
        //#386
        return this.gameOver;
    }
    
    /**
     * Tells the server that the game is over.
     */
    public void setGameOver()
    {
        gameOver = true;
        sendToAllClients(Protocol.GAME_OVER);
    }
    
    /**
     * Hook method called each time a new <code>GameClient</code> connection is
     * accepted. This method will add the <code>Player</code> represented by
     * the <code>GameClient</code> to this class' <code>Queue</code> of
     * <code>Player</code>s and also will send this <code>Player</code> to all
     * the connected clients, including the parameter client. The clients will
     * add the <code>Player</code> to their own respective <code>Queue</code>.
     * The default implementation does nothing.
     * This method does not have to be synchronized since only
     * one client can be accepted at a time.
     *
     * @param client the connection connected to the client.
     */
    @Override
    protected void clientConnected(ConnectionToClient client)
    {
        // Only add to the queue if the max limit has not been reached
        if (getNumberOfClients() <= kMaxPlayers)
        {
            System.out.println("Client connected");
            // ADD to the queue to indicate that queue needs to be updated
            connectedClients.add(client); // do we need to add to the queue?
        }
    }

    /**
     * Hook method called each time a <code>GameClient</code> disconnects.
     * This method will extract the <code>Player</code> from this class'
     * <code>Queue</code> of <code>Player</code>s, will notify the other
     * connected clients that a <code>Player</code> needs to be removed from
     * their <code>Queue</code>, and finally will send the <code>Player</code>
     * to be removed.
     * The client is guaranteed to be disconnected but the thread
     * is still active until it is asynchronously removed from the thread group. 
     * The default implementation does nothing. The method
     * may be overridden by subclasses but should remains synchronized.
     *
     * @param client the connection with the client.
     */
    @Override
    protected void clientDisconnected(ConnectionToClient client)
    {
        // player to be removed
        Player rmPlayer = null;
        Player test;
        System.out.println("Client disconnected");
        
        // Check for disconnection at entering name before lobby
        if (!playerConnections.containsValue(client))
        {
            connectedClients.remove(client);
            return;
        }
        
        // handles disconnects while still in the lobby
        if (!this.startedGame)
        {
            // removes the player disconnected during the lobby
            for (Map.Entry<Player, ConnectionToClient> en : playerConnections.entrySet())
            {
                // find player with the connection value
                if (client.equals(en.getValue()))
                {
                    rmPlayer = en.getKey();
                }
            }
            // remove player from players list
            int size = players.size();
            
            // REMOVE the given player from the queue of players
            for (int count = 0; count < size; count++)
            {
                Player temp = players.remove();
                // IF retrieved player is not the player to be removed
                if (!rmPlayer.equalsName(temp))
                {
                    // PUT the retrieved player back in the queue
                    players.add(temp);
                }
            }            
            // SEND deep copy of the queue of players to everyone
            Queue<Player> newPlayers = new ArrayDeque<Player>();
            
            // ADD players to the queue
            while (players.size() > 0)
            {
                newPlayers.add(new HumanPlayer(players.remove().getName()));
            }
            players = newPlayers;
            // send updated players list
            sendToAllClients(players);
            
        }
        //ELSEIF game is not over
        else if (!this.gameOver) // ADD AI to replace disconnected player
        {
            replacePlayerWithAI(client);
            System.out.println("Replaced human player with Robot");
        }

    }
    
    private Player[] dropList = new Player[this.kMaxPlayers];
    private int dropCount = 0;
    
    /**
     * Replaces the disconnected client with a Robot player.
     * 
     * @param client the connection with the client.
     */
    private void replacePlayerWithAI(ConnectionToClient client)
    {
        Robot toReplace = null;
        // GET player that maps with the connectedToClient object
        dropList[dropCount] = getPlayerFromClient(client);
        System.out.println("**: The disconnect client was: " 
                + dropList[dropCount].getName());
        
        sendToAllClients(dropList[dropCount].getName() + 
                " dropped, replaced with robot");
        // CREATE new notepad for computer player
        Notepad notepad = createNotepadFromTheme(defaultTheme);
        // CREATE robotPlayer = new Robot
        robotArray[robotCount] = new Robot(players, 
               dropList[dropCount].getName(), AILevel.SMART);
        
        robotArray[robotCount].handleMessageFromServer(table);
        
        toReplace = robotArray[robotCount++];
        
        // CREATE list to get players from the queue
        List<Player> oldPlayers = new ArrayList<Player>(players);
        // GET index of disconnected player
        int index = 0;
        // For each player from the Q
        for (Player aPlayer : oldPlayers)
        {
            // Compare name with the droped player
            if (aPlayer.getName().equals(dropList[dropCount].getName()))
            {
                break;
            }
            index++;
        }
        toReplace.getEngine().getState().setSelf(toReplace);
        toReplace.getEngine().getState().setPlayers(players);
        giveHandToAI(oldPlayers, index, toReplace);
        //toReplace.getEngine().printState();
        // REMOVE the disconnected player at index
        Player head = players.peek();

        // Check for disconnecting player the turn player
        if (dropList[dropCount].equalsName(head))
        {
            head = toReplace;
        }
        // Find the player to be removed
        while (index > 0)
        {
            Player next = players.remove();
            players.add(next);
            index--;
        }
        dropList[dropCount] = players.remove();
        
        dropCount += 1;
        
        players.add(toReplace);
        robots.add(toReplace);
        // cycle back queue to how it was before
        while (!players.peek().equalsName(head))
        {
            Player next = players.remove();
            players.add(next);
        }
        // SEND deep copy of queue
        Queue<Player> newPlayers = makeNewPlayerQueue(players);
        // SEND updated queue to all clients (have clients update their players)
        //sendToAllClients(newPlayers);
        sendToAllRobots(players);
        checkTurnAfterReplaceAI(head, toReplace);
    }
    
    private void giveHandToAI(List<Player> oldPlayers, int index, Robot toReplace)
    {
        List<ClueCard> clues = oldPlayers.get(index).getClueCards();
        // For each clues card of the droped player
        for (ClueCard aClues : clues )
        {
            toReplace.getHand().addToHand(aClues);
        }
        List<ActionCard> actions = oldPlayers.get(index).getActionCards();
        // For each action card of the droped player
        for (ActionCard anAction : actions )
        {
            toReplace.getHand().addToHand(anAction);
        }
        toReplace.setDestination(oldPlayers.get(index).getDestination());
    }
    
    private void checkTurnAfterReplaceAI(Player head, Player toReplace)
    {
        // IF disconnected player is the turn player
        if (head == toReplace)
        {
            // End turn
            // CALL selectNextPlayerTurn
            Player nextTurnPlayer = selectNextPlayerTurn();

            // NO valid next player
            if (nextTurnPlayer == null || gameOver)
            {
                gameOver = true;
                sendToAllClients(Protocol.GAME_OVER);
                sendToAllRobots(Protocol.GAME_OVER);
            }
            else
            {
                // SEND Protocol.END_TURN 
                sendToAllClients(Protocol.END_TURN);
                sendToAllRobots(Protocol.END_TURN);
            }
        }
        // Check if that drop player was the last active human player in the game.
        else if (checkOutPlayers())
        {
            gameOver = true;
            sendToAllClients(Protocol.GAME_OVER);
        }
    }
    
    private Notepad createNotepadFromTheme(Theme theme)
    {
        List<SuspectCard> suspects = new ArrayList<SuspectCard>();
        List<VehicleCard> vehicles = new ArrayList<VehicleCard>();
        List<DestinationCard> destinations = new ArrayList<DestinationCard>();

        // create suspect cards
        for (Suspect suspect : defaultTheme.getSuspects())
        {
            suspects.add(new SuspectCard(suspect));
        }
        // create vehicle cards
        for (Vehicle vehicle : defaultTheme.getVehicles())
        {
            vehicles.add(new VehicleCard(vehicle));
        }
        // create destination cards
        for (Destination destination : defaultTheme.getDestinations())
        {
            destinations.add(new DestinationCard(destination));
        }

        return new Notepad(players, suspects, vehicles, destinations, solution);
    }
    
    private Player getPlayerFromClient(ConnectionToClient client)
    {
        Player player = null;
        
        // Search through all map entries
        for (Entry<Player, ConnectionToClient> entry : playerConnections.entrySet())
        {
            // Compare the entry's client to the searched client
            if (client == entry.getValue())
            {
                player = entry.getKey();
            }
        }
        
        return player;
    }

    private Robot[] robotArray = new Robot[4];
    private int robotCount = 0;
    /**
     * Handles a command sent from one client to the <code>GameServer</code>.
     * The server will receive <code>Protocol</code> enums and will also
     * send the appropriate <code>Protocol</code> enums to the connected clients
     * along with a specific object immediately after depending on
     * the situation.
     * This method is called by a synchronized method so it is also
     * implicitly synchronized.
     *
     * @param msg   the message sent.
     * @param client the connection connected to the client that
     *  sent the message.
     */
    @Override
    synchronized protected void handleMessageFromClient(Object msg,
                                                    ConnectionToClient client)
    {
        boolean result = handleClientMessageCaseSet1(msg, client);
        
        // check if messaged handleded already
        if (!result)
        {
            result = handleClientMessageCaseSet2(msg, client);
        }
        // check if messaged handleded already
        if (!result)
        {
            result = handleClientMessageCaseSet3(msg, client);
        }
        // check if messaged handleded already
        if (!result)
        {
            result = handleClientMessageCaseSet4(msg, client);
        }
        
        // RELAY updated HistoryLog to everyone
        if (!result && msg instanceof HistoryLog)
        {
            // SEND to all client to update their history log
            sendToAllClients(msg);
            sendToAllRobots(msg);
        }
        // ADD protocol to be handled
        else if (!result && msg instanceof Protocol)
        {
            // ADD protocol to queue for synchronization purposes
            protocols.add((Protocol) msg);
        }
        // CALLED before game started to change the theme
        else if (!result && msg instanceof ThemeType)
        {
            
            ThemeType theme = (ThemeType) msg;
            // changes the default theme to the current one
            this.defaultTheme.changeThemeType(theme);
            // recreates the table to use the new Theme
            this.table = new Table(defaultTheme);
            this.table.buildClueDeck();
            this.table.buildActionDeck();
            System.out.println("New Theme Selected: " + theme.toString());
        }
    }
    
    private boolean handleClientMessageCaseSet1(Object msg, ConnectionToClient client)
    {
        // NEW connected player still needing to send updated player queue to everyone
        if (msg instanceof HumanPlayer && connectedClients.size() > 0)
        {
            // ADD to queue
            HumanPlayer newPlayer = (HumanPlayer) msg;
            players.add(newPlayer);
            playerConnections.put(newPlayer, client);
            // POP off connected client to indicate the new connection is handled
            connectedClients.remove();
            // SEND deep copy of the queue of players to everyone
            Queue<Player> newPlayers = makeNewPlayerQueue(players);
            
            players = newPlayers;
            
            sendToAllClients(newPlayers);
            sendToAllRobots(newPlayers);

        }
        // NEW robot was added to game
        else if(msg instanceof Robot) 
        {
            System.out.println("Sever adding Robot...");
            
            Robot bot = (Robot) msg;
            robotArray[robotCount] = new Robot(players, bot.getName(), bot.getAILevel());
            players.add(robotArray[robotCount]);
            robots.add(robotArray[robotCount]);
            ++robotCount;
            
            Queue<Player> newPlayers = makeNewPlayerQueue(players);
            
            players = newPlayers;
            sendToAllClients(newPlayers);
            sendToAllRobots(newPlayers);
        }
        // HANDLE disconnecting a player from the lobby
        else if (msg instanceof Player
                && protocols.peek() == Protocol.PLAYER_DISCONNECTED_FROM_LOBBY)
        {
            handlePlayerDisconnectFromPlayer((Player) msg);
        }
        else // when the other conditions were not reached
        {
            return false;
        }
        return true;
    }
    
    private void handlePlayerDisconnectFromPlayer(Player player)
    {
        System.out.println("Received Player to update the queue for disconnection");
        // REMOVE protocol from queue since the protocol has been handled
        protocols.remove();

        // REMOVE player from queue
        Player first = players.peek();
        int size = players.size();

        // REMOVE the given player from the queue of players
        for (int count = 0; count < size; count++)
        {
            Player temp = players.remove();
            // IF retrieved player is not the player to be removed
            if (!player.equals(temp))
            {
                // PUT the retrieved player back in the queue
                players.add(temp);
            }
        }

        // CHECK if the first player originally is still the first player
        if (!player.equals(first) && !first.equals(players.peek()))
        {
            // THROW error
            System.out.println("ERROR: queue is not in the correct order");
        }

        // SEND the updated player queue
        sendToAllClients(players);
        sendToAllRobots(players);
    }
    
    private boolean handleClientMessageCaseSet2(Object msg, ConnectionToClient client)
    {
        // SEND players
        if (msg instanceof Protocol && ((Protocol) msg) == Protocol.SEND_PLAYERS)
        {
            sendToAllClients(players);
            sendToAllRobots(players);
        }
        // ENABLE testing mode
        else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.TESTING_MODE)
        {
            this.testingMode = true;
        }
        // SET clue deck file name
        else if (msg instanceof String && protocols.peek() == Protocol.ORDERED_CLUE_DECK)
        {
            this.orderedClueDeckFile = (String) msg;
            protocols.remove();
        }
        // SET action deck file name
        else if (msg instanceof String
                && protocols.peek() == Protocol.ORDERED_ACTION_DECK)
        {
            this.orderedActionDeckFile = (String) msg;
            protocols.remove();
        }
        else
        {
            return false;
        }
        return true;
    }
    
    private boolean handleClientMessageCaseSet3(Object msg, ConnectionToClient client)
    {
        // IF msg is Protocol.GAME_READY (in queue) && client's self Player
        // is the first player in the queue
        if (msg instanceof Player
               && protocols.peek() == Protocol.GAME_READY
               && ((Player) msg).equalsName(players.peek()))
        {
            System.out.println("Readying game...");
            // REMOVE the handled protocol
            protocols.remove();

            //Prepare the deck before sending to clients, depending to the testing mode
            if (!testingMode)
            {
                this.table.shuffleActionDeck();
                this.table.shuffleClueDeck();
                this.table.shuffleDM();
            }
            else
            {
                System.out.print("In testing mode... ");
                this.table.buildOrderedClueDeck(orderedClueDeckFile);
                this.table.buildOrderedActionDeck(orderedActionDeckFile);
            }
            this.solution = table.makeSolution();
            System.out.println("Solution: " + solution.toString());

            // SEND Table to all clients
            sendToAllClients(table);
            sendToAllRobots(table);
            System.out.println("Sent table");

            sendToAllClients(solution);
            sendToAllRobots(solution);
            System.out.println("Sent solution");

            // SEND Protocol.GAME_READY to all the clients
            sendToAllClients(Protocol.GAME_READY);
            sendToAllRobots(Protocol.GAME_READY);
            System.out.println("Sent GAME_READY");
        }
        // START game
        else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.GAME_START)
        {
            System.out.println("Starting game...");
            // SET startedGame to true
            startedGame = true;
            turnPlayer = players.peek();

            sendToAllClients(msg);
            sendToAllRobots(msg);
        }
        else
        {
            return false;
        }
        return true;
    }
    
    private boolean handleClientMessageCaseSet4(Object msg, ConnectionToClient client)
    {
        // RELAY CardMessage to everyone to be handled
        if (msg instanceof CardMessage)
        {
            sendToAllClients(msg);
            sendToAllRobots(msg);
        }
        // RELAY SuggestionCardLogic to everyone to be handled
        else if (msg instanceof SuggestionCardLogic)
        {
            sendToAllClients(msg);
            sendToAllRobots(msg);
        }
        // HANDLE AccusationMessage
        else if (msg instanceof AccusationMessage)
        {    
            AccusationMessage accusation = (AccusationMessage) msg;
            accusation.setSolution(this.solution);

            // IF correct
            if (solution.equals(accusation.getAccusation()))
            {
                accusation.setIsCorrect(true);
                // SET gameOver to TRUE
                gameOver = true;
            }
            else
            {
                accusation.setIsCorrect(false);
                // SET turnPlayer as out
                turnPlayer.setPlayerLoses();
            }
            // SEND AccusationMessage to all clients
            sendToAllClients(accusation);
            sendToAllRobots(accusation);
        }
        // HANDLE ending turn
        else if (msg instanceof Protocol && ((Protocol) msg) == Protocol.END_TURN)
        {
            // CALL selectNextPlayerTurn
            Player nextTurnPlayer = selectNextPlayerTurn();

            // NO valid next player
            if (nextTurnPlayer == null || gameOver)
            {
                this.gameOver = true;
                sendToAllClients(Protocol.GAME_OVER);
                sendToAllRobots(Protocol.GAME_OVER);
            }
            else
            {
                // SEND Protocol.END_TURN 
                sendToAllClients(Protocol.END_TURN);
                sendToAllRobots(Protocol.END_TURN);
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    
    /**
     * Chooses the next
     * <code>Player</code> to take their turn. Skips players who are out. If all
     * the players are out, the game should end and this method will return null.
     *
     * @return the next <code>Player</code>'s turn or null if all players are out
     */
    private Player selectNextPlayerTurn()
    {
        int totalPlayer = players.size();
        int counter = 0;
        // DEQUEUE the player from queue (assuming it's the previous turn player)
        // ENQUEUE the previous turn player back to the queue
        players.add(players.remove());
        
        //SKIP the players who was out
        while(!(players.peek().isInGame()) && (counter < totalPlayer))
        {
            counter += 1;
            Player previous = players.remove();
            players.add(previous);
        }
        
        // SET turn player to the peeked player from the queue
        if (counter < totalPlayer && !checkOutPlayers())
        {
            turnPlayer = players.peek();
            return turnPlayer;
        }
        
        
        return null;
    }
    /**
     * Check the queue of robots and queue of human 
     * player to see if the game should end.
     * @return true if game should end, false when not.
     */
    public boolean checkOutPlayers()
    {
        int countPlayerOut = 0;
        // Count out player
        for (Player player : new ArrayList<Player>(players))
        {
            // check for out player
            if (!player.isInGame())
            {
                countPlayerOut++;
            }
        }
        // Check for number of out player and robot
        if (countPlayerOut + robots.size() == players.size())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Let the list of robot take turn handling the message.
     * @param message is the message for Robot to handle
     */
    private void sendToAllRobots(Object message)
    {
        List<Object> out ;
        List<Object> toSend = new ArrayList<Object>();
        // send all
        for (Robot aRobot : robots)
        {
            out = aRobot.handleMessageFromServer(message);
            // send messages if not null
            if (out != null && out.size() > 0)
            {   // build send to server list
                for (Object returnMessage : out)
                {
                    toSend.add(returnMessage);
                }
            }
        }
        // send to server
        for (Object returnMessage : toSend)
        {
            this.handleMessageFromClient(returnMessage, null);
        }
    }
    
    private Queue<Player> makeNewPlayerQueue(Queue<Player> playerss)
    {
        Queue<Player> newPlayers = new ArrayDeque<Player>();
        int size = playerss.size();
        // any players left
        for(int idx = 0; idx < size; idx++)
        {   // check if first is robot
            if(playerss.peek().isRobot())
            {
                Robot tempBot = (Robot)playerss.remove();
                newPlayers.add(new Robot(tempBot.getName(), tempBot.getAILevel()));
                playerss.add(tempBot);
            }
            else
            {
                HumanPlayer tempPlayer = (HumanPlayer)playerss.remove();
                newPlayers.add(new HumanPlayer(tempPlayer.getName()));
                playerss.add(tempPlayer);
            }
        }
        return newPlayers;
        
    }
}
