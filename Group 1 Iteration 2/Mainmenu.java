package malefizMinor1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mainmenu extends JFrame
{
    private newGame myGame;
    public Mainmenu()
    {
        super("");
        makeFrame();
        myGame =new newGame();
    }


    private void makeFrame()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel myPanel_1= new JPanel();
        myPanel_1.setLayout(new FlowLayout());
        myPanel_1.setBorder(new EmptyBorder(30, 10, 50, 10));
        JPanel myPanel_2= new JPanel();
        myPanel_2.setBorder(new EmptyBorder(40, 10, 30, 10));
        myPanel_2.setLayout(new FlowLayout());
        JPanel myPanel_3= new JPanel();
        myPanel_3.setBorder(new EmptyBorder(20, 10, 20, 10));
        myPanel_3.setLayout(new FlowLayout());
        JLabel title = new JLabel("Malefiz");
        title.setSize(300,300);
        title.setFont(new Font("Arial", Font.PLAIN, 100));
        JButton startGame=new JButton("Start Game");
        startGame.setPreferredSize(new Dimension(150, 50));
        startGame.setFont(new Font("Arial", Font.PLAIN, 20));
        startGame.setBackground(Color.DARK_GRAY);
        startGame.setForeground(Color.WHITE);
        JButton loadGame=new JButton("Load Game");
        loadGame.setPreferredSize(new Dimension(150, 50));
        loadGame.setFont(new Font("Arial", Font.PLAIN, 20));
        loadGame.setBackground(Color.DARK_GRAY);
        loadGame.setForeground(Color.WHITE);
        JButton help=new JButton("Help");
        help.setPreferredSize(new Dimension(120, 40));
        help.setFont(new Font("Arial", Font.PLAIN, 15));
        startGame.addActionListener(e -> {
        	this.dispose();
        	newGame ng = new newGame();
        	ng.frmNewGame.setVisible(true);
        	});
        help.addActionListener(e -> {
            contentPane.removeAll();
            gameRules();
        });
        myPanel_1.add(title);
        myPanel_2.add(startGame);
        myPanel_2.add(loadGame);
        myPanel_3.add(help);
        myPanel_1.setBackground(Color.gray);
        myPanel_2.setBackground(Color.GRAY);
        myPanel_3.setBackground(Color.GRAY);

        contentPane.add(myPanel_1, BorderLayout.NORTH);
        contentPane.add(myPanel_2, BorderLayout.CENTER);
        contentPane.add(myPanel_3, BorderLayout.SOUTH);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);
        setVisible(true);
    }

    private void gameRules() {
        Container contentPane_2 = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        JLabel lblNewLabel = new JLabel("Game play and rules:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 10, 158, 23);
        contentPane_2.add(lblNewLabel);

        JTextPane txtpnAtTheBeginning = new JTextPane();
        txtpnAtTheBeginning.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnAtTheBeginning.setText("At the beginning of each turn, the active player rolls the die. That player selects one of her five pawns and moves it a number of steps equal to the number shown on the die. That pawn may begin traveling in any direction and may turn to continue through corners in the path, but it may not double-back along its course, and it may not forgo any steps. The spaces within the players' houses are not counted against the die-roll; the first space counted by any pawn is the space immediately above the house.\r\n\r\nDuring the course of a move, a pawn may pass other pawns (regardless of colour) with no effect. In the event that a pawn finishes its move by landing on a space occupied by another pawn, the pawn occupying that space is captured. Captured pawns are returned to their respective houses and become available to rejoin play upon their owner's next turn.\r\n\r\nUnlike pawns, barricade pieces may not be passed. In order for play to progress past a barricade, the barricade must be captured by a pawn. A player who captures a barricade must relocate the barrier to an unoccupied space on the board. Barricades may not be placed in the four houses or in any of the 17 spaces in the bottom-most row.\r\n\r\nA pawn may not be moved if doing so would cause it either to pass a barricade or to overshoot the uppermost space on the board.\r\n\r\nAfter the move is complete, play passes to the next player.\r\n\r\nA player may forgo her move if and only if none of her pawns may be moved.\r\n\r\nWin condition:\r\nThe first player to land a pawn in the uppermost space is the winner.");
        txtpnAtTheBeginning.setBounds(20, 43, 556, 594);
        contentPane_2.add(txtpnAtTheBeginning);
    }
}