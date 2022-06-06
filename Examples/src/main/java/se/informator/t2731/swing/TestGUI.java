package se.informator.t2731.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldHour;
	private JTextField textFieldMin;
	private JTextField textFieldSec;

	private Timemodel now;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		final Timemodel now = new Timemodel(15, 23, 33);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI(now);
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
	public TestGUI(Timemodel tm) {
		
		now = tm;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Text");
		northPanel.add(lblNewLabel);
		
		textField = new JTextField();
		northPanel.add(textField);
		textField.setColumns(20);
		
		JPanel midPanel = new JPanel();
		contentPane.add(midPanel, BorderLayout.CENTER);
		midPanel.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lblHour = new JLabel("Hour");
		midPanel.add(lblHour);
		
		JLabel lblMin = new JLabel("Min");
		midPanel.add(lblMin);
		
		JLabel lblSec = new JLabel("Sec");
		midPanel.add(lblSec);
		
		textFieldHour = new JTextField();
//		textFieldHour.setText(String.valueOf(now.getHour()));
		midPanel.add(textFieldHour);
		textFieldHour.setColumns(10);
		
		textFieldMin = new JTextField();
//		textFieldMin.setText(String.valueOf(now.getMin()));
		midPanel.add(textFieldMin);
		textFieldMin.setColumns(10);
		
		textFieldSec = new JTextField();
//		textFieldSec.setText(String.valueOf(now.getSec()));
		midPanel.add(textFieldSec);
		textFieldSec.setColumns(10);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		southPanel.add(horizontalGlue);

		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				now = now.next();
				updateGUI();
			}

		});
		southPanel.add(btnGo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		southPanel.add(btnExit);
		
		
		updateGUI();
	}
	

	private void updateGUI() {
		// TODO Auto-generated method stub
		textFieldHour.setText(String.valueOf(now.getHour()));
		textFieldMin.setText(String.valueOf(now.getMin()));
		textFieldSec.setText(String.valueOf(now.getSec()));
	}

}
