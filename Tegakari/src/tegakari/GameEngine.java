package tegakari;

import guiConsoleController.*;
import allguis.*;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * The GameEngine represents the actions necessary for a
 * <code>Player</code> to play the game as well as the methods needed to
 * facilitate the game state.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 11/6/2015 Adding java doc
 * @version 11/8/2015 Adding pseudocode performAction
 *                    Adding private helper methods for performAction.
 * @version 11/12/2015 Add pseudocode for actions
 * @version 11/15/2015 Implement all except beginTurn
 * @version 11/17/2015 Implement beginTurn, add method finishingTurn
 * @version 11/28/2015 Finished version 1.0
 * @version 12/5/15 Version 1.0
 */
public class GameEngine implements Serializable
{
    /**
     * An instant of parent lobby to replay the game later.
     */
    private Lobby lobby;
    /**
     * Number of card this self player expect to get back after player
     * Private tip or Suggestion.
     */
    private int expectedReceivingCard = 0;
    /**
     * Number of card this self player expect to get back after player
     * Sleuth.
     */
    private int expectedReceivingSleuth = 0;
    /**
     * Number of cards this self player actually received from other player
     * after playing private tip or sleuth card.
     */
    private int receivedCards = 0; 
    /**
     * List of card message received from other players waiting to be shown.
     */
    private List<CardMessage> receivedCardList = new ArrayList<CardMessage>();   
    /**
     * Temporary store the SuggestionLogic that player made.
     */
    private SuggestionCardLogic tempSuggestLogic;    
    /**
     * The client connected to the server.
     */
    private GameClient client;
    /**
     * The messages must be analyzed first come, first serve so a
     * <code>Queue</code> suffices this requirement.
     */
    private Queue<CardMessage> messages;
    /**
     * The game state.
     */
    private GameState gameState;
    /**
     * The GUI of the game board.
     */
    private JFrame tableGUI;
    
    /**
     * Indicate if someone won the game
     */
    private boolean gotWinner = false;
    /**
     * Indicate if views should be text style
     */
    private boolean isConsole;
    /**
     * Indicate if engine needs to have a new scanner input
     */
    private Scanner input = null;
    /**
     * For prevent exiting the application when in testing mode
     */
    private boolean noneTesting = true;
    /**
     * Constructs an instance of this class using the GameState and GameClient.
     * Default console to false.
     * @param gameState the manipulated model the GameTable will be observing
     * @param client the point of communication with the server
     */
    public GameEngine(GameState gameState, GameClient client)
    {
        this.client = client;
        this.messages = new ArrayDeque<CardMessage>();
        this.gameState = gameState;
        this.isConsole = false;
        client.setGameEngine(this);
    }
    
    /**
     * Constructs an instance of this class using the GameState and GameClient.
     * Sets the console boolean to stated.
     * @param gameState manipulated model the GameTable will be observing
     * @param client the point of communication with the server
     * @param isConsole checks if it is a console.
     */
    public GameEngine(GameState gameState, GameClient client, boolean isConsole)
    {
        this.client = client;
        this.messages = new ArrayDeque<CardMessage>();
        this.gameState = gameState;
        this.isConsole = isConsole;
        client.setGameEngine(this);
    }
    
    /**
     * Sets the GameTableGUI reference of this class to the passed parameter.
     * 
     * @param table the GUI of the game board
     */
    public void setGameTableGUI(JFrame table)
    {
        this.tableGUI = table;
    }
    
    /**
     * Retrieve the GameTable GUI that the class uses.
     * 
     * @return the GUI for the game table
     */
    public JFrame getGameTableGUI()
    {
        return tableGUI;
    }
    
    /**
     * Retrieves the game state.
     * 
     * @return the GameState
     */
    public GameState getGameState()
    {
        return gameState;
    }

    /**
     * Setter to the field expectedReceivingSleuth for testing
     * @param toSet is the integer to set the expectedReceivingSleuth
     */
    public void setExpectSleuth(int toSet)
    {
        expectedReceivingSleuth = toSet;
    }
    /**
     * Adds the given text input to the
     * <code>HistoryLog</code>.
     *
     * @param text the <code>String</code> to be added
     * the <code>HistoryLog</code>
     */
    public void addToLog(String text)
    {
        // CALL addToLog method on the log with parameter is text
        gameState.addToHistoryLog(text);
    }

    /**
     * Updates the new turn <code>Player</code>.
     *
     * @return indicator for successful update
     */
    public boolean updateQueueForNextTurn()
    {
        // SET turn player with the player in parameter
        return gameState.updateQueueForNextTurn();
    }

    /**
     * Determines if the player this class represents is currently in their turn.
     * 
     * @return indicator if in the represented player's turn
     */
    public boolean isTurn()
    {
        return gameState.getTurnPlayer().equals(gameState.getSelfPlayer());
    }

    /**
     * Allow <code>this Player</code> to conduct their turn. This method will
     * send a collection of items to the server when necessary depending on
     * the action taken.
     */
    public void beginTurn()
    {
        // SET inturn to TRUE
        gameState.setInAction(true);
        // INIT a list of object to be returned
        List<Object> toSend = new ArrayList<Object>();

        // CHECK if an action card was played instead of an immediate accusation
        if (gameState.getAccusation() == null)
        {
            // GET chosen action card to play from GameState
            ActionCard cardPlayed = gameState.getChosenActionCard();
            // CALL performAction with that action card
            // SET the list to be sent to the server
            toSend = performAction(cardPlayed);
        }

        // SEND the gathered objects to the server
        for (Object object : toSend)
        {
            try 
            {
                client.sendToServer(object);
            }
            catch (IOException e)
            {
                System.out.println("ERROR: Failed to send to server");
            }
        }
    }
    
