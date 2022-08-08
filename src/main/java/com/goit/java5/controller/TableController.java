package com.goit.java5.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.goit.java5.pref.DatabaseInitService;
import com.goit.java5.pref.Prefs;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

//engine create
@WebServlet ("/")//люба урла приведе на мейн сторінку
public class TableController extends HttpServlet {
	public TemplateEngine engine;
	public CommandService commandService;

	@Override
	public void init() {
		new DatabaseInitService().initDb(Prefs.DB_JDBC_CONNECTION_URL, Prefs.DB_USER, Prefs.DB_PASS);

		engine = new TemplateEngine();

		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setPrefix("D:/Temp/hw6Servlets/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(engine.getTemplateResolvers().size());
		resolver.setCacheable(false);
		engine.addTemplateResolver(resolver);

		commandService = new CommandService(Prefs.DB_JDBC_CONNECTION_URL, Prefs.DB_USER, Prefs.DB_PASS);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		Context simpleContext = new Context();
		engine.process("main", simpleContext, resp.getWriter());
		resp.getWriter().close();
	}
}
