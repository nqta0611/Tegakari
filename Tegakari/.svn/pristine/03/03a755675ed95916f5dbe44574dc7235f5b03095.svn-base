package allguis;

import guiConsoleController.I_NoOneDisprove;
import guiConsoleController.NoOneDisproveController;
import tegakari.Solution;

/**
 * Window for a suggestion that cannot be disproven
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class NoOneDisproveDialog extends javax.swing.JDialog implements I_NoOneDisprove
{

    /**
     * File path to the image of the suspect in the suggestion
     */
    private String pathSuspect = "";
    /**
     * File path to the image of the vehicle of the suggestion
     */
    private String pathVehicle = "";
    /**
     * File path to the image of the destination of the suggestion
     */
    private String pathDestination = "";
    /**
     * String representation of the suggestion
     */
    private String guess = "";
    /**
     * Controller for this view
     */
    private NoOneDisproveController ctrl;

    /**
     * Creates new form NoOneDisproveDialog
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param guess the suggestion
     * @param ctrl controller, eventHandler for NoOneDisproveDialog
     */
    public NoOneDisproveDialog(java.awt.Frame parent, boolean modal, 
            Solution guess, NoOneDisproveController ctrl)
    {

        super(parent, modal);
        this.setTitle("Tegakari");
        this.guess = guess.toString();
        pathSuspect = guess.getSuspect().getImagePath();
        pathVehicle = guess.getVehicle().getImagePath();
        pathDestination = guess.getDestination().getImagePath();

        this.ctrl = ctrl;
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.okButton.addActionListener(ctrl);
        this.okButton.setActionCommand("OK");
        this.okButton.addKeyListener(ctrl);
    }

    /**
     * method for controller to use when pressing "OK"
     */
    public void dispose()
    {
        this.setVisible(false);
    }
    
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathSuspect)));
        jButton3.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jButton3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathVehicle)));
        jButton1.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathDestination)));
        jButton2.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jButton2);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 22)); // NOI18N
        jLabel1.setText("Suggestion Result");
        jLabel1.setName("titleText"); // NOI18N

        jLabel2.setText("No one can disprove you suggestion.");
        jLabel2.setName("descText"); // NOI18N

        jLabel3.setText(guess.toString());

        okButton.setText("OK (SPACE)");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jLabel1)
                .add(154, 154, 154))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(119, 119, 119)
                        .add(jLabel2))
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(jLabel3)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(okButton)
                        .add(33, 33, 33))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(131, 131, 131))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2)
                .add(55, 55, 55)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(okButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action for OK button. Closes window
     *
     * @param evt button pressed
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
