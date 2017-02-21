package guiConsoleController;

import allguis.NoOneDisproveDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tegakari.Solution;

/**
 * The controller for NoOneDisproveController
 * @author DeionLaw
 */
public class NoOneDisproveController implements ActionListener, KeyListener
{
    private Solution guess;
    private I_NoOneDisprove view;
    /**
     * Sets up the Controller
     * @param aGuess the Solution guessed
     * @param aView the view - GUI or Console
     */
    public void setup(Solution aGuess, I_NoOneDisprove aView)
    {
        this.guess = aGuess;
        this.view = aView;
    }
    
    /**
     * Action Performed
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String cm = ae.getActionCommand();
        
        // if OK
        if (cm.equals("OK"))
        {
            ((NoOneDisproveDialog)view).dispose();
        }
        
    }

    /**
     * Key typed
     * @param e keyEvent
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
        // if SPACE
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(new ActionEvent(this, 0, "OK"));
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
