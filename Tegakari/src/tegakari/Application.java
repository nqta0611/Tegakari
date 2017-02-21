package tegakari;
import guiConsoleController.MainWindowController;
import guiConsoleController.ConsoleLobbyPhase;
import allguis.*;
import java.util.Arrays;
import java.util.List;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;

/**
 * Application is the starting point that begins the client application for
 * Tegakari. This class is responsible for connecting the
 * <code>Player</code> to the desired lobby and for closing the client
 * application when prompted to quit.
 *
 * @author Jonathan Molina
 * @version 12/5/15 Version 1.0
 */
public class Application
{
    /**
     * The minimum number of players needed to start.
     */
    private static final int kMinNumPlayersStart = 3;
    /**
     * The minimum number of players needed to start.
     */
    private static final int kMaxPlayersAllowed = 5;
    /**
     * Variable will indicate which input will be taken from console
     */
    private static FileInputStream in;
    
    /**
     * Begins the client application for Tegakari. The following command lines
     * can be used to connect to a servers or make certain action and clue decks.
     * <br>
     * -localhost : Connects to a server on the default port of 51000 on localhost.<br>
     * -server "IP.ADDRESS" : Connects to a server on the default port of 51000
     * to the given "IP.ADDRESS" (e.g. -server 129.65.150.243).<br>
     * -t "cluedeck.txt" "actiondeck.txt" : Builds a specific ordered clue and
     * action deck. The client with these command flag presets would need to
     * be the first connected client to the server.<br>
     *
     * @param args the list of files provided to make a specific deck or
     * to connect to a specific server
     */
    public static void main(String[] args)
    {
        List<String> listArgs = Arrays.asList(args);
        Lobby lobby;
        boolean isConsole = false;
        boolean useSystem = false;
        
        // CONNECT to localhost server
        if (listArgs.contains("-localhost"))
        {
            lobby = new Lobby(kMinNumPlayersStart, kMaxPlayersAllowed, true);
        }
        // CONNECT to given IP address of a server
        else if (listArgs.contains("-server"))
        {
            int indexOf = listArgs.indexOf("-server");
            String serverIP = "";
            
            try
            {
                serverIP = listArgs.get(indexOf+1);
            } 
            catch (IndexOutOfBoundsException exception)
            {
                System.out.println("Include a valid IP address of "
                    + "the target server immediately following the '-server' "
                    + "flag. E.g: -server 129.65.150.243");
            }
            lobby = new Lobby(kMinNumPlayersStart, kMaxPlayersAllowed, serverIP);
        }
        // CONNECT to VM server
        else
        {
            lobby = new Lobby(kMinNumPlayersStart, kMaxPlayersAllowed);
        }
        
        //Set testing mode flag, 
        //the 1st player of lobby will send it to sever.
        if (listArgs.contains("-t"))
        {
            lobby.setTestingMode(listArgs.get(listArgs.indexOf("-t")+1),
                                 listArgs.get(listArgs.indexOf("-t")+2));
        }
        
        //Set input/output/error flag and which files to output/input to
        if (listArgs.contains("-i"))
        {
            useSystem = inputCommand(listArgs);
        }
        isConsole = listArgs.contains("-console");
        // check for console flage
        if (isConsole)
        {
            lobby.setConsoleMode(true);
            runConsole(useSystem, lobby);
        }
        else 
        {
            runSwingGUI(lobby);
        }
    }
    
    private static void runSwingGUI(Lobby lobby)
    {
        // CREATE gui instance passing the Lobby in as a param
        MainWindowController controller = new MainWindowController();
        MainWindow mainWindow = new MainWindow(controller);
        // LAYOUT the gui
        // SET gui visibility to true
        controller.setup(mainWindow, lobby, false);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    private static void runConsole(boolean useSystem, Lobby lobby)
    {
        Scanner input = null;
        // check for input file
        if (useSystem)
        {
            input = new Scanner(in);
        }
        else
        {
            input = new Scanner(System.in);
        }
        lobby.setInputMode(input);
        MainWindowController controller = new MainWindowController();
        ConsoleLobbyPhase mainWindow = 
                new ConsoleLobbyPhase(controller, lobby, input);
        controller.setup(mainWindow, lobby, true);
        mainWindow.lobbyPhase();
    }
    
    private static boolean inputCommand(List<String> listArgs)
    {
        boolean useSystem = false;
        
        try
        {
            in = new FileInputStream(new File(listArgs.get(listArgs.indexOf("-i")+ 1)));
            useSystem = true;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("file not found, check your arguments for input");
        }
        try
        {
            System.setOut(new PrintStream(new File(
                    listArgs.get(listArgs.indexOf("-i")+ 2))));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("file not found, check your arguments for output");
        }
        try
        {
            System.setErr(new PrintStream(new File(
                    listArgs.get(listArgs.indexOf("-i")+ 3))));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("file not found, check your arguments for error");
        }
        
        return useSystem;
    }

}