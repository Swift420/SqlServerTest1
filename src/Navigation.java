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

public class Navigation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation frame = new Navigation();
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
	public Navigation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(212, 10, 866, 591);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Click The Button");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(305, 10, 255, 96);
		panel.add(lblNewLabel);
		
		JLabel lblBelowToNavigate = new JLabel("Below To Navigate");
		lblBelowToNavigate.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblBelowToNavigate.setBounds(283, 76, 277, 96);
		panel.add(lblBelowToNavigate);
		
		JButton profile = new JButton("VIEW PROFILE");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            Profile prof1 = new Profile();
		            prof1.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		profile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.setBounds(305, 233, 212, 70);
		panel.add(profile);
		
		JButton status = new JButton("VIEW STATUS");
		status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            overloadedLecturer load = new overloadedLecturer();
		            load.setVisible(true);
		            setVisible(false);
		            
				}catch(Exception e1) {
					 JOptionPane.showConfirmDialog(null, e1);
				 }
			}
		});
		status.setFont(new Font("Tahoma", Font.PLAIN, 18));
		status.setBounds(305, 436, 212, 70);
		panel.add(status);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(37, 86, 126, 37);
		contentPane.add(btnNewButton);
	}

}