    /**
     * After player played an action card, a player can make
     * an accusation or end their turn.
     */
    public void finishingTurn()
    {
        // SEND a created accusation to the server
        if (gameState.getAccusation() != null)
        {
            // ADD AccusationMessage to the return list
            AccusationMessage accusation =
                    new AccusationMessage(gameState.getAccusation(),
                        null, gameState.getTurnPlayer());
            try
            {
                client.sendToServer(accusation);
            }
            catch (IOException e)
            {
                System.out.println("ERROR: Failed to send to server");
            }
        }
        expectedReceivingCard = 0;
        expectedReceivingSleuth = 0;
        receivedCards = 0;
        receivedCardList = new ArrayList<CardMessage>();
        gameState.reset();
        
        // Send END_TURN protocol
        try
        {
            client.sendToServer(Protocol.END_TURN);
        }
        catch (IOException e)
        {
            System.out.println("ERROR: Failed to send to server");
        }
    }
    /**
     * Use for show card from playing Snoop, PrivateTip, or playing SuperSleuth.
     * 
     * @param cardReceived the card to display
     */
    public void handleShowCard(CardMessage cardReceived)
    {
        // ADD this card message to the list of ReceivedCard
        receivedCardList.add(cardReceived);
        // INCREEMENT the counter receivedCard
        receivedCards++;
        
        // IF case disprove & private tip
        if (expectedReceivingSleuth == 0)
        {
            handleShowCardForDisprovePrivateTip(cardReceived);
        }
        // ELSE case SuperSleuthResponse 
        else if (receivedCards >= expectedReceivingSleuth)
        {
            String names = "";
            
            // FORMAT the names of the players
            for (CardMessage msg: receivedCardList)
            {
                names = names + "[" + msg.getFromPlayer().getName() + "] ";
            }
            
            gameState.addToHistoryLog(names + " each showed "
                    + gameState.getTurnPlayer().getName()
                    + " a Clue Card in response to a SuperSleuth");
            try
            {
                client.sendToServer(gameState.getHistoryLog());
            }
            catch (IOException e)
            {
                System.out.println("ERROR: Failed to send to server");
            }
            
            SleuthResultDialogController ctrl = new SleuthResultDialogController();
            // check for console
            if (isConsole)
            {
                SleuthResultDialogConsole view = 
                        new SleuthResultDialogConsole(ctrl, receivedCardList);
                ctrl.setup(isConsole, view);
                view.startDialog();
            }
            else
            {
                SleuthResultDialog view = 
                        new SleuthResultDialog(ctrl, tableGUI, true, receivedCardList);
                ctrl.setup(isConsole, view);
                view.pack();
                view.setVisible(true);
                view.dispose();
            }

            // RESET list of receivedCard
            receivedCardList.clear();
            receivedCards = 0;
        }
    }
    
    /**
     * Helper method for handleShowCard().
     * 
     * @param cardReceived the card received
     */
    private void handleShowCardForDisprovePrivateTip(CardMessage cardReceived)
    {
        ClueCard card = (ClueCard)(cardReceived.getCards().get(0));
        // IF self player has this card, means other player snoop on me
        if ((gameState.getSelfPlayer().getClueCards().contains(card)))
        {
            SnoopOnMeDialogController ctrl = new SnoopOnMeDialogController();
            // check for console
            if (isConsole)
            {
                SnoopOnMeConsole view = new SnoopOnMeConsole(ctrl, cardReceived);
                ctrl.setup(view);
                view.startDialog();
            }
            else
            {
                SnoopOnMeDialog view = 
                        new SnoopOnMeDialog(ctrl, tableGUI, true, cardReceived);
                ctrl.setup(view);
                view.pack();
                view.setVisible(true);
                view.dispose();
            }

            // SHOW has been snoopped on dialog
            receivedCardList.clear();
        }
        // ELSE (means other player shows a card to turnplayer )
        else
        {
            ShowCardDialogController ctrl = new ShowCardDialogController();
            // SHOW show card(s) dialog
            if (isConsole)
            {
                ShowCardDialogConsole view = 
                        new ShowCardDialogConsole(ctrl, receivedCardList);
                ctrl.setUp(view, isConsole, receivedCardList);
                view.startDialogue();
            }
            else 
            {
                ShowCardDialog view = 
                        new ShowCardDialog(ctrl, tableGUI, true, 
                        receivedCardList);
                ctrl.setUp(view, isConsole, receivedCardList);
                view.pack();
                view.setVisible(true);
            }
        }
        // RESET list of receivedCard
        receivedCardList.clear();
        receivedCards = 0;
    }
    
    /**
     * Handles a snoop card played. Returns a CardMessage of the snooped 
     * <code>ClueCard</code> to display.
     * 
     * @param snoopCardToPlay the snoop card that was played
     * @return a message with a <code>ClueCard</code> that was snooped on targetPlayer
     */
    public List<Object> handleSnoop(SnoopCard snoopCardToPlay)
    {
        List<Object> toReturn = new ArrayList<Object>();

        // APPLIES only if player is still in the game
        if (gameState.getSelfPlayer().isInGame())
        {    
            // MAKE SnoopCardLogic
            SnoopCardLogic snoopLogic = 
                    new SnoopCardLogic(snoopCardToPlay, gameState.getTurnPlayer());
            // CALL playSnoop on the next player according to direction
            ArrayList<Player> listOfPlayers = 
                    new ArrayList<Player>(gameState.getPlayers());

            int myIndex = listOfPlayers.indexOf(gameState.getSelfPlayer());
            int myTargetIndex;
            // DETERMINE snoop direction
            if (snoopCardToPlay.getDirection().isRight())
            {
                // DETERMINE appropriate player index to the right
                if (myIndex == 0)
                {
                    myTargetIndex = listOfPlayers.size()-1;
                }
                else
                {
                    myTargetIndex = myIndex-1;
                }
            }
            else
            {
                // DETERMINE appropriate player index to the left
                if (myIndex == listOfPlayers.size()-1)
                {
                    myTargetIndex = 0;
                }
                else
                {
                    myTargetIndex = myIndex+1;
                }
            }
            
            SnoopDialogController ctrl = new SnoopDialogController();
            // check for console
            if (isConsole)
            {
                handleSnoopConsole(ctrl, listOfPlayers, myTargetIndex);
            }
            else
            {
                handleSnoopSwingGUI(ctrl, listOfPlayers, myTargetIndex, snoopCardToPlay);
            }
            ClueCard snooped = ctrl.showDialog();

            // MAKE CardMesseger to tell next player the snooped card
            toReturn.add(new CardMessage(
                    listOfPlayers.get(myTargetIndex),
                    gameState.getSelfPlayer(), snooped));
        }
        // RETURN the list of object which contain 1 card message
        return toReturn;
    }
    
