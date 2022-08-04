package com.goit.java5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.goit.java5.prefs.Prefs;
import com.goit.java5.storage.DatabaseInitService;
import com.goit.java5.storage.Storage;

public class App {
	public static void main(String[] args) throws SQLException {
		Storage storage = Storage.getInstance();
//
//		new DatabaseInitService().initDb(
//				new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL),
//				new Prefs().getString(Prefs.DB_USER),
//				new Prefs().getString(Prefs.DB_PASS)
//				);

}
}
