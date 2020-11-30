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
import javax.websocket.SendResult;

import com.utte.beans.Member;
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
		String useCookie =request.getParameter("lgch");
		System.out.println("cookie : "+useCookie);
		String uri =(String)request.getSession().getAttribute("uri");
		Member mvo = MemberDAO.login(m_email, m_pwd);
		if(mvo != null) {
			System.out.println("m_nick : "  +mvo.getM_nick());
			HttpSession session =  request.getSession();
			session.setAttribute("mvo", mvo);
			
			System.out.println("uri:"+uri);
			response.sendRedirect(uri);
		}else{
			request.setAttribute("failed", true);
			RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
