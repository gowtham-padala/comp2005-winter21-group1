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

public class DisplayOptions extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayOptions frame = new DisplayOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Board theme:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(110, 10, 117, 21);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default", "Ocean", "War", "Dark", "Light", "None"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(120, 41, 88, 29);
		contentPane.add(comboBox);
		
		JLabel lblWindowSize = new JLabel("Window size:");
		lblWindowSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWindowSize.setBounds(110, 80, 117, 21);
		contentPane.add(lblWindowSize);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Small", "Medium", "Large"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(120, 111, 88, 29);
		contentPane.add(comboBox_1);
		
		JLabel lblPawnTheme = new JLabel("Pawn theme:");
		lblPawnTheme.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPawnTheme.setBounds(110, 150, 117, 21);
		contentPane.add(lblPawnTheme);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Numbers", "Symbols", "None"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_1.setBounds(120, 179, 88, 29);
		contentPane.add(comboBox_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 229, 326, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mainBoard mb = new mainBoard();
				mb.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(120, 244, 86, 29);
		contentPane.add(btnNewButton);
	}
}
