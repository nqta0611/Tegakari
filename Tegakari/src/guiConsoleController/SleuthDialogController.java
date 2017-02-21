package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controller for sleuth dialog
 * @author Chris Thibodeau - cathibod
 */
public class SleuthDialogController  implements ActionListener, KeyListener
{
    private I_SleuthDialog view;
    private boolean isConsole;
    private ActionEvent ok;
    
    /**
     * Sets up the controller.
     * @param aView the view - GUI or console
     * @param aConsole if it is a console
     */
    public void setup(I_SleuthDialog aView, boolean aConsole)
    {
        this.view = aView;
        this.isConsole = aConsole;
        this.ok = new ActionEvent(this, 0, "OK");
    }

    /**
     * Performs the action for this controller.
     * 
     * @param event the action event
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        
        // if OK
        if (cmd.equals("OK"))
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
     * On key pressed.
     * 
     * @param event the key
     */
    @Override
    public void keyPressed(KeyEvent event) 
    {
        // if SPACE
        if(event.getKeyCode() == KeyEvent.VK_O)
        {
            this.actionPerformed(ok);
        }
    }

    /**
     * On key released.
     * @param event the key
     */
    @Override
    public void keyReleased(KeyEvent event) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
