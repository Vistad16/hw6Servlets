package com.goit.java5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.goit.java5.prefs.Prefs;
import com.goit.java5.storage.DatabaseInitService;
import com.goit.java5.storage.Storage;

public class App {
	public static void main(String[] args) {
		Storage storage = Storage.getInstance();

		//test
		//Connection connection = storage.getConnection();

//		storage.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");

		new DatabaseInitService().initDb(storage);

}
}
