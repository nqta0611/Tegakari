package allguis;

import guiConsoleController.I_Accusation;
import guiConsoleController.AccusationController;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import tegakari.Destination;
import tegakari.Solution;
import tegakari.Suspect;
import tegakari.Vehicle;

/**
 * Swing window for selecting the Suspect, Vehicle, and Destination of an
 * accusation.
 *
 * @author Anh Nguyen
 * @version 11/30/15 change source path
 */
public class AccusationDialog extends javax.swing.JDialog implements I_Accusation
{

    /**
     * Suspect selected for accusation
     */
    private Suspect suspectChosen;
    /**
     * Vehicle selected for accusation
     */
    private Vehicle vehicleChosen;
    /**
     * Destination selected for accusation
     */
    private Destination destinationChosen;
    /**
     * Parent GameTable GUI
     */
    private GameTable tableGui;
    /**
     * Array of suspect buttons
     */
    private javax.swing.JButton[] suspects;
    /**
     * Array of vehicle buttons
     */
    private javax.swing.JButton[] vehicles;
    /**
     * Array of destination buttons
     */
    private javax.swing.JButton[] destinations;
    /**
     * List of suspects
     */
    private List<Suspect> suspectCards;
    /**
     * List of vehicles
     */
    private List<Vehicle> vehicleCards;
    /**
     * List of destinations
     */
    private List<Destination> destinationCards;
    /**
     * Suspect, vehicle, and destination for the accusation
     */
    private Solution result;
    private AccusationController ctrl;

    /**
     * Creates new form AccusationDialog
     *
     * @param parent the parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param ctrl AccusationController, eventHandler for AccusationDialog
     */
    public AccusationDialog(AccusationController ctrl, GameTable parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        tableGui = parent;
        makeArrayButton();
        suspectCards = parent.getTable().getTheme().getSuspects();
        vehicleCards = parent.getTable().getTheme().getVehicles();
        destinationCards = parent.getTable().getTheme().getDestinations();

        //SET icons for suspects
        for (int suspect = 0; suspect < suspectCards.size(); suspect++)
        {
            suspects[suspect].setIcon(new ImageIcon(getClass().getResource(suspectCards.get(suspect).getImagePath())));
            suspects[suspect].setActionCommand("suspect"+(suspect+1));
            suspects[suspect].addActionListener(ctrl);
        }

        //SET icons for vehicles
        for (int vehicle = 0; vehicle < vehicleCards.size(); vehicle++)
        {
            vehicles[vehicle].setIcon(new ImageIcon(getClass().getResource(vehicleCards.get(vehicle).getImagePath())));
            vehicles[vehicle].setActionCommand("vehicle"+(vehicle+1));
            vehicles[vehicle].addActionListener(ctrl);
        }

        //SET icons for destination
        for (int destination = 0; destination < destinationCards.size(); destination++)
        {
            destinations[destination].setIcon(new ImageIcon(getClass().getResource(destinationCards.get(destination).getImagePath())));
            destinations[destination].setActionCommand("destination"+(destination+1));
            destinations[destination].addActionListener(ctrl);
        }
        
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
        ButtonSubmit.setActionCommand("ok");
        ButtonSubmit.addActionListener(ctrl);
        ButtonSubmit.addKeyListener(ctrl);
        ButtonReset.setActionCommand("reset");
        ButtonReset.addActionListener(ctrl);
        ButtonReset.addKeyListener(ctrl);
        ButtonCancel.setActionCommand("cancel");
        ButtonCancel.addActionListener(ctrl);
        ButtonCancel.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
        
        setNames();
    }

