package com.donggi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();

		int sum = 0;

		int v = Integer.parseInt(request.getParameter("v"));
		String op = request.getParameter("operator");

		if (op.equals("=")) {

//			String operator = (String) application.getAttribute("op");
//			int v_ = (Integer) application.getAttribute("value");

//			String operator = (String) session.getAttribute("op");
//			int v_ = (Integer) session.getAttribute("value");
			int v_ = 0;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("value")) {
					v_ = Integer.parseInt(cookie.getValue());
					break;
				}
				
			}
			String operator = "";
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("op")) {
					
					if (cookie.getValue().equals("+")) {
						sum = v_ + v;
					} else if (cookie.getValue().equals("-")) {
						sum = v_ - v;
					}
					break;
				}
			}

//			if (operator.equals("+")) {
//				sum = v_ + v;
//			} else if (operator.equals("-")) {
//				sum = v_ - v;
//			}
			out.println("<h2>" + sum + "</h2>");
		} else {

//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
			
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value",String.valueOf(v));
			Cookie operatorCookie= new Cookie("op",op);
			
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60);	// sec
			
			operatorCookie.setPath("/calc2");
			
			response.addCookie(valueCookie);
			response.addCookie(operatorCookie);
			
			response.sendRedirect("/calc2.html");
			
		}

	}

}
