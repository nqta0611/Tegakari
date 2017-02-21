package guiConsoleController;

/**
 * The Console for SleuthDialog
 * @author jchoi30
 */
public class SleuthDialogConsole implements I_SleuthDialog
{
    private SleuthDialogController ctrl;

    /**
     * The constructor for this console
     * @param aCtrl the controller
     */
    public SleuthDialogConsole(SleuthDialogController aCtrl)
    {
        this.ctrl = aCtrl;
    }
    
    /**
     * starts the console
     */
    public void startDialog()
    {
        System.out.println("You played a Sleuth Card, please wait for players "
                + "to choose.");
    }
    
    /**
     * disposes of the view
     */
    public void dispose()
    {
    }
}
