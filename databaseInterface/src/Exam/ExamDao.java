package Exam;

import java.util.List;

public interface ExamDao {
	
	public boolean addExam(Exam exam);
	public int removeExam(String CE);
	public Exam searchExam(String CE);
	public List<Exam> getAllExams();

}
