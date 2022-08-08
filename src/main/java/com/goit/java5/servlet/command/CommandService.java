package com.goit.java5.servlet.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.goit.java5.servlet.command.companies.AddCommands;
import com.goit.java5.servlet.command.companies.DeleteCommands;
import com.goit.java5.servlet.command.companies.GetCommands;
import com.goit.java5.servlet.command.companies.UpdateCommand;

public class CommandService {
	private final Map<String, Command> commands;

	public CommandService() {
		commands = new HashMap<>();
		//todo add commands
		commands.put("GET /companies", new GetCommands());
		commands.put("POST /companies/delete", new DeleteCommands());
		commands.put("POST /companies", new AddCommands());
		commands.put("POST /companies/update", new UpdateCommand());


	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String requestURI = req.getRequestURI();
		String commandKey = req.getMethod() + " " + requestURI;

		try {
			commands.get(commandKey).process(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
