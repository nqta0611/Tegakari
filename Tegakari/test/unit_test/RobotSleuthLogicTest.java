/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.*;
import static org.mockito.Mockito.*;
import tegakari.*;

/**
 *
 * @author roh
 */
public class RobotSleuthLogicTest extends TestCase
{
    private RobotSleuthLogic logic;
    private SuperSleuthCard sleuthCard;
    private Notepad notepad;
    private HumanPlayer humanPlayer;
    private Robot robotPlayer;
    private Hand hand;
    private String[] playerNames = {"P1", "P2", "P3", "P4"};
    private List<Player> players;
    private List<Suspect> suspects;
    private List<Vehicle> vehicles;
    private List<Destination> destinations;
    private Map<String, ClueCard> cards;
    
    public RobotSleuthLogicTest() {
    }
    
   /**
     * The method called before every test method.
     * 
     * @throws Exception 
     */
    @Override
    protected void setUp() throws Exception
    {
        sleuthCard = mock(SuperSleuthCard.class);
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
            when(player.getName()).thenReturn(name);
        }
        mockCategories();
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
            when(artemis.getName()).thenReturn("Artemis");
            when(artemis.getAttributes()).thenReturn(attributes);
            Suspect hera = mock(Suspect.class);
            when(hera.getName()).thenReturn("Hera");
            when(hera.getAttributes()).thenReturn(attributes);

            attributes = new ArrayList<Attribute>();
            attributes.add(Attribute.MALE);
            Suspect ares = mock(Suspect.class);
            when(ares.getName()).thenReturn("Ares");
            when(ares.getAttributes()).thenReturn(attributes);
            Suspect dionysus = mock(Suspect.class);
            when(dionysus.getName()).thenReturn("Dionysus");
            when(dionysus.getAttributes()).thenReturn(attributes);
            Suspect hermes = mock(Suspect.class);
            when(hermes.getName()).thenReturn("Hermes");
            when(hermes.getAttributes()).thenReturn(attributes);

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
     * Test of responseToActionRequest method, of class RobotSleuthLogic.
     */
    public void testResponseToActionRequest() {
        System.out.println("responseToActionRequest");
        Player self = mock(Robot.class);
        Player turn = players.get(0);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        // Set up target player's hand
        List<ClueCard> handCards = new ArrayList<ClueCard>();
        handCards.add(suspectList.get(0));
        handCards.add(suspectList.get(4));
        handCards.add(suspectList.get(5));
        handCards.add(destinationList.get(2));
        handCards.add(vehicleList.get(0));
        
        when(hand.getClueCards()).thenReturn(handCards);
        when(self.getHand()).thenReturn(hand);
        
        for (ClueCard c : handCards)
        {
            if (c.equals(handCards.get(1)))
                when(notepad.getEntry(c, turn)).thenReturn(NoteEntry.SHOWN);
            else
                when(notepad.getEntry(c, turn)).thenReturn(NoteEntry.BLANK);
        }
        
        List<ClueCard> expected = new ArrayList<ClueCard>();
        List<ClueCard> results = new ArrayList<ClueCard>();
        expected.add(handCards.get(1));
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        results = logic.responseToActionRequest(sleuthCard, notepad, turn, self, AILevel.SMART);
        assertEquals(expected, results);
    }

    /**
     * Test of benefitFromAction method, of class RobotSleuthLogic.
     */
    public void testBenefitFromActionSuspects() {
        System.out.println("testBenefitFromActionSuspects");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        when(sleuthCard.getClueType()).thenReturn(ClueType.SUSPECT);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getSuspects()).thenReturn(suspectList);
        
        for (Player p : players)
        {
            for (ClueCard c : suspectList)
                if (!p.equals(self))
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                else
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(5, results);
    }
    
