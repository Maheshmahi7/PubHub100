package pubhub.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pubhub.dao.BookTagDAO;
import pubhub.dao.BookTagDAOImpl;

public class DAOUtilities {
	
//	private static final String CONNECTION_USERNAME = "root";
//	private static final String CONNECTION_PASSWORD = "MAhesh19";
//	private static final String URL = "jdbc:mysql://localhost:3306/pubhub";
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pubhub","root", "MAhesh19");
			System.out.println(connection.getMetaData().getUserName());
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pubhub","root", "MAhesh19");
		}
		return connection;
	}
	
	public static BookTagDAO getBookTagDAO() {
		return new BookTagDAOImpl();
	}

}
