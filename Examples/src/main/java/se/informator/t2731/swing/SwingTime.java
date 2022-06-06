/*  Source file  : SwingTime.java
    Programmer   : Kjell H Carlsson
    Last updated : 2006-10-10
*/

package se.informator.t2731.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTime extends JFrame{

	private static final long serialVersionUID = 1L;
	// GUI attributes
	private JPanel controlPanel = new JPanel();
    private JButton lastTimeJB = new JButton("<<");
    private JButton resetTimeJB = new JButton("Reset");
    private JButton nextTimeJB = new JButton(">>");
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
    public SwingTime(Timemodel t1){

    	now=t1;

        // set application layout
        this.setLayout(new BorderLayout());

        // center panel holds current Time info
        timePanel.setLayout(new GridLayout(2,3));

        // upper row holds the labels
        hourJL.setOpaque(true);
        hourJL.setBackground(Color.GREEN);
        timePanel.add(hourJL);

        minJL.setOpaque(true);
        minJL.setBackground(Color.GREEN);
        timePanel.add(minJL);

        secJL.setOpaque(true);
        secJL.setBackground(Color.GREEN);
        timePanel.add(secJL);

        // lower row holds the textfields
        hourJTF.setText(String.valueOf(now.getHour()));
        hourJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        hourJTF.setBackground(Color.WHITE);
        hourJTF.setEditable(false);
        timePanel.add(hourJTF);

        minJTF.setText(String.valueOf(now.getMin()));
        minJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        minJTF.setBackground(Color.WHITE);
        minJTF.setEditable(false);
        timePanel.add(minJTF);

        secJTF.setText(String.valueOf(now.getSec()));
        secJTF.setHorizontalAlignment(SwingConstants.RIGHT);
        secJTF.setBackground(Color.WHITE);
        secJTF.setEditable(false);
        timePanel.add(secJTF);
        
        this.add(timePanel, BorderLayout.CENTER);

        // southern panel holds control buttons
        controlPanel.setLayout(new FlowLayout());

        // add action listeners to components, add to panel
        lastTimeJB.addActionListener(new AppActionListener());
        controlPanel.add(lastTimeJB);

        resetTimeJB.addActionListener(new AppActionListener());
        controlPanel.add(resetTimeJB);

        nextTimeJB.addActionListener(new AppActionListener());
        controlPanel.add(nextTimeJB);

        exitAppJB.addActionListener(new AppActionListener());
        controlPanel.add(exitAppJB);

        this.add(controlPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // inner class that handles user events
    class AppActionListener implements ActionListener{

    	public void actionPerformed(ActionEvent ae){

    		JButton temp=(JButton)ae.getSource();

    		// exit application
    		if(temp==exitAppJB){
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
    			now=new Timemodel(12, 0, 0);
    			updateView();                      
    		}
    	}
    }
    
    private void updateView(){
    	hourJTF.setText(String.valueOf(now.getHour()));
    	minJTF.setText(String.valueOf(now.getMin()));
    	secJTF.setText(String.valueOf(now.getSec()));
    }

}