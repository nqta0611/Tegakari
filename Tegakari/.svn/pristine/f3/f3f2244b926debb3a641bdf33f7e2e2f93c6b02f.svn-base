package unit_test;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import junit.framework.*;
import tegakari.*;

/**
 * Junit Unit Test Case that tests the <code>Notepad</code> class.  Lowest
 * dependency of v2.0 classes so no mocks are used.
 * 
 * @author Josh Choi - jchoi30
 */
public class NotepadTest extends TestCase {
    
    private Notepad notepad;
    private List<SuspectCard> suspects;
    private List<VehicleCard> vehicles;
    private List<DestinationCard> destinations;
    private SuspectCard s1;
    private SuspectCard s2;
    private SuspectCard s3;
    private SuspectCard s4;
    private SuspectCard s5;
    private SuspectCard s6;
    private VehicleCard v1;
    private VehicleCard v2;
    private VehicleCard v3;
    private VehicleCard v4;
    private VehicleCard v5;
    private VehicleCard v6;
    private DestinationCard d1;
    private DestinationCard d2;
    private DestinationCard d3;
    private DestinationCard d4;
    private DestinationCard d5;
    private DestinationCard d6;
    private DestinationCard d7;
    private DestinationCard d8;
    private DestinationCard d9;
    
    
    
    public NotepadTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception
    {
        this.suspects = new ArrayList<SuspectCard>();
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.FEMALE);
        
