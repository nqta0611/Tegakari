package guiConsoleController;

import tegakari.Solution;

/**
 * The Console for NoWinner
 * @author DeionLaw
 */
public class NoWinnerConsole implements I_NoWinner
{
    private NoWinnerController ctrl;
    private Solution solution;
    
    /**
     * The constructor for NoWinnerConsole
     * @param aCtrl the controller to use
     * @param aSolution the solution
     */
    public NoWinnerConsole(NoWinnerController aCtrl, Solution aSolution)
    {
        this.ctrl = aCtrl;
        this.solution = aSolution;
    }
    
    /**
     * starts the console
     */
    public void startDialog()
    {
        System.out.println("Game Result: No Winner");
        System.out.println("All players made false accusations or"
                    + " some player disconnected.\n");
        System.out.println("Correct Solution: " + solution.getSuspect().getName() + 
                    " " + solution.getVehicle().getName() + " " + 
                    solution.getDestination().getName());
    }
}
