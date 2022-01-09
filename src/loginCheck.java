import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class loginCheck extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginCheck frame = new loginCheck();
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
	public loginCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(79, 85, 71, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(79, 164, 101, 13);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(221, 82, 96, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(221, 161, 96, 19);
		contentPane.add(password);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"admin", "lecturer"}));
		comboBox1.setBounds(221, 21, 96, 21);
		contentPane.add(comboBox1);
		
		
		JButton signin = new JButton("SignIn");
		signin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				 try{
			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
			            Connection con = DriverManager.getConnection(url);
			            String sql = "Select * from usertbl where username=? and password=? and userType=?";
			            PreparedStatement pst = con.prepareStatement(sql);
			            pst.setString(1, username.getText());
			            pst.setString(2, password.getText());
			            pst.setString(3,String.valueOf(comboBox1.getSelectedItem()) );
			            ResultSet rs = pst.executeQuery();
			            if(rs.next()){
			            	if(comboBox1.getSelectedIndex()==0) {
			            		AdminLandPage field1 = new AdminLandPage();
				            	field1.setVisible(true);
				            	setVisible(false);
			            	}
			            	else {
			            		Navigation nav1 = new Navigation();
			            		nav1.setVisible(true);
			            		setVisible(false);
			            	}
			            }
			            else {
			            	JOptionPane.showConfirmDialog(null, "Username and Password Not Correct");
			            	username.setText("");
			            	password.setText("");
			            }
			            con.close();
				 }
				 catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		signin.setBounds(53, 232, 85, 21);
		contentPane.add(signin);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		reset.setBounds(184, 232, 85, 21);
		contentPane.add(reset);
		
		
		JLabel lblNewLabel_2 = new JLabel("Select User Type");
		lblNewLabel_2.setBounds(60, 25, 122, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            lecturer reg = new lecturer();
		            reg.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		btnNewButton.setBounds(317, 232, 85, 21);
		contentPane.add(btnNewButton);
	}
}
