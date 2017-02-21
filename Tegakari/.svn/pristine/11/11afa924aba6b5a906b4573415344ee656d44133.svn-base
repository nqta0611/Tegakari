package guiConsoleController;

import allguis.SnoopOnPlayerDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import tegakari.*;
import java.util.*;

/**
 * Controller class for SnoopOnPlayerDialog.
 * 
 * @author Jonathan Molina
 */
public class SnoopOnPlayerDialogController implements ActionListener, KeyListener
{
    /**
     * The view
     */
    private I_SnoopOnPlayerDialog dialog;
    private final int kNumButtons = 4;
    private Player chosenPlayer;
    private List<Player> list;
    
    private ActionEvent ok;
    private ActionEvent choose1;
    private ActionEvent choose2;
    private ActionEvent choose3;
    private ActionEvent choose4;
    private boolean isConsole = false;
    private SnoopOnPlayerDialog gui;
    
    /**
     * Creates an instance of this controller class.
     * 
     * @param view the SnoopOnMeDialog
     * @param players list of players
     */
    public void setup(I_SnoopOnPlayerDialog view, List<Player> players)
    {
        this.dialog = view;
        this.list = players;
        chosenPlayer = list.get(1);
        
        this.ok = new ActionEvent(this, 0, "ok");
        this.choose1 = new ActionEvent(this, 0, "seat1");
        this.choose2 = new ActionEvent(this, 0, "seat2");
        this.choose3 = new ActionEvent(this, 0, "seat3");
        this.choose4 = new ActionEvent(this, 0, "seat4");
        
        // if console
        if (dialog instanceof SnoopOnPlayerConsole)
        {
            isConsole = true;
        }
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
        switch (cmd)
        {
            case "ok":
                dialog.setOKButton(false);
                dialog.dispose();
                break;
            case "seat1":
                clickSeat(1);
                break;
            case "seat2":
                clickSeat(2);
                break;
            case "seat3":
                clickSeat(3);
                break;
            case "seat4":
                clickSeat(4);
                break;
            default:
                break;
        }
    }
    
    private void clickSeat(int num)
    {
        // disable all buttons
        for (int button = 1; button <= kNumButtons; button++)
        {
            dialog.setSeatButton(button, false);
        }
        
        dialog.setOKButton(true);
        dialog.setSeatButton(num, true);
        chosenPlayer = list.get(num);
    }
    
    /**
     * Returns the player chosen to the GameEngine
     *
     * @return the chosen player
     */
    public Player showDialog()
    {
        return chosenPlayer;
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
     * Handles keyEvents to trigger ok, and choose 1-5.
     * 
     * @param e keyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {
        // if not console
        if (!isConsole)
        {
            gui = (SnoopOnPlayerDialog) this.dialog;
        }
        
        //if ok is selected
        
        keyPressedOne(e);
        keyPressedTwo(e);
    }
    
    private void keyPressedOne(KeyEvent e)
    {
        //if ok is selected
        if(e.getKeyCode() == KeyEvent.VK_SPACE && 
                (isConsole || gui.getOkButton().isEnabled()))
        {
            this.actionPerformed(ok);
        }
        //if choose1 is selected
        else if (e.getKeyCode() == KeyEvent.VK_1 && 
                (isConsole || gui.getSeat(1).isEnabled()))
        {
            this.actionPerformed(choose1);
        }
        //if choose2 is selected
        else if (e.getKeyCode() == KeyEvent.VK_2 && 
                (isConsole || gui.getSeat(2).isEnabled()))
        {
            this.actionPerformed(choose2);
        }
    }
    
    private void keyPressedTwo(KeyEvent e)
    {
        // if 3 is selected
        if (e.getKeyCode() == KeyEvent.VK_3 && 
                (isConsole || gui.getSeat(3).isEnabled()))
        {
            this.actionPerformed(choose3);
        }
        //if choose4 is selected
        else if (e.getKeyCode() == KeyEvent.VK_4 && 
                (isConsole || gui.getSeat(4).isEnabled()))
        {
            this.actionPerformed(choose4);
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
