package tegakari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A Theme represents the Suspect Cards, Vehicles, and Destinations that will be
 * used when a game is running. The first player will get to decide which theme
 * to use. Themes will be integrated by locating the path to the file that
 * contains the pictures to all the Clue Cards and the name of the Clue Cards.
 *
 * @author Josh Choi - pseudocode
 * @author Josh Choi - implementation
 */
public class Theme implements Serializable 
{

    // -- DATA MEMBERS --
    /**
     * List of Suspects collected from <code>ThemeType</code>.
     */
    private List<Suspect> suspects;
    /**
     * List of Vehicles collected from <code>ThemeType</code>.
     */
    private List<Vehicle> vehicles;
    /**
     * List of Destinations collected from <code>ThemeType</code>.
     */
    private List<Destination> destinations;

    /*
     * The total number of <code>Suspect</code> in the game.
     */
    //final int num_Suspects = 6;

    /*
     * The total number of <code>Vehicle</code> in the game.
     */
    //final int num_Vehicles = 6;

    /*
     * The total number of <code>Destination</code> in the game.
     */
    //final int num_Destinations = 9;
    // -- METHODS --
    
    /**
     * Default theme of Greece pre-loaded.
     */
    public Theme() 
    {
         // initialize lists of Suspects, Vehicles, and Destinations
        this.suspects = new ArrayList<Suspect>();
        this.vehicles = new ArrayList<Vehicle>();
        this.destinations = new ArrayList<Destination>();
        
        // 6 Suspects
        loadGreekSuspects();
        // 6 Vehicles
        loadGreekVehicles();
        // 9 Destinations
        loadGreekDestinations();

        // Make a copy of DM pile, for GUI to access later.
        /*for (Destination d: destinations){
            Destination a = new Destination(d.name, d.getAttributes(), d.imagePath);
            allDM.add(a);
        }*///This was a work-around before Josh fix bugs of deep copy get DM pile
    }
    
    /**
     * A helper method to get below 50 lines.
     * creates and adds suspects to list.
     */
    private void loadGreekSuspects() 
    {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.FEMALE);
        
        suspects.add(new Suspect("Aphrodite", attributes, 
                "/image/GreeceImages/Suspects-Aphrodite.jpg")); // S1
        suspects.add(new Suspect("Artemis", attributes, 
                "/image/GreeceImages/Suspects-Artemis.jpg")); // S2
        suspects.add(new Suspect("Hera", attributes, 
                "/image/GreeceImages/Suspects-Hera.jpg")); // S3
        
