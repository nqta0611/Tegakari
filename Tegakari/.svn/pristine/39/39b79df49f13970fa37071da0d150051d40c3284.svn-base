package unit_test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.*;
import static org.mockito.Mockito.*;
import tegakari.*;

/**
 * Unit test class for RobotSnoopLogic in the tegakari package.
 * @author Jonathan Molina
 */
public class RobotSnoopLogicTest extends TestCase
{
    private RobotSnoopLogic logic;
    private SnoopCard snoopCard;
    private Notepad notepad;
    private HumanPlayer humanPlayer;
    private Robot robotPlayer;
    private Hand hand;
    private String[] playerNames = {"Lucas", "Ness", "Mario", "Luigi"};
    private List<Player> players;
    private String targetPlayerName = "Ness";
    private String robotName = "Computer";
    private List<Suspect> suspects;
    private List<Vehicle> vehicles;
    private List<Destination> destinations;
    private Map<String, ClueCard> cards;
    
    /**
     * The method called before every test method.
     * 
     * @throws Exception 
     */
    @Override
    protected void setUp() throws Exception
    {
        logic = new RobotSnoopLogic();
        snoopCard = mock(SnoopCard.class);
        notepad = mock(Notepad.class);
        humanPlayer = mock(HumanPlayer.class);
        robotPlayer = mock(Robot.class);
        hand = mock(Hand.class);
        cards = new HashMap<String, ClueCard>();
        robotPlayer = mock(Robot.class);
        players = new ArrayList<Player>();
        for (String name : playerNames)
        {
            HumanPlayer player = mock(HumanPlayer.class);
            players.add(player);
        }
    }
    
