import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.EventQueue;

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

	protected String nameNew;
	protected String surnameNew;
	protected String emailNew;
	protected int phoneNumberNew;
	protected int ssnNew;
	protected int confirmed_idNew;
	protected String victim_relationshipNew;
	protected String dangerNew;
	protected String areaNew;
	protected String streetNew;
	protected int streetNumberNew;
	protected int zipNew;
	protected String areaTemp;
	protected String streetTemp;
	protected int streetNumberTemp;
	protected int zipTemp;
	protected String nameTemp;
	protected String surnameTemp;
	protected String emailTemp;
	protected int phoneNumberTemp;
	protected int ssnTemp;
	protected int confirmed_idTemp;
	protected String victim_relationshipTemp;
	protected String dangerTemp;
	protected static JButton buttonSub;
	protected static JTextField nameText;
	protected static JTextField surnameText;
	protected static JTextField emailText;
	protected static JTextField phoneNumberText;
	protected static JTextField ssnText;
	protected static JTextField confirmed_idText;
	protected static JTextField victim_relationshipText;
	protected static JTextField dangerText;
	protected JTextField areaText;
	protected JTextField streetText;
	protected JTextField streetNumberText;
	protected JTextField zipText;
	protected JPanel contentPane;
	protected JTable table;
	protected static JLabel labelChangeUserImg;
	protected static DefaultTableModel model;
	final static Object[] row = new Object[10];
	static Object[] column = { "Name", "Surname", "Email", "Phone Number", "SSN", "Area", "Street", "Street Number",
			"Zip", "Active Status" };
	protected Object[] column_1 = { "Name", "Surname", "Email", "Phone Number", "SSN", "Confirmed Id",
			"Victim Relationship", "Danger" };
	protected final static Object[] row_1 = new Object[8];
	protected static int number = -1;

	boolean flag = false;

	public Platform(String who) throws Exception {
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
		Image imgAddress = new ImageIcon(this.getClass().getResource("address.png")).getImage();

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(11, 113, 45, 24);
		panel.add(lblEmail);

		JLabel labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(54, 118, 25, 25);
		panel.add(labelEmailImg);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(11, 143, 98, 24);
		panel.add(lblPhoneNumber);

		JLabel labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(106, 143, 25, 25);
		panel.add(labelPhoneImg);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSsn.setBounds(11, 173, 45, 24);
		panel.add(lblSsn);

		JLabel labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(54, 173, 25, 25);
		panel.add(labelAmkaImg);

		nameText = new JTextField();
		nameText.setBounds(128, 52, 160, 20);
		panel.add(nameText);
		nameText.setColumns(10);

		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnameText.setBounds(128, 82, 160, 20);
		panel.add(surnameText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(129, 113, 160, 20);
		panel.add(emailText);

		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(129, 143, 160, 20);
		panel.add(phoneNumberText);

		ssnText = new JTextField();
		ssnText.setColumns(10);
		ssnText.setBounds(129, 175, 160, 20);
		panel.add(ssnText);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 56, 1000, 318);
		panel.add(scrollPane);

		PersonJdbo persondao = new PersonJdbo();

		if (who == "c") {

			JLabel lblNewLabel_3 = new JLabel("Area");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(11, 203, 37, 20);
			panel.add(lblNewLabel_3);

			areaText = new JTextField();
			areaText.setColumns(10);
			areaText.setBounds(129, 205, 160, 20);
			panel.add(areaText);

			JLabel lblNewLabel_4 = new JLabel("Street");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(11, 233, 46, 14);
			panel.add(lblNewLabel_4);

			streetText = new JTextField();
			streetText.setColumns(10);
			streetText.setBounds(129, 235, 160, 20);
			panel.add(streetText);

			JLabel lblNewLabel_5 = new JLabel("Street Number");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(10, 263, 121, 14);
			panel.add(lblNewLabel_5);

			streetNumberText = new JTextField();
			streetNumberText.setColumns(10);
			streetNumberText.setBounds(129, 265, 160, 20);
			panel.add(streetNumberText);

			JLabel lblNewLabel_6 = new JLabel("Zip");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_6.setBounds(11, 293, 46, 14);
			panel.add(lblNewLabel_6);

			zipText = new JTextField();
			zipText.setColumns(10);
			zipText.setBounds(129, 295, 160, 20);
			panel.add(zipText);

			JLabel lblNewLabel_7 = new JLabel("Active Status");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_7.setBounds(10, 323, 88, 24);
			panel.add(lblNewLabel_7);

			JCheckBox checkBoxYes = new JCheckBox("Yes");
			checkBoxYes.setBounds(125, 322, 53, 23);
			panel.add(checkBoxYes);

			JCheckBox checkBoxNo = new JCheckBox("No");
			checkBoxNo.setBounds(192, 322, 97, 23);
			panel.add(checkBoxNo);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow();
					nameText.setText(model.getValueAt(i, 0).toString());
					nameTemp = model.getValueAt(i, 0).toString();
					surnameText.setText(model.getValueAt(i, 1).toString());
					surnameTemp = model.getValueAt(i, 1).toString();
					emailText.setText(model.getValueAt(i, 2).toString());
					emailTemp = model.getValueAt(i, 2).toString();
					phoneNumberText.setText(model.getValueAt(i, 3).toString());
					phoneNumberTemp = Integer.parseInt(model.getValueAt(i, 3).toString());
					ssnText.setText(model.getValueAt(i, 4).toString());
					ssnTemp = Integer.parseInt(model.getValueAt(i, 4).toString());
					areaText.setText(model.getValueAt(i, 5).toString());
					areaTemp = model.getValueAt(i, 5).toString();
					streetText.setText(model.getValueAt(i, 6).toString());
					streetTemp = model.getValueAt(i, 6).toString();
					streetNumberText.setText(model.getValueAt(i, 7).toString());
					streetNumberTemp = Integer.parseInt(model.getValueAt(i, 7).toString());
					zipText.setText(model.getValueAt(i, 8).toString());
					zipTemp = Integer.parseInt(model.getValueAt(i, 8).toString());
				}
			});
			scrollPane.setViewportView(table);
			table.setBackground(new Color(211, 211, 211));
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table.setModel(model);

			JButton btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (nameText.getText().equals("") || surnameText.getText().equals("")
							|| emailText.getText().equals("") || phoneNumberText.getText().equals("")
							|| ssnText.getText().equals("") || areaText.getText().equals("")
							|| streetText.getText().equals("") || streetNumberText.getText().equals("")
							|| zipText.getText().equals("")
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
								row[9] = true;
							} else if (checkBoxNo.isSelected()) {
								row[9] = false;
							}
							model.addRow(row);
							if (flag == false) {
								nameText.setText("");
								surnameText.setText("");
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
			btnNewButton.setBounds(300, 385, 230, 25);
			panel.add(btnNewButton);

			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i >= 0) {
						model.setValueAt(nameText.getText(), i, 0);
						nameNew = nameText.getText();
						model.setValueAt(surnameText.getText(), i, 1);
						surnameNew = surnameText.getText();
						model.setValueAt(emailText.getText(), i, 2);
						emailNew = emailText.getText();
						model.setValueAt(phoneNumberText.getText(), i, 3);
						phoneNumberNew = Integer.parseInt(phoneNumberText.getText());
						model.setValueAt(ssnText.getText(), i, 4);
						ssnNew = Integer.parseInt(ssnText.getText());
						model.setValueAt(areaText.getText(), i, 5);
						areaNew = areaText.getText();
						model.setValueAt(streetText.getText(), i, 6);
						streetNew = streetText.getText();
						model.setValueAt(streetNumberText.getText(), i, 7);
						streetNumberNew = Integer.parseInt(streetNumberText.getText());
						model.setValueAt(zipText.getText(), i, 8);
						zipNew = Integer.parseInt(zipText.getText());
						if (checkBoxYes.isSelected()) {
							row[9] = true;
							model.setValueAt(true, i, 9);
						} else if (checkBoxNo.isSelected()) {
							row[9] = false;
							model.setValueAt(false, i, 9);
						}

						JOptionPane.showMessageDialog(null, "Updated Successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}

				}
			});
			btnUpdate.setBounds(560, 385, 230, 25);
			panel.add(btnUpdate);

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameText.setText("");
					surnameText.setText("");
					emailText.setText("");
					phoneNumberText.setText("");
					ssnText.setText("");
					areaText.setText("");
					streetText.setText("");
					streetNumberText.setText("");
					zipText.setText("");
				}
			});
			btnClear.setBounds(1070, 385, 230, 25);
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
			btnDelete.setBounds(814, 385, 230, 25);
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
						try {
							// Na vro to id kai na to valo sti methofo alterTables
							if (nameTemp != nameNew) {
								String s = AllPeople.setName(nameNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (surnameTemp != surnameNew) {
								String s = AllPeople.setSurname(surnameNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (!emailTemp.equals(emailNew)) {
								String s = AllPeople.setEmail(emailNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (phoneNumberTemp != phoneNumberNew) {
								String s = AllPeople.setPhonenumber(phoneNumberNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (ssnTemp != ssnNew) {
								String s = AllPeople.setAMKA(ssnNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (areaTemp != areaNew) {
								String s = Confirmed.setArea(areaNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (streetTemp != streetNew) {
								String s = Confirmed.setStreet(streetNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (streetNumberTemp != streetNumberNew) {
								String s = Confirmed.setStreet_number(streetNumberNew);
								persondao.alterTables(2, "confirmed", s);
							}
							if (zipTemp != zipNew) {
								String s = Confirmed.setZip(zipNew);
								persondao.alterTables(2, "confirmed", s);
							}
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						// import vivliothiki
						// Communication.sendMailToConfirmedCases((String) row[2]);
						dispose();
						new Message("Your personal information has been submited successfully. Thank you!", 120);
					}

				}
			});
			buttonSub.setBounds(10, 439, 245, 45);
			buttonSub.setIcon(new ImageIcon(imgSubmit));
			panel.add(buttonSub);

			int count = persondao.check("confirmed");
			for (int i = 1; i <= count; i++) {
				Confirmed patient = (Confirmed) persondao.showAll("confirmed", i);
				if (patient == null) {
					count++;
				} else {
					row[0] = patient.name;
					row[1] = patient.surname;
					row[2] = patient.email;
					row[3] = patient.phonenumber;
					row[4] = patient.AMKA;
					row[5] = patient.area;
					row[6] = patient.street;
					row[7] = patient.street_number;
					row[8] = patient.zip;
					row[9] = patient.active_status;
					model.addRow(row);
				}
			}

		} else if (who == "v") {

			JLabel lblNewLabel_3 = new JLabel("Confirmed Id");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(11, 203, 100, 20);
			panel.add(lblNewLabel_3);

			confirmed_idText = new JTextField();
			confirmed_idText.setColumns(10);
			confirmed_idText.setBounds(129, 205, 160, 20);
			panel.add(confirmed_idText);

			JLabel lblNewLabel_4 = new JLabel("Victim Relationship");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(11, 233, 100, 14);
			panel.add(lblNewLabel_4);

			victim_relationshipText = new JTextField();
			victim_relationshipText.setColumns(10);
			victim_relationshipText.setBounds(129, 235, 160, 20);
			panel.add(victim_relationshipText);

			JLabel lblNewLabel_5 = new JLabel("Danger");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(10, 263, 121, 20);
			panel.add(lblNewLabel_5);

			dangerText = new JTextField();
			dangerText.setColumns(10);
			dangerText.setBounds(129, 265, 160, 20);
			panel.add(dangerText);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow();
					nameText.setText(model.getValueAt(i, 0).toString());
					nameTemp = model.getValueAt(i, 0).toString();
					surnameText.setText(model.getValueAt(i, 1).toString());
					surnameTemp = model.getValueAt(i, 1).toString();
					emailText.setText(model.getValueAt(i, 2).toString());
					emailTemp = model.getValueAt(i, 2).toString();
					phoneNumberText.setText(model.getValueAt(i, 3).toString());
					phoneNumberTemp = Integer.parseInt(model.getValueAt(i, 3).toString());
					ssnText.setText(model.getValueAt(i, 4).toString());
					ssnTemp = Integer.parseInt(model.getValueAt(i, 4).toString());
					confirmed_idText.setText(model.getValueAt(i, 5).toString());
					confirmed_idTemp = Integer.parseInt(model.getValueAt(i, 5).toString());
					victim_relationshipText.setText(model.getValueAt(i, 6).toString());
					victim_relationshipTemp = model.getValueAt(i, 6).toString();
					dangerText.setText(model.getValueAt(i, 7).toString());
					dangerTemp = model.getValueAt(i, 7).toString();
				}
			});
			scrollPane.setViewportView(table);
			table.setBackground(new Color(211, 211, 211));
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column_1);
			table.setModel(model);
			JButton btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (nameText.getText().equals("") || surnameText.getText().equals("")
							|| emailText.getText().equals("") || phoneNumberText.getText().equals("")
							|| ssnText.getText().equals("") || confirmed_idText.getText().equals("")
							|| victim_relationshipText.getText().equals("") || dangerText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Pease Fill Complete Information");
					} else {
						number++;
						row_1[0] = nameText.getText();
						row_1[1] = surnameText.getText();
						row_1[2] = emailText.getText();
						row_1[3] = phoneNumberText.getText();
						row_1[4] = ssnText.getText();
						row_1[5] = confirmed_idText.getText();
						row_1[6] = victim_relationshipText.getText();
						row_1[7] = dangerText.getText();
						model.addRow(row_1);
						if (flag == false) {
							nameText.setText("");
							surnameText.setText("");
							emailText.setText("");
							phoneNumberText.setText("");
							ssnText.setText("");
							confirmed_idText.setText("");
							victim_relationshipText.setText("");
							dangerText.setText("");
						}
					}

				}
			});
			btnNewButton.setBounds(300, 385, 230, 25);
			panel.add(btnNewButton);

			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i >= 0) {
						model.setValueAt(nameText.getText(), i, 0);
						nameNew = nameText.getText();
						model.setValueAt(surnameText.getText(), i, 1);
						surnameNew = surnameText.getText();
						model.setValueAt(emailText.getText(), i, 2);
						emailNew = emailText.getText();
						model.setValueAt(phoneNumberText.getText(), i, 3);
						phoneNumberNew = Integer.parseInt(phoneNumberText.getText());
						model.setValueAt(ssnText.getText(), i, 4);
						ssnNew = Integer.parseInt(ssnText.getText());
						model.setValueAt(confirmed_idText.getText(), i, 5);
						confirmed_idNew = Integer.parseInt(confirmed_idText.getText());
						model.setValueAt(victim_relationshipText.getText(), i, 6);
						victim_relationshipNew = victim_relationshipText.getText();
						model.setValueAt(dangerText.getText(), i, 7);
						dangerNew = dangerText.getText();
						JOptionPane.showMessageDialog(null, "Updated Successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}

				}
			});
			btnUpdate.setBounds(560, 385, 230, 25);
			panel.add(btnUpdate);

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameText.setText("");
					surnameText.setText("");
					emailText.setText("");
					phoneNumberText.setText("");
					ssnText.setText("");
					confirmed_idText.setText("");
					victim_relationshipText.setText("");
					dangerText.setText("");
				}
			});
			btnClear.setBounds(1070, 385, 230, 25);
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
			btnDelete.setBounds(814, 385, 230, 25);
			panel.add(btnDelete);

			JLabel labelSubmitImg = new JLabel("");
			Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
			labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
			labelSubmitImg.setBounds(5, 240, 25, 25);

			JButton buttonSub = new JButton("Submit");
			buttonSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (row_1[0] == null) {
						JOptionPane.showMessageDialog(null, "Please Add a Row First");
					} else {
						try {
							// Na vro to id kai na to valo sti methofo alterTables
							if (nameTemp != nameNew) {
								String s = AllPeople.setName(nameNew);
								persondao.alterTables(2, "victim_contacts", s);
							}

							if (surnameTemp != surnameNew) {
								String s = AllPeople.setSurname(surnameNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (emailTemp != emailNew) {
								String s = AllPeople.setEmail(emailNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (phoneNumberTemp != phoneNumberNew) {
								String s = AllPeople.setPhonenumber(phoneNumberNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (ssnTemp != ssnNew) {
								String s = AllPeople.setAMKA(ssnNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (confirmed_idTemp != confirmed_idNew) {
								String s = VictimContact.setConfirmed_id(confirmed_idNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (victim_relationshipTemp != victim_relationshipNew) {
								String s = VictimContact.setVictim_relationship(victim_relationshipNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
							if (dangerTemp != dangerNew) {
								String s = VictimContact.setDanger(dangerNew);
								persondao.alterTables(2, "victim_contacts", s);
							}
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
							System.out.println("In Method: Submit(Line 568)\nException: " + e1.getMessage());
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("In Metho2d: Submit(Line 568)\nException: " + e1.getMessage());
						}
						// import vivliothiki
						// Communication.sendMailToConfirmedCases((String) row[2]);
						dispose();
						new Message("Your personal information has been submited successfully. Thank you!", 120);
					}

				}
			});
			buttonSub.setBounds(10, 439, 245, 45);
			buttonSub.setIcon(new ImageIcon(imgSubmit));
			panel.add(buttonSub);

			int count_1 = persondao.check("victim_contacts");
			for (int i = 1; i <= count_1; i++) {
				VictimContact victim = (VictimContact) persondao.showAll("victim_contacts", i);
				if (victim == null) {
					count_1++;
				} else {
					row_1[0] = victim.name;
					row_1[1] = victim.surname;
					row_1[2] = victim.email;
					row_1[3] = victim.phonenumber;
					row_1[4] = victim.AMKA;
					row_1[5] = victim.confirmed_id;
					row_1[6] = victim.victim_relationship;
					row_1[7] = victim.danger;
					model.addRow(row_1);
				}
			}
		} else if (who == "null") {

			JLabel lblNewLabel_3 = new JLabel("Area");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(11, 203, 37, 20);
			panel.add(lblNewLabel_3);

			areaText = new JTextField();
			areaText.setColumns(10);
			areaText.setBounds(129, 205, 160, 20);
			panel.add(areaText);

			JLabel lblNewLabel_4 = new JLabel("Street");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(11, 233, 46, 14);
			panel.add(lblNewLabel_4);

			streetText = new JTextField();
			streetText.setColumns(10);
			streetText.setBounds(129, 235, 160, 20);
			panel.add(streetText);

			JLabel lblNewLabel_5 = new JLabel("Street Number");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(10, 263, 121, 14);
			panel.add(lblNewLabel_5);

			streetNumberText = new JTextField();
			streetNumberText.setColumns(10);
			streetNumberText.setBounds(129, 295, 160, 20);
			panel.add(streetNumberText);

			JLabel lblNewLabel_6 = new JLabel("Zip");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_6.setBounds(11, 293, 46, 14);
			panel.add(lblNewLabel_6);

			zipText = new JTextField();
			zipText.setColumns(10);
			zipText.setBounds(129, 265, 160, 20);
			panel.add(zipText);

			JLabel lblNewLabel_7 = new JLabel("Active Status");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_7.setBounds(10, 323, 88, 24);
			panel.add(lblNewLabel_7);

			JCheckBox checkBoxYes = new JCheckBox("Yes");
			checkBoxYes.setBounds(125, 322, 53, 23);
			panel.add(checkBoxYes);

			JCheckBox checkBoxNo = new JCheckBox("No");
			checkBoxNo.setBounds(192, 322, 97, 23);
			panel.add(checkBoxNo);

			JButton btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (nameText.getText().equals("") || surnameText.getText().equals("")
							|| emailText.getText().equals("") || phoneNumberText.getText().equals("")
							|| ssnText.getText().equals("") || areaText.getText().equals("")
							|| streetText.getText().equals("") || streetNumberText.getText().equals("")
							|| zipText.getText().equals("")
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
								row[9] = true;
							} else if (checkBoxNo.isSelected()) {
								row[9] = false;
							}
							model.addRow(row);
							if (flag == false) {
								nameText.setText("");
								surnameText.setText("");
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
			btnNewButton.setBounds(300, 385, 230, 25);
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
							model.setValueAt(true, i, 9);
						} else if (checkBoxNo.isSelected()) {
							row[9] = false;
							model.setValueAt(false, i, 9);
						}

						JOptionPane.showMessageDialog(null, "Updated Successfully");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}

				}
			});
			btnUpdate.setBounds(560, 385, 230, 25);
			panel.add(btnUpdate);

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameText.setText("");
					surnameText.setText("");
					emailText.setText("");
					phoneNumberText.setText("");
					ssnText.setText("");
					areaText.setText("");
					streetText.setText("");
					streetNumberText.setText("");
					zipText.setText("");
				}
			});
			btnClear.setBounds(1070, 385, 230, 25);
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
			btnDelete.setBounds(814, 385, 230, 25);
			panel.add(btnDelete);

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
						try {
							Confirmed patient = new Confirmed((String) row[0], (String) row[1], (String) row[2],
									Integer.parseInt((String) row[3]), Integer.parseInt((String) row[4]),
									(String) row[5], (String) row[6], Integer.parseInt((String) row[7]),
									Integer.parseInt((String) row[8]), (boolean) row[9]);
							persondao.addConfirmed(patient);
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						// import vivliothiki
						// Communication.sendMailToConfirmedCases((String) row[2]);
						dispose();
						new Message("Your personal information has been submited successfully. Thank you!", 120);
					}

				}
			});
			buttonSub.setBounds(10, 439, 245, 45);
			buttonSub.setIcon(new ImageIcon(imgSubmit));
			panel.add(buttonSub);

		}

		JLabel labelCancelImg = new JLabel("");
		Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (who == "c" || who == "v") {
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
				} else {
					dispose();
					new PrintMenu();
				}

			}
		});
		buttonCancel.setBounds(279, 439, 240, 45);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);

		labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);

		JLabel lblNewLabel_1 = new JLabel("Enter the personal information as it appears on the police ID.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(387, 20, 502, 20);
		panel.add(lblNewLabel_1);

		JLabel labelIdImg = new JLabel("");
		Image imgId = new ImageIcon(this.getClass().getResource("id.png")).getImage();
		labelIdImg.setIcon(new ImageIcon(imgId));
		labelIdImg.setBounds(899, 9, 48, 36);
		panel.add(labelIdImg);

		JLabel lblNewLabel_2 = new JLabel(
				"If you press submit you will have no more accessibility to the information that you have entered.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 413, 607, 25);
		panel.add(lblNewLabel_2);
	}

}
