package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;

/**
 *
 * @author DeionLaw
 */
public class SleuthTest extends UISpecTestCase
{
    private SleuthDialog view;
    private SleuthDialogController ctrl;
    private SuperSleuthCard card;
    
    
    public SleuthTest(String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        card = new SuperSleuthCard(ClueType.VEHICLE, 
                Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg");
        ctrl = mock(SleuthDialogController.class);
        view = new SleuthDialog(new JFrame(), true, card, ctrl);
        ctrl.setup(view, false);
    }
    
    public void testOKButton()
    {
        Window window = new Window(view);
        Button ok = window.getButton();
        
        ok.click();
        
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
        
    }
}
