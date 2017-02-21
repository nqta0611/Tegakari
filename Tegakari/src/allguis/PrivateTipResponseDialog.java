package allguis;

import guiConsoleController.PrivateTipResponseController;
import guiConsoleController.I_PrivateTipResponse;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tegakari.ClueCard;
import tegakari.Player;
import tegakari.PrivateTipCardLogic;

/**
 * Window for response to a Private Tip played
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class PrivateTipResponseDialog extends javax.swing.JDialog implements I_PrivateTipResponse
{

    /**
     * list of clue cards to be shown
     */
    private List<ClueCard> clues;
    /**
     * array of labels for clue cards to use to display
     */
    private JLabel[] clueLabels;

    /**
     * Form for the window to be shown after playing private tip
     *
     * @param parent the parent frame, GameTable
     * @param modal the modal setting for JDialog
     * @param clues the list of clue cards to be shown
     * @param logic the information on the private tip played
     * @param ctrl controller, eventHandler for PrivateTipResponseDialog
     */
    public PrivateTipResponseDialog(PrivateTipResponseController ctrl, java.awt.Frame parent, boolean modal, List<ClueCard> clues, PrivateTipCardLogic logic)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.clues = clues;
        JLabel[] tempArray =
        {
            clue1, clue2, clue3, clue4
        };
        clueLabels = tempArray;

        //show Clue Cards
        for (int clue = 0; clue < clues.size(); clue++)
        {
            clueLabels[clue].setIcon(new ImageIcon(getClass().getResource(clues.get(clue).getImagePath())));
        }

        //set Text
        if (clues.isEmpty())
        {
            showsYouText.setText(logic.getTargetPlayer().getName() + " has no cards to show you.");
        }
        else
        {
            showsYouText.setText(logic.getTargetPlayer().getName() + " shows you:");
        }
        okButton.addActionListener(ctrl);
        okButton.setActionCommand("OK");
        okButton.addKeyListener(ctrl);
        
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
        title = new javax.swing.JLabel();
        showsYouText = new javax.swing.JLabel();
        clue1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        clue2 = new javax.swing.JLabel();
        clue4 = new javax.swing.JLabel();
        clue3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Private Tip Response");
        title.setName("titleText"); // NOI18N

        showsYouText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showsYouText.setText("Player2 - comp_1 shows you these clues");
        showsYouText.setName("descText"); // NOI18N

        clue1.setPreferredSize(new java.awt.Dimension(70, 100));

        okButton.setText("<HTML><U>O</U>K<HTNML>");
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        clue2.setPreferredSize(new java.awt.Dimension(70, 100));

        clue4.setPreferredSize(new java.awt.Dimension(70, 100));

        clue3.setPreferredSize(new java.awt.Dimension(70, 100));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(showsYouText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .add(45, 45, 45)
                .add(clue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(29, 29, 29)
                .add(clue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(clue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32)
                .add(clue4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(29, 29, 29)
                .add(title)
                .add(18, 18, 18)
                .add(showsYouText)
                .add(54, 54, 54)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(clue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 47, Short.MAX_VALUE)
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
     * Dispose all resources of this object.
     */
    public void dispose()
    {
        this.setVisible(false);
    }
    
    /**
     * Action for OK button. Closes window
     *
     * @param evt button pressed
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clue1;
    private javax.swing.JLabel clue2;
    private javax.swing.JLabel clue3;
    private javax.swing.JLabel clue4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel showsYouText;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
