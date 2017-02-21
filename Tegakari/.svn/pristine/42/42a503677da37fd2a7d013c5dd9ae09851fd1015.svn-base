package allguis;

import guiConsoleController.I_Disprove;
import guiConsoleController.DisproveController;
import java.util.List;
import tegakari.ClueCard;
import tegakari.DestinationCard;
import tegakari.Player;
import tegakari.SuggestionCardLogic;
import tegakari.SuspectCard;
import tegakari.VehicleCard;

/**
 * Window shown for disproving an suggestion
 *
 * @author DeionLaw
 */
public class Disprove extends javax.swing.JDialog implements I_Disprove
{

    /**
     * Clue Card chosen to disprove with
     */
    private ClueCard result;
    /**
     * Information of the suggestion card played
     */
    private SuggestionCardLogic logic;
    /**
     * List if clue cards that player can use to disprove
     */
    private List<ClueCard> listClueCard;
    /**
     * Player that made a suggestion
     */
    private Player from;
    /**
     * File path to the suspect of the suggestion
     */
    private String pathSuspect = "";
    /**
     * File path to the vehicle of the suggestion
     */
    private String pathVehicle = "";
    /**
     * File path to the destination of the suggestion
     */
    private String pathDestination = "";
    /**
     * True if player is able to disprove the suspect
     */
    private boolean hasSuspect = false;
    /**
     * True if player is able to disprove the vehicle
     */
    private boolean hasVehicle = false;
    /**
     * True if player is able to disprove the destination
     */
    private boolean hasDestination = false;

    private DisproveController ctrl;
    
