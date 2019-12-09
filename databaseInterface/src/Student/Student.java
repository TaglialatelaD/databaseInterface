package Student;

public class Student {
	private String matricola;
	private String firstName;
	private String lastName;
	
	public Student(String matricola, String firstName, String lastName) {
		
		this.matricola = matricola;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

}
