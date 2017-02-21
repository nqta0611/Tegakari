package integration_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.WindowInterceptor;
import tegakari.Application;
import tegakari.GameServer;

/**
 *
 * @author cathibod
 */
public class ApplicationTest extends UISpecTestCase {
    
    public ApplicationTest(String testName) {
        super(testName);
    }
    
    static
    {
        UISpec4J.init();
    }
    /**
     * Test of main method, of class Application.
     */
    public void testMain() {
        System.out.println("main");
        final String[] args1 = {"-localhost", "-t", "./test/testsetup/t12clue", 
                            "./test/testsetup/t12action", "-console",
                            "-i", "./test/integration_test/AppTesttxt.in", 
                            "./test/integration_test/AppTesttxt.out", 
                            "./test/integration_test/AppTesttxt.err"};
        
        final String[] args2 = {"-server", "129.65.150.243", "-i", 
                            "./test/integration_test/AppTesttxtfail.in", 
                            "", 
                            ""};
        final String[] args3 = {"-server"};
        final String[] args4 = {""};
        Application app = new Application();
        GameServer server = new GameServer();
        try
        {
            server.listen();
        }
        catch(IOException e)
        {
            System.out.println();
        }
        
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException ex)
        {
            System.out.println(ex);
        }
        Application.main(args1);
        System.out.println("post arg1");
        
        
                        
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                       Application.main(args2);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Japanese").
                triggerButtonClick("quitButton")).run();
        
        System.out.println("post arg2");
        
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                       Application.main(args3);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Japanese").
                triggerButtonClick("quitButton")).run();
        
        System.out.println("post arg3");
        
        WindowInterceptor.init(
                new Trigger() 
                {
                    public void run() throws Exception
                    {
                       Application.main(args4);
                    }
                }
		).
                process(BasicHandler.init().
                assertContainsText("Japanese").
                triggerButtonClick("quitButton")).run();
        
        System.out.println("post arg4");
        
        //tests failure of input file
        try
        {
            FileInputStream in = new FileInputStream(
                    new File("./test/integration_test/AppTesttxtfail.in"));
            fail("Failed exception not caught.");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not found pass.");
        }
        try
        {
            server.close();
        }
        catch(IOException e)
        {
            System.out.println();
        }
    }
}
