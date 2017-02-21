/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allguis;

import guiConsoleController.I_SnoopDialog;
import guiConsoleController.SnoopDialogController;
import java.util.List;
import javax.swing.JButton;
import tegakari.ActionCard;
import tegakari.ClueCard;
import javax.swing.ImageIcon;

/**
 * The GUI window for choosing a card to snoop from the opponent's hand.
 * 
 * @author anhnguyen
 * @version 11/30/15 modify source path
 */
public class SnoopDialog extends javax.swing.JDialog implements I_SnoopDialog
{

    /**
     * The chosen clue card from random selection
     */
    private ClueCard pickedCard;
    /**
     * List of all clue cards of the player that Snoop was used on
     */
    private List<ClueCard> cardList;
    /**
     * Array of buttons for the cards
     */
    private JButton[] cardButtons;
    /**
     * The Snoop card used
     */
    private ActionCard card;
    /**
     * Player that used the Snoop card and type of snoop card
     */
    private String messageText;
    /**
     * Who's hand is being snooped on
     */
    private String messageText2;

    /**
     * Form of the window to perform a snoop
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param cardsToSnoop list of clue cards to snoop, ie target player's hand
     * @param card the Snoop card
     * @param toShow text of who played the snoop and the type of snoop
     * @param toShow2 text of who is being snooped on
     * @param ctrl controller, eventHandler for SnoopDialog
     */
    public SnoopDialog(SnoopDialogController ctrl, java.awt.Frame parent, boolean modal,
            List<ClueCard> cardsToSnoop, ActionCard card, String toShow, String toShow2)
    {
        super(parent, modal);
        this.setTitle("Tegakari");
        int rand = (int) (Math.random() * cardsToSnoop.size());
        pickedCard = cardsToSnoop.get(rand);
        this.card = card;
        messageText = toShow;
        messageText2 = toShow2;
        initComponents();
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        cardList = cardsToSnoop;
        JButton[] tempArray =
        {
            clue1Button, clue2Button, clue3Button, clue4Button, clue5Button, clue6Button
        };
        cardButtons = tempArray;
        
        // name buttons
        okButton.setActionCommand("ok");
        clue1Button.setActionCommand("card1");
        clue2Button.setActionCommand("card2");
        clue3Button.setActionCommand("card3");
        clue4Button.setActionCommand("card4");
        clue5Button.setActionCommand("card5");
        clue6Button.setActionCommand("card6");
        // add action listeners
        okButton.addActionListener(ctrl);
        clue1Button.addActionListener(ctrl);
        clue2Button.addActionListener(ctrl);
        clue3Button.addActionListener(ctrl);
        clue4Button.addActionListener(ctrl);
        clue5Button.addActionListener(ctrl);
        clue6Button.addActionListener(ctrl);
        
        // add key listeners
        okButton.addKeyListener(ctrl);
        clue1Button.addKeyListener(ctrl);
        clue2Button.addKeyListener(ctrl);
        clue3Button.addKeyListener(ctrl);
        clue4Button.addKeyListener(ctrl);
        clue5Button.addKeyListener(ctrl);
        clue6Button.addKeyListener(ctrl);

        //FOR each card in the target's hand
        for (int size = cardList.size(); size < 6; size++)
        {
            cardButtons[size].setEnabled(false);
        }
        //ENDFORF

        this.setLocationRelativeTo(null);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        pickCardText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        clue1Button = new javax.swing.JButton();
        clue2Button = new javax.swing.JButton();
        clue3Button = new javax.swing.JButton();
        clue4Button = new javax.swing.JButton();
        clue5Button = new javax.swing.JButton();
        clue6Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Snoop");

        pickCardText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pickCardText.setText("Please pick a card below.");

        clue1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue1Button.setName("card1"); // NOI18N
        clue1Button.setPreferredSize(new java.awt.Dimension(70, 100));
        clue1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clue1ButtonActionPerformed(evt);
            }
        });

        clue2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue2Button.setName("card2"); // NOI18N
        clue2Button.setPreferredSize(new java.awt.Dimension(70, 100));

        clue3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue3Button.setName("card3"); // NOI18N
        clue3Button.setPreferredSize(new java.awt.Dimension(70, 100));

        clue4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue4Button.setName("card4"); // NOI18N
        clue4Button.setPreferredSize(new java.awt.Dimension(70, 100));

        clue5Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue5Button.setName("card5"); // NOI18N
        clue5Button.setPreferredSize(new java.awt.Dimension(70, 100));

        clue6Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg")));
        clue6Button.setName("card6"); // NOI18N
        clue6Button.setPreferredSize(new java.awt.Dimension(70, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(card.getImagePath())));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 100));

        jLabel2.setText(messageText + ".");
        jLabel2.setName("text1"); // NOI18N

        jLabel3.setText(messageText2 + ".");
        jLabel3.setName("text2"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(24, 24, 24)
                                .add(clue1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(clue2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(clue3Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(clue4Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(clue5Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(clue6Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(52, 52, 52)
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(jLabel2)
                                        .add(91, 91, 91)
                                        .add(message))
                                    .add(jLabel3))))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(pickCardText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(title)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(50, 50, 50)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(message))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel3)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(pickCardText)
                .add(7, 7, 7)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(clue1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue3Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue4Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue5Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clue6Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        okButton.setText("OK (SPACE)");
        okButton.setName("okButton"); // NOI18N
        okButton.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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

    private void clue1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clue1ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clue1ButtonActionPerformed
    
    /**
     * Obtain the seat with the corresponding number.
     * 
     * @param num the card number, not the index number, starting from the left at 1
     * @param set the boolean to set this button to
     */
    public void setCardButton(int num, boolean set)
    {        
        cardButtons[num-1].setEnabled(set);
    }
    
    /**
     * Sets this OK Button visible or not
     * 
     * @param set the boolean to set this button visible or not
     */
    public void setOKButton(boolean set)
    {
        okButton.setEnabled(set);
    }
    
    /**
     * Set the Icon of this button
     * 
     * @param card the icon seat to change to
     * @param pickedCard the icon to change to
     */
    public void setIcon(int card, ClueCard pickedCard)
    {
        cardButtons[card-1].setIcon(new ImageIcon(
                getClass().getResource(pickedCard.getImagePath())));
    }
    
    /**
     * make this window hidden
     */
    public void dispose()
    {
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clue1Button;
    private javax.swing.JButton clue2Button;
    private javax.swing.JButton clue3Button;
    private javax.swing.JButton clue4Button;
    private javax.swing.JButton clue5Button;
    private javax.swing.JButton clue6Button;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel message;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel pickCardText;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
