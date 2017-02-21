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
public class ShowCardTest extends UISpecTestCase
{
    private ShowCardDialogController ctrl;
    private ShowCardDialog view;
    private JFrame parent;
    private List<CardMessage> receivedCards;
    private CardMessage message;
    private SuspectCard card;
    private Player from;
    private Player to;
             
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        from = new HumanPlayer("from");
        to = new HumanPlayer("to");
        
        Theme theme = new Theme();
        card = new SuspectCard(theme.getSuspects().get(0));
        receivedCards = new ArrayList<CardMessage>();
        List<Card> list = new ArrayList<Card>();
        list.add(card);
        message = new CardMessage(to, from, list);
        receivedCards.add(message);
        
        
        parent = new JFrame();
        ctrl = mock(ShowCardDialogController.class);
        view = new ShowCardDialog(ctrl, parent, true, receivedCards);
    }
    
    public void testText()
    {
        Window window = new Window(view);
        
        TextBox hasText = window.getTextBox("playerHasText");
        
        assertEquals("from has:", hasText.getText());
    }
    
    public void testOKButton()
    {
        Window window = new Window(view);
        Button okButton = window.getButton("okButton");
        
        okButton.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
        assertFalse(view.isVisible());
    }
}
