package Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.DbConnection;

public class ExamDaoImpl implements ExamDao {

	private Connection conn = null;
	private static final String CREATE_QUERY = "INSERT INTO exam VALUES (?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM exam WHERE ce = ?";
	private static final String READ_QUERY = "SELECT * FROM exam WHERE ce = ?";
	private static final String READ_ALL_QUERY = "SELECT * FROM exam";

	public boolean addExam(Exam exam) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, exam.getCE());
			preparedStatement.setString(2, exam.getName());
			preparedStatement.setString(3, exam.getProfessorName());
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

	public int removeExam(String CE) {

		PreparedStatement preparedStatement = null;

		try {

			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(DELETE_QUERY);
			preparedStatement.setString(1, CE);

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {

			// e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return 0;

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

	public Exam searchExam(String CE) {

		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Exam exam = null;

		try {

			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(READ_QUERY);
			preparedStatement.setString(1, CE);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			if (result.next() && result != null) {
				exam = new Exam(result.getString(1), result.getString(2), result.getString(3));
			}

		} catch (SQLException e) {

			// e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;

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
		return exam;
	}

	public List<Exam> getAllExams() {

		List<Exam> examsList = new ArrayList<Exam>();
		Exam exam = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {

			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(READ_ALL_QUERY);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {
				exam = new Exam(result.getString(1), result.getString(2), result.getString(3));
				examsList.add(exam);
			}

		} catch (SQLException e) {

			// e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

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

		return examsList;
	}
}
