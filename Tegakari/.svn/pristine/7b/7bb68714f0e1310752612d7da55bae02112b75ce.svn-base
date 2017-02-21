package GUI_test;

import allguis.*;
import tegakari.*;
import org.uispec4j.*;
import org.uispec4j.interception.*;
import static org.mockito.Mockito.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import guiConsoleController.*;

/**
 *
 * @author ericroh
 */
public class AccusationResultTest extends UISpecTestCase 
{
    private JFrame parent;
    private AccusationResult view;
    private Window window;
    private AccusationMessage message;
    private Theme theme;
    private Solution solution;
    private Solution wrong;
    private Solution correct;
    private Player self;
    private AccusationResultController ctrl;
    
    public AccusationResultTest(String testName) {
        super(testName);
        ctrl = new AccusationResultController();
        self = new HumanPlayer("self");
        theme = new Theme();
        correct = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        solution = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        wrong = new Solution(theme.getSuspects().get(2), 
                theme.getVehicles().get(2), theme.getDestinations().get(2));
        parent = new JFrame();
    }

    public void testWrongSelf() {
        System.out.println("testWrongSelf");
        message = new AccusationMessage(wrong, solution, self);
        message.setShowTo(self);
        message.setIsCorrect(false);

        view = new AccusationResult(ctrl, parent, true, message);
        ctrl.setup(view);
        window = new Window(view);
        TextBox accusationText = window.getTextBox("accusationText");
        TextBox playerAccusesText = window.getTextBox("playerAccusesText");
        TextBox resultPrefixText = window.getTextBox("resultPrefixText");
        TextBox outcomeText = window.getTextBox("outcomeText");
        
        String expected = message.getAccusation().toString();
        assertEquals(expected, accusationText.getText());
        expected = "Your accusation:";
        assertEquals(expected, playerAccusesText.getText());
        expected = " Which does not match the correct solution";
        assertEquals(expected, resultPrefixText.getText());
        expected = "You Lost The Game";
        assertEquals(expected, outcomeText.getText());
    }
    
    public void testWrongOthers() {
        System.out.println("testWrongOthers");
        message = new AccusationMessage(wrong, solution, self);
        Player others = new HumanPlayer("Others");
        message.setShowTo(others);
        message.setIsCorrect(false);
        view = new AccusationResult(ctrl, parent, true, message);
        ctrl.setup(view);
        window = new Window(view);
        TextBox accusationText = window.getTextBox("accusationText");
        TextBox playerAccusesText = window.getTextBox("playerAccusesText");
        TextBox resultPrefixText = window.getTextBox("resultPrefixText");
        TextBox outcomeText = window.getTextBox("outcomeText");
        
        String expected = message.getAccusation().toString();
        assertEquals(expected, accusationText.getText());
        expected = "self accuses:";
        assertEquals(expected, playerAccusesText.getText());
        expected = " Which does not match the correct solution";
        assertEquals(expected, resultPrefixText.getText());
        expected = "self Lost The Game";
        assertEquals(expected, outcomeText.getText());
    }
    
    public void testCorrectSelf() {
        System.out.println("testCorrectSelf");
        message = new AccusationMessage(correct, solution, self);
        message.setShowTo(self);
        message.setIsCorrect(true);
        view = new AccusationResult(ctrl, parent, true, message);
        ctrl.setup(view);
        window = new Window(view);
        TextBox accusationText = window.getTextBox("accusationText");
        TextBox playerAccusesText = window.getTextBox("playerAccusesText");
        TextBox resultPrefixText = window.getTextBox("resultPrefixText");
        TextBox outcomeText = window.getTextBox("outcomeText");
        
        String expected = message.getAccusation().toString();
        assertEquals(expected, accusationText.getText());
        expected = "Your accusation:";
        assertEquals(expected, playerAccusesText.getText());
        expected = " Which matches the correct solution";
        assertEquals(expected, resultPrefixText.getText());
        expected = "You WIN The Game ";
        assertEquals(expected, outcomeText.getText());
    }
    
    public void testCorrectOthers() {
        System.out.println("testCorrectOthers");
        message = new AccusationMessage(correct, solution, self);
        Player others = new HumanPlayer("Others");
        message.setShowTo(others);
        message.setIsCorrect(true);
        view = new AccusationResult(ctrl, parent, true, message);
        ctrl.setup(view);
        window = new Window(view);
        TextBox accusationText = window.getTextBox("accusationText");
        TextBox playerAccusesText = window.getTextBox("playerAccusesText");
        TextBox resultPrefixText = window.getTextBox("resultPrefixText");
        TextBox outcomeText = window.getTextBox("outcomeText");
        
        String expected = message.getAccusation().toString();
        assertEquals(expected, accusationText.getText());
        expected = "self accuses:";
        assertEquals(expected, playerAccusesText.getText());
        expected = " Which matches the correct solution";
        assertEquals(expected, resultPrefixText.getText());
        expected = "self WIN The Game ";
        assertEquals(expected, outcomeText.getText());
    }
    
    public void testOkButtons() 
    {
        System.out.println("testOkButtons");
        message = new AccusationMessage(correct, solution, self);
        Player others = new HumanPlayer("Others");
        message.setShowTo(others);
        message.setIsCorrect(true);
        view = new AccusationResult(ctrl, parent, true, message);
        ctrl.setup(view);
        window = new Window(view);
        Button okButton = window.getButton("okButton");
       
        okButton.click();
        assertFalse(view.isVisible());
    }
}
