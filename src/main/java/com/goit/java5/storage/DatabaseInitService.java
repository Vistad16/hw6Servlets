package com.goit.java5.storage;

import com.goit.java5.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
	public void initDb(String connectionUrl, String connectionUser, String connectionPass) {
		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway
				.configure()
				.dataSource(connectionUrl, connectionUser, connectionPass)
				.load();

		// Start the migration
		flyway.migrate();
	}
}
