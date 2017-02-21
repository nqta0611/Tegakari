
package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will compute all logic of playing SuperSleuth
 * in different level of intelligent, it also calculate the
 * benefit of playing SuperSleuth, so that the robot can 
 * decide to play this action or not.
 * 
 * @author Eric Roh
 * @author anhnguyen
 * @version 2.0
 *      1/12/2016 proposed skeleton.
 */
public class RobotSleuthLogic implements RobotActionLogic, Serializable
{
    /**
     * the level of intelligent of this robot,
     * ranging from 1 to 3, as 3 is smartest. 
     */
    private AILevel intLv;

    /**
     * The <code>Queue</code> of <code>Players</code> currently in the game.
     */
    private List<Player> players;
    
    /**
     * Constructor for RobotSleuthLogic
     * @param level level of the AI
     * @param players list of current players
     */
    public RobotSleuthLogic(AILevel level, List<Player> players) 
    {
        this.intLv = level;
        this.players = players;
    }
    /**
     * Robot's decision on making a response to a <code>Player</code>'s 
     * <code>SuperSleuthCard</code>
     * @param action The represented <code>SuperSleuthCard</code>
     * @param note The <code>Notepad</code> of the <code>Robot</code> player
     * @param turn The player that played the <code>SuperSleuthCard</code>
     * @param self The player responding to the <code>SuperSleuthCard</code>
     * @param intelligentLevel determine how smart this robot is. 
     * @return <code>ClueCard</code> responding to the <code>SuperSleuthCard</code>
     *      if none found return null
     */
    @Override
    public List<ClueCard> responseToActionRequest(ActionCard action, 
                   Notepad note, Player turn, Player self, AILevel intelligentLevel) 
    {
        // This method will be called when turn Player plays a SuperSleuthCard
        // The Robot should look into it's own hand, choose a ClueCard in respond to the
        // SuperSleuthCard. Return null if the Robot doesn't have a ClueCard to respond.
        
        // INIT List of Cards for returning
        List<ClueCard> retCards = new ArrayList<ClueCard>();
        ClueCard retCard = null, last = null;
        // GET the hand of the robot
        Hand hand = self.getHand();
        SuperSleuthCard card = (SuperSleuthCard) action;
        Attribute cardAttribute = card.getAttribute();
        
        // FOR each card in hand
        for (ClueCard handCard : hand.getClueCards())
        {
            // IF card matches description of the action card then put into return list 
            // IF a card exists in the list
            for (Attribute att : handCard.getAttribute()) 
            {
                // if attribute equals
                if (att.equals(cardAttribute)) 
                {
                    last = handCard;
                    //compare to see which is a better card to show
                    if (intelligentLevel.equals(AILevel.SMART))
                    {
                        // if card has been shown then replace return card
                        if (note.getEntry(handCard, turn).equals(NoteEntry.SHOWN))
                        {
                            retCard = handCard;
                        }
                    }
                    else
                    {
                        retCard = handCard;
                    }
                }
            }
                // ENDIF
            // ENDIF
        }
        // ENDFOR
        
         //if return card is null then show the last card
        if (retCard == null)
        {
            retCard = last;
        }
        retCards.add(retCard);
        // RETURN list or IF list is empty return null
        return retCards;
    }
    
    /**
     * Pre-calculate the benefit of playing an specific <code>ActionCard</code>
     * so that the <code>Robot</code> can decide which <code>ActionCard</code>
     * is going to be played. 
     * @param note is the <code>Notepad</code> of this <code>Robot</code>.
     * @param action is the <code>ActionCard</code> that <code>Robot</code>
     *        want to calculate the benefit from playing it.
     * 
     * @return the beneficial amount of playing an <code>ActionCard</code> 
     *         the return value is ranging from 0 to 5 as 0 means no benefit,
     *         and 5 means the <code>Robot</code> can gain a lot of benefit.
     *         The return value also depend on how smart the <code>Robot</code>
     *         is. if the <code>Robot</code> had intelligent level 1, than this
     *         method should always return 0 because this <code>Robot</code> 
     *         isn't smart enough to calculate the benefit of playing an 
     *         <code>ActionCard</code>
     */
    @Override
    public int benefitFromAction(Notepad note, ActionCard action) 
    {
        // INIT int benifit to return
        int benefit = 0;
        int count = 0;
        // GET info from Notepad
        List att = null;
        SuperSleuthCard card = (SuperSleuthCard) action;
        Attribute attribtue = card.getAttribute();
        ClueType cardType = card.getClueType();
        // if the card looks for suspects
        if(cardType == ClueType.SUSPECT)
        {
            att = note.getSuspects();
        }
        // checks if card looks for vehicle
        else if(cardType == ClueType.VEHICLE)
        {
            att = note.getVehicles();
        }
        // if card looks for destinations
        else
        {
            att = note.getDestinations();
        }
        // predict what information can be found from the action card
        // CALCULATE how many of the clue card described in the action card is known
        for (Player player : players)
        {
            // for all clue cards
            for (ClueCard clueCard : (List<ClueCard>) att)
            {
                // for all attribute of the clueCard
                for (Attribute cardAtt : clueCard.getAttribute())
                {
                    // if note entry is blank
                    if (note.getEntry(clueCard, player) == NoteEntry.BLANK
                            && cardAtt.equals(attribtue))
                    {
                        benefit++;
                    }
                    // add to card count
                    if (cardAtt == attribtue)
                    {
                        count++;
                    }
                }
            }
        }
        
        benefit = calcBenefit(count, benefit);
        // RETURN value of benifit
        return benefit;
    }
    
    private int calcBenefit(int count, int benefit)
    {
        // IF no info on the description of the action card
            // SET benifit to 5
        // ELSE IF no information is needed from the described action card
            // SET benifit to 1
        // ELSE 
            // DETERMINE how much information can be attained
        // END IF
        count = count * (players.size() - 1) / players.size();
        double ratio = (double) (count - benefit) / count;
        
        // if less than 20%
        if (ratio <= .2)
        {
            benefit = 5;
        }
        // if less than 40%
        else if (ratio <= .4)
        {
            benefit = 4;
        }        
        // if less than 60%
        else if (ratio <= .6)
        {
            benefit = 3;
        }
        // if less than 80%
        else if (ratio <= .8)
        {
            benefit = 2;
        }
        // if less than 100%
        else
        {
            benefit = 1;
        }
        
        return benefit;
    }
    
    /**
     * Perform the actions required for <code>SuperSleuthCard</code>, Gets all 
     * <code>ClueCard</code> matching description of the <code>SuperSleuthCard</code>.
     * @param self The <code>Player</code> sending the <code>ActionCard</code>
     * @param action The represented <code>SuperSleuthCard</code>
     * @return A list of <code>ClueCard</code>s responding to the 
     *      <code>SuperSleuthCard</code>. If none found returns null
     */
    public List<CardMessage> playSleuth(Player self, ActionCard action) 
    {
        // INIT List of Card Message for returning
        List<CardMessage> retMsg = new ArrayList<CardMessage>();
        // SEND to all players the action card
        for (Player player : players)
        {
            // if the player is self dont make
            if (!player.equalsName(self))
            {
                retMsg.add(new CardMessage(player, self, action));
            }
        }
        // The clue cards response from player are put into the list of cards to return
        // Modify notepad according to the response
        // RETRUN list of cards
        return retMsg;
    }
}
