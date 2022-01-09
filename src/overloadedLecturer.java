import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class overloadedLecturer extends JFrame {

	private JPanel contentPane;
	private JTable JTable_DIsplay_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					overloadedLecturer frame = new overloadedLecturer();
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
	int val;
	public overloadedLecturer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(636, 130, 599, 197);
		contentPane.add(scrollPane);
		
		JTable_DIsplay_User = new JTable();
		JTable_DIsplay_User.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"lecturerID", "firstName", "lastName", "Overloaded or Underloaded", "New column"
			}
		));
		JTable_DIsplay_User.getColumnModel().getColumn(3).setPreferredWidth(165);
		scrollPane.setViewportView(JTable_DIsplay_User);
		
		textField = new JTextField();
		textField.setBounds(467, 195, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            String url="jdbc:sqlserver://localhost:1433;databaseName=Customer;user=Swift;password=pizza1212";
		            Connection con = DriverManager.getConnection(url);
		            int i=Integer.parseInt(textField.getText());
		            show_user2(i);
		            
		            
		            
			}catch(Exception e1) {
				 JOptionPane.showConfirmDialog(null, e1);
				 
					
			}}
		});
		btnNewButton.setBounds(415, 241, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("Lecturer ID");
		lblNewLabel.setBounds(346, 198, 96, 13);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Back");
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
		btnNewButton_1.setBounds(57, 69, 111, 36);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("If the (overloaded or underloaded) number is over 6");
		lblNewLabel_1.setFont(new Font("Verdana Pro Black", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(507, 406, 599, 19);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("The lecturer is overloaded with work per week");
		lblNewLabel_2.setFont(new Font("Verdana Pro Black", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(548, 448, 538, 19);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("If the (overloaded or underloaded) number is over 4");
		lblNewLabel_3.setFont(new Font("Verdana Pro Black", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(507, 505, 599, 19);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("The lecturer is underloaded with work per week");
		lblNewLabel_4.setFont(new Font("Verdana Pro Black", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(548, 559, 538, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Overloaded or Underloaded");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Verdana Pro Black", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(595, 24, 460, 54);
		contentPane.add(lblNewLabel_5);
	}
	int t;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	public void show_user2(int t) {
		ArrayList<newUser> list = userList2(t);
		try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
            Connection con = DriverManager.getConnection(url);
            String query1= "SELECT lecturerID, firstName,lastName,department FROM tempTable1";
            String query2 = "Select (LEN(Course) - LEN(REPLACE(course,',','')) + 1) AS [OverLoaded or UnderLoaded] FROM tempTable1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            
            DefaultTableModel model = (DefaultTableModel)JTable_DIsplay_User.getModel();
            model.setRowCount(0);
            Object[] row = new Object[5];
            for(int i=0;i<list.size(); i++) {
            	row[0]=list.get(i).getlecturerID();
            	row[1]=list.get(i).getfirstName();
            	row[2]=list.get(i).getlastName();
            	row[3]=list.get(i).getdepartment();
            	
				model.addRow(row);
            }}catch(Exception e1) {
   			 JOptionPane.showConfirmDialog(null, e1);
   		 }

	}
	
	public ArrayList<newUser> userList2(int c){
		int a = 1234;
	    int b;
	    String str1 = Integer.toString(a);
	    String str2;
	    
		ArrayList<newUser> usersList = new ArrayList<>();
		try{
			val=0;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LecturerDB;user=Swift;password=pizza1212";
            Connection con = DriverManager.getConnection(url);
            String query1= "SELECT lecturerID, firstName,lastName,department FROM tempTable1 WHERE lecturerID= "+Integer.toString(b=c);
            String query2 = "Select (LEN(Course) - LEN(REPLACE(course,',','')) + 1) AS chicken FROM tempTable1 WHERE lecturerID="+Integer.toString(b=c);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            
            
            newUser user = null; 
            while(rs.next()) {
            	
            	user = new newUser(rs.getInt("lecturerID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("department"));
            	
            }
            ResultSet rt = st.executeQuery(query2);
            while(rt.next()) {
            	
            		user.setDepartment(rt.getString("chicken"));
                	usersList.add(user);
            	
            	
            	
            }
		}catch(Exception e1) {
			 JOptionPane.showConfirmDialog(null, e1);
		 }
		return usersList;
	}
}
