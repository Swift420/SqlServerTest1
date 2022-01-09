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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class newLecturer extends JFrame {

	private JPanel contentPane;
	private JTextField lecturerID;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField street;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newLecturer frame = new newLecturer();
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public newLecturer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(186, 85, 1053, 411);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 63, 85, 21);
		panel.add(lblNewLabel_1);
		
		lecturerID = new JTextField();
		lecturerID.setColumns(10);
		lecturerID.setBounds(170, 67, 96, 19);
		panel.add(lecturerID);
		
		JLabel newVar = new JLabel("First Name");
		newVar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newVar.setBounds(10, 135, 122, 23);
		panel.add(newVar);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(170, 139, 96, 19);
		panel.add(firstName);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 201, 109, 23);
		panel.add(lblNewLabel_2);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(170, 205, 96, 19);
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
		lblNewLabel_5.setBounds(268, 248, 96, 13);
		panel.add(lblNewLabel_5);
		
		JCheckBox mci = new JCheckBox("MCI");
		mci.setBounds(393, 246, 93, 21);
		panel.add(mci);
		
		JCheckBox dpg = new JCheckBox("DPG");
		dpg.setBounds(508, 246, 93, 21);
		panel.add(dpg);
		
		JCheckBox prg = new JCheckBox("PRG");
		prg.setBounds(393, 309, 93, 21);
		panel.add(prg);
		
		JCheckBox cad = new JCheckBox("CAD");
		cad.setBounds(508, 309, 93, 21);
		panel.add(cad);
		
		JCheckBox mtm = new JCheckBox("MTM");
		mtm.setBounds(393, 366, 93, 21);
		panel.add(mtm);
		
		JCheckBox ict = new JCheckBox("ICT");
		ict.setBounds(508, 366, 93, 21);
		panel.add(ict);
		
		JCheckBox gnb = new JCheckBox("GNB");
		gnb.setBounds(624, 246, 93, 21);
		panel.add(gnb);
		
		JCheckBox ias = new JCheckBox("IAS");
		ias.setBounds(624, 309, 93, 21);
		panel.add(ias);
		
		JCheckBox gnc = new JCheckBox("GNC");
		gnc.setBounds(624, 366, 93, 21);
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
		
		JButton save = new JButton("save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            String query = "insert into tempTable1(lecturerID,FirstName, LastName, department, course, City, Street, Email, Gender )Values(?,?,?,?,?,?,?,?,?)";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setString(1, lecturerID.getText());
		            pst.setString(2,firstName.getText() );
		            pst.setString(3, lastName.getText());
		            
		            if(computer.isSelected()) {
		            	department = "Computer Science";
		            }
		            if(engineering.isSelected()) {
		            	department = "Engineering";
		            }
		            if(health.isSelected()) {
		            	department = "Health and Applied Sciences";
		            	
		            }
		            pst.setString(4, department);
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
		            pst.setString(5, course);
		            pst.setString(6, city.getText());
		            pst.setString(7, street.getText());
		            pst.setString(8, email.getText());
		            if(male.isSelected()) {
		            	gender="Male";
		            }
		            if(female.isSelected()) {
		            	gender="Female";
		            }
		            pst.setString(9, gender);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "New Lecturer Added Succesfully!");
		            
		           
			}catch(Exception e1) {
				 JOptionPane.showConfirmDialog(null, e1);
			 }
				
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		save.setBounds(1102, 519, 162, 45);
		contentPane.add(save);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(62, 22, 148, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Currently Operating as An admin");
		lblNewLabel.setBounds(575, 589, 197, 13);
		contentPane.add(lblNewLabel);
		
		
		
	}

}
