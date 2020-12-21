import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Confirmed extends JFrame implements ActionListener {
	
	protected static Registration obj;
	protected static JLabel labelIdImg;
	protected static JLabel labelNameImg;
	protected static JLabel labelSurNameImg;
	protected static JLabel labelAddressImg;
	protected static JLabel labelEmailImg;
	protected static JLabel labelPhoneImg;
	protected static JLabel labelAmkaImg;
	protected static JLabel labelSubmitImg;
	protected static JLabel labelCancelImg;
	protected static JLabel labelChangeUserImg;
	protected static JPanel panel;
	protected static JPanel panelNew;
	protected static JFrame frame;
	protected static JLabel message;
	protected static JLabel nameLabel;
	protected static JLabel surnameLabel;
	protected static JLabel addressLabel;
	protected static JLabel emailLabel;
	protected static JLabel phoneNumberLabel;
	protected static JLabel amkaLabel;
	protected static JTextField nameText;
	protected static JTextField surnameText;
	protected static JTextField addressText;
	protected static JTextField emailText;
	protected static JTextField phoneNumberText;
	protected static JTextField amkaText;
	protected static JButton buttonSub;
	protected static JButton buttonHomePage;
	protected static JButton buttonChangeUser;
	protected static JButton buttonExit;
	protected static JButton buttonSubNew;
	protected static JButton buttonHomePageNew;
	protected static JButton buttonChangeUserNew;
	protected static JButton buttonExitNew;
	protected static JLabel success;
	protected static String name;
	protected static String surname;
	protected static String address;
	protected static String email;
	protected static String phoneNumber;
	protected static String amka;

	public Confirmed() {
		obj = new Registration();
		//Image for Id
		labelIdImg = new JLabel("");
		Image imgId = new ImageIcon(this.getClass().getResource("id.png")).getImage();
		labelIdImg.setIcon(new ImageIcon(imgId));
		labelIdImg.setBounds(370, 20, 25, 25);
		//Image for name
		labelNameImg = new JLabel("");
		Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelNameImg.setIcon(new ImageIcon(imgName));
		labelNameImg.setBounds(50, 50, 25, 25);
		//Image for surname
		labelSurNameImg = new JLabel("");
		Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelSurNameImg.setIcon(new ImageIcon(imgSurName));
		labelSurNameImg.setBounds(70, 80, 25, 25);
		//Image for address
		labelAddressImg = new JLabel("");
		Image imgAddress = new ImageIcon(this.getClass().getResource("address.png")).getImage();
		labelAddressImg.setIcon(new ImageIcon(imgAddress));
		labelAddressImg.setBounds(65, 110, 25, 25);
		//Image for address
		labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(50, 140, 25, 25);
		//Image for address
		labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(100, 170, 25, 25);
		//Image for amka
		labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(50, 200, 25, 25);
		
		labelSubmitImg = new JLabel("");
		Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);
		
		labelCancelImg = new JLabel("");
		Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);
		
		labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);
		
		
		
		panel = new JPanel();
		//Message
		message = new JLabel("Enter your personal information as it appears on your police ID.");
		message.setBounds(10, 20, 400, 25);
		panel.add(message);
		// Text name
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 50, 80, 25);
		panel.add(nameLabel);
		// Frame to write the name
		nameText = new JTextField(20);
		nameText.setBounds(130, 50, 290, 25);
		panel.add(nameText);
		// Text surname
		surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(10, 80, 80, 25);
		panel.add(surnameLabel);
		// Frame to write the surname
		surnameText = new JTextField(20);
		surnameText.setBounds(130, 80, 290, 25);
		panel.add(surnameText);
		// Text address
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 110, 80, 25);
		panel.add(addressLabel);
		// Frame to write the address
		addressText = new JTextField(30);
		addressText.setBounds(130, 110, 290, 25);
		panel.add(addressText);
		// Text email
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 140, 80, 25);
		panel.add(emailLabel);
		// Frame to write the email
		emailText = new JTextField(30);
		emailText.setBounds(130, 140, 290, 25);
		panel.add(emailText);
		// Text phoneNumber
		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(10, 170, 100, 25);
		panel.add(phoneNumberLabel);
		// Frame to write the phoneNumber
		phoneNumberText = new JTextField(10);
		phoneNumberText.setBounds(130, 170, 290, 25);
		panel.add(phoneNumberText);
		// Text AMKA
		amkaLabel = new JLabel("AMKA");
		amkaLabel.setBounds(10, 200, 80, 25);
		panel.add(amkaLabel);
		// Frame to write the AMKA
		amkaText = new JTextField(9);
		amkaText.setBounds(130, 200, 290, 25);
		panel.add(amkaText);
		// Making the button to confirm the details
		buttonSub = new JButton("Submit");
		buttonSub.setBounds(5, 240, 150, 25);
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		buttonSub.addActionListener(this);
		panel.add(buttonSub);
		// Making the botton for the Cancel
		buttonHomePage = new JButton("Cancel");
		buttonHomePage.setBounds(165, 240, 150, 25);
		buttonHomePage.setIcon(new ImageIcon(imgCancel));
		buttonHomePage.addActionListener(this);
		panel.add(buttonHomePage);
		// Making the button to change user
		buttonChangeUser = new JButton("Change user");
		buttonChangeUser.setBounds(325, 240, 150, 25);
		buttonChangeUser.setIcon(new ImageIcon(imgChangeUser));
		buttonChangeUser.addActionListener(this);
		panel.add(buttonChangeUser);
		// Making the Frame and add everything
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Personal information");
		this.setLayout(null);
		this.setSize(500, 330);
		this.setVisible(true);
		this.add(labelIdImg);
		this.add(labelNameImg);
		this.add(labelSurNameImg);
		this.add(labelAddressImg);
		this.add(labelEmailImg);
		this.add(labelPhoneImg);
		this.add(labelAmkaImg);
		this.add(message);
		this.add(nameLabel);
		this.add(nameText);
		this.add(surnameLabel);
		this.add(surnameText);
		this.add(addressLabel);
		this.add(addressText);
		this.add(emailLabel);
		this.add(emailText);
		this.add(phoneNumberLabel);
		this.add(phoneNumberText);
		this.add(amkaLabel);
		this.add(amkaText);
		this.add(buttonSub);
		this.add(buttonHomePage);
		this.add(buttonChangeUser);
		this.add(success);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonSub) {
			name = nameText.getText();
			surname = surnameText.getText();
			address = addressText.getText();
			email = emailText.getText();
			phoneNumber = phoneNumberText.getText();
			amka = amkaText.getText();
			dispose();
			new ConfirmedNew();
		} else if (e.getSource() == buttonHomePage) {
			dispose();
			new PrintMenu();
		} else if (e.getSource() == buttonChangeUser) {
			dispose();
			obj.login();
		}

	}

}
