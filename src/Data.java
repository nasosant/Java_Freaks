import java.awt.BorderLayout;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Data extends JFrame {

	protected static JLabel labelOkey;
	protected JPanel contentPane;
	protected JTable table;
	protected static DefaultTableModel model;
	protected Object[] column = {"Name", "Surname", "Address", "Email", "Phone Number", "SSN"};
	protected final static Object[] row = new Object[6];

	public static void main(String[] args) throws Exception {
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
	
	public Data() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1071, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 1051, 457);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("These are all the data!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(436, 11, 196, 27);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				Platform.nameText.setText(model.getValueAt(i, 0).toString());
				Platform.surnameText.setText(model.getValueAt(i, 1).toString());
				Platform.addressText.setText(model.getValueAt(i, 2).toString());
				Platform.emailText.setText(model.getValueAt(i, 3).toString());
				Platform.phoneNumberText.setText(model.getValueAt(i, 4).toString());
				Platform.ssnText.setText(model.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		PersonJdbo obj = new PersonJdbo();
		obj.showAll("confirmed");
		
		
		
		
		
		
		
		
		
		
		
		
		labelOkey = new JLabel("");
		Image imgOkey = new ImageIcon(this.getClass().getResource("okey.png")).getImage();
		labelOkey.setBounds(373, 529, 48, 48);//panel.add(labelOkey);
		
		JButton btnNewButton = new JButton("Okey");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setIcon(new ImageIcon(imgOkey));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PrintMenu();
			}
		});
		btnNewButton.setBounds(430, 529, 223, 54);
		panel.add(btnNewButton);
	}
}

