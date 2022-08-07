package com.goit.java5.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.goit.java5.model.Command;

public class CommandService {
	private Connection connection;
	private final Map<String, Command> commands;

	public CommandService(String url, String username, String password) {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		commands = new HashMap<>();
		//todo add command
	}
}
