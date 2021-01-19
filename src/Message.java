import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JFrame implements ActionListener {

	protected static Registration obj;
	protected static JLabel label;
	protected static JLabel labelHomePageImg;
	protected static JPanel panel;
	protected static JLabel success;
	protected static JButton buttonHomePageNew;
	protected static JButton buttonChangeUserNew;
	protected static JButton buttonExitNew;
	protected static JButton buttonCancel;

	public Message(String message, int boundm, int boundi) {
		obj = new Registration();

		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("success.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(boundi, 30, 60, 40);

		labelHomePageImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("homePage.png")).getImage();
		// labelHomePageImg.setIcon(new ImageIcon(imgPhone));
		labelHomePageImg.setBounds(155, 80, 25, 25);

		panel = new JPanel();

		success = new JLabel(message);
		success.setBounds(boundm, 40, 400, 25);
		panel.add(success);

		buttonHomePageNew = new JButton("Home Page");
		buttonHomePageNew.setBounds(235, 100, 140, 25);
		buttonHomePageNew.setIcon(new ImageIcon(imgPhone));
		buttonHomePageNew.addActionListener(this);
		panel.add(buttonHomePageNew);

		this.setTitle("Thank you!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(success);
		this.add(labelHomePageImg);
		this.add(buttonHomePageNew);
		this.getContentPane().add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonHomePageNew) {
			dispose();
			new PrintMenu();
		}
	}

}
