package se.informator.t2731.db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingEnhancedPhoneBook extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel midPanel=new JPanel();
    
    private JPanel userPanel=new JPanel();
    private JLabel whoJL=new JLabel("Name");
    private JTextField whoJTF=new JTextField(8);
    private JLabel noJL=new JLabel("Number");
    private JTextField noJTF=new JTextField(8);
       
    private JPanel controlPanel=new JPanel();
    private JButton lookUpJB=new JButton("Look up");
    private JButton addJB=new JButton("Add");
    private JButton updateJB=new JButton("Update");
    private JButton removeJB=new JButton("Remove");     
    private JButton resetJB=new JButton("Reset");
    private JButton exitJB=new JButton("Exit");
    
    private EnhancedPhoneBook thePhoneBook;
    
    public SwingEnhancedPhoneBook(EnhancedPhoneBook epb){
    	
        thePhoneBook=epb;
        
        this.setLayout(new BorderLayout());
        
        midPanel.setLayout(new FlowLayout());
        userPanel.setLayout(new GridLayout(2,2));
        userPanel.add(whoJL);
        userPanel.add(whoJTF);
        userPanel.add(noJL);
        userPanel.add(noJTF);
        midPanel.add(userPanel);
        
        this.add(midPanel, BorderLayout.CENTER);

        controlPanel.setLayout(new FlowLayout());
        lookUpJB.addActionListener(new AppActionListener());
        controlPanel.add(lookUpJB);
        addJB.addActionListener(new AppActionListener());
        controlPanel.add(addJB);    
        updateJB.addActionListener(new AppActionListener());
        controlPanel.add(updateJB);
        removeJB.addActionListener(new AppActionListener());
        controlPanel.add(removeJB);
        resetJB.addActionListener(new AppActionListener());
        controlPanel.add(resetJB);           
        exitJB.addActionListener(new AppActionListener());
        controlPanel.add(exitJB);
        
        this.add(controlPanel, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    
    class AppActionListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String name=whoJTF.getText();
            String number=noJTF.getText();
            
            JButton temp=(JButton)ae.getSource();
            
            if(temp==lookUpJB){
                System.out.println("Looking up "+name);
                number=thePhoneBook.findNumber(name);
                if(number.length()>0){
                    noJTF.setText(number);
                }
                else{
                    noJTF.setText("Not found!");
                }
            }
            
            if(temp==addJB){
                if(!thePhoneBook.findNumber(name).isEmpty()){
                    JOptionPane.showMessageDialog(SwingEnhancedPhoneBook.this, 
                            "Entry already exists!","Phone Book message", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    System.out.println("Adding "+name+", "+number);
                    thePhoneBook.addNameAndNumber(name, number);
                }
            }

            if(temp==updateJB){
                if(!thePhoneBook.findNumber(name).equals("")){
                    System.out.println("Updating "+name+", new number: "+number);
                    thePhoneBook.updateEntry(name, number);
                }
            }   
            
            if(temp==removeJB){
                if(!thePhoneBook.findNumber(name).isEmpty()){
                    String[] options={"Yes", "No"};
                    int answer=JOptionPane.showOptionDialog(SwingEnhancedPhoneBook.this, 
                            "Do you really want to remove this entry!","Phone Book message", 
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, null); 
                    if(answer==0){
                        thePhoneBook.removeEntry(name);
                        whoJTF.setText("");
                        noJTF.setText("");                       
                    }
                }
            }   
            
            if(temp==resetJB){           
                whoJTF.setText("");
                noJTF.setText("");
            }
            
            if(temp==exitJB){
                String[] options={"Yes", "No"};
                int answer=JOptionPane.showOptionDialog(SwingEnhancedPhoneBook.this, "Do you really want to exit",
                        "Exit message", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                if(answer==0){
                    thePhoneBook.shutDown();
                    System.exit(0);
                }
            }                        
        }
    
    }
    
    public static void main(String[] args) {

    	Runnable swingRunner = new Runnable(){
    		public void run(){

    			EnhancedPhoneBook epb=new EnhancedDBPhoneBook("phonedb");
    			JFrame jf=new SwingEnhancedPhoneBook(epb);
    			jf.setTitle("Phone Book");
    			jf.pack();
    			jf.setVisible(true);
    		}
    	};
    	SwingUtilities.invokeLater(swingRunner);
    }

}
