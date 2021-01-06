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
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

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
	final static Object[] row = new Object[10];
	static Object[] column = { "Name", "Surname", "Email", "Phone Number", "SSN", "Area", "Street", "Street Number",
			"Zip", "Active Status" };
	protected static int number = -1;
	private JTextField areaText;
	private JTextField streetText;
	private JTextField streetNumberText;
	private JTextField zipText;
	boolean flag = false;

	public Platform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 535);
		setTitle("Personal information");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		// panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1309, 506);
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
		nameText.setBounds(128, 52, 160, 20);
		panel.add(nameText);
		nameText.setColumns(10);

		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnameText.setBounds(128, 82, 160, 20);
		panel.add(surnameText);

		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(128, 112, 160, 20);
		panel.add(addressText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(128, 142, 160, 20);
		panel.add(emailText);

		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(128, 172, 160, 20);
		panel.add(phoneNumberText);

		ssnText = new JTextField();
		ssnText.setColumns(10);
		ssnText.setBounds(128, 204, 160, 20);
		panel.add(ssnText);

		areaText = new JTextField();
		areaText.setColumns(10);
		areaText.setBounds(128, 234, 160, 20);
		panel.add(areaText);

		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(128, 264, 160, 20);
		panel.add(streetText);

		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		streetNumberText.setBounds(128, 324, 160, 20);
		panel.add(streetNumberText);

		zipText = new JTextField();
		zipText.setColumns(10);
		zipText.setBounds(128, 294, 160, 20);
		panel.add(zipText);

		JCheckBox checkBoxYes = new JCheckBox("Yes");
		checkBoxYes.setBounds(124, 351, 53, 23);
		panel.add(checkBoxYes);

		JCheckBox checkBoxNo = new JCheckBox("No");
		checkBoxNo.setBounds(191, 351, 97, 23);
		panel.add(checkBoxNo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 56, 1001, 318);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nameText.setText(model.getValueAt(i, 0).toString());
				surnameText.setText(model.getValueAt(i, 1).toString());
				emailText.setText(model.getValueAt(i, 2).toString());
				phoneNumberText.setText(model.getValueAt(i, 3).toString());
				ssnText.setText(model.getValueAt(i, 4).toString());
				areaText.setText(model.getValueAt(i, 5).toString());
				streetText.setText(model.getValueAt(i, 6).toString());
				streetNumberText.setText(model.getValueAt(i, 7).toString());
				zipText.setText(model.getValueAt(i, 8).toString());
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
						|| phoneNumberText.getText().equals("") || ssnText.getText().equals("")
						|| areaText.getText().equals("") || streetText.getText().equals("")
						|| streetNumberText.getText().equals("") || zipText.getText().equals("")
						|| (!checkBoxYes.isSelected() && !checkBoxNo.isSelected())) {

					JOptionPane.showMessageDialog(null, "Pease Fill Complete Information");
				} else {
					number++;
					row[0] = nameText.getText();
					row[1] = surnameText.getText();
					row[2] = emailText.getText();
					row[3] = phoneNumberText.getText();
					row[4] = ssnText.getText();
					row[5] = areaText.getText();
					row[6] = streetText.getText();
					row[7] = streetNumberText.getText();
					row[8] = zipText.getText();
					if (checkBoxYes.isSelected() && checkBoxNo.isSelected()) {
						JOptionPane.showMessageDialog(null, "Pease Check Only One Box");
						flag = true;
					} else {
						if (checkBoxYes.isSelected()) {
						 	row[9] = "Yes";
						} else if (checkBoxNo.isSelected()) {
							row[9] = "No";
						}
						model.addRow(row);
						if (flag == false) {
							nameText.setText("");
							surnameText.setText("");
							addressText.setText("");
							emailText.setText("");
							phoneNumberText.setText("");
							ssnText.setText("");
							areaText.setText("");
							streetText.setText("");
							streetNumberText.setText("");
							zipText.setText("");
						}
					}

				}

			}
		});
		btnNewButton.setBounds(298, 387, 110, 25);
		panel.add(btnNewButton);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(nameText.getText(), i, 0);
					model.setValueAt(surnameText.getText(), i, 1);
					model.setValueAt(emailText.getText(), i, 2);
					model.setValueAt(phoneNumberText.getText(), i, 3);
					model.setValueAt(ssnText.getText(), i, 4);
					model.setValueAt(areaText.getText(), i, 5);
					model.setValueAt(streetText.getText(), i, 6);
					model.setValueAt(streetNumberText.getText(), i, 7);
					model.setValueAt(zipText.getText(), i, 8);
					if (checkBoxYes.isSelected()) {
						row[9] = true;
						model.setValueAt("Yes", i, 9);
					} else if (checkBoxNo.isSelected()) {
						row[9] = false;
						model.setValueAt("No", i, 9);
					}

					JOptionPane.showMessageDialog(null, "Updated Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnUpdate.setBounds(418, 387, 110, 25);
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
				areaText.setText("");
				streetText.setText("");
				streetNumberText.setText("");
				zipText.setText("");
			}
		});
		btnClear.setBounds(658, 387, 110, 25);
		panel.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = table.getSelectedRow();
				if (k >= 0) {
					model.removeRow(k);
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnDelete.setBounds(538, 387, 110, 25);
		panel.add(btnDelete);

		JLabel labelSubmitImg = new JLabel("");
		Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);

		JButton buttonSub = new JButton("Submit");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (row[0] == null) {
					JOptionPane.showMessageDialog(null, "Please Add a Row First");
				} else {
					PersonJdbo persondao = new PersonJdbo();
					int[] tel = { Integer.parseInt((String) row[3]), Integer.parseInt((String) row[3]) };
					try {
						Confirmed patient = new Confirmed((String) row[0], (String) row[1], (String) row[2], tel,
								Integer.parseInt((String) row[4]), (String) row[5], (String) row[6],
								Integer.parseInt((String) row[7]), Integer.parseInt((String) row[8]),
								Boolean.parseBoolean((String) row[9]));
						persondao.addConfirmed(patient);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					dispose();
					new Message("Your personal information has been submited successfully. Thank you!", 120);
				}

			}
		});
		buttonSub.setBounds(58, 435, 245, 45);
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
		buttonCancel.setBounds(347, 435, 240, 45);
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

		JLabel lblNewLabel_2 = new JLabel(
				"If you press submit you will have no more accessibility to the information that you have entered.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 412, 607, 24);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Area");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 232, 37, 20);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Street");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 262, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Street Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(9, 292, 121, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Zip");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 322, 46, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Active Status");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(9, 352, 88, 24);
		panel.add(lblNewLabel_7);

	}
}
