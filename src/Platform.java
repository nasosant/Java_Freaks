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

public class Platform extends JFrame {

	protected static JButton buttonSub;
	protected static JTextField nameText;
	protected static JTextField surnameText;
	protected static JTextField addressText;
	protected static JTextField emailText;
	protected static JTextField phoneNumberText;
	protected static JTextField ssnText;
	protected JPanel contentPane;
	protected JTable table;
	protected static JLabel labelChangeUserImg;
	protected static DefaultTableModel model;
	// protected static JTextField[][] details = new JTextField[100][6];
	final static Object[] row = new Object[6];
	static Object[] column = { "Name", "Surname", "Address", "Email", "Phone Number", "SSN" };
	protected static int number = -1;

	public Platform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 481);
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

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 52, 45, 24);
		panel.add(lblNewLabel);

		JLabel labelNameImg = new JLabel("");
		Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelNameImg.setIcon(new ImageIcon(imgName));
		labelNameImg.setBounds(53, 52, 25, 25);
		panel.add(labelNameImg);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(10, 82, 63, 24);
		panel.add(lblSurname);

		JLabel labelSurNameImg = new JLabel("");
		Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelSurNameImg.setIcon(new ImageIcon(imgSurName));
		labelSurNameImg.setBounds(83, 82, 25, 25);
		panel.add(labelSurNameImg);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 112, 63, 24);
		panel.add(lblAddress);

		JLabel labelAddressImg = new JLabel("");
		Image imgAddress = new ImageIcon(this.getClass().getResource("address.png")).getImage();
		labelAddressImg.setIcon(new ImageIcon(imgAddress));
		labelAddressImg.setBounds(70, 112, 25, 25);
		panel.add(labelAddressImg);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 142, 45, 24);
		panel.add(lblEmail);

		JLabel labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(53, 147, 25, 25);
		panel.add(labelEmailImg);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 172, 98, 24);
		panel.add(lblPhoneNumber);

		JLabel labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(105, 172, 25, 25);
		panel.add(labelPhoneImg);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSsn.setBounds(10, 202, 45, 24);
		panel.add(lblSsn);

		JLabel labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(53, 202, 25, 25);
		panel.add(labelAmkaImg);

		nameText = new JTextField();
		nameText.setBounds(128, 56, 160, 20);
		panel.add(nameText);
		nameText.setColumns(10);

		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnameText.setBounds(128, 86, 160, 20);
		panel.add(surnameText);

		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(128, 116, 160, 20);
		panel.add(addressText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(128, 146, 160, 20);
		panel.add(emailText);

		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(128, 176, 160, 20);
		panel.add(phoneNumberText);

		ssnText = new JTextField();
		ssnText.setColumns(10);
		ssnText.setBounds(128, 208, 160, 20);
		panel.add(ssnText);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 56, 782, 283);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nameText.setText(model.getValueAt(i, 0).toString());
				surnameText.setText(model.getValueAt(i, 1).toString());
				addressText.setText(model.getValueAt(i, 2).toString());
				emailText.setText(model.getValueAt(i, 3).toString());
				phoneNumberText.setText(model.getValueAt(i, 4).toString());
				ssnText.setText(model.getValueAt(i, 5).toString());
			}
		});
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameText.getText().equals("") || surnameText.getText().equals("")
						|| addressText.getText().equals("") || emailText.getText().equals("")
						|| phoneNumberText.getText().equals("") || ssnText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Pease Fill Complete Information");
				} else {
					number++;
					row[0] = nameText.getText();
					row[1] = surnameText.getText();
					row[2] = addressText.getText();
					row[3] = emailText.getText();
					row[4] = phoneNumberText.getText();
					row[5] = ssnText.getText();
					model.addRow(row);

					nameText.setText("");
					surnameText.setText("");
					addressText.setText("");
					emailText.setText("");
					phoneNumberText.setText("");
					ssnText.setText("");

					/*
					 * details[number][0].getText(); details[number][1].getText();
					 * details[number][2].getText(); details[number][3].getText();
					 * details[number][4].getText(); details[number][5].getText();
					 */
				}

			}
		});
		btnNewButton.setBounds(10, 270, 110, 25);
		panel.add(btnNewButton);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(nameText.getText(), i, 0);
					model.setValueAt(surnameText.getText(), i, 1);
					model.setValueAt(addressText.getText(), i, 2);
					model.setValueAt(emailText.getText(), i, 3);
					model.setValueAt(phoneNumberText.getText(), i, 4);
					model.setValueAt(ssnText.getText(), i, 5);
					/*
					 * details[number][0].getText(); details[number][1].getText();
					 * details[number][2].getText(); details[number][3].getText();
					 * details[number][4].getText(); details[number][5].getText();
					 */
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnUpdate.setBounds(144, 270, 110, 25);
		panel.add(btnUpdate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameText.setText("");
				surnameText.setText("");
				addressText.setText("");
				emailText.setText("");
				phoneNumberText.setText("");
				ssnText.setText("");
			}
		});
		btnClear.setBounds(144, 314, 110, 25);
		panel.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = table.getSelectedRow();
				if (k >= 0) {
					model.removeRow(k);
					/*
					 * for (int i = k; i > number; k++) { for (int j = 0; j > 6; j++) {
					 * details[k][j] = details[k + 1][j]; } } for (int j = 0; j < 6; j++) {
					 * details[number][j] = null; }
					 */
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnDelete.setBounds(10, 314, 110, 25);
		panel.add(btnDelete);

		JLabel labelSubmitImg = new JLabel("");
		Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);

		JButton buttonSub = new JButton("Submit");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Confirmed patient = new Confirmed(nameText.getText(), surnameText.getText(), emailText.getText(), phoneNumberText.getText(), ssnText.getText(), addressText.getText(),
				// phonenumber [ ] +
				//			   [ ] +
				//			   [ ]
				// int phonenumber[] περισσοτερες επιλογες
				// String area, String street, int street_number, int zip, boolean active_status
				dispose();
				new Message("Your personal information has been submited successfully. Thank you!", 120);
			}
		});
		buttonSub.setBounds(10, 381, 245, 45);
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		panel.add(buttonSub);

		JLabel labelCancelImg = new JLabel("");
		Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PrintMenu();
			}
		});
		buttonCancel.setBounds(424, 381, 240, 45);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);

		labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);

		JButton buttonChangeUser = new JButton("Change user");
		buttonChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Registration obj = new Registration();
				obj.login();
			}
		});
		buttonChangeUser.setBounds(840, 381, 240, 45);
		buttonChangeUser.setIcon(new ImageIcon(imgChangeUser));
		panel.add(buttonChangeUser);

		JLabel lblNewLabel_1 = new JLabel("Enter the personal information as it appears on the police ID.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(244, 11, 502, 20);
		panel.add(lblNewLabel_1);

		JLabel labelIdImg = new JLabel("");
		Image imgId = new ImageIcon(this.getClass().getResource("id.png")).getImage();
		labelIdImg.setIcon(new ImageIcon(imgId));
		labelIdImg.setBounds(756, 5, 48, 36);
		panel.add(labelIdImg);

		JLabel lblNewLabel_2 = new JLabel(
				"If you press submit you will have no more accessibility to the information that you have entered.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 350, 607, 24);
		panel.add(lblNewLabel_2);
	}
}
