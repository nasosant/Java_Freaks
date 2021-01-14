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
import java.awt.Window;

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
	protected JLabel lblNewLabel_3;
	protected JLabel lblNewLabel_4;
	protected JLabel lblNewLabel_5;
	protected JLabel lblNewLabel_6;
	protected JLabel lblNewLabel_7;
	protected JCheckBox checkBoxYes;
	protected JCheckBox checkBoxNo;
	protected JLabel labelSubmitImg;
	protected PersonJdbo persondao;
	protected Image imgSubmit;
	protected JLabel labelCancelImg;
	protected Image imgCancel;
	protected Image imgChangeUser;
	private JTextField confirmedId;
	private JTextField victimRelationship;
	private JTextField danger;
	private JLabel labelUpdateImg;
	private Image imgUpdate;
	private JLabel labelDeleteImg;
	private Image imgDelete;
	private JLabel labelClearImg;
	private Image imgClear;

	public EditVictimContact() throws Exception {
		persondao = new PersonJdbo();
		draw();
		images();
		table();
		buttons();
		dataBase();
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

		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(1, 52, 45, 24);
		panel.add(lblNewLabel);

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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 52, 1005, 402);
		panel.add(scrollPane);

		lblNewLabel_3 = new JLabel("Confirmed Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(2, 203, 79, 24);
		panel.add(lblNewLabel_3);

		confirmedId = new JTextField();
		confirmedId.setColumns(10);
		confirmedId.setBounds(141, 205, 148, 20);
		panel.add(confirmedId);

		lblNewLabel_4 = new JLabel("Victim Relationship");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(2, 233, 112, 24);
		panel.add(lblNewLabel_4);

		victimRelationship = new JTextField();
		victimRelationship.setColumns(10);
		victimRelationship.setBounds(141, 235, 148, 20);
		panel.add(victimRelationship);

		lblNewLabel_5 = new JLabel("Danger");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(1, 263, 63, 22);
		panel.add(lblNewLabel_5);

		danger = new JTextField();
		danger.setColumns(10);
		danger.setBounds(141, 265, 148, 20);
		panel.add(danger);

		JLabel lblNewLabel_1 = new JLabel("Here you can edit every person's information.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(512, 21, 379, 20);
		panel.add(lblNewLabel_1);

	}

	public void table() {
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
	}

	public void buttons() {

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
		btnUpdate.setBounds(294, 465, 230, 30);
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
		btnDelete.setBounds(672, 465, 230, 30);
		btnDelete.setIcon(new ImageIcon(imgDelete));
		panel.add(btnDelete);

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
		buttonSub.setBounds(10, 386, 245, 45);
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
		buttonCancel.setBounds(10, 450, 240, 45);
		buttonCancel.setIcon(new ImageIcon(imgCancel));
		panel.add(buttonCancel);
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

		labelSubmitImg = new JLabel("");
		imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);

		labelCancelImg = new JLabel("");
		imgCancel = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		labelCancelImg.setIcon(new ImageIcon(imgCancel));
		labelCancelImg.setBounds(165, 240, 25, 25);

		labelChangeUserImg = new JLabel("");
		imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);
		
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
		
		JLabel labelDangerImg = new JLabel("");
		Image imgDanger = new ImageIcon(this.getClass().getResource("danger.png")).getImage();
		labelDangerImg.setBounds(50, 263, 25, 25);
		labelDangerImg.setIcon(new ImageIcon(imgDanger));
		panel.add(labelDangerImg);
		
		JLabel labelRelationshipImg = new JLabel("");
		Image imgRelationship = new ImageIcon(this.getClass().getResource("relationship.png")).getImage();
		labelRelationshipImg.setBounds(115, 232, 25, 25);
		labelRelationshipImg.setIcon(new ImageIcon(imgRelationship));
		panel.add(labelRelationshipImg);
		
		JLabel labelIdImg = new JLabel("");
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

	public void dataBase() throws Exception {
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
	}
}