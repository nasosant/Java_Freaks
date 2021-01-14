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

import java.sql.*;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

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
	protected static Object[] row = new Object[10];
	protected Confirmed[] con = new Confirmed[2];
	static Object[] column = { "Name", "Surname", "Email", "Phone Number", "SSN", "Area", "Street", "Street Number",
			"Zip", "Active Status" };
	protected Object[] column_1 = { "Name", "Surname", "Email", "Phone Number", "SSN", "Confirmed Id",
			"Victim Relationship", "Danger" };
	protected final static Object[] row_1 = new Object[8];
	protected static int number = -1;
	boolean flag = false;
	protected PersonJdbo persondao;
	protected JPanel panel;
	protected JLabel lblNewLabel;
	protected JLabel labelNameImg;
	protected JLabel lblSurname;
	protected JLabel labelSurNameImg;
	protected JLabel lblEmail;
	protected JLabel labelEmailImg;
	protected JLabel lblPhoneNumber;
	protected JLabel labelPhoneImg;
	protected JLabel lblSsn;
	protected JLabel labelAmkaImg;
	protected JScrollPane scrollPane;
	protected JLabel lblNewLabel_4;
	protected JLabel lblNewLabel_3;
	protected JLabel lblNewLabel_5;
	protected JLabel lblNewLabel_6;
	protected JLabel lblNewLabel_7;
	protected JRadioButton checkBoxYes;
	protected JRadioButton checkBoxNo;
	protected Image imgSubmit;
	protected Image imgCancel;
	protected JLabel labelArea;
	protected JLabel labelStreetImg;
	protected JLabel labelStreetNumberImg;
	protected JLabel labelZipImg;
	protected JLabel labelActiveStatusImg;
	protected JLabel labelAdd;
	protected Image imgAdd;
	private JLabel labelChange;
	private Image imgChange;
	private JLabel labelDelete;
	private Image imgDelete;
	private JLabel labelClear;
	private Image imgClear;
	private boolean flagAdd = true;

	public Platform() throws Exception {
		persondao = new PersonJdbo();
		draw();
		images();
		buttons();
		table();
	}

	public void draw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 535);
		setTitle("Personal information");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 0, 1309, 506);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 52, 45, 24);
		panel.add(lblNewLabel);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(10, 82, 63, 24);
		panel.add(lblSurname);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(11, 113, 45, 24);
		panel.add(lblEmail);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(11, 143, 98, 24);
		panel.add(lblPhoneNumber);

		lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSsn.setBounds(11, 173, 45, 24);
		panel.add(lblSsn);

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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 52, 979, 380);
		panel.add(scrollPane);

		lblNewLabel_3 = new JLabel("Area");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(11, 203, 37, 20);
		panel.add(lblNewLabel_3);

		areaText = new JTextField();
		areaText.setColumns(10);
		areaText.setBounds(129, 205, 160, 20);
		panel.add(areaText);

		lblNewLabel_4 = new JLabel("Street");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(11, 233, 46, 14);
		panel.add(lblNewLabel_4);

		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(129, 235, 160, 20);
		panel.add(streetText);

		lblNewLabel_5 = new JLabel("Street Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 263, 99, 19);
		panel.add(lblNewLabel_5);

		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		streetNumberText.setBounds(129, 295, 160, 20);
		panel.add(streetNumberText);

		lblNewLabel_6 = new JLabel("Zip");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(11, 293, 46, 14);
		panel.add(lblNewLabel_6);

		zipText = new JTextField();
		zipText.setColumns(10);
		zipText.setBounds(129, 265, 160, 20);
		panel.add(zipText);

		lblNewLabel_7 = new JLabel("Active Status");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 323, 88, 24);
		panel.add(lblNewLabel_7);

		checkBoxYes = new JRadioButton("Yes");
		checkBoxYes.setBounds(128, 322, 65, 25);
		panel.add(checkBoxYes);

		checkBoxNo = new JRadioButton("No");
		checkBoxNo.setBounds(223, 322, 65, 25);
		panel.add(checkBoxNo);

		JLabel lblNewLabel_1 = new JLabel("Enter the personal information as it appears on the ID.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(439, 20, 462, 20);
		panel.add(lblNewLabel_1);

	}

	public void buttons() {
		if (flagAdd) {
			JButton btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tempAMKA = ssnText.getText();
					if (nameText.getText().equals("") || surnameText.getText().equals("")
							|| emailText.getText().equals("") || phoneNumberText.getText().equals("")
							|| ssnText.getText().equals("") || areaText.getText().equals("")
							|| streetText.getText().equals("") || streetNumberText.getText().equals("")
							|| zipText.getText().equals("")
							|| (!checkBoxYes.isSelected() && !checkBoxNo.isSelected())) {
						JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
					} else if (checkAMKA(tempAMKA)) {
						JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN");
						ssnText.setText("");
					} else {
						number++;
						if (number < con.length) {
							row[0] = nameText.getText();
							row[1] = surnameText.getText();
							row[2] = emailText.getText();
							row[3] = phoneNumberText.getText();
							row[4] = tempAMKA;
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
								Confirmed patient = null;
								try {
									patient = new Confirmed((String) row[0], (String) row[1], (String) row[2],
											Integer.parseInt((String) row[3]), Integer.parseInt((String) row[4]),
											(String) row[5], (String) row[6], Integer.parseInt((String) row[7]),
											Integer.parseInt((String) row[8]), (boolean) row[9]);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								con[number] = patient;
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
						} else {
							JOptionPane.showMessageDialog(null,
									"You Can Not Add more Than 10 People At A Time! Press Submit.");
							flagAdd = false;
						}

					}
				}
			});

			btnNewButton.setBounds(299, 455, 230, 30);
			btnNewButton.setIcon(new ImageIcon(imgAdd));
			panel.add(btnNewButton);
		}
		JButton btnUpdate = new JButton("Change");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempAMKA = ssnText.getText();
				if (checkAMKA(tempAMKA)) {
					JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN");
					ssnText.setText("");
				} else {
					int i = table.getSelectedRow();
					if (i >= 0) {
						model.setValueAt(nameText.getText(), i, 0);
						model.setValueAt(surnameText.getText(), i, 1);
						model.setValueAt(emailText.getText(), i, 2);
						model.setValueAt(phoneNumberText.getText(), i, 3);
						model.setValueAt(tempAMKA, i, 4);
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
			}
		});
		btnUpdate.setBounds(550, 455, 230, 30);
		btnUpdate.setIcon(new ImageIcon(imgChange));
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
		btnClear.setBounds(1047, 455, 230, 30);
		btnClear.setIcon(new ImageIcon(imgClear));
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
		btnDelete.setBounds(800, 455, 230, 30);
		btnDelete.setIcon(new ImageIcon(imgDelete));
		panel.add(btnDelete);

		JButton buttonSub = new JButton("Submit");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (row[0] == null) {
					JOptionPane.showMessageDialog(null, "Please Add a Row First");
				} else {
					flagAdd = true;
					number = 0;
					try {
						for (int i = 0; i < con.length; i++) {
							if (con[i] != null) {
								persondao.addConfirmed(con[i]);
								con[i] = null;
							} else {
								break;
							}
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						Communication.sendMailToConfirmedCases((String) row[2]);
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
						System.out.println(e2.getCause());
					}

					dispose();
					new Message("Your personal information has been submited successfully. Thank you!", 120);
				}

			}
		});
		buttonSub.setBounds(10, 387, 245, 45);
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		panel.add(buttonSub);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PrintMenu();
			}
		});
		buttonCancel.setBounds(10, 440, 245, 45);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);

	}

	public void table() {
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
	}

	public void images() {
		labelClear = new JLabel("");
		imgClear = new ImageIcon(this.getClass().getResource("clear.png")).getImage();
		labelClear.setBounds(20, 40, 60, 40);

		labelDelete = new JLabel("");
		imgDelete = new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		labelDelete.setBounds(20, 40, 60, 40);

		labelChange = new JLabel("");
		imgChange = new ImageIcon(this.getClass().getResource("change.png")).getImage();
		labelChange.setBounds(20, 40, 60, 40);

		labelAdd = new JLabel("");
		imgAdd = new ImageIcon(this.getClass().getResource("addPatient.png")).getImage();
		labelAdd.setBounds(20, 40, 60, 40);

		labelActiveStatusImg = new JLabel("");
		Image imgActiveStatus = new ImageIcon(this.getClass().getResource("activeStatus.png")).getImage();
		labelActiveStatusImg.setIcon(new ImageIcon(imgActiveStatus));
		labelActiveStatusImg.setBounds(94, 322, 25, 25);
		panel.add(labelActiveStatusImg);

		labelZipImg = new JLabel("");
		Image imgZip = new ImageIcon(this.getClass().getResource("zip.png")).getImage();
		labelZipImg.setIcon(new ImageIcon(imgZip));
		labelZipImg.setBounds(42, 293, 25, 25);
		panel.add(labelZipImg);

		labelStreetNumberImg = new JLabel("");
		Image imgStreetNumber = new ImageIcon(this.getClass().getResource("streetNumber.png")).getImage();
		labelStreetNumberImg.setIcon(new ImageIcon(imgStreetNumber));
		labelStreetNumberImg.setBounds(103, 260, 25, 25);
		panel.add(labelStreetNumberImg);

		labelStreetImg = new JLabel("");
		Image imgStreet = new ImageIcon(this.getClass().getResource("street.png")).getImage();
		labelStreetImg.setIcon(new ImageIcon(imgStreet));
		labelStreetImg.setBounds(58, 230, 25, 25);
		panel.add(labelStreetImg);

		labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(54, 173, 25, 25);
		panel.add(labelAmkaImg);

		labelArea = new JLabel("");
		Image imgArea = new ImageIcon(this.getClass().getResource("area.png")).getImage();
		labelArea.setIcon(new ImageIcon(imgArea));
		labelArea.setBounds(42, 203, 25, 25);
		panel.add(labelArea);

		labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(106, 143, 25, 25);
		panel.add(labelPhoneImg);

		labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(54, 118, 25, 25);
		panel.add(labelEmailImg);

		labelSurNameImg = new JLabel("");
		Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelSurNameImg.setIcon(new ImageIcon(imgSurName));
		labelSurNameImg.setBounds(83, 82, 25, 25);
		panel.add(labelSurNameImg);

		labelNameImg = new JLabel("");
		Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelNameImg.setIcon(new ImageIcon(imgName));
		labelNameImg.setBounds(53, 52, 25, 25);
		panel.add(labelNameImg);

		JLabel labelSubmitImg = new JLabel("");
		imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		// labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);

		JLabel labelCancelImg = new JLabel("");
		imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		// labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);

		labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);

		JLabel labelIdImg = new JLabel("");
		Image imgId = new ImageIcon(this.getClass().getResource("id.png")).getImage();
		labelIdImg.setIcon(new ImageIcon(imgId));
		labelIdImg.setBounds(911, 11, 48, 36);
		panel.add(labelIdImg);
	}

	public static boolean checkAMKA(String tempAMKA) {
		PersonJdbo persondao = new PersonJdbo();
		try {
			persondao.connect();
			String query = "SELECT * FROM confirmed";
			Statement statement = persondao.connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int AMKA = resultSet.getInt("AMKA");
				if (AMKA == Integer.parseInt(tempAMKA)) {
					return true; // return true if finds same AMKA
				}
			}
		} catch (Exception e) {
			System.out.println("In Method: Platform.checkAMKA\nException: " + e.getMessage());
		}
		return false;
	}

}
