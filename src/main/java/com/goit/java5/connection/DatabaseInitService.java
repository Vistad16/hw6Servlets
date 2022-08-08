package com.goit.java5.connection;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
	public void initDb() {
		Prefs prefs = new Prefs();
		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway
				.configure()
				.dataSource(prefs.getDB_JDBC_CONNECTION_URL(), prefs.getDB_USER(), prefs.getDB_PASS())
				.load();

		// Start the migration
		flyway.migrate();
	}
}
