package Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.*;

@SuppressWarnings("unused")
public class StudentDaoImpl implements StudentDao {
	
	private Connection conn = null;
	private static final String CREATE_QUERY = "INSERT INTO student VALUES (?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM student WHERE matricola = ?";
	private static final String READ_QUERY = "SELECT * FROM student WHERE matricola = ?";
	
	private static final String READ_ALL_QUERY = (
													  " SELECT student.matricola, student.first_name, student.last_name, studentexams.ce, studentexams.vote "
													+ " FROM student LEFT OUTER JOIN studentexams "
													+ " ON student.matricola = studentexams.matricola "
													+ " GROUP BY student.matricola, studentexams.ce, studentexams.vote "
												 );
	
	public boolean addStudent(Student student) {
		
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
        	
        	conn = new DbConnection().getConnection();
        	preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getMatricola().toUpperCase());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
            
            if (result.next() && result != null) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
			
        	//e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			return false;
			
		} finally {
            try {
            	
                preparedStatement.close();
            
            } catch (Exception e) {
            	
                //e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
            try {
            	
                conn.close();
                
            } catch (Exception e) {
            	
                //e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
        }
	}
	
	public int removeStudent(String matricola) {
        
		PreparedStatement preparedStatement = null;
     
		try {
        	
			conn = new DbConnection().getConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setString(1, matricola);
            
            return preparedStatement.executeUpdate();
            
        } catch (SQLException e) {

        	//e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return 0;
            
        } finally {
            try {
                
            	preparedStatement.close();
            
            } catch (Exception e) {
                
            	//e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
            try {
            	
                conn.close();
                
            } catch (Exception e) {
                
            	//e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
        }
	}
	
	public Student searchStudent(String matricola) {
       
		PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Student student = null;
        
        try {
        	
        	conn = new DbConnection().getConnection();
            preparedStatement = conn.prepareStatement(READ_QUERY);
            preparedStatement.setString(1, matricola);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            
            if (result.next() && result != null) {
            	student = new Student(result.getString(1), result.getString(2), result.getString(3));
            } 
            
        } catch (SQLException e) {
            
        	//e.printStackTrace();
        	System.err.println(e.getClass().getName()+": "+e.getMessage());
            return null;
        
        } finally {
            try {
            	
                preparedStatement.close();
                
            } catch (Exception e) {
                
            	//e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
            try {
            	
                conn.close();
                
            } catch (Exception e) {
                
            	//e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
        }
        return student;
	}

	public List<StudentWithExam> getAllStudents() {
		
		List<StudentWithExam> studentsList = new ArrayList<StudentWithExam>();
		StudentWithExam student = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			
			conn = new DbConnection().getConnection();
			preparedStatement = conn.prepareStatement(READ_ALL_QUERY);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while (result.next()) {
				student = new StudentWithExam(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
				studentsList.add(student);
			}
            
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			
		} finally {
            try {
                
            	preparedStatement.close();
            	
            } catch (Exception e) {
                
            	//e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
            try {
            	
                conn.close();
                
            } catch (Exception e) {
            	
                //e.printStackTrace();
            	System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
        }

		return studentsList;
	}
}