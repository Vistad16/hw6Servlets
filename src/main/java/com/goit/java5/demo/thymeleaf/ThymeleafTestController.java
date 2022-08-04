package com.goit.java5.demo.thymeleaf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

@WebServlet ("/thymeleaf")
public class ThymeleafTestController extends HttpServlet {
	private TemplateEngine engine;

	@Override
	public void init() throws ServletException {
		engine = new TemplateEngine();

		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setPrefix("D:\\goit\\hw6Servlets\\templates\\");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(engine.getTemplateResolvers().size());
		resolver.setCacheable(false);
		engine.addTemplateResolver(resolver);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> parameterMap = req.getParameterMap();

		Map<String, Object> params = new LinkedHashMap<>();
		for (Map.Entry<String, String[]> keyValue : parameterMap.entrySet()){
			params.put(keyValue.getKey(), keyValue.getValue()[0]);
		}
		resp.setContentType("text/html");
		Context simpleContext = new Context(
				req.getLocale(),
				Map.of("queryParams", params)
		);
		engine.process("test", simpleContext, resp.getWriter());
		resp.getWriter().close();
	}
}
