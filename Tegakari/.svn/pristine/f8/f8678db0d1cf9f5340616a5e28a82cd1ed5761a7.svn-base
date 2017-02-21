package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * This class is for RobotEngineInIdle so that it doesn't have fan out
 * complexity
 * @author TTStarck
 */
public class RobotEngineInIdleMethods implements Serializable
{
    /**
     * A robot state to use
     */
    private RobotState state;
    /**
     * Constructor
     * @param state the RobotState
     */
    public RobotEngineInIdleMethods(RobotState state)
    {
        this.state = state;
    }
    
    /** 
     * Helper method to handle <code>SnoopCard</code> request.
     * @param snoopCard is the <code>CardMessage</code> containing the 
     *        <code>SnoopCard</code> that other <code>Player</code> snoop on me
     * @param level the AILevel of the robot
     * @return the list of object to return to the server. This list will 
     *         contain the <code>ClueCard</code> that <code>Robot</code>
     *         choose to respond to turn <code>Player</code>'s action request.
     *         Return an empty list if there is no <code>ClueCard</code> to show
     */
    public List<Object> handleSnoopCard(CardMessage snoopCard, AILevel level)
    {
        //System.out.println("\tHandling snoop card");
        List<Object> out = new ArrayList<Object>();
        // APPLIES only if player is still in the game
        if (state.getSelf().isInGame())
        { 
            //System.out.println("\trobot in game");
            // INIT a RobotSnoopLogic
            RobotSnoopLogic snoop = new RobotSnoopLogic();
            SnoopCard card = (SnoopCard) snoopCard.getCards().get(0);
            // IF the snoop card is AllSnoop
            if (card.isAllSnoop()) 
            {
                //System.out.println("\tAll snoop");
                // COMPUTE the next player according to direction on snoop card
                ArrayList<Player> listOfPlayers = 
                    new ArrayList<Player>(state.getPlayers());
                int myIndex = listOfPlayers.indexOf(state.getSelf());
                int myTargetIndex = 0;
                // if the direction is left
                if (card.getDirection() == Direction.LEFT) 
                {
                    // my index is max for the list
                    if (myIndex == listOfPlayers.size() - 1)
                    {
                        myTargetIndex = 0;
                    }
                    // anything else
                    else
                    {
                        myTargetIndex = myIndex + 1;
                    }
                }
                // direciton is right
                else 
                {
                    // my index is 0 in the list
                    if (myIndex == 0)
                    {
                        myTargetIndex = listOfPlayers.size() - 1;
                    }
                    // anything else
                    else
                    {
                        myTargetIndex = myIndex - 1;
                    }
                }
                
                //System.out.println("\tmy target to snoop is: " + 
                //listOfPlayers.get(myTargetIndex).getName());
                // CALL responseToActionRequest on the RobotSnoopLogic.
                // this should be from RobotState
                Notepad note = state.getNote();
                out = new ArrayList<Object>();
                List<ClueCard> list = snoop.responseToActionRequest(card, 
                        note, listOfPlayers.get(myTargetIndex), 
                        listOfPlayers.get(myIndex), level);
                //System.out.println("\t1 mean succesful 
                //snoop on a card: " + list.size());
                // checking if the list is null
                if (list != null && list.size() > 0)
                {
                    out.add(new CardMessage(listOfPlayers.get(myTargetIndex),
                        state.getSelf(), list.get(0)));
                    //System.out.println("\tadded a card message to send to
                    //" + listOfPlayers.get(myTargetIndex).getName());
                }
                //System.out.println("\tdone in handle snoop");
            }
        // ENDIF
        }
        // RETURN the card this robot just snoop on other
        return out;
    }
    
