package br.ufc.quixada.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/";
	private static final String DB_NAME = "persistencia";
	private static final String USER = "root";
	private static final String PASSWORD = "yagocruz123";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(DRIVE_NAME);
			Connection con = DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
			return con;
		}catch(ClassNotFoundException e) {
			throw new SQLException();
		}
	}
}
