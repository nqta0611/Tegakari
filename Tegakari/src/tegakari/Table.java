package tegakari;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * The Table for storing all the
 * <code>Card</code>s in the game that is not
 * in a
 * <code>Player</code>'s hand and also has a
 * <code>DMPile</code> that
 * <code>Player</code>s can swap with.
 * It also builds all the
 * <code>Deck</code>s and deals the
 * <code>Card</code>s
 * out to
 * <code>Player</code>s.
 *
 * @author Lohit
 */
public class Table implements Serializable
{
    /**
     * <code>DMPile</code> not occupied by a
     * <code>Player</code>
     */
    private DMPile pile;
    /**
     * The
     * <code>Theme</code> of the
     * <code>Card</code>s that was used for this game
     */
    private Theme theme;
    /**
     * Contains <code>ClueCard</code><code>Deck</code>, 
     * <code>ActionCard</code><code>Deck</code>, Discard Pile
     */
    private TableDecks decks;

    /**
     * Constructs the initial Destination Markers Pile from the Theme given.
     * Must call one of the deck building methods to construct both the action
     * and clue deck.
     *
     * @param theme The type of <code>Suspect</code>s,<code>Vehicle</code>s,
     * and <code>Destination</code>s in game
     */
    public Table(Theme theme)
    {
        decks = new TableDecks();
        
        //INIT DMPile
        this.pile = new DMPile(theme);
        //SET Theme
        this.theme = theme;

    }

    /**
     * Retrieves the
     * <code>Theme</code> of cards used for the
     * <code>Table</code>.
     *
     * @return the
     * <code>Theme</code> of cards used for the
     * <code>Table</code>
     */
    public Theme getTheme()
    {
        //RETURN theme
        return theme;
    }

    /**
     * Builds the ActionDeck,hard coded sequence because all themes of game have
     * the same deck.
     */
    public void buildActionDeck()
    {
//        actionDeck = new Deck<ActionCard>();
        decks.initActionDeck();
        //FOR four regular snoop cards in the deck
        for (int counter = 0; counter < 4; counter++)
        {
            //INIT SnoopCard
            //ADD to ActionCardDeck
            this.decks.addCardToActionDeck(decks.makeSnoop());
            //ENDFOR
        }
        //FOR two left all snoop cards in the deck
        for (int counter = 0; counter < 2; counter++)
        {
            //INIT SnoopCard with left Direction

            //ADD to ActionCardDeck
            this.decks.addCardToActionDeck(decks.makeSnoop(Direction.LEFT, 
                    "/image/Action-AllSnoopLeft.jpg"));
            //ENDFOR
        }
        //FOR two right all snoop card in the deck
        for (int counter = 0; counter < 2; counter++)
        {
            //INIT SnoopCard with right Direction

            //ADD to ActionCardDeck
            this.decks.addCardToActionDeck(decks.makeSnoop(Direction.RIGHT, 
                    "/image/Action-AllSnoopRight.jpg"));
            //ENDFOR
        }
        //FOR nine any Destination Suggestion Card in the deck
        for (int counter = 0; counter < 10; counter++)
        {
            //INIT SuggestionCard with false
            SuggestionCard sug = new SuggestionCard(false,
                    "/image/Action-SuggestionAny.jpg");
            //ADD to ActionCardDeck
            this.decks.addCardToActionDeck(sug);
            //ENDFOR
        }
        //FOR eight current Destination Suggestion Cards in the deck
        for (int counter = 0; counter < 9; counter++)
        {
            //INIT SuggestionCard with true
            SuggestionCard sug = new SuggestionCard(true,
                    "/image/Action-SuggestionCurrent.jpg");
            //ADD to ActionCardDeck
            this.decks.addCardToActionDeck(sug);
            //ENDFOR
        }
        
        buildSuperSleuth();
        buildPrivateTip();
    }
    
