package tegakari;

import java.util.List;
import java.util.ArrayList;

/**
 * The SuperSleuthCardLogic represents the necessary actions each
 * <code>SuperSleuthCard</code> must simulate.
 * 
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 11/4/2015 - Write java doc
 * @version 11/11/2015 - Implement code
 */
public class SuperSleuthCardLogic extends ActionCardLogic 
{

    /**
     * Constructs the
     * <code>SuperSleuthCardLogic</code> instance.
     *
     * @param card the represented <code>SuperSleuthCard</code>
     * @param turnPlayer the <code>Player</code> that played
     * the <code>SuperSleuthCard</code>
     */
    public SuperSleuthCardLogic(SuperSleuthCard card, Player turnPlayer)
    {
        // SET card
        // SET turn player
        super(card, turnPlayer);
    }

    /**
     * Performs the action the target
     * <code>Player</code> must do.
     *
     * @param received the target <code>Player</code>
     * @return the appropriate <code>List</code> of <code>Cards</code>
     */
    public List<ClueCard> playSuperSleuth(Player received)
    {
        //INIT a List of return cards
        //GET the Hand from received player
        //FOR each card of the list
            //IF that card match the cluetype and attribute with this sleuth card
                //ADD this clue card to the return list
        //ENDFOR
        //RETURN the list of clue card
        //------------------------------------------
        List<ClueCard> toReturn = new ArrayList<ClueCard>();
        //GET the Hand from received player
        Hand hand = received.getHand();
        //GET the list of clue card from Hand
        List<ClueCard> clueCards = hand.getClueCards();
        //FOR each card of the list
        SuperSleuthCard sleuthCard = (SuperSleuthCard)(super.getActionCard());
        //For all cards
        for (int ind = 0; ind < clueCards.size(); ind++)
        {
            ClueCard card = clueCards.get(ind);
            ClueType type = card.getClueType();
            List<Attribute> attributes = card.getAttribute();
            //IF that card match the cluetype and attribute with this sleuth card
            if (type.equals(sleuthCard.getClueType())
                   && attributes.contains(sleuthCard.getAttribute()))
            {
                toReturn.add(card);
            }
        //ENDFOR
        }
        //RETURN the list of clue card
        return toReturn;

    }
}
