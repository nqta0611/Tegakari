package guiConsoleController;

/**
 * The interface for Replay
 * @author DeionLaw
 */
public interface I_Replay 
{
    /**
     * Returns the result of the button press
     * @return the value
     */
    public boolean showDialog();
    /**
     * Sets the controller 
     * @param controller the controller to set it to
     */
    public void setController(ReplayController controller);
    /**
     * Quits game
     */
    public void noReplay();
    /**
     * Replays game
     */
    public void yesReplay();
}
