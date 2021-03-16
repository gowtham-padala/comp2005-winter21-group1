import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class mainBoard extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
					mainBoard frame = new mainBoard();
					frame.setVisible(true);
	}


	public mainBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 730);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem item1 = new JMenuItem("New Game");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	dispose();
	        	NewGameWin ng = new NewGameWin();
	        	ng.setVisible(true);
			}
		});
		menu.add(item1);
		
		JMenuItem item2 = new JMenuItem("Save Game");
		menu.add(item2);
		
		JMenuItem item3 = new JMenuItem("Load Game");
		menu.add(item3);
		
		JMenuItem item4 = new JMenuItem("Help");
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help hp = new help();
				hp.setVisible(true);
			}
		});
		menu.add(item4);
		
		JMenuItem item5 = new JMenuItem("Quit Game");
		menu.add(item5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 595, 636, 76);
		contentPane.add(panel);
		
		JLabel dice = new JLabel("Dice : 0");
		dice.setForeground(Color.WHITE);
		dice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dice.setBounds(566, 26, 60, 20);
		panel.add(dice);
		
		JButton rollBtn = new JButton("Roll");
		rollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int randint = rand.nextInt(6)+1;
				dice.setText("Dice : "+randint);
			}
		});
		rollBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rollBtn.setBounds(10, 26, 60, 26);
		panel.add(rollBtn);
		
		JLabel p4l4 = new JLabel("Player 4\r\n\r\n");
		p4l4.setForeground(Color.GREEN);
		p4l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p4l4.setBounds(458, 30, 60, 21);
		panel.add(p4l4);
		
		JLabel p1l1 = new JLabel("Player 1\r\n\r\n");
		p1l1.setForeground(Color.RED);
		p1l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p1l1.setBounds(106, 30, 60, 21);
		panel.add(p1l1);
		
		JLabel p2l2 = new JLabel("Player 2\r\n\r\n");
		p2l2.setForeground(Color.BLUE);
		p2l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p2l2.setBounds(226, 30, 60, 21);
		panel.add(p2l2);
		
		JLabel p3l3 = new JLabel("Player 3\r\n\r\n");
		p3l3.setForeground(Color.YELLOW);
		p3l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p3l3.setBounds(342, 30, 60, 21);
		panel.add(p3l3);
		setResizable(false);
	}
}
