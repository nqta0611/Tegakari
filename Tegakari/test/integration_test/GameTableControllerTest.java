/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import junit.framework.TestCase;
import tegakari.*;
import guiConsoleController.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JButton;
import allguis.*;

import static org.mockito.Mockito.*;

/**
 *
 * @author TTStarck
 */
public class GameTableControllerTest extends TestCase {
    private I_GameTable view;
    private boolean isConsole;
    private GameEngine engine;
    private GameState state;
    private Player selfPlayer;
    private ActionEvent dealer;
    private ActionEvent action1;
    private ActionEvent action2;
    private ActionEvent endTurn;
    private ActionEvent accuse;
    private ActionEvent notepad;
    private ActionEvent rules;
    private Scanner input;
    private AtomicBoolean bool;
    
    GameTableController ctrl;
    public GameTableControllerTest(String testName) {
        super(testName);
        bool = new AtomicBoolean();
        isConsole = true;
        ctrl = new GameTableController();
        input = new Scanner("1\n 2\n 3\n");
        
        Theme theme = new Theme();
        Table t = new Table(theme);
        Hand hand = new Hand();
        
        List<Attribute> att = new ArrayList<>();
        att.add(Attribute.RED);
        Destination d = new Destination("bob", att, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        ActionCard a1 = new PrivateTipCard(ClueType.DESTINATION,
                "/image/GreeceImages/Suspects-Hera.jpg");
        ActionCard a2 = new PrivateTipCard(ClueType.SUSPECT, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        hand.addToHand(a1);
        hand.addToHand(a2);
        Player p = new HumanPlayer("hi", hand, d);
        Queue<Player> list = new LinkedList<Player>();
        list.add(p);
        state = mock(GameState.class);
        when(state.getPlayers()).thenReturn(list);
        when(state.getSelfPlayer()).thenReturn(p);
        when(state.getTable()).thenReturn(t);
        when(state.getTurnPlayer()).thenReturn(p);
        GameClient client = new GameClient("hi", 0);
        engine = new GameEngine(state, client);
        
        
        view = new GameTableConsole(ctrl, engine, input, bool);
        ctrl.setup(view, engine, isConsole, input);
        
        this.dealer = new ActionEvent(this, 0, "DealerActionPile");
        this.action1 = new ActionEvent(this, 0, "action1");
        this.action2 = new ActionEvent(this, 0, "action2");
        this.endTurn = new ActionEvent(this, 0, "EndTurn");
        this.accuse = new ActionEvent(this, 0, "Accuse");
        this.notepad = new ActionEvent(this, 0 , "Notepad");
        this.rules = new ActionEvent(this, 0, "Rules");
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testKeyEvents()
    {
        JButton btn = new JButton("");
        final KeyEvent dealer = new KeyEvent(btn,0,0,KeyEvent.VK_D,
                KeyEvent.VK_D,'d');
        final KeyEvent one = new KeyEvent(btn,0,0,KeyEvent.VK_1,
                KeyEvent.VK_1,'1');
        final KeyEvent two = new KeyEvent(btn,0,0,KeyEvent.VK_2,
                KeyEvent.VK_2,'2');
        final KeyEvent end = new KeyEvent(btn,0,0,KeyEvent.VK_E,
                KeyEvent.VK_E,'e');
        final KeyEvent acc = new KeyEvent(btn,0,0,KeyEvent.VK_A,
                KeyEvent.VK_A,'a');
        final KeyEvent note = new KeyEvent(btn,0,0,KeyEvent.VK_N,
                KeyEvent.VK_N,'n');
        final KeyEvent rule = new KeyEvent(btn,0,0,KeyEvent.VK_R,
                KeyEvent.VK_R,'r');
        
        final KeyEvent nothing = new KeyEvent(btn,0,0,KeyEvent.VK_Q,
                KeyEvent.VK_Q,'q');
        
        ctrl.keyPressed(nothing);
        ctrl.keyTyped(nothing);
        ctrl.keyReleased(nothing);
        
        ctrl.keyPressed(dealer);
        ctrl.keyPressed(one);
        ctrl.keyPressed(two);
        ctrl.keyPressed(end);
        ctrl.keyPressed(acc);
        ctrl.keyPressed(note);
        ctrl.keyPressed(rule);
        
        input = new Scanner("1\n 2\n 3\n y\n 1\n 2\n 3\n 4\n");
        view = new GameTableConsole(ctrl, engine, input, bool);
        ctrl.setup(view, engine, isConsole, input);
        ctrl.keyPressed(acc);
        
        
        verify(state, times(4)).getSelfPlayer();
    }
}
