package com.epam.bigdata.restaurant.database;

import java.sql.*;

import com.epam.bigdata.restaurant.logger.FatalLogger;

public class ConnectToDataBase {
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final static String DB_URL = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";
	   
	public static Connection createConnectionWithDataBase() throws SQLException {	
		Connection connection = null;	
		try {				   	
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);		
		}
		catch(ClassNotFoundException e){
			new FatalLogger("A problem occurred while registering JDBC driver: " + e.getMessage());
			System.err.println("\nTechnical issues. Accept our apologies :(");
			System.exit(0);
		}
		
		return connection;		
	}
}
