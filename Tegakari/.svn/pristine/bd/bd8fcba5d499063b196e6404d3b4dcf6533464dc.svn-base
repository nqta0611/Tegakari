package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 * Controller class for SnoopOnMeDialog.
 * 
 * @author Jonathan Molina
 */
public class SnoopOnMeDialogController implements ActionListener, KeyListener
{
    /**
     * The view
     */
    private I_SnoopOnMeDialog dialog;
    private ActionEvent ok;

    /**
     * Creates an instance of this controller class.
     * 
     * @param view the SnoopOnMeDialog
     */
    public void setup(I_SnoopOnMeDialog view)
    {
        this.dialog = view;
        this.ok = new ActionEvent(this, 0, "ok");
    }

    /**
     * Will close the dialog.
     * 
     * @param event the action event
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();

        // check if the ok button was pressed
        if (cmd.equals("ok"))
        {
            dialog.dispose();
        }
    }

    /**
     * Can't remove this method as it is needed to implement keyListener
     * 
     * @param e keyEvent
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
    
    /**
     * Handles keyEvents to trigger ok.
     * 
     * @param e keyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        //if ok is selected
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(ok);
        }
    }

    /**
     * Can't remove this method as it is needed to implement keyListener
     * 
     * @param e keyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
