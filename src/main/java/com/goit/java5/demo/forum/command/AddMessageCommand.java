package com.goit.java5.demo.forum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import com.goit.java5.demo.forum.InMemoryMessageStorage;
import com.goit.java5.demo.forum.Message;
import org.thymeleaf.TemplateEngine;

public class AddMessageCommand implements Command{
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
		String author = req.getParameter("author");
		String content = req.getParameter("content");

		Message message = new Message();
		message.setAuthor(author);
		message.setContent(content);
		message.setId(UUID.randomUUID().toString());

		InMemoryMessageStorage.getInstance().add(message);

		resp.sendRedirect("/hw6Servlets/forum");
	}
}
