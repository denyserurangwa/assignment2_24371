package com.auca.submission;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request. getParameter("email");
		String password= request. getParameter("password");
		
		if(email.equals("bwadenyse@gmail.com")&& password.equals("1234")) {
			User user = new User();
			user.setEmail(email);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("submission.html");
		}else {
			response.sendRedirect("index.html");
		}
}
}