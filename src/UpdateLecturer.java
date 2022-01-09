import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;

public class UpdateLecturer extends JFrame {

	private JPanel contentPane;
	private JTextField lecturerID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField street;
	private JTextField city;
	private JTable JTable_DIsplay_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateLecturer frame = new UpdateLecturer();
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
	String department;
	String gender;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public UpdateLecturer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(172, 225, 1082, 398);
		contentPane.add(panel);
		
		lecturerID = new JTextField();
		lecturerID.setColumns(10);
		lecturerID.setBounds(181, 104, 85, -18);
		panel.add(lecturerID);
		
		JLabel newVar = new JLabel("First Name");
		newVar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newVar.setBounds(10, 104, 122, 23);
		panel.add(newVar);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(170, 108, 96, 19);
		panel.add(firstName);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 179, 109, 23);
		panel.add(lblNewLabel_2);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(170, 183, 96, 19);
		panel.add(lastName);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(393, 64, 109, 21);
		panel.add(lblNewLabel_4);
		
		JRadioButton computer = new JRadioButton("Computing and Informatics");
		buttonGroup.add(computer);
		computer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		computer.setBounds(508, 64, 209, 21);
		panel.add(computer);
		
		JRadioButton engineering = new JRadioButton("Engineering");
		buttonGroup.add(engineering);
		engineering.setFont(new Font("Tahoma", Font.PLAIN, 15));
		engineering.setBounds(508, 100, 196, 21);
		panel.add(engineering);
		
		JRadioButton health = new JRadioButton("Health and Applied Sciences");
		buttonGroup.add(health);
		health.setFont(new Font("Tahoma", Font.PLAIN, 15));
		health.setBounds(508, 138, 234, 21);
		panel.add(health);
		
		JLabel lblNewLabel_5 = new JLabel("Course(s)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(293, 248, 96, 13);
		panel.add(lblNewLabel_5);
		
		JCheckBox mci = new JCheckBox("MCI");
		mci.setBounds(433, 246, 93, 21);
		panel.add(mci);
		
		JCheckBox dpg = new JCheckBox("DPG");
		dpg.setBounds(557, 246, 93, 21);
		panel.add(dpg);
		
		JCheckBox prg = new JCheckBox("PRG");
		prg.setBounds(433, 309, 93, 21);
		panel.add(prg);
		
		JCheckBox cad = new JCheckBox("CAD");
		cad.setBounds(557, 309, 93, 21);
		panel.add(cad);
		
		JCheckBox mtm = new JCheckBox("MTM");
		mtm.setBounds(433, 366, 93, 21);
		panel.add(mtm);
		
		JCheckBox ict = new JCheckBox("ICT");
		ict.setBounds(557, 366, 93, 21);
		panel.add(ict);
		
		JCheckBox gnb = new JCheckBox("GNB");
		gnb.setBounds(683, 246, 93, 21);
		panel.add(gnb);
		
		JCheckBox ias = new JCheckBox("IAS");
		ias.setBounds(683, 309, 93, 21);
		panel.add(ias);
		
		JCheckBox gnc = new JCheckBox("GNC");
		gnc.setBounds(683, 366, 93, 21);
		panel.add(gnc);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(825, 70, 77, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Street");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(825, 116, 45, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(825, 171, 45, 13);
		panel.add(lblNewLabel_8);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(896, 170, 147, 19);
		panel.add(email);
		
		street = new JTextField();
		street.setColumns(10);
		street.setBounds(896, 115, 147, 19);
		panel.add(street);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(896, 67, 147, 19);
		panel.add(city);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(825, 233, 85, 28);
		panel.add(lblNewLabel_9);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup_1.add(male);
		male.setFont(new Font("Tahoma", Font.PLAIN, 15));
		male.setBounds(914, 239, 103, 21);
		panel.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		buttonGroup_1.add(female);
		female.setFont(new Font("Tahoma", Font.PLAIN, 15));
		female.setBounds(914, 283, 103, 21);
		panel.add(female);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            int row = JTable_DIsplay_User.getSelectedRow();
		            String value = (JTable_DIsplay_User.getModel().getValueAt(row, 0).toString());
		            String value1 = lecturerID.getText();
		            String query = "UPDATE tempTable1 SET  firstName=?, lastName=?, department=?, course=?,city=?,street=?,email=?,gender=?  where lecturerID="+value;
		            PreparedStatement pst = con.prepareStatement(query);
		            
		            pst.setString(1,firstName.getText() );
		            pst.setString(2, lastName.getText());
		           
		            if(computer.isSelected()) {
		            	department = "Computer Science";
		            }
		            if(engineering.isSelected()) {
		            	department = "Engineering";
		            }
		            if(health.isSelected()) {
		            	department = "Health and Applied Sciences";
		            	
		            }
		            pst.setString(3, department);
		            
		            
		            String course = "";
		            if(mci.isSelected()) {
		            	course+=mci.getText()+",";
		            }
		            if(dpg.isSelected()) {
		            	course+=dpg.getText()+",";
		            }
		            if(prg.isSelected()) {
		            	course+=prg.getText()+",";
		            }
		            if(mtm.isSelected()) {
		            	course+=mtm.getText()+ ",";
		            }
		            if(cad.isSelected()) {
		            	course+=cad.getText()+",";
		            }
		            if(ict.isSelected()) {
		            	course+= ict.getText()+",";
		            }
		            if(gnb.isSelected()) {
		            	course+= gnb.getText()+",";		      
		            }
		            if(ias.isSelected()) {
		            	course+= ias.getText()+",";
		            }
		            if(gnc.isSelected()) {
		            	course+=gnc.getText()+",";
		            }
		            pst.setString(4, course);
		            pst.setString(5, city.getText());
		            pst.setString(6, street.getText());
		            pst.setString(7, email.getText());
		            if(male.isSelected()) {
		            	gender="Male";
		            }
		            if(female.isSelected()) {
		            	gender="Female";
		            }
		            pst.setString(8, gender);
		            pst.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Updated Succesfully!");
		            
				
			}catch(Exception e1) {
				 JOptionPane.showConfirmDialog(null, e1);
				 
					
		}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(871, 328, 154, 45);
		panel.add(btnNewButton);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            int row = JTable_DIsplay_User.getSelectedRow();
		            String value = (JTable_DIsplay_User.getModel().getValueAt(row, 0).toString());
		            String query = "DELETE FROM tempTable1 WHERE lecturerID = "+ value;
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.executeUpdate();
		            DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
		    		model.setRowCount(0);
		    		show_user();
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				}
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delete.setBounds(36, 330, 154, 45);
		panel.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 21, 1064, 149);
		contentPane.add(scrollPane);
		
		JTable_DIsplay_User = new JTable();
		JTable_DIsplay_User.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = JTable_DIsplay_User.getSelectedRow();
				TableModel model = JTable_DIsplay_User.getModel();
				firstName.setText(model.getValueAt(i, 1).toString());
				lastName.setText(model.getValueAt(i, 2).toString());
				String dep = model.getValueAt(i, 3).toString();
				if(dep.equals("Computer Science")) {
					computer.setSelected(true);
				}
				if(dep.equals("Engineering")) {
					engineering.setSelected(true);
				}
				if(dep.equals("Health and Applied Sciences")) {
					health.setSelected(true);
				}
				String cour = model.getValueAt(i, 4).toString();
				switch(cour) {
					case "MCI,":
						mci.setSelected(true);
					case "DPG,":
						dpg.setSelected(true);	
					case "MTM,":
						mtm.setSelected(true);
					case "CAD,":
						cad.setSelected(true);
					case "ICT,":
						ict.setSelected(true);
					case "GNB,":
						gnb.setSelected(true);
					case "IAS,":
						ias.setSelected(true);
					case "GNC,":
						gnc.setSelected(true);
					default:
						gnc.setSelected(false);
						ias.setSelected(false);
						gnb.setSelected(false);
						ict.setSelected(false);
						cad.setSelected(false);
						mtm.setSelected(false);
						dpg.setSelected(false);
						mci.setSelected(false);
						
				}
				city.setText(model.getValueAt(i, 5).toString());
				street.setText(model.getValueAt(i, 6).toString());
				email.setText(model.getValueAt(i, 7).toString());
				
				String sex = model.getValueAt(i, 8).toString();
				if(sex.equals("Male")) {
					male.setSelected(true);
				}else {
					female.setSelected(true);
				}
					
			}
		});
		JTable_DIsplay_User.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"lecturerID", "firstName", "lastName", "department", "course", "city", "street", "email", "gender"
			}
		));
		scrollPane.setViewportView(JTable_DIsplay_User);
		
		JLabel lblNewLabel = new JLabel("Search Lecturer ID");
		lblNewLabel.setBounds(159, 180, 96, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					show_user1();
			}
		});
		btnNewButton_1.setBounds(380, 179, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(265, 180, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_user();
			}
		});
		btnNewButton_2.setBounds(1031, 180, 117, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 31, 131, 48);
		contentPane.add(btnNewButton_3);
	}
	public ArrayList<User> userList1(){
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
}
