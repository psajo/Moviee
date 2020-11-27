package com.utte.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.beans.Review;
import com.utte.dao.ReviewDAO;

/**
 * Servlet implementation class WriteReview
 */
@WebServlet("/WriteReview")
public class WriteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//M_NICK MV_ID R_CONTENTS R_STAR
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String m_nick= request.getParameter("M_NICK");
		int mv_id= Integer.parseInt(request.getParameter("MV_ID"));
		String r_contents= request.getParameter("R_CONTENTS");
		int r_star= Integer.parseInt(request.getParameter("R_STAR"));
		String uri = request.getParameter("uri");
		Review rvo = new Review(); //review 객체 만들어서 한번에 담아서 전달
		rvo.setM_nick(m_nick);
		rvo.setMv_id(mv_id);
		rvo.setR_contents(r_contents);
		rvo.setR_star(r_star);
		int ret =ReviewDAO.insertReview(rvo);
		if(ret >0) {
			response.sendRedirect(uri);
		}else {
			PrintWriter out= response.getWriter();
			out.print("리뷰<SCRIPT>alert('리뷰실패!!!');</SCRIPT>");
			out.close();
		}
		
	}
}

