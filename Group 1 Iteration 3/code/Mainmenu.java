

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
            help hp = new help();
            hp.setVisible(true);
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

}
