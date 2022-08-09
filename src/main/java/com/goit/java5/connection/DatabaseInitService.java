package com.goit.java5.connection;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
	public void initDb() {
		Prefs prefs = new Prefs();

		Flyway flyway = Flyway
				.configure()
				.dataSource(prefs.getDB_JDBC_CONNECTION_URL(), prefs.getDB_USER(), prefs.getDB_PASS())
				.load();

		flyway.migrate();
	}
}
