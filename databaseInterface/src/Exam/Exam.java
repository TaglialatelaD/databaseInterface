package Exam;

public class Exam {
	
	private String CE;
	private String name;
	private String professorName;
	
	public Exam(String CE, String name, String professorName) {
		this.CE = CE;
		this.name = name;
		this.professorName = professorName;	
	}
	
	public String getCE() {
		return CE;
	}
	public void setCE(String cE) {
		CE = cE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	

}
