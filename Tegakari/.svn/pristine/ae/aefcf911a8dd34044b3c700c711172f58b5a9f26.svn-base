
package tegakari;

import java.util.List;

/**
 * This is the interface containing the Action Logic of the <code>Robot</code>.
 * 
 * @author anhnguyen
 * @version 2.0
 *         1/12/2016 proposed skeleton.
 *         1/14/2016 add javadocs
 */
public interface RobotActionLogic 
{
    
    /**
     * Perform the action in responding to an action request by 
     * other <code>Player</code>.
     * @param action is the <code>ActionCard</code> has been played by 
     *               turn <code>Player</code>.
     * @param note is the <code>Notepad</code> of this <code>Robot</code>.
     * @param turn is the turn <code>Player</code> who played 
     *             the <code>ActionCard</code>.
     * @param self is this <code>Robot</code> who need to respond 
     *             to the action from turn <code>Player</code>.
     * @param intelligentLevel the <code>AILevel</code> for the <code>Robot</code>
     * @return the <code>ClueCard</code>s this <code>Robot</code> chose to 
     *         respond to the action request.
     */
    public List<ClueCard> responseToActionRequest(ActionCard action,
            Notepad note, Player turn, Player self, AILevel intelligentLevel);
    
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
    public int benefitFromAction(Notepad note, ActionCard action);
    
}
