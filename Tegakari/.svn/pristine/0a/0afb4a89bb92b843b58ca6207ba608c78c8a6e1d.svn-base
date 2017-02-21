package guiConsoleController;

import allguis.PrivateTipToDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import tegakari.*;

/**
 * Controller class for SnoopOnPlayerDialog.
 * 
 * @author Jonathan Molina
 */
public class PrivateTipToDialogController implements ActionListener, KeyListener
{
    /**
     * The view
     */
    private I_PrivateTipToDialog view;
    private boolean isConsole;
    private List<Player> players;
    private Player chosenPlayer;
    private boolean hasChosenPlayer;
    
    private ActionEvent ok;
    private ActionEvent choose1;
    private ActionEvent choose2;
    private ActionEvent choose3;
    private ActionEvent choose4;
    private PrivateTipToDialog gui;

    /**
     * Creates an instance of this controller class.
     * 
     * @param aConsole to set this controller to console mode
     * @param aView the view that this controller handles
     * @param listPlayers the list of players in this game
     */
    public void setup(boolean aConsole, I_PrivateTipToDialog aView, 
            List<Player> listPlayers)
    {
        this.view = aView;
        this.isConsole = aConsole;
        this.players = listPlayers;
        this.chosenPlayer = listPlayers.get(0);
        this.hasChosenPlayer = false;
        
        this.ok = new ActionEvent(this, 0, "OK");
        this.choose1 = new ActionEvent(this, 0, "1");
        this.choose2 = new ActionEvent(this, 0, "2");
        this.choose3 = new ActionEvent(this, 0, "3");
        this.choose4 = new ActionEvent(this, 0, "4");
    }

    /**
     * Will close the dialog.
     * 
     * @param event the action event
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String buttonName = event.getActionCommand();
        // check if the ok button was pressed
        if (buttonName.equals("OK"))
        {
            // if has chosen player
            if (hasChosenPlayer)
            {
                view.setOK(false);
                view.eraseWindow();
            }
        }
        // if 1
        else if(buttonName.equals("1"))
        {
            clickSeat(0);
        }
        // if 2
        else if(buttonName.equals("2"))
        {
            clickSeat(1);
        }
        // if 3
        else if(buttonName.equals("3"))
        {
            clickSeat(2);
        }
        // if 4
        else if(buttonName.equals("4"))
        {
            clickSeat(3);
        }
    }
    
    private void clickSeat(int seat)
    {
        // disable all buttons
        view.disableAll();
        //ENDFOR
        view.setOK(true);               
        view.setButton(seat, true);
        chosenPlayer = players.get(seat);
        hasChosenPlayer = true;
        
    }
    
    /**
     * shows the chosen player
     * @return the player chosen
     */
    public Player showDialog()
    {
        return chosenPlayer;
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
        // if not console
        if (!isConsole)
        {
            gui = (PrivateTipToDialog) this.view;
        }
        
        keyPressedOne(e);
        keyPressedTwo(e);
    }
    
    private void keyPressedOne(KeyEvent e)
    {
        // ok
        if(e.getKeyCode() == KeyEvent.VK_O && 
                (isConsole || gui.getOkButton().isEnabled()))
        {
            this.actionPerformed(ok);
        }
        // if 1
        else if (e.getKeyCode() == KeyEvent.VK_1 && 
                (isConsole || gui.getSeat(1).isEnabled()))
        {
            this.actionPerformed(choose1);
        }
        // if 2
        else if (e.getKeyCode() == KeyEvent.VK_2 && 
                (isConsole || gui.getSeat(2).isEnabled()))
        {
            this.actionPerformed(choose2);
        }
    }
    
    private void keyPressedTwo(KeyEvent e)
    {
        // if 3
        if (e.getKeyCode() == KeyEvent.VK_3 && 
                (isConsole || gui.getSeat(3).isEnabled()))
        {
            this.actionPerformed(choose3);
        }
        // if 4
        else if (e.getKeyCode() == KeyEvent.VK_4 && 
                (isConsole || gui.getSeat(4).isEnabled()))
        {
            this.actionPerformed(choose4);
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
