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
import java.util.*;

/**
 * The controller for SleuthOnMeDialog
 * @author jchoi30
 */
public class SleuthOnMeDialogController implements ActionListener, KeyListener
{
    private I_SleuthOnMeDialog view;
    private List<ClueCard> clues;
    private ClueCard toReturn;
    private boolean isConsole;
    
    private ActionEvent ok;
    private ActionEvent choose1;
    private ActionEvent choose2;
    private ActionEvent choose3;
    private ActionEvent choose4;
    private ActionEvent choose5;
    private ActionEvent choose6;

    /**
     * sets up the controller
     * @param aConsole if it is a console
     * @param aView the view - GUI or console
     * @param clueCards list of clue cards to use
     */
    public void setup(boolean aConsole, I_SleuthOnMeDialog aView, 
            List<ClueCard> clueCards)
    {
        this.view = aView;
        this.clues = clueCards;
        this.toReturn = clueCards.get(0);
        this.isConsole = aConsole;
        
        this.ok = new ActionEvent(this, 0, "OK");
        this.choose1 = new ActionEvent(this, 0, "1");
        this.choose2 = new ActionEvent(this, 0, "2");
        this.choose3 = new ActionEvent(this, 0, "3");
        this.choose4 = new ActionEvent(this, 0, "4");
        this.choose5 = new ActionEvent(this, 0, "5");
        this.choose6 = new ActionEvent(this, 0, "6");
    }

    /**
     * action performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if NOT OK
        if (!cmd.equals("OK"))
        {
            // if 1
            if (cmd.equals("1"))
            {
                toReturn = clues.get(0);
            }
            // if 2
            else if (cmd.equals("2"))
            {
                toReturn = clues.get(1);
            }
            // if 3
            else if (cmd.equals("3"))
            {
                toReturn = clues.get(2);
            }
            // if 4
            else if (cmd.equals("4"))
            {
                toReturn = clues.get(3);
            }
            // if 5
            else if (cmd.equals("5"))
            {
                toReturn = clues.get(4);
            }
            else
            {
                toReturn = clues.get(5);
            }
            view.setOff();
            view.setEnabledButton(cmd);
            view.setEnabledOK();
        }
        else
        {
            view.dispose();
        }
    }
    
    /**
     * shows the resulting clue card
     * @return the clue card to return
     */
    public ClueCard showDialog()
    {
        return toReturn;
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
        // if 1
        else if (e.getKeyCode() == KeyEvent.VK_1)
        {
            this.actionPerformed(choose1);
        }
        // if 2
        else if (e.getKeyCode() == KeyEvent.VK_2)
        {
            this.actionPerformed(choose2);
        }
        // if 3
        else if (e.getKeyCode() == KeyEvent.VK_3)
        {
            this.actionPerformed(choose3);
        }
        // if 4
        else if (e.getKeyCode() == KeyEvent.VK_4)
        {
            this.actionPerformed(choose4);
        }
        // if 5
        else if (e.getKeyCode() == KeyEvent.VK_5)
        {
            this.actionPerformed(choose5);
        }
        // if 6
        else if (e.getKeyCode() == KeyEvent.VK_6)
        {
            this.actionPerformed(choose6);
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
