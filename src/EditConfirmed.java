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
import javax.swing.JRadioButton;

public class EditConfirmed extends JFrame {

	protected int repeatedly = 0;
	protected static JTextField nameText;
	protected static JTextField surnameText;
	protected static JTextField emailText;
	protected static JTextField phoneNumberText;
	protected static JTextField ssnText;
	protected static JTextField confirmed_idText;
	protected static JTextField victim_relationshipText;
	protected static JTextField dangerText;
	protected static JTextField areaText;
	protected static JTextField streetText;
	protected static JTextField streetNumberText;
	protected static JTextField zipText;
	protected JPanel contentPane;
	protected JTable table;
	protected static JLabel labelChangeUserImg;
	protected static DefaultTableModel model;
	protected static Object[] column = { "Name", "Surname", "Email", "Phone Number", "SSN", "Area", "Street",
			"Street Number", "Zip", "Active Status", "Id" };
	final static Object[] row = new Object[11];
	protected String[][] matrixNew = new String[10][10];
	protected String[][] matrixTemp = new String[11][10];
	protected int[] idToDelete = new int[10];
	protected static int numberDel = -1;
	protected static int numberNew = -1;
	protected static int numberTemp = -1;
	boolean flag = false;
	protected JPanel panel;
	// Label
	protected JLabel lblName;
	protected JLabel lblSurname;
	protected JLabel lblEmail;
	protected JLabel lblPhoneNumber;
	protected JLabel lblSsn;
	protected JLabel lblArea;
	protected JLabel lblStreet;
	protected JLabel lblStreetNumber;
	protected JLabel lblZip;
	protected JLabel lblActiveStatus;
	// Label Images
	protected JLabel labelNameImg;
	protected JLabel labelSurNameImg;
	protected JLabel labelEmailImg;
	protected JLabel labelPhoneImg;
	protected JLabel labelAmkaImg;
	protected JLabel labelArea;
	protected JLabel labelStreetImg;
	protected JLabel labelStreetNumberImg;
	protected JLabel labelZipImg;
	protected JLabel labelActiveStatusImg;
	// Images
	protected Image imgSubmit;
	protected Image imgCancel;
	protected Image imgChangeUser;
	protected Image imgId;
	protected Image imgUpdate;
	protected Image imgDelete;
	protected Image imgClear;

	protected JScrollPane scrollPane;
	protected JRadioButton checkBoxYes;
	protected JRadioButton checkBoxNo;
	protected PersonJdbo persondao;
	protected int id;
	private boolean flagUpdate = true;
	protected JLabel labelSubmitImg;
	private JLabel labelUpdateImg;
	private JLabel labelDeleteImg;
	private JLabel labelClearImg;
	protected JLabel labelCancelImg;

	public EditConfirmed() throws Exception {
		persondao = new PersonJdbo();
		draw();
		images();
		table();
		dataBase();
		buttons();
	}

