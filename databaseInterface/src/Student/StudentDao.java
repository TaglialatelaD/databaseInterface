package Student;


import java.util.List;

public interface StudentDao {
	
	public boolean addStudent(Student student);
	public int removeStudent(String matricola);
	public Student searchStudent(String matricola);
	public List<StudentWithExam> getAllStudents();

}
