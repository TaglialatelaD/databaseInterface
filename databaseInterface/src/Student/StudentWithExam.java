package Student;

public class StudentWithExam {
	
	private String matricola;
	private String firstName;
	private String lastName;
	
	private String CE;
	private String vote;
	
	public StudentWithExam(String matricola, String firstName, String lastName, String CE, String vote) {
		
		this.matricola = matricola;
		this.firstName = firstName;
		this.lastName = lastName;
		this.CE = CE;
		this.vote = vote;
		
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

	public String getCE() {
		return CE;
	}

	public void setCE(String cE) {
		CE = cE;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}
	
	
	
	

}
