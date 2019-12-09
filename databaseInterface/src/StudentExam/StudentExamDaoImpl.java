package StudentExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DbConnection;

public class StudentExamDaoImpl implements StudentExamDao {

	private Connection conn = null;
	private static final String ADD_EXAM_TO_A_STUDENT_QUERY = "INSERT INTO studentexams VALUES (?,?,?)";

	public boolean addAnExamToAstudent(StudentExam studentExam) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(ADD_EXAM_TO_A_STUDENT_QUERY, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, studentExam.getCE());
			preparedStatement.setString(2, studentExam.getMatricola());
			preparedStatement.setInt(3, studentExam.getVoto());
			preparedStatement.execute();
			result = preparedStatement.getGeneratedKeys();

			if (result.next() && result != null) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {

			// e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;

		} finally {
			try {

				preparedStatement.close();

			} catch (Exception e) {

				// e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
			try {

				conn.close();

			} catch (Exception e) {

				// e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}

	}

}
