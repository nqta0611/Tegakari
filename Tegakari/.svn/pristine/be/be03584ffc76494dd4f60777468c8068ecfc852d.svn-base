package allguis;

import guiConsoleController.SnoopOnMeDialogController;
import guiConsoleController.I_SnoopOnMeDialog;
import javax.swing.ImageIcon;
import tegakari.CardMessage;
import tegakari.ClueCard;

/**
 * Window to inform that the user got snooped on
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class SnoopOnMeDialog extends javax.swing.JDialog implements I_SnoopOnMeDialog
{

    /**
     * Form for SnoopOnMe window
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param cardReceived card that was shown
     * @param ctrl controller, eventHandler for SnoopOnMeDialog
     */
    public SnoopOnMeDialog(SnoopOnMeDialogController ctrl, java.awt.Frame parent, 
            boolean modal, CardMessage cardReceived)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        snoopText.setText(cardReceived.getFromPlayer().getName() 
                + " snooped on me and saw:");
        snoopText.setName("snoopText");
        card.setIcon(new ImageIcon(getClass().getResource(
                ((ClueCard) cardReceived.getCards().get(0)).getImagePath())));
        this.setLocationRelativeTo(null);
        // set names to button
        okButton.setName("ok");
        
        okButton.setActionCommand("ok");
        okButton.addActionListener(ctrl);
        okButton.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    /**
     * make this window hidden
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
        title = new javax.swing.JLabel();
        snoopText = new javax.swing.JLabel();
        card = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Snoop On Me");

        snoopText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        card.setName("card"); // NOI18N
        card.setPreferredSize(new java.awt.Dimension(70, 100));

        okButton.setText("OK (SPACE)");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, snoopText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(okButton)
                                .addContainerGap())
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(card, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(147, 147, 147))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(title)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(snoopText)
                .add(26, 26, 26)
                .add(card, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(23, 23, 23)
                .add(okButton)
                .addContainerGap(22, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel card;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel snoopText;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
