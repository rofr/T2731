package se.informator.t2731.db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingPhoneBook extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel infoPanel = new JPanel();
	private JLabel nameJL = new JLabel("Name", SwingConstants.CENTER);
	private JLabel numberJL = new JLabel("Number", SwingConstants.CENTER);
	private JTextField nameJTF = new JTextField();
	private JTextField numberJTF = new JTextField();
	
	private JPanel controlPanel = new JPanel();
	private JButton lookUpJB = new JButton("Look Up");
	private JButton addJB = new JButton("Add");
	private JButton resetJB = new JButton("Reset");
	private JButton exitJB = new JButton("Exit");
	
	private PhoneBook thePhoneBook; 
	
	public SwingPhoneBook(PhoneBook pb){
		// 	TODO: Add code here
	}
	
	class AppActionListener implements ActionListener{

		public void actionPerformed(ActionEvent ae) {
			// 	TODO: Add code here
        }			
	}	
}

