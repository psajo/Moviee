package com.utte.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(login_id != null) {
			System.out.println(login_id);
			request.setAttribute("login_result", login_id);
			request.getRequestDispatcher("loginstatus.jsp").forward(request, response);
		}else {
			System.out.println("!");
			request.setAttribute("login_result", "f");
			System.out.println(request.getAttribute("login_result"));
			RequestDispatcher rd =  request.getRequestDispatcher("loginstatus.jsp");
			rd.forward(request, response);
		}
		
	}

}
