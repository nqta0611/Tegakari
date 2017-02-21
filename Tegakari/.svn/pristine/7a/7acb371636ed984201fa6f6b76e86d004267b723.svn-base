package allguis;

import guiConsoleController.NotePadController;
import guiConsoleController.GameTableController;
import guiConsoleController.I_GameTable;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import tegakari.*;

/**
 * Window of the game table where the game is played
 *
 * @author anh nguyen
 */
public class GameTable extends javax.swing.JFrame implements Observer, I_GameTable
{
    /**
     * Number of players in the lobby
     */
    private int playerSize;
    /**
     * The notepad window
     */
    private NotePadDialog notepad;
    /**
     * Color for having the current turn
     */
    private java.awt.Color inturn = new java.awt.Color(0, 153, 0);
    /**
     * Color when not in turn
     */
    private java.awt.Color outturn = new java.awt.Color(102, 153, 255);
    /**
     * Color when seat has no player
     */
    private java.awt.Color outseat = new java.awt.Color(102,102,102);
    /**
     * Color when player is out
     */
    private java.awt.Color outedPlayer = new java.awt.Color(204, 51, 0);
    /**
     * Border for having current turn
     */
    private Border inturnBorder = BorderFactory.createLineBorder(inturn);
    /**
     * Border when not in turn
     */
    private Border outturnBorder = BorderFactory.createLineBorder(outturn);
    /**
     * Border for user's seat when having current turn
     */
    private Border selfPlayerInturnBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, inturn);
    /**
     * Border for user's seat when not in turn
     */
    private Border selfPlayerOutturnBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, outturn);
    /**
     * Button border for user's seat when having current turn
     */
    private Border inturnButtonBorder = BorderFactory.createMatteBorder(0, 0, 0, 5, inturn);
    /**
     * Button border for user's seat when not in turn
     */
    private Border outturnButtonBorder = BorderFactory.createMatteBorder(0, 0, 0, 5, outturn);
    /**
     * The game engine
     */
    private GameEngine engine;
    /**
     * The state if the game being played
     */
    private GameState state;
    /**
     * The user
     */
    private Player selfPlayer;
    /**
     * The players in each seat
     */
    private Player[] seats;
    /**
     * The panels of each seat's turn indicator
     */
    private JPanel[] seatTurnIndicator;
    /**
     * The panels of each seat's panel
     */
    private JPanel[] seatPanels;
    /**
     * Each seat's DM
     */
    private JLabel[] seatDMs;
    /**
     * Each seat's Portrait
     */
    private JLabel[] seatHands;
    /**
     * User's action card buttons
     */
    private JButton[] actionCardButtons;

    private JLabel[] DMLabels;

    /**
     * Creates new form GameTable
     *
     * @param engine A set-up game engine ready to play the game
     * @param ctrl controller, eventHandler for GameTable
     */
    public GameTable(GameTableController ctrl, GameEngine engine)
    {
        this.engine = engine;
        this.setTitle("Tegakari");
        engine.setGameTableGUI(this);
        state = engine.getGameState();
        this.playerSize = state.getPlayers().size();
        seats = new Player[playerSize];
        state.addObserver(this);
        selfPlayer = state.getSelfPlayer();
        this.setTitle("Tegakari: " + selfPlayer.getName());
        initComponents();
        this.setLocationRelativeTo(null);
        
        NotePadController noteCtrl = new NotePadController();
        // create the notepad
        notepad = new NotePadDialog(this, false, 
                engine.getGameState().getTable().getTheme(), noteCtrl);
        notepad.setLocationRelativeTo(this);
        notepad.toFront();
        notepad.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        noteCtrl.setup(false, notepad);

        //System.out.println("Dest size: " +state.getTable().getTheme().getDestinations().size());
        JPanel[] tempArray1 =
        {
            selfPlayerTurnIndicator, seat1TurnIndicator, seat2TurnIndicator, seat3TurnIndicator, seat4TurnIndicator
        };
        seatTurnIndicator = tempArray1;
        JPanel[] tempArray2 =
        {
            selfPlayerSeat, seat1, seat2, seat3, seat4
        };
        seatPanels = tempArray2;
        JLabel[] tempArray3 =
        {
            selfPlayerDM, seat1DM, seat2DM, seat3DM, seat4DM
        };
        seatDMs = tempArray3;
        JButton[] tempArray4 =
        {
            actionCard1Button, actionCard2Button
        };
        actionCardButtons = tempArray4;
        JLabel[] tempArray5 =
        {
            seat1Hand, seat2Hand, seat3Hand, seat4Hand
        };
        seatHands = tempArray5;

        JLabel[] TempsLabel = {jLabel7, jLabel3, jLabel4, jLabel5, jLabel6, jLabel2};
        DMLabels = TempsLabel;
        
        initialDraw();
        updateSeats();
        updateActionCards();
        updateDM();
        //notepad.setNotepadTheme(engine.getGameState().getTable().getTheme());
        
        drawButton.addActionListener(ctrl);
        drawButton.addKeyListener(ctrl);
        actionCard1Button.addActionListener(ctrl);
        actionCard1Button.setActionCommand("action1");
        actionCard1Button.addKeyListener(ctrl);
        actionCard2Button.addActionListener(ctrl);
        actionCard2Button.setActionCommand("action2");
        actionCard2Button.addKeyListener(ctrl);
        accuseButton.addActionListener(ctrl);
        accuseButton.addKeyListener(ctrl);
        notepadButton.addActionListener(ctrl);
        notepadButton.setActionCommand("Notepad");
        notepadButton.addKeyListener(ctrl);
        
        rulesButton.addActionListener(ctrl);
        rulesButton.setActionCommand("Rules");
        rulesButton.addKeyListener(ctrl);
        
        endTurnButton.addActionListener(ctrl);
        endTurnButton.setActionCommand("EndTurn");
        endTurnButton.addKeyListener(ctrl);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    public void drawEnable(boolean visable)
    {
        drawButton.setEnabled(visable);
    }
    public void action1Enable(boolean visable)
    {
        actionCard1Button.setEnabled(visable);
    }
    public void action2Enable(boolean visable)
    {
        actionCard2Button.setEnabled(visable);
    }
    public void accuseEnable(boolean visable)
    {
        accuseButton.setEnabled(visable);
    }
    public void endTurnEnable(boolean visable)
    {
        endTurnButton.setEnabled(visable);
    }
    
    public void notepadEnable(boolean visable)
    {
        notepad.setVisible(visable);
    }
    
    public void rulesEnable()
    {
        HelpDialog rules = new HelpDialog(this, true);
        rules.setLocationRelativeTo(this);
        rules.pack();
        rules.setVisible(true);
    }
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        PanelTable = new javax.swing.JPanel();
        selfPlayerSeat = new javax.swing.JPanel();
        PanelPlayer1Cards = new javax.swing.JPanel();
        selfPlayerDM = new javax.swing.JLabel();
        selfPlayerClue1 = new javax.swing.JLabel();
        selfPlayerClue2 = new javax.swing.JLabel();
        selfPlayerClue3 = new javax.swing.JLabel();
        selfPlayerClue4 = new javax.swing.JLabel();
        actionCard1Button = new javax.swing.JButton();
        actionCard2Button = new javax.swing.JButton();
        selfPlayerClue5 = new javax.swing.JLabel();
        selfPlayerClue6 = new javax.swing.JLabel();
        dmLabel = new javax.swing.JLabel();
        actionCardDirections = new javax.swing.JLabel();
        PanelButtons = new javax.swing.JPanel();
        endTurnButton = new javax.swing.JButton();
        accuseButton = new javax.swing.JButton();
        notepadButton = new javax.swing.JButton();
        rulesButton = new javax.swing.JButton();
        selfPlayerTurnIndicator = new javax.swing.JPanel();
        selfPlayerName = new javax.swing.JLabel();
        seat1 = new javax.swing.JPanel();
        seat1TurnIndicator = new javax.swing.JPanel();
        seat1Name = new javax.swing.JLabel();
        seat1CardCount = new javax.swing.JLabel();
        seat1Hand = new javax.swing.JLabel();
        seat1DM = new javax.swing.JLabel();
        seat2 = new javax.swing.JPanel();
        seat2TurnIndicator = new javax.swing.JPanel();
        seat2Name = new javax.swing.JLabel();
        seat2CardCount = new javax.swing.JLabel();
        seat2Hand = new javax.swing.JLabel();
        seat2DM = new javax.swing.JLabel();
        seat3 = new javax.swing.JPanel();
        seat3TurnIndicator = new javax.swing.JPanel();
        seat3Name = new javax.swing.JLabel();
        seat3CardCount = new javax.swing.JLabel();
        seat3Hand = new javax.swing.JLabel();
        seat3DM = new javax.swing.JLabel();
        seat4 = new javax.swing.JPanel();
        seat4TurnIndicator = new javax.swing.JPanel();
        seat4Name = new javax.swing.JLabel();
        seat4CardCount = new javax.swing.JLabel();
        seat4Hand = new javax.swing.JLabel();
        seat4DM = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        drawButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PanelHistory = new javax.swing.JPanel();
        LabelHistory = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TextHistory = new javax.swing.JScrollPane();
        textHistoryArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selfPlayerSeat.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 51, 153)));

        PanelPlayer1Cards.setBackground(new java.awt.Color(255, 255, 255));

        selfPlayerDM.setText("DM1");
        selfPlayerDM.setPreferredSize(new java.awt.Dimension(70, 100));

        selfPlayerClue1.setText(" ");
        selfPlayerClue1.setPreferredSize(new java.awt.Dimension(70, 100));

        selfPlayerClue2.setText(" ");
        selfPlayerClue2.setPreferredSize(new java.awt.Dimension(70, 100));

        selfPlayerClue3.setText(" ");
        selfPlayerClue3.setPreferredSize(new java.awt.Dimension(70, 100));

        selfPlayerClue4.setText(" ");
        selfPlayerClue4.setPreferredSize(new java.awt.Dimension(70, 100));

        actionCard1Button.setName("action1"); // NOI18N
        actionCard1Button.setPreferredSize(new java.awt.Dimension(70, 100));
        actionCard1Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                actionCard1ButtonActionPerformed(evt);
            }
        });

        actionCard2Button.setName("action2"); // NOI18N
        actionCard2Button.setPreferredSize(new java.awt.Dimension(70, 100));
        actionCard2Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                actionCard2ButtonActionPerformed(evt);
            }
        });

        selfPlayerClue5.setText(" ");
        selfPlayerClue5.setPreferredSize(new java.awt.Dimension(70, 100));

        selfPlayerClue6.setText(" ");
        selfPlayerClue6.setPreferredSize(new java.awt.Dimension(70, 100));

        dmLabel.setText("<HTML><center>Destination<br>Marker</center></HTML>");

        actionCardDirections.setText("Press 1 or 2 to play the Action Card ");

        org.jdesktop.layout.GroupLayout PanelPlayer1CardsLayout = new org.jdesktop.layout.GroupLayout(PanelPlayer1Cards);
        PanelPlayer1Cards.setLayout(PanelPlayer1CardsLayout);
        PanelPlayer1CardsLayout.setHorizontalGroup(
            PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelPlayer1CardsLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelPlayer1CardsLayout.createSequentialGroup()
                        .add(selfPlayerDM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(selfPlayerClue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(selfPlayerClue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(selfPlayerClue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(selfPlayerClue4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(selfPlayerClue5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(selfPlayerClue6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(dmLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelPlayer1CardsLayout.createSequentialGroup()
                        .add(actionCard1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(actionCard2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(actionCardDirections))
                .add(27, 27, 27))
        );
        PanelPlayer1CardsLayout.setVerticalGroup(
            PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelPlayer1CardsLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelPlayer1CardsLayout.createSequentialGroup()
                        .add(dmLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(5, 5, 5))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelPlayer1CardsLayout.createSequentialGroup()
                        .add(actionCardDirections)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                .add(PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(actionCard2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(actionCard1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(PanelPlayer1CardsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(selfPlayerDM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(selfPlayerClue6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelButtons.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(0, 0, 153)));

        endTurnButton.setText("<HTML><U>E</U>nd<br>Turn<HTML>");
        endTurnButton.setName("EndTurn"); // NOI18N
        endTurnButton.setEnabled(false);
        endTurnButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                endTurnButtonActionPerformed(evt);
            }
        });

        accuseButton.setText("<HTML><U>A</U>ccuse<HTNML>");
        accuseButton.setEnabled(false);
        accuseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                accuseButtonActionPerformed(evt);
            }
        });

        notepadButton.setText("<HTML><U>N</U>otePad<HTNML>");
        notepadButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                notepadButtonActionPerformed(evt);
            }
        });

        rulesButton.setText("<HTML>View <U>R</U>ules<HTNML>");
        rulesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rulesButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout PanelButtonsLayout = new org.jdesktop.layout.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(endTurnButton)
            .add(accuseButton)
            .add(notepadButton)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, rulesButton)
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .add(endTurnButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(accuseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(notepadButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rulesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selfPlayerTurnIndicator.setBackground(new java.awt.Color(204, 204, 204));
        selfPlayerTurnIndicator.setForeground(new java.awt.Color(255, 255, 255));

        selfPlayerName.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        selfPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selfPlayerName.setText("SelfPlayer");

        org.jdesktop.layout.GroupLayout selfPlayerTurnIndicatorLayout = new org.jdesktop.layout.GroupLayout(selfPlayerTurnIndicator);
        selfPlayerTurnIndicator.setLayout(selfPlayerTurnIndicatorLayout);
        selfPlayerTurnIndicatorLayout.setHorizontalGroup(
            selfPlayerTurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, selfPlayerTurnIndicatorLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(selfPlayerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 828, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(65, 65, 65))
        );
        selfPlayerTurnIndicatorLayout.setVerticalGroup(
            selfPlayerTurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(selfPlayerTurnIndicatorLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(selfPlayerName)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout selfPlayerSeatLayout = new org.jdesktop.layout.GroupLayout(selfPlayerSeat);
        selfPlayerSeat.setLayout(selfPlayerSeatLayout);
        selfPlayerSeatLayout.setHorizontalGroup(
            selfPlayerSeatLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, selfPlayerSeatLayout.createSequentialGroup()
                .add(PanelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(selfPlayerSeatLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(PanelPlayer1Cards, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(selfPlayerTurnIndicator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        selfPlayerSeatLayout.setVerticalGroup(
            selfPlayerSeatLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(selfPlayerSeatLayout.createSequentialGroup()
                .add(selfPlayerTurnIndicator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PanelPlayer1Cards, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(PanelButtons, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        seat1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));

        seat1TurnIndicator.setBackground(new java.awt.Color(153, 153, 153));
        seat1TurnIndicator.setPreferredSize(new java.awt.Dimension(32, 25));

        seat1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat1Name.setText(" ");

        seat1CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat1CardCount.setText(" ");

        org.jdesktop.layout.GroupLayout seat1TurnIndicatorLayout = new org.jdesktop.layout.GroupLayout(seat1TurnIndicator);
        seat1TurnIndicator.setLayout(seat1TurnIndicatorLayout);
        seat1TurnIndicatorLayout.setHorizontalGroup(
            seat1TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat1TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap()
                .add(seat1TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(seat1Name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .add(seat1CardCount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        seat1TurnIndicatorLayout.setVerticalGroup(
            seat1TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat1TurnIndicatorLayout.createSequentialGroup()
                .add(seat1Name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(seat1CardCount)
                .addContainerGap())
        );

        seat1Hand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg"))); // NOI18N
        seat1Hand.setText(" ");
        seat1Hand.setPreferredSize(new java.awt.Dimension(70, 100));

        seat1DM.setText(" ");
        seat1DM.setPreferredSize(new java.awt.Dimension(70, 100));

        org.jdesktop.layout.GroupLayout seat1Layout = new org.jdesktop.layout.GroupLayout(seat1);
        seat1.setLayout(seat1Layout);
        seat1Layout.setHorizontalGroup(
            seat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat1Layout.createSequentialGroup()
                .addContainerGap()
                .add(seat1Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                .add(seat1DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(seat1TurnIndicator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        seat1Layout.setVerticalGroup(
            seat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat1Layout.createSequentialGroup()
                .addContainerGap()
                .add(seat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(seat1DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(seat1Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(seat1TurnIndicator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        seat2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        seat2.setPreferredSize(new java.awt.Dimension(215, 170));

        seat2TurnIndicator.setBackground(outturn);

        seat2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat2Name.setText(" ");

        seat2CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat2CardCount.setText(" ");

        org.jdesktop.layout.GroupLayout seat2TurnIndicatorLayout = new org.jdesktop.layout.GroupLayout(seat2TurnIndicator);
        seat2TurnIndicator.setLayout(seat2TurnIndicatorLayout);
        seat2TurnIndicatorLayout.setHorizontalGroup(
            seat2TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat2TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap()
                .add(seat2TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(seat2CardCount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(seat2Name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        seat2TurnIndicatorLayout.setVerticalGroup(
            seat2TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat2TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .add(seat2Name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(seat2CardCount)
                .addContainerGap())
        );

        seat2Hand.setBackground(new java.awt.Color(0, 255, 102));
        seat2Hand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ClueBack.jpg"))); // NOI18N
        seat2Hand.setPreferredSize(new java.awt.Dimension(70, 100));

        seat2DM.setBackground(new java.awt.Color(153, 255, 255));
        seat2DM.setPreferredSize(new java.awt.Dimension(70, 100));

        org.jdesktop.layout.GroupLayout seat2Layout = new org.jdesktop.layout.GroupLayout(seat2);
        seat2.setLayout(seat2Layout);
        seat2Layout.setHorizontalGroup(
            seat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat2Layout.createSequentialGroup()
                .addContainerGap()
                .add(seat2Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                .add(seat2DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(seat2TurnIndicator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        seat2Layout.setVerticalGroup(
            seat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, seat2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(seat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, seat2DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, seat2Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26)
                .add(seat2TurnIndicator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        seat3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        seat3.setPreferredSize(new java.awt.Dimension(215, 170));

        seat3TurnIndicator.setBackground(outseat);

        seat3Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat3Name.setText(" ");

        seat3CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat3CardCount.setText(" ");

        org.jdesktop.layout.GroupLayout seat3TurnIndicatorLayout = new org.jdesktop.layout.GroupLayout(seat3TurnIndicator);
        seat3TurnIndicator.setLayout(seat3TurnIndicatorLayout);
        seat3TurnIndicatorLayout.setHorizontalGroup(
            seat3TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat3TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap()
                .add(seat3TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(seat3CardCount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(seat3Name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        seat3TurnIndicatorLayout.setVerticalGroup(
            seat3TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat3TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .add(seat3Name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(seat3CardCount)
                .addContainerGap())
        );

        seat3Hand.setBackground(new java.awt.Color(0, 255, 102));
        seat3Hand.setPreferredSize(new java.awt.Dimension(70, 100));

        seat3DM.setBackground(new java.awt.Color(153, 255, 255));
        seat3DM.setPreferredSize(new java.awt.Dimension(70, 100));

        org.jdesktop.layout.GroupLayout seat3Layout = new org.jdesktop.layout.GroupLayout(seat3);
        seat3.setLayout(seat3Layout);
        seat3Layout.setHorizontalGroup(
            seat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat3Layout.createSequentialGroup()
                .addContainerGap()
                .add(seat3Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 52, Short.MAX_VALUE)
                .add(seat3DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(seat3TurnIndicator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        seat3Layout.setVerticalGroup(
            seat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, seat3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(seat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, seat3Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, seat3DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26)
                .add(seat3TurnIndicator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        seat4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        seat4.setPreferredSize(new java.awt.Dimension(215, 170));

        seat4TurnIndicator.setBackground(new java.awt.Color(102, 102, 102));

        seat4Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat4Name.setText(" ");

        seat4CardCount.setBackground(new java.awt.Color(204, 204, 204));
        seat4CardCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seat4CardCount.setText(" ");

        org.jdesktop.layout.GroupLayout seat4TurnIndicatorLayout = new org.jdesktop.layout.GroupLayout(seat4TurnIndicator);
        seat4TurnIndicator.setLayout(seat4TurnIndicatorLayout);
        seat4TurnIndicatorLayout.setHorizontalGroup(
            seat4TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat4TurnIndicatorLayout.createSequentialGroup()
                .addContainerGap()
                .add(seat4TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(seat4Name, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .add(seat4CardCount, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        seat4TurnIndicatorLayout.setVerticalGroup(
            seat4TurnIndicatorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat4TurnIndicatorLayout.createSequentialGroup()
                .add(seat4Name)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(seat4CardCount)
                .addContainerGap())
        );

        seat4Name.getAccessibleContext().setAccessibleName("Player5");

        seat4Hand.setPreferredSize(new java.awt.Dimension(70, 100));

        seat4DM.setPreferredSize(new java.awt.Dimension(70, 100));

        org.jdesktop.layout.GroupLayout seat4Layout = new org.jdesktop.layout.GroupLayout(seat4);
        seat4.setLayout(seat4Layout);
        seat4Layout.setHorizontalGroup(
            seat4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat4Layout.createSequentialGroup()
                .addContainerGap()
                .add(seat4Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 76, Short.MAX_VALUE)
                .add(seat4DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(seat4TurnIndicator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        seat4Layout.setVerticalGroup(
            seat4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(seat4Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(seat4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(seat4Hand, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(seat4DM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(seat4TurnIndicator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        tablePanel.setBackground(new java.awt.Color(0, 102, 102));
        tablePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        drawButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ActionBack.jpg")));
        drawButton.setMnemonic(KeyEvent.VK_S);
        drawButton.setText("DealerActionPile");
        drawButton.setPreferredSize(new java.awt.Dimension(70, 100));
        drawButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                drawButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<HTML>Click on the Action Deck  or Press 'd' to<br>Draw a Card and to Start Your Turn</HTML>");
        jLabel1.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel7);

        jLabel3.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel3);

        jLabel4.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel4);

        jLabel5.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel5);

        jLabel6.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel6);

        jLabel2.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel2);

        jLabel8.setPreferredSize(new java.awt.Dimension(70, 100));
        jPanel1.add(jLabel8);

        org.jdesktop.layout.GroupLayout tablePanelLayout = new org.jdesktop.layout.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanelLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tablePanelLayout.createSequentialGroup()
                        .add(drawButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 479, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanelLayout.createSequentialGroup()
                .add(18, 18, 18)
                .add(tablePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(drawButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelHistory.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LabelHistory.setBackground(new java.awt.Color(153, 153, 153));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("HISTORY");

        org.jdesktop.layout.GroupLayout LabelHistoryLayout = new org.jdesktop.layout.GroupLayout(LabelHistory);
        LabelHistory.setLayout(LabelHistoryLayout);
        LabelHistoryLayout.setHorizontalGroup(
            LabelHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, LabelHistoryLayout.createSequentialGroup()
                .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LabelHistoryLayout.setVerticalGroup(
            LabelHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, LabelHistoryLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel9)
                .addContainerGap())
        );

        textHistoryArea.setEditable(false);
        textHistoryArea.setColumns(20);
        textHistoryArea.setRows(5);
        textHistoryArea.setEditable(false);
        TextHistory.setViewportView(textHistoryArea);
        //TextHistory.setEditable(false);

        org.jdesktop.layout.GroupLayout PanelHistoryLayout = new org.jdesktop.layout.GroupLayout(PanelHistory);
        PanelHistory.setLayout(PanelHistoryLayout);
        PanelHistoryLayout.setHorizontalGroup(
            PanelHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(LabelHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(TextHistory)
        );
        PanelHistoryLayout.setVerticalGroup(
            PanelHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelHistoryLayout.createSequentialGroup()
                .add(LabelHistory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(TextHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout PanelTableLayout = new org.jdesktop.layout.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelTableLayout.createSequentialGroup()
                .add(PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(seat2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .add(seat1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelTableLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(tablePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(seat4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(PanelTableLayout.createSequentialGroup()
                        .add(60, 60, 60)
                        .add(seat3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(53, 53, 53)
                        .add(PanelHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .add(PanelTableLayout.createSequentialGroup()
                .add(selfPlayerSeat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelTableLayout.createSequentialGroup()
                        .add(PanelHistory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(PanelTableLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(seat2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                    .add(seat3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelTableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, tablePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, seat4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                    .add(PanelTableLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(seat1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(selfPlayerSeat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action for button to draw an action card
     *
     * @param evt button pressed
     */
    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed

    }//GEN-LAST:event_drawButtonActionPerformed

    /**
     * Action for notepad button
     *
     * @param evt button pressed
     */
    private void notepadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notepadButtonActionPerformed
        //notepad.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_notepadButtonActionPerformed

    /**
     * Action for accuse button. Displays accusation windows to make an accusation.
     *
     * @param evt button pressed
     */
    private void accuseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accuseButtonActionPerformed

    }//GEN-LAST:event_accuseButtonActionPerformed

    /**
     * Action for end turn button. Informs GameEngine that user ends turn
     *
     * @param evt button pressed
     */
    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed

    }//GEN-LAST:event_endTurnButtonActionPerformed

    /**
     * Action for second action card button. Displays appropriate window for second action card
     *
     * @param evt button pressed
     */
    private void actionCard2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionCard2ButtonActionPerformed

    }//GEN-LAST:event_actionCard2ButtonActionPerformed

    /**
     * Action for first action card button. Displays appropriate window for first action card
     *
     * @param evt button pressed
     */
    private void actionCard1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionCard1ButtonActionPerformed

    }//GEN-LAST:event_actionCard1ButtonActionPerformed

    /**
     * Action for rules button. Displays rules window
     *
     * @param evt button pressed
     */
    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        
    }//GEN-LAST:event_rulesButtonActionPerformed

    @Override
    public void update(Observable obs, Object obj)
    {
        updateSeats();
        updateActionCards();
        updateDM();
        textHistoryArea.setText(state.getHistoryLog().toString());
        textHistoryArea.setCaretPosition(0);
    }

    private void updateDM() {
        List<Destination> dest = state.getTable().getPile();
        for (int i = 0; i < dest.size(); i++) {
            DMLabels[i].setIcon(new ImageIcon(getClass().getResource((dest.get(i).getImagePath()))));
        }
    }
    /**
     * Draw initial GUI components. Seats, players, hands, and DMs
     */
    private void initialDraw()
    { //TODO add image path to hand cards of opponents
        //Loop to get turn order starting with selfPlayer
        int counter = 0;
        Queue<Player> players = state.getPlayers();

        //WHILE player at top of queue is not user
        while (!players.peek().equalsName(selfPlayer))
        {
            players.add(players.remove());
            counter++;
        }
        //ENDWHILE
        Queue<Player> temp = new LinkedList<Player>();

        //selfPlayer setup
        temp.add(players.remove());
        JLabel[] playerCards =
        {
            selfPlayerClue1, selfPlayerClue2, selfPlayerClue3, selfPlayerClue4, selfPlayerClue5, selfPlayerClue6
        };
        Queue<ClueCard> playerClueCards = new LinkedList<ClueCard>(selfPlayer.getClueCards());
        Queue<ClueCard> tempClue = new LinkedList<ClueCard>();

        //FOR each clue card in the user's hand
        for (int currCard = 0; !playerClueCards.isEmpty(); currCard++)
        {
            ClueCard card = playerClueCards.remove();
            tempClue.add(card);
            
            //String resource = "/";
            //String resource = card.getImagePath();
            //System.out.println(resource);
            //ImageIcon icon = new ImageIcon(resource);
            //playerCards[currCard].setIcon(icon);
            //System.out.println("Set: " + resource);
            playerCards[currCard].setIcon(new ImageIcon(getClass().getResource((card.getImagePath()))));
            //System.out.println("Set: " + resource);
            //System.out.println("Card path: " + card.getImagePath());
        }
        //ENDFOR

        //For each Clue card in the player's hand
        for (ClueCard c : tempClue)
        {
            //Add back to list
            playerClueCards.add(c);
        }
        //ENDFOR 

        selfPlayerName.setText(selfPlayer.getName());
        selfPlayerDM.setIcon(new ImageIcon(getClass().getResource((selfPlayer.getDestination().getImagePath()))));
        seats[0] = selfPlayer;

        //setup rest of players in game
        Player currSeatPlayer;
        JLabel[] seatNames =
        {
            selfPlayerName, seat1Name, seat2Name, seat3Name, seat4Name
        };
        JLabel[] seatCardCounts =
        {
            null, seat1CardCount, seat2CardCount, seat3CardCount, seat4CardCount
        };

        //FOR each player, except user
        for (int currSeat = 1; !players.isEmpty(); currSeat++)
        {
            currSeatPlayer = players.remove();
            temp.add(currSeatPlayer);
            seatNames[currSeat].setText(currSeatPlayer.getName());
            Destination dest = currSeatPlayer.getDestination();
            seatDMs[currSeat].setIcon(new ImageIcon(getClass().getResource((dest.getImagePath()))));
            //System.out.println("dest path: " + dest.imagePath);
            seatCardCounts[currSeat].setText("ClueCard Count: " + currSeatPlayer.getClueCards().size());
            seats[currSeat] = currSeatPlayer;
        }
        //ENDFOR

        //Put players back in player list
        for (Player p : temp)
        {
            players.add(p);
        }
        // Put back the list of Player back to original order. 
        // The loop at beginning of this method move player arround
        for (int i = 0; i < playerSize - counter; i++)
        {
            players.add(players.remove());
        }
    }

    //updates seats's turn indicator and dm's
    private void updateSeats()
    {
        Player turnPlayer = state.getTurnPlayer();

        //loop through each seat
        for (int currSeat = 0; currSeat < playerSize; currSeat++)
        {
            //set DM
            seatDMs[currSeat].setIcon(
                    new ImageIcon(getClass().getResource((seats[currSeat].getDestination().getImagePath()))));
            if (currSeat != 0)
            {
                seatHands[currSeat - 1].setIcon(new javax.swing.ImageIcon(
                        getClass().getResource("/image/ClueBack.jpg")));
            }
            
            //check if inturn
            if (seats[currSeat].equalsName(turnPlayer))
            {
                seatTurnIndicator[currSeat].setBackground(inturn);

                //Check if selfPlayer has turn
                if (currSeat == 0)
                {
                    seatPanels[currSeat].setBorder(selfPlayerInturnBorder);
                    PanelButtons.setBorder(inturnButtonBorder);
                    selfPlayerSeat.setBackground(inturn);
                    drawButton.setEnabled(!(state.hasDrawn()));
                    jLabel1.setVisible(true);
                }
                else
                {
                    seatPanels[currSeat].setBorder(inturnBorder);
                }
            }
            else
            {
                //Check if player is out
                if (!seats[currSeat].isInGame())
                {
                    seatTurnIndicator[currSeat].setBackground(outedPlayer);
                }
                //use out of turn
                else
                {
                    seatTurnIndicator[currSeat].setBackground(outturn);
                }
                //Check if user
                if (currSeat == 0)
                {
                    seatPanels[currSeat].setBorder(selfPlayerOutturnBorder);
                    PanelButtons.setBorder(outturnButtonBorder);
                    selfPlayerSeat.setBackground(outturn);
                    //check if user is out
                    if (!seats[currSeat].isInGame())
                    {
                        selfPlayerSeat.setBackground(outedPlayer);
                    }
                    actionCard1Button.setEnabled(false);
                    actionCard2Button.setEnabled(false);
                    drawButton.setEnabled(false);
                    accuseButton.setEnabled(false);
                    endTurnButton.setEnabled(false);
                    jLabel1.setVisible(false);
                }
                else
                {
                    seatPanels[currSeat].setBorder(outturnBorder);
                }
            }
        }
    }

    /**
     * Update Action Card in player's hand
     */
    private void updateActionCards()
    {
        List<ActionCard> actionCards = state.getSelfPlayer().getHand().getActionCards();
        int numCard = 0;

        //FOR each action card in the player's hand
        for (ActionCard card : actionCards)
        {
            //Set icon and enable
            actionCardButtons[numCard].setIcon(new ImageIcon(getClass().getResource((card.getImagePath()))));
            actionCardButtons[numCard++].setEnabled(state.hasDrawn());
        }
        //ENDFOR

        //IF there is only one action card
        if (numCard == 1)
        {
            //REMOVE icon on second button and disable
            actionCardButtons[numCard].setIcon(null);
            actionCard2Button.setEnabled(false);

            //IF action card was not chosen 
            if (state.getChosenActionCard() != null)
            {
                actionCard1Button.setEnabled(false);
            }
        }
    }

    /**
     * Returns the table for children windows to use
     *
     * @return the table model of the game
     */
    public Table getTable()
    {
        return state.getTable();
    }

    /**
     * Returns the state of the game for children windows to use
     *
     * @return the GameState model
     */
    public GameState getGameState()
    {
        return state;
    }
    
    /**
     * Gets the accuse button.
     * 
     * @return accuse button
     */
    public javax.swing.JButton getAccuseButton()
    {
        return accuseButton;
    }
    /**
     * Gets the first action card button.
     * 
     * @return the first action card button
     */
    public javax.swing.JButton getActionCard1Button()
    {
        return actionCard1Button;
    }
    /**
     * Gets the second action card button.
     * 
     * @return the second action card button
     */
    public javax.swing.JButton getActionCard2Button()
    {
        return actionCard2Button;
    }
    /**
     * Gets the draw button.
     * 
     * @return the draw button
     */
    public javax.swing.JButton getDrawButton()
    {
        return drawButton;
    }
    /**
     * Gets the end turn button.
     * 
     * @return the end turn button
     */
    public javax.swing.JButton getEndTurnButton()
    {
        return endTurnButton;
    }
    /**
     * Gets the notepad button.
     * 
     * @return the notepad button
     */
    public javax.swing.JButton getNotepadButton()
    {
        return notepadButton;
    }
    /**
     * Gets the rules button.
     * 
     * @return the rules button
     */
    public javax.swing.JButton getRulesButton()
    {
        return rulesButton;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LabelHistory;
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelHistory;
    private javax.swing.JPanel PanelPlayer1Cards;
    private javax.swing.JPanel PanelTable;
    private javax.swing.JScrollPane TextHistory;
    private javax.swing.JButton accuseButton;
    private javax.swing.JButton actionCard1Button;
    private javax.swing.JButton actionCard2Button;
    private javax.swing.JLabel actionCardDirections;
    private javax.swing.JLabel dmLabel;
    private javax.swing.JButton drawButton;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton notepadButton;
    private javax.swing.JButton rulesButton;
    private javax.swing.JPanel seat1;
    private javax.swing.JLabel seat1CardCount;
    private javax.swing.JLabel seat1DM;
    private javax.swing.JLabel seat1Hand;
    private javax.swing.JLabel seat1Name;
    private javax.swing.JPanel seat1TurnIndicator;
    private javax.swing.JPanel seat2;
    private javax.swing.JLabel seat2CardCount;
    private javax.swing.JLabel seat2DM;
    private javax.swing.JLabel seat2Hand;
    private javax.swing.JLabel seat2Name;
    private javax.swing.JPanel seat2TurnIndicator;
    private javax.swing.JPanel seat3;
    private javax.swing.JLabel seat3CardCount;
    private javax.swing.JLabel seat3DM;
    private javax.swing.JLabel seat3Hand;
    private javax.swing.JLabel seat3Name;
    private javax.swing.JPanel seat3TurnIndicator;
    private javax.swing.JPanel seat4;
    private javax.swing.JLabel seat4CardCount;
    private javax.swing.JLabel seat4DM;
    private javax.swing.JLabel seat4Hand;
    private javax.swing.JLabel seat4Name;
    private javax.swing.JPanel seat4TurnIndicator;
    private javax.swing.JLabel selfPlayerClue1;
    private javax.swing.JLabel selfPlayerClue2;
    private javax.swing.JLabel selfPlayerClue3;
    private javax.swing.JLabel selfPlayerClue4;
    private javax.swing.JLabel selfPlayerClue5;
    private javax.swing.JLabel selfPlayerClue6;
    private javax.swing.JLabel selfPlayerDM;
    private javax.swing.JLabel selfPlayerName;
    private javax.swing.JPanel selfPlayerSeat;
    private javax.swing.JPanel selfPlayerTurnIndicator;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextArea textHistoryArea;
    // End of variables declaration//GEN-END:variables
}
