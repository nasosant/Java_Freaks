import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrintMenu extends JFrame implements ActionListener{
	
	protected static Registration obj;
	protected static JFrame frame;
	protected static JLabel label;
	protected static JLabel labelPatient;
	protected static JLabel labelVirus;
	protected static JLabel labelExit;
	protected static JLabel  labelChangeUser;
	protected static JLabel  labelHelp;
	protected static JButton button1;
	protected static JButton button2;
	protected static JButton button3;
	protected static JButton button4;
	protected static JButton button5;
	protected static JButton button6;
	protected static JButton buttonExit;
	protected static JButton buttonChangeUser;
	protected static JButton buttonHelp;
	
	PrintMenu() {
		obj = new Registration();
		
		labelPatient = new JLabel("");
		Image imgPatient = new ImageIcon(this.getClass().getResource("patient.png")).getImage();
		labelPatient.setIcon(new ImageIcon(imgPatient));
		labelPatient.setBounds(20, 40, 60, 40);
		
		labelVirus = new JLabel("");
		Image imgVirus = new ImageIcon(this.getClass().getResource("virus.png")).getImage();
		labelVirus.setIcon(new ImageIcon(imgVirus));
		labelVirus.setBounds(25, 80, 180, 140);
		
		labelExit = new JLabel("");
		Image imgExit = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
		//labelExit.setIcon(new ImageIcon(imgExit));
		labelExit.setBounds(5, 2, 25, 25);
		
		labelChangeUser = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		//labelChangeUser.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUser.setBounds(165, 2, 25, 25);
		
		labelHelp = new JLabel("");
		Image imgHelp = new ImageIcon(this.getClass().getResource("help.png")).getImage();
		//labelHelp.setIcon(new ImageIcon(imgHelp));
		labelHelp.setBounds(325, 2, 25, 25);
		
		label = new JLabel();
		label.setText("Choose one of the following!");
		label.setBounds(230, 35, 400, 25);
		
		button1 = new JButton("1. Add a patient.");
		button1.setBounds(180, 70, 250, 25);
		button1.setIcon(new ImageIcon(imgPatient));
		button1.addActionListener(this);
		
		button2 = new JButton("2. Update.");
		button2.setBounds(180, 100, 250, 25);
		button2.addActionListener(this);
		 
		button3 = new JButton("3. Someone got the virus over.");
		button3.setBounds(180, 130, 250, 25);
		button3.addActionListener(this);
		 
		button4 = new JButton("4. Positive or negative to the test.");
		button4.setBounds(180, 160, 250, 25);
		button4.addActionListener(this);
		 
		button5 = new JButton("5. Show all the results until now.");
		button5.setBounds(180, 190, 250, 25);
		button5.addActionListener(this);
		 
		button6 = new JButton("6. Inform about my daily temperature.");
		button6.setBounds(180, 220, 250, 25);
		button6.addActionListener(this);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(5, 2, 150, 25);
		buttonExit.setIcon(new ImageIcon(imgExit));
		buttonExit.addActionListener(this);
		
		buttonChangeUser = new JButton("Change user");
		buttonChangeUser.setBounds(165, 2, 150, 25);
		buttonChangeUser.setIcon(new ImageIcon(imgChangeUser));
		buttonChangeUser.addActionListener(this);
		
		buttonHelp = new JButton("Help");
		buttonHelp.setBounds(325, 2, 150, 25);
		buttonHelp.setIcon(new ImageIcon(imgHelp));
		buttonHelp.addActionListener(this);
	    
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu");
		this.setLayout(null);
		this.setSize(500, 300);
		this.setVisible(true);
		this.add(label);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		this.add(buttonExit);
		this.add(buttonChangeUser);
		this.add(buttonHelp);
		this.add(labelVirus);
		//this.add(labelExit);
		//this.add(labelChangeUser);
		//this.add(labelHelp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			dispose();
			new Confirmed();
		} else if(e.getSource() == button2) {
			//dispose();
		} else if(e.getSource() == button3) {
			//dispose();
		} else if(e.getSource() == button4) {
			//dispose();
		} else if(e.getSource() == button5) {
			//dispose();
		} else if(e.getSource() == button6) {
			//dispose();
		} else if(e.getSource() == buttonExit) {
			System.exit(1);
		} else if(e.getSource() == buttonChangeUser) {
			dispose();
			obj.login();
		} else if(e.getSource() == buttonHelp) {
			dispose();
		}
	}
}
