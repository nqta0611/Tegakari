/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import allguis.NotePadDialog;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import tegakari.*;

/**
 * The controller for NotePad
 * @author Tarrant
 */
public class NotePadController implements ActionListener
{
    private NotePadDialog note;
    private boolean isConsole;
    
    /**
     * sets up the controller
     * @param aConsole if it is a console
     * @param aNote the NotePadDialog
     */
    public void setup(boolean aConsole, NotePadDialog aNote)
    {
        this.isConsole = aConsole;
        this.note = aNote;
        
        
    }
    
    /**
     * action performed
     * @param e the action
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String cmd = e.getActionCommand();
        
        Scanner scan = new Scanner(cmd);
        
        String name = scan.next();
        int card = scan.nextInt();
        
        //System.out.println("this was chosen: " + name + " " + card);
        if (name.equals("suspect"))
        {
            setBackground(note.suspect.get(card));
        }
        // if vehicle
        else if (name.equals("vehicle"))
        {
            setBackground(note.vehicle.get(card));
        }
        // if destination
        else if (name.equals("destination"))
        {
            setBackground(note.destination.get(card));
        }
    }
    
    private void setBackground(JButton colorButton)
    {
        Color color = colorButton.getBackground();
        
        // if color is black
        if (color.equals(Color.black))
        {
            colorButton.setBackground(Color.blue);
        }
        // if color is blue
        else if (color.equals(Color.blue))
        {
            colorButton.setBackground(Color.green);
        }
        // if color is green
        else if (color.equals(Color.green))
        {
            colorButton.setBackground(Color.red);
        }
        // if color is red
        else if (color.equals(Color.red))
        {
            colorButton.setBackground(Color.black);
        }
    }
    
}
