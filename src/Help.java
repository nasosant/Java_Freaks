import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JFrame implements ActionListener {

	protected static JPanel panel;
	protected static JLabel label;
	protected static JLabel labelInfo;
	protected static JLabel labelOkey;
	protected static JButton button;

	public Help() {
		panel = new JPanel();

		labelInfo = new JLabel("");
		Image imgInfo = new ImageIcon(this.getClass().getResource("info.png")).getImage();
		labelInfo.setIcon(new ImageIcon(imgInfo));
		labelInfo.setBounds(5, 10, 130, 130);

		labelOkey = new JLabel("");
		Image imgOkey = new ImageIcon(this.getClass().getResource("okey.png")).getImage();
		labelOkey.setIcon(new ImageIcon(imgOkey));
		labelOkey.setBounds(260, 160, 50, 50);

		label = new JLabel();
		label.setText("<html>This is a<br>multline label!<br> Try it yourself!</html>");

		label = new JLabel(
				"<html><p style=\"text-align:justify\"><font size=\"+1\">This is an application that manages and tracks covid-19 cases."
						+ " More specifically, this application is managed by the National Organization of Public Health (EODY). "
						+ "There are 3 options in the menu. The first one refers to the addition of a new patient, the second one refers to the "
						+ "update of a patient's existing data while the third one displays all the data that exists in the system. </font></p></html>");
		label.setBounds(150, 2, 570, 145);
		panel.add(label);

		button = new JButton("<html><font size=+2>Okey</font></html>");
		button.setBounds(320, 160, 100, 50);
		button.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Help");
		this.setLayout(null);
		this.setSize(750, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(label);
		this.add(labelInfo);
		this.add(button);
		this.add(labelOkey);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			dispose();
			new PrintMenu();
		}

	}

}
