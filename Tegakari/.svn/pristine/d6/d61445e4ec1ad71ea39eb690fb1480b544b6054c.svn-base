package allguis;

import guiConsoleController.AccusationResultController;
import guiConsoleController.I_AccusationResult;
import tegakari.AccusationMessage;

/**
 * Window to show the result of an accusation
 *
 * @author Deion Law
 * @author Anh nguyen
 */
public class AccusationResult extends javax.swing.JDialog implements I_AccusationResult
{

    /**
     * Player that accused
     */
    private String accuser = "";
    /**
     * The accusation
     */
    private String accuse = "";
    /**
     * AccusationMessage containing all information of an accusation
     */
    private AccusationMessage accusation;
    /**
     * File path to the suspect image of the accusation
     */
    private String suspectPath;
    /**
     * File path to the vehicle image of the accusation
     */
    private String vehiclePath;
    /**
     * File path to the destination image of the accusation
     */
    private String destinationPath;
    /**
     * File path to the suspect of the Solution
     */
    private String suspectPath1;
    /**
     * File path to the vehicle of the Solution
     */
    private String vehiclePath1;
    /**
     * File path to the destination of the Solution
     */
    private String destinationPath1;
    /**
     * String of the solution
     */
    private String solution = "";
    /**
     * Result of the accusation
     */
    private String result = "";
    /**
     * True if player displaying this window is the turn player, ie the accuser
     */
    private boolean isTurnPlayer;
    /**
     * String if a player won or lost the game
     */
    private String out = "";

    /**
     * Form to display the result of an accusation
     *
     * @param parent the parent frame
     * @param modal modal setting for JDialog
     * @param accusation message holding accusation information
     * @param ctrl controller, eventHandler for AccusationResult
     */
    public AccusationResult(AccusationResultController ctrl, java.awt.Frame parent, boolean modal, AccusationMessage accusation)
    {
        super(parent, modal);
        this.setTitle("Tegakari");
        this.accusation = accusation;

        accuse = accusation.getAccusation().toString();
        suspectPath = accusation.getAccusation().getSuspect().getImagePath();
        vehiclePath = accusation.getAccusation().getVehicle().getImagePath();
        destinationPath = accusation.getAccusation().getDestination().getImagePath();

        suspectPath1 = accusation.getSolution().getSuspect().getImagePath();
        vehiclePath1 = accusation.getSolution().getVehicle().getImagePath();
        destinationPath1 = accusation.getSolution().getDestination().getImagePath();

        isTurnPlayer = accusation.getCreator().getName().equals(accusation.getShowTo().getName());
        accuser = isTurnPlayer ? "Your accusation:" : (accusation.getCreator().getName() + " accuses:");
        result = accusation.isCorrect()
                ? " Which matches the correct solution" : " Which does not match the correct solution";
        out = (isTurnPlayer ? "You" : accusation.getCreator().getName()) + (accusation.isCorrect() ? " WIN The Game " : " Lost The Game");

        initComponents();
        this.setLocationRelativeTo(null);
        
        this.okButton.setActionCommand("OK");
        this.okButton.addActionListener(ctrl);
        this.okButton.addKeyListener(ctrl);
        
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
        
        setNames();
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    private void setNames()
    {
        accusationText.setName("accusationText");
        jLabel1.setName("accusationResult");
        jLabel2.setName("acSuspect");
        jLabel3.setName("acVehicle");
        jLabel4.setName("acDestination");
        jLabel5.setName("soSuspect");
        jLabel6.setName("soVehicle");
        jLabel7.setName("soDestination");
        jPanel1.setName("panel1");
        jPanel2.setName("panel2");
        okButton.setName("okButton");
        outcomeText.setName("outcomeText");
        playerAccusesText.setName("playerAccusesText");
        resultPrefixText.setName("resultPrefixText");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerAccusesText = new javax.swing.JLabel();
        accusationText = new javax.swing.JLabel();
        resultPrefixText = new javax.swing.JLabel();
        outcomeText = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        playerAccusesText.setText(accuser);

        accusationText.setText(accuse);

        resultPrefixText.setText(result);

        outcomeText.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        outcomeText.setText(out);

        okButton.setText("OK (SPACE)");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        jLabel1.setText("Accusation Result");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(suspectPath)));
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(vehiclePath)));
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel3);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(destinationPath)));
        jLabel4.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel4);

        if (isTurnPlayer || accusation.isCorrect()) {
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(suspectPath1)));
        }
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel2.add(jLabel5);

        if (isTurnPlayer || accusation.isCorrect()) {
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource(vehiclePath1)));
        }
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel2.add(jLabel6);

        if (isTurnPlayer || accusation.isCorrect()){
            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(destinationPath1)));
        }
        jLabel7.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel2.add(jLabel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerAccusesText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accusationText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outcomeText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultPrefixText)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(playerAccusesText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accusationText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(resultPrefixText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outcomeText)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void dispose()
    {
        this.setVisible(false);
    }
    
    /**
     * Event for OK button. Closes window
     *
     * @param evt button clicked
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accusationText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel outcomeText;
    private javax.swing.JLabel playerAccusesText;
    private javax.swing.JLabel resultPrefixText;
    // End of variables declaration//GEN-END:variables
}
