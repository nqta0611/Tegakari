/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import tegakari.*;

/**
 *
 * @author ericroh
 */
public class PlayerTest extends TestCase 
{
    private Player self;
    private Hand hand;
    private Table table;
    private Theme theme;
    
    public PlayerTest(String testName) 
    {
        super(testName);
        theme = new Theme();
        table = new Table(theme);
        self = new HumanPlayer("self");
        hand = new Hand();
    }

    /**
     * Test of getValidCardsSuggestion method, of class Player.
     */
    public void testGetValidCardsSuggestion() 
    {
        System.out.println("getValidCardsSuggestion");
        Solution condition = new Solution(theme.getSuspects().get(0), 
                theme.getVehicles().get(0), theme.getDestinations().get(0));
        self = new HumanPlayer("self", hand, theme.getDestinations().get(0));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(0)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(0)));
        hand.addToHand(new DestinationCard(theme.getDestinations().get(0)));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(3)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(3)));
        
        
        List expResult = new ArrayList<Card>();
        expResult.add(new SuspectCard(theme.getSuspects().get(0)));
        expResult.add(new VehicleCard(theme.getVehicles().get(0)));
        expResult.add(new DestinationCard(theme.getDestinations().get(0)));
        List result = self.getValidCardsSuggestion(condition);
        assertEquals(expResult, result);
        
        hand = new Hand();
        self = new HumanPlayer("self", hand, theme.getDestinations().get(0));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(1)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(1)));
        hand.addToHand(new DestinationCard(theme.getDestinations().get(1)));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(3)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(3)));
        
        expResult = new ArrayList<Card>();
        result = self.getValidCardsSuggestion(condition);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValidCardsPrivateTip method, of class Player.
     */
    public void testGetValidCardsPrivateTip() 
    {
        System.out.println("getValidCardsPrivateTip");
        PrivateTipCard card = new PrivateTipCard(ClueType.SUSPECT, null);
        self = new HumanPlayer("self", hand, theme.getDestinations().get(0));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(0)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(0)));
        hand.addToHand(new DestinationCard(theme.getDestinations().get(0)));
        hand.addToHand(new SuspectCard(theme.getSuspects().get(3)));
        hand.addToHand(new VehicleCard(theme.getVehicles().get(3)));
        
        List expResult = new ArrayList<Card>();
        expResult.add(new SuspectCard(theme.getSuspects().get(0)));
        expResult.add(new SuspectCard(theme.getSuspects().get(3)));
        List result = self.getValidCardsPrivateTip(card);
        assertEquals(expResult, result);
        
        card = new PrivateTipCard(ClueType.SUSPECT, Attribute.MALE, null);
        expResult = new ArrayList<Card>();
        expResult.add(new SuspectCard(theme.getSuspects().get(3)));
        result = self.getValidCardsPrivateTip(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of getActionCards method, of class Player.
     */
    public void testGetActionCards() 
    {
        System.out.println("getActionCards");
        self = new HumanPlayer("self", hand, theme.getDestinations().get(0));
        hand.addToHand(new SnoopCard(null));
        hand.addToHand(new PrivateTipCard(ClueType.SUSPECT, null));
        List expResult = new ArrayList<ActionCard>();
        expResult.add(new SnoopCard(null));
        expResult.add(new PrivateTipCard(ClueType.SUSPECT, null));
        List result = self.getActionCards();
        assertTrue(self.cardListsEqual(result, result));
    }

}
