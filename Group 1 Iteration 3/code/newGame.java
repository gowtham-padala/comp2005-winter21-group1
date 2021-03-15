



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newGame{

    public JFrame frmNewGame;
    private JTextField name_1;
    private JTextField name_2;
    private JTextField name_3;
    private JTextField name_4;
    private String players_details;
    private Board gameboard;


    public newGame() {
        initialize();
        gameboard = new Board();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frmNewGame = new JFrame();
        frmNewGame.setResizable(false);
        frmNewGame.setTitle("New Game");
        frmNewGame.setBounds(100, 100, 410, 390);
        frmNewGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmNewGame.getContentPane().setLayout(null);

        JLabel main_title = new JLabel("Players");
        main_title.setFont(new Font("Tahoma", Font.PLAIN, 15));
        main_title.setBounds(10, 10, 69, 19);
        frmNewGame.getContentPane().add(main_title);

        JLabel choice_title = new JLabel("Choice");
        choice_title.setFont(new Font("Tahoma", Font.PLAIN, 13));
        choice_title.setBounds(20, 39, 45, 13);
        frmNewGame.getContentPane().add(choice_title);


        JComboBox type_1 = new JComboBox();
        type_1.setEnabled(false);
        type_1.setModel(new DefaultComboBoxModel(new String[] {"Human", "System"}));
        type_1.setSelectedIndex(0);
        type_1.setBounds(117, 69, 77, 21);
        frmNewGame.getContentPane().add(type_1);

        JComboBox type_2 = new JComboBox();

        type_2.setModel(new DefaultComboBoxModel(new String[] {"Human", "System"}));
        type_2.setSelectedIndex(1);
        type_2.setBounds(117, 115, 77, 21);
        frmNewGame.getContentPane().add(type_2);

        JComboBox type_3 = new JComboBox();
        type_3.setEnabled(false);
        type_3.setModel(new DefaultComboBoxModel(new String[] {"Human", "System"}));
        type_3.setBounds(117, 161, 77, 21);
        frmNewGame.getContentPane().add(type_3);

        JComboBox type_4 = new JComboBox();
        type_4.setEnabled(false);
        type_4.setModel(new DefaultComboBoxModel(new String[] {"Human", "System"}));
        type_4.setToolTipText("");
        type_4.setBounds(117, 207, 77, 21);
        frmNewGame.getContentPane().add(type_4);

        JLabel name_title = new JLabel("Player Name");
        name_title.setFont(new Font("Tahoma", Font.PLAIN, 13));
        name_title.setBounds(223, 39, 78, 13);
        frmNewGame.getContentPane().add(name_title);

        name_1 = new JTextField();
        name_1.setText("Human 1");
        name_1.setBounds(210, 69, 96, 19);
        frmNewGame.getContentPane().add(name_1);
        name_1.setColumns(10);

        name_2 = new JTextField();
        name_2.setText("Computer 1");
        name_2.setBounds(210, 115, 96, 19);
        frmNewGame.getContentPane().add(name_2);
        name_2.setColumns(10);

        name_3 = new JTextField();
        name_3.setEnabled(false);
        name_3.setBounds(210, 161, 96, 19);
        frmNewGame.getContentPane().add(name_3);
        name_3.setColumns(10);

        name_4 = new JTextField();
        name_4.setEnabled(false);
        name_4.setBounds(210, 207, 96, 19);
        frmNewGame.getContentPane().add(name_4);
        name_4.setColumns(10);

        JLabel level_title = new JLabel("Level");
        level_title.setFont(new Font("Tahoma", Font.PLAIN, 13));
        level_title.setBounds(329, 39, 38, 13);
        frmNewGame.getContentPane().add(level_title);

        JComboBox level_1 = new JComboBox();
        level_1.setEnabled(false);
        level_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
        level_1.setBounds(327, 69, 38, 21);
        frmNewGame.getContentPane().add(level_1);

        JComboBox level_2 = new JComboBox();
        level_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
        level_2.setBounds(327, 115, 38, 21);
        frmNewGame.getContentPane().add(level_2);

        JComboBox level_3 = new JComboBox();
        level_3.setEnabled(false);
        level_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
        level_3.setBounds(327, 161, 38, 21);
        frmNewGame.getContentPane().add(level_3);

        JComboBox level_4 = new JComboBox();
        level_4.setEnabled(false);
        level_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
        level_4.setBounds(327, 207, 38, 21);
        frmNewGame.getContentPane().add(level_4);

        JCheckBox choice_box_1 = new JCheckBox("");
		choice_box_1.setEnabled(false);
		choice_box_1.setSelected(true);
        choice_box_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(choice_box_1.isSelected()) {
        			type_1.setEnabled(true);
        			name_1.setEnabled(true);
        		}
        		else {
        			type_1.setEnabled(false);
        			name_1.setEnabled(false);        			
        		}
        	}
        });
        choice_box_1.setBounds(32, 69, 21, 21);
        frmNewGame.getContentPane().add(choice_box_1);

        JCheckBox choice_box_2 = new JCheckBox("");
		choice_box_2.setEnabled(false);
		choice_box_2.setSelected(true);
        choice_box_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(choice_box_2.isSelected()){
                    type_2.setEnabled(true);
                    name_2.setEnabled(true);
                }
                else {
                    type_2.setEnabled(false);
                    name_2.setEnabled(false);
                    level_2.setEnabled(false);
                }
            }
        });
        choice_box_2.setBounds(32, 115, 21, 21);
        frmNewGame.getContentPane().add(choice_box_2);

        JCheckBox choice_box_3 = new JCheckBox("");
        choice_box_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(choice_box_3.isSelected()){
                    type_3.setEnabled(true);
                    name_3.setEnabled(true);
                }
                else {
                    type_3.setEnabled(false);
                    name_3.setEnabled(false);
                    level_3.setEnabled(false);
                }
            }
        });
        choice_box_3.setBounds(32, 161, 21, 21);
        frmNewGame.getContentPane().add(choice_box_3);

        JCheckBox choice_box_4 = new JCheckBox("");
        choice_box_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(choice_box_4.isSelected()){
                    type_4.setEnabled(true);
                    name_4.setEnabled(true);
                }
                else {
                    type_4.setEnabled(false);
                    name_4.setEnabled(false);
                    level_4.setEnabled(false);
                }
            }
        });
        choice_box_4.setBounds(32, 207, 21, 21);
        frmNewGame.getContentPane().add(choice_box_4);

        JLabel color_title = new JLabel("Color");
        color_title.setFont(new Font("Tahoma", Font.PLAIN, 13));
        color_title.setBounds(75, 40, 38, 13);
        frmNewGame.getContentPane().add(color_title);

        Canvas color_1 = new Canvas();
        color_1.setBackground(Color.RED);
        color_1.setBounds(82, 73, 14, 13);
        frmNewGame.getContentPane().add(color_1);

        Canvas color_2 = new Canvas();
        color_2.setBackground(Color.GREEN);
        color_2.setBounds(82, 118, 14, 13);
        frmNewGame.getContentPane().add(color_2);

        Canvas color_3 = new Canvas();
        color_3.setBackground(Color.ORANGE);
        color_3.setBounds(82, 164, 14, 13);
        frmNewGame.getContentPane().add(color_3);

        Canvas color_4 = new Canvas();
        color_4.setBackground(Color.CYAN);
        color_4.setBounds(82, 210, 14, 13);
        frmNewGame.getContentPane().add(color_4);

        JLabel type_title = new JLabel("Type");
        type_title.setFont(new Font("Tahoma", Font.PLAIN, 13));
        type_title.setBounds(140, 39, 45, 13);
        frmNewGame.getContentPane().add(type_title);

        type_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type_2.getSelectedIndex()==0){
                    level_2.setEnabled(false);
                }
                else {
                    level_2.setEnabled(true);
                }
            }
        });

        type_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type_3.getSelectedIndex()==0){
                    level_3.setEnabled(false);
                }
                else {
                    level_3.setEnabled(true);
                }
            }
        });

        type_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(type_4.getSelectedIndex()==0){
                    level_4.setEnabled(false);
                }
                else {
                    level_4.setEnabled(true);
                }
            }
        });


        JSeparator separator = new JSeparator();
        separator.setBounds(10, 265, 376, 2);
        frmNewGame.getContentPane().add(separator);




        JButton start_button = new JButton("Next");
        start_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
       
                if(choice_box_1.isSelected()) {
                    players_details = players_details + "1 "+ type_1.getSelectedItem() + " " + name_1.getText() + " " + level_1.getSelectedItem()  + "\n" ;
                }

                if(choice_box_2.isSelected()) {
                    players_details = players_details + "2 "+ type_2.getSelectedItem() + " " + name_2.getText() + " " + level_2.getSelectedItem()  + "\n";
                }

                if(choice_box_3.isSelected()) {
                    players_details = players_details + "3 "+ type_3.getSelectedItem() + " " + name_3.getText() + " " + level_3.getSelectedItem()  + "\n" ;
                }

                if(choice_box_4.isSelected()) {
                    players_details = players_details + "4 "+ type_4.getSelectedItem() + " " + name_4.getText() + " " + level_4.getSelectedItem()  + "\n";
                }
                frmNewGame.dispose();
                DisplayOptions dp = new DisplayOptions();
                dp.setVisible(true);
                
            }
        });
        start_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        start_button.setBounds(49, 293, 129, 32);
        frmNewGame.getContentPane().add(start_button);

        JButton cancel_button = new JButton("Cancel");
        cancel_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cancel_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cancel_button.setBounds(213, 293, 129, 32);
        frmNewGame.getContentPane().add(cancel_button);
        
        frmNewGame.setVisible(false);
    }
}
