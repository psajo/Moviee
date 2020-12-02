package com.utte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String access_token = (String)session.getAttribute("access_token");
		session.invalidate();
		
		String uri = request.getParameter("uri");
		Cookie ck = new Cookie("m_email",null);
		ck.setMaxAge(0);
		response.addCookie(ck);
		System.out.println("logout : "+uri);
		if(uri == null || uri.equals("")) {
			response.sendRedirect("IndexServlet");
		}else {
			response.sendRedirect(uri);
		}
	}

}
