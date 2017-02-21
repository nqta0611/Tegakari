/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tegakari.*;

/**
 * The controller of the controller.
 * @author anhnguyen
 */
public class AccusationConfirmController implements ActionListener, KeyListener 
{
    private I_AccusationConfirm view;
    private boolean toReturn = false;
    private ActionEvent yes;
    private ActionEvent no;
    /**
     * Sets up the controller
     * @param theView the view to use
     */
    public void setup(I_AccusationConfirm theView)
    {
        this.view = theView;
        this.yes = new ActionEvent(this, 0, "y");
        this.no = new ActionEvent(this, 0, "n");
    }
    
    /**
     * Perform the following action
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if the command is yes
        if (cmd.equals("y"))
        {
            toReturn = true;
        }
        // command is no
        else
        {
            toReturn = false;
            // if it is a console
            if (view instanceof AccusationConfirmConsole)
            {
                ((AccusationConfirmConsole)view).restartTurn();
            }
        }
        view.disposeView();
    }
    /**
     * Dispose of the view
     * @return The action done - accuse or not accuse
     */
    public boolean showDialog()
    {
        return toReturn;
    }

    /**
     * If a key is typed
     * @param e the key typed
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
    /**
     * if a key is pressed
     * @param e the key pressed
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if space
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.actionPerformed(yes);
            
        }
        // if C
        else if (e.getKeyCode() == KeyEvent.VK_C)
        {
            this.actionPerformed(no);
        }
    }

    /**
     * If key is released
     * @param e the key released
     */
    @Override
    public void keyReleased(KeyEvent e) 
    {
        // doesn't need to do anything, key pressed does it
        // can't remove this method as it is needed to implement keyListener
    }
}
