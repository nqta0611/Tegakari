package guiConsoleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import tegakari.*;
import java.util.*;

/**
 * Controller class for SnoopDialog.
 * 
 * @author Jonathan Molina
 */
public class SnoopDialogController implements ActionListener, KeyListener
{
    /**
     * The view
     */
    private I_SnoopDialog dialog;
    private final int kNumButtons = 6;
    private ClueCard pickedCard;
    
    private ActionEvent ok;
    private ActionEvent choose1;
    private ActionEvent choose2;
    private ActionEvent choose3;
    private ActionEvent choose4;
    private ActionEvent choose5;
    private ActionEvent choose6;
    /**
     * Creates an instance of this controller class.
     * 
     * @param view the SnoopOnMeDialog
     * @param cardsToSnoop list of clue cards
     */
    public void setup(I_SnoopDialog view, List<ClueCard> cardsToSnoop)
    {
        this.dialog = view;
        int rand = (int) (Math.random() * cardsToSnoop.size());
        this.pickedCard = cardsToSnoop.get(rand);
        
        this.ok = new ActionEvent(this, 0, "ok");
        this.choose1 = new ActionEvent(this, 0, "card1");
        this.choose2 = new ActionEvent(this, 0, "card2");
        this.choose3 = new ActionEvent(this, 0, "card3");
        this.choose4 = new ActionEvent(this, 0, "card4");
        this.choose5 = new ActionEvent(this, 0, "card5");
        this.choose6 = new ActionEvent(this, 0, "card6");
    }

    /**
     * The actions performed but the JButtons from the SnoopDialog class.
     * 
     * @param event the certain action event
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        // check if the ok button was pressed
        switch (cmd)
        {
            case "ok":
                dialog.dispose();
                break;
            case "card1":
                clickCard(1);
                break;
            case "card2":
                clickCard(2);
                break;
            case "card3":
                clickCard(3);
                break;
            case "card4":
                clickCard(4);
                break;
            case "card5":
                clickCard(5);
                break;
            case "card6":
                clickCard(6);
                break;
            default:
                break;
        }
    }
    
    private void clickCard(int card)
    {
        // disable all buttons
        for (int button = 1; button <= kNumButtons; button++)
        {
            dialog.setCardButton(button, false);
        }
        
        dialog.setIcon(card, pickedCard);
        dialog.setCardButton(card, true);
        dialog.setOKButton(true);
    }
    
    /**
     * Returns the card chosen
     *
     * @return the clue card
     */
    public ClueCard showDialog()
    {
        return pickedCard;
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
     * Handles keyEvents to trigger ok, or card chosen actions.
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
        //if card 1 is selected
        else if (e.getKeyCode() == KeyEvent.VK_1)
        {
            this.actionPerformed(choose1);
        }
        //if card 2 is selected
        else if (e.getKeyCode() == KeyEvent.VK_2)
        {
            this.actionPerformed(choose2);
        }
        //if card 3 is selected
        else if (e.getKeyCode() == KeyEvent.VK_3)
        {
            this.actionPerformed(choose3);
        }
        //if card 4 is selected
        else if (e.getKeyCode() == KeyEvent.VK_4)
        {
            this.actionPerformed(choose4);
        }
        //if card 5 is selected
        else if (e.getKeyCode() == KeyEvent.VK_5)
        {
            this.actionPerformed(choose5);
        }
        //if card 6 is selected
        else if (e.getKeyCode() == KeyEvent.VK_6)
        {
            this.actionPerformed(choose6);
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