    private void handleSnoopConsole(SnoopDialogController ctrl, 
            ArrayList<Player> listOfPlayers, int myTargetIndex)
    {
        SnoopConsole view = new SnoopConsole(
                ctrl, listOfPlayers.get(myTargetIndex).getClueCards(), input);
        ctrl.setup(view, listOfPlayers.get(myTargetIndex).getClueCards());
        view.startDialogue();
    }
    
    private void handleSnoopSwingGUI(SnoopDialogController ctrl, 
            ArrayList<Player> listOfPlayers, int myTargetIndex, 
            SnoopCard snoopCardToPlay)
    {
        SnoopDialog view = new SnoopDialog(ctrl, tableGUI,
                true,
                listOfPlayers.get(myTargetIndex).getClueCards(),
                snoopCardToPlay, 
                gameState.getTurnPlayer().getName() + " played this All Snoop",
                "You can snoop on "
                    + listOfPlayers.get(myTargetIndex).getName() + "'s hand");
        ctrl.setup(view, listOfPlayers.get(myTargetIndex).getClueCards());
        view.pack();
        view.setVisible(true);
        view.dispose();
    }

    /**
     * Handles a privateTip played. Returns a list of messages to send to server.
     * 
     * @param privateTip the action card to handle
     * @return list of messages to send to turnPlayer. Empty if an 'all' condition.
     */
    public List<Object> handlePrivateTip(PrivateTipCard privateTip) 
    {
        //INIT a list of card message to return
        List<Object> toReturn = new ArrayList<Object>();
        PrivateTipCardLogic tipLogic = 
            new PrivateTipCardLogic(privateTip,
                gameState.getTurnPlayer(),
                gameState.getSelfPlayer());
        //CALL playPrivateTip on self player to get list of cards
        List<ClueCard> cardsToShowTurnPlayers =
                tipLogic.playPrivateTip(gameState.getSelfPlayer());
        
        // EXISTS appropriate cards to show
        if (cardsToShowTurnPlayers.size() > 0)
        {
            handlePrivateTipExistsCardsToShow(
                    privateTip, cardsToShowTurnPlayers, toReturn);
        }
        else
        {
            PrivateTipFromDialogController ctrl = new PrivateTipFromDialogController();
            // Check for console
            if (isConsole)
            {
                PrivateTipDialogConsole view = 
                        new PrivateTipDialogConsole(ctrl, 
                        cardsToShowTurnPlayers, privateTip, 
                        gameState.getTurnPlayer(), input);
                ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
                view.startDialogue();
            }
            else
            {
                PrivateTipFromDialog view =
                    new PrivateTipFromDialog(ctrl, tableGUI,
                        true, gameState.getTurnPlayer(),
                        privateTip, cardsToShowTurnPlayers);
                ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
                view.pack();
                view.setVisible(true);
                view.dispose();
            }
        }
        //RETURN the list of CardMessage
        return toReturn;
    }
    
