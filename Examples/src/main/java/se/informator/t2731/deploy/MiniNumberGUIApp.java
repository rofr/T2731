package se.informator.t2731.deploy;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MiniNumberGUIApp {

	public static void main(String[] args) {

		final MiniNumberModel model = new MiniNumberModel(20);
		
		Runnable swingRunner = new Runnable(){
			public void run(){
				JFrame gui = new MiniNumberGUI(model);
				gui.setTitle("MiniNumberGame");
				gui.setSize(new Dimension(300, 200));
				gui.setVisible(true);
			}
			
		};
		SwingUtilities.invokeLater(swingRunner);
	}

}
