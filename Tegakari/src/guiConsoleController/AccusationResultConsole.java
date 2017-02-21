/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

import tegakari.*;
/**
 * The console for accusation result
 * @author jchoi30
 */
public class AccusationResultConsole implements I_AccusationResult
{
    private AccusationResultController ctrl;
    private AccusationMessage accusation;
    /**
     * The constructor
     * @param ctrl the controller
     * @param accusation the accusation
     */        
    public AccusationResultConsole(AccusationResultController ctrl, 
            AccusationMessage accusation)
    {
        this.ctrl = ctrl;
        this.accusation = accusation;
    }
    /**
     * starts the console
     */
    public void startDialogue()
    {
        boolean isTurnPlayer = accusation.getCreator().getName().equals(
                accusation.getShowTo().getName());
        // if is turnplayer
        if (isTurnPlayer)
        {
            System.out.println("Your accusation:");
        }
        // else
        else
        {
            System.out.println(accusation.getCreator().getName() + " accuses:");
        }
        //System.out.println(isTurnPlayer ? "Your accusation:" : 
        //(accusation.getCreator().getName() + " accuses:"));
        
        System.out.println(accusation.getAccusation().getSuspect().getName());
        System.out.println(accusation.getAccusation().getVehicle().getName());
        System.out.println(accusation.getAccusation().getDestination().getName());

        //System.out.println(accusation.isCorrect()
     //? "Which matches the correct solution" :
        //"Which does not match the correct solution");
        // if accusation is correct
        if (accusation.isCorrect())
        {
            System.out.println("Which matches the correct solution");
        }
        // else
        else
        {
            System.out.println("Which does not match the correct solution");
        }
        // if you are turn player
        if (isTurnPlayer)
        {
            System.out.println(accusation.getSolution().getSuspect().getName());
            System.out.println(accusation.getSolution().getVehicle().getName());
            System.out.println(accusation.getSolution().getDestination().getName());
        }
        
        //System.out.println((isTurnPlayer ? "You" : 
        //accusation.getCreator().getName()) + 
        //(accusation.isCorrect() ? " WIN The Game " : " Lost The Game"));
        
        // if turnplyae
        if (isTurnPlayer)
        {
            System.out.print("You " + accusation.getCreator().getName());
            // if accusation correct
            if (accusation.isCorrect())
            {
                System.out.print(" WIN The Game \n");
            }
            // else
            else
            {
                System.out.print(" Lost The Game\n");
            }
        }
        //else
        else
        {
            
        }
    }
    /**
     * dispose of the console
     */
    public void dispose()
    {
        
    }
}
