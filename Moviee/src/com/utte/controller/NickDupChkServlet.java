package com.utte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class NickDupChkServlet
 */
@WebServlet("/NickDupChkServlet")
public class NickDupChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_nick = request.getParameter("m_nick");
		boolean isDup = MemberDAO.dup_nick(m_nick);
		if(isDup) {
			//중복인경우
			response.getWriter().print("dup");
		}else {
			//가입가능한경우
			response.getWriter().print("ok");
		}
	}

}
