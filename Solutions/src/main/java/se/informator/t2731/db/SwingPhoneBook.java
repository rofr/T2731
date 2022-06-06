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
		thePhoneBook = pb;
		
		this.setLayout(new BorderLayout());
		
		infoPanel.setLayout(new GridLayout(2, 2));
		infoPanel.add(nameJL);
		infoPanel.add(nameJTF);
		infoPanel.add(numberJL);
		infoPanel.add(numberJTF);
		this.add(infoPanel, BorderLayout.CENTER);
		
		controlPanel.setLayout(new FlowLayout());
		lookUpJB.addActionListener(new AppActionListener());
		controlPanel.add(lookUpJB);
		addJB.addActionListener(new AppActionListener());
		controlPanel.add(addJB);
		resetJB.addActionListener(new AppActionListener());
		controlPanel.add(resetJB);
		exitJB.addActionListener(new AppActionListener());
		controlPanel.add(exitJB);
		this.add(controlPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
	class AppActionListener implements ActionListener{

		public void actionPerformed(ActionEvent ae) {
			
			String name = nameJTF.getText();
			String number = numberJTF.getText();
			JButton temp =(JButton)ae.getSource();
			
			if(temp == lookUpJB){
				if(name.isEmpty()){
					// add warning message
					JOptionPane.showMessageDialog(
							SwingPhoneBook.this, 
							"Name missing!",
							"Input Control Message",
							JOptionPane.WARNING_MESSAGE
							);
				}
				else{
					number = thePhoneBook.findNumber(name);
					if(number.isEmpty()){
						// add info message
						JOptionPane.showMessageDialog(
								SwingPhoneBook.this, 
								"No entry found!",
								"Input Control Message",
								JOptionPane.INFORMATION_MESSAGE
								);
					}
					else{
						numberJTF.setText(number);
					}
				}
			}
			
			if(temp == addJB){
				if(name.isEmpty() || number.isEmpty()){
					// add warning message
					JOptionPane.showMessageDialog(
							SwingPhoneBook.this, 
							"Name or number missing!",
							"Input Control Message",
							JOptionPane.WARNING_MESSAGE
							);					
				}
				else{
					if(thePhoneBook.findNumber(name).equals("")){
						thePhoneBook.addNameAndNumber(name, number);
					}
					else{
						// add error message
						JOptionPane.showMessageDialog(
								SwingPhoneBook.this, 
								"Entry already exists!",
								"Input Control Message",
								JOptionPane.ERROR_MESSAGE
								);
					}
				}			
			}			
			if(temp == resetJB){
				nameJTF.setText("");
				numberJTF.setText("");
			}
			
            if(temp == exitJB){
            	// add option dialog
                String[] options={"Yes", "No"};
                int answer=JOptionPane.showOptionDialog(SwingPhoneBook.this, "Do you really want to exit",
                        "Exit message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                if(answer==0){
                	thePhoneBook.shutDown();
                    System.exit(0);
                }
            }		
		}		
	}	
}

