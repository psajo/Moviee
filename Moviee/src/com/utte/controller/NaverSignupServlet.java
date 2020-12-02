package com.utte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.beans.Member;
import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class NaverSignupServlet
 */
@WebServlet("/NaverSignupServlet")
public class NaverSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid=request.getParameter("nid");
		System.out.println("ns nid : "+nid);
		String m_nick = request.getParameter("m_nick");
		String[] favs = request.getParameterValues("m_fav");
		Member mvo = new Member();
		mvo.setM_email(nid);
		mvo.setM_nick(m_nick);
		mvo.setM_fav1(favs[0]);
		mvo.setM_fav2(favs[1]);
		mvo.setM_fav3(favs[2]);
		int ret =MemberDAO.insertNaver(mvo);
		if(ret >0) {
			System.out.println("네이버회원가입 성공");
			request.getSession().setAttribute("mvo", mvo);
		}
		String uri = (String)request.getSession().getAttribute("uri");
		if(uri == null || uri.equals("")) {
			response.sendRedirect("IndexServlet");
		}else {
			response.sendRedirect(uri);
		}
	}

}