	public void draw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 546);
		setTitle("Edit Confirmed Cases");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1309, 517);
		contentPane.add(panel);
		panel.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 52, 45, 24);
		panel.add(lblName);

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

		lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(11, 203, 37, 20);
		panel.add(lblArea);

		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreet.setBounds(11, 233, 46, 14);
		panel.add(lblStreet);

		lblStreetNumber = new JLabel("Street Number");
		lblStreetNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNumber.setBounds(10, 263, 121, 14);
		panel.add(lblStreetNumber);

		lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZip.setBounds(11, 293, 46, 14);
		panel.add(lblZip);

		lblActiveStatus = new JLabel("Active Status");
		lblActiveStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActiveStatus.setBounds(10, 323, 88, 24);
		panel.add(lblActiveStatus);

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

		areaText = new JTextField();
		areaText.setColumns(10);
		areaText.setBounds(129, 205, 160, 20);
		panel.add(areaText);

		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(129, 235, 160, 20);
		panel.add(streetText);

		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		streetNumberText.setBounds(129, 265, 160, 20);
		panel.add(streetNumberText);

		zipText = new JTextField();
		zipText.setColumns(10);
		zipText.setBounds(129, 295, 160, 20);
		panel.add(zipText);

		checkBoxYes = new JRadioButton("Yes");
		checkBoxYes.setBounds(125, 322, 53, 23);
		panel.add(checkBoxYes);

		checkBoxNo = new JRadioButton("No");
		checkBoxNo.setBounds(192, 322, 97, 23);
		panel.add(checkBoxNo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 52, 1002, 396);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Here you can edit every person's information.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(586, 21, 384, 20);
		panel.add(lblNewLabel_1);
	}

	public void images() {
		labelNameImg = new JLabel("");
		Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelNameImg.setIcon(new ImageIcon(imgName));
		labelNameImg.setBounds(83, 52, 25, 25);
		panel.add(labelNameImg);

		labelSurNameImg = new JLabel("");
		Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelSurNameImg.setIcon(new ImageIcon(imgSurName));
		labelSurNameImg.setBounds(83, 82, 25, 25);
		panel.add(labelSurNameImg);

		labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(54, 118, 25, 25);
		panel.add(labelEmailImg);

		labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(106, 143, 25, 25);
		panel.add(labelPhoneImg);

		labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(54, 173, 25, 25);
		panel.add(labelAmkaImg);

		imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		/*
		 * labelSubmitImg = new JLabel(""); imgSubmit = new
		 * ImageIcon(this.getClass().getResource("submit.png")).getImage();
		 * labelSubmitImg.setIcon(new ImageIcon(imgSubmit)); labelSubmitImg.setBounds(5,
		 * 240, 25, 25);
		 */

		labelCancelImg = new JLabel("");
		imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);

		labelChangeUserImg = new JLabel("");
		imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);

		labelArea = new JLabel("");
		Image imgArea = new ImageIcon(this.getClass().getResource("area.png")).getImage();
		labelArea.setIcon(new ImageIcon(imgArea));
		labelArea.setBounds(42, 203, 25, 25);
		panel.add(labelArea);

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
		labelStreetNumberImg.setBounds(105, 260, 25, 25);
		panel.add(labelStreetNumberImg);

		labelStreetImg = new JLabel("");
		Image imgStreet = new ImageIcon(this.getClass().getResource("street.png")).getImage();
		labelStreetImg.setIcon(new ImageIcon(imgStreet));
		labelStreetImg.setBounds(58, 230, 25, 25);
		panel.add(labelStreetImg);

		labelUpdateImg = new JLabel("");
		imgUpdate = new ImageIcon(this.getClass().getResource("update.png")).getImage();
		labelUpdateImg.setBounds(58, 230, 25, 25);
		panel.add(labelUpdateImg);

		labelDeleteImg = new JLabel("");
		imgDelete = new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		labelDeleteImg.setBounds(58, 230, 25, 25);
		panel.add(labelDeleteImg);

		labelClearImg = new JLabel("");
		imgClear = new ImageIcon(this.getClass().getResource("clear.png")).getImage();
		labelClearImg.setBounds(58, 230, 25, 25);
		panel.add(labelClearImg);

		JLabel labelEditImg = new JLabel("");
		Image imgEdit = new ImageIcon(this.getClass().getResource("edit.png")).getImage();
		labelEditImg.setBounds(967, 16, 25, 25);
		labelEditImg.setIcon(new ImageIcon(imgEdit));
		panel.add(labelEditImg);
	}

	public void table() {
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				repeatedly++;
				if (repeatedly != 1) {
					numberTemp--;
				}
				numberTemp++;
				int i = table.getSelectedRow();

				nameText.setText(model.getValueAt(i, 0).toString());
				matrixTemp[numberTemp][0] = model.getValueAt(i, 0).toString();

				surnameText.setText(model.getValueAt(i, 1).toString());
				matrixTemp[numberTemp][1] = model.getValueAt(i, 1).toString();

				emailText.setText(model.getValueAt(i, 2).toString());
				matrixTemp[numberTemp][2] = model.getValueAt(i, 2).toString();

				phoneNumberText.setText(model.getValueAt(i, 3).toString());
				matrixTemp[numberTemp][3] = model.getValueAt(i, 3).toString();

				ssnText.setText(model.getValueAt(i, 4).toString());
				matrixTemp[numberTemp][4] = model.getValueAt(i, 4).toString();

				areaText.setText(model.getValueAt(i, 5).toString());
				matrixTemp[numberTemp][5] = model.getValueAt(i, 5).toString();

				streetText.setText(model.getValueAt(i, 6).toString());
				matrixTemp[numberTemp][6] = model.getValueAt(i, 6).toString();

				streetNumberText.setText(model.getValueAt(i, 7).toString());
				matrixTemp[numberTemp][7] = model.getValueAt(i, 7).toString();

				zipText.setText(model.getValueAt(i, 8).toString());
				matrixTemp[numberTemp][8] = model.getValueAt(i, 8).toString();

				matrixTemp[numberTemp][9] = model.getValueAt(i, 10).toString();
			}

		});
		scrollPane.setViewportView(table);
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
	}

	public void buttons() {
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flagUpdate) {
					String tempAMKA = ssnText.getText();
					if (!matrixTemp[numberTemp][4].equals(tempAMKA) && Platform.checkAMKA(tempAMKA)) {
						JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN");
						ssnText.setText("");
					} else {
						numberNew++;
						if (numberNew < 10) {
							int i = table.getSelectedRow();
							if (i >= 0) {
								model.setValueAt(nameText.getText(), i, 0);
								matrixNew[numberNew][0] = nameText.getText();

								model.setValueAt(surnameText.getText(), i, 1);
								matrixNew[numberNew][1] = surnameText.getText();

								model.setValueAt(emailText.getText(), i, 2);
								matrixNew[numberNew][2] = emailText.getText();

								model.setValueAt(phoneNumberText.getText(), i, 3);
								matrixNew[numberNew][3] = phoneNumberText.getText();

								model.setValueAt(tempAMKA, i, 4);
								matrixNew[numberNew][4] = tempAMKA;

								model.setValueAt(areaText.getText(), i, 5);
								matrixNew[numberNew][5] = areaText.getText();

								model.setValueAt(streetText.getText(), i, 6);
								matrixNew[numberNew][6] = streetText.getText();

								model.setValueAt(streetNumberText.getText(), i, 7);
								matrixNew[numberNew][7] = streetNumberText.getText();

								model.setValueAt(zipText.getText(), i, 8);
								matrixNew[numberNew][8] = zipText.getText();

								repeatedly = 0;
							} else {
								JOptionPane.showMessageDialog(null, "Please Select a Row First");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"You Can Not Update more Than 10 People At A Time! Press Submit.");
							flagUpdate = false;
						}
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"You Can Not Update more Than 10 People At A Time! Press Submit.");
				}
			}
		});
		btnUpdate.setBounds(298, 459, 230, 25);
		btnUpdate.setIcon(new ImageIcon(imgUpdate));
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
		btnClear.setBounds(1069, 459, 230, 25);
		btnClear.setIcon(new ImageIcon(imgClear));
		panel.add(btnClear);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = table.getSelectedRow();
				if (k >= 0) {
					numberDel++;
					idToDelete[numberDel] = Integer.parseInt(model.getValueAt(k, 10).toString());
					model.removeRow(k);
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnDelete.setBounds(684, 459, 230, 25);
		btnDelete.setIcon(new ImageIcon(imgDelete));
		panel.add(btnDelete);

		JButton buttonSub = new JButton("Submit");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numberDel > -1) {
					for (int i = 0; i < idToDelete.length; i++) {
						try {
							persondao.removePerson(idToDelete[i], "confirmed");
							JOptionPane.showMessageDialog(null, "Deleted Successfully");
						} catch (Exception e1) {
							System.out.println("In Method: EditConfirmed.DeleteButton\nException: " + e1.getMessage());
						}
						if (idToDelete[i + 1] == 0) {
							break;
						}
					}
				}
				if (row[0] == null) {
					JOptionPane.showMessageDialog(null, "Please Pick a Row First");
				} else {
					flagUpdate = true;
					numberNew = 0;
					for (int i = 0; i < 10; i++) {
						if (matrixTemp[i][0] != null) {
							try {
								if (!matrixTemp[i][0].equals(matrixNew[i][0])) {
									String s = AllPeople.setName(matrixNew[i][0]);
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][1].equals(matrixNew[i][1])) {
									String s = AllPeople.setSurname(matrixNew[i][1]);
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][2].equals(matrixNew[i][2])) {
									String s = AllPeople.setEmail(matrixNew[i][2]);
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][3].equals(matrixNew[i][3])) {
									String s = AllPeople.setPhonenumber(Integer.parseInt(matrixNew[i][3]));
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][4].equals(matrixNew[i][4])) {
									String s = AllPeople.setAMKA(Integer.parseInt(matrixNew[i][4]));
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][5].equals(matrixNew[i][5])) {
									String s = Confirmed.setArea(matrixNew[i][5]);
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][6].equals(matrixNew[i][6])) {
									String s = Confirmed.setStreet(matrixNew[i][6]);
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][7].equals(matrixNew[i][7])) {
									String s = Confirmed.setStreet_number(Integer.parseInt(matrixNew[i][7]));
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								if (!matrixTemp[i][8].equals(matrixNew[i][8])) {
									String s = Confirmed.setZip(Integer.parseInt(matrixNew[i][8]));
									persondao.alterTables(Integer.parseInt(matrixTemp[i][9]), "confirmed", s);
								}
								JOptionPane.showMessageDialog(null, "Updated Successfully");
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}

						} else {
							break;
						}
					}
					matrixNew = null;
					matrixTemp = null;
					idToDelete = null;
					dispose();
					new Message("Your personal information has been submited successfully. Thank you!", 120);
				}
			}
		});
		buttonSub.setBounds(10, 375, 245, 45);
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		panel.add(buttonSub);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		buttonCancel.setBounds(10, 439, 240, 45);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);
	}

	public void dataBase() throws Exception {
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
				row[10] = patient.cid;
				model.addRow(row);
			}
		}
	}
}