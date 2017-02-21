package allguis;

import guiConsoleController.PrivateTipFromDialogController;
import guiConsoleController.I_PrivateTipFrom;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import tegakari.ClueCard;
import tegakari.Player;
import tegakari.PrivateTipCard;
import tegakari.SuspectCard;

/**
 * Window for Private Tip played on user
 *
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class PrivateTipFromDialog extends javax.swing.JDialog implements I_PrivateTipFrom
{

    /**
     * File path to the action card image
     */
    private String actionPath;
    /**
     * Name of the player that used the action card
     */
    private String playerName;
    /**
     * Clue Card to respond to Private Tip with
     */
    private ClueCard cardToShow;
    /**
     * List of clue cards able to show
     */
    private List<ClueCard> cardsToShow;
    /**
     * Array of JButtons for the cards able to be shown
     */
    private JButton[] cards;
    /**
     * True if the private tip is for all cards
     */
    private boolean isAllTip;

    /**
     * Creates a new PrivateTipFrom window
     *
     * @param parent frame that is calling window
     * @param modal modal setting for JDialog
     * @param turnPlayer the player whose turn it is
     * @param privateTip the private tip card that was played
     * @param cardsToShow the list of cards that the user can show
     * @param ctrl controller, eventHandler for PrivateTipFromDialog
     */
    public PrivateTipFromDialog(
            PrivateTipFromDialogController ctrl, JFrame parent, boolean modal, Player turnPlayer,
            PrivateTipCard privateTip, List<ClueCard> cardsToShow)
    {

        super(parent, modal);
        this.setTitle("Tegakari");
        actionPath = privateTip.getImagePath();
        playerName = turnPlayer.getName();
        isAllTip = privateTip.isAll();

        //Check if there are cards to show
        if (cardsToShow.size() > 0)
        {
            cardToShow = cardsToShow.get(0);
        }
        else
        {
            cardToShow = new SuspectCard(null);
        }
        
        
        this.cardsToShow = cardsToShow;

        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        JButton[] tempArray =
        {
            cardButton1, cardButton2, cardButton3, cardButton4, cardButton5, cardButton6
        };
        cards = tempArray;

        //initialize images
        int currInitCard = 0;
        for (ClueCard card : cardsToShow)
        {
            cards[currInitCard++].setIcon(new ImageIcon(getClass().getResource(card.getImagePath())));
        }

        //diable leftover buttons
        while (currInitCard < 6)
        {
            cards[currInitCard++].setEnabled(false);
        }
        
        // If there's only one card to show, make OK button selectable
        if (cardsToShow.size() == 1)
        {
            okButton.setEnabled(true);
        }

        //set text according to isAll conditions
        playsText.setText(privateTip.isAll()
                ? "played this Private Tip on you and saw these cards."
                : "played this Private Tip you. Pick a card to show.");
        if (this.cardsToShow.size() == 0)
        {
            playsText.setText("played this Private Tip on you but you have no cards to show.");
            okButton.setEnabled(true);
        }
        
        okButton.addActionListener(ctrl);
        okButton.setActionCommand("OK");
        okButton.addKeyListener(ctrl);
        
        cardButton1.setActionCommand("1");
        cardButton1.addActionListener(ctrl);
        cardButton1.addKeyListener(ctrl);
        
        cardButton2.setActionCommand("2");
        cardButton2.addActionListener(ctrl);
        cardButton2.addKeyListener(ctrl);
        
        cardButton3.setActionCommand("3");
        cardButton3.addActionListener(ctrl);
        cardButton3.addKeyListener(ctrl);
        
        cardButton4.setActionCommand("4");
        cardButton4.addActionListener(ctrl);
        cardButton4.addKeyListener(ctrl);
        
        cardButton5.setActionCommand("5");
        cardButton5.addActionListener(ctrl);
        cardButton5.addKeyListener(ctrl);
        
        cardButton6.setActionCommand("6");
        cardButton6.addActionListener(ctrl);
        cardButton6.addKeyListener(ctrl);
        
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
        playsText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cardButton2 = new javax.swing.JButton();
        cardButton1 = new javax.swing.JButton();
        cardButton3 = new javax.swing.JButton();
        cardButton4 = new javax.swing.JButton();
        cardButton5 = new javax.swing.JButton();
        cardButton6 = new javax.swing.JButton();
        privateTipImage = new javax.swing.JLabel();
        fromPlayerText1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        title.setText("Private Tip Request");
        title.setName("titleText"); // NOI18N

        playsText.setText("<HTML>plays this Private Tip on you, pick a card to show<br>or press 1-6<HTNML>");
        playsText.setName("descText"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cardButton2.setName("cardButton2"); // NOI18N
        cardButton2.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton2ActionPerformed(evt);
            }
        });

        cardButton1.setName("cardButton1"); // NOI18N
        cardButton1.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton1ActionPerformed(evt);
            }
        });

        cardButton3.setName("cardButton3"); // NOI18N
        cardButton3.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton3ActionPerformed(evt);
            }
        });

        cardButton4.setName("cardButton4"); // NOI18N
        cardButton4.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton4ActionPerformed(evt);
            }
        });

        cardButton5.setName("cardButton5"); // NOI18N
        cardButton5.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton5ActionPerformed(evt);
            }
        });

        cardButton6.setName("cardButton6"); // NOI18N
        cardButton6.setPreferredSize(new java.awt.Dimension(70, 100));
        cardButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(cardButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cardButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cardButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cardButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cardButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cardButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cardButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cardButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cardButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cardButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cardButton5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cardButton6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        privateTipImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(actionPath)));
        privateTipImage.setText("<Private Tip Card>");
        privateTipImage.setName("subText"); // NOI18N
        privateTipImage.setPreferredSize(new java.awt.Dimension(70, 100));

        fromPlayerText1.setText(playerName);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(fromPlayerText1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(playsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(133, 133, 133)
                        .add(title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(103, 103, 103))
            .add(jPanel1Layout.createSequentialGroup()
                .add(233, 233, 233)
                .add(privateTipImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(title)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(privateTipImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(playsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fromPlayerText1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        okButton.setText("OK (SPACE)");
        okButton.setName("okButton"); // NOI18N
        okButton.setEnabled(isAllTip || (cardsToShow.size() == 0));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(okButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(okButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void setEnabledButton(String cmd)
    {
        if (cmd.equals("1"))
        {
            cardButton1.setEnabled(true);
        }
        else if (cmd.equals("2"))
        {
            cardButton2.setEnabled(true);
        }
        else if (cmd.equals("3"))
        {
            cardButton3.setEnabled(true);
        }
        else if (cmd.equals("4"))
        {
            cardButton4.setEnabled(true);
        }
        else if (cmd.equals("5"))
        {
            cardButton5.setEnabled(true);
        }
        else
        {
            cardButton6.setEnabled(true);
        }
    }
    
    public void setEnabledOK()
    {
        okButton.setEnabled(true);
    }
    
    /**
     * Action for OK button. Closes window
     *
     * @param evt button pressed
     */
private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    this.dispose();
}//GEN-LAST:event_okButtonActionPerformed

    /**
     * Action for the card button 6. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton6ActionPerformed

    }//GEN-LAST:event_cardButton6ActionPerformed

    /**
     * Action for card button 5. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton5ActionPerformed

    }//GEN-LAST:event_cardButton5ActionPerformed

    /**
     * Action for card button 4. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton4ActionPerformed

    }//GEN-LAST:event_cardButton4ActionPerformed

    /**
     * Action for card button 3. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton3ActionPerformed

    }//GEN-LAST:event_cardButton3ActionPerformed

    /**
     * Action for card button 1. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton1ActionPerformed

    }//GEN-LAST:event_cardButton1ActionPerformed

    /**
     * Action for card button 2. Selects that card and disables all other ones
     *
     * @param evt button pressed
     */
    private void cardButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButton2ActionPerformed

    }//GEN-LAST:event_cardButton2ActionPerformed

    /**
     * Disables all card buttons
     */
    public void disableCards()
    {
        cardButton1.setEnabled(false);
        cardButton2.setEnabled(false);
        cardButton3.setEnabled(false);
        cardButton4.setEnabled(false);
        cardButton5.setEnabled(false);
        cardButton6.setEnabled(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cardButton1;
    private javax.swing.JButton cardButton2;
    private javax.swing.JButton cardButton3;
    private javax.swing.JButton cardButton4;
    private javax.swing.JButton cardButton5;
    private javax.swing.JButton cardButton6;
    private javax.swing.JLabel fromPlayerText1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel playsText;
    private javax.swing.JLabel privateTipImage;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
