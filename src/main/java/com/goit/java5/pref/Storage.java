package com.goit.java5.pref;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {

	private static final Storage INSTANCE = new Storage();

	private Connection connection;

	private Storage() {
		try {
			String connectionUrl = Prefs.DB_JDBC_CONNECTION_URL;
			String connectionUser = Prefs.DB_USER;
			String connectionPass = Prefs.DB_PASS;
			connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPass);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Storage getInstance() {
		return INSTANCE;
	}

	public int executeUpdate(String sql) {
		try(Statement st = connection.createStatement()) {
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
