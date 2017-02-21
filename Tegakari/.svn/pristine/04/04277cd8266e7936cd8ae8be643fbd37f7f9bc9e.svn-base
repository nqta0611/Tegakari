package unit_test;

import junit.framework.*;
import tegakari.*;

/**
 * Testing the <code>Table</code> class in the tegakari package.
 * 
 * @author Jonathan Molina
 */
public class TableTest extends TestCase
{
    /**
     * Test the buildOrderedActionDeck() method in <code>Table</code>.
     */
    public void testBuildOrderedActionDeck()
    {
        Table table = new Table(new Theme());

        table.buildOrderedActionDeck("test/testsetup/t9action");
        
        Deck<ActionCard> actionDeck = table.getActionDeck();
        
        PrivateTipCard t1 = 
                new PrivateTipCard(ClueType.VEHICLE, Attribute.RED, 
                "/image/Action-PrivateTipRed.jpg");
        PrivateTipCard t2 = 
                new PrivateTipCard(ClueType.DESTINATION, Attribute.NORTHERN, 
                "/image/Action-PrivateTipNorthern.jpg");    
        PrivateTipCard t3 = 
                new PrivateTipCard(ClueType.SUSPECT, Attribute.FEMALE, 
                "/image/Action-PrivateTipFemale.jpg");
        PrivateTipCard t4 = 
                new PrivateTipCard(ClueType.VEHICLE, 
                "/image/Action-PrivateTipAllVehicle.jpg");
        PrivateTipCard t5 = 
                new PrivateTipCard(ClueType.DESTINATION, 
                "/image/Action-PrivateTipAllDestination.jpg");
        PrivateTipCard t6 = 
                new PrivateTipCard(ClueType.SUSPECT, 
                "/image/Action-PrivateTipAllSuspect.jpg");

        assertEquals(t1, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t1, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t4, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t4, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t1, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t1, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t4, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t4, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t2, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t2, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t5, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t5, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t3, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t3, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t6, (PrivateTipCard) actionDeck.dealCard());
        assertEquals(t6, (PrivateTipCard) actionDeck.dealCard());
        assertNull(actionDeck.dealCard()); // No cards left in the deck
    }
    
    /**
     * Test the buildOrderedClueDeck() method in <code>Table</code>.
     */
    public void testBuildOrderedClueDeck()
    {
        Theme theme = new Theme();
        Table table = new Table(theme);

        table.buildOrderedClueDeck("test/testsetup/t9clue");
        
        Deck<ClueCard> clueDeck = table.getClueDeck();
        
        Suspect s1 = theme.getSuspects().get(0);
        Suspect s2 = theme.getSuspects().get(1);
        Suspect s3 = theme.getSuspects().get(2);
        Suspect s4 = theme.getSuspects().get(3);
        Suspect s5 = theme.getSuspects().get(4);
        Suspect s6 = theme.getSuspects().get(5);
        
        Vehicle v1 = theme.getVehicles().get(0);
        Vehicle v2 = theme.getVehicles().get(1);
        Vehicle v3 = theme.getVehicles().get(2);
        Vehicle v4 = theme.getVehicles().get(3);
        Vehicle v5 = theme.getVehicles().get(4);
        Vehicle v6 = theme.getVehicles().get(5);
        
        Destination d1 = theme.getDestinations().get(0);
        Destination d2 = theme.getDestinations().get(1);
        Destination d3 = theme.getDestinations().get(2);
        Destination d4 = theme.getDestinations().get(3);
        Destination d5 = theme.getDestinations().get(4);
        Destination d6 = theme.getDestinations().get(5);
        Destination d7 = theme.getDestinations().get(6);
        Destination d8 = theme.getDestinations().get(7);
        Destination d9 = theme.getDestinations().get(8);

        assertEquals(d9, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(v6, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(s6, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(s1, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(v1, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(d2, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(s5, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(s2, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(v2, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(d3, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(v3, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(s3, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(v4, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(d5, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(d1, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(s4, ((SuspectCard) clueDeck.dealCard()).getSuspect());
        assertEquals(v5, ((VehicleCard) clueDeck.dealCard()).getVehicle());
        assertEquals(d7, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(d4, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(d6, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertEquals(d8, ((DestinationCard) clueDeck.dealCard()).getDestination());
        assertNull(clueDeck.dealCard()); // No cards left in the deck
    }
    
    /**
     * Test the makeSolution() method in <code>Table</code>.
     */
    public void testMakeSolution()
    {
        Theme theme = new Theme();
        Table table = new Table(theme);

        table.buildOrderedClueDeck("test/testsetup/t1clue");
        
        Deck<ClueCard> clueDeck = table.getClueDeck();
        int originalSize = clueDeck.getCardCount();
        
        Solution solution = table.makeSolution();
        
        assertEquals(solution.getSuspect(), theme.getSuspects().get(0));
        assertEquals(solution.getVehicle(), theme.getVehicles().get(0));
        assertEquals(solution.getDestination(), theme.getDestinations().get(0));
        assertEquals(originalSize - 3, table.getClueDeck().getCardCount());
        
        
    }
}
