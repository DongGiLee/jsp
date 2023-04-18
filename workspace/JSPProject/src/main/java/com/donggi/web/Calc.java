package com.donggi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int sum = 0;

		String operator = request.getParameter("operator");
		

		if (operator.equals("덧셈")) {
			sum = num1 + num2;
		} else if (operator.equals("뺄셈")) {
			sum = num1 - num2;
		}

			out.println("<h2>" + num1 + " + " + num2 + " = " + sum);

	}

}
