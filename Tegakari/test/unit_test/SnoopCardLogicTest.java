
package unit_test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import tegakari.*;

/**
 * SnoopCardLogic Unit test
 * @author ericroh
 */
public class SnoopCardLogicTest extends TestCase 
{
    private SnoopCardLogic logic;
    private SnoopCard card;
    private Player player;
    private Table table;
    private Theme theme;
    
    public SnoopCardLogicTest(String testName) 
    {
        super(testName); 
        theme = new Theme();
        table = new Table(theme);
        card = table.getTableDecks().makeSnoop();
        player = new HumanPlayer("self");
        logic = new SnoopCardLogic(card, player);   
    }

    /**
     * Test of playSnoop method, of class SnoopCardLogic.
     */
    public void testPlaySnoop() 
    {
        System.out.println("playSnoop");
        List<ClueCard> hand = new ArrayList<ClueCard>();
        hand.add(new DestinationCard(theme.getDestinations().get(0)));
        hand.add(new SuspectCard(theme.getSuspects().get(0)));
        hand.add(new SuspectCard(theme.getSuspects().get(2)));
        hand.add(new VehicleCard((theme.getVehicles().get(1))));
        
        Player received = mock(Player.class);
        when(received.getClueCards()).thenReturn(hand);
        List expResult = hand;
        List result = logic.playSnoop(received);
        assertEquals(expResult, result);
    }
}