    private void setNames()
    {
        AccussationPanel.setName("accusationPanel");
        ButtonCancel.setName("buttonCancel");
        ButtonReset.setName("buttonReset");
        ButtonSubmit.setName("buttonSubmit");
        Destination1.setName("destination1");
        Destination2.setName("destination2");
        Destination3.setName("destination3");
        Destination4.setName("destination4");
        Destination5.setName("destination5");
        Destination6.setName("destination6");
        Destination7.setName("destination7");
        Destination8.setName("destination8");
        Destination9.setName("destination9");
        DestinationPanel.setName("destinationPanel");
        DialogName.setName("dialogName");
        LabelDest.setName("labeDest");
        LabelSuspect.setName("lableSuspect");
        LabelVehicle.setName("lableVehicle");
        Suspect1.setName("suspect1");
        Suspect2.setName("suspect2");
        Suspect3.setName("suspect3");
        Suspect4.setName("suspect4");
        Suspect5.setName("suspect5");
        Suspect6.setName("suspect6");
        SuspectPanel.setName("suspectPanel");
        Vehicle1.setName("vehicle1");
        Vehicle2.setName("vehicle2");
        Vehicle3.setName("vehicle3");
        Vehicle4.setName("vehicle4");
        Vehicle5.setName("vehicle5");
        Vehicle6.setName("vehicle6");
        VehiclePanel.setName("vehiclePanel");
    }
    
