package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import Exam.*;
import Student.*;
import StudentExam.*;
import UI.*;

public class Controller {

	private static Controller ctrl = new Controller();
	private static AdminFrame admin = new AdminFrame(ctrl);
	private StudentDao studentDao = new StudentDaoImpl();
	private ExamDao examDao = new ExamDaoImpl();
	private StudentExamDao studentExamDao = new StudentExamDaoImpl();

	private List<StudentWithExam> studentsWithExamList = new ArrayList<StudentWithExam>();
	private List<Exam> examsList = new ArrayList<Exam>();

	public static void main(String[] args) {

		admin = new AdminFrame(ctrl);
		admin.setVisible(true);

	}

	public void addStudentFrame() {
		AddStudentFrame addStudentFrame = new AddStudentFrame(ctrl);
		addStudentFrame.setVisible(true);
	}

	public boolean addStudent(String matricola, String firstName, String lastName) {

		if (matricola.length() == 9 && !firstName.isEmpty() && !lastName.isEmpty()) {

			Student student = new Student(matricola, firstName, lastName);

			if (studentDao.addStudent(student)) {
				return true;
			}
		}
		return false;
	}

	public void removeStudentFrame() {
		RemoveStudentFrame removeStudentFrame = new RemoveStudentFrame(ctrl);
		removeStudentFrame.setVisible(true);
	}

	public boolean removeStudent(String matricola) {

		int removedRows = 0;

		if (matricola.length() == 9) {

			removedRows = studentDao.removeStudent(matricola);

			if (removedRows != 0) {
				return true;
			}
		}

		return false;
	}

	public void searchStudentFrame() {
		SearchStudentFrame searchStudentFrame = new SearchStudentFrame(ctrl);
		searchStudentFrame.setVisible(true);
	}

	public Student searchStudent(String matricola) {

		Student student = null;

		if (matricola.length() == 9) {

			student = studentDao.searchStudent(matricola);

			return student;
		}

		return student;
	}

	public void getAllStudents() {

		AllStudentsFrame allStudentsFrame = new AllStudentsFrame(ctrl);

		DefaultTableModel model = allStudentsFrame.getTableModel();

		studentsWithExamList = studentDao.getAllStudents();

		for (StudentWithExam std : studentsWithExamList) {
			model.addRow(new Object[] { std.getMatricola(), std.getFirstName(), std.getLastName(), std.getCE(), std.getVote()});
		}

		allStudentsFrame.setVisible(true);

	}

	public void addExamFrame() {
		AddExamFrame addExamFrame = new AddExamFrame(ctrl);
		addExamFrame.setVisible(true);
	}

	public boolean addExam(String CE, String name, String professorName) {

		Exam exam = null;

		if (CE.length() == 4 && !name.isEmpty() && !professorName.isEmpty()) {

			exam = new Exam(CE, name, professorName);

			if (examDao.addExam(exam)) {
				return true;
			}
		}
		return false;
	}

	public void removeExamFrame() {
		RemoveExamFrame removeExamFrame = new RemoveExamFrame(ctrl);
		removeExamFrame.setVisible(true);
	}

	public boolean removeExam(String CE) {

		int removedRows = 0;

		if (CE.length() == 4) {

			removedRows = examDao.removeExam(CE);

			if (removedRows != 0) {
				return true;
			}
		}

		return false;
	}

	public void searchExamFrame() {
		SearchExamFrame searchExamFrame = new SearchExamFrame(ctrl);
		searchExamFrame.setVisible(true);
	}

	public Exam searchExam(String CE) {

		Exam exam = null;

		if (CE.length() == 4) {

			exam = examDao.searchExam(CE);

			return exam;
		}

		return exam;
	}

	public void addAnExamToAstudentFrame() {
		AddAnExamToAstudentFrame addAnExamToAstudentFrame = new AddAnExamToAstudentFrame(ctrl);
		addAnExamToAstudentFrame.setVisible(true);
	}

	public boolean addAnExamToAstudent(String CE, String matricola, String vote) {
			
		StudentExam studentExam = null;

			try {
				
				int Vote = Integer.parseInt(vote);
				
				if (CE.length() == 4 && matricola.length() == 9 && (Vote >= 18 && Vote <= 30)) {

					studentExam = new StudentExam(CE, matricola, Vote);

					if (studentExamDao.addAnExamToAstudent(studentExam)) {
						return true;
					}
				}
				
			}catch(Exception e) {
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				return false;
			}
			
			return false;
	}

	public void getAllExams() {

		AllExamsFrame allExamsFrame = new AllExamsFrame(ctrl);

		DefaultTableModel model = allExamsFrame.getTableModel();

		examsList = examDao.getAllExams();

		for (Exam exam : examsList) {
			model.addRow(new Object[] { exam.getCE(), exam.getName(), exam.getProfessorName() });
		}

		allExamsFrame.setVisible(true);

	}

	public static AdminFrame getAdmin() {
		return admin;
	}
}
