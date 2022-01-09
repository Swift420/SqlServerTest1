import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Success extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Success frame = new Success();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String gender;
	private JTable table;
	private JTable JTable_DIsplay_User;
	public Success() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 25, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(41, 68, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Knowledge");
		lblNewLabel_2.setBounds(41, 161, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject");
		lblNewLabel_3.setBounds(41, 217, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(186, 22, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JTextArea address = new JTextArea();
		address.setBounds(186, 62, 96, 22);
		contentPane.add(address);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(41, 123, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setBounds(138, 119, 103, 21);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		buttonGroup.add(female);
		female.setBounds(274, 119, 103, 21);
		contentPane.add(female);
		
		JCheckBox coreJava = new JCheckBox("Java");
		coreJava.setBounds(138, 157, 93, 21);
		contentPane.add(coreJava);
		
		JCheckBox python = new JCheckBox("Python");
		python.setBounds(274, 157, 93, 21);
		contentPane.add(python);
		
		JComboBox subject = new JComboBox();
		subject.setModel(new DefaultComboBoxModel(new String[] {"Computer Science", "Management", "Humanities", "Arts", "Education"}));
		subject.setBounds(138, 213, 144, 21);
		contentPane.add(subject);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=Customer;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            String query = "Insert INTO users(name, address, gender, knowledge, subject)Values(?,?,?,?,?)";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, address.getText());
		            if(male.isSelected()) {
		            	gender="Male";
		            }
		            if(female.isSelected()) {
		            	gender="Female";
		            }
		            pst.setString(3, gender);
		            String knowledge="";
		            if(coreJava.isSelected()) {
		            	knowledge+=coreJava.getText()+" ";
		            	
		            }
		           if(python.isSelected()) {
		        	   knowledge+=python.getText()+" ";
		        	   
		           }
		           pst.setString(4, knowledge);
		           String course;
		           course= subject.getSelectedItem().toString();
		           pst.setString(5, course);
		           pst.executeUpdate();
		           DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
		           model.setRowCount(0);
		         //  show_user();
		           JOptionPane.showMessageDialog(null, "Inserted Successfully!");
		            
		           
		           
		            
		           
			}
				 catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
				
			
			}
		});
		saveBtn.setBounds(69, 244, 85, 21);
		contentPane.add(saveBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				address.setText("");
				buttonGroup.clearSelection();
				subject.setSelectedIndex(0);
				
			}
		});
		resetBtn.setBounds(291, 244, 85, 21);
		contentPane.add(resetBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(726, 119, 192, -66);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(424, 10, 641, 261);
		contentPane.add(scrollPane_1);
		
		JTable_DIsplay_User = new JTable();
		JTable_DIsplay_User.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = JTable_DIsplay_User.getSelectedRow();
				TableModel model = JTable_DIsplay_User.getModel();
				name.setText(model.getValueAt(i, 2).toString());
				address.setText(model.getValueAt(i, 3).toString());
				
				
			}
		});
		JTable_DIsplay_User.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"lecturerID", "firstName", "lastName", "department", "course", "city", "email", "gender"
			}
		));
		scrollPane_1.setViewportView(JTable_DIsplay_User);
		
		JButton btnNewButton = new JButton("Show records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				show_user();
			}
		});
		btnNewButton.setBounds(329, 68, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=Customer;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            int row = JTable_DIsplay_User.getSelectedRow();
		            String value = (JTable_DIsplay_User.getModel().getValueAt(row, 0).toString());
		            String query = "UPDATE users SET name=?, address=?, gender=?, knowledge=?, subject=? where sno="+value;
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setString(1, name.getText());
		            pst.setString(2, address.getText());
		            if(male.isSelected()) {
		            	gender="Male";
		            }
		            if(female.isSelected()) {
		            	gender="Female";
		            }
		            pst.setString(3, gender);
		            String knowledge="";
		            if(coreJava.isSelected()) {
		            	knowledge+=coreJava.getText()+" ";
		            	
		            }
		           if(python.isSelected()) {
		        	   knowledge+=python.getText()+" ";
		        	   
		           }
		           pst.setString(4, knowledge);
		           String course;
		           course= subject.getSelectedItem().toString();
		           pst.setString(5, course);
		           pst.executeUpdate();
		           DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
		           model.setRowCount(0);
		         //  show_user();
		           JOptionPane.showMessageDialog(null, "Updated Successfully!");
				
			}catch(Exception e1) {
				 JOptionPane.showConfirmDialog(null, e1);
			 }
			
			}
			
		});
		updateBtn.setBounds(125, 270, 85, 21);
		contentPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=Customer;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            int row = JTable_DIsplay_User.getSelectedRow();
		            String value = (JTable_DIsplay_User.getModel().getValueAt(row, 0).toString());
		            String query = "DELETE FROM users where  sno="+value;
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.executeUpdate();
		            DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
			        model.setRowCount(0);
			    //    show_user();
			        JOptionPane.showMessageDialog(null, "Deleted Successfully!");
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
				
			}
		});
		deleteBtn.setBounds(220, 270, 85, 21);
		contentPane.add(deleteBtn);
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
