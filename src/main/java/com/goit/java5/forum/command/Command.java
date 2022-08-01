package com.goit.java5.forum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;

public interface Command {
	void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException;
}
