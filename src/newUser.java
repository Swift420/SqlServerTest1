
import javax.swing.table.DefaultTableModel;

class newUser {
	private int lecturerID;
	private String firstName,lastName,department,overload;
	
	newUser(int lecturerID, String firstName, String lastName, String department){
		
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

	public int getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	
}
