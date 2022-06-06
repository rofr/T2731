package se.informator.t2731.swing;

import javax.swing.*;

public class SwingTimeApp {
	
    public static void main(String args[]){
    	
    	Runnable swingRunner = new Runnable(){           		
    	  public void run(){   			    		
    		Timemodel t1=new Timemodel(15, 22, 51);

	        JFrame jf=new SwingTime(t1);
	        jf.setTitle("SwingTime");
	        jf.pack();
	        jf.setResizable(false);
	        jf.setVisible(true);
    	  }
    	};
    	SwingUtilities.invokeLater(swingRunner);	
    }
}
