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
	private int playerTurn=1;
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

	//private ImageIcon pawn=new ImageIcon("./pawn.jpg");
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
				{1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,2,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,1,1,2,1,1,1,2,1,1,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
				{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
				{0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
				{2,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,2},
				{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,3,0,0,0,4,0,0,0,5,0,0,0,6,0,0},
				{0,3,3,3,0,4,4,4,0,5,5,5,0,6,6,6,0},
				{0,0,3,0,0,0,4,0,0,0,5,0,0,0,6,0,0}
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
				else if (map[i][j]==3)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(players.get(0).getColor());
					centre_panel.add(squares[i][j]);
				}
				else if (map[i][j]==4)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(players.get(1).getColor());
					centre_panel.add(squares[i][j]);
				}
				else if (map[i][j]==5)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(players.get(2).getColor());
					centre_panel.add(squares[i][j]);
				}
				else if (map[i][j]==6)
				{
					squares[i][j] = new JButton();
					squares[i][j].setBackground(players.get(3).getColor());
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
		JLabel label0 = new JLabel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel[] label = new JLabel[] { label0, label1, label2, label3};
		for (int i=0;i<players.size();i++) {
			label[i].setText(players.get(i).getName() + "\r\n\r\n");
			label[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			label[i].setBounds(106, 30, 100, 21);
			if(i==0) {
				label[i].setForeground(Color.RED);
			}
			if(i==1) {
				label[i].setForeground(Color.blue);
			}
			if(i==2) {
				label[i].setForeground(Color.yellow);
			}
			if(i==3) {
				label[i].setForeground(Color.green);
			}
			bottom_panel.add(label[i]);
		}


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
				turn++;
				playerTurn = (turn%players.size())+1;
				playerTurnLabel.setText("Player "+ playerTurn + "'s turn");
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
		int newRow=Math.abs(row-i);
		int newCol=Math.abs(col-j);
		if (validRow==newRow ||validCol==newCol|| validRow==newRow+newCol||validCol==newRow+newCol  ){
			return true;
		}

		return false;

	}
	public void processClick(int i, int j){
		/*if(validMovements(i,j)==false){
			return;
		}*/

		squares[row][col].setBackground(Color.pink);
		squares[i][j].setBackground(players.get(playerTurn-1).getColor());
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


