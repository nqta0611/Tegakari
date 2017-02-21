package guiConsoleController;

import tegakari.ClueCard;

/**
 * The interface for Disprove
 * @author DeionLaw
 */
public interface I_Disprove
{
    /**
     * disposes of the console
     */
    public void dispose();
    /**
     * sets the disprove enabled
     * @param choice the choice
     * @param set what to set it to
     */
    public void setEnabled(String choice, boolean set);
}
