import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

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
	protected static int curedId;
	protected static int deceasedId;
	final static Object[] row = new Object[8];
	protected Object[] column = { "Id", "Name", "Surname", "Email", "Phone Number", "SSN", "Address", "Has Covid" };
	private JLabel labelHeal;
	private Image imgHeal;
	private JLabel labelPassedWay;
	protected static int number = -1;

	public Cured_PassedAway() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 478);
		setTitle("Cured - Passed Away");
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
			if (obj2 == null) {
				count++;
			} else if (obj2.active_status) {
				row[0] = obj2.cid;
				row[1] = obj2.name;
				row[2] = obj2.surname;
				row[3] = obj2.email;
				row[4] = obj2.phonenumber;
				row[5] = obj2.AMKA;
				row[6] = obj2.street + " " + obj2.street_number + ", " + obj2.area + " " + obj2.zip;
				row[7] = obj2.active_status;
				model.addRow(row);
			}
		}

		labelHeal = new JLabel("");
		imgHeal = new ImageIcon(this.getClass().getResource("heal.png")).getImage();
		labelHeal.setBounds(20, 40, 60, 40);

		JButton btnNewButton = new JButton("Cured");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					curedId = Integer.parseInt(model.getValueAt(i, 0).toString());
					PersonJdbo persondao = new PersonJdbo();
					Confirmed confirmed = null;
					try {
						confirmed = (Confirmed) persondao.getPerson(curedId, "confirmed");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						String set = Confirmed.setActive_status(false);
						persondao.alterTables(confirmed.cid, "confirmed", set);
						persondao.insertIntoCured_Deceased(new Cured_Deceased(confirmed.cid, new Date()), "cured");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Thank you!");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}

			}
		});
		btnNewButton.setBounds(10, 381, 245, 45);
		btnNewButton.setIcon(new ImageIcon(imgHeal));
		panel.add(btnNewButton);

		labelPassedWay = new JLabel("");
		Image imgPassedWay = new ImageIcon(this.getClass().getResource("passedAway.png")).getImage();
		labelPassedWay.setBounds(20, 40, 60, 40);

		JButton btnUpdate = new JButton("Passed Away");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					deceasedId = Integer.parseInt(model.getValueAt(i, 0).toString());
					PersonJdbo persondao = new PersonJdbo();
					Confirmed confirmed = null;
					try {
						confirmed = (Confirmed) persondao.getPerson(deceasedId, "confirmed");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					try {
						String set = Confirmed.setActive_status(false);
						persondao.alterTables(confirmed.cid, "confirmed", set);
						persondao.insertIntoCured_Deceased(new Cured_Deceased(confirmed.cid, new Date()), "deceased");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Thank you!");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
			}
		});
		btnUpdate.setBounds(409, 381, 245, 45);
		btnUpdate.setIcon(new ImageIcon(imgPassedWay));
		panel.add(btnUpdate);

		JLabel labelSubmitImg = new JLabel("");
		Image imgSubmit = new ImageIcon(this.getClass().getResource("submit.png")).getImage();
		labelSubmitImg.setIcon(new ImageIcon(imgSubmit));
		labelSubmitImg.setBounds(5, 240, 25, 25);

		JButton buttonSub = new JButton("Okay");
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PrintMenu();
			}
		});
		buttonSub.setBounds(818, 381, 245, 45);
		buttonSub.setIcon(new ImageIcon(imgSubmit));
		panel.add(buttonSub);

		labelChangeUserImg = new JLabel("");
		Image imgChangeUser = new ImageIcon(this.getClass().getResource("changeUser.png")).getImage();
		labelChangeUserImg.setIcon(new ImageIcon(imgChangeUser));
		labelChangeUserImg.setBounds(325, 240, 25, 25);

		JLabel lblNewLabel_1 = new JLabel("Enter if a person has been cured or passed away.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(333, 15, 413, 20);
		panel.add(lblNewLabel_1);
	}
}