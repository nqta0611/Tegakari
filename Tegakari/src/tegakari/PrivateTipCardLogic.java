package tegakari;

import java.util.List;
import java.util.ArrayList;

/**
 * The PrivateTipCardLogic represents the necessary actions each
 * <code>PrivateTipCard</code> must simulate.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 11/4/2015 - Write java doc
 * @version 11/11/2015 - Implement code
 */
public class PrivateTipCardLogic extends ActionCardLogic 
{

    /**
     * the Player the ActionCard was meant for
     */
    private Player targetPlayer;

    /**
     * Constructs the
     * <code>PrivateTipCardLogic</code> instance.
     *
     * @param card the represented <code>PrivateTipCard</code>
     * @param turnPlayer the <code>Player</code> that played
     * the <code>PrivateTipCard</code>
     * @param targetPlayer the <code>Player</code> the <code>PrivateTipCard</code>
     * was meant for
     */
    public PrivateTipCardLogic(PrivateTipCard card, 
            Player turnPlayer, Player targetPlayer) 
    {
        //SET card
        //SET turnPlayer
        super(card, turnPlayer);
        //SET targetPlayer
        this.targetPlayer = targetPlayer;
    }

    /**
     * Performs the action the target
     * <code>Player</code> must do.
     *
     * @param received the target <code>Player</code>
     * @return the appropriate <code>List</code> of <code>Cards</code>
     */
    public List<ClueCard> playPrivateTip(Player received) 
    {
        //INIT a return list
        List<ClueCard> toReturn = new ArrayList<ClueCard>();
        //GET the Hand of received player
        Hand hand = received.getHand();
        //GET the list of clue card from Hand
        List<ClueCard> clueCard = hand.getClueCards();
        PrivateTipCard card = (PrivateTipCard)(super.getActionCard());
        //IF this card isAll card
        if (card.isAll())
        {
            //FOR each clue card
            for (int index = 0; index < clueCard.size(); index++) 
            {
                //IF this clue card match cluetype with the private tip card
                if (clueCard.get(index).getClueType().equals(card.getClueType()))
                {
                    //ADD clue card to the return list
                    toReturn.add(clueCard.get(index));
                }
                //ENDIF
            //ENDFOR
            }
        }
        //ELSE this card is not All card
        else 
        {
            //FOR each clue card
            for (int index = 0; index < clueCard.size(); index++) 
            {
                //IF this clue card math cluetype and attribute with the private tip card
                if (clueCard.get(index).getClueType().equals(card.getClueType())
                        && clueCard.get(index).getAttribute().contains(
                            card.getAttribute()))
                {
                    //ADD clue card to the return list
                    toReturn.add(clueCard.get(index));
                }
                //ENDIF
            //ENDFOR
            }
        //ENDIF
        }
        //RETURN the return list 
        return toReturn;
    }

    /**
     * Retrieves the
     * <code>Player</code> the
     * <code>PrivateTipCard</code> was meant for.
     *
     * @return the target <code>Player</code>
     */
    public Player getTargetPlayer() 
    {
        //RETURN targetPlayer
        return targetPlayer;
    }
}
