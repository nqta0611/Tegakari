package allguis;

import guiConsoleController.I_PrivateTipToDialog;
import guiConsoleController.PrivateTipToDialogController;
import java.util.List;
import javax.swing.JButton;
import tegakari.Player;

/**
 * Window to select who to play a private tip on
 *
 * @author anhnguyen
 */
public class PrivateTipToDialog extends javax.swing.JDialog implements I_PrivateTipToDialog
{

    /**
     * The player chosen to play the private tip on
     */
    private Player chosenPlayer;
    /**
     * Array of buttons for each player
     */
    private JButton[] playerButtons;
    /**
     * The list of players not including the user
     */
    private List<Player> players;
    /**
     * True if user choose a player
     */
    private boolean hasChosenPlayer;

    /**
     * Form for the window to show to select the player to play a private tip on
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param players list of players not including self
     * @param ctrl controller, eventHandler for PrivateTipToDialog
     */
    public PrivateTipToDialog(PrivateTipToDialogController ctrl, java.awt.Frame parent, boolean modal, List<Player> players)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.chosenPlayer = players.get(0);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.players = players;
        hasChosenPlayer = false;
        JButton[] tempArray =
        {
            seatButton1, seatButton2, seatButton3, seatButton4
        };
        
        playerButtons = tempArray;
        
        for (JButton buttonDex : tempArray)
        {
            buttonDex.setEnabled(false);
            buttonDex.setVisible(false);
        }
        
        // Set the text for the buttons to the names of the possible target players
        for (int player = 0; player < players.size(); player++)
        {
            playerButtons[player].setText(players.get(player).getName());
            playerButtons[player].setEnabled(true);
            playerButtons[player].setVisible(true);
        }
        okButton.setEnabled(false);
        
        okButton.addActionListener(ctrl);
        okButton.setActionCommand("OK");
        okButton.addKeyListener(ctrl);
        
        seatButton1.setActionCommand("1");
        seatButton1.addActionListener(ctrl);
        seatButton1.addKeyListener(ctrl);
        seatButton2.setActionCommand("2");
        seatButton2.addActionListener(ctrl);
        seatButton2.addKeyListener(ctrl);
        seatButton3.setActionCommand("3");
        seatButton3.addActionListener(ctrl);
        seatButton3.addKeyListener(ctrl);
        seatButton4.setActionCommand("4");
        seatButton4.addActionListener(ctrl);
        seatButton4.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    /**
     * Gets the seat button.
     * @param num seat number for button.
     * @return button for seat number.
     */
    public JButton getSeat(int num)
    {
        return playerButtons[num-1];
    }
    
    /**
     * Gets the okButton.
     * @return okButton.
     */
    public JButton getOkButton()
    {
        return okButton;
    }

    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        DialogName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        seatButton3 = new javax.swing.JButton();
        seatButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        seatButton1 = new javax.swing.JButton();
        seatButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("<HTML><U>O</U>K<HTNML>");
        okButton.setName("okButton"); // NOI18N
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        DialogName.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        DialogName.setText("Private Tip ");
        DialogName.setName("titleText"); // NOI18N

        seatButton3.setText("Bob");
        seatButton3.setName("player3"); // NOI18N
        seatButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatButton3ActionPerformed(evt);
            }
        });

        seatButton4.setText("p4");
        seatButton4.setName("player4"); // NOI18N
        seatButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(seatButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(seatButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(seatButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(seatButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Hand Private Tip card to, or click (1234)");
        jLabel2.setName("descText"); // NOI18N

        seatButton1.setText("comp_1");
        seatButton1.setName("player1"); // NOI18N
        seatButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatButton1ActionPerformed(evt);
            }
        });

        seatButton2.setText("<('u)");
        seatButton2.setName("player2"); // NOI18N
        seatButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(seatButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(seatButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(213, 213, 213)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(DialogName))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(DialogName)
                .add(30, 30, 30)
                .add(jLabel2)
                .add(28, 28, 28)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(seatButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(seatButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 74, Short.MAX_VALUE)
                .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Return the player chosen to play the private tip on
     */
    public void disableAll()
    {
        for (JButton button : playerButtons)
        {
            button.setEnabled(false);
        }
    }
    public void setOK(boolean set)
    {
         okButton.setEnabled(set);
    }
    public void setButton(int seat, boolean set)
    {
        playerButtons[seat].setEnabled(set);
    }
    
    public void eraseWindow()
    {
        this.setVisible(false);
    }

    /**
     * Action for the OK button. Closes window if player selected
     *
     * @param evt button pressed
     */
private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

}//GEN-LAST:event_okButtonActionPerformed

    /**
     * Action for seat button 1. Selects that player and disables all other ones
     *
     * @param evt button pressed
     */
    private void seatButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatButton1ActionPerformed

    }//GEN-LAST:event_seatButton1ActionPerformed

    /**
     * Action for seat button 2. Selects that player and disables all other ones
     *
     * @param evt button pressed
     */
    private void seatButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatButton2ActionPerformed

    }//GEN-LAST:event_seatButton2ActionPerformed

    /**
     * Action for seat button 3. Selects that player and disables all other ones
     *
     * @param evt button pressed
     */
    private void seatButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatButton3ActionPerformed

    }//GEN-LAST:event_seatButton3ActionPerformed

    private void seatButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DialogName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton seatButton1;
    private javax.swing.JButton seatButton2;
    private javax.swing.JButton seatButton3;
    private javax.swing.JButton seatButton4;
    // End of variables declaration//GEN-END:variables
}
