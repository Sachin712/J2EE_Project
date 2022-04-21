package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	private static Connection connection;
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	/*private static String CONNECTION_URL = "jdbc:mysql://127.0.0.1:3306/j2ee_project";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";*/
	
	private static String CONNECTION_URL = "jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_b89caede66a73b0";
	private static String USERNAME = "bbb7cb0f2b35ac";
	private static String PASSWORD = "0ed99054";


	private DB() {

	}

	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		}
		return connection;
	}

}
