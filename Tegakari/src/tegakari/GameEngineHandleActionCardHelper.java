package tegakari;

import guiConsoleController.SnoopConsole;
import guiConsoleController.PrivateTipFromDialogController;
import guiConsoleController.PrivateTipDialogConsole;
import guiConsoleController.DisproveConsole;
import guiConsoleController.SleuthOnMeDialogController;
import guiConsoleController.SleuthOnMeDialogConsole;
import guiConsoleController.SnoopDialogController;
import guiConsoleController.DisproveController;
import allguis.*;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

/**
 * The GameEngineHandleActionCardHelper represents 
 * the actions needed by the GameEngine class.
 *
 * @author Jonathan Molina
 * @version 2/28/15 Version 2.0
 */
public class GameEngineHandleActionCardHelper implements Serializable
{
    private final GameEngine engine;
    private GameState gameState;
    private boolean isConsole;
    
    /**
     * Constructor for the class.
     * 
     * @param otherEngine the game engine to be used
     * @param console whether the console UI is being used or not
     */
    public GameEngineHandleActionCardHelper(GameEngine otherEngine, boolean console)
    {
        this.engine = otherEngine;
        this.gameState = otherEngine.getGameState();
        this.isConsole = console;
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
        if (engine.getGameState().getSelfPlayer().isInGame())
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
                ctrl, 
                listOfPlayers.get(myTargetIndex).getClueCards(), 
                engine.getScanner());
        ctrl.setup(view, listOfPlayers.get(myTargetIndex).getClueCards());
        view.startDialogue();
    }
    
    private void handleSnoopSwingGUI(SnoopDialogController ctrl, 
            ArrayList<Player> listOfPlayers, int myTargetIndex, 
            SnoopCard snoopCardToPlay)
    {
        SnoopDialog view = new SnoopDialog(ctrl, engine.getGameTableGUI(),
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
                        gameState.getTurnPlayer(), engine.getScanner());
                ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
                view.startDialogue();
            }
            else
            {
                PrivateTipFromDialog view =
                    new PrivateTipFromDialog(ctrl, engine.getGameTableGUI(),
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
                    gameState.getTurnPlayer(), engine.getScanner());
            ctrl.setup(isConsole, view, cardsToShowTurnPlayers, privateTip);
            view.startDialogue();
        }
        else
        {
            PrivateTipFromDialog view =
                new PrivateTipFromDialog(ctrl, engine.getGameTableGUI(),
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
                    new SleuthOnMeDialogConsole(ctrl, cardToGive, engine.getScanner());
            ctrl.setup(isConsole, view, cardToGive);
            view.startDialogue();
        }
        else
        {
            SleuthOnMeDialog view = new SleuthOnMeDialog(
                    ctrl, engine.getGameTableGUI(), true, sleuth, 
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
        if (!engine.isTurn())
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
                DisproveConsole view = 
                        new DisproveConsole(ctrl, toDisprove, engine.getScanner());
                ctrl.setup(view, logic, toDisprove);
                view.startDialogue();
            }
            else
            {
                Disprove view = 
                    new Disprove(
                        ctrl, engine.getGameTableGUI(), true, logic, toDisprove);
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

}
