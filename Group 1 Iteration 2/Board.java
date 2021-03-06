package malefizMinor1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Board extends JFrame {
	
	private JPanel top_panel, center_panel;
	private JLabel text;
	private JButton saveGame, quitGame;
	
	
	
	public void Board () {
		
		this.setSize(600, 600);
		
		
		top_panel= new JPanel();
		top_panel.setLayout(new FlowLayout(0, 5, 5));
		
		saveGame= new JButton("Save Game");
		quitGame= new JButton("Quit Game");
		quitGame.addActionListener(e -> {
			this.dispose();
		});
		
		top_panel.add(saveGame);
		top_panel.add(quitGame);
		
		center_panel= new JPanel();
		
		text= new JLabel("The Board will be here");
		
		center_panel.add(text);
		center_panel.setBackground(Color.cyan);
		
		
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(top_panel, BorderLayout.NORTH);
		getContentPane().add(center_panel, BorderLayout.CENTER);
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);	
		
		
	}




	
	

}
