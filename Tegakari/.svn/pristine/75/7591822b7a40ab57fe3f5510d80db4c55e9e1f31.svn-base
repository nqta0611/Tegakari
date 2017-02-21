/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;
import java.util.ArrayList;
import tegakari.*;
import java.util.List;
import junit.framework.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author anhnguyen
 */
public class CardMessageTest extends TestCase{
    
    public CardMessageTest() {
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    
    public void testConstructor1() {
        List<Card> cards = new ArrayList<Card>();
        Player from = mock(Player.class);
        Player to = mock(Player.class);
        Card card = mock(Card.class);
        cards.add(card);
        cards.add(card);
        
        
        CardMessage mess = new CardMessage(to, from, cards);
        assertEquals(from, mess.getFromPlayer());
        assertEquals(to, mess.getToPlayer());
        assertEquals(card, mess.getCards().get(0));
        assertEquals(card, mess.getCards().get(1));
        assertEquals(2, mess.getCards().size());
    }
    
    public void testConstructor2() {
        Player from = mock(Player.class);
        Player to = mock(Player.class);
        Card card = mock(Card.class);
        
        CardMessage mess = new CardMessage(to, from, card);
        assertEquals(from, mess.getFromPlayer());
        assertEquals(to, mess.getToPlayer());
        assertEquals(card, mess.getCards().get(0));
        assertEquals(1, mess.getCards().size());
    
    }
}