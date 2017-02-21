package allguis;

import guiConsoleController.SuggestionDialogController;
import guiConsoleController.I_Suggestion;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import tegakari.Destination;
import tegakari.SuggestionCard;
import tegakari.Suspect;
import tegakari.Theme;
import tegakari.Vehicle;

/**
 * Window for making a suggestion from any destination
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class SuggestionDialog extends javax.swing.JDialog implements I_Suggestion
{

    /**
     * The suspect chosen for the suggestion
     */
    private Suspect suspectChosen;
    /**
     * The vehicle chosen for the suggestion
     */
    private Vehicle vehicleChosen;
    /**
     * The destination chosen for the suggestion
     */
    private Destination destinationChosen;
    /**
     * The index of the user's destination
     */
    private int indexMyDM;
    /**
     * True if player moves
     */
    private boolean move = false;
    /**
     * Array of suspects buttons
     */
    private JButton[] suspects;
    /**
     * Array of vehicle buttons
     */
    private JButton[] vehicles;
    /**
     * Array of destinations buttons
     */
    private JButton[] destinations;
    /**
     * List of all suspect cards
     */
    private List<Suspect> suspectCards;
    /**
     * List of all vehicle cards
     */
    private List<Vehicle> vehicleCards;
    /**
     * List of all destination cards
     */
    private List<Destination> destinationCards;
    /**
     * The played suggestion card
     */
    private SuggestionCard suggestionCard;

    /**
     * Form to make a suggestion from any destination window
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param suggestionCard suggestion card used
     * @param ctrl controller, eventHandler for SuggestionDialog
     * @param theme selected theme of the game
     */
    public SuggestionDialog(SuggestionDialogController ctrl, JFrame parent, boolean modal, 
            SuggestionCard suggestionCard, Theme theme)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.suggestionCard = suggestionCard;

        makeArrayButton();
        suspectCards = theme.getSuspects();
        vehicleCards = theme.getVehicles();
        destinationCards = theme.getDestinations();

        //FOR each suspect card, set the image
        for (int suspect = 0; suspect < suspectCards.size(); suspect++)
        {
            suspects[suspect].setIcon(new ImageIcon(
                getClass().getResource(suspectCards.get(suspect).getImagePath())));
            suspects[suspect].setActionCommand("suspect"+(suspect+1));
            suspects[suspect].addActionListener(ctrl);
            suspects[suspect].setName("suspect"+(suspect+1));
        }

        //FOR each vehicle card, set the image
        for (int vehicle = 0; vehicle < vehicleCards.size(); vehicle++)
        {
            vehicles[vehicle].setIcon(new ImageIcon(
                getClass().getResource(vehicleCards.get(vehicle).getImagePath())));
            vehicles[vehicle].setActionCommand("vehicle"+(vehicle+1));
            vehicles[vehicle].addActionListener(ctrl);
            vehicles[vehicle].setName("vehicle"+(vehicle+1));
        }

        //FOR each destination card, set the image
        for (int destination = 0; destination < destinationCards.size(); destination++)
        {
            destinations[destination].setIcon(new ImageIcon(
                getClass().getResource(destinationCards.get(destination).getImagePath())));
            destinations[destination].setActionCommand("destination"+(destination+1));
            destinations[destination].addActionListener(ctrl);
            destinations[destination].setName("destination"+(destination+1));
        }
        
        buttonOK.setActionCommand("ok");
        buttonOK.addActionListener(ctrl);
        buttonOK.addKeyListener(ctrl);
        buttonOK.setName("ok");
        buttonReset.setActionCommand("reset");
        buttonReset.addActionListener(ctrl);
        buttonReset.addKeyListener(ctrl);
        buttonReset.setName("reset");

        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    /**
     * Sets the array of suspects, vehicle, and destination buttons
     */
    private void makeArrayButton()
    {
        suspects = new javax.swing.JButton[6];
        suspects[0] = suspect1;
        suspects[1] = suspect2;
        suspects[2] = suspect3;
        suspects[3] = suspect4;
        suspects[4] = suspect5;
        suspects[5] = suspect6;

        vehicles = new javax.swing.JButton[6];
        vehicles[0] = vehicle1;
        vehicles[1] = vehicle2;
        vehicles[2] = vehicle3;
        vehicles[3] = vehicle4;
        vehicles[4] = vehicle5;
        vehicles[5] = vehicle6;

        destinations = new javax.swing.JButton[9];
        destinations[0] = destination1;
        destinations[1] = destination2;
        destinations[2] = destination3;
        destinations[3] = destination4;
        destinations[4] = destination5;
        destinations[5] = destination6;
        destinations[6] = destination7;
        destinations[7] = destination8;
        destinations[8] = destination9;
    }
    
    public void dispose()
   {
       this.setVisible(false);
   }
    
    /**
     * Returns the 'OK' button.
     * 
     * @return the ok button
     */
    public JButton getOKButton()
    {
        return buttonOK;
    }
    
    
    
    /**
     * Obtain the suspect button with the corresponding number,
     * starting from 1 at the most left.
     * 
     * @param suspect the button number, not the index number, 
     * starting from the left at 1
     * @return the JButton representing the suspect player
     */
    public JButton getSuspectButton(int suspect)
    {
        return suspects[suspect-1];
    }
    
    /**
     * Obtain the vehicle button with the corresponding number,
     * starting from 1 at the most left.
     * 
     * @param vehicle the button number, not the index number, 
     * starting from the left at 1
     * @return the JButton representing the vehicle
     */
    public JButton getVehicleButton(int vehicle)
    {
        return vehicles[vehicle-1];
    }
    
    /**
     * Obtain the destination button with the corresponding number,
     * starting from 1 at the most left.
     * 
     * @param destination the button number, not the index number, 
     * starting from the left at 1
     * @return the JButton representing the destination
     */
    public JButton getDestinationButton(int destination)
    {
        return destinations[destination-1];
    }
    
    /**
     * Returns the JButton for the current destination.
     * 
     * @return JButton representing the current destination
     */
    public JButton getCurrDestination()
    {
        return destinations[indexMyDM];
    }
    
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuggestion = new javax.swing.JPanel();
        dialogName = new javax.swing.JLabel();
        labelSuspect = new javax.swing.JLabel();
        panelSuspect = new javax.swing.JPanel();
        suspect1 = new javax.swing.JButton();
        suspect2 = new javax.swing.JButton();
        suspect3 = new javax.swing.JButton();
        suspect4 = new javax.swing.JButton();
        suspect5 = new javax.swing.JButton();
        suspect6 = new javax.swing.JButton();
        labelVehicle = new javax.swing.JLabel();
        panelVehicle = new javax.swing.JPanel();
        vehicle1 = new javax.swing.JButton();
        vehicle2 = new javax.swing.JButton();
        vehicle3 = new javax.swing.JButton();
        vehicle4 = new javax.swing.JButton();
        vehicle5 = new javax.swing.JButton();
        vehicle6 = new javax.swing.JButton();
        labelDest = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        panelVehicle1 = new javax.swing.JPanel();
        destination1 = new javax.swing.JButton();
        destination2 = new javax.swing.JButton();
        destination3 = new javax.swing.JButton();
        destination4 = new javax.swing.JButton();
        destination5 = new javax.swing.JButton();
        destination6 = new javax.swing.JButton();
        destination7 = new javax.swing.JButton();
        destination8 = new javax.swing.JButton();
        destination9 = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dialogName.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        dialogName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dialogName.setText("Make Suggestion ");

        labelSuspect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSuspect.setText("Suspect(1-6)");

        panelSuspect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        suspect1.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect1);

        suspect2.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect2);

        suspect3.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect3);

        suspect4.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect4);

        suspect5.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect5);

        suspect6.setPreferredSize(new java.awt.Dimension(70, 100));
        panelSuspect.add(suspect6);

        labelVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVehicle.setText("Vehicle(qwerty)");

        panelVehicle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        vehicle1.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle1);

        vehicle2.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle2);

        vehicle3.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle3);

        vehicle4.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle4);

        vehicle5.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle5);

        vehicle6.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle.add(vehicle6);

        labelDest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDest.setText("Destination(asdfghjkl)");

        buttonOK.setText("OK (SPACE)");
        buttonOK.setName("okButton"); // NOI18N
        buttonOK.setEnabled(false);

        panelVehicle1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        destination1.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination1);

        destination2.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination2);

        destination3.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination3);

        destination4.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination4);

        destination5.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination5);

        destination6.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination6);

        destination7.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination7);

        destination8.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination8);

        destination9.setPreferredSize(new java.awt.Dimension(70, 100));
        panelVehicle1.add(destination9);

        buttonReset.setText("Reset(C)");

        org.jdesktop.layout.GroupLayout panelSuggestionLayout = new org.jdesktop.layout.GroupLayout(panelSuggestion);
        panelSuggestion.setLayout(panelSuggestionLayout);
        panelSuggestionLayout.setHorizontalGroup(
            panelSuggestionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSuspect, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelVehicle1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
            .add(panelVehicle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelSuggestionLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelSuggestionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelSuspect, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelSuggestionLayout.createSequentialGroup()
                        .add(panelSuggestionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dialogName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelDest, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelVehicle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelSuggestionLayout.createSequentialGroup()
                                .add(0, 618, Short.MAX_VALUE)
                                .add(buttonReset)
                                .add(18, 18, 18)
                                .add(buttonOK)))
                        .addContainerGap())))
        );
        panelSuggestionLayout.setVerticalGroup(
            panelSuggestionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSuggestionLayout.createSequentialGroup()
                .addContainerGap()
                .add(dialogName)
                .add(1, 1, 1)
                .add(labelSuspect)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelSuspect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelVehicle)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVehicle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelDest)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVehicle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(panelSuggestionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonOK)
                    .add(buttonReset)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSuggestion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSuggestion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton destination1;
    private javax.swing.JButton destination2;
    private javax.swing.JButton destination3;
    private javax.swing.JButton destination4;
    private javax.swing.JButton destination5;
    private javax.swing.JButton destination6;
    private javax.swing.JButton destination7;
    private javax.swing.JButton destination8;
    private javax.swing.JButton destination9;
    private javax.swing.JLabel dialogName;
    private javax.swing.JLabel labelDest;
    private javax.swing.JLabel labelSuspect;
    private javax.swing.JLabel labelVehicle;
    private javax.swing.JPanel panelSuggestion;
    private javax.swing.JPanel panelSuspect;
    private javax.swing.JPanel panelVehicle;
    private javax.swing.JPanel panelVehicle1;
    private javax.swing.JButton suspect1;
    private javax.swing.JButton suspect2;
    private javax.swing.JButton suspect3;
    private javax.swing.JButton suspect4;
    private javax.swing.JButton suspect5;
    private javax.swing.JButton suspect6;
    private javax.swing.JButton vehicle1;
    private javax.swing.JButton vehicle2;
    private javax.swing.JButton vehicle3;
    private javax.swing.JButton vehicle4;
    private javax.swing.JButton vehicle5;
    private javax.swing.JButton vehicle6;
    // End of variables declaration//GEN-END:variables
}
