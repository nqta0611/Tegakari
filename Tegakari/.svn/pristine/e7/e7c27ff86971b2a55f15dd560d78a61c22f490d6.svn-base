package unit_test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import tegakari.*;

/**
 * Junit Unit Test Case that tests the <code>Theme</code> class.  Lowest
 * dependency of v2.0 classes so no mocks are used.
 * 
 * @author Josh Choi - jchoi30
 */
public class ThemeTest extends TestCase {
    
    public ThemeTest(String testName) {
        super(testName);
    }

    /**
     * Test of getSuspects method, of class Theme.
     */
    public void testGetSuspects() {
        System.out.println("getSuspects");
        Theme theme = new Theme();
        List<Suspect> suspects = theme.getSuspects();
        List<Attribute> attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.FEMALE);
        assertTrue(suspects.contains(new Suspect("Aphrodite", attributes, 
                "/image/GreeceImages/Suspects-Aphrodite.jpg")));
        assertTrue(suspects.contains(new Suspect("Artemis", attributes, 
                "/image/GreeceImages/Suspects-Artemis.jpg")));
        assertTrue(suspects.contains(new Suspect("Hera", attributes, 
                "/image/GreeceImages/Suspects-Hera.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.MALE);
        assertTrue(suspects.contains(new Suspect("Ares", attributes, 
                "/image/GreeceImages/Suspects-Ares.jpg")));
        assertTrue(suspects.contains(new Suspect("Dionysus", attributes, 
                "/image/GreeceImages/Suspects-Dionysus.jpg")));
        assertTrue(suspects.contains(new Suspect("Hermes", attributes, 
                "/image/GreeceImages/Suspects-Hermes.jpg")));
    }

    /**
     * Test of getVehicles method, of class Theme.
     */
    public void testGetVehicles() {
        System.out.println("getVehicles");
        Theme theme = new Theme();
        List<Vehicle> vehicles = theme.getVehicles();
        List<Attribute> attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.GROUND);
        assertTrue(vehicles.contains(new Vehicle("Apollo's Chariot", attributes, 
                "/image/GreeceImages/Transportation-ApollosChariot.jpg")));
        assertTrue(vehicles.contains(new Vehicle("Athena's Horse", attributes, 
                "/image/GreeceImages/Transportation-AthenaHorse.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.FLYING);
        assertTrue(vehicles.contains(new Vehicle("Eros' Wings", attributes, 
                "/image/GreeceImages/Transportation-ErosWings.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.RED);
        attributes.add(Attribute.GROUND);;
        assertTrue(vehicles.contains(new Vehicle("Hades' Dogs", attributes, 
                "/image/GreeceImages/Transportation-HadesDogs.jpg")));
        assertTrue(vehicles.contains(new Vehicle("Poseidon's Ship", attributes, 
                "/image/GreeceImages/Transportation-PoseidonShip.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.RED);
        attributes.add(Attribute.FLYING);
        assertTrue(vehicles.contains(new Vehicle("Hermes Sandals", attributes, 
                "/image/GreeceImages/Transportation-HermesWingSandals.jpg")));
    }

    /**
     * Test of getDestinations method, of class Theme.
     */
    public void testGetDestinations() {
        System.out.println("getDestinations");
        Theme theme = new Theme();
        List<Destination> destinations = theme.getDestinations();
        List<Attribute> attributes = new ArrayList<Attribute>();
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.EASTERN);
        assertTrue(destinations.contains(new Destination("Athena's Forest", 
                attributes, "/image/GreeceImages/Location-Athena-Forest.jpg"))); // L1
        assertTrue(destinations.contains(new Destination("Athens", attributes, 
                "/image/GreeceImages/Location-Athens.jpg"))); // L2
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.WESTERN);
        assertTrue(destinations.contains(new Destination("Atlas' Sky", attributes, 
                "/image/GreeceImages/Location-AtlasSky.jpg"))); // L3
        assertTrue(destinations.contains(new Destination("Dionysus' Vineyard", attributes, 
                "/image/GreeceImages/Location-Dionysus-Vineyard.jpg"))); // L4
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.WESTERN);
        assertTrue(destinations.contains(new Destination("Hades' Underworld", attributes, 
                "/image/GreeceImages/Location-HadesUnderworld.jpg"))); // L5
        assertTrue(destinations.contains(new Destination("Hephaestus' Volcano", attributes, 
                "/image/GreeceImages/Location-HephaestusVolcano.jpg"))); // L6
        assertTrue(destinations.contains(new Destination("Mount Olympus", attributes, 
                "/image/GreeceImages/Location-MountOlympus.jpg"))); // L7
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.EASTERN);
        assertTrue(destinations.contains(new Destination("Phoebe's Moon", attributes, 
                "/image/GreeceImages/Location-Phobe-Moon.jpg"))); // L8
        assertTrue(destinations.contains(new Destination("Poseidon's Ocean", attributes, 
                "/image/GreeceImages/Location-Poseidon-Ocean.jpg"))); // L9
    }

    /**
     * Test of changeThemeType method, of class Theme.
     */
    public void testChangeThemeType() {
        System.out.println("changeThemeType");
        Theme theme = new Theme();
        theme.changeThemeType(ThemeType.WESTERN);
        
        List<Suspect> suspects = theme.getSuspects();
        List<Attribute> attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.FEMALE);
        assertTrue(suspects.contains(new Suspect("Helen", attributes, 
                "/image/Suspects-Helen.jpg")));
        assertTrue(suspects.contains(new Suspect("Ashley", attributes, 
                "/image/Suspects-Ashley.jpg")));
        assertTrue(suspects.contains(new Suspect("Catherine", attributes, 
                "/image/Suspects-Catherine.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.MALE);
        assertTrue(suspects.contains(new Suspect("Bob", attributes, 
                "/image/Suspects-Bob.jpg")));
        assertTrue(suspects.contains(new Suspect("Steve", attributes, 
                "/image/Suspects-Steve.jpg")));
        assertTrue(suspects.contains(new Suspect("Texas", attributes, 
                "/image/Suspects-Texas.jpg")));
        
        List<Vehicle> vehicles = theme.getVehicles();
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.GROUND);
        assertTrue(vehicles.contains(new Vehicle("Wagon", attributes, 
                "/image/Transportation-Wagon.jpg")));
        assertTrue(vehicles.contains(new Vehicle("Mustang", attributes, 
                "/image/Transportation-Mustang.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.FLYING);
        assertTrue(vehicles.contains(new Vehicle("Flying Mustang", attributes, 
                "/image/Transportation-FlyingMustang.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.RED);
        attributes.add(Attribute.GROUND);;
        assertTrue(vehicles.contains(new Vehicle("Ox", attributes, 
                "/image/Transportation-Ox.jpg")));
        assertTrue(vehicles.contains(new Vehicle("Bull", attributes, 
                "/image/Transportation-Bull.jpg")));
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.RED);
        attributes.add(Attribute.FLYING);
        assertTrue(vehicles.contains(new Vehicle("Speedwagon", attributes, 
                "/image/Transportation-Speedwagon.jpg")));
        
        List<Destination> destinations = theme.getDestinations();
        attributes = new ArrayList<Attribute>();
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.EASTERN);
        assertTrue(destinations.contains(new Destination("Bar", 
                attributes, "/image/Location-Bar.jpg"))); // L1
        assertTrue(destinations.contains(new Destination("Steve's House", attributes, 
                "/image/Location-SteveHouse.jpg"))); // L2
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.WESTERN);
        assertTrue(destinations.contains(new Destination("Wastelands", attributes, 
                "/image/Location-Wastelands.jpg"))); // L3
        assertTrue(destinations.contains(new Destination("Desert", attributes, 
                "/image/Location-Desert.jpg"))); // L4
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.WESTERN);
        assertTrue(destinations.contains(new Destination("Piano Bar", attributes, 
                "/image/Location-PianoBar.jpg"))); // L5
        assertTrue(destinations.contains(new Destination("Farm", attributes, 
                "/image/Location-Farm.jpg"))); // L6
        assertTrue(destinations.contains(new Destination("Town", attributes, 
                "/image/Location-Town.jpg"))); // L7
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.EASTERN);
        assertTrue(destinations.contains(new Destination("Graveyard", attributes, 
                "/image/Location-Graveyard.jpg"))); // L8
        assertTrue(destinations.contains(new Destination("Catherine's House", attributes, 
                "/image/Location-CatherineHouse.jpg"))); // L9
    }
}
