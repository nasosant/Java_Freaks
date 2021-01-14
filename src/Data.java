import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Data extends JFrame {

	protected static JLabel labelOkey;
	protected JPanel contentPane;
	protected JTable table;
	protected static DefaultTableModel model;
	protected Object[] column = { "Id", "Name", "Surname", "Email", "Phone Number", "SSN", "Address", "Has Covid" };
	protected final static Object[] row = new Object[8];
	protected static DefaultTableModel model_1;
	protected Object[] column_1 = { "Id", "Name", "Surname", "Email", "Phone Number", "SSN", "Confirmed Id",
			"Victim Relationship", "Danger" };
	protected final static Object[] row_1 = new Object[9];
	private JTable table_1;
	private JLabel labelEditCon;
	private JLabel labelEditVictim;
	private Image imgEditCon;
	private Image imgEditVictim;

	public Data() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1458, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Data");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1452, 769);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 760, 630);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Confirmed Cases");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(260, 11, 146, 26);
		panel.add(lblNewLabel);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);

		PersonJdbo persondao = new PersonJdbo();
		int count = persondao.check("confirmed");
		for (int i = 1; i <= count; i++) {
			Confirmed patient = (Confirmed) persondao.showAll("confirmed", i);
			if (patient == null) {
				count++;
			} else {
				row[0] = patient.cid;
				row[1] = patient.name;
				row[2] = patient.surname;
				row[3] = patient.email;
				row[4] = patient.phonenumber;
				row[5] = patient.AMKA;
				row[6] = patient.street + " " + patient.street_number + ", " + patient.area + " " + patient.zip;
				row[7] = patient.active_status;
				model.addRow(row);
			}
		}

		labelOkey = new JLabel("");
		Image imgOkey = new ImageIcon(this.getClass().getResource("okey.png")).getImage();
		labelOkey.setBounds(373, 529, 48, 48);// panel.add(labelOkey);

		JButton btnNewButton = new JButton("Okey");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setIcon(new ImageIcon(imgOkey));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PrintMenu();
			}
		});
		btnNewButton.setBounds(629, 690, 223, 54);
		panel.add(btnNewButton);

		labelEditCon = new JLabel("");
		imgEditCon = new ImageIcon(this.getClass().getResource("edit.png")).getImage();
		labelEditCon.setBounds(373, 529, 48, 48);

		JButton btnNewButton_1 = new JButton("Edit a Confirmed Case");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditConfirmed frame = new EditConfirmed();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(275, 690, 223, 54);
		btnNewButton_1.setIcon(new ImageIcon(imgEditCon));
		panel.add(btnNewButton_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(780, 49, 660, 630);
		panel.add(scrollPane_1);

		// Victim Contact

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setBackground(new Color(211, 211, 211));
		model_1 = new DefaultTableModel();
		model_1.setColumnIdentifiers(column_1);
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);

		int count_1 = persondao.check("victim_contacts");
		for (int i = 1; i <= count_1; i++) {
			VictimContact victim = (VictimContact) persondao.showAll("victim_contacts", i);
			if (victim == null) {
				count_1++;
			} else {
				row_1[0] = victim.vid;
				row_1[1] = victim.name;
				row_1[2] = victim.surname;
				row_1[3] = victim.email;
				row_1[4] = victim.phonenumber;
				row_1[5] = victim.AMKA;
				row_1[6] = victim.confirmed_id;
				row_1[7] = victim.victim_relationship;
				row_1[8] = victim.danger;
				model_1.addRow(row_1);
			}
		}

		labelEditVictim = new JLabel("");
		imgEditVictim = new ImageIcon(this.getClass().getResource("edit.png")).getImage();
		labelEditVictim.setBounds(373, 529, 48, 48);

		JButton btnNewButton_1_1 = new JButton("Edit a Victim Contact");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditVictimContact frame = new EditVictimContact();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(961, 690, 223, 54);
		btnNewButton_1_1.setIcon(new ImageIcon(imgEditVictim));
		panel.add(btnNewButton_1_1);

		JLabel lblNewLabel_1 = new JLabel("Victim Contact");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(994, 11, 146, 26);
		panel.add(lblNewLabel_1);
	}

}
