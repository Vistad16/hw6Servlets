package com.goit.java5.demo.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet ("/api/calc")
public class CalcServlet extends HttpServlet {
	private CalcService calcService;

	@Override
	public void init() throws ServletException {//initializing start servlet
		calcService = new CalcService();
		super.init();
	}

	private CalcRequest mapToCalcRequest(HttpServletRequest request){
		String body = null;
		try {
			body = request
					.getReader()
					.lines()
					.collect(Collectors.joining("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> params = new Gson().fromJson(body, TypeToken.getParameterized(Map.class, String.class, String.class)
																		.getType());

		return new Gson().fromJson(body, CalcRequest.class);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CalcRequest calcRequest = mapToCalcRequest(req);

		CalcResponse calcResponse = calcService.calculate(calcRequest);

		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(calcResponse));
		resp.getWriter().close();
	}
}
