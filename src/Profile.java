import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTable JTable_DIsplay_User;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1349, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer ID");
		lblNewLabel.setBounds(22, 232, 110, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(349, 198, 976, 347);
		contentPane.add(scrollPane_1);
		
		JTable_DIsplay_User = new JTable();
		JTable_DIsplay_User.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTable_DIsplay_User.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"lecturerID", "firstName", "lastName", "department", "course", "city", "street", "email", "gender"
			}
		));
		scrollPane_1.setViewportView(JTable_DIsplay_User);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_user();
			}
		});
		btnNewButton.setBounds(132, 336, 173, 71);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(132, 229, 173, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(581, 20, 173, 80);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            Navigation nav1 = new Navigation();
		            nav1.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(116, 41, 124, 46);
		contentPane.add(btnNewButton_1);
	}
	
	
	public ArrayList<User> userList(){
		ArrayList<User> usersList = new ArrayList<>();
		try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
            Connection con = DriverManager.getConnection(url);
            String query1= "SELECT lecturerID, firstName,lastName,department,course,city,street,email,gender FROM tempTable1 WHERE lecturerID = "+ textField.getText().toString();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User user; 
            while(rs.next()) {
            	user= new User(rs.getInt("lecturerID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("department"), rs.getString("course"), rs.getString("city"), rs.getString("street"), rs.getString("email"), rs.getString("gender"));
            	usersList.add(user);
            }
		}catch(Exception e1) {
			 JOptionPane.showConfirmDialog(null, e1);
		 }
		return usersList;
	}
	public void show_user() {
		ArrayList<User> list = userList();
		DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
		Object[] row = new Object[9];
		for(int i=0;i<list.size(); i++) {
			row[0]=list.get(i).getlecturerID();
			row[1]=list.get(i).getfirstName();
			row[2]=list.get(i).getlastName();
			row[3]=list.get(i).getdepartment();
			row[4]=list.get(i).getcourse();
			row[5]=list.get(i).getcity();
			row[6]=list.get(i).getstreet();
			row[7]=list.get(i).getemail();
			row[8]=list.get(i).getgender();
			model.addRow(row);
			
			
		}
}
}