package StudentExam;

public class StudentExam {
	
	private String CE;
	private String matricola;
	private int voto;
	
	public StudentExam(String CE, String matricola, int voto) {
		this.CE = CE;
		this.matricola = matricola;
		this.voto = voto;
	}
	
	public String getCE() {
		return CE;
	}
	public void setCE(String cE) {
		CE = cE;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
	
	

}
