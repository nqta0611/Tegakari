package guiConsoleController;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import tegakari.Solution;

/**
 * The console for Replay
 * @author DeionLaw
 */
public class ReplayConsole implements I_Replay
{
    private boolean result;
    private ReplayController controller;
    private Scanner input;
    
    /**
     * The constructor for ReplayConsole
     * @param scanner the scanner to use
     */
    public ReplayConsole(Scanner scanner)
    {
        this.input = scanner;
    }
        
    /**
     * starts up the console
     */
    public void startDialogue()
    {
        boolean foundValidResult = false;
        char reply = ' ';
        
        System.out.println("Game Over");
        System.out.println("Play again? Enter: (y/n)");
        // do the following
        do
        {
            reply = Character.toLowerCase(input.nextLine().charAt(0));
            // if yes
            if(reply == 'y')
            {
                result = true;
                foundValidResult = true;
                controller.actionPerformed(new ActionEvent(this, 0, "replay"));
            }
            // if no
            else if(reply == 'n')
            {
                result = false;
                foundValidResult = true;
                controller.actionPerformed(new ActionEvent(this, 0, "no"));
            }
            else
            {
                System.out.println("Invalid reply.");
                System.out.println("Play again? Enter: (y/n)");
            }
        } 
        while(!foundValidResult);
        
        
    }
    
    /**
     * sets the controller
     * @param controller what to set it to
     */
    public void setController(ReplayController controller)
    {
        this.controller = controller;
    }
    
    /**
     * displays the result
     * @return the result
     */
    public boolean showDialog()
    {
        return result;
    }

    /**
     * if not replaying game
     */
    @Override
    public void noReplay() 
    {
        
    }

    /**
     * if replaying the game
     */
    @Override
    public void yesReplay() 
    {
        
    }
}