        attributes = new ArrayList<Attribute>();
        attributes.add(Attribute.MALE);
        suspects.add(new Suspect("Ares", attributes, 
                "/image/GreeceImages/Suspects-Ares.jpg"));  // S4
        suspects.add(new Suspect("Dionysus", attributes, 
                "/image/GreeceImages/Suspects-Dionysus.jpg")); // S5
        suspects.add(new Suspect("Hermes", attributes, 
                "/image/GreeceImages/Suspects-Hermes.jpg")); // S6
    }
    
    /**
     * a helper method.
     * creates and adds vehicles to list.
     */
    private void loadGreekVehicles()
    {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes = new ArrayList<Attribute>();

        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.GROUND);        
        vehicles.add(new Vehicle("Apollo's Chariot", attributes, 
                "/image/GreeceImages/Transportation-ApollosChariot.jpg")); // V1
        vehicles.add(new Vehicle("Athena's Horse", attributes, 
                "/image/GreeceImages/Transportation-AthenaHorse.jpg")); // V2
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.BLUE);
        attributes.add(Attribute.FLYING);
        vehicles.add(new Vehicle("Eros' Wings", attributes, 
                "/image/GreeceImages/Transportation-ErosWings.jpg")); // V3
        
        attributes = new ArrayList<Attribute>();

        attributes.add(Attribute.RED);
        attributes.add(Attribute.GROUND);
        vehicles.add(new Vehicle("Hades' Dogs", attributes, 
                "/image/GreeceImages/Transportation-HadesDogs.jpg")); // V4
        vehicles.add(new Vehicle("Poseidon's Ship", attributes, 
                "/image/GreeceImages/Transportation-PoseidonShip.jpg")); // V5
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.RED);
        attributes.add(Attribute.FLYING);
        vehicles.add(new Vehicle("Hermes Sandals", attributes, 
                "/image/GreeceImages/Transportation-HermesWingSandals.jpg")); 
                // V6
    }
    
    /**
     * helper method.
     * creates and adds destinations to list.
     */
    private void loadGreekDestinations()
    {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.EASTERN);
        destinations.add(new Destination("Athena's Forest", attributes, 
                "/image/GreeceImages/Location-Athena-Forest.jpg")); // L1
        destinations.add(new Destination("Athens", attributes, 
                "/image/GreeceImages/Location-Athens.jpg")); // L2
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.NORTHERN);
        attributes.add(Attribute.WESTERN);
        destinations.add(new Destination("Atlas' Sky", attributes, 
                "/image/GreeceImages/Location-AtlasSky.jpg")); // L3
        destinations.add(new Destination("Dionysus' Vineyard", attributes, 
                "/image/GreeceImages/Location-Dionysus-Vineyard.jpg")); // L4
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.WESTERN);
        destinations.add(new Destination("Hades' Underworld", attributes, 
                "/image/GreeceImages/Location-HadesUnderworld.jpg")); // L5
        destinations.add(new Destination("Hephaestus' Volcano", attributes, 
                "/image/GreeceImages/Location-HephaestusVolcano.jpg")); // L6
        destinations.add(new Destination("Mount Olympus", attributes, 
                "/image/GreeceImages/Location-MountOlympus.jpg")); // L7
        
        attributes = new ArrayList<Attribute>();
        
        attributes.add(Attribute.SOUTHERN);
        attributes.add(Attribute.EASTERN);
        destinations.add(new Destination("Phoebe's Moon", attributes, 
                "/image/GreeceImages/Location-Phobe-Moon.jpg")); // L8
        destinations.add(new Destination("Poseidon's Ocean", attributes, 
                "/image/GreeceImages/Location-Poseidon-Ocean.jpg")); // L9
    }
    
    /**
     * Return an ArrayList of the <code>Suspect</code> that were collected from the
     * theme files.
     *
     * @return The ArrayList of <code>Suspect</code> that were interpreted
     */
    public List<Suspect> getSuspects() 
    {
        // RETURN list of Suspects
        return this.suspects;
    }

    /**
     * Return an ArrayList of the <code>Vehicle</code> that were collected from the
     * theme files.
     *
     * @return The ArrayList of <code>Vehicle</code> that were interpreted
     */
    public List<Vehicle> getVehicles() 
    {
        // RETURN list of Vehicles
        return this.vehicles;
    }

    /**
     * Return an ArrayList of the <code>Destination</code>'s that were collected from the
     * theme files.
     *
     * @return The ArrayList of <code>Destination</code>'s that were interpreted
     */
    public List<Destination> getDestinations() 
    {
        // RETURN list of Destinations
        return this.destinations;
    }
    
    /**
     * This function acts as the constructor for this <code>Theme</code>
     * in that it reconstructs all the <code>List</code> of 
     * <code>ClueCard</code> entries to the new <code>ThemeType</code>.
     * 
     * @param theme The <code>ThemeType</code> which contains the path name to 
     * the images for the <code>Theme</code>.
     */
    public void changeThemeType(ThemeType theme) 
    {
        // SET the Theme with the given ThemeType paramiter
        // CALL getFilePath of the given ThemeType
        //  the file path will be used to read in the clue cards
        //  the file must have the correct format 
        //  each line goes cardType, name, attribute, attribute(?)
        String path = theme.getFilePath();
        Scanner scan;
        // SET initial lists of Suspects, Vehicles, and Destinations
        this.suspects = new ArrayList<Suspect>();
        this.vehicles = new ArrayList<Vehicle>();
        this.destinations = new ArrayList<Destination>();

        // SET a file out of the path
        InputStream input;
        //File file = new File(getClass().getResourceAsStream(path));
        try 
        {
            input = getClass().getResourceAsStream(path);
            // SET Scanner for the file
            scan = new Scanner(input);
            
            // WHILE new line not EOF
            while (scan.hasNextLine()) 
            {
                // CALL scan in a new line
                String line = scan.nextLine();
                // SET a new Scanner to only scan a line
                Scanner scanner = new Scanner(line);
                // CALL scan in first word of the line - what type of ClueCard
                String cardType = scanner.next();
                // CALL scan in second word of the line - name of the ClueCard
                String cardName = scanner.next().replace("%", " ");
                // CALL scan in filepath to the image location of the ClueCard
                String filePath = "/";
                filePath += scanner.next();
                //String filePath = scanner.next();
                // CALL scan in the attributes and add to attribute list
                List<Attribute> attr = new ArrayList<Attribute>();
                // WHILE loops when it has more data to scan
                while (scanner.hasNext()) 
                {
                    // CALL scan in attribute
                    attr.add(Attribute.valueOf(scanner.next()));
                }
                // IF first word = Suspect
                if (cardType.equals("Suspect")) 
                {
                    // SET new Suspect with the given name and attributes
                    Suspect suspect = new Suspect(cardName, attr, filePath);
                    // ADD created Suspect to list
                    this.suspects.add(suspect);
                }
                // ELSEIF first word = Vehicle
                else if (cardType.equals("Vehicle")) 
                {
                    // SET new Vehicle with the given name and attributes
                    Vehicle vehicle = new Vehicle(cardName, attr, filePath);
                    // ADD created Vehcile to list
                    this.vehicles.add(vehicle);
                }
                // ELSEIF first word = Destination
                else if (cardType.equals("Destination")) 
                {
                    // SET new Destination with the given name and attributes
                    Destination destination = new Destination(cardName, attr, filePath);
                    // ADD created Destination to list
                    this.destinations.add(destination);
                // ENDIF
                }
            // ENDWHILE
            }
        } 
        catch (Exception e) 
        {
            System.out.println("File Not Found Exception");
        }
        // check for changed script
        if (theme.equals(ThemeType.GREEK))
        {
            loadGreekTheme();
        }
    }
    
    private void loadGreekTheme()
    {
        this.suspects = new ArrayList<Suspect>();
        this.vehicles = new ArrayList<Vehicle>();
        this.destinations = new ArrayList<Destination>();

        loadGreekSuspects();
        loadGreekVehicles();
        loadGreekDestinations();
    }
}
