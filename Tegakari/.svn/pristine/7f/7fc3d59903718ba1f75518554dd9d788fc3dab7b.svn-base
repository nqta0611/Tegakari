/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import tegakari.*;

/**
 * The console for CreateRobot
 * @author Tarrant
 */
public class CreateRobotConsole implements I_CreateRobot
{
    private CreateRobotController ctrl;
    private Scanner input;
    private AILevel level;
    private Lobby lobby;
    /**
     * The constructor
     * @param ctrl the controller
     * @param lobby the lobby
     * @param input the scanner to use
     */
    public CreateRobotConsole(CreateRobotController ctrl, Lobby lobby, Scanner input)
    {
        this.input = input;
        this.ctrl = ctrl;
        this.lobby = lobby;
        this.level = null;
    }
    
    /**
     * starts the console
     */
    public void startDialogue()
    {
        ActionEvent evt = null;
        
        System.out.println("What difficulty robot? Basic (b) or Smart (s)");
        String in = input.nextLine();
        // if b
        if (in.equals("b"))
        {
            evt = new ActionEvent(this, 0, "Basic");
            ctrl.actionPerformed(evt);
        }
        else
        {
            evt = new ActionEvent(this, 0, "Smart");
            ctrl.actionPerformed(evt);
        }
        
        evt = new ActionEvent(this, 0, "Create");
        ctrl.actionPerformed(evt);
    }
    
    /**
     * add a robot to the lobby
     */
    @Override
    public void addRobot() 
    {
        lobby.addRobot(level);
    }

    /**
     * sets the robot to smart
     */
    @Override
    public void setToSmart() 
    {
        level = AILevel.SMART;
    }

    /**
     * sets the robot to basic
     */
    @Override
    public void setToBasic() 
    {
        level = AILevel.BASIC;
    }
}