    private void mockCategories()
    {
        if (suspects == null || vehicles == null || destinations == null)
        {
            List<Attribute> attributes = new ArrayList<Attribute>();
            // Adding to suspects list
            attributes.add(Attribute.FEMALE);

            Suspect aphrodite = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Aphrodite");
            when(aphrodite.getAttributes()).thenReturn(attributes);
            Suspect artemis = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Artemis");
            when(aphrodite.getAttributes()).thenReturn(attributes);
            Suspect hera = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Hera");
            when(aphrodite.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.MALE);
            Suspect ares = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Ares");
            when(aphrodite.getAttributes()).thenReturn(attributes);
            Suspect dionysus = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Dionysus");
            when(aphrodite.getAttributes()).thenReturn(attributes);
            Suspect hermes = mock(Suspect.class);
            when(aphrodite.getName()).thenReturn("Hermes");
            when(aphrodite.getAttributes()).thenReturn(attributes);

            suspects = new ArrayList<Suspect>();
            suspects.add(aphrodite);
            suspects.add(artemis);
            suspects.add(hera);
            suspects.add(ares);
            suspects.add(dionysus);
            suspects.add(hermes);
            
            SuspectCard aphoroditeCard = mock(SuspectCard.class);
            when(aphoroditeCard.getSuspect()).thenReturn(aphrodite);
            SuspectCard artemisCard = mock(SuspectCard.class);
            when(artemisCard.getSuspect()).thenReturn(artemis);
            SuspectCard heraCard = mock(SuspectCard.class);
            when(heraCard.getSuspect()).thenReturn(hera);
            SuspectCard aresCard = mock(SuspectCard.class);
            when(aresCard.getSuspect()).thenReturn(ares);
            SuspectCard dionysusCard = mock(SuspectCard.class);
            when(dionysusCard.getSuspect()).thenReturn(dionysus);
            SuspectCard hermesCard = mock(SuspectCard.class);
            when(hermesCard.getSuspect()).thenReturn(hermes);

            cards.put("Aphrodite", aphoroditeCard);
            cards.put("Artemis", artemisCard);
            cards.put("Hera", heraCard);
            cards.put("Ares", aresCard);
            cards.put("Dionysus", dionysusCard);
            cards.put("Hermes", hermesCard);
            
            // Adding to vehicles list
            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.BLUE);
            attributes.add(Attribute.GROUND);        
            Vehicle chariot = mock(Vehicle.class);
            when(chariot.getName()).thenReturn("Apollo's Chariot");
            when(chariot.getAttributes()).thenReturn(attributes);
            Vehicle horse = mock(Vehicle.class);
            when(horse.getName()).thenReturn("Athena's Horse");
            when(horse.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.BLUE);
            attributes.add(Attribute.FLYING);
            Vehicle wings = mock(Vehicle.class);
            when(wings.getName()).thenReturn("Eros' Wings");
            when(wings.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.RED);
            attributes.add(Attribute.GROUND);
            Vehicle dogs = mock(Vehicle.class);
            when(dogs.getName()).thenReturn("Hades' Dogs");
            when(dogs.getAttributes()).thenReturn(attributes);
            Vehicle ship = mock(Vehicle.class);
            when(ship.getName()).thenReturn("Poseidon's Ship");
            when(ship.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.RED);
            attributes.add(Attribute.FLYING);
            Vehicle sandals = mock(Vehicle.class);
            when(sandals.getName()).thenReturn("Hermes Sandals");

            vehicles = new ArrayList<Vehicle>();
            vehicles.add(chariot);
            vehicles.add(horse);
            vehicles.add(wings);
            vehicles.add(dogs);
            vehicles.add(ship);
            vehicles.add(sandals);

            VehicleCard chariotCard = mock(VehicleCard.class);
            when(chariotCard.getVehicle()).thenReturn(chariot);
            VehicleCard horseCard = mock(VehicleCard.class);
            when(horseCard.getVehicle()).thenReturn(horse);
            VehicleCard wingsCard = mock(VehicleCard.class);
            when(wingsCard.getVehicle()).thenReturn(wings);
            VehicleCard dogsCard = mock(VehicleCard.class);
            when(dogsCard.getVehicle()).thenReturn(dogs);
            VehicleCard shipCard = mock(VehicleCard.class);
            when(shipCard.getVehicle()).thenReturn(ship);
            VehicleCard sandalsCard = mock(VehicleCard.class);
            when(sandalsCard.getVehicle()).thenReturn(sandals);

            cards.put("Chariot", chariotCard);
            cards.put("Horse", horseCard);
            cards.put("Wings", wingsCard);
            cards.put("Dogs", dogsCard);
            cards.put("Ship", shipCard);
            cards.put("Sandals", sandalsCard);
            
            // Adding to destinations list
            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.NORTHERN);
            attributes.add(Attribute.EASTERN);
            Destination forest = mock(Destination.class);
            when(forest.getName()).thenReturn("Athena's Forest");
            when(forest.getAttributes()).thenReturn(attributes);
            Destination athens = mock(Destination.class);
            when(athens.getName()).thenReturn("Athens");
            when(athens.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.NORTHERN);
            attributes.add(Attribute.WESTERN);
            Destination sky = mock(Destination.class);
            when(sky.getName()).thenReturn("Atlas' Sky");
            when(sky.getAttributes()).thenReturn(attributes);
            Destination vineyard = mock(Destination.class);
            when(vineyard.getName()).thenReturn("Dionysus' Vineyard");
            when(vineyard.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.SOUTHERN);
            attributes.add(Attribute.WESTERN);
            Destination underworld = mock(Destination.class);
            when(underworld.getName()).thenReturn("Hades' Underworld");
            when(underworld.getAttributes()).thenReturn(attributes);
            Destination volcano = mock(Destination.class);
            when(volcano.getName()).thenReturn("Hephaestus' Volcano");
            when(volcano.getAttributes()).thenReturn(attributes);
            Destination olympus = mock(Destination.class);
            when(olympus.getName()).thenReturn("Mount Olympus");
            when(olympus.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.SOUTHERN);
            attributes.add(Attribute.EASTERN);
            Destination moon = mock(Destination.class);
            when(moon.getName()).thenReturn("Phoebe's Moon");
            when(moon.getAttributes()).thenReturn(attributes);
            Destination ocean = mock(Destination.class);
            when(ocean.getName()).thenReturn("Poseidon's Ocean");
            when(ocean.getAttributes()).thenReturn(attributes);

            destinations = new ArrayList<Destination>();
            destinations.add(forest);
            destinations.add(athens);
            destinations.add(sky);
            destinations.add(vineyard);
            destinations.add(underworld);
            destinations.add(volcano);
            destinations.add(olympus);
            destinations.add(moon);
            destinations.add(ocean);
            
            DestinationCard forestCard = mock(DestinationCard.class);
            when(forestCard.getDestination()).thenReturn(forest);
            DestinationCard athensCard = mock(DestinationCard.class);
            when(athensCard.getDestination()).thenReturn(athens);
            DestinationCard skyCard = mock(DestinationCard.class);
            when(skyCard.getDestination()).thenReturn(sky);
            DestinationCard vineyardCard = mock(DestinationCard.class);
            when(vineyardCard.getDestination()).thenReturn(vineyard);
            DestinationCard underworldCard = mock(DestinationCard.class);
            when(underworldCard.getDestination()).thenReturn(underworld);
            DestinationCard volcanoCard = mock(DestinationCard.class);
            when(volcanoCard.getDestination()).thenReturn(volcano);
            DestinationCard olympusCard = mock(DestinationCard.class);
            when(olympusCard.getDestination()).thenReturn(olympus);
            DestinationCard moonCard = mock(DestinationCard.class);
            when(moonCard.getDestination()).thenReturn(moon);
            DestinationCard oceanCard = mock(DestinationCard.class);
            when(oceanCard.getDestination()).thenReturn(ocean);

