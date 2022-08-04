package com.goit.java5.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.goit.java5.prefs.Prefs;

public class Storage {

	private static final Storage INSTANCE = new Storage();

	private Connection connection;

	private Storage() {
		try {
			String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
			String connectionUser = new Prefs().getString(Prefs.DB_USER);
			String connectionPass = new Prefs().getString(Prefs.DB_PASS);
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
