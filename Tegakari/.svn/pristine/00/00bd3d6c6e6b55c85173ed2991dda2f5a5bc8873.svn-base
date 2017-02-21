package allguis;

import guiConsoleController.SnoopOnPlayerDialogController;
import guiConsoleController.I_SnoopOnPlayerDialog;
import java.util.List;
import javax.swing.JButton;
import tegakari.Player;

/**
 * Window to choose which player to snoop on
 *
 * @author DeionLaw
 */
public class SnoopOnPlayerDialog extends javax.swing.JDialog implements I_SnoopOnPlayerDialog
{

    /**
     * The player chosen to snoop on
     */
    private Player chosenPlayer;
    /**
     * Array of buttons for each player
     */
    private JButton[] playerButtons;
    /**
     * List of players
     */
    private List<Player> playerList;

    /**
     * Form of the window to select player to snoop on
     *
     * @param parent parent frame, GameTable
     * @param modal modal setting for JDialog
     * @param list list of players
     * @param ctrl controller, eventHandler for SnoopOnPlayerDialog
     */
    public SnoopOnPlayerDialog(SnoopOnPlayerDialogController ctrl, java.awt.Frame parent, boolean modal, List<Player> list)
    {
        super(parent, modal);
        this.setTitle("Tegakari");
        chosenPlayer = list.get(1);
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        // name buttons.
        seat1Button.setName("seat1");
        seat2Button.setName("seat2");
        seat3Button.setName("seat3");
        okButton.setName("ok");
        playerList = list;
        JButton[] tempArray =
        {
            seat1Button, seat2Button, seat3Button, seat4Button
        };
        playerButtons = tempArray;
        //System.out.println("Dialog: List Player size: " + list.size());
        
        for (JButton buttonIndex : playerButtons)
        {
            buttonIndex.setEnabled(false);
            buttonIndex.setVisible(false);
        }
        
        //FOR each player assign a button
        for (int seat = 1; seat < list.size(); seat++)
        {
            playerButtons[seat - 1].setText(list.get(seat).getName());
            playerButtons[seat - 1].setEnabled(true);
            playerButtons[seat - 1].setVisible(true);
            //System.out.println("\tDone: " + seat + " |"+ list.get(seat).name);
        }
        //ENDFOR

        this.setLocationRelativeTo(null);
        // Add action listeners
        okButton.setActionCommand("ok");
        okButton.addActionListener(ctrl);
        okButton.addKeyListener(ctrl);
        seat1Button.setActionCommand("seat1");
        seat1Button.addActionListener(ctrl);
        seat1Button.addKeyListener(ctrl);
        seat2Button.setActionCommand("seat2");
        seat2Button.addActionListener(ctrl);
        seat2Button.addKeyListener(ctrl);
        seat3Button.setActionCommand("seat3");
        seat3Button.addActionListener(ctrl);
        seat3Button.addKeyListener(ctrl);
        seat4Button.setActionCommand("seat4");
        seat4Button.addActionListener(ctrl);
        seat4Button.addKeyListener(ctrl);
        
        // for the forth button that should be added
        //seat4Button.setActionCommand("seat4");
        //seat4Button.addActionListener(ctrl);
        //seat4Button.addKeyListener(ctrl);
        
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
     * Obtain the seat with the corresponding number.
     * 
     * @param num the seat number, not the index number, starting from the left at 1
     * @param set the boolean to set this button visible or not
     */
    public void setSeatButton(int num, boolean set)
    {        
        playerButtons[num-1].setEnabled(set);
    }
    
    /**
     * Sets the OK Button to be visible or not.
     * 
     * @param set the boolean to set this button visible or not
     */
    public void setOKButton(boolean set)
    {
        okButton.setEnabled(set);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        seat1Button = new javax.swing.JButton();
        seat2Button = new javax.swing.JButton();
        seat3Button = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        seat4Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Snoop on player");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choose a player to snoop on (1-4):");

        seat1Button.setText("jButton1");
        seat1Button.setName(""); // NOI18N

        seat2Button.setText("jButton2");
        seat2Button.setName(""); // NOI18N

        seat3Button.setText("jButton3");
        seat3Button.setName(""); // NOI18N

        okButton.setText("OK (SPACE)");
        okButton.setName(""); // NOI18N
        okButton.setEnabled(false);

        seat4Button.setText("jButton4");
        seat4Button.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(seat1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seat2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seat3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(seat4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton seat1Button;
    private javax.swing.JButton seat2Button;
    private javax.swing.JButton seat3Button;
    private javax.swing.JButton seat4Button;
    // End of variables declaration//GEN-END:variables
}