    public void testBenefitFromActionDesinations() {
        System.out.println("testBenefitFromActionDesinations");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.NORTHERN);
        when(sleuthCard.getClueType()).thenReturn(ClueType.DESTINATION);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getDestinations()).thenReturn(destinationList);
        
        for (Player p : players)
        {
            for (ClueCard c : destinationList)
                if (!p.equals(self))
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                else
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(5, results);
    }
    
    public void testBenefitFromActionVehicles() {
        System.out.println("testBenefitFromActionVehicles");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.FLYING);
        when(sleuthCard.getClueType()).thenReturn(ClueType.VEHICLE);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getVehicles()).thenReturn(vehicleList);
        
        for (Player p : players)
        {
            for (ClueCard c : vehicleList)
                if (!p.equals(self))
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                else
                    when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(5, results);
    }

    public void testBenefitFromActionSuspects4() {
        System.out.println("testBenefitFromActionSuspects4");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        when(sleuthCard.getClueType()).thenReturn(ClueType.SUSPECT);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getSuspects()).thenReturn(suspectList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : suspectList)
                for (Attribute at : c.getAttribute())
                    if (at.equals(Attribute.MALE) && !p.equals(self) && i++ % 3 != 0)
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                    else
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(4, results);
    }
    
    public void testBenefitFromActionSuspects3() {
        System.out.println("testBenefitFromActionSuspects3");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        when(sleuthCard.getClueType()).thenReturn(ClueType.SUSPECT);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getSuspects()).thenReturn(suspectList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : suspectList)
                for (Attribute at : c.getAttribute())
                    if (at.equals(Attribute.MALE) && !p.equals(self) && i++ % 2 != 0)
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                    else
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(3, results);
    }
    
    public void testBenefitFromActionDesinations3() {
        System.out.println("testBenefitFromActionDesinations3");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.NORTHERN);
        when(sleuthCard.getClueType()).thenReturn(ClueType.DESTINATION);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getDestinations()).thenReturn(destinationList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : destinationList)
                for (Attribute at : c.getAttribute())
                    if (at.equals(Attribute.NORTHERN) && !p.equals(self) && i++ % 2 != 0)
                    {
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                        break;
                    }
                    else
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(3, results);
    }
    
    public void testBenefitFromActionVehicles3() {
        System.out.println("testBenefitFromActionVehicles3");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.FLYING);
        when(sleuthCard.getClueType()).thenReturn(ClueType.VEHICLE);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getVehicles()).thenReturn(vehicleList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : vehicleList)
                for (Attribute at : c.getAttribute())
                    if (at.equals(Attribute.FLYING) && !p.equals(self) && i++ % 2 != 0)
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                    else
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(3, results);
    }
    
    public void testBenefitFromActionSuspects2() {
        System.out.println("testBenefitFromActionSuspects2");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        when(sleuthCard.getClueType()).thenReturn(ClueType.SUSPECT);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getSuspects()).thenReturn(suspectList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : suspectList)
                for (Attribute at : c.getAttribute())
                    if (at.equals(Attribute.MALE) && !p.equals(self) && i++ % 3 == 0)
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.BLANK);
                    else
                        when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(2, results);
    }
    
    public void testBenefitFromActionSuspects1() {
        System.out.println("testBenefitFromActionSuspects1");
        Player self = mock(Robot.class);
        players.add(self);
        when(sleuthCard.getAttribute()).thenReturn(Attribute.MALE);
        when(sleuthCard.getClueType()).thenReturn(ClueType.SUSPECT);
        List<SuspectCard> suspectList = convertSuspectsToCards(suspects);
        List<DestinationCard> destinationList = convertDestinationsToCards(destinations);
        List<VehicleCard> vehicleList = convertVehiclesToCards(vehicles);
        
        when(notepad.getSuspects()).thenReturn(suspectList);
        int i = 0;
        
        for (Player p : players)
        {
            for (ClueCard c : suspectList)
                when(notepad.getEntry(c, p)).thenReturn(NoteEntry.HASNOT);
                    
        }
        
        logic = new RobotSleuthLogic(AILevel.SMART, players);
        int results = logic.benefitFromAction(notepad, sleuthCard);
        assertEquals(1, results);
    }
    
    /**
     * Test of playSleuth method, of class RobotSleuthLogic.
     */
    public void testPlaySleuth() {
        System.out.println("playSleuth");
        Player self = mock(Robot.class);
        players.add(self);
        when(self.getName()).thenReturn("self");
        logic = new RobotSleuthLogic(AILevel.SMART, players);

        List expResult = new ArrayList<CardMessage>();
        for (Player p : players)
        {
            if (!p.equals(self))
            {
                when(p.equalsName(self)).thenReturn(false);
                expResult.add(new CardMessage(p, self, sleuthCard));
            }
            else
                when(p.equalsName(self)).thenReturn(true);
        }
        List result = logic.playSleuth(self, sleuthCard);
        
        assertEquals(expResult.size(), result.size());
    }
}