    private void buildPrivateTip()
    {
        //INIT PrivateTip with Suspect ClueType
        
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.SUSPECT, 
                "/image/Action-PrivateTipAllSuspect.jpg"));
        //INIT PrivateTip with Vehicle ClueType
        
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.VEHICLE, 
                "/image/Action-PrivateTipAllVehicle.jpg"));
        //INIT PrivateTip with Vehicle ClueType and Red Attribute
       
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.VEHICLE, 
                Attribute.RED, "/image/Action-PrivateTipRed.jpg"));
        //INIT PrivateTip with Destination ClueType and Northern Attribute
        
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.DESTINATION, 
                Attribute.NORTHERN, "/image/Action-PrivateTipNorthern.jpg"));
        //INIT PrivateTip with Destination ClueType
        
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.DESTINATION,
                "/image/Action-PrivateTipAllDestination.jpg"));
        //INIT PrivateTip with Suspect ClueType and Female Attribute
        
        //ADD PrivateTip to ActionCardDeck
        this.decks.addCardToActionDeck(decks.makePrivate(ClueType.SUSPECT, 
                Attribute.FEMALE, "/image/Action-PrivateTipFemale.jpg"));
    }
  
    private void buildSuperSleuth()
    {
        //INIT SuperSleuthCard with Suspect ClueType and Female Attribute
        SuperSleuthCard ss = new SuperSleuthCard(
                ClueType.SUSPECT, Attribute.FEMALE, 
                "/image/Action-SuperSleuthFemale.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
        //INIT SuperSleuthCard with Suspect ClueType and Male Attribute
        ss = new SuperSleuthCard(
                ClueType.SUSPECT, Attribute.MALE, "/image/Action-SuperSleuthMale.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
        //INIT SuperSleuthCard with Vehicle ClueType and Flying Attribute
        ss = new SuperSleuthCard(
                ClueType.VEHICLE, Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
        //INIT SuperSleuthCard with Vehicle ClueType and Blue Attribute
        ss = new SuperSleuthCard(
                ClueType.VEHICLE, Attribute.BLUE, "/image/Action-SuperSleuthBlue.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
        //INIT SuperSleuthCard with Destination ClueType and Southern Attribute
        ss = new SuperSleuthCard(
                ClueType.DESTINATION, Attribute.SOUTHERN, 
                "/image/Action-SuperSleuthSouth.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
        //INIT SuperSleuthCard with Destination ClueType and Western Attribute
        ss = new SuperSleuthCard(ClueType.DESTINATION, Attribute.WESTERN,
                "/image/Action-SuperSleuthWest.jpg");
        //ADD to ActionCardDeck
        this.decks.addCardToActionDeck(ss);
    }

    /**
     * Shuffle the Deck
     */
    public void shuffleActionDeck()
    {
        //CALL shuffle on deck
        this.decks.shuffleActionDeck();
    }

    /**
     * Shuffle the DM Pile
     */
    public void shuffleDM()
    {
        //CALL shuffle on DMPile
        this.pile.shuffle();
    }

    /**
     * Allow for pre-determined order of Action deck to facilitate testing by
     * parsing an order from file. The key that will be used to determine action
     * cards is located here:
     * https://calpoly.repositoryhosting.com/trac/calpoly_badgers/wiki/ConsoleDesign/Key
     * A new deck will be created when this method is called and will place each
     * action card in first-in-last-out order, with the first action card in
     * the file on the bottom of the deck and the last action card in the file
     * at the top of the deck.
     *
     * @param file The file path to a file that contains order
     */
    public void buildOrderedActionDeck(String file)
    {
//        decks.getActionDeck() = new Deck<ActionCard>();
        decks.initActionDeck();
        File path = new File(file);
        //File path = new File(file);// use for the download page
        
        try
        {
            Scanner input = new Scanner(path);
            //While there is a line
            while (input.hasNextLine())
            {
                String parse = input.nextLine();
                //INIT card that is parsed
                //ADD card to ActionCardDeck
                switch (parse.charAt(0))
                {
                    case 'G':
                        makeSuggestion(parse.charAt(1));
                        break;
                    case 'T':
                        makePrivateTip(parse.charAt(1));
                        break;
                    case 'N':
                        makeSnoop(parse.charAt(1));
                        break;
                    case 'E':
                        makeSuperSleuth(parse.charAt(1));
                        break;
                    default:
                        System.out.println("notValid");
                        break;
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not Found Exception Action Deck. " + ex);
        }
    }
    
    private void makeSuggestion(char num)
    {
        // if first key
        if (num == '1')
        {
            SuggestionCard stemp = new SuggestionCard(true,
                    "/image/Action-SuggestionCurrent.jpg");
            this.decks.addCardToActionDeck(stemp);
        }
        else
        {
            SuggestionCard stemp = new SuggestionCard(false, 
                    "/image/Action-SuggestionAny.jpg");
            this.decks.addCardToActionDeck(stemp);
        }
    }
    
    private void makePrivateTip(char num)
    {
        //IF first private tip card
        if (num == '1')
        {
            
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.VEHICLE, 
                    Attribute.RED, "/image/Action-PrivateTipRed.jpg"));
        }
        //ELSEIF second private tip card
        else if (num == '2')
        {
           
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.DESTINATION, 
                    Attribute.NORTHERN, "/image/Action-PrivateTipNorthern.jpg"));
        }
        //ELSEIF third private tip card
        else if (num == '3')
        {
            
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.SUSPECT, 
                    Attribute.FEMALE, "/image/Action-PrivateTipFemale.jpg"));
        }
        //ELSEIF fourth private tip card
        else if (num == '4')
        {
//            PrivateTipCard ptemp = new PrivateTipCard(ClueType.VEHICLE, 
//                    "/image/Action-PrivateTipAllVehicle.jpg");
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.VEHICLE, 
                    "/image/Action-PrivateTipAllVehicle.jpg"));
        }
        //ELSEIF fifth private tip card
        else if (num == '5')
        {
//            PrivateTipCard ptemp = new PrivateTipCard(
//                    ClueType.DESTINATION, 
//                    "/image/Action-PrivateTipAllDestination.jpg");
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.DESTINATION, 
                    "/image/Action-PrivateTipAllDestination.jpg"));
        }
        //ELSE sixth private tip card
        else
        {
//            PrivateTipCard ptemp = new PrivateTipCard(ClueType.SUSPECT, 
//                    "/image/Action-PrivateTipAllSuspect.jpg");
            this.decks.addCardToActionDeck(decks.makePrivate(ClueType.SUSPECT, 
                    "/image/Action-PrivateTipAllSuspect.jpg"));
        }
        //ENDIF
    }

    private void makeSnoop(char num)
    {
        //IF first snoop card
        if (num == '1')
        {

            this.decks.addCardToActionDeck(decks.makeSnoop(Direction.LEFT, 
                    "/image/Action-AllSnoopLeft.jpg"));
        }
        //ELSEIF second snoop card
        else if (num == '2')
        {
            this.decks.addCardToActionDeck(decks.makeSnoop(Direction.RIGHT, 
                    "/image/Action-AllSnoopRight.jpg"));
        }
        //ELSE third snoop card
        else
        {
            this.decks.addCardToActionDeck(decks.makeSnoop());
        }
        //ENDIF
    }
    
    private void makeSuperSleuth(char num)
    {
        //IF first super sleuth card
        if (num == '1')
        {
            SuperSleuthCard temp = new SuperSleuthCard(ClueType.VEHICLE, 
                 Attribute.FLYING, "/image/Action-SuperSleuthAir.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ELSEIF second super sleuth card
        else if (num == '2')
        {
            SuperSleuthCard temp = new SuperSleuthCard(ClueType.VEHICLE, 
                    Attribute.BLUE, "/image/Action-SuperSleuthBlue.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ELSEIF third super sleuth card
        else if (num == '3')
        {
            SuperSleuthCard temp = new SuperSleuthCard(
                    ClueType.DESTINATION, Attribute.SOUTHERN, 
                    "/image/Action-SuperSleuthSouth.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ELSEIF fourth super sleuth card
        else if (num == '4')
        {
            SuperSleuthCard temp = new SuperSleuthCard(
                    ClueType.DESTINATION, Attribute.WESTERN, 
                    "/image/Action-SuperSleuthWest.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ELSEIF fifth super sleuth card
        else if (num == '5')
        {
            SuperSleuthCard temp = new SuperSleuthCard(
                    ClueType.SUSPECT, Attribute.FEMALE, 
                    "/image/Action-SuperSleuthFemale.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ELSE sixth super sleuth card
        else
        {
            SuperSleuthCard temp = new SuperSleuthCard(
                    ClueType.SUSPECT, Attribute.MALE, 
                    "/image/Action-SuperSleuthMale.jpg");
            this.decks.addCardToActionDeck(temp);
        }
        //ENDIF
    }
    
    /**
     * Builds the clue Deck from the Theme passed in to the table.
     */
    public void buildClueDeck()
    {
        decks.initClueDeck();
        //FOR each Suspect in theme getSuspects
        for (Suspect temp : this.theme.getSuspects())
        {
            //ADD to clueDeck
            SuspectCard newCard = new SuspectCard(temp);
            this.decks.addCardToClueDeck(newCard);
            //ENDFOR
        }
        //FOR each Vehicle in theme getVehicles
        for (Vehicle temp : this.theme.getVehicles())
        {
            //ADD to clueDeck
            VehicleCard newCard = new VehicleCard(temp);
            this.decks.addCardToClueDeck(newCard);
            //ENDFOR
        }
        //FOR each Destination in theme
        for (Destination temp : this.theme.getDestinations())
        {
            //ADD to clueDeck
            DestinationCard newCard = new DestinationCard(temp);
            this.decks.addCardToClueDeck(newCard);
            //ENDFOR
        }
    }

    /**
     * Shuffle the Deck
     */
    public void shuffleClueDeck()
    {
        //CALL shuffle on deck
        this.decks.shuffleClueDeck();
    }

    /**
     * Builds the clue Deck from the Theme passed in to the table with
     * the given file name. The key that will be used to determine the clue
     * cards is located here:
     * https://calpoly.repositoryhosting.com/trac/calpoly_badgers/wiki/ConsoleDesign/Key
     * A new deck will be created when this method is called and will place each
     * clue card in first-in-last-out order, with the first clue card in
     * the file on the bottom of the deck and the last clue card in the file
     * at the top of the deck. Be aware that the
     * <code>makeSolution()</code>
     * method will be called after constructing decks, so have the three
     * appropriate clue cards be at the end of the file.
     *
     * @param file The file path to a file that contains order
     */
    public void buildOrderedClueDeck(String file)
    {
//        clueDeck = new Deck<ClueCard>();
        decks.initClueDeck();
        List<Suspect> suspects = this.theme.getSuspects();
        List<Vehicle> vehicles = this.theme.getVehicles();
        List<Destination> destinations = this.theme.getDestinations();
        File path = new File(file);
        int index;
        //File path = new File(file); // use for the download page

        try
        {
            //INIT Scanner with file
            Scanner input = new Scanner(path);
            //WHILE there is a next line
            while (input.hasNextLine())
            {
                String parse = input.nextLine();
                //INIT card that is parsed
                //ADD card to ClueDeck
                switch (parse.charAt(0))
                {
                    case 'S':
                        index = Integer.parseInt("" + parse.charAt(1)) - 1;
                        Suspect stemp = suspects.get(index);
                        SuspectCard newSuspectCard = new SuspectCard(stemp);
                        this.decks.addCardToClueDeck(newSuspectCard);
                        break;
                    case 'V':
                        index = Integer.parseInt("" + parse.charAt(1)) - 1;
                        Vehicle vtemp = vehicles.get(index);
                        VehicleCard newVehicleCard = new VehicleCard(vtemp);
                        this.decks.addCardToClueDeck(newVehicleCard);
                        break;
                    default:
                        index = Integer.parseInt("" + parse.charAt(1)) - 1;
                        Destination dtemp = destinations.get(index);
                        DestinationCard newDestCard = new DestinationCard(dtemp);
                        this.decks.addCardToClueDeck(newDestCard);
                        break;
                }
                //ENDWHILE
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not Found Exception Clue Deck. " + ex);
        }
    }

    /**
     * Deals out clue card
     *
     * @return the top <code>ClueCard</code>
     */
    public ClueCard dealClueCard()
    {
        //GET top card off deck
        return this.decks.dealClueDeck();
    }

    /**
     * Deals out action card
     *
     * @return the top <code>ActionCard</code>
     */
    public ActionCard dealActionCard()
    {
        //GET top card off deck
        return this.decks.dealActionDeck();
    }


    /**
     * Deals a
     * <code>Destination</code> acting as the
     * destination marker to Player.
     *
     * @return a destination
     */
    public Destination dealDM()
    {
        //GET top card off DMPile
        return this.pile.removeTopCard();
    }

    /**
     * Exchanges a DestinationMarker from DMPile and Player.
     *
     * @param player The player to exchange
     * @param destination The destination that player wants
     */
    public void exchangeDM(Player player, Destination destination)
    {
        this.pile.removeFromPile(destination);
        //CALL setDestiantion on player using destination card
        Destination temp = player.setDestination(destination);
        //ADD card from setDestination call to DMPile
        this.pile.addDM(temp);
    }

    /**
     * Adds ActionCard that has been played to the discard pile.
     *
     * @param card The card to be discarded
     */
    public void addtoDiscardPile(ActionCard card)
    {
        //ADD card to discard pile
        this.decks.addCardToDisCardPile(card);
    }

    /**
     * Rebuilds the ActionDeck from discard pile when the ActionDeck is empty.
     */
    public void rebuildActionDeckFromDiscardPile()
    {
        //SET discardPile to actionDeck
        this.decks.setActionDeck(this.decks.getDiscardPile());
        //CALL shuffle on actionDeck
        this.decks.shuffleActionDeck();
        //INIT new discardPile
        this.decks.initDisCardPile();
    }

    /**
     * Gets the DMPile, mostly used for GUI interface
     *
     * @return list of Destinations stored in the Destination Pile
     */
    public List<Destination> getPile()
    {
        return this.pile.getPile();
    }

    /**
     * Gets the Action Deck
     *
     * @return list of Action cards stored in the Action Deck
     */
    public Deck<ActionCard> getActionDeck()
    {
        return this.decks.getActionDeck();
    }

    /**
     * Gets the Clue Deck
     *
     * @return list of Clue Cards stored in the Clue Deck
     */
    public Deck<ClueCard> getClueDeck()
    {
        return this.decks.getClueDeck();
    }

    /**
     * Gets the Discard Pile
     *
     * @return list of Action Cards stored in the Discard Pile
     */
    public Deck<ActionCard> getDiscardPile()
    {
        return this.decks.getDiscardPile();
    }

    /**
     * Creates a solution and removes the clue cards from the deck. The solution
     * is chosen after the deck is built, picking the first seen Suspect, Vehicle,
     * and Destination card.
     *
     * @return the solution for this table
     */
    public Solution makeSolution()
    {
        Deck<ClueCard> temp = new Deck<ClueCard>();
        SuspectCard suspect = null;
        VehicleCard vehicle = null;
        DestinationCard destination = null;
        //Search for the suspect, vehicle, destination
        while (suspect == null || vehicle == null || destination == null)
        {
            ClueCard card = decks.dealClueDeck();
            // if suspect
            if (card instanceof SuspectCard && suspect == null)
            {
                suspect = (SuspectCard) card;
            }
            // if vehicle
            else if (card instanceof VehicleCard && vehicle == null)
            {
                vehicle = (VehicleCard) card;
            }
            // if destination
            else if (card instanceof DestinationCard && destination == null)
            {
                destination = (DestinationCard) card;
            }
            else
            {
                temp.addCardToDeck(card);
            }
        }

        addBack(temp);

        return new Solution(suspect.getSuspect(),
                vehicle.getVehicle(),
                destination.getDestination());
    }

    private void addBack(Deck<ClueCard> cards)
    {
        ClueCard card;
        // ADD removed cards back to the deck
        while ((card = cards.dealCard()) != null)
        {
            decks.addCardToClueDeck(card);
        }
    }
    
    /**
     * Gets the <code>TableDecks</code> of the <code>Table</code>.
     * @return TableDecks
     */
    public TableDecks getTableDecks()
    {
        return this.decks;
    }
    
    /**
     * Returns if this Table is equal to the parameter Table
     *
     * @param obj object to check if equals 
     * @return if the two Table objects are equal to each other or not
     */
    @Override
    public boolean equals(Object obj)
    {
        //IF object is null
        if (obj == null)
        {
            return false;
        }
        //ENDIF
        
        //IF object is not a Table 
        if (!(obj instanceof Table))
        {
            return false;
        }
        //ENDIF
        
        Table test = (Table) obj;
        
        //IF piles are not equal
        if (!this.pile.getPile().equals(test.getPile()))
        {
            return false;
        }
        //ENDIF
        
        //IF themes are not equal
        if (!this.theme.equals(test.getTheme()))
        {
            return false;
        }
        //ENDIF
        
        //IF decks are not equal
        if (!this.decks.equals(test.getTableDecks()))
        {
            return false;
        }
        //ENDIF
        
        
        return true;
    }
}