    /** 
     * Helper method to handle <code>SuperSleuthCard</code> request.
     * @param sleuthCard is the <code>CardMessage</code> containing the 
     *        <code>SuperSleuthCard</code> that other <code>Player</code> sleuth
     *        on me
     * @param level the AILevel of the robot
     * @return the list of object to return to the server. This list will 
     *         contain all the <code>ClueCard</code> that <code>Robot</code>
     *         choose to respond to turn <code>Player</code>'s action request.
     *         Return an empty list if there is no <code>ClueCard</code> to show
     */
    public List<Object> handleSleuthCard(CardMessage sleuthCard, AILevel level)
    {
        System.out.println("\tHandling sleuth card");
        List<Object> out = new ArrayList<Object>();
        // INIT a RobotSleuthLogic
        // CALL responseToActionRequest on the RobotSleuthLogic.
        
        Queue<Player> queue = state.getPlayers();
        List<Player> players = new ArrayList<Player>(queue);
        // Create RobotSleuthLogic
        RobotSleuthLogic sleuth = new RobotSleuthLogic(level, players);
        System.out.println("\tcreated robot sleuth logic");
        // CALL responseToActionRequest on RobotSleuthLogic
        SuperSleuthCard card = (SuperSleuthCard) sleuthCard.getCards().get(0);
        // should be from robotstate
        Notepad note = state.getNote();
        System.out.println("\tgot note from state");
        //out.add(sleuth.responseToActionRequest(sleuth, 
        //note, sleuthCard., to, intelligentLevel));
        
        List<ClueCard> list = sleuth.responseToActionRequest(card, 
                note, sleuthCard.getFromPlayer(), sleuthCard.getToPlayer(), level);
        System.out.println("\tcalled respond to action, and got " + 
                list.size() + " card to show");
        // checking if the list is null
        if (list != null && list.get(0) != null)
        {
            out = new ArrayList<Object>();
            out.add(new CardMessage(sleuthCard.getFromPlayer(),
                        state.getSelf(), list.get(0)));
            System.out.println("\tmade a card message to " + 
                    sleuthCard.getFromPlayer().getName());
        }
        
        return out;
    }
    
    /** 
     * Helper method to handle <code>PrivateTipCard</code> request.
     * @param tip is the <code>CardMessage</code> containing the 
     *        <code>PrivateTipCard</code> that other <code>Player</code> 
     *        played on me
     * @param level the AILevel of the robot
     * @return the list of object to return to the server. This list will 
     *         contain the <code>ClueCard</code> that <code>Robot</code>
     *         choose to respond to turn <code>Player</code>'s action request.
     *         Return an empty list if there is no <code>ClueCard</code> to show
     */
    public List<Object> handlePrivateTipCard(CardMessage tip, AILevel level)
    {
        System.out.println("\tHandling tip card");
        List<Object> out = new ArrayList<Object>();
        // INIT a RobotPrivateTipLogic
        // CALL responseToActionRequest on the RobotSnoopLogic.
        // RETURN the chosen cluecard in response to PrivateTip
        Queue<Player> queue = state.getPlayers();
        List<Player> players = new ArrayList<Player>(queue);
        
        PrivateTipCard tipCard = (PrivateTipCard) tip.getCards().get(0);
        
        PrivateTipCardLogic tipLogic = new PrivateTipCardLogic(tipCard,
                state.getTurnPlayer(), state.getSelf());
        System.out.println("\tcreated robot tip logic");
        //CALL playPrivateTip on self player to get list of cards
        List<ClueCard> cardsToShowTurnPlayers = tipLogic.playPrivateTip(state.getSelf());
        System.out.println("\tcalled respond to action, and got " + 
                cardsToShowTurnPlayers.size() + " card to show");

        // Create RobotPrivateTipLogic
        // RobotPrivateTipLogic logic = new RobotPrivateTipLogic(level, players);
        // CALL responseToActionRequest on RobotPrivateTipLogic
        //List<ClueCard> list = logic.responseToActionRequest(tipCard, note, 
        //        tip.getFromPlayer(), tip.getToPlayer(), level);
        
        // note should be from RobotState
        Notepad note = state.getNote();
        // IF shown all, turn player has seen my cards, now I just mark the note
        if (tipCard.isAll())
        {
            System.out.println("\t isALL, no need to send card message");
            // loops through all cards in the list and marks them as shown
            for (ClueCard card: cardsToShowTurnPlayers)
            {
                note.mark(card, state.getSelf(), NoteEntry.SHOWN);
            }
        }
        //Select a Card to show turn player
        // checking if the size of list is greater than 0 
        else if (cardsToShowTurnPlayers.size() > 0)
        {
            out.add(new CardMessage(tip.getFromPlayer(),
                        state.getSelf(), cardsToShowTurnPlayers.get(0)));
            note.mark(cardsToShowTurnPlayers.get(0), state.getSelf(), NoteEntry.SHOWN);
            HistoryLog log = state.getLog();
            log.addToLog(state.getSelf().getName()
                        + " shows " + state.getTurnPlayer().getName()
                        + " a clue in response to a Private Tip.");
            out.add(log);
            System.out.println("\t show 1, made a card message to " + 
                    tip.getFromPlayer().getName());
        }
        return out;
    }
}
