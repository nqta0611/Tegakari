package guiConsoleController;

import java.awt.event.*;
import java.awt.Frame;

/**
 * The controller of replaying the game
 * @author DeionLaw
 */
public class ReplayController implements ActionListener, KeyListener
{
    private boolean result;
    private I_Replay view;
    private ActionEvent yes;
    private ActionEvent no;
    
    /**
     * the constructor for the controller
     * @param aView the view to use - GUI or console
     */
    public ReplayController(I_Replay aView)
    {
        this.view = aView;
        
        this.yes = new ActionEvent(this, 0, "replay");
        this.no = new ActionEvent(this, 0, "no");
    }
    
    /**
     * action performed
     * @param event the action
     */
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        
        // if replaying game
        if(cmd.equals("replay"))
        {
            view.yesReplay();
            result = view.showDialog();
        }
        // if not replaying game
        else if (cmd.equals("no"))
        {
            view.noReplay();
            result = view.showDialog();
        }
    }
    
    /**
     * Showing result
     * @return the result - yes or no
     */
    public boolean showDialog()
    {
        return result;
    }

    /**
     * key typed
     * @param e the key
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }

    /**
     * key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if Yes
        if(e.getKeyCode() == KeyEvent.VK_Y)
        {
            this.actionPerformed(yes);
        }
        // if No
        else if (e.getKeyCode() == KeyEvent.VK_N)
        {
            this.actionPerformed(no);
        }
    }

    /**
     * key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
