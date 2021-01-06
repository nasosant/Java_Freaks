import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrintMenu extends JFrame implements ActionListener {

	protected static Registration obj;
	protected static JFrame frame;
	protected static JLabel label;
	protected static JLabel labelPatient;
	protected static JLabel labelUpgrade;
	protected static JLabel labelData;
	protected static JLabel labelVirus;
	protected static JLabel labelExit;
	protected static JLabel labelChangeUser;
	protected static JLabel labelHelp;
	protected static JButton buttonAddPatient;
	protected static JButton buttonUpgrade;
	protected static JButton buttonData;
	protected static JButton buttonExit;
	protected static JButton buttonChangeUser;
	protected static JButton buttonHelp;

	PrintMenu() {
		obj = new Registration();

		labelVirus = new JLabel("");
		Image imgVirus = new ImageIcon(this.getClass().getResource("virus.png")).getImage();
		labelVirus.setIcon(new ImageIcon(imgVirus));
		labelVirus.setBounds(25, 50, 180, 140);

		label = new JLabel();
		label.setText("Choose one of the following!");
		label.setBounds(230, 45, 400, 25);

		labelPatient = new JLabel("");
		Image imgPatient = new ImageIcon(this.getClass().getResource("patient.png")).getImage();
		labelPatient.setBounds(20, 40, 60, 40);

		buttonAddPatient = new JButton("1. Add a patient.");
		buttonAddPatient.setBounds(180, 80, 250, 30);
		buttonAddPatient.setIcon(new ImageIcon(imgPatient));
		buttonAddPatient.addActionListener(this);

		labelUpgrade = new JLabel("");
		Image imgUpgrade = new ImageIcon(this.getClass().getResource("upgrade.png")).getImage();
		labelUpgrade.setBounds(325, 2, 25, 25);

		buttonUpgrade = new JButton("2. Update.");
		buttonUpgrade.setIcon(new ImageIcon(imgUpgrade));
		buttonUpgrade.setBounds(180, 115, 250, 30);
		buttonUpgrade.addActionListener(this);

		labelData = new JLabel("");
		Image imgData = new ImageIcon(this.getClass().getResource("data.png")).getImage();
		labelData.setBounds(600, 2, 25, 25);

		buttonData = new JButton("Show data.");
		buttonData.setBounds(180, 150, 250, 30);
		buttonData.setIcon(new ImageIcon(imgData));
		buttonData.addActionListener(this);

		labelExit = new JLabel("");
		Image imgExit = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
		labelExit.setBounds(5, 2, 25, 25);

		buttonExit = new JButton("Exit");
		buttonExit.setBounds(5, 2, 150, 25);
		buttonExit.setIcon(new ImageIcon(imgExit));
		buttonExit.addActionListener(this);

		labelChangeUser = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUser.setBounds(165, 2, 25, 25);

		buttonChangeUser = new JButton("Change user");
		buttonChangeUser.setBounds(165, 2, 150, 25);
		buttonChangeUser.setIcon(new ImageIcon(imgChangeUser));
		buttonChangeUser.addActionListener(this);

		labelHelp = new JLabel("");
		Image imgHelp = new ImageIcon(this.getClass().getResource("help.png")).getImage();
		labelHelp.setBounds(325, 2, 25, 25);

		buttonHelp = new JButton("Help");
		buttonHelp.setBounds(325, 2, 150, 25);
		buttonHelp.setIcon(new ImageIcon(imgHelp));
		buttonHelp.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu");
		this.setLayout(null);
		this.setSize(500, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(label);
		this.add(buttonAddPatient);
		this.add(buttonUpgrade);
		this.add(buttonExit);
		this.add(buttonChangeUser);
		this.add(buttonHelp);
		this.add(labelVirus);
		this.add(buttonData);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAddPatient) {
			dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Platform frame = new Platform();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if (e.getSource() == buttonUpgrade) {
			dispose();
			new Upgrade();
		} else if (e.getSource() == buttonExit) {
			System.exit(1);
		} else if (e.getSource() == buttonChangeUser) {
			dispose();
			obj.login();
		} else if (e.getSource() == buttonHelp) {
			dispose();
			new Help();
		} else if (e.getSource() == buttonData) {
			dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Data frame = new Data();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
