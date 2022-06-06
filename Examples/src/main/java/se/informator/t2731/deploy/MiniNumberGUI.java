package se.informator.t2731.deploy;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MiniNumberGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel numberPanel = new JPanel();
	JButton[] numberJB;
	JTextField outputJTF = new JTextField();
	Font boldFont = new Font("SanSerif", Font.BOLD, 16);
	
	MiniNumberModel theModel;
	
	public MiniNumberGUI(MiniNumberModel model){
		theModel = model;

		this.setLayout(new BorderLayout());
		
		numberPanel.setLayout(new GridLayout(4, 5));
		numberJB = new JButton[20];
		for(int i=0; i<numberJB.length; i++){
			numberJB[i] = new JButton(String.valueOf(i+1));
			numberJB[i].addActionListener(new ButtonActionListener());
			numberPanel.add(numberJB[i]);
		}
		
		this.add(numberPanel, BorderLayout.CENTER);
		
		outputJTF.setFont(boldFont);
		this.add(outputJTF, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			JButton temp = (JButton)ae.getSource();

			int guess = Integer.parseInt(temp.getText());
			theModel.setGuess(guess);
			theModel.setGuessListValue(guess);
			
			// call evaluation routine
    		String output = theModel.evaluation();
    		outputJTF.setText(output);
    		
    		if(output.equals("Correct!")){
    			JOptionPane.showMessageDialog(MiniNumberGUI.this, 
    					"Hurrah!", 
    					"Game msg", 
    					JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			else{
				if(theModel.isGameOver()){
					JOptionPane.showMessageDialog(MiniNumberGUI.this, 							
							"Game Over, correct value was " + theModel.getSecretNumber(),
							"Game msg",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				temp.setEnabled(false);
			}
		}
		
	}
}
