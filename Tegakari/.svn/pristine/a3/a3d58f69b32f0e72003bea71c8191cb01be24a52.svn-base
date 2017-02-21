package allguis;

import guiConsoleController.I_AccusationConfirm;
import guiConsoleController.AccusationConfirmController;
import tegakari.Solution;

/**
 * The GUI to confirm an accusation to be made.
 * 
 * @author Deion Law
 * @author Anh Nguyen
 *
 * @version 11/30/15 change source path
 */
public class AccusationConfirm extends javax.swing.JDialog implements I_AccusationConfirm
{

    /**
     * The suspect, vehicle, and destination of the accusation
     */
    private Solution accusation;
    /**
     * Boolean on whether or not the user confirms.
     */
    private boolean result = false;

    /**
     * Creates new form AccusationConfirm
     *
     * @param ctrl the controller for this class
     * @param parent the parent frame
     * @param modal setting to block clicking on other windows
     * @param accusation the accusation selected
     */
    public AccusationConfirm(AccusationConfirmController ctrl, 
            java.awt.Frame parent, boolean modal, Solution accusation)
    {
        super(parent, modal);
        this.setTitle("Tegakari");
        this.accusation = accusation;
        initComponents();
        this.setLocationRelativeTo(null);
        accusationText.setText("Accuse " + accusation.getSuspect().getName()
                + " in a " + accusation.getVehicle().getName() + " at "
                + accusation.getDestination().getName());
        
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
        cancelButton.setActionCommand("n");
        cancelButton.setName("cancelButton");
        cancelButton.addActionListener(ctrl);
        cancelButton.addKeyListener(ctrl);
        okButton.setName("okButton");
        okButton.setActionCommand("y");
        okButton.addActionListener(ctrl);
        okButton.addKeyListener(ctrl);
        accusationText.setName("accusationText");
        prefixPromtText.setName("prefixPromtText");
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }

    /**
     * NetBeans made code for Swing
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        prefixPromtText = new javax.swing.JLabel();
        accusationText = new javax.swing.JLabel();
        warningText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vehicle = new javax.swing.JLabel();
        suspect = new javax.swing.JLabel();
        destination = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("OK(SPACE)");

        cancelButton.setText("(C)ancel");

        prefixPromtText.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        prefixPromtText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prefixPromtText.setText("Are you sure you want to:");

        accusationText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accusationText.setText("<Accustation here>");

        warningText.setForeground(new java.awt.Color(204, 0, 0));
        warningText.setText("<HTML>Attention !!!<br>Failing an accusation will disable you from playing<br>action cards and making further accusations.<HTML>");

        vehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource(accusation.getVehicle().getImagePath())));
        vehicle.setPreferredSize(new java.awt.Dimension(70, 100));

        suspect.setIcon(new javax.swing.ImageIcon(getClass().getResource(accusation.getSuspect().getImagePath())));
        suspect.setPreferredSize(new java.awt.Dimension(70, 100));

        destination.setIcon(new javax.swing.ImageIcon(getClass().getResource(accusation.getDestination().getImagePath())));
        destination.setPreferredSize(new java.awt.Dimension(70, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(suspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prefixPromtText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(accusationText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(warningText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(prefixPromtText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accusationText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(warningText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Dispose this GUI view.
     */
    public void disposeView()
    {
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accusationText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel destination;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel prefixPromtText;
    private javax.swing.JLabel suspect;
    private javax.swing.JLabel vehicle;
    private javax.swing.JLabel warningText;
    // End of variables declaration//GEN-END:variables
}
