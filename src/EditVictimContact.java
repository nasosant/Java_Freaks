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

public class EditVictimContact extends JFrame {

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
	protected static JTextField confirmedId;
	protected static JTextField victimRelationship;
	protected static JTextField danger;
	protected JPanel contentPane;
	protected JTable table;
	protected static DefaultTableModel model;
	protected Object[] column = { "Name", "Surname", "Email", "Phone Number", "SSN", "Confirmed Id",
			"Victim Relationship", "Danger", "Id" };
	protected final static Object[] row = new Object[9];
	protected String[][] matrixNew = new String[10][8];
	protected String[][] matrixTemp = new String[10][8];
	protected int[] idToDelete = new int[10];
	protected static int numberDel = -1;
	protected static int numberNew = -1;
	protected static int numberTemp = -1;
	boolean flag = false; // to svino?????
	protected JPanel panel;
	// Label
	protected JLabel lblName;
	protected JLabel lblSurname;
	protected JLabel lblEmail;
	protected JLabel lblPhoneNumber;
	protected JLabel lblSsn;
	protected JLabel lblConfirmedId;
	protected JLabel lblVictimRelationship;
	protected JLabel lblDanger;
	// Label Images
	protected JLabel labelNameImg;
	protected JLabel labelSurNameImg;
	protected JLabel labelEmailImg;
	protected JLabel labelPhoneImg;
	protected JLabel labelAmkaImg;
	protected JLabel labelIdImg;
	protected JLabel labelRelationshipImg;
	protected JLabel labelDangerImg;

	protected JScrollPane scrollPane;
	protected PersonJdbo persondao;

	public EditVictimContact() throws Exception {
		persondao = new PersonJdbo();
		draw();
		images();
		table();
		dataBase();
		buttons();
	}

