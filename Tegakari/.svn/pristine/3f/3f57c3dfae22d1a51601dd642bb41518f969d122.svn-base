package guiConsoleController;

import allguis.NoWinnerDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import tegakari.CardMessage;
import tegakari.Solution;

/**
 * The controller for NoWinner
 * @author DeionLaw
 */
public class NoWinnerController implements ActionListener, KeyListener
{
    private I_NoWinner view;
    
    /**
     * Sets up the controller
     * @param dialog the view - GUI or console
     * @param solution the solution to use
     */
    public void setUp(I_NoWinner dialog, Solution solution)
    {
        this.view = dialog;
    }
    
    /**
     * Action performed
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String cm = ae.getActionCommand();
        // if OK
        if (cm.equals("OK"))
        {
            ((NoWinnerDialog)view).dispose();
        }
        
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
