import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.math.*;

public class mainBoard extends JFrame{
	private JPanel top_panel;
	private JPanel centre_panel;
	private JPanel bottom_panel;
	private JButton [][] squares=new JButton[17][17];
	private int row=16;
	private int col=3;


	private ImageIcon pawn=new ImageIcon("./pawn.jpg");

	public mainBoard()
	{

		Container contentPane = getContentPane();
		setBounds(100, 100, 600, 600);
		contentPane.setLayout(new BorderLayout());
		top_panel=new JPanel();
		centre_panel=new JPanel();
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
		JLabel playerTurnLabel=new JLabel("Here We will Show the Turn");
		top_panel.add(playerTurnLabel);

		centre_panel.setLayout(new GridLayout(17,17));
		for(int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
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
		}
		squares[row][col].setBackground(Color.red);

		bottom_panel.setLayout(new FlowLayout());

		JButton rollBtn = new JButton("Roll");

		rollBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rollBtn.setBounds(5, 26, 60, 26);
		bottom_panel.add(rollBtn);

		JLabel p1l1 = new JLabel("Player 1\r\n\r\n");
		p1l1.setForeground(Color.RED);
		p1l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p1l1.setBounds(106, 30, 100, 21);
		bottom_panel.add(p1l1);

		JLabel p2l2 = new JLabel("Player 2\r\n\r\n");
		p2l2.setForeground(Color.BLUE);
		p2l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p2l2.setBounds(226, 30, 100, 21);
		bottom_panel.add(p2l2);

		JLabel p3l3 = new JLabel("Player 3\r\n\r\n");
		p3l3.setForeground(Color.YELLOW);
		p3l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p3l3.setBounds(342, 30, 100, 21);
		bottom_panel.add(p3l3);

		JLabel p4l4 = new JLabel("Player 4\r\n\r\n");
		p4l4.setForeground(Color.GREEN);
		p4l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		p4l4.setBounds(458, 30, 100, 21);
		bottom_panel.add(p4l4);
		JLabel dice = new JLabel("Dice : 0");
		dice.setForeground(Color.WHITE);
		dice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dice.setBounds(566, 26, 100, 20);
		bottom_panel.add(dice);
		rollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int randint = rand.nextInt(6)+1;
				dice.setText("Dice : "+randint);
			}
		});
		bottom_panel.setBackground(Color.darkGray);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);//shows the window on centre
	}
	public boolean validMovements(int i, int j){

		int validRow=Math.abs(i-row);
		int validCol=Math.abs(i-row);
		if (validRow==1 ){
			return true;
		}
		if (validCol==1){
			return true;
		}
		return false;

	}
	public void processClick(int i, int j){
		if(validMovements(i,j)==false){
			return;
		}
		squares[row][col].setBackground(Color.PINK);
		squares[i][j].setBackground(Color.red);
		row=i;
		col=j;
	}

}


