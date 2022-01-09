import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class AdminLandPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLandPage frame = new AdminLandPage();
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
	public AdminLandPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 25));
		lblNewLabel.setBounds(534, 25, 120, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To view the list of lectuers and their information, click on the lecturer's tab. ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(246, 308, 799, 93);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Click on new lecturers to add lecturers to the database. Click on Update Lecturers to Update ");
		lblNewLabel_2.setFont(new Font("Verdana Pro", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(220, 386, 865, 59);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(57, 47, 133, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            showLectures lec1 = new showLectures();
		            lec1.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 
				
			}
			}
		});
		btnNewButton_1.setBounds(338, 124, 146, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add New Lecturer");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try{
			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
			            Connection con = DriverManager.getConnection(url);
			            newLecturer lect1 = new newLecturer();
			            lect1.setVisible(true);
			            setVisible(false);
			            
					}catch(Exception e1) {
						 JOptionPane.showConfirmDialog(null, e1);
					 
					
				}
				
				
			}
		});
		btnNewButton_2.setBounds(670, 124, 184, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            UpdateLecturer lect2 = new UpdateLecturer();
		            lect2.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 
				
			}
			
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(508, 262, 146, 46);
		contentPane.add(btnNewButton_3);
	}
}
