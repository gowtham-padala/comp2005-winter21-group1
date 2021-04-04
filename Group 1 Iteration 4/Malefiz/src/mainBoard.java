import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.math.*;

public class mainBoard extends JFrame{
	private int turn = 0;
	private int display;
	private JPanel top_panel;
	private JPanel centre_panel;
	private JPanel bottom_panel;
	private JButton [][] squares=new JButton[17][17];
	private int row=15;
	private int col=2;
	private int[][] map;
	private int randint;
	private Dice dice=new Dice();
	private LinkedList<Player> players;

	private ImageIcon pawn=new ImageIcon("./pawn.jpg");
	private ImageIcon dices=createImageIcon("images/dice_1.png");

	public mainBoard(LinkedList<Player> var0)
	{
		this.players=var0;

		Container contentPane = getContentPane();
		setBounds(100, 100, 600, 600);
		contentPane.setLayout(new BorderLayout());
		top_panel=new JPanel();
		centre_panel=new JPanel();
		centre_panel.setLayout(new GridLayout());
		bottom_panel=new JPanel();
		contentPane.add(top_panel, BorderLayout.NORTH);
		contentPane.add(centre_panel, BorderLayout.CENTER);
		contentPane.add(bottom_panel,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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
		JLabel playerTurnLabel=new JLabel("Player 1's turn");
		top_panel.add(playerTurnLabel);

		centre_panel.setLayout(new GridLayout(17,17));
		int[][] map = {
				{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,3,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,1,1,3,1,1,1,3,1,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
				{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
				{0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
				{3,1,1,1,3,1,1,1,3,1,1,1,3,1,1,1,3},
				{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},
				{0,2,2,2,0,2,2,2,0,2,2,2,0,2,2,2,0},
				{0,0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0}
		};
		for(int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				if (map[i][j]==1)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(Color.PINK);
					centre_panel.add(squares[i][j]);
					int finalI = i;
					int finalJ = j;
					squares[i][j].addActionListener(e -> {
						processClick(finalI, finalJ);
						return;
					});
				}
				else if (map[i][j]==0)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(Color.BLACK);
					squares[i][j].setEnabled(false);
					centre_panel.add(squares[i][j]);
				}
				else if (map[i][j]==2)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(Color.GREEN);
					centre_panel.add(squares[i][j]);
				}
				else
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(Color.GRAY);
					centre_panel.add(squares[i][j]);
				}
			}
		}
		squares[row][col].setBackground(Color.red);

		bottom_panel.setLayout(new FlowLayout());

		JButton rollBtn = new JButton("Roll");

		rollBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rollBtn.setBounds(5, 26, 60, 26);
		bottom_panel.add(rollBtn);

		JLabel p1l1 = new JLabel(players.get(0).getName()+"\r\n\r\n");
		p1l1.setForeground(Color.RED);
		p1l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p1l1.setBounds(106, 30, 100, 21);
		bottom_panel.add(p1l1);

		JLabel p2l2 = new JLabel(players.get(1).getName()+"\r\n\r\n");
		p2l2.setForeground(Color.BLUE);
		p2l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p2l2.setBounds(226, 30, 100, 21);
		bottom_panel.add(p2l2);

		JLabel p3l3 = new JLabel(players.get(2).getName()+"\r\n\r\n");
		p3l3.setForeground(Color.YELLOW);
		p3l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p3l3.setBounds(342, 30, 100, 21);
		bottom_panel.add(p3l3);

		JLabel p4l4 = new JLabel(players.get(3).getName()+"\r\n\r\n");
		p4l4.setForeground(Color.GREEN);
		p4l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p4l4.setBounds(458, 30, 100, 21);
		bottom_panel.add(p4l4);

		JLabel diceimg = new JLabel();
		diceimg.setIcon(dices);
		bottom_panel.add(diceimg);
		rollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dice.roll();
				randint=dice.getRandint();
				ImageIcon dices= new ImageIcon("images/dice_"+randint+".png");
				diceimg.setIcon(dices);
				bottom_panel.add(diceimg);
				turn = turn + 1;
				display = turn%4+1;
				playerTurnLabel.setText("Player "+ display + "'s turn");
			}
		});
		bottom_panel.setBackground(Color.darkGray);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);//shows the window on centre
	}
	public boolean validMovements(int i, int j){

		int validRow=Math.abs(i-randint);
		int validCol=Math.abs(j-randint);

		if (validRow==(validRow+validCol) ){
			return true;
		}
		if (validCol==validRow+validCol){
			return true;
		}
		return false;

	}
	public void processClick(int i, int j){
		if(validMovements(i,j)==false){
			return;
		}
		squares[row][col].setBackground(Color.pink);
		squares[i][j].setBackground(Color.red);
		row=i;
		col=j;
	}
	private ImageIcon createImageIcon(final String name) {
		try {
			BufferedImage pictureID = ImageIO.read(new File(name));
			ImageIcon icon = new ImageIcon(pictureID);
			return icon;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}


