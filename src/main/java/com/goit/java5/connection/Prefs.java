package com.goit.java5.connection;

import lombok.Getter;

@Getter
public class Prefs {
	private final String DB_JDBC_CONNECTION_URL = "jdbc:mysql://localhost/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "pass";
}
