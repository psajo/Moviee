package com.utte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_email =request.getParameter("m_email");
		String m_pwd = request.getParameter("m_pwd");
		String login_id = MemberDAO.login(m_email, m_pwd);
		System.out.println("login_id : " +login_id);
		if(login_id != null) {
			HttpSession session =  request.getSession();
			session.setAttribute("login_id", login_id);
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("failed", true);
			RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
