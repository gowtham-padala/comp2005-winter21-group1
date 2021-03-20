import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class help extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
					help frame = new help();
					frame.setVisible(true);
	}

	public help() {
		
		setTitle("Help");
		setBounds(100, 100, 600, 700);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Game play and rules:");
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(10, 10, 158, 23);
		getContentPane().add(label);
		
		JTextPane text = new JTextPane();
		text.setEditable(false);
		text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text.setText("At the beginning of each turn, the active player rolls the die. That player selects one of her five pawns and moves it a number of steps equal to the number shown on the die. That pawn may begin traveling in any direction and may turn to continue through corners in the path, but it may not double-back along its course, and it may not forgo any steps. The spaces within the players' houses are not counted against the die-roll; the first space counted by any pawn is the space immediately above the house.\r\n\r\nDuring the course of a move, a pawn may pass other pawns (regardless of colour) with no effect. In the event that a pawn finishes its move by landing on a space occupied by another pawn, the pawn occupying that space is captured. Captured pawns are returned to their respective houses and become available to rejoin play upon their owner's next turn.\r\n\r\nUnlike pawns, barricade pieces may not be passed. In order for play to progress past a barricade, the barricade must be captured by a pawn. A player who captures a barricade must relocate the barrier to an unoccupied space on the board. Barricades may not be placed in the four houses or in any of the 17 spaces in the bottom-most row.\r\n\r\nA pawn may not be moved if doing so would cause it either to pass a barricade or to overshoot the uppermost space on the board.\r\n\r\nAfter the move is complete, play passes to the next player.\r\n\r\nA player may forgo her move if and only if none of her pawns may be moved.\r\n\r\nWin condition:\r\nThe first player to land a pawn in the uppermost space is the winner.");
		text.setBounds(20, 43, 556, 594);
		getContentPane().add(text);
		
		
	}

}
