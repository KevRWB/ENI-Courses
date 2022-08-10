package fr.eni.projeteliot.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

	private static String url;
	
	private static String user;
	
	private static String password;
	
	static {
		url = Settings.getValue("url");
		user = Settings.getValue("user");
		password = Settings.getValue("password");
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}




