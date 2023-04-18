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

/*
 * Application 객체로 저장하기
 * Session 객체로 저장하기
 * Cookie 객체로 저장하기
 * 
 * ServletContext 사용
 * HttpSession 사용
 * Cookie 사용
 * 
 * 차이점 정리
 * 
 * Application	
 * ----------------------
 * 전역범위
 * was가 시작해서 종료할때 까지
 * was 서버의 메모리
 * 
 * Session
 * ----------------------
 * 세션 범위
 * 세션이 시작해서 종료할때 까지
 * was 서버의 메모리
 * 
 * Cookie
 * ----------------------
 * Web Browser 별 지정한 path 범주 공간
 * Browser에 전달한 시간 부터 만료시간 까지
 * Web Browser 의 메모리 또는 파일
 * 
 * */
@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

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
