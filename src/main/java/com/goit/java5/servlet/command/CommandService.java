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
import com.goit.java5.servlet.command.customers.AddCustomersCommand;
import com.goit.java5.servlet.command.customers.DeleteCustomersCommand;
import com.goit.java5.servlet.command.customers.GetCustomersCommand;
import com.goit.java5.servlet.command.customers.UpdateCustomersCommand;
import com.goit.java5.servlet.command.developers.AddDevelopersCommand;
import com.goit.java5.servlet.command.developers.DeleteDevelopersCommand;
import com.goit.java5.servlet.command.developers.GetDevelopersCommand;
import com.goit.java5.servlet.command.developers.UpdateDevelopersCommand;
import com.goit.java5.servlet.command.projects.AddProjectsCommand;
import com.goit.java5.servlet.command.projects.DeleteProjectsCommand;
import com.goit.java5.servlet.command.projects.GetProjectsCommand;
import com.goit.java5.servlet.command.projects.UpdateProjectsCommand;
import com.goit.java5.servlet.command.skills.AddSkillsCommand;
import com.goit.java5.servlet.command.skills.DeleteSkillsCommand;
import com.goit.java5.servlet.command.skills.GetSkillsCommand;
import com.goit.java5.servlet.command.skills.UpdateSkillsCommand;

public class CommandService {
	private final Map<String, Command> commands;

	public CommandService() {
		commands = new HashMap<>();
		//todo add commands
		//company
		commands.put("POST /hw6Servlets/companies", new AddCommands());
		commands.put("POST /hw6Servlets/companies/delete", new DeleteCommands());
		commands.put("GET /hw6Servlets/companies", new GetCommands());
		commands.put("POST /hw6Servlets/companies/update", new UpdateCommand());
		//customers
		commands.put("POST /hw6Servlets/customers/add", new AddCustomersCommand());
		commands.put("POST /hw6Servlets/customers/delete", new DeleteCustomersCommand());
		commands.put("GET /hw6Servlets/customers", new GetCustomersCommand());
		commands.put("POST /hw6Servlets/customers/update", new UpdateCustomersCommand());
		//developers
		commands.put("POST /hw6Servlets/developers/add", new AddDevelopersCommand());
		commands.put("POST /hw6Servlets/developers/delete", new DeleteDevelopersCommand());
		commands.put("GET /hw6Servlets/developers", new GetDevelopersCommand());
		commands.put("POST /hw6Servlets/developers/update", new UpdateDevelopersCommand());
		//projects
		commands.put("POST /hw6Servlets/projects/add", new AddProjectsCommand());
		commands.put("POST /hw6Servlets/projects/delete", new DeleteProjectsCommand());
		commands.put("GET /hw6Servlets/projects", new GetProjectsCommand());
		commands.put("POST /hw6Servlets/projects/update", new UpdateProjectsCommand());
		//skills
		commands.put("POST /hw6Servlets/skills/add", new AddSkillsCommand());
		commands.put("POST /hw6Servlets/skills/delete", new DeleteSkillsCommand());
		commands.put("GET /hw6Servlets/skills", new GetSkillsCommand());
		commands.put("POST /hw6Servlets/skills/update", new UpdateSkillsCommand());
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
