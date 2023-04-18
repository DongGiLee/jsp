package com.donggi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int sum = 0;
		
		String[] nums = request.getParameterValues("num");
		
		for (int i=0; i<nums.length; i++) {
			int num = Integer.parseInt(nums[i]);
			sum += num;
		}
		
		out.println("<h2>" + sum + "</h2>");

	}

}
