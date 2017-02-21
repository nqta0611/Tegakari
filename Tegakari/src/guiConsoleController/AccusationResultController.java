/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controller
 * @author jchoi30
 */
public class AccusationResultController implements ActionListener, KeyListener
{
    private I_AccusationResult view;
    private ActionEvent confirm;
    /**
     * Sets up the controller
     * @param aView the view
     */
    public void setup(I_AccusationResult aView)
    {
        this.view = aView;
        this.confirm = new ActionEvent(this, 0, "OK");
    }
    
    /**
     * Action performed
     * @param event the action
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String buttonName = event.getActionCommand();
        
        // check if ok button
        if (buttonName.equals("OK"))
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
     * Key pressed
     * @param e the key
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if space
        if(e.getKeyCode() == KeyEvent.VK_O)
        {
            this.actionPerformed(confirm);
        }
    }

    /**
     * Key released
     * @param e the key
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
