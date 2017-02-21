package allguis;

import guiConsoleController.I_ShowCardDialog;
import guiConsoleController.ShowCardDialogController;
import java.util.List;
import javax.swing.ImageIcon;
import tegakari.CardMessage;
import tegakari.ClueCard;

/**
 *
 * @author Deion Law
 * @author Anh nguyen
 * @version 11/30/15 modify source path
 */
public class ShowCardDialog extends javax.swing.JDialog implements I_ShowCardDialog
{

    /**
     * Window for showing a clue card
     *
     * @param parent the parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param recievedCardList list of cards to show
     * @param ctrl controller, eventHandler for ShowCardDialog
     */
    public ShowCardDialog(ShowCardDialogController ctrl, java.awt.Frame parent, 
            boolean modal, List<CardMessage> recievedCardList)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        playerHasText.setText(recievedCardList.get(0).getFromPlayer().getName() + " has:");
        showCardImage.setIcon(new ImageIcon(getClass().getResource(((ClueCard) recievedCardList.get(0).getCards().get(0)).getImagePath())));
        this.okButton.addActionListener(ctrl);
        this.okButton.setActionCommand("OK");
        this.okButton.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }

    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerHasText = new javax.swing.JLabel();
        showCardImage = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        playerHasText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerHasText.setText("<Player> has:");
        playerHasText.setName("playerHasText"); // NOI18N

        showCardImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showCardImage.setName("cardImage"); // NOI18N
        showCardImage.setPreferredSize(new java.awt.Dimension(70, 100));

        okButton.setText("OK (SPACE)");
        okButton.setName("okButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerHasText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(showCardImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(playerHasText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showCardImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void dispose()
    {
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okButton;
    private javax.swing.JLabel playerHasText;
    private javax.swing.JLabel showCardImage;
    // End of variables declaration//GEN-END:variables
}
