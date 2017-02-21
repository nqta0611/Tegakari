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
 * The controller for CreateRobot
 * @author Tarrant
 */
public class CreateRobotController implements ActionListener, KeyListener
{
    private boolean isConsole;
    private I_CreateRobot view;
    
    private ActionEvent ok;
    private ActionEvent smart;
    private ActionEvent basic;
    /**
     * sets up the controller
     * @param aConsole if it is console
     * @param aView the view
     */
    public void setup(boolean aConsole, I_CreateRobot aView)
    {
        this.isConsole = aConsole;
        this.view = aView;
        
        this.ok = new ActionEvent(this, 0, "Create");
        this.smart = new ActionEvent(this, 0, "Smart");
        this.basic = new ActionEvent(this, 0, "Basic");
    }
    /**
     * action performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String cmd = e.getActionCommand();
        // if smart
        if (cmd.equals("Smart"))
        {
            view.setToSmart();
        }
        // if basic
        else if (cmd.equals("Basic"))
        {
            view.setToBasic();
        }
        // Create
        else
        {
            view.addRobot();
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
        // if space
        if(e.getKeyCode() == KeyEvent.VK_O)
        {
            this.actionPerformed(ok);
        }
        // if basic
        else if (e.getKeyCode() == KeyEvent.VK_B)
        {
            this.actionPerformed(basic);
        }
        // if smart
        else if (e.getKeyCode() == KeyEvent.VK_S)
        {
            this.actionPerformed(smart);
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
