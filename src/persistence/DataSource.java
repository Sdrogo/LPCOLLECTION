package persistence;

import java.sql.*;

public class DataSource {
	final private String dbURI;// = "jdbc:postgresql://localhost/LpCollector";
	final private String userName;// = "postgres";
	final private String password;// = "postgres";
	
	private static final DataSource data = new DataSource("jdbc:postgresql://localhost:5432/LpCollection","postgres","postgres");
		
	public DataSource(String dbURI, String userName, String password) {
		this.dbURI=dbURI;
		this.userName=userName;
		this.password=password;
	}

	public static DataSource getInstance() {
		return data;
	}
	
	public Connection getConnection() throws PersistenceException {
		Connection connection = null;
		try {
		    connection = DriverManager.getConnection(dbURI,userName, password);
			
		
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
}
