
package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will compute all logic of playing PrivateTip
 * in different level of intelligent, it also calculate the
 * benefit of playing PrivateTip, so that the robot can
 * decide to play this action or not.
 * @author Eric Roh
 * @author anhnguyen
 * @version 2.0
 *      1/12/2016 proposed skeleton.
 */
public class RobotPrivateTipLogic implements RobotActionLogic, Serializable
{
    /**
     * the level of intelligent of this robot,
     * ranging from 1 to 3, as 3 is smartest. 
     */
    private AILevel intLv;
    /**
     * Player to target the <code>ActionCard</code>
     */
    private Player targetPlayer;
    /**
     * The <code>Queue</code> of <code>Players</code> currently in the game.
     */
    private List<Player> players;
    
    /**
     * Constructor for RobotPrivateTipLogic
     * @param level level of the ai
     * @param players list of the players
     */
    public RobotPrivateTipLogic(AILevel level, List<Player> players) 
    {
        this.intLv = level;
        this.players = players;
        this.targetPlayer = players.get(0);
    }
    /**
     * Gets the response to the <code>PrivateTipCard</code> when other 
     * player plays a <code>PrivateTipCard</code> on this Robot.
     * @param action The represented <code>PrivateTipCard</code>
     * @param note The <code>Notepad</code> of the <code>Robot</code> player
     * @param turn The player that played the <code>PrivateTipCard</code>
     * @param self The player responding to the <code>PrivateTipCard</code>
     * @param intelligentLevel determine how smart this robot is. 
     * @return <code>ClueCard</code>s responding to the <code>PrivateTipCard</code>
     *      if none found return null
     */
    @Override
    public List<ClueCard> responseToActionRequest(ActionCard action, 
                   Notepad note, Player turn, Player self, AILevel intelligentLevel) 
    {
        // INIT List of Cards for returning
        List<ClueCard> retCards = new ArrayList<ClueCard>();
        PrivateTipCard card = (PrivateTipCard) action;
        // GET the hand of the robot
        List<ClueCard> clueCards = self.getHand().getClueCards();
        // FOR each card in hand
        for (ClueCard handCard : clueCards)
        {
            // IF card matches the description of the action card 
            if (card.isAll())
            {
                // if clue hand card matches discription for actioncard 
                // add to the return list
                if (handCard.getClueType() == card.getClueType())
                {
                    retCards.add(handCard);
                }
            }
            // if card is not is all
            else
            {
                // checks if the card matches the attribute of ActionCard
                for (Attribute cardAttribute : handCard.getAttribute())
                {
                    // if the card attribute matches the request of the 
                    // ActionCard add to return cards
                    if (cardAttribute.equals(card.getAttribute()) && 
                            !retCards.contains(handCard) && retCards.isEmpty())
                    {
                    //ADD to return list
                        retCards.add(handCard);
                    }
                }
                //ENDIF
            }
        }
        //ENDFOR
        for (ClueCard retCard : retCards)
        {
            note.mark(retCard, turn, NoteEntry.SHOWN);
        }
        // IF list is empty return null
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
        // INIT int benefit to return
        int benefit = 0;
        PrivateTipCard card = (PrivateTipCard) action;
        
        List att = null;
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

        // checks if the actioncard is is all
        if(card.isAll())
        {
            benefit = benefitFromIsAll(note, card, att);
        }
        else
        {
            benefit = benefitFromNotALL(note, card, att);
        }
        
        // RETURN value of benefit
        return benefit;
    }
    
