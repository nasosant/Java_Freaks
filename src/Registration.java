import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration implements ActionListener {
	
	protected static JCheckBox checkBox;
	protected static JFrame frame;
	protected static JPanel panel;
	protected static JLabel userLabel;
	protected static JTextField userText;
	protected static JLabel passwordLabel;
	protected static JPasswordField passwordText;
	protected static JButton button;
	protected static JLabel success;
	protected static JLabel labelLogin;
	protected static ImageIcon img;
	
	public void login() {
		// Image for the login.
		labelLogin = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		labelLogin.setIcon(new ImageIcon(img));
		labelLogin.setBounds(20, 30, 150, 130);
	    // Making the panel in which I add all the labels.
	    panel = new JPanel();
	    // Making the Username label.
	    userLabel = new JLabel("Username");
	    userLabel.setBounds(180, 30, 80, 25);
	    panel.add(userLabel);
	    // Making the text field for the username.
	    userText = new JTextField(100);
	    userText.setBounds(270, 30, 165, 25);
	    panel.add(userText);
	    // Making the Password label.
	    passwordLabel = new JLabel("Password");
	    passwordLabel.setBounds(180, 60, 80, 25);
	    panel.add(passwordLabel);
	    // Making the text field for the password.
	    passwordText = new JPasswordField();
	    passwordText.setBounds(270, 60, 165, 25);
	    panel.add(passwordText);
	    // Making the check box "I'm not a robot".
	    checkBox = new JCheckBox("I'm not a robot.");
	    checkBox.setBounds(180, 90, 130, 25);
	    // Making the login button.
	    button = new JButton("Login");
	    button.setBounds(180, 120, 80, 25);
	    button.addActionListener(new Registration());
	    // Making the label in which the error message is apeared 
	    success = new JLabel("");
	    success.setBounds(180, 145, 190, 25);
	    panel.add(success);
	    // Making the JFrame window.
	    frame = new JFrame();
	    frame.setTitle("Login");
	    frame.setSize(500, 260);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);
	    frame.setVisible(true);
	    // Adding all the labels to the frame.
	    frame.add(checkBox);
	    frame.add(userLabel);
	    frame.add(userText);
	    frame.add(passwordLabel);
	    frame.add(passwordText);
	    frame.add(button);
	    frame.add(success);
	    frame.getContentPane().add(labelLogin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Getting the user name and the password entered by the user
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println(user + ", " + password);
		// Checking if the username and the password are equaled to the right ones and making and obj of PrintMenu() class.
		if (user.contentEquals("n") && password.contentEquals("n")) {
			if (checkBox.isSelected()) {
				frame.dispose();
				new PrintMenu();
			} else {
				success.setText("The check box is NOT selected!");
			}
			
		} else {
			success.setText("Username or password is wrong!");
		}		
	}
	    
}