        suspects.add(s1 = new SuspectCard(new Suspect("Aphrodite", attributes, 
                "/image/Suspects-Aphrodite.jpg"))); // S1
        suspects.add(s2 = new SuspectCard(new Suspect("Artemis", attributes, 
                "/image/Suspects-Artemis.jpg"))); // S2
        suspects.add(s3 = new SuspectCard(new Suspect("Hera", attributes, 
                "/image/Suspects-Hera.jpg"))); // S3
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.MALE);
        suspects.add(s4 = new SuspectCard(new Suspect("Ares", attributes, 
                "/image/Suspects-Ares.jpg")));  // S4
        suspects.add(s5 = new SuspectCard(new Suspect("Dionysus", attributes, 
                "/image/Suspects-Dionysus.jpg"))); // S5
        suspects.add(s6 = new SuspectCard(new Suspect("Hermes", attributes, 
                "/image/Suspects-Hermes.jpg"))); // S6
        
        this.vehicles = new ArrayList<VehicleCard>();
        attributes = new ArrayList<Attribute>();
        attributes = new ArrayList<Attribute>();

        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.GROUND);        
        vehicles.add(v1 = new VehicleCard(new Vehicle("Apollo's Chariot", attributes, 
                "/image/Transportation-ApollosChariot.jpg"))); // V1
        vehicles.add(v2 = new VehicleCard(new Vehicle("Athena's Horse", attributes, 
                "/image/Transportation-AthenaHorse.jpg"))); // V2
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.FLYING);
        vehicles.add(v3 = new VehicleCard(new Vehicle("Eros' Wings", attributes, 
                "/image/Transportation-ErosWings.jpg"))); // V3
        
        attributes = new ArrayList<Attribute>();

        attributes.add(Attribute.RED);
        attributes.add(Attribute.GROUND);
        vehicles.add(v4 = new VehicleCard(new Vehicle("Hades' Dogs", attributes, 
                "/image/Transportation-HadesDogs.jpg"))); // V4
        vehicles.add(v5 = new VehicleCard(new Vehicle("Poseidon's Ship", attributes, 
                "/image/Transportation-PoseidonShip.jpg"))); // V5
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.RED);
        attributes.add(Attribute.FLYING);
        vehicles.add(v6 = new VehicleCard(new Vehicle("Hermes Sandals", attributes, 
                "/image/Transportation-HermesWingSandals.jpg"))); // V6
        
        this.destinations = new ArrayList<DestinationCard>();
        attributes = new ArrayList<Attribute>();
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.EASTERN);
        destinations.add(d1 = new DestinationCard(new Destination("Athena's Forest", 
                attributes, "/image/Location-Athena-Forest.jpg"))); // L1
        destinations.add(d2 = new DestinationCard(new Destination("Athens", 
                attributes, "/image/Location-Athens.jpg"))); // L2
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.WESTERN);
        destinations.add(d3 = new DestinationCard(new Destination("Atlas' Sky", 
                attributes, "/image/Location-AtlasSky.jpg"))); // L3
        destinations.add(d4 = new DestinationCard(new Destination(
                "Dionysus' Vineyard", attributes, 
                "/image/Location-Dionysus-Vineyard.jpg"))); // L4
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.WESTERN);
        destinations.add(d5 = new DestinationCard(new Destination(
                "Hades' Underworld", attributes, 
                "/image/Location-HadesUnderworld.jpg"))); // L5
        destinations.add(d6 = new DestinationCard(new Destination(
                "Hephaestus' Volcano", attributes, 
                "/image/Location-HephaestusVolcano.jpg"))); // L6
        destinations.add(d7 = new DestinationCard(new Destination("Mount Olympus", 
                attributes, "/image/Location-MountOlympus.jpg"))); // L7
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.EASTERN);
        destinations.add(d8 = new DestinationCard(new Destination("Phoebe's Moon", 
                attributes, "/image/Location-Phobe-Moon.jpg"))); // L8
        destinations.add(d9 = new DestinationCard(new Destination("Poseidon's Ocean",
                attributes, "/image/Location-Poseidon-Ocean.jpg"))); // L9
        
        Solution sol = new Solution(new Suspect("Aphrodite", attributes, 
                "/image/Suspects-Aphrodite.jpg"), new Vehicle(
                "Apollo's Chariot", attributes, 
                "/image/Transportation-ApollosChariot.jpg"), 
                new Destination("Poseidon's Ocean", attributes, 
                "/image/Location-Poseidon-Ocean.jpg"));
        
        ArrayDeque<Player> players = new ArrayDeque<Player>();
        players.add(new HumanPlayer("p1", null, null));
        players.add(new HumanPlayer("p2", null, null));
        players.add(new HumanPlayer("p3", null, null));
        players.add(new HumanPlayer("p4", null, null));
        players.add(new HumanPlayer("p5", null, null));
        
        this.notepad = new Notepad(players, suspects, vehicles, destinations,
                sol);
    }

    /**
     * Test of mark method, of class Notepad.
     */
    public void testMark() {
        System.out.println("mark");
        HumanPlayer h1 = new HumanPlayer("p1", null, null);
        assertTrue(notepad.mark(s1, h1, NoteEntry.HAS));
        assertTrue(notepad.mark(v2, h1, NoteEntry.HAS));
        assertTrue(notepad.mark(d9, h1, NoteEntry.HAS));
    }

    /**
     * Test of hasSolution method, of class Notepad.
     */
    public void testHasSolution() {
        System.out.println("hasSolution");
        
        assertFalse(notepad.hasSolution());
        
        HumanPlayer h1 = new HumanPlayer("p1", null, null);
        HumanPlayer h2 = new HumanPlayer("p2", null, null);
        HumanPlayer h3 = new HumanPlayer("p3", null, null);
        HumanPlayer h4 = new HumanPlayer("p4", null, null);
        HumanPlayer h5 = new HumanPlayer("p5", null, null);
        
        notepad.mark(d1, h1, NoteEntry.HAS);
        notepad.mark(d2, h2, NoteEntry.HAS);
        notepad.mark(d3, h3, NoteEntry.HAS);
        notepad.mark(d4, h4, NoteEntry.HAS);
        notepad.mark(d5, h5, NoteEntry.HAS);
        notepad.mark(d6, h1, NoteEntry.HAS);
        notepad.mark(d7, h2, NoteEntry.HAS);
        notepad.mark(d8, h3, NoteEntry.HAS);
        
        notepad.mark(s2, h1, NoteEntry.HAS);
        notepad.mark(s3, h2, NoteEntry.HAS);
        notepad.mark(s4, h3, NoteEntry.HAS);
        notepad.mark(s5, h4, NoteEntry.HAS);
        notepad.mark(s6, h5, NoteEntry.HAS);
        
        notepad.mark(v2, h1, NoteEntry.HAS);
        notepad.mark(v3, h2, NoteEntry.HAS);
        notepad.mark(v4, h3, NoteEntry.HAS);
        notepad.mark(v5, h4, NoteEntry.HAS);
        notepad.mark(v6, h5, NoteEntry.HAS);
        
        assertTrue(notepad.hasSolution());
    }

    /**
     * Test of clearNotepad method, of class Notepad.
     */
    public void testClearNotepad() {
        System.out.println("clearNotepad");
        HumanPlayer h1 = new HumanPlayer("p1", null, null);
        notepad.mark(d9, h1, NoteEntry.HAS);
        
        assertEquals(NoteEntry.HAS, notepad.getEntry(d9, h1));
        notepad.clearNotepad();
        assertEquals(NoteEntry.BLANK, notepad.getEntry(d9, h1));
    }

    /**
     * Test of getEntry method, of class Notepad.
     */
    public void testGetEntry() {
        System.out.println("getEntry");
        HumanPlayer h1 = new HumanPlayer("p1", null, null);
        notepad.mark(d9, h1, NoteEntry.HAS);
        
        assertEquals(NoteEntry.HAS, notepad.getEntry(d9, h1));
        
        HumanPlayer h2 = new HumanPlayer("p2", null, null);
        notepad.mark(s1, h2, NoteEntry.SHOWN);
        
        assertEquals(NoteEntry.SHOWN, notepad.getEntry(s1, h2));
        
        HumanPlayer h3 = new HumanPlayer("p3", null, null);
        notepad.mark(v1, h3, NoteEntry.HASNOT);
        
        assertEquals(NoteEntry.HASNOT, notepad.getEntry(v1, h3));
    }

    /**
     * Test of getSuspects method, of class Notepad.
     */
    public void testGetSuspects() {
        System.out.println("getSuspects");
        assertEquals(suspects, notepad.getSuspects());
    }

    /**
     * Test of getVehicles method, of class Notepad.
     */
    public void testGetVehicles() {
        System.out.println("getVehicles");
        assertEquals(vehicles, notepad.getVehicles());
    }

    /**
     * Test of getDestinations method, of class Notepad.
     */
    public void testGetDestinations() {
        System.out.println("getDestinations");
        assertEquals(destinations, notepad.getDestinations());
    }
}
