package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	Connection connection = null;
	
	
	public DBManager(){
		
	}
	
	public void setConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			System.out.println("Connection is set!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		 Statement statement;
		 ResultSet rs; 
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			return rs;
	}
	
	public void executeUpdate(String query) throws SQLException {
		 Statement statement;
		 statement = connection.createStatement();
		 statement.executeUpdate(query);
		
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
		System.out.println("Connection is closed");
	}
	
	
}