	public void draw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 535);
		setTitle("Edit Victim Contact");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1309, 506);
		contentPane.add(panel);
		panel.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(1, 52, 45, 24);
		panel.add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(1, 82, 63, 24);
		panel.add(lblSurname);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(2, 113, 45, 24);
		panel.add(lblEmail);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(2, 143, 98, 24);
		panel.add(lblPhoneNumber);

		lblSsn = new JLabel("SSN");
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSsn.setBounds(2, 173, 45, 24);
		panel.add(lblSsn);

		lblConfirmedId = new JLabel("Confirmed Id");
		lblConfirmedId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmedId.setBounds(2, 203, 79, 24);
		panel.add(lblConfirmedId);

		lblVictimRelationship = new JLabel("Victim Relationship");
		lblVictimRelationship.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVictimRelationship.setBounds(2, 233, 112, 24);
		panel.add(lblVictimRelationship);

		lblDanger = new JLabel("Danger");
		lblDanger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDanger.setBounds(1, 263, 63, 22);
		panel.add(lblDanger);

		nameText = new JTextField();
		nameText.setBounds(140, 52, 149, 20);
		panel.add(nameText);
		nameText.setColumns(10);

		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnameText.setBounds(140, 82, 149, 20);
		panel.add(surnameText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(141, 113, 148, 20);
		panel.add(emailText);

		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(141, 143, 148, 20);
		panel.add(phoneNumberText);

		ssnText = new JTextField();
		ssnText.setColumns(10);
		ssnText.setBounds(141, 175, 148, 20);
		panel.add(ssnText);

		confirmed_idText = new JTextField();
		confirmed_idText.setColumns(10);
		confirmed_idText.setBounds(141, 205, 148, 20);
		panel.add(confirmed_idText);

		victimRelationship = new JTextField();
		victimRelationship.setColumns(10);
		victimRelationship.setBounds(141, 235, 148, 20);
		panel.add(victimRelationship);

		danger = new JTextField();
		danger.setColumns(10);
		danger.setBounds(141, 265, 148, 20);
		panel.add(danger);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 52, 1005, 402);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Here you can edit every person's information.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(512, 21, 379, 20);
		panel.add(lblNewLabel_1);

	}

	public void images() {
		labelNameImg = new JLabel("");
		Image imgName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelNameImg.setIcon(new ImageIcon(imgName));
		labelNameImg.setBounds(45, 52, 25, 25);
		panel.add(labelNameImg);

		labelSurNameImg = new JLabel("");
		Image imgSurName = new ImageIcon(this.getClass().getResource("name.png")).getImage();
		labelSurNameImg.setIcon(new ImageIcon(imgSurName));
		labelSurNameImg.setBounds(65, 82, 25, 25);
		panel.add(labelSurNameImg);

		labelEmailImg = new JLabel("");
		Image imgEmail = new ImageIcon(this.getClass().getResource("email.png")).getImage();
		labelEmailImg.setIcon(new ImageIcon(imgEmail));
		labelEmailImg.setBounds(45, 113, 25, 25);
		panel.add(labelEmailImg);

		labelPhoneImg = new JLabel("");
		Image imgPhone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
		labelPhoneImg.setIcon(new ImageIcon(imgPhone));
		labelPhoneImg.setBounds(98, 143, 25, 25);
		panel.add(labelPhoneImg);

		labelAmkaImg = new JLabel("");
		Image imgAmka = new ImageIcon(this.getClass().getResource("amka.png")).getImage();
		labelAmkaImg.setIcon(new ImageIcon(imgAmka));
		labelAmkaImg.setBounds(38, 172, 25, 25);
		panel.add(labelAmkaImg);

		labelDangerImg = new JLabel("");
		Image imgDanger = new ImageIcon(this.getClass().getResource("danger.png")).getImage();
		labelDangerImg.setBounds(50, 263, 25, 25);
		labelDangerImg.setIcon(new ImageIcon(imgDanger));
		panel.add(labelDangerImg);

		labelRelationshipImg = new JLabel("");
		Image imgRelationship = new ImageIcon(this.getClass().getResource("relationship.png")).getImage();
		labelRelationshipImg.setBounds(115, 232, 25, 25);
		labelRelationshipImg.setIcon(new ImageIcon(imgRelationship));
		panel.add(labelRelationshipImg);

		labelIdImg = new JLabel("");
		Image imgId = new ImageIcon(this.getClass().getResource("conId.png")).getImage();
		labelIdImg.setBounds(83, 202, 25, 25);
		labelIdImg.setIcon(new ImageIcon(imgId));
		panel.add(labelIdImg);

		JLabel labelEditImg = new JLabel("");
		Image imgEdit = new ImageIcon(this.getClass().getResource("edit.png")).getImage();
		labelEditImg.setBounds(895, 17, 25, 25);
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

				confirmed_idText.setText(model.getValueAt(i, 5).toString());
				matrixTemp[numberTemp][5] = model.getValueAt(i, 5).toString();

				victim_relationshipText.setText(model.getValueAt(i, 6).toString());
				matrixTemp[numberTemp][6] = model.getValueAt(i, 6).toString();

				dangerText.setText(model.getValueAt(i, 7).toString());
				matrixTemp[numberTemp][7] = model.getValueAt(i, 7).toString();

				matrixTemp[numberTemp][8] = model.getValueAt(i, 8).toString();
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
				String tempAMKA = ssnText.getText();
				boolean unvalidAMKA = false;
				// Check for a valid AMKA
				if (persondao.constraints(tempAMKA, "int", 9) == false || tempAMKA.length() != 9) {
					unvalidAMKA = true;
				} else if (!matrixTemp[numberTemp][4].equals(tempAMKA) && persondao.checkAMKA(tempAMKA)) {
					// Check if it has changed to a not valid AMKA
					unvalidAMKA = true;
				} else {
					// Check for same AMKA in temporary UpdateList
					for (int i = 0; i < numberTemp; i++) {
						if (matrixTemp[i][4].equals(tempAMKA) && !matrixTemp[numberTemp][4].equals(tempAMKA)) {
							unvalidAMKA = true;
							break;
						}
					}
				}
				// some others checks ....
				if (nameText.getText().equals("") || surnameText.getText().equals("") || emailText.getText().equals("")
						|| phoneNumberText.getText().equals("") || ssnText.getText().equals("")
						|| confirmed_idText.getText().equals("") || victim_relationshipText.getText().equals("")
						|| dangerText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				} else if (unvalidAMKA) {
					JOptionPane.showMessageDialog(null, "Please Enter A Valid SSN");
					ssnText.setText("");
				} else if (numberNew + 1 == 10) { // 10 einai giati tosous mporoyme na enhmerosoyme kathe fora
					JOptionPane.showMessageDialog(null,
							"You Can Not Update more Than 10 People At A Time! Press Submit.");
				} else {
					numberNew++;
					int checkForNull = 0; // Elegxos egkyrothtas
					int i = table.getSelectedRow();
					if (i >= 0) {
						if (persondao.constraints(nameText.getText(), "String", 50)) {
							checkForNull++;
						}
						if (persondao.constraints(surnameText.getText(), "String", 50)) {
							checkForNull++;
						}
						if (persondao.constraints(emailText.getText(), "String", 50)) {
							checkForNull++;
						}
						if (persondao.constraints(phoneNumberText.getText(), "int", 10)
								&& phoneNumberText.getText().length() == 10) {
							checkForNull++;
						}
						if (persondao.constraints(confirmed_idText.getText(), "int", Integer.MAX_VALUE)) {
							checkForNull++;
						}
						if (persondao.constraints(victim_relationshipText.getText(), "String", 50)) {
							checkForNull++;
						}
						if (persondao.constraints(dangerText.getText(), "String", 4)) {
							checkForNull++;
						}
						if (checkForNull == 7) {
							model.setValueAt(surnameText.getText(), i, 1);
							model.setValueAt(nameText.getText(), i, 0);
							model.setValueAt(emailText.getText(), i, 2);
							model.setValueAt(phoneNumberText.getText(), i, 3);
							model.setValueAt(tempAMKA, i, 4);
							model.setValueAt(confirmed_idText.getText(), i, 5);
							model.setValueAt(victim_relationshipText.getText(), i, 6);
							model.setValueAt(dangerText.getText(), i, 7);

							matrixNew[numberNew][0] = nameText.getText();
							matrixNew[numberNew][1] = surnameText.getText();
							matrixNew[numberNew][2] = emailText.getText();
							matrixNew[numberNew][3] = phoneNumberText.getText();
							matrixNew[numberNew][4] = tempAMKA;
							matrixNew[numberNew][5] = confirmed_idText.getText();
							matrixNew[numberNew][6] = victim_relationshipText.getText();
							matrixNew[numberNew][7] = dangerText.getText();
						} else {
							JOptionPane.showMessageDialog(null, "Enter Valid Information");
							numberNew--;
						}
						repeatedly = 0;
					} else {
						JOptionPane.showMessageDialog(null, "Please Select a Row First");
					}
				}
				if (numberNew != numberTemp) {
					for (int k = 0; k < 9; k++) {
						matrixTemp[numberTemp][k] = null;
					}
				}
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
		btnUpdate.setBounds(294, 465, 230, 30);
		Image imgUpdate = new ImageIcon(this.getClass().getResource("update.png")).getImage();
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
				confirmed_idText.setText("");
				victim_relationshipText.setText("");
				dangerText.setText("");
			}
		});
		btnClear.setBounds(1070, 465, 230, 30);
		Image imgClear = new ImageIcon(this.getClass().getResource("clear.png")).getImage();
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
		btnDelete.setBounds(672, 465, 230, 30);
		Image imgDelete = new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		btnDelete.setIcon(new ImageIcon(imgDelete));
		panel.add(btnDelete);

		JButton buttonSub = new JButton("Submit");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if there is anyone in DeleteList
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
				for (int i = 0; i < 10; i++) {
					if (matrixTemp[i][0] != null) {
						try {
							if (!matrixTemp[i][0].equals(matrixNew[i][0])) {
								String s = AllPeople.setName(matrixNew[i][0]);
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}

							if (!matrixTemp[i][1].equals(matrixNew[i][1])) {
								String s = AllPeople.setSurname(matrixNew[i][0]);
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][2].equals(matrixNew[i][2])) {
								String s = AllPeople.setEmail(matrixNew[i][0]);
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][3].equals(matrixNew[i][3])) {
								String s = AllPeople.setPhonenumber(Integer.parseInt(matrixNew[i][0]));
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][4].equals(matrixNew[i][4])) {
								String s = AllPeople.setAMKA(Integer.parseInt(matrixNew[i][0]));
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][5].equals(matrixNew[i][5])) {
								String s = VictimContact.setConfirmed_id(Integer.parseInt(matrixNew[i][0]));
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][6].equals(matrixNew[i][6])) {
								String s = VictimContact.setVictim_relationship(matrixNew[i][0]);
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
							}
							if (!matrixTemp[i][7].equals(matrixNew[i][7])) {
								String s = VictimContact.setDanger(matrixNew[i][0]);
								persondao.alterTables(Integer.parseInt(matrixTemp[i][8]), "victim_contacts", s);
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
				nameText.setText("");
				surnameText.setText("");
				emailText.setText("");
				phoneNumberText.setText("");
				ssnText.setText("");
				areaText.setText("");
				streetText.setText("");
				streetNumberText.setText("");
				zipText.setText("");
				numberTemp = 0;
				numberNew = 0;
				matrixNew = null;
				matrixTemp = null;
				idToDelete = null;
				dispose();
				new Message("Your personal information has been submited successfully. Thank you!", 120);
			}
		});
		buttonSub.setBounds(10, 386, 245, 45);
		Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		panel.add(buttonSub);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberTemp = 0;
				numberNew = 0;
				matrixNew = null;
				matrixTemp = null;
				idToDelete = null;
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
		buttonCancel.setBounds(10, 450, 240, 45);
		Image imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);
	}

	public void dataBase() throws Exception {
		int count = persondao.check("victim_contacts");
		for (int i = 1; i <= count; i++) {
			VictimContact victim = (VictimContact) persondao.showAll("victim_contacts", i);
			if (victim == null) {
				count++;
			} else {
				row[0] = victim.name;
				row[1] = victim.surname;
				row[2] = victim.email;
				row[3] = victim.phonenumber;
				row[4] = victim.AMKA;
				row[5] = victim.confirmed_id;
				row[6] = victim.victim_relationship;
				row[7] = victim.danger;
				row[8] = victim.vid;
				model.addRow(row);
			}
		}
	}
}