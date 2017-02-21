package allguis;

import guiConsoleController.I_SleuthOnMeDialog;
import guiConsoleController.SleuthOnMeDialogController;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import tegakari.SuperSleuthCard;
import tegakari.ClueCard;
import tegakari.Player;

/**
 * Window to show when user is able to respond to a Sleuth Card
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class SleuthOnMeDialog extends javax.swing.JDialog implements I_SleuthOnMeDialog
{

    /**
     * File path for the sleuth card
     */
    private String actionPath = "";
    /**
     * Name of the player that played the Sleuth Card
     */
    private String playerName = "";
    /**
     * Clue Card to show
     */
    private ClueCard toReturn;
    /**
     * List of clue cards that user can use to respond
     */
    private List<ClueCard> clues;
    private SleuthOnMeDialogController ctrl;

    /**
     * Form of the response window to a Sleuth Card
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param sleuthCard the Sleuth Card used
     * @param clues the list of clue cards that the user is able to respond with
     * @param ctrl controller, eventHandler for SleuthOnMeDialog
     * @param playerName name of the player
     */
    public SleuthOnMeDialog(SleuthOnMeDialogController ctrl, JFrame parent, 
            boolean modal, SuperSleuthCard sleuthCard, List<ClueCard> clues, String playerName)
    {
        super(parent, modal);
        this.setTitle("Tegakari");
        this.clues = clues;
        toReturn = clues.get(0);

        actionPath = sleuthCard.getImagePath();
        this.playerName = playerName;

        if (clues.size() > 0)
        {
            toReturn = clues.get(0);
        }
        initComponents();
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        String path = "/image/ClueBack.jpg";

        String imagePath1 = clues.get(0).getImagePath();

        JButton[] tempArray =
        {
            clue1, clue2, clue3, clue4, clue5, clue6
        };

        //FOR each valid clue card to respond with
        for (int i = 0; i < clues.size(); i++)
        {
            tempArray[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(clues.get(i).getImagePath())));
            tempArray[i].setEnabled(true);
        }
        //ENDFOR
        
        if (clues.size() == 1)
        {
            OkButton.setEnabled(true);
        }
        
        //FOR the remaining labels
        for (int size = clues.size(); size < 6; size++)
        {
            tempArray[size].setIcon(new javax.swing.ImageIcon(getClass().getResource(path)));
            tempArray[size].setEnabled(false);
        }
        //ENDFOR

        this.setLocationRelativeTo(null);
        
        
        
        OkButton.addActionListener(ctrl);
        OkButton.setActionCommand("OK");
        OkButton.addKeyListener(ctrl);
        
        clue1.setActionCommand("1");
        clue1.addActionListener(ctrl);
        clue1.addKeyListener(ctrl);
        clue2.setActionCommand("2");
        clue2.addActionListener(ctrl);
        clue2.addKeyListener(ctrl);
        clue3.setActionCommand("3");
        clue3.addActionListener(ctrl);
        clue3.addKeyListener(ctrl);
        clue4.setActionCommand("4");
        clue4.addActionListener(ctrl);
        clue4.addKeyListener(ctrl);
        clue5.setActionCommand("5");
        clue5.addActionListener(ctrl);
        clue5.addKeyListener(ctrl);
        clue6.setActionCommand("5");
        clue6.addActionListener(ctrl);
        clue6.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }

    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        clue1 = new javax.swing.JButton();
        clue2 = new javax.swing.JButton();
        clue3 = new javax.swing.JButton();
        clue4 = new javax.swing.JButton();
        clue5 = new javax.swing.JButton();
        clue6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setText("Super Sleuth");

        jLabel2.setText(playerName + " played this Super Sleuth.");
        jLabel2.setName("fromText"); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(actionPath)));
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 100));

        OkButton.setText("OK (SPACE)");
        OkButton.setName("okButton"); // NOI18N
        OkButton.setEnabled(false);
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        clue1.setName("clue1"); // NOI18N
        clue1.setPreferredSize(new java.awt.Dimension(70, 100));
        clue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue1ActionPerformed(evt);
            }
        });
        jPanel2.add(clue1);

        clue2.setName("card2"); // NOI18N
        clue2.setPreferredSize(new java.awt.Dimension(70, 100));
        clue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue2ActionPerformed(evt);
            }
        });
        jPanel2.add(clue2);

        clue3.setName("card3"); // NOI18N
        clue3.setPreferredSize(new java.awt.Dimension(70, 100));
        clue3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue3ActionPerformed(evt);
            }
        });
        jPanel2.add(clue3);

        clue4.setName("card4"); // NOI18N
        clue4.setPreferredSize(new java.awt.Dimension(70, 100));
        clue4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue4ActionPerformed(evt);
            }
        });
        jPanel2.add(clue4);

        clue5.setToolTipText("");
        clue5.setName("card5"); // NOI18N
        clue5.setPreferredSize(new java.awt.Dimension(70, 100));
        clue5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue5ActionPerformed(evt);
            }
        });
        jPanel2.add(clue5);

        clue6.setToolTipText("");
        clue6.setName("card5"); // NOI18N
        clue6.setPreferredSize(new java.awt.Dimension(70, 100));
        clue6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue6ActionPerformed(evt);
            }
        });
        jPanel2.add(clue6);

        jLabel4.setText("Choose a card to show, or Click 1-6");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel4))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(OkButton)
                .add(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jLabel1)
                .add(14, 14, 14)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(OkButton)
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
     * Disables all buttons
     */
    public void setOff()
    {
        clue1.setEnabled(false);
        clue2.setEnabled(false);
        clue3.setEnabled(false);
        clue4.setEnabled(false);
        clue5.setEnabled(false);
        clue6.setEnabled(false);
    }
    
    public void setEnabledButton(String cmd)
    {
        if (cmd.equals("1"))
        {
            clue1.setEnabled(true);
        }
        else if (cmd.equals("2"))
        {
            clue2.setEnabled(true);
        }
        else if (cmd.equals("3"))
        {
            clue3.setEnabled(true);
        }
        else if (cmd.equals("4"))
        {
            clue4.setEnabled(true);
        }
        else if (cmd.equals("5"))
        {
            clue5.setEnabled(true);
        }
        else
        {
            clue6.setEnabled(true);
        }
    }
    
    public void setEnabledOK()
    {
        OkButton.setEnabled(true);
    }
    
    /**
     * Action for OK button. Closes window
     *
     * @param evt button pressed
     */
    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed

    }//GEN-LAST:event_OkButtonActionPerformed

    /**
     * method for controller to use when pressing "OK"
     */
    public void dispose()
    {
        this.setVisible(false);
    }
    
    /**
     * Action for selecting clue 1. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void clue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue1ActionPerformed

    }//GEN-LAST:event_clue1ActionPerformed

    /**
     * Action for selecting clue 2. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void clue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue2ActionPerformed
        
    }//GEN-LAST:event_clue2ActionPerformed

    /**
     * Action for selecting clue 3. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void clue3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue3ActionPerformed
        
    }//GEN-LAST:event_clue3ActionPerformed

    /**
     * Action for selecting clue 4. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void clue4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue4ActionPerformed

    }//GEN-LAST:event_clue4ActionPerformed

    /**
     * Action for selecting clue 5. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void clue5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue5ActionPerformed

    }//GEN-LAST:event_clue5ActionPerformed

    private void clue6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clue6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkButton;
    private javax.swing.JButton clue1;
    private javax.swing.JButton clue2;
    private javax.swing.JButton clue3;
    private javax.swing.JButton clue4;
    private javax.swing.JButton clue5;
    private javax.swing.JButton clue6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
