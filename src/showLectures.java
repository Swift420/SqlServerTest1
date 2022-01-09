import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class showLectures extends JFrame {

	private JPanel contentPane;
	private JTable JTable_DIsplay_User;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showLectures frame = new showLectures();
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
	public showLectures() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            AdminLandPage adm = new AdminLandPage();
		            adm.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 
				
			}
			
			}
		});
		btnNewButton.setBounds(56, 35, 101, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 145, 1052, 438);
		contentPane.add(scrollPane);
		
		JTable_DIsplay_User = new JTable();
		JTable_DIsplay_User.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"lecturerID", "firstName", "lastName", "department", "course", "city", "street", "email", "gender"
			}
		));
		scrollPane.setViewportView(JTable_DIsplay_User);
		
		JButton btnNewButton_1 = new JButton("Show Lecturers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_user();
			}
		});
		btnNewButton_1.setBounds(467, 31, 208, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Search ID");
		lblNewLabel.setBounds(820, 37, 59, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(904, 39, 120, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_user1();
			}
		});
		btnNewButton_2.setBounds(842, 75, 176, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Currently Operating as an Admin");
		lblNewLabel_1.setBounds(587, 593, 163, 13);
		contentPane.add(lblNewLabel_1);
	}
	
	public ArrayList<User> userList(){
		ArrayList<User> usersList = new ArrayList<>();
		try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
            Connection con = DriverManager.getConnection(url);
            String query1= "SELECT lecturerID, firstName,lastName,department,course,city,street,email,gender FROM tempTable1";
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
		model.setRowCount(0);
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
	
	
	
	public ArrayList<User> userList1(){
		ArrayList<User> usersList = new ArrayList<>();
		try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
            Connection con = DriverManager.getConnection(url);
            String query1= "SELECT lecturerID, firstName,lastName,department,course,city,street,email,gender FROM tempTable1 WHERE lecturerID = "+textField.getText().toString();
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
	public void show_user1() {
		ArrayList<User> list = userList1();
		DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
		model.setRowCount(0);
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
	}}
