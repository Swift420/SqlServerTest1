
class User1 {
	private int lecturerID;
	private String firstName,lastName,department,course,city,street,email,gender;
	
	
		
	
	
						
	
	public User1(int lecturerID, String firstName, String lastName, String department) {
		this.lecturerID=lecturerID;
		this.firstName=firstName;
		this.lastName=lastName;
		
		this.department=department;
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
	
}
