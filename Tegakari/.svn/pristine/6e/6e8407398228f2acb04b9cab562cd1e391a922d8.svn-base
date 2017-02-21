package integration_test;

import java.util.List;
import junit.framework.TestCase;
import tegakari.*;

/**
 * Test for Table.
 * @author roh
 */
public class TableTest extends TestCase 
{
    private Table table;
    private Theme theme;
    
    public TableTest(String testName) 
    {
        super(testName);
        
        theme = new Theme();
        table = new Table(theme);
    }

    /**
     * Test of getTheme method, of class Table.
     */
    public void testGetTheme() 
    {
        System.out.println("getTheme");
        
        assertEquals(theme, table.getTheme());
    }

    /**
     * Test of buildActionDeck method, of class Table.
     */
    public void testBuildActionDeck() 
    {
        System.out.println("buildActionDeck");
        
        Deck<ActionCard> actionDeck;
        
        
    }

    /**
     * Test of buildOrderedActionDeck method, of class Table.
     */
    public void testBuildOrderedActionDeck() 
    {
        System.out.println("buildOrderedActionDeck");
        
        Deck<ActionCard> actionDeck = new Deck<ActionCard>();
        
        actionDeck.addCardToDeck(new SuggestionCard(true,
                    "/image/Action-SuggestionCurrent.jpg"));
        actionDeck.addCardToDeck(new SuggestionCard(false, 
                    "/image/Action-SuggestionAny.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.VEHICLE, 
                    Attribute.RED, "/image/Action-PrivateTipRed.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.DESTINATION, 
                    Attribute.NORTHERN, "/image/Action-PrivateTipNorthern.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.SUSPECT, 
                    Attribute.FEMALE, "/image/Action-PrivateTipFemale.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.VEHICLE, 
                    "/image/Action-PrivateTipAllVehicle.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.DESTINATION, 
                    "/image/Action-PrivateTipAllDestination.jpg"));
        actionDeck.addCardToDeck(new PrivateTipCard(ClueType.SUSPECT, 
                    "/image/Action-PrivateTipAllSuspect.jpg"));
        actionDeck.addCardToDeck(new SnoopCard("/image/Action-Snoop.jpg"));
        actionDeck.addCardToDeck(new SnoopCard(Direction.RIGHT, 
                    "/image/Action-AllSnoopRight.jpg"));
        actionDeck.addCardToDeck(new SnoopCard(Direction.LEFT, 
                    "/image/Action-AllSnoopLeft.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(
                    ClueType.SUSPECT, Attribute.MALE, 
                    "/image/Action-SuperSleuthMale.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(
                    ClueType.SUSPECT, Attribute.FEMALE, 
                    "/image/Action-SuperSleuthFemale.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(
                    ClueType.DESTINATION, Attribute.WESTERN, 
                    "/image/Action-SuperSleuthWest.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(
                    ClueType.DESTINATION, Attribute.SOUTHERN, 
                    "/image/Action-SuperSleuthSouth.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(ClueType.VEHICLE, 
                    Attribute.BLUE, "/image/Action-SuperSleuthBlue.jpg"));
        actionDeck.addCardToDeck(new SuperSleuthCard(ClueType.VEHICLE, 
                 Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg"));
        
        table.buildOrderedActionDeck("./test/testsetup/t0action");

        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        assertEquals(actionDeck.dealCard().getActionText(), 
                table.dealActionCard().getActionText());
        
    }

    /**
     * Test of buildClueDeck method, of class Table.
     */
    public void testBuildClueDeck() 
    {
        System.out.println("buildClueDeck");
        
    }

    /**
     * Test of buildOrderedClueDeck method, of class Table.
     */
    public void testBuildOrderedClueDeck() 
    {
        System.out.println("buildOrderedClueDeck");
    }

    /**
     * Test of dealClueCard method, of class Table.
     */
    public void testDealClueCard() 
    {
        System.out.println("dealClueCard");

    }

    /**
     * Test of dealActionCard method, of class Table.
     */
    public void testDealActionCard() 
    {
        System.out.println("dealActionCard");
        
    }

    /**
     * Test of dealDM method, of class Table.
     */
    public void testDealDM() 
    {
        System.out.println("dealDM");
        
        
    }

    /**
     * Test of exchangeDM method, of class Table.
     */
    public void testExchangeDM() 
    {
        System.out.println("exchangeDM");
        
    }

    /**
     * Test of addtoDiscardPile method, of class Table.
     */
    public void testAddtoDiscardPile() 
    {
        System.out.println("addtoDiscardPile");
        
    }

    /**
     * Test of rebuildActionDeckFromDiscardPile method, of class Table.
     */
    public void testRebuildActionDeckFromDiscardPile() 
    {
        System.out.println("rebuildActionDeckFromDiscardPile");
        
    }

    /**
     * Test of getPile method, of class Table.
     */
    public void testGetPile() 
    {
        System.out.println("getPile");
        
    }

    /**
     * Test of getActionDeck method, of class Table.
     */
    public void testGetActionDeck() 
    {
        System.out.println("getActionDeck");
        
    }

    /**
     * Test of getClueDeck method, of class Table.
     */
    public void testGetClueDeck() 
    {
        System.out.println("getClueDeck");
        
    }

    /**
     * Test of getDiscardPile method, of class Table.
     */
    public void testGetDiscardPile() 
    {
        System.out.println("getDiscardPile");
        
        assertTrue(table.getDiscardPile().isEmpty());
        table.buildOrderedActionDeck("./test/testsetup/t0action");
        ActionCard removed = table.dealActionCard();
        table.addtoDiscardPile(removed);
        
        assertFalse(table.getDiscardPile().isEmpty());
        assertEquals(removed, table.getDiscardPile().dealCard());
    }

    /**
     * Test of makeSolution method, of class Table.
     */
    public void testMakeSolution() 
    {
        System.out.println("makeSolution");
        
        table.buildOrderedClueDeck("./test/testsetup/t0clue");
        
        table.makeSolution();
        
        assertEquals(new SuspectCard(theme.getSuspects().get(1)), 
                table.getClueDeck().dealCard());
        assertEquals(new SuspectCard(theme.getSuspects().get(2)), 
                table.getClueDeck().dealCard());
        assertEquals(new VehicleCard(theme.getVehicles().get(1)), 
                table.getClueDeck().dealCard());
        assertEquals(new VehicleCard(theme.getVehicles().get(2)), 
                table.getClueDeck().dealCard());
        assertEquals(new DestinationCard(theme.getDestinations().get(1)), 
                table.getClueDeck().dealCard());
    }

    /**
     * Test of getTableDecks method, of class Table.
     */
    public void testGetTableDecks() {
        System.out.println("getTableDecks");
        
    }

    /**
     * Test of equals method, of class Table.
     */
    public void testEquals() {
        System.out.println("equals");
        
        Theme diffTheme = new Theme();
        diffTheme.changeThemeType(ThemeType.PIRATE);
        
        Table diff1 = new Table(theme);
        Table diff2 = new Table(diffTheme);
        Table diff3 = new Table(theme);

        diff1.dealDM();
        diff2.dealActionCard();
        
        table.buildActionDeck();
        table.buildClueDeck();
        
        assertFalse(table.equals(null));
        assertFalse(table.equals(this));
        assertFalse(table.equals(diff1));
        assertFalse(table.equals(diff2));
        assertFalse(table.equals(diff3));
        assertTrue(table.equals(table));
    }
}