    /**
     * This
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AccussationPanel = new javax.swing.JPanel();
        DialogName = new javax.swing.JLabel();
        LabelSuspect = new javax.swing.JLabel();
        SuspectPanel = new javax.swing.JPanel();
        Suspect1 = new javax.swing.JButton();
        Suspect2 = new javax.swing.JButton();
        Suspect3 = new javax.swing.JButton();
        Suspect4 = new javax.swing.JButton();
        Suspect5 = new javax.swing.JButton();
        Suspect6 = new javax.swing.JButton();
        LabelVehicle = new javax.swing.JLabel();
        VehiclePanel = new javax.swing.JPanel();
        Vehicle1 = new javax.swing.JButton();
        Vehicle2 = new javax.swing.JButton();
        Vehicle3 = new javax.swing.JButton();
        Vehicle4 = new javax.swing.JButton();
        Vehicle5 = new javax.swing.JButton();
        Vehicle6 = new javax.swing.JButton();
        LabelDest = new javax.swing.JLabel();
        DestinationPanel = new javax.swing.JPanel();
        Destination1 = new javax.swing.JButton();
        Destination2 = new javax.swing.JButton();
        Destination3 = new javax.swing.JButton();
        Destination4 = new javax.swing.JButton();
        Destination5 = new javax.swing.JButton();
        Destination6 = new javax.swing.JButton();
        Destination7 = new javax.swing.JButton();
        Destination8 = new javax.swing.JButton();
        Destination9 = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        ButtonSubmit = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DialogName.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        DialogName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DialogName.setText("Make Accusation");

        LabelSuspect.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LabelSuspect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSuspect.setText("Choose a Suspect:(1-6)");

        SuspectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Suspect1.setPreferredSize(new java.awt.Dimension(70, 100));
        SuspectPanel.add(Suspect1);

        Suspect2.setPreferredSize(new java.awt.Dimension(70, 100));
        SuspectPanel.add(Suspect2);

        Suspect3.setPreferredSize(new java.awt.Dimension(70, 100));
        Suspect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suspect3ActionPerformed(evt);
            }
        });
        SuspectPanel.add(Suspect3);

        Suspect4.setPreferredSize(new java.awt.Dimension(70, 100));
        Suspect4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suspect4ActionPerformed(evt);
            }
        });
        SuspectPanel.add(Suspect4);

        Suspect5.setPreferredSize(new java.awt.Dimension(70, 100));
        Suspect5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suspect5ActionPerformed(evt);
            }
        });
        SuspectPanel.add(Suspect5);

        Suspect6.setPreferredSize(new java.awt.Dimension(70, 100));
        Suspect6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suspect6ActionPerformed(evt);
            }
        });
        SuspectPanel.add(Suspect6);

        LabelVehicle.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LabelVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVehicle.setText("Choose a Vehicle:(qwerty)");

        VehiclePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Vehicle1.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle1ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle1);

        Vehicle2.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle2ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle2);

        Vehicle3.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle3ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle3);

        Vehicle4.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle4ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle4);

        Vehicle5.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle5ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle5);

        Vehicle6.setPreferredSize(new java.awt.Dimension(70, 100));
        Vehicle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vehicle6ActionPerformed(evt);
            }
        });
        VehiclePanel.add(Vehicle6);

        LabelDest.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LabelDest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDest.setText("Choose a Destination(asdfghjkl)");

        DestinationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Destination1.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination1ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination1);

        Destination2.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination2ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination2);

        Destination3.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination3ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination3);

        Destination4.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination4ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination4);

        Destination5.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination5ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination5);

        Destination6.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination6ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination6);

        Destination7.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination7ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination7);

        Destination8.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination8ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination8);

        Destination9.setPreferredSize(new java.awt.Dimension(70, 100));
        Destination9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destination9ActionPerformed(evt);
            }
        });
        DestinationPanel.add(Destination9);

        ButtonCancel.setText("Cancel(Z)");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        ButtonSubmit.setText("Submit (SPACE)");
        ButtonSubmit.setEnabled(false);
        ButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSubmitActionPerformed(evt);
            }
        });

        ButtonReset.setText("Reset(C)");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout AccussationPanelLayout = new org.jdesktop.layout.GroupLayout(AccussationPanel);
        AccussationPanel.setLayout(AccussationPanelLayout);
        AccussationPanelLayout.setHorizontalGroup(
            AccussationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AccussationPanelLayout.createSequentialGroup()
                .add(AccussationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(AccussationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(AccussationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, AccussationPanelLayout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(ButtonReset)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(ButtonCancel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(ButtonSubmit))
                            .add(VehiclePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(SuspectPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(DestinationPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, DialogName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, LabelSuspect, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, LabelVehicle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, LabelDest, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AccussationPanelLayout.setVerticalGroup(
            AccussationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AccussationPanelLayout.createSequentialGroup()
                .add(12, 12, 12)
                .add(DialogName)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(LabelSuspect)
                .add(5, 5, 5)
                .add(SuspectPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(LabelVehicle)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(VehiclePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(LabelDest)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(DestinationPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(AccussationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ButtonCancel)
                    .add(ButtonSubmit)
                    .add(ButtonReset))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AccussationPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AccussationPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Initialized the arrays of buttons
     */
    private void makeArrayButton()
    {
        suspects = new javax.swing.JButton[6];
        suspects[0] = Suspect1;
        suspects[1] = Suspect2;
        suspects[2] = Suspect3;
        suspects[3] = Suspect4;
        suspects[4] = Suspect5;
        suspects[5] = Suspect6;

        vehicles = new javax.swing.JButton[6];
        vehicles[0] = Vehicle1;
        vehicles[1] = Vehicle2;
        vehicles[2] = Vehicle3;
        vehicles[3] = Vehicle4;
        vehicles[4] = Vehicle5;
        vehicles[5] = Vehicle6;

        destinations = new javax.swing.JButton[9];
        destinations[0] = Destination1;
        destinations[1] = Destination2;
        destinations[2] = Destination3;
        destinations[3] = Destination4;
        destinations[4] = Destination5;
        destinations[5] = Destination6;
        destinations[6] = Destination7;
        destinations[7] = Destination8;
        destinations[8] = Destination9;
    }

private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed

}//GEN-LAST:event_ButtonCancelActionPerformed

    /**
     * Action when submit button gets clicked. accusation is made to be confirmed
     *
     * @param evt submit button clicked
     */
private void ButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSubmitActionPerformed

}//GEN-LAST:event_ButtonSubmitActionPerformed

    /**
     * Action for Suspect Button 3. Selects that suspect and disables all other ones
     *
     * @param evt button clicked
     */
private void Suspect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suspect3ActionPerformed

}//GEN-LAST:event_Suspect3ActionPerformed

    /**
     * Action for Suspect Button 4. Selects that suspect and disables all other ones
     *
     * @param evt button clicked
     */
private void Suspect4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suspect4ActionPerformed

}//GEN-LAST:event_Suspect4ActionPerformed

    /**
     * Action for Suspect Button 5. Selects that suspect and disables all other ones
     *
     * @param evt button clicked
     */
private void Suspect5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suspect5ActionPerformed

}//GEN-LAST:event_Suspect5ActionPerformed

    /**
     * Action for Suspect Button 6. Selects that suspect and disables all other ones
     *
     * @param evt button clicked
     */
