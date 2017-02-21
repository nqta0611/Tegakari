package tegakari;

import java.io.Serializable;

/**
 * The accusation message which contain the accusation form, 
 * the accuser, and the result.
 *
 * @author JMo
 * @version 1.0
 */
public class AccusationMessage implements Serializable 
{
    
    /**
     * the solution of the game.
     */
    private Solution solution;

   /**
    * Turn player's accuse.
    */
    private final Solution accusation;
    /**
     * the creator of the solution message.
     */
    private final Player creator;
    /**
     * who this accusation message is showing to .
     */
    private Player showTo;
    /**
     * indicate if the accusation is correct .
     */
    private boolean isCorrect;
    
    /** Access to the accusation.
     * 
     * @return the accusation
     */
    public Solution getAccusation() 
    {
        return accusation;
    }
    /** 
     * Access to the creator.
     * 
     * @return the player who created this accusationMessage
     */
    public Player getCreator() 
    {
        return creator;
    }
    /** 
     * Access to the showTo player.
     * 
     * @return the player who created this accusationMessage
     */
    public Player getShowTo() 
    {
        return showTo;
    }
    /** 
     * Setter the ShowTo player.
     * @param showTo is the player who can view the solution
     */
    public void setShowTo(Player showTo) 
    {
        this.showTo = showTo;
    }
    /** 
     * Access to the solution.
     * 
     * @return the solution of the game
     */
    public Solution getSolution()
    {
        return solution;
    }
    /** 
     * Set the solution.
     * @param solution is the solution to set
     */
    public void setSolution(Solution solution) 
    {
        this.solution = solution;
    }
    /**
     * Retrieve the result of accusation.
     * @return the boolean indicate if this accusation is correct
     */
    public boolean isCorrect() 
    {
        return isCorrect;
    }
    /**
     * Setter to the result.
     * @param isCorrect is the result of the accusation
     */
    public void setIsCorrect(boolean isCorrect) 
    {
        this.isCorrect = isCorrect;
    }
    /**
     * Construct the accusation Message
     * @param accusation is the accusation form
     * @param solution is the solution of the game
     * @param creator is the player who made this accusation
     */
    public AccusationMessage(Solution accusation, Solution solution, Player creator) 
    {
        this.accusation = accusation;
        this.creator = creator;
        this.solution = solution;
    }

}
