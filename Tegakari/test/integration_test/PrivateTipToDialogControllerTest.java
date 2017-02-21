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
import javax.swing.JButton;

/**
 *
 * @author TTStarck
 */
public class PrivateTipToDialogControllerTest extends TestCase {
    private I_PrivateTipToDialog view;
    
    private PrivateTipToDialogController ctrl;
    private Player p;
    
    public PrivateTipToDialogControllerTest(String testName) {
        super(testName);
        
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
        p = new HumanPlayer("hi", hand, d);
        List<Player> list = new LinkedList<Player>();
        list.add(p);
        list.add(p);
        list.add(p);
        list.add(p);
        ctrl = new PrivateTipToDialogController();
        Scanner scan = new Scanner("h");
        view = new PrivateTipToDialogConsole(ctrl, list, scan);
        ctrl.setup(true, view, list);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testKeys()
    {
        JButton btn = new JButton("");
        final KeyEvent ok = new KeyEvent(btn,0,0,KeyEvent.VK_O,
                KeyEvent.VK_O,'s');
        final KeyEvent one = new KeyEvent(btn,0,0,KeyEvent.VK_1,
                KeyEvent.VK_1,'1');
        final KeyEvent two = new KeyEvent(btn,0,0,KeyEvent.VK_2,
                KeyEvent.VK_2,'2');
        final KeyEvent three = new KeyEvent(btn,0,0,KeyEvent.VK_3,
                KeyEvent.VK_3,'3');
        final KeyEvent four = new KeyEvent(btn,0,0,KeyEvent.VK_4,
                KeyEvent.VK_4,'4');
        
        ctrl.keyReleased(one);
        ctrl.keyTyped(one);
        
        ctrl.keyPressed(one);
        assertEquals(ctrl.showDialog(), p);
        ctrl.keyPressed(two);
        assertEquals(ctrl.showDialog(), p);
        ctrl.keyPressed(three);
        assertEquals(ctrl.showDialog(), p);
        ctrl.keyPressed(four);
        assertEquals(ctrl.showDialog(), p);
        
        ctrl.keyPressed(ok);
    }
}
