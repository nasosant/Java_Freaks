import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cured_PassedAway extends JFrame {

	protected static JButton buttonSub;
	protected static String name;
	protected static String surname;
	protected static String address;
	protected static String email;
	protected static String phoneNumber;
	protected static String ssn;
	protected JPanel contentPane;
	protected JTable table;
	protected static JLabel labelChangeUserImg;
	protected static DefaultTableModel model;
	protected static boolean cured;
	final static Object[] row = new Object[8];
	protected Object[] column = { "Id", "Name", "Surname", "Email", "Phone Number", "SSN", "Address", "Has Covid" };
	protected static int number = -1;

	public Cured_PassedAway() throws Exception {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1090, 478);
			setTitle("Personal information");
			setResizable(false);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setLocationRelativeTo(null);

			JPanel panel = new JPanel();
			// panel.setBackground(new Color(176, 196, 222));
			panel.setBounds(0, 0, 1092, 452);
			contentPane.add(panel);
			panel.setLayout(null);
			Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
			Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
			Image imgAddress = new ImageIcon(this.getClass().getResource("address.png")).getImage();
			Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
			Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
			Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 55, 1053, 315);
			panel.add(scrollPane);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow();
				}
			});
			table.setBackground(new Color(211, 211, 211));
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			PersonJdbo obj = new PersonJdbo();

			int count = obj.check("confirmed");
			for (int i = 1; i <= count; i++) {
				Confirmed obj2 = (Confirmed) obj.showAll("confirmed", i);
				row[0] = obj2.cid;
				row[1] = obj2.name;
				row[2] = obj2.surname;
				row[3] = obj2.email;
				row[4] = obj2.phonenumber[0];
				for (int j = 1; j < obj2.phonenumber.length; j++) {
					row[4] += ", " + obj2.phonenumber[j];
				}
				row[5] = obj2.AMKA;
				row[6] = obj2.street + " " + obj2.street_number + ", " + obj2.area + " " + obj2.zip;
				row[7] = obj2.active_status;
				model.addRow(row);
			}


			JButton btnNewButton = new JButton("Cured");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i >= 0) {
						cured = true;
						model.removeRow(i);
						JOptionPane.showMessageDialog(null, "Thank you!");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}

				}
			});
			btnNewButton.setBounds(10, 381, 245, 45);
			panel.add(btnNewButton);

			JButton btnUpdate = new JButton("Passed Away");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i >= 0) {
						cured = false;
						model.removeRow(i);
						JOptionPane.showMessageDialog(null, "Thank you!");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}
				}
			});
			btnUpdate.setBounds(280, 381, 245, 45);
			panel.add(btnUpdate);

			JLabel labelSubmitImg = new JLabel("");
			Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
			labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
			labelSubmitImg.setBounds(5, 240, 25, 25);

			JButton buttonSub = new JButton("Okey");
			buttonSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * name = nameText.getText(); surname = surnameText.getText(); address =
					 * addressText.getText(); email = emailText.getText(); phoneNumber =
					 * phoneNumberText.getText(); ssn = ssnText.getText();
					 */
					dispose();
					new Message("Your personal information has been submited successfully. Thank you!", 120);
				}
			});
			buttonSub.setBounds(550, 381, 245, 45);
			buttonSub.setIcon(new ImageIcon(imgSubmit));
			panel.add(buttonSub);

			JLabel labelCancelImg = new JLabel("");
			Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
			labelCancelImg.setIcon(new ImageIcon(imgCancel));
			labelCancelImg.setBounds(165, 240, 25, 25);

			JButton buttonCancel = new JButton("Back");
			buttonCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new PrintMenu();
				}
			});
			buttonCancel.setBounds(820, 381, 245, 45);
			buttonCancel.setIcon(new ImageIcon(imgCancel));
			panel.add(buttonCancel);

			labelChangeUserImg = new JLabel("");
			Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
			labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
			labelChangeUserImg.setBounds(325, 240, 25, 25);

			JLabel lblNewLabel_1 = new JLabel("Enter the personal information as it appears on the police ID.");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1.setBounds(244, 11, 502, 20);
			panel.add(lblNewLabel_1);

			JLabel labelIdImg = new JLabel("");
			Image imgId = new ImageIcon(this.getClass().getResource("id.png")).getImage();
			labelIdImg.setIcon(new ImageIcon(imgId));
			labelIdImg.setBounds(756, 5, 48, 36);
			panel.add(labelIdImg);
		}
}

