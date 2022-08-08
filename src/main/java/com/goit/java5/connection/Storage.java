package com.goit.java5.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {

	private static final Storage INSTANCE = new Storage();

	private Connection connection;

	Prefs prefs = new Prefs();

	private Storage() {
		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //deprecated
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			//don't know why not working this
//			connection = DriverManager.getConnection(prefs.getDB_JDBC_CONNECTION_URL(), prefs.getDB_USER(), prefs.getDB_USER());

			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "pass");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		new DatabaseInitService().initDb();
	}

	public static Storage getInstance() {
		return INSTANCE;
	}

	public int executeUpdate(String sql) {
		try (Statement st = connection.createStatement()) {
			return st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();

			return -1;
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}