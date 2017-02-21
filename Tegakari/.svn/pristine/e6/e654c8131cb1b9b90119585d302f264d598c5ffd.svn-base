package allguis;

import guiConsoleController.ReplayController;
import guiConsoleController.I_Replay;
import java.awt.event.ActionEvent;

/**
 * Window to query if user wants to replay the game after it is over
 *
 * @author anhnguyen
 */
public class ReplayGame extends javax.swing.JDialog implements I_Replay
{

    /**
     * True if user wants to replay game
     */
    private boolean result;
    
    private ReplayController controller;

    /**
     * Creates new form ReplayGame window
     *
     * @param parent the parent frame, GameTable
     * @param modal modal setting for JDialog
     */
    public ReplayGame(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        jLabel1.setText("<HTML>Game Over<br>Play Again?</HTML>");
        jLabel1.setName("titleText"); // NOI18N

        yesButton.setText("(Y)es");
        yesButton.setName("yesButton"); // NOI18N
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.setText("(N)o");
        noButton.setName("noButton"); // NOI18N
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(71, 71, 71)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(yesButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(noButton))
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(yesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(noButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Return the option chosen to replay
     *
     * @return True if user wants to replay
     */
    public boolean showDialog()
    {
        return result;
    }
    
    public void setController(ReplayController controller)
    {
        this.controller = controller;
        
        noButton.addActionListener(controller);
        noButton.addKeyListener(controller);
        noButton.setActionCommand("no");
        
        yesButton.addActionListener(controller);
        yesButton.addKeyListener(controller);
        yesButton.setActionCommand("replay");
        
        this.setFocusable(true);
        this.addKeyListener(controller);
    }
    
    public void noReplay()
    {
        result = false;
        dispose();
    }
    
    public void yesReplay()
    {
        result = true;
        dispose();
    }
    /**
     * Action for the no button. Close and restarts game
     *
     * @param evt button pressed
     */
    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed

    }//GEN-LAST:event_noButtonActionPerformed

    /**
     * Action for the yes button. Closes and restarts game
     *
     * @param evt button pressed
     */
    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed

    }//GEN-LAST:event_yesButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton noButton;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
