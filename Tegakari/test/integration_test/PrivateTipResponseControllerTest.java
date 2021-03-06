/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration_test;

import guiConsoleController.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import junit.framework.TestCase;
import tegakari.*;


/**
 *
 * @author TTStarck
 */
public class PrivateTipResponseControllerTest extends TestCase {
    private I_PrivateTipResponse view;
    private boolean isConsole;
    private PrivateTipResponseController ctrl;
    private Player p;
    private List<ClueCard> list;
    private PrivateTipCardLogic logic;
    
    public PrivateTipResponseControllerTest(String testName) {
        super(testName);
        
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
        DestinationCard card = new DestinationCard(d);
        list = new ArrayList<ClueCard>();
        list.add(card);
        
        
        PrivateTipCard tip = new PrivateTipCard(ClueType.DESTINATION, 
                "/image/GreeceImages/Suspects-Hera.jpg");
        logic = new PrivateTipCardLogic(tip, p, p);
        isConsole = true;
        ctrl = new PrivateTipResponseController();
        view = new PrivateTipResponseConsole(ctrl, list, logic);
        ctrl.setUp(view, isConsole);
    }
    
    public void testKeys()
    {
        JButton btn = new JButton("");
        final KeyEvent ok = new KeyEvent(btn,0,0,KeyEvent.VK_O,
                KeyEvent.VK_O,'s');
        final KeyEvent one = new KeyEvent(btn,0,0,KeyEvent.VK_1,
                KeyEvent.VK_1,'1');
        
        ctrl.keyReleased(one);
        ctrl.keyTyped(one);
        
        ctrl.keyPressed(ok);
        
        //PrivateTipResponseConsole console = 
          //      new PrivateTipResponseConsole(ctrl, list, logic);
        assertEquals(view.getClass(), PrivateTipResponseConsole.class);
    }
}
