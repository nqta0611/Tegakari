package GUI_test;

import org.uispec4j.*;
import allguis.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tegakari.*;
import java.util.*;
import static junit.framework.Assert.assertFalse;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import guiConsoleController.*;


/**
 * UISpec4J GUI Unit test for PrivateTipFromDialog.
 * 
 * @author Chris Thibodeau - cathibod
 */
public class PrivateTipFromDialogTest extends UISpecTestCase
{
    private PrivateTipFromDialog view6;
    private PrivateTipFromDialog view1;
    private PrivateTipFromDialog view0;
    private PrivateTipFromDialogController ctrl;
    private JFrame parent;
    private Player turnPlayer;
    private PrivateTipCard privateTip;
    private PrivateTipCard privateTipAll;
    private List<ClueCard> cardsToShow6;
    private List<ClueCard> cardsToShow1;
    private List<ClueCard> cardsToShow0;
    private Theme theme;
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        
        turnPlayer = mock(HumanPlayer.class);
        when(turnPlayer.getName()).thenReturn("player1");
        
        cardsToShow6 = new ArrayList<ClueCard>();
        cardsToShow1 = new ArrayList<ClueCard>();
        cardsToShow0 = new ArrayList<ClueCard>();
        theme = new Theme();
        for(int i = 0; i < 6; i++)
        {
            cardsToShow6.add(new SuspectCard(theme.getSuspects().get(i)));
        }
        cardsToShow1.add(new SuspectCard(theme.getSuspects().get(0)));
        
        privateTip = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, "");
        privateTipAll = new PrivateTipCard(ClueType.SUSPECT,"");
        
        ctrl = mock(PrivateTipFromDialogController.class);
        parent = new JFrame();
        view6 = new PrivateTipFromDialog(ctrl, parent, true, turnPlayer,
                privateTipAll, cardsToShow6);
        view1 = new PrivateTipFromDialog(ctrl, parent, true, turnPlayer,
                privateTip, cardsToShow1);
        view0 = new PrivateTipFromDialog(ctrl, parent, true, turnPlayer,
                privateTip, cardsToShow0);
    }

    public void testText()
    {
        System.out.println("testText");
        Window window = new Window(view6);
        
        TextBox titleText = 
                window.getTextBox("titleText");
        TextBox descText = window.getTextBox("descText");
        TextBox subText = 
                window.getTextBox("subText");
        assertEquals("Private Tip Request", titleText.getText());
        assertEquals("played this Private Tip on you and saw these cards.", 
                descText.getText());
        assertEquals("<Private Tip Card>", 
                subText.getText());
    }
    
    /**
     * Test of disableAll method, of class PrivateTipToDialog.
     */
    public void testDisableCards() 
    {
        System.out.println("disableAll");
        Window window = new Window(view6);
        
        List<String> cardButtons = Arrays.asList("cardButton1", "cardButton2", 
                "cardButton3", "cardButton4", "cardButton5", "cardButton6");
        
        view6.setEnabledButton("1");
        assertTrue(window.getButton("cardButton1").isEnabled());
        view6.setEnabledButton("4");
        assertTrue(window.getButton("cardButton4").isEnabled());
        view6.disableCards();
        for(String button : cardButtons)
        {
            assertFalse(window.getButton(button).isEnabled());
        }
    }

    /**
     * Test of setOK method, of class PrivateTipToDialog.
     */
    public void testSetEnabledOK() {
        System.out.println("setEnabledOK");
        Window window1 = new Window(view6);
        
        assertTrue(window1.getButton("okButton").isEnabled());
        
        Window window2 = new Window(view1);
        assertTrue(window2.getButton("okButton").isEnabled());
        
        Window window3 = new Window(view1);
        assertTrue(window3.getButton("okButton").isEnabled());
    }

    public void testOKButton()
    {
        Window window = new Window(view6);
        Button okButton = window.getButton("okButton");
        
        view6.setEnabledOK();
        okButton.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton6()
    {
        Window window = new Window(view6);
        Button cardButton6 = window.getButton("cardButton6");
        
        view6.setEnabledButton("6");
        cardButton6.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton5()
    {
        Window window = new Window(view6);
        Button cardButton5 = window.getButton("cardButton5");
        
        cardButton5.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton4()
    {
        Window window = new Window(view6);
        Button cardButton4 = window.getButton("cardButton4");
        
        cardButton4.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton3()
    {
        Window window = new Window(view6);
        Button cardButton3 = window.getButton("cardButton3");
        
        cardButton3.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton2()
    {
        Window window = new Window(view6);
        Button cardButton2 = window.getButton("cardButton2");
        
        cardButton2.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
    public void testcardButton1()
    {
        Window window = new Window(view6);
        Button cardButton1 = window.getButton("cardButton1");
        
        cardButton1.click();
        ArgumentCaptor<ActionEvent> argument = ArgumentCaptor.forClass(ActionEvent.class);
                
        verify(ctrl).actionPerformed(argument.capture());
    }
}
