package Connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private Connection conn = null;
	
	public DbConnection() {
		
		try {
			
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(//EDIT THIS LINK jdbc:postgresql://<host>:<port>/<dbname>?user=<username>&password=<password>);

		} catch (Exception e) {
			
			//e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
}
