
package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import tegakari.*;

/**
 * The controller of PrivateTipResponse
 * @author roh
 */
public class PrivateTipResponseController implements ActionListener, KeyListener
{
    private I_PrivateTipResponse view;
    private boolean isConsole;
    private ActionEvent ok;
    
    /**
     * sets up the controller
     * @param dialog the view - GUI or Console
     * @param console if it is a console
     */
    public void setUp(I_PrivateTipResponse dialog, boolean console)
    {
        this.view = dialog;
        this.isConsole = console;
        
        this.ok = new ActionEvent(this, 0, "OK");
    }
    
    /**
     * action performed
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String cm = ae.getActionCommand();
        
        // if OK
        if (cm.equals("OK"))
        {
            view.dispose();
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
        if(e.getKeyCode() == KeyEvent.VK_O)
        {
            this.actionPerformed(ok);
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
