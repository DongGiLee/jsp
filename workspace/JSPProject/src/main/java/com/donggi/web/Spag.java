package com.donggi.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag_mvc2")
public class Spag extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = 0;
		String model;
		String num_ = req.getParameter("n");

		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		if (num % 2 == 0)
			model = "짝수";
		else
			model = "홀수";
		
		String[] names = {"donggi", "skandar"};
		
		Map<String,Object> notice = new HashMap<>();
		notice.put("age", 30);
		notice.put("local", "korea");
		
		req.setAttribute("model", model);
		req.setAttribute("notice", notice);
		req.setAttribute("names", names);
		req.setAttribute("result", "리설트");
		
		
		//redirect: 현재작업과 상관없이 새로운요청
		//forward : 현재작업을 이어서
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("spag_mvc2.jsp");
		dispatcher.forward(req, resp);

	}

}