    private void handlePrivateTipExistsCardsToShow(PrivateTipCard privateTip, 
            List<ClueCard> cardsToShowTurnPlayers, List<Object> toReturn)
    {
        PrivateTipFromDialogController ctrl = new PrivateTipFromDialogController();
        
        // check for console
        if (isConsole)
        {
            PrivateTipDialogConsole view = 
                    new PrivateTipDialogConsole(
                    ctrl, cardsToShowTurnPlayers, privateTip, 
                    gameState.getTurnPlayer(), input);
            ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
            view.startDialogue();
        }
        else
        {
            PrivateTipFromDialog view =
                new PrivateTipFromDialog(ctrl, tableGUI,
                    true, gameState.getTurnPlayer(),
                    privateTip, cardsToShowTurnPlayers);
            ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        // IF privteTip is regular
        if (!privateTip.isAll())
        {
            ClueCard cardToShow = ctrl.showDialog(); 
            // MAKE card message which user's choice, and add it to return list
            toReturn.add(new CardMessage(
                    gameState.getTurnPlayer(), 
                    gameState.getSelfPlayer(), 
                    cardToShow));
            // MAKE a string "<SelfPlayer> shows to <turnPlayer> a tip"
            gameState.addToHistoryLog(gameState.getSelfPlayer().getName()
                    + " shows " + gameState.getTurnPlayer().getName()
                    + " a clue in response to a Private Tip.");
            // ADD the string to the return list
            toReturn.add(gameState.getHistoryLog());
        }
    }
    
    /**
     * Handles Sleuth being played. Returns what was sleuthed to turnPlayer.
     * 
     * @param sleuth the action card to handle
     * @return a message to send to turnPlayer and history log
     */
    public List<Object> handleSleuth(SuperSleuthCard sleuth)
    {
        List<Object> toReturn = new ArrayList<Object>();
        
        // MAKE SuperSleuthCardLogic with this sleuth card
        SuperSleuthCardLogic sleuthLogic = 
                new SuperSleuthCardLogic(sleuth, gameState.getTurnPlayer());
        
        // CALL playSuperSleuth on self Player to get the list of option
        List<ClueCard> cardToGive = 
                sleuthLogic.playSuperSleuth(gameState.getSelfPlayer());
        
        SleuthOnMeDialogController ctrl = new SleuthOnMeDialogController();
        // check for console
        if (isConsole)
        {
            SleuthOnMeDialogConsole view = 
                    new SleuthOnMeDialogConsole(ctrl, cardToGive, input);
            ctrl.setup(isConsole, view, cardToGive);
            view.startDialogue();
        }
        else
        {
            SleuthOnMeDialog view = new SleuthOnMeDialog(ctrl, tableGUI, true, sleuth, 
                    cardToGive, gameState.getTurnPlayer().getName());
            ctrl.setup(isConsole, view, cardToGive);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        // PROMPT user which card to give turnPlayer
        
        ClueCard toGiveTurnPlayer = ctrl.showDialog();
        
        // MAKE a card message with user's choice
        toReturn.add(new CardMessage(
                gameState.getTurnPlayer(), 
                gameState.getSelfPlayer(), 
                toGiveTurnPlayer));
        
        // RETURN card message
        return toReturn;
    }
    
    /**
     * Handles a SuggestionCard played. Returns a message with disproven card.
     * 
     * @param logic logic of the played SuggestionCard
     * @return a message of the disproven card and message. Empty if swap
     */
    public List<Object> handleSuggestion(SuggestionCardLogic logic)
    {
        List<Object> toReturn = new ArrayList<Object>();
        // IF not turnPlayer
        if (!isTurn())
        {
            // IF the suggestionLogic is suggestion and it was for me to disprove
            if((!logic.isMoved()) 
                    && (logic.getDisprover().equalsName(gameState.getSelfPlayer())))
            {
                handleSuggestionMeDisprove(logic, toReturn);
            }
            // ELSE IF the destination is on the DM Pile
            else if (gameState.getTable().getPile().contains(logic.getDestination()))
            {
                // CALL SwapWithTable
                logic.swapDMWithTable(gameState.getTable(), 
                        gameState.getPlayers().peek());
            }
            // ELSE IF destination is on other player hand
            else 
            {
                List<Player> playerList = new ArrayList<Player>(gameState.getPlayers());
                
                // FIND the player with the target destination
                for (Player targetPlayer : playerList)
                {
                    // CHECK if the player has the target destination
                    if (targetPlayer.getDestination().equals(logic.getDestination()))
                    {
                        // SWAP turn player's dm's with the target player
                        logic.swapDMWithPlayer(gameState.getTurnPlayer(), targetPlayer);
                        break;
                    }
                }
            }
        }
        gameState.setChangedGameState();
        return toReturn;
    }
    
    private void handleSuggestionMeDisprove(SuggestionCardLogic logic, 
            List<Object> toReturn)
    {
        // CALL disprove on this logic
        List<ClueCard> toDisprove = logic.disprove(gameState.getSelfPlayer()); 

        // PROMPT user which card to use to disprove
        if (toDisprove.size() > 0) 
        {
            DisproveController ctrl = new DisproveController();
            // check for console
            if(isConsole)
            {
                DisproveConsole view = new DisproveConsole(ctrl, toDisprove, input);
                ctrl.setup(view, logic, toDisprove);
                view.startDialogue();
            }
            else
            {
                Disprove view = 
                    new Disprove(ctrl, tableGUI, true, logic, toDisprove);
                ctrl.setup(view, logic, toDisprove);
                view.pack();
                view.setVisible(true);
                view.dispose();

            }
            ClueCard cardToDisprove = ctrl.showDialog();

            // MAKE a card message with that a return it
            toReturn.add(new CardMessage(
                    gameState.getTurnPlayer(), 
                    gameState.getSelfPlayer(), 
                    cardToDisprove));           

            // WRITE to History "<selfPlayer> disprove <turnPlayer>'s suggestion"
            gameState.addToHistoryLog(gameState.getSelfPlayer().getName() 
                    + " disproved " + gameState.getTurnPlayer().getName() 
                    + "'s suggestion.");
            // ADD the History to the return list
            toReturn.add(gameState.getHistoryLog());
        }
    }
    
    /**
     * Handles an accusation made by turnPlayer.
     * 
     * @param accusation the Suspect, Vehicle, and Destination of the accusation
     */
    public void handleSolution(AccusationMessage accusation)
    {
        // VIEW accusation results
        accusation.setShowTo(gameState.getSelfPlayer());
        AccusationResultController ctrl = new AccusationResultController();
        // close connection immediately if correct to avoid being connected to lobby
        if (accusation.isCorrect())
        {
            try
            {
                client.closeConnection();
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }
        
        // check for console
        if (isConsole)
        {
            AccusationResultConsole view = new AccusationResultConsole(ctrl, accusation);
            ctrl.setup(view);
            view.startDialogue();
        }
        else
        {
            AccusationResult view = 
                    new AccusationResult(ctrl, tableGUI, true, accusation);
            ctrl.setup(view);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        
        // IF the solution is incorrect, set the player out.
        if (!accusation.isCorrect())
        {    
            // NOTIFY this player that the previous player accuse this and lost the game
            HistoryLog log = gameState.getHistoryLog();
            log.addToLog(accusation.getCreator().getName() + " is OUT");
            gameState.setHistoryLog(log);
            
            gameState.setPlayerOut(accusation.getCreator());
        }
        else 
        {
            gotWinner = true;
            // handle replaying game offline, i.e. disconnected from server
            endGame(false);
        }
    }
    
    /**
     * Updates the HistoryLog to the given HistoryLog.
     * 
     * @param log the new HistoryLog
     */
    public void handleHistoryLog(HistoryLog log)
    {
        // UPDATE the history log -- setChanged/notifyObservers
        gameState.setHistoryLog(log);
    }
    
    /**
     * Performs an action depending on the given
     * <code>ActionCard</code>. Usually results in sending a
     * <code>CardMessage</code> to a specific
     * <code>Player</code>.
     *
     * @param action a certain action to be performed
     * by <code>this Player</code>
     * @return a list objects which will be sent to the server
     */
    public List<Object> performAction(ActionCard action)
    {
        // INIT a list of message that will be send to others players
        List<Object> toReturn = new ArrayList<Object>();
        // IF action card is Snoop card
        if (action instanceof SnoopCard)
        {
            //CALL the performSnoop with parameter is action
            toReturn = performSnoop(action);
        }
        //ELSE IF action card is Sleuth card
        else if (action instanceof SuperSleuthCard) 
        {
            //CALL the performSleuth with parameter is action
            toReturn = performSleuth(action);
        }
        //ELSE IF action card is PrivateTip card
        else if (action instanceof PrivateTipCard) 
        {
            //CALL the performPrivateTip with parameter is action\
            toReturn = performPrivateTip(action);
        }
        //ELSE IF action card is Suggestion card
        else if (action instanceof SuggestionCard) 
        {
            //CALL the performSuggestion 
            toReturn = performSuggestion(action);
            //RESET the temp suggestionCardLogic field
            tempSuggestLogic = null;
        }
        // RETURN the list of object to be sent
        return toReturn;
    }
    
    /**
     * Helper method to perform action of Snooping.
     * 
     * @param action is the ActionCardLogic for this action
     * @return a list of message needed to send out
     */
    private List<Object> performSnoop(ActionCard action) 
    {
        //INIT a list of card messeger
        List<Object> toReturn = new ArrayList<Object>();
        //INIT a SnoopCardLogic
        SnoopCardLogic snoopLogic = 
                new SnoopCardLogic((SnoopCard) action, gameState.getTurnPlayer());
        
        //IF action card is not all snoop
        if (!((SnoopCard)action).isAllSnoop())
        {
            performSingleSnoop(action, toReturn);
        }
        //ELSE action card is all snoop
        else
        {
            performAllSnoop(action, snoopLogic, toReturn);
        }
        //RETURN the list of object
        return toReturn;
    }
    
    private void performSingleSnoop(ActionCard action, List<Object> toReturn)
    {
        //OBTAIN the target player from user
        List<Player> playersToSnoop = new ArrayList<Player>(gameState.getPlayers());

        SnoopOnPlayerDialogController sctrl = new SnoopOnPlayerDialogController();
        // check for console
        if (isConsole)
        {
            SnoopOnPlayerConsole view = 
                    new SnoopOnPlayerConsole(sctrl, playersToSnoop, input);
            sctrl.setup(view, playersToSnoop);
            view.startDialogue();
        }
        else
        {
            SnoopOnPlayerDialog view = 
                new SnoopOnPlayerDialog(sctrl, tableGUI, true, playersToSnoop);
            sctrl.setup(view, playersToSnoop);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        Player targetPlayer = sctrl.showDialog();

        //OBTAIN the choosen card from user
        SnoopDialogController ctrl = new SnoopDialogController();
        // check for console
        if (isConsole)
        {
            SnoopConsole view = 
                    new SnoopConsole(ctrl, targetPlayer.getClueCards(), input);
            ctrl.setup(view, targetPlayer.getClueCards());
            view.startDialogue();
        }
        else
        {
            SnoopDialog view = new SnoopDialog(ctrl, tableGUI,
                    true,
                    targetPlayer.getClueCards(),
                    (SnoopCard) action, "You played this snoop card",
                    "You can snoop on " + targetPlayer.getName() + "'s hand");
            ctrl.setup(view, targetPlayer.getClueCards());
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        Card chosenClueCard = ctrl.showDialog();

        //INIT a CardMessenger(ClueCard) to tell target player the snooped card
        //ADD this CardMessenger to the return list
        toReturn.add(new CardMessage(targetPlayer, 
                        gameState.getTurnPlayer(), chosenClueCard));

        // WRITE to log "<turnPlayer> snooped on <targetPlayer>"
        gameState.addToHistoryLog(gameState.getTurnPlayer().getName()
                + " snooped on " + targetPlayer.getName());
        // ADD history log to the return list
        toReturn.add(gameState.getHistoryLog());
    }
    
    private void performAllSnoop(ActionCard action, SnoopCardLogic snoopLogic,
            List<Object> toReturn)
    {
        // WRITE to log "<turnPlayer> play this <snoopCard>"
        gameState.addToHistoryLog(gameState.getTurnPlayer().getName()
                + " plays an All-Snoop card on the "
                + ((SnoopCard)action).getDirection().toString());
        // ADD history log to the return list
        toReturn.add(gameState.getHistoryLog());

        // playSnoop method with the next player according to direction
        List<Player> playersList = new ArrayList<Player>(gameState.getPlayers());
        int indexTargetPlayer;
        // GET correct target player index
        if (((SnoopCard)action).getDirection().isRight())
        {
            indexTargetPlayer = playersList.size()-1;
        }
        else
        {
            indexTargetPlayer = 1;
        }

        List<ClueCard> cardToSnoop = 
                snoopLogic.playSnoop(playersList.get(indexTargetPlayer));
        
        SnoopDialogController ctrl = new SnoopDialogController();
        // check for console
        if (isConsole)
        {
            SnoopConsole view = new SnoopConsole(ctrl, cardToSnoop, input);
            ctrl.setup(view, cardToSnoop);
            view.startDialogue();
        }
        else
        {
            SnoopDialog view = new SnoopDialog(ctrl, tableGUI,
                    true,
                    cardToSnoop,
                (SnoopCard)action, "You played this Snoop card",
                "You can snoop on " + playersList.get(indexTargetPlayer).getName()
                + "'s hand");
            ctrl.setup(view, cardToSnoop);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        Card chosenClueCard = ctrl.showDialog();

        // INIT a CardMessenger(with ClueCard) to tell target player the snooped card
        toReturn.add(new CardMessage(playersList.get(indexTargetPlayer),
            gameState.getTurnPlayer(), (ClueCard)chosenClueCard));

        // CREATE CardMessage with SnoopCard to all player player -- except self
        for(Player player : playersList)
        {
            // DO every player except self
            if (!(player.equals(gameState.getSelfPlayer())))
            {
                toReturn.add(new CardMessage(player,
                        gameState.getSelfPlayer(), (SnoopCard)action));
            }
        }
        // SET the expectedReceivingCard to 1 (1 player will snoop on me)
        expectedReceivingCard = 1;
    }
    
    /**
     * Helper method to perform action of Suggestion.
     * 
     * @param action is the ActionCardLogic for this action
     * @return a list of objects relating to the suggestion
     */
    private List<Object> performSuggestion(ActionCard action)
    {
        //INIT a list of object to return
        List<Object> toReturn = new ArrayList<Object>();
        Destination myDM = gameState.getSelfPlayer().getDestination();
        //OBTAIN user's action
        if (((SuggestionCard)action).isCurrentSuggestion())
        {
            performCurrentSuggestion(action, myDM);
        }
        else
        {
            performAnySuggestion(action);
        }
        
        //IF user made suggestion
        if (!tempSuggestLogic.isMoved())
        {
            performSuggestionHelper(action, toReturn);
        }
        //ELSE user swapped destination
        else
        {
            performSwap(toReturn);
        }
        //RETURN the list of object to be sent
        return toReturn;
    }
    
    private void performCurrentSuggestion(ActionCard action, Destination myDM)
    {
        SuggestionAndMoveDialogController ctrl = 
                new SuggestionAndMoveDialogController();
        // check for console
        if (isConsole)
        {
            SuggestionAndMoveConsole view = 
                    new SuggestionAndMoveConsole(ctrl, input);
            ctrl.setup(view, gameState.getTable().getTheme(), myDM, 
                    (SuggestionCard)action, gameState.getTurnPlayer());
            view.startDialogue();
        }
        else
        {
            SuggestionAndMoveDialog view = 
                    new SuggestionAndMoveDialog(ctrl, tableGUI, true,
                    myDM, (SuggestionCard)action, gameState.getTable().getTheme());
            ctrl.setup(view, gameState.getTable().getTheme(), myDM, 
                    (SuggestionCard)action, gameState.getTurnPlayer());
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        tempSuggestLogic = ctrl.showDialog(); 
    }
    
    private void performAnySuggestion(ActionCard action)
    {
        SuggestionDialogController ctrl = new SuggestionDialogController();
        // check for console
        if (isConsole)
        {
            SuggestionConsole view = new SuggestionConsole(ctrl, input);
            ctrl.setup(view, gameState, (SuggestionCard)action);
            view.startDialogue();
        }
        else
        {
            SuggestionDialog view = new SuggestionDialog(ctrl, tableGUI, true,
                (SuggestionCard)action, gameState.getTable().getTheme());
            ctrl.setup(view, gameState, (SuggestionCard)action);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        tempSuggestLogic = ctrl.showDialog();
    }
    
    private void performSuggestionHelper(ActionCard action, List<Object> toReturn)
    {
        // WRITE to log "<turnPlayer> suggest this <suggestion>"
        gameState.addToHistoryLog(gameState.getTurnPlayer().getName() 
            + " played this card: " + action.getActionText()
            + "\nand made this suggestion: " + tempSuggestLogic.getGuess() + ".");
        // ADD history log to the return list
        toReturn.add(gameState.getHistoryLog());

        // CALL disprovable to check if any one can disprove this suggestion
        // IF the guess is disprovable
        if (tempSuggestLogic.isDisprovable(gameState.getPlayers()))
        {
            // ADD the suggestionLogic to the return object
            toReturn.add(tempSuggestLogic);
            // SET expectedReceivingCard to 1, which is the disprove card
            expectedReceivingCard = 1;
        }
        // ELSE no one can disprove it
        else
        {
            // WRITE to log "<turnPlayer> suggest this <suggestion>"
            gameState.addToHistoryLog("No one can disprove "
                    + gameState.getTurnPlayer().getName() + "'s guess.");
            // ADD history log to the return list
            toReturn.add(gameState.getHistoryLog());

            // NOTIFY user that no one can disprove it
            NoOneDisproveController no1Ctrl = new NoOneDisproveController();
            // check for console
            if(isConsole)
            {
                NoOneDisproveConsole no1Console = new
                        NoOneDisproveConsole(tempSuggestLogic.getGuess());
                no1Ctrl.setup(tempSuggestLogic.getGuess(), no1Console);
                no1Console.startDialogue();
            }
            else
            {
                NoOneDisproveDialog no1Dialog = new NoOneDisproveDialog(tableGUI, 
                        true, tempSuggestLogic.getGuess(), no1Ctrl);
                no1Ctrl.setup(tempSuggestLogic.getGuess(), no1Dialog);
                no1Dialog.pack();
                no1Dialog.setVisible(true);
            }
        }
    }
    
    private void performSwap(List<Object> toReturn)
    {   
        //IF user's desired destination is on the table
        if (gameState.getTable().getPile().contains(
                tempSuggestLogic.getDestination()))
        { 
            //CALL swapDMWithTable
            tempSuggestLogic.swapDMWithTable(gameState.getTable(),
                    gameState.getTurnPlayer());
            // WRITE to log "<turnPlayer> move to new <destination>"
            gameState.addToHistoryLog(gameState.getTurnPlayer().getName()
                + " moved to " + tempSuggestLogic.getDestination().getName() + ".") ;
        }
        else
        {
            Player toSwap = null;
            //DETERMINE the player who is holding the desired destination
            for (Player player : gameState.getPlayers())
            {
                // CHECK for player with the destination
                if (player.getDestination().equals(
                        tempSuggestLogic.getDestination()))
                {
                    toSwap = player;
                    // WRITE to log "<turnPlayer> move to new <destination>"
                    gameState.addToHistoryLog(gameState.getTurnPlayer().getName()
                        + " moved to " + tempSuggestLogic.getDestination().getName() 
                        + " (swapped with " + player.getName() + " ).") ;
                    break;
                }
            }
            //CALL swapDMWithPlayer
            tempSuggestLogic.swapDMWithPlayer(gameState.getTurnPlayer(), toSwap);
        }

        // ADD history log to the return list
        toReturn.add(gameState.getHistoryLog());
        //ADD the suggestionLogic to the return object
        toReturn.add(tempSuggestLogic);
        // CALL finishingTurn and add its returned list to this return
    }
    
    /**
     * Helper method to perform action of Sleuth.
     * 
     * @param action is the ActionCardLogic for this action
     * @return a list of message needed to send out
     */
    private List<Object> performSleuth(ActionCard action)
    {
        //INIT a list of card message
        List<Object> toReturn = new ArrayList<Object>();
        
        // WRITE to log "<turnPlayer> play this <sleuthCard> : Everyone shows...."
        gameState.addToHistoryLog(gameState.getTurnPlayer().getName()
            + " played this Super Sleuth card: " + action.getActionText() + ".");
        // ADD history log to the return list
        toReturn.add(gameState.getHistoryLog());
        
        // SET expectedReceivingCard to 0
        expectedReceivingSleuth = 0;
        SuperSleuthCardLogic sleuthLogic = 
            new SuperSleuthCardLogic((SuperSleuthCard)action,
                gameState.getTurnPlayer());      
        
        //FOR each player who has an appropriate card to show, except turn player
        for (Player player : gameState.getPlayers())
        {
            // CHECK for a player with an appropriate card to show
            if (!player.equals(gameState.getTurnPlayer())
                && sleuthLogic.playSuperSleuth(player).size() > 0)
            {         
                //INCREMENT expectedReceivingCard
                expectedReceivingSleuth++;
                //MAKE a card messenger sending this action card to player
                //ADD this card messeger to the list of card message
                toReturn.add(new CardMessage(player,
                    gameState.getTurnPlayer(), (SuperSleuthCard)action));
            }
        }
        
        //IF expectedReceivingSleuth is 0, means no one has card to show
        if (expectedReceivingSleuth == 0)
        {
            performSleuthNoCardToShow(toReturn);
        }
        else
        {
            performSleuthHelper(action, toReturn);
            
        }
        //RETURN the list of card message
        return toReturn;
    }
    
    private void performSleuthNoCardToShow(List<Object> toReturn)
    {
        gameState.addToHistoryLog("No one can respond to " 
            + gameState.getTurnPlayer().getName() + "'s Super Sleuth card.");
        toReturn.add(gameState.getHistoryLog());
            
        ArrayList<CardMessage> tempMessage = new ArrayList<CardMessage>();
        SleuthResultDialogController ctrl = new SleuthResultDialogController();
        // check for console
        if (isConsole)
        {
            SleuthResultDialogConsole view = 
                    new SleuthResultDialogConsole(ctrl, tempMessage);
            ctrl.setup(isConsole, view);
            view.startDialog();
        }
        else
        {
            SleuthResultDialog view = 
                    new SleuthResultDialog(ctrl, tableGUI, true, tempMessage);
            ctrl.setup(isConsole, view);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
    }
    
    private void performSleuthHelper(ActionCard action, List<Object> toReturn)
    {
        // SEND to server directly so that other players can pick card 
        // to give turnPlayer sooner
        for (Object object : toReturn)
        {
            try
            {
                client.sendToServer(object);
            }
            catch (IOException exception) 
            {
                System.out.println("ERROR: Failed to send to server");
            }
        }
        // check for console
        if (isConsole)
        {
            SleuthDialogController ctrl = new SleuthDialogController();
            SleuthDialogConsole sleuthDialog = new SleuthDialogConsole(ctrl);
            ctrl.setup(sleuthDialog, isConsole);
            sleuthDialog.startDialog();
        }
        else
        {
            SleuthDialogController ctrl = new SleuthDialogController();
            SleuthDialog sleuthDialog = 
                    new SleuthDialog(tableGUI, true, action, ctrl);
            ctrl.setup(sleuthDialog, !isConsole);
            sleuthDialog.pack();
            sleuthDialog.setVisible(true);
            sleuthDialog.dispose();
        }
        toReturn.clear();
    }
    
    /**
     * Helper method to perform action of PrivateTip.
     * 
     * @param action is the ActionCardLogic for this action
     * @return a list of message needed to send out
     */
    private List<Object> performPrivateTip(ActionCard action)
    {
        List<Object> toReturn = new ArrayList<Object>();
        //OBTAIN user's target player to hand this private tip card to
        Queue<Player> players = gameState.getPlayers();
        List<Player> toChoose = new ArrayList<Player>();
        
        // BUILD player selection list
        for (Player player : players)
        {
            // ADD everyone except yourself
            if (!player.equals(gameState.getTurnPlayer()))
            {
                toChoose.add(player);
            }
        }
        
        PrivateTipToDialogController ctrl = new PrivateTipToDialogController();
        // check for conosle
        if (isConsole)
        {
            PrivateTipToDialogConsole view = 
                    new PrivateTipToDialogConsole(ctrl, toChoose, input);
            ctrl.setup(isConsole, view, toChoose);
            view.startDialogue();
        }
        else
        {
            PrivateTipToDialog view = 
                    new PrivateTipToDialog(ctrl, tableGUI, true, toChoose);
            ctrl.setup(isConsole, view, toChoose);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        
        Player targetPlayer = ctrl.showDialog();
        
        //WRITE to log "<turnPlayer> play a private tip on <targetPlayer>"
        gameState.addToHistoryLog(gameState.getTurnPlayer().getName() 
            + " played a Private Tip on " + targetPlayer.getName() + ".");
        //ADD HistoryLog to the return list
        toReturn.add(gameState.getHistoryLog());
        
        PrivateTipCardLogic tipLogic = 
             new PrivateTipCardLogic((PrivateTipCard)action,
                gameState.getTurnPlayer(), targetPlayer);
               
        //IF this PrivateTip card is showAll
        if (((PrivateTipCard)action).isAll())
        {
            performPrivateTipIsAll(tipLogic, targetPlayer, action, toReturn);
        }
        //ELSE IF the target player has a card to show
        else if (tipLogic.playPrivateTip(targetPlayer).size() > 0)
        {
            performPrivateTipHasCardToShow(targetPlayer, action, toReturn);
        }
        else
        {
            performPrivateTipHasNoCardToShow(tipLogic, targetPlayer, action, toReturn);
        }
        //RETURN the list of card message
        return toReturn;
    }
    
    private void performPrivateTipIsAll(PrivateTipCardLogic tipLogic, 
            Player targetPlayer, ActionCard action, List<Object> toReturn)
    {
        // DISPLAY all to turnPlayer
        List<ClueCard> toShow = tipLogic.playPrivateTip(targetPlayer);

        // EXISTS approriate cards to show
        PrivateTipResponseController rctrl = new PrivateTipResponseController();
        // check for console
        if (isConsole)
        {
            PrivateTipResponseConsole view = 
                    new PrivateTipResponseConsole(rctrl, toShow, tipLogic);
            rctrl.setUp(view, isConsole);
            view.startDialogue();
        }
        else
        {
            PrivateTipResponseDialog view = 
                    new PrivateTipResponseDialog(
                    rctrl, tableGUI, true, toShow, tipLogic);
            rctrl.setUp(view, isConsole);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        // MAKE a card message with this privatetip card and add to return list
        toReturn.add(new CardMessage(targetPlayer,
                gameState.getTurnPlayer(), (PrivateTipCard)action));
    }
    
    private void performPrivateTipHasCardToShow(Player targetPlayer, 
            ActionCard action, List<Object> toReturn)
    {
        // SET expectedReceivingCard to 1
        expectedReceivingCard = 1;
        // MAKE a card message with this privatetip card and add to return list
        toReturn.add(new CardMessage(targetPlayer,
                gameState.getTurnPlayer(), (PrivateTipCard)action));
    }
    
    private void performPrivateTipHasNoCardToShow(PrivateTipCardLogic tipLogic, 
            Player targetPlayer, ActionCard action, List<Object> toReturn)
    {
        // NOTIFY user that target player does not have card to show
        List<ClueCard> toShow = new ArrayList<ClueCard>();
        PrivateTipResponseController rctrl = new PrivateTipResponseController();
        // check for console
        if (isConsole)
        {
            PrivateTipResponseConsole view = 
                    new PrivateTipResponseConsole(rctrl, toShow, tipLogic);
            rctrl.setUp(view, isConsole);
            view.startDialogue();
        }
        else
        {
            PrivateTipResponseDialog view = 
                    new PrivateTipResponseDialog(
                    rctrl, tableGUI, true, toShow, tipLogic);
            rctrl.setUp(view, isConsole);
            view.pack();
            view.setVisible(true);
            view.dispose();
        }
        toReturn.add(new CardMessage(targetPlayer,
                gameState.getTurnPlayer(), (PrivateTipCard)action));
    }
    
    /**
     * Add a card message to the GameState in order to be handled.
     * 
     * @param message the card message to be handled
     */
    public void addCardMessage(CardMessage message)
    {
        gameState.addCardMessage(message);
    }
    
    /**
     * Ends the game and signals the other clients to end as well.
     * @param testMode for testing
     */
    public void endGame(boolean testMode)
    {
        int numberOfLosers = 0;
        
        // Count losers
        for(Player player : gameState.getPlayers()) 
        {
            //IF player is not in game
            if(!player.isInGame()) 
            {
                numberOfLosers++;
            }
        }
        
        //IF game end cause of someone win or other reason
        if (!gotWinner)
        {
            handleEndGame();
        }
        
        // SET GameState to gameOver
        gameState.makeGameOver();
        HistoryLog log = gameState.getHistoryLog();
        log.addToLog("\nEND GAME\n");
        gameState.setHistoryLog(log);
        //Notify/Setchanges to observers
        ReplayController replayCont;
        
        // check for console
        if (isConsole)
        {
            ReplayConsole replayCons = new ReplayConsole(input);
            replayCont = new ReplayController(replayCons);
            replayCons.setController(replayCont);
            replayCons.startDialogue();
        }
        else
        {
            ReplayGame replay = new ReplayGame(tableGUI, true);
            replayCont = new ReplayController(replay);
            replay.setController(replayCont);
            replay.pack();
            replay.setVisible(true);
        }
        //For testing
        if (!testMode)
        {
            handleReplayGame(replayCont.showDialog());
        }
        
    }
    
    /**
     * End the game when there is no winner.
     */
    public void handleEndGame()
    {
        NoWinnerController noWinCtrl = new NoWinnerController();
        // check for console
        if (isConsole)
        {
            NoWinnerConsole noWinConsole = 
                    new NoWinnerConsole(noWinCtrl, client.getSolution());
            noWinCtrl.setUp(noWinConsole, client.getSolution());
            noWinConsole.startDialog();
        }
        else 
        {
            NoWinnerDialog noWinDialog = new NoWinnerDialog(tableGUI, true, 
                    client.getSolution(), noWinCtrl);
            noWinCtrl.setUp(noWinDialog, client.getSolution());
            noWinDialog.pack();
            noWinDialog.setVisible(true);
        }
    }
    
    /**
     * Replaying the game
     * 
     * @param replay is user's decision to play again or not
     */
    public void handleReplayGame(boolean replay)
    {
        // replay game screen
        if (replay)
        {
            Lobby oldLobby = lobby;
            try
            {
                client.closeConnection();
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
            lobby = new Lobby(oldLobby.getMinPlayersAllowed(), 
                    oldLobby.getMaxPlayersAllowed(), 
                    lobby.getServerIP().equals("localhost"));
            // must check for testing mode
            if (oldLobby.isTestingMode())
            {
                lobby.setTestingMode(oldLobby.getClueDeckFile(), 
                        oldLobby.getActionDeckFile());
            }
            lobby.setConsoleMode(oldLobby.getConsoleMode());
            lobby.joinLobby();
            // open up Lobby gui
            if (!lobby.getConsoleMode())
            {
                replayGUIView();
            }
            else
            {
                // check for input file
                lobby.setInputMode(oldLobby.getInputMode());
                MainWindowController controller = new MainWindowController();
                ConsoleLobbyPhase mainWindow = 
                        new ConsoleLobbyPhase(controller, lobby, input);
                controller.setup(mainWindow, lobby, true);
                mainWindow.lobbyPhase();
            }
        }
        else
        {
            System.exit(0);
        }
    }
    
    private void replayGUIView()
    {
        ((I_GameTable)tableGUI).notepadEnable(false);
        tableGUI.setVisible(false);
        
        LobbyController lobbyCtrl = new LobbyController();
        ScreenNameController screenControl = new ScreenNameController();
        LobbyGUI lobbyGui = new LobbyGUI(lobby, lobbyCtrl);
        lobby.addObserver(lobbyGui);
        lobbyCtrl.setup(lobbyGui, lobby, false, lobbyGui);
        lobbyGui.setVisible(true);

        ScreenNameDialog screenName = 
                new ScreenNameDialog(lobbyGui, screenControl, true);
        screenControl.setup(screenName, lobby, false, lobbyGui);
        screenName.setLocationRelativeTo(lobbyGui);
        screenName.setVisible(true);
    }
    
    /**
     * Set the this class' Lobby instance to the parameter.
     * 
     * @param lobby new lobby reference for this class
     */
    public void setLobby(Lobby lobby)
    {
        this.lobby = lobby;
    }
    
    /**
     * Set the this Scanner to the Scanner of previous classes
     * 
     * @param otherInput the Scanner to change this object's scanner
     */
    public void setScanner(Scanner otherInput)
    {
        this.input = otherInput;
    }
    
    /**
     * Retrieves the method of input, which is the Scanner.
     * 
     * @return the scanner used for input
     */
    public Scanner getScanner()
    {
        return input;
    }
}
