/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_test;

import allguis.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author DeionLaw
 */
public class GUITestSuite extends TestCase {
    
    public GUITestSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("GUITestSuite");
        suite.addTestSuite(AccusationConfirmTest.class);
        suite.addTestSuite(AccusationDialogTest.class);
        suite.addTestSuite(AccusationResultTest.class);
        suite.addTestSuite(ChooseThemeDialogTest.class);
        suite.addTestSuite(CreateRobotDialogTest.class);
        //suite.addTestSuite(DMPileDialogTest.class);
        suite.addTestSuite(DisproveTest.class);
        suite.addTestSuite(HelpDialogTest.class);
        suite.addTestSuite(LobbyGUITest.class);
        suite.addTestSuite(MainWindowTest.class);
        suite.addTestSuite(NoOneDisproveDialogTest.class);
        suite.addTestSuite(NoWinnerDialogTest.class);
        suite.addTestSuite(NotePadDialogTest.class);
        suite.addTestSuite(PrivateTipFromDialogTest.class);
        suite.addTestSuite(PrivateTipToDialogTest.class);
        suite.addTestSuite(ReplayGameTest.class);
        suite.addTestSuite(ScreenNameTest.class);
        suite.addTestSuite(ShowCardTest.class);
        suite.addTestSuite(SleuthOnMeTest.class);
        suite.addTestSuite(SleuthResultTest.class);
        suite.addTestSuite(SleuthTest.class);
        suite.addTestSuite(SnoopDialogTest.class);
        suite.addTestSuite(SnoopOnMeDialogTest.class);
        suite.addTestSuite(SnoopOnPlayerDialogTest.class);
        suite.addTestSuite(SuggestionAndMoveTest.class);
        suite.addTestSuite(SuggestionDialogTest.class);
        
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
}
