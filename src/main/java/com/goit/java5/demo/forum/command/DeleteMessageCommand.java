package com.goit.java5.demo.forum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.goit.java5.demo.forum.InMemoryMessageStorage;
import org.thymeleaf.TemplateEngine;

public class DeleteMessageCommand implements Command {
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
		String id = req.getParameter("id");
		InMemoryMessageStorage.getInstance().deleteById(id);

		resp.sendRedirect("/hw6Servlets/forum");
	}
}
