import javax.swing.table.DefaultTableModel;

class User {
	private int lecturerID;
	private String firstName,lastName,department,course,city,street,email,gender;
	
	public User(int lecturerID, String firstName, String lastName, String department, String course, String city, String street, String email, String gender) {
		this.lecturerID=lecturerID;
		this.firstName=firstName;
		this.lastName=lastName;
		
		
		this.department=department;
		this.course=course;
		this.city=city;
		this.street=street;
		this.email=email;
		this.gender=gender;
		
	
						
	}
	public int getlecturerID() {
		return lecturerID;
	}
	public String getfirstName() {
		return firstName;	
	}
	public String getlastName() {
		return lastName;	
	}
	public String getdepartment() {
		return department;	
	}
	public String getcourse() {
		return course;	
	}
	public String getcity() {
		return city;	
	}
	public String getstreet() {
		return street;	
	}
	public String getemail() {
		return email;	
	}public String getgender() {
		return gender;	
	}
}



/*model.addRow(new Object[] {
		name.getText(),
		  address.getText(),
		   gender,
		   
		   
		   subject.getSelectedItem(),
});
*/













/*int x = 1;
int sno = 0;
model.addRow(new Object[] {
			
			sno+=x,
			name.getText(),
			  address.getText(),
			   gender,
			   knowledge,
			   subject.getSelectedItem(),
	});*/