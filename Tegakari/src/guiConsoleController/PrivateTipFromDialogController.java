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
 * The Controller for PrivateTipFromDialog
 * @author jchoi30
 */
public class PrivateTipFromDialogController implements ActionListener, KeyListener
{
    private I_PrivateTipFrom view;
    private List<ClueCard> clues;
    private ClueCard toReturn;
    private boolean isConsole;
    private boolean isAllTip;
    
    private ActionEvent ok;
    private ActionEvent action1;
    private ActionEvent action2;
    private ActionEvent action3;
    private ActionEvent action4;
    private ActionEvent action5;
    private ActionEvent action6;

    /**
     * sets up the controller
     * @param aConsole if it is a console
     * @param aView the view - GUI or console
     * @param clueCards the list of clue cards to use
     * @param pTip the private tip card
     */
    public void setup(boolean aConsole, I_PrivateTipFrom aView, 
            List<ClueCard> clueCards, PrivateTipCard pTip)
    {
        this.view = aView;
        this.clues = clueCards;
        // if size > 0
        if (clueCards.size() > 0)
        {
            toReturn = clueCards.get(0);
        }
        else
        {
            toReturn = new SuspectCard(null);
        }
        this.isConsole = aConsole;
        this.isAllTip = pTip.isAll();
        
        this.ok = new ActionEvent(this, 0, "OK");
        this.action1 = new ActionEvent(this, 0, "1");
        this.action2 = new ActionEvent(this, 0, "2");
        this.action3 = new ActionEvent(this, 0, "3");
        this.action4 = new ActionEvent(this, 0, "4");
        this.action5 = new ActionEvent(this, 0, "5");
        this.action6 = new ActionEvent(this, 0, "6");
    }

    /**
     * action performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        // if not OK and not ALLTIP
        if (!cmd.equals("OK") && (!isAllTip))
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
            view.disableCards();
            view.setEnabledButton(cmd);
            view.setEnabledOK();
        }
        // IF the action was an ok button
        else if (cmd.equals("OK"))
        {
            view.dispose();
        }
    }
    
    /**
     * returns the clue card received
     * @return the value
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
     * Key pressed
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
            this.actionPerformed(action1);
        }
        // if 2
        else if (e.getKeyCode() == KeyEvent.VK_2)
        {
            this.actionPerformed(action2);
        }
        // if 3
        else if (e.getKeyCode() == KeyEvent.VK_3)
        {
            this.actionPerformed(action3);
        }
        // if 4
        else if (e.getKeyCode() == KeyEvent.VK_4)
        {
            this.actionPerformed(action4);
        }
        // if 5
        else if (e.getKeyCode() == KeyEvent.VK_5)
        {
            this.actionPerformed(action5);
        }
        // if 6
        else if (e.getKeyCode() == KeyEvent.VK_6)
        {
            this.actionPerformed(action6);
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
