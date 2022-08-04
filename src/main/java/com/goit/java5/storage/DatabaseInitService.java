package com.goit.java5.storage;

import com.goit.java5.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
//	public void initDb(String connectionUrl, String connectionUser, String connectionPass) {
	public void initDb(Storage storage) {


		// Create the Flyway instance and point it to the database
		String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
		String connectionUser = new Prefs().getString(Prefs.DB_USER);
		String connectionPass = new Prefs().getString(Prefs.DB_PASS);
		Flyway flyway = Flyway
				.configure()
				.dataSource(connectionUrl, connectionUser, connectionPass)
				.load();

		// Start the migration
		flyway.migrate();
	}
}
