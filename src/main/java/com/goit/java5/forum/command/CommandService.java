package com.goit.java5.forum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.TemplateEngine;

public class CommandService {
	private Map<String, Command> commands;

	public CommandService(){
		commands = new HashMap<>();
		//registration command
		commands.put("GET /hw6Servlets/forum", new GetMessagesCommand());
		commands.put("POST /hw6Servlets/forum/delete", new DeleteMessageCommand());
		commands.put("POST /hw6Servlets/forum", new AddMessageCommand());
	}

	public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
		String requestUri = req.getRequestURI();
		String commandKey = req.getMethod() + " " + requestUri;

		commands.get(commandKey).process(req, resp, engine);
	}
}