            cards.put("Forest", forestCard);
            cards.put("Athens", athensCard);
            cards.put("Sky", skyCard);
            cards.put("Vineyard", vineyardCard);
            cards.put("Underworld", underworldCard);
            cards.put("Volcano", volcanoCard);
            cards.put("Olympus", olympusCard);
            cards.put("Moon", moonCard);
            cards.put("Ocean", oceanCard);
        }
    }
    
    private List<SuspectCard> convertSuspectsToCards(List<Suspect> types)
    {
        List<SuspectCard> cards = new ArrayList<SuspectCard>();
        
        for (Suspect suspect : types)
        {
            cards.add(new SuspectCard(suspect));
        }
        
        return cards;
    }
    
    private List<VehicleCard> convertVehiclesToCards(List<Vehicle> types)
    {
        List<VehicleCard> cards = new ArrayList<VehicleCard>();
        
        for (Vehicle vehicle : types)
        {
            cards.add(new VehicleCard(vehicle));
        }
        
        return cards;
    }
    
    private List<DestinationCard> convertDestinationsToCards(List<Destination> types)
    {
        List<DestinationCard> cards = new ArrayList<DestinationCard>();
        
        for (Destination destination : types)
        {
            cards.add(new DestinationCard(destination));
        }
        
        return cards;
    }
    
    /**
     * Testing responseToActionRequest method.
     */
    public void testResponseToActionRequest()
    {        
        // Set up the snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // Set up target player's hand
        SuspectCard aresCard = mock(SuspectCard.class);
        when(aresCard.getName()).thenReturn("Ares");
        SuspectCard heraCard = mock(SuspectCard.class);
        when(heraCard.getName()).thenReturn("Hera");
        SuspectCard artemisCard = mock(SuspectCard.class);
        when(artemisCard.getName()).thenReturn("Artemis");
        SuspectCard hermesCard = mock(SuspectCard.class);
        when(hermesCard.getName()).thenReturn("Hermes");
        
        List<ClueCard> handCards = new ArrayList<ClueCard>();
        handCards.add(aresCard);
        handCards.add(heraCard);
        handCards.add(artemisCard);
        handCards.add(hermesCard);

        // Set up target player
        when(hand.getClueCards()).thenReturn(handCards);
        when(humanPlayer.getClueCards()).thenReturn(handCards);
   
        // Set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        when(notepad.getPlayers()).thenReturn(players);

        // CALL method
        List<ClueCard> result = logic.responseToActionRequest(
                snoopCard, notepad, humanPlayer, humanPlayer, AILevel.BASIC);
        // size of returned list should be 1
        assertEquals(1, result.size());
        // the item in the list should also be in the created list
        assertTrue(handCards.contains(result.get(0)));
    }
    
    /**
     * Testing benefitFromAction method with an incorrect card.
     */
    public void testBenefitFromActionWrongCard()
    {
        PrivateTipCard card = mock(PrivateTipCard.class);
        
        int benefit = logic.benefitFromAction(notepad, card);
        assertEquals("action is not a snoop card", -1, benefit);
    }
    
    /**
     * Testing benefitFromAction method for benefit = 5 (0/5 known cards).
     */
    public void testBenefitFromActionSnoop5()
    {
        // set up snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(false);
        
        // set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        
        // add a getEntries(Player, NotepadEnum)?
        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(5, benefit); // should be the best since no known cards
    }
    
    /**
     * Testing benefitFromAction method for benefit = 4 (2/5 known cards).
     */
    public void testBenefitFromActionSnoop4()
    {
        // set up snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(false);
        
        // set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        List<VehicleCard> vehicleCards = convertVehiclesToCards(vehicles);
        when(notepad.getVehicles()).thenReturn(vehicleCards);
        when(notepad.getEntry(vehicleCards.get(0), players.get(2))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(vehicleCards.get(1), players.get(2))).thenReturn(NoteEntry.HAS);
        List<DestinationCard> destinationCards = convertDestinationsToCards(destinations);
        when(notepad.getDestinations()).thenReturn(destinationCards);
        when(notepad.getEntry(destinationCards.get(0), players.get(1))).thenReturn(NoteEntry.HAS);
        
        // add a getEntries(Player, NotepadEnum)?
        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(4, benefit); // should be the best since no known cards
    }
    
    /**
     * Testing benefitFromAction method for benefit = 3 (3/5 known cards).
     */
    public void testBenefitFromActionSnoop3()
    {
        // set up snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(false);
        
        // set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        
        // add a getEntries(Player, NotepadEnum)?
        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(3, benefit); // should be the best since no known cards
    }
    
    /**
     * Testing benefitFromAction method for benefit = 2 (4/5 known cards).
     */
    public void testBenefitFromActionSnoop2()
    {
        // set up snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(false);
        
        // set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(3), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        
        // add a getEntries(Player, NotepadEnum)?
        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(2, benefit); // should be the best since no known cards
    }
    
    /**
     * Testing benefitFromAction method for benefit = 1 (5/5 known cards).
     */
    public void testBenefitFromActionSnoop1()
    {
        // set up snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(false);
        
        // set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(3), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(4), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        
        // add a getEntries(Player, NotepadEnum)?
        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(1, benefit); // should be the best since no known cards
    }
    
    /**
     * Testing benefitFromAction method for benefit = 5 (0/5 known cards).
     */
    public void testBenefitFromActionAllSnoop5()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(5, benefit);
    }
    
    /**
     * Testing benefitFromAction method for benefit = 4 (3/5 known cards).
     */
    public void testBenefitFromActionAllSnoop4()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.RIGHT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(3))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(3))).thenReturn(NoteEntry.HAS);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(4, benefit);
    }
    
    /**
     * Testing benefitFromAction method for benefit = 3 (3/5 known cards).
     */
    public void testBenefitFromActionAllSnoop3()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(3, benefit);
    }
    
    /**
     * Testing benefitFromAction method for benefit = 2 (4/5 known cards).
     */
    public void testBenefitFromActionAllSnoop2()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getEntry(suspectCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(suspectCards.get(3), players.get(0))).thenReturn(NoteEntry.HAS);

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(2, benefit);
    }
    
    /**
     * Testing benefitFromAction method for benefit = 1 (5/5 known cards).
     */
    public void testBenefitFromActionAllSnoop1()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);  
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        List<VehicleCard> vehicleCards = convertVehiclesToCards(vehicles);
        when(notepad.getVehicles()).thenReturn(vehicleCards);
        when(notepad.getEntry(vehicleCards.get(0), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(vehicleCards.get(1), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(vehicleCards.get(2), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(vehicleCards.get(3), players.get(0))).thenReturn(NoteEntry.HAS);
        when(notepad.getEntry(vehicleCards.get(4), players.get(0))).thenReturn(NoteEntry.HAS);

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(1, benefit);
    }
    
    /**
     * Testing chooseTargetPlayer method.
     */
    public void testChooseTargetPlayer()
    {
        // set up snoop card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // set up notepad
        // mocking player hand
        when(hand.getClueCardTotal()).thenReturn(5);
        // set player hand return
        int ndx = 0;
        for (Player player : players)
        {
            when(player.getHand()).thenReturn(hand);
            when(player.getName()).thenReturn(playerNames[ndx++]);
        }
        when(notepad.getPlayers()).thenReturn(players);
        mockCategories();
        List<SuspectCard> suspectCards = convertSuspectsToCards(suspects);
        when(notepad.getSuspects()).thenReturn(suspectCards);
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));
        when(notepad.getSuspects()).thenReturn(convertSuspectsToCards(suspects));

        int benefit = logic.benefitFromAction(notepad, snoopCard);
        assertEquals(5, benefit);
        assertEquals("Lucas", logic.chooseTargetPlayer(notepad, snoopCard).getName());
    }
    
    /**
     * Testing playSnoop method.
     */
    public void testPlaySnoop()
    {
        // Set up the snoop action card
        when(snoopCard.isAllSnoop()).thenReturn(true);
        when(snoopCard.getDirection()).thenReturn(Direction.LEFT);
        
        // Set up target player's hand
        SuspectCard aresCard = mock(SuspectCard.class);
        when(aresCard.getName()).thenReturn("Ares");
        SuspectCard heraCard = mock(SuspectCard.class);
        when(heraCard.getName()).thenReturn("Hera");
        SuspectCard artemisCard = mock(SuspectCard.class);
        when(artemisCard.getName()).thenReturn("Artemis");
        SuspectCard hermesCard = mock(SuspectCard.class);
        when(hermesCard.getName()).thenReturn("Hermes");
        
        List<ClueCard> handCards = new ArrayList<ClueCard>();
        handCards.add(aresCard);
        handCards.add(heraCard);
        handCards.add(artemisCard);
        handCards.add(hermesCard);

        // Set up target player
        when(hand.getClueCards()).thenReturn(handCards);
        when(humanPlayer.getClueCards()).thenReturn(handCards);
   
        // Set up notepad
        // assign player names
        for (int ndx = 0; ndx < playerNames.length; ndx++)
        {
            when(players.get(ndx).getName()).thenReturn(playerNames[ndx]);
        }
        when(notepad.getPlayers()).thenReturn(players);
        
        ClueCard card = logic.playSnoop(snoopCard, notepad, humanPlayer, robotPlayer, AILevel.BASIC);

        assertTrue(handCards.contains(card));
    }
}