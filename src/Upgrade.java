import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Upgrade extends JFrame implements ActionListener{
	
	protected static Registration obj;
	protected static JButton buttonPassedAway;
	protected static JButton buttonHealed;
	protected static JButton buttonExit;
	protected static JButton buttonChangeUser;
	protected static JButton buttonCancel;
	protected static JLabel label1;
	protected static JLabel labelExit;
	protected static JLabel labelChangeUser;
	protected static JLabel labelHelp;
	protected static JLabel label2;
	protected static JLabel labelPassedAway;
	protected static JLabel labelHeal;
	protected static JPanel panel;
	
	public Upgrade() {
		obj = new Registration();
		panel = new JPanel();
		
		labelExit = new JLabel("");
		Image imgExit = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
		labelExit.setBounds(5, 2, 25, 25);
		
		labelChangeUser = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUser.setBounds(165, 2, 25, 25);
		
		labelHelp = new JLabel("");
		Image imgHelp = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelHelp.setBounds(325, 2, 25, 25);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(5, 2, 135, 25);
		buttonExit.setIcon(new ImageIcon(imgExit));
		buttonExit.addActionListener(this);
		
		buttonChangeUser = new JButton("Change user");
		buttonChangeUser.setBounds(150, 2, 135, 25);
		buttonChangeUser.setIcon(new ImageIcon(imgChangeUser));
		buttonChangeUser.addActionListener(this);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(295, 2, 135, 25);
		buttonCancel.setIcon(new ImageIcon(imgHelp));
		buttonCancel.addActionListener(this);
		
		labelPassedAway = new JLabel("");
		Image imgPassedAway = new ImageIcon(this.getClass().getResource("passedAway.png")).getImage();
		labelPassedAway.setIcon(new ImageIcon(imgPassedAway));
		labelPassedAway.setBounds(50, 80, 180, 140);
		
		labelHeal = new JLabel("");
		Image imgHeal = new ImageIcon(this.getClass().getResource("heal.png")).getImage();
		labelHeal.setIcon(new ImageIcon(imgHeal));
		labelHeal.setBounds(50, 220, 180, 140);
		
		label1 = new JLabel("Choose one of the following!");
		label1.setBounds(200, 40, 172, 25);
		panel.add(label1);
		
		label2 = new JLabel("The patient: ");
		label2.setBounds(245, 55, 80, 25);
		panel.add(label2);
		
		buttonPassedAway = new JButton("Passed away");
		buttonPassedAway.setBounds(195, 80, 172, 128);
		buttonPassedAway.addActionListener(this);
		
		buttonHealed = new JButton("Healed");
		buttonHealed.setBounds(195, 220, 172, 128);
		buttonHealed.addActionListener(this);
		
		this.setTitle("Upgrade");
		this.setSize(450, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.add(label1);
		this.add(label2);
		this.add(buttonPassedAway);
		this.add(buttonHealed);
		this.add(labelPassedAway);
		this.add(labelHeal);
		this.add(buttonExit);
		this.add(buttonChangeUser);
		this.add(buttonCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonExit) {
			dispose();
			System.exit(1);
		} else if (e.getSource() == buttonChangeUser) {
			dispose();
			obj.login();
		} else if (e.getSource() == buttonCancel) {
			dispose();
			new PrintMenu();
		} else if (e.getSource() == buttonPassedAway) {
			dispose();
			new Message("The data has been submited successfully. Thank you!", 150);
		} else if(e.getSource() == buttonHealed) {
			dispose();
			new Message("The data has been submited successfully. Thank you!", 150);
		}
		
	}
	
}