    /**
     * Creates new form Disprove
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param logic information about the suggestion
     * @param list cards that can be used to disprove
     * @param ctrl controller, eventHandler for Disprove
     */
    public Disprove(DisproveController ctrl, java.awt.Frame parent, boolean modal, SuggestionCardLogic logic, List<ClueCard> list)
    {
        super(parent, modal);
        this.ctrl = ctrl;
        this.setTitle("Tegakari");
        result = list.get(0);
        this.logic = logic;
        listClueCard = list;
        from = logic.getTurnPlayer();
        pathSuspect = logic.getGuess().getSuspect().getImagePath();
        pathVehicle = logic.getGuess().getVehicle().getImagePath();
        pathDestination = logic.getGuess().getDestination().getImagePath();
        for (ClueCard card : list)
        {
            //System.out.print("Card: " + card.getName());
            if (card instanceof SuspectCard)
            {
                //System.out.println(" is Suspect: " + card.getImagePath());
                hasSuspect = true;
            }
            else if (card instanceof VehicleCard)
            {
                hasVehicle = true;
                //System.out.println(" is Vehicle: " + card.getImagePath());
            }
            else if (card instanceof DestinationCard)
            {
                hasDestination = true;
                //System.out.println(" is Destination: " + card.getImagePath());
            }
        }
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Set OK available if only 1 card is available.
        if (list.size() == 1)
        {
            okButton.setEnabled(true);
            resetButton.setEnabled(false);
        }
        
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
        setNames();
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    private void setNames()
    {
        DestinationButton.setActionCommand("DestinationButton");
        DestinationButton.setName("DestinationButton");
        DestinationButton.addActionListener(ctrl);
        DestinationButton.addKeyListener(ctrl);
        cardButtonPanel.setName("cardButtonPanel");
        jLabel1.setName("jLabel1");
        okButton.setActionCommand("okButton");
        okButton.setName("okButton");
        okButton.addActionListener(ctrl);
        okButton.addKeyListener(ctrl);
        playerSuggestsText.setName("playerSuggestsText");
        resetButton.setActionCommand("resetButton");
        resetButton.setName("resetButton");
        resetButton.addActionListener(ctrl);
        resetButton.addKeyListener(ctrl);
        selectText.setName("selectText");
        suggestionText.setName("suggestionText");
        suspectButton.setActionCommand("suspectButton");
        suspectButton.setName("suspectButton");
        suspectButton.addActionListener(ctrl);
        suspectButton.addKeyListener(ctrl);
        vehicleButton.setActionCommand("vehicleButton");
        vehicleButton.setName("vehicleButton");
        vehicleButton.addActionListener(ctrl);
        vehicleButton.addKeyListener(ctrl);
    }
    
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        selectText = new javax.swing.JLabel();
        cardButtonPanel = new javax.swing.JPanel();
        DestinationButton = new javax.swing.JButton();
        vehicleButton = new javax.swing.JButton();
        suspectButton = new javax.swing.JButton();
        playerSuggestsText = new javax.swing.JLabel();
        suggestionText = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Disprove:");

        okButton.setText("OK (SPACE)");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        selectText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectText.setText("Click on a card below or use Keyboard S: Suspect V: Vehicle D: Destination to disprove");

        DestinationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathDestination)));
        DestinationButton.setEnabled(hasDestination);
        DestinationButton.setPreferredSize(new java.awt.Dimension(70, 100));
        DestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationButtonActionPerformed(evt);
            }
        });

        vehicleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathVehicle)));
        vehicleButton.setEnabled(hasVehicle);
        vehicleButton.setPreferredSize(new java.awt.Dimension(70, 100));
        vehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleButtonActionPerformed(evt);
            }
        });

        suspectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathSuspect)));
        suspectButton.setEnabled(hasSuspect);
        suspectButton.setPreferredSize(new java.awt.Dimension(70, 100));
        suspectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardButtonPanelLayout = new javax.swing.GroupLayout(cardButtonPanel);
        cardButtonPanel.setLayout(cardButtonPanelLayout);
        cardButtonPanelLayout.setHorizontalGroup(
            cardButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardButtonPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(suspectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DestinationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardButtonPanelLayout.setVerticalGroup(
            cardButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(suspectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(DestinationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        playerSuggestsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerSuggestsText.setText(logic.getTurnPlayer().getName() + " suggests:");

        suggestionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suggestionText.setText(logic.getGuess().toString());

        resetButton.setText("(R)eset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addContainerGap())
            .addComponent(cardButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(playerSuggestsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(suggestionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(playerSuggestsText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suggestionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(resetButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action for OK button. Closes window.
     *
     * @param evt button pressed
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
    }//GEN-LAST:event_okButtonActionPerformed

    public void dispose()
    {
        this.setVisible(false);
    }
    
    /**
     * Action for suspect button. Selects the suspect card and disables vehicle and destination
     *
     * @param evt button pressed
     */
    private void suspectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspectButtonActionPerformed

        
    }//GEN-LAST:event_suspectButtonActionPerformed

    /**
     * Action for vehicle button. Selects vehicle card and disables suspect and destination
     *
     * @param evt button pressed
     */
    private void vehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleButtonActionPerformed

        
    }//GEN-LAST:event_vehicleButtonActionPerformed

    /**
     * Action for destination button. Selects destination card and disables suspect and vehicle
     *
     * @param evt button pressed
     */
    private void DestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationButtonActionPerformed

        
    }//GEN-LAST:event_DestinationButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_resetButtonActionPerformed
    {//GEN-HEADEREND:event_resetButtonActionPerformed
        
    }//GEN-LAST:event_resetButtonActionPerformed

    public void setEnabled(String choice, boolean set)
    {
        if (choice.equals("destination"))
        {
            DestinationButton.setEnabled(set);
        }
        else if (choice.equals("suspect"))
        {
            suspectButton.setEnabled(set);
        }
        else if (choice.equals("vehicle"))
        {
            vehicleButton.setEnabled(set);
        }
        else
        {
            okButton.setEnabled(set);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DestinationButton;
    private javax.swing.JPanel cardButtonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel playerSuggestsText;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel selectText;
    private javax.swing.JLabel suggestionText;
    private javax.swing.JButton suspectButton;
    private javax.swing.JButton vehicleButton;
    // End of variables declaration//GEN-END:variables
}
