import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JFrame implements ActionListener{

	private static int boundNew;
	protected static Registration obj;
	protected static JLabel label;
	protected static JLabel labelHomePageImg;
	protected static JPanel panel;
	protected static JLabel success;
	protected static JButton buttonHomePageNew;
	protected static JButton buttonChangeUserNew;
	protected static JButton buttonExitNew;
	protected static JButton buttonCancel;
	
	public Message(String message, int bound) {
		obj = new Registration();
		boundNew = bound;
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("success.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(30, 30, 60, 40);
		
		/*Confirmed.labelCancelImg = new JLabel("");
		Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		//Confirmed.labelCancelImg.setIcon(new ImageIcon(imgCancel));
		Confirmed.labelCancelImg.setBounds(5, 80, 25, 25);*/
		
		labelHomePageImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("homePage.png")).getImage();
		//labelHomePageImg.setIcon(new ImageIcon(imgPhone));
		labelHomePageImg.setBounds(155, 80, 25, 25);
		
		Platform.labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		//Confirmed.labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		Platform.labelChangeUserImg.setBounds(305, 80, 25, 25);
		
		PrintMenu.labelExit = new JLabel("");
		Image imgExit = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
		//PrintMenu.labelExit.setIcon(new ImageIcon(imgExit));
		PrintMenu.labelExit.setBounds(455, 80, 25, 25);
		
		panel = new JPanel();
		
		success = new JLabel(message);
		success.setBounds(bound, 40, 400, 25);
		panel.add(success);
		// Making the cancel button
		/*buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(5, 80, 140, 25);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		buttonCancel.addActionListener(this);
		panel.add(buttonCancel);*/
		// Making the button Home Page
		buttonHomePageNew = new JButton("Home Page");
		buttonHomePageNew.setBounds(50, 80, 140, 25);
		buttonHomePageNew.setIcon(new ImageIcon(imgPhone));
		buttonHomePageNew.addActionListener(this);
		panel.add(buttonHomePageNew);
		// Making the button to change user
		buttonChangeUserNew = new JButton("Change user");
		buttonChangeUserNew.setBounds(220, 80, 140, 25);
		buttonChangeUserNew.setIcon(new ImageIcon(imgChangeUser));
		buttonChangeUserNew.addActionListener(this);
		panel.add(buttonChangeUserNew);
		// Making the botton for the Exit
		buttonExitNew = new JButton("Exit");
		buttonExitNew.setBounds(390, 80, 140, 25);
		buttonExitNew.setIcon(new ImageIcon(imgExit));
		buttonExitNew.addActionListener(this);
		panel.add(buttonExitNew);
		
		this.setTitle("Thank you!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(success);
		//this.add(Confirmed.labelCancelImg);		
		this.add(labelHomePageImg);
		this.add(Platform.labelChangeUserImg);
		this.add(PrintMenu.labelExit);
		this.add(buttonHomePageNew);
		this.add(buttonChangeUserNew);
		this.add(buttonExitNew);
		//this.add(buttonCancel);
		this.getContentPane().add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonHomePageNew) {
			dispose();
			new PrintMenu();
		} else if (e.getSource() == buttonChangeUserNew) {
			dispose();
			obj.login();
		} else if (e.getSource() == buttonExitNew) {
			System.exit(1);
		}
	}

}