private void Suspect6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suspect6ActionPerformed

}//GEN-LAST:event_Suspect6ActionPerformed

    /**
     * Action for Vehicle Button 1. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle1ActionPerformed

}//GEN-LAST:event_Vehicle1ActionPerformed

    /**
     * Action for Vehicle Button 2. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle2ActionPerformed

}//GEN-LAST:event_Vehicle2ActionPerformed

    /**
     * Action for Vehicle Button 3. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle3ActionPerformed

}//GEN-LAST:event_Vehicle3ActionPerformed

    /**
     * Action for Vehicle Button 4. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle4ActionPerformed

}//GEN-LAST:event_Vehicle4ActionPerformed

    /**
     * Action for Vehicle Button 5. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle5ActionPerformed

}//GEN-LAST:event_Vehicle5ActionPerformed

    /**
     * Action for Vehicle Button 6. Selects that vehicle and disables all other ones
     *
     * @param evt button clicked
     */
private void Vehicle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vehicle6ActionPerformed

}//GEN-LAST:event_Vehicle6ActionPerformed

    /**
     * Action for Destination Button 1. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination1ActionPerformed

}//GEN-LAST:event_Destination1ActionPerformed

    /**
     * Action for Destination Button 2. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination2ActionPerformed

}//GEN-LAST:event_Destination2ActionPerformed

    /**
     * Action for Destination Button 3. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination3ActionPerformed

}//GEN-LAST:event_Destination3ActionPerformed

    /**
     * Action for Destination Button 4. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination4ActionPerformed

}//GEN-LAST:event_Destination4ActionPerformed

    /**
     * Action for Destination Button 5. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination5ActionPerformed

}//GEN-LAST:event_Destination5ActionPerformed

    /**
     * Action for Destination Button 6. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination6ActionPerformed

}//GEN-LAST:event_Destination6ActionPerformed

    /**
     * Action for Destination Button 7. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
private void Destination7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination7ActionPerformed

}//GEN-LAST:event_Destination7ActionPerformed

    /**
     * Action for reset button. Re-enables all other buttons
     *
     * @param evt button clicked
     */
private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed

}//GEN-LAST:event_ButtonResetActionPerformed

    /**
     * Action for Destination Button 8. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
    private void Destination8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination8ActionPerformed

    }//GEN-LAST:event_Destination8ActionPerformed

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
        return this.ButtonSubmit;
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
     * Action for Destination Button 9. Selects that destination and disables all other ones
     *
     * @param evt button clicked
     */
    private void Destination9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destination9ActionPerformed

    }//GEN-LAST:event_Destination9ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccussationPanel;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonSubmit;
    private javax.swing.JButton Destination1;
    private javax.swing.JButton Destination2;
    private javax.swing.JButton Destination3;
    private javax.swing.JButton Destination4;
    private javax.swing.JButton Destination5;
    private javax.swing.JButton Destination6;
    private javax.swing.JButton Destination7;
    private javax.swing.JButton Destination8;
    private javax.swing.JButton Destination9;
    private javax.swing.JPanel DestinationPanel;
    private javax.swing.JLabel DialogName;
    private javax.swing.JLabel LabelDest;
    private javax.swing.JLabel LabelSuspect;
    private javax.swing.JLabel LabelVehicle;
    private javax.swing.JButton Suspect1;
    private javax.swing.JButton Suspect2;
    private javax.swing.JButton Suspect3;
    private javax.swing.JButton Suspect4;
    private javax.swing.JButton Suspect5;
    private javax.swing.JButton Suspect6;
    private javax.swing.JPanel SuspectPanel;
    private javax.swing.JButton Vehicle1;
    private javax.swing.JButton Vehicle2;
    private javax.swing.JButton Vehicle3;
    private javax.swing.JButton Vehicle4;
    private javax.swing.JButton Vehicle5;
    private javax.swing.JButton Vehicle6;
    private javax.swing.JPanel VehiclePanel;
    // End of variables declaration//GEN-END:variables
}
