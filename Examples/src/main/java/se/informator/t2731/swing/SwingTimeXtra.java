/*  Source file  : SwingTimeXtra.java
    Programmer   : Kjell H Carlsson
    Last updated : 2006-10-10
*/

package se.informator.t2731.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTimeXtra extends JFrame{

	private static final long serialVersionUID = 1L;
	// GUI attributes
	private JPanel controlPanel = new JPanel();
	private JButton lastTimeJB = new JButton("Last");
	private JButton resetTimeJB = new JButton("Reset");
	private JButton nextTimeJB = new JButton("Next");
	private JButton exitAppJB = new JButton("Exit");

	private JPanel timePanel=new JPanel();
	private JLabel hourJL=new JLabel("Hour", SwingConstants.CENTER);
	private JLabel minJL=new JLabel("Min", SwingConstants.CENTER);
	private JLabel secJL=new JLabel("Sec", SwingConstants.CENTER);

	private JTextField hourJTF=new JTextField();
	private JTextField minJTF=new JTextField();
	private JTextField secJTF=new JTextField();

	// model attribute
    private Timemodel now;

    // constructor
    public SwingTimeXtra(Timemodel t1){

        now=t1;

        // set application layout
        this.setLayout(new BorderLayout());

        // center panel holds current Time info
        timePanel.setLayout(new GridLayout(2,3));

        // upper row holds the labels
        hourJL.setOpaque(true);
        hourJL.setBackground(Color.green);
        timePanel.add(hourJL);

        minJL.setOpaque(true);
        minJL.setBackground(Color.green);
        timePanel.add(minJL);

        secJL.setOpaque(true);
        secJL.setBackground(Color.green);
        timePanel.add(secJL);

        // lower row holds the textfields
        hourJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        hourJTF.setBackground(Color.white);
        hourJTF.setEditable(false);
        timePanel.add(hourJTF);

        minJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        minJTF.setBackground(Color.white);
        minJTF.setEditable(false);
        timePanel.add(minJTF);

        secJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        secJTF.setBackground(Color.white);
        secJTF.setEditable(false);
        timePanel.add(secJTF);
        updateView();
        
        this.add(timePanel, BorderLayout.CENTER);

        // southern panel holds control buttons
        controlPanel.setLayout(new FlowLayout());

        // add action listeners, tooltips and speed keys + add to panel
        lastTimeJB.addActionListener(new AppActionListener());
        lastTimeJB.setToolTipText("Tick 1 second backwards");
        lastTimeJB.setMnemonic('L');
        controlPanel.add(lastTimeJB);

        resetTimeJB.addActionListener(new AppActionListener());
        resetTimeJB.setToolTipText("Reset time parameters");
        resetTimeJB.setMnemonic('R');
        controlPanel.add(resetTimeJB);

        nextTimeJB.addActionListener(new AppActionListener());
        nextTimeJB.setToolTipText("Tick 1 second forwards");
        nextTimeJB.setMnemonic('N');
        controlPanel.add(nextTimeJB);

        exitAppJB.addActionListener(new AppActionListener());
        exitAppJB.setToolTipText("Exit application");
        exitAppJB.setMnemonic('E');
        controlPanel.add(exitAppJB);        

        this.add(controlPanel, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void updateView(){
        hourJTF.setText(String.valueOf(now.getHour()));
        minJTF.setText(String.valueOf(now.getMin()));
        secJTF.setText(String.valueOf(now.getSec()));
    }
    
    // inner class that handles user events
    class AppActionListener implements ActionListener{

      public void actionPerformed(ActionEvent ae){

         JButton temp=(JButton)ae.getSource();

         // exit application
         if(temp==exitAppJB){
              JOptionPane.showMessageDialog(
            		  SwingTimeXtra.this, 
            		  "You are now exiting the application", 
            		  "User information",
                      JOptionPane.PLAIN_MESSAGE, 
                      null);
              System.exit(0);
         }
         // calc previous time via call to model
         if(temp==lastTimeJB){
             now=now.last();
             updateView();               
         }
         // calc next time via call to model
         if(temp==nextTimeJB){
             now=now.next();
             updateView();  
         }

         // reset time to noon
         if(temp==resetTimeJB){
             // assign new value to now
             now=new Timemodel(12, 0, 0);
             updateView();
         }
      }
    }

    // test routine
    public static void main(String args[]){

    	Runnable swingRunner = new Runnable(){        
    		public void run(){
    			Timemodel t1=new Timemodel(15, 22, 51);
    			JFrame jf=new SwingTimeXtra(t1);
    			jf.setTitle("SwingTimeXtra");
    			jf.pack();
    			jf.setVisible(true);
    		}
    	};
    	SwingUtilities.invokeLater(swingRunner);
    }
}