    private int benefitFromNotALL(Notepad note, PrivateTipCard action, List att)
    {
        int benefit = 0;
        int cardCount = 0;
        
        Attribute cardAtt = action.getAttribute();
        ClueType cardType = action.getClueType();
        
        
        
        // predict what information can be found from the action card
        // FOR each player
        for (Player player : players)
        {
            int temp = 0;
            // CALCULATE how much information can be obtained about the card
            for (ClueCard clueCard : (List<ClueCard>) att)
            {
                // check only for clue cards in the attribute
                for (Attribute attribute : clueCard.getAttribute())
                {
                    // if check if card is same as attribute
                    if (attribute.equals(cardAtt))
                    {
                        cardCount++;
                        // if blank add benefit
                        if (note.getEntry(clueCard, player).equals(NoteEntry.BLANK))
                        {
                            temp++;
                        }
                    }
                }
                
            }
            // IF more information is found than the current target player
            if (temp > benefit)
            {
                // SET target player to current player
                this.targetPlayer = player;
                // SET benefit according to information abtainable
                benefit = temp;
            }
            // END IF
        }
        
        cardCount = cardCount / players.size();
        benefit = calcBenefit(cardCount, benefit, false);
        
        return benefit;
    }
    
    private int benefitFromIsAll(Notepad note, PrivateTipCard action, List att)
    {
        int benefit = 0;
        
        // predict what information can be found from the action card
        // FOR each player
        for (Player player : players)
        {
            int temp = 0;
            // CALCULATE how much information can be obtained about the card
            for (ClueCard clueCard : (List<ClueCard>) att)
            {
                // if blank add benefit
                if (note.getEntry(clueCard, player).equals(NoteEntry.BLANK))
                {
                    temp++;
                }
            }
            // IF more information is found than the current target player
            if (temp > benefit)
            {
                // SET target player to current player
                this.targetPlayer = player;
                // SET benefit according to information abtainable
                benefit = temp;
            }
            // END IF
        }
        
        benefit = calcBenefit(att.size(), benefit, true);
        return benefit;
    }
    
    private int calcBenefit(int size, int found, boolean isAll)
    {
        int benefit = 0;
        double ratio = (double) (size - found) / size;
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
        else if (ratio <= 1)
        {
            benefit = 1;
        }
        // lower benefit if card is not is all action card
        if (!isAll && benefit - 1 > 1) 
        {
            benefit--;
        }
        
        return benefit;
    }
    
    /**
     * Determines the player to target the <code>ActionCard</code>.
     * @return The player to target the private tip
     */
    public Player getTargetPlayer() 
    {
        // RETRUN the player who will be most significant
        return this.targetPlayer;
    }

    /**
     * Play the privateTipCard on the target <code>Player</code>
     * @param note The <code>Notepad</code> of the <code>Robot</code> player
     * @param target the target <code>Player</code> of the private tip
     * @param action The privateTip card played
     * @return the list of <code>ClueCard</code> if this private tip was
     *         a show all card, return null if not show all.
     */
    public List<ClueCard> playPrivateTip(Notepad note, Player target, 
            ActionCard action) 
    {
        // INIT return list of cards
        List<ClueCard> retCards = new ArrayList<ClueCard>();
        // GET info of hand of the targeted player 
        List<ClueCard> hand = target.getHand().getClueCards();
        PrivateTipCard card = (PrivateTipCard) action;
        Attribute attribute = card.getAttribute();
        
        // FOR each card in the targeted player's hand
        for (ClueCard handCard : hand)
        {
            // IF card matches the description of the action card 
            if (card.isAll())
            {
                // if clue hand card matches discription for actioncard 
                // add to the return list
                if (handCard.getClueType() == card.getClueType())
                {
                    retCards.add(handCard);
                }
            }
            // if card is not is all
            else
            {
                // checks if the card matches the attribute of ActionCard
                for (Attribute cardAttribute : handCard.getAttribute())
                {
                    // if the card attribute matches the request of the 
                    // ActionCard add to return cards
                    if (cardAttribute.equals(attribute) && 
                            !retCards.contains(handCard) && retCards.isEmpty())
                    {
                    //ADD to return list
                        retCards.add(handCard);
                    }
                }
                //ENDIF
            }
            // END IF
        }
        // END FOR
        // Modify notepad according to the response
        for (ClueCard retCard : retCards)
        {
            note.mark(retCard, target, NoteEntry.HAS);
        }
        // RETURN list of cards if list is empty return null
        return retCards;
    }
}
