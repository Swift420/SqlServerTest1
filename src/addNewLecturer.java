import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addNewLecturer extends JFrame {
	


	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JLabel lblNewLabel_1;
	private JTextField lecturerID;
	private JLabel lblNewLabel_2;
	private JTextField username;
	private JPasswordField password;
	private JTextField email;
	private JTextField street;
	private JTextField city;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lecturer frame = new lecturer();
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
	public addNewLecturer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1342, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(205, 27, 1053, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Lecturer ID");
		lblNewLabel_1.setBounds(10, 63, 85, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lecturerID = new JTextField();
		lecturerID.setBounds(170, 67, 96, 19);
		panel.add(lecturerID);
		lecturerID.setColumns(10);
		
		JLabel newVar = new JLabel("First Name");
		newVar.setBounds(10, 135, 122, 23);
		panel.add(newVar);
		newVar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		firstName = new JTextField();
		firstName.setBounds(170, 139, 96, 19);
		panel.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(10, 201, 109, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lastName = new JTextField();
		lastName.setBounds(170, 205, 96, 19);
		panel.add(lastName);
		lastName.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(10, 268, 109, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		username = new JTextField();
		username.setBounds(170, 267, 96, 19);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 328, 103, 13);
		panel.add(lblNewLabel_3);
		
		password = new JPasswordField();
		password.setBounds(170, 327, 96, 19);
		panel.add(password);
		
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
		lblNewLabel_5.setBounds(393, 248, 96, 13);
		panel.add(lblNewLabel_5);
		
		JCheckBox mci = new JCheckBox("MCI");
		mci.setBounds(502, 246, 93, 21);
		panel.add(mci);
		
		JCheckBox dpg = new JCheckBox("DPG");
		dpg.setBounds(624, 246, 93, 21);
		panel.add(dpg);
		
		JCheckBox prg = new JCheckBox("PRG");
		prg.setBounds(502, 309, 93, 21);
		panel.add(prg);
		
		JCheckBox cad = new JCheckBox("CAD");
		cad.setBounds(624, 309, 93, 21);
		panel.add(cad);
		
		JCheckBox mtm = new JCheckBox("MTM");
		mtm.setBounds(502, 366, 93, 21);
		panel.add(mtm);
		
		JCheckBox ict = new JCheckBox("ICT");
		ict.setBounds(624, 366, 93, 21);
		panel.add(ict);
		
		JCheckBox gnb = new JCheckBox("GNB");
		gnb.setBounds(728, 246, 93, 21);
		panel.add(gnb);
		
		JCheckBox ias = new JCheckBox("IAS");
		ias.setBounds(728, 309, 93, 21);
		panel.add(ias);
		
		JCheckBox gnc = new JCheckBox("GNC");
		gnc.setBounds(728, 366, 93, 21);
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
		email.setBounds(896, 170, 147, 19);
		panel.add(email);
		email.setColumns(10);
		
		street = new JTextField();
		street.setBounds(896, 115, 147, 19);
		panel.add(street);
		street.setColumns(10);
		
		city = new JTextField();
		city.setBounds(896, 67, 147, 19);
		panel.add(city);
		city.setColumns(10);
		
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
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            String query = "insert into tempTable1(lecturerID,FirstName, LastName,Username, Password, department, course, City, Street, Email, Gender )Values(?,?,?,?,?,?,?,?,?,?,?)";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setString(1, lecturerID.getText());
		            pst.setString(2,firstName.getText() );
		            pst.setString(3, lastName.getText());
		            pst.setString(4, username.getText());
		            pst.setString(5, password.getText());
		            if(computer.isSelected()) {
		            	department = "Computer Science";
		            }
		            if(engineering.isSelected()) {
		            	department = "Engineering";
		            }
		            if(health.isSelected()) {
		            	department = "Health and Applied Sciences";
		            	
		            }
		            pst.setString(6, department);
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
		            pst.setString(7, course);
		            pst.setString(8, city.getText());
		            pst.setString(9, street.getText());
		            pst.setString(10, email.getText());
		            if(male.isSelected()) {
		            	gender="Male";
		            }
		            if(female.isSelected()) {
		            	gender="Female";
		            }
		            pst.setString(11, gender);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Registered Succesfully!");
		            
		            loginCheck log = new loginCheck();
		            log.setVisible(true);
		            setVisible(false);
			}catch(Exception e1) {
				 JOptionPane.showConfirmDialog(null, e1);
			 }
				}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 16));
		save.setBounds(1154, 514, 116, 40);
		contentPane.add(save);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            loginCheck log = new loginCheck();
		            log.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		back.setBounds(44, 514, 116, 33);
		contentPane.add(back);
	}
}
