package com.ayush;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ayush.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// take from db
		LoginDao userAuthenticate = new LoginDao();
		boolean isValidUser = userAuthenticate.authenticate(username, password);
		
		if(isValidUser) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("loginForm.jsp");
		}
	}

}
