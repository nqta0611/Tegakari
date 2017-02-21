
package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import tegakari.*;

/**
 * The controller for ShowCardDialog
 * @author roh
 */
public class ShowCardDialogController implements ActionListener, KeyListener
{
    private I_ShowCardDialog view;
    private boolean isConsole;
    private ActionEvent ok;
    
    /**
     * sets up the controller
     * @param dialog the view - GUI or console
     * @param console if it is a console
     * @param recievedCardList the card messages received
     */
    public void setUp(I_ShowCardDialog dialog, boolean console, 
            List<CardMessage> recievedCardList)
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
     * Key typed
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
