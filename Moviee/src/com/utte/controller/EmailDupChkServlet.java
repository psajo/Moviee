package com.utte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class EmailDupChkServlet
 */
@WebServlet("/EmailDupChkServlet")
public class EmailDupChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_email = request.getParameter("m_email");
		System.out.println(m_email);
		boolean isDup = MemberDAO.dup_email(m_email);
		if(isDup) {
			//중복인경우
			response.getWriter().print("dup");
		}else {
			//가입가능한경우
			response.getWriter().print("ok");
		}
	}

}
