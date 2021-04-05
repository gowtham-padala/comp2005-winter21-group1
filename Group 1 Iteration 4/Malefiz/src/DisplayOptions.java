import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class DisplayOptions extends JFrame {

	private JPanel contentPane;
	private LinkedList<Player> players;
	private String value;


	public DisplayOptions(LinkedList<Player> var0) {
		this.players=var0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel board = new JLabel("Board theme:");
		board.setFont(new Font("Tahoma", Font.PLAIN, 17));
		board.setBounds(110, 10, 117, 21);
		contentPane.add(board);

		JComboBox boardSelection = new JComboBox();
		boardSelection.setModel(new DefaultComboBoxModel(new String[] {"Default", "Ocean", "Dark", "Light", "None"}));
		boardSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boardSelection.setBounds(120, 41, 88, 29);

		boardSelection.addActionListener(e->{
			if(boardSelection.getSelectedItem().equals("Ocean")){
				value="Ocean";
			}else if(boardSelection.getSelectedItem().equals("Dark")){
				value="Dark";
			}else if(boardSelection.getSelectedItem().equals("Light")){
				value="Light";
			}else{
				value=null;
			}
		});


		contentPane.add(boardSelection);

		JLabel window = new JLabel("Window size:");
		window.setFont(new Font("Tahoma", Font.PLAIN, 17));
		window.setBounds(110, 80, 117, 21);
		contentPane.add(window);

		JComboBox windowSelection = new JComboBox();
		windowSelection.setModel(new DefaultComboBoxModel(new String[] {"Default", "Small", "Medium", "Large"}));
		windowSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		windowSelection.setBounds(120, 111, 88, 29);
		contentPane.add(windowSelection);

		JLabel pawn = new JLabel("Pawn theme:");
		pawn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pawn.setBounds(110, 150, 117, 21);
		contentPane.add(pawn);

		JComboBox pawnSelection = new JComboBox();
		pawnSelection.setModel(new DefaultComboBoxModel(new String[] {"Default", "Numbers", "Symbols", "None"}));
		pawnSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pawnSelection.setBounds(120, 179, 88, 29);
		contentPane.add(pawnSelection);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 229, 326, 2);
		contentPane.add(separator);

		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainBoard mb = new mainBoard(players,value);
				mb.setVisible(true);
				System.out.println(value);
			}
		});
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		startButton.setBounds(120, 244, 86, 29);
		contentPane.add(startButton);

	}
}
