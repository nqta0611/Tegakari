/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;
import tegakari.ClueCard;

/**
 * The interface for Snoop
 * @author jchoi30
 */
public interface I_SnoopDialog
{
    /**
     * Obtain the seat with the corresponding number.
     * 
     * @param num the card number, not the index number, starting from the left at 1
     * @param set the boolean to set this button to
     */
    public void setCardButton(int num, boolean set);
    /**
     * Set the Icon of this button
     * 
     * @param card the icon seat to change to
     * @param pickedCard the icon to change to
     */
    public void setIcon(int card, ClueCard pickedCard);
    /**
     * Sets this OK Button visible or not
     * 
     * @param set the boolean to set this button visible or not
     */
    public void setOKButton(boolean set);
    /**
     * make this window hidden
     */
    public void dispose();
     /**
     * if the OK button is visible
     * @return true if the button is visible, false if not
     */
    public boolean isOkVisible();
}
