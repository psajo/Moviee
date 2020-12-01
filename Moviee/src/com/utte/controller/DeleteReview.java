package com.utte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.dao.ReviewDAO;

/**
 * Servlet implementation class DeleteReview
 */
@WebServlet("/DeleteReview")
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r_reviewId = request.getParameter("r_reviewId");
		String uri = request.getParameter("uri");
		int ret =ReviewDAO.delReview(Integer.parseInt(r_reviewId));
		if(ret >0) {
			System.out.println(r_reviewId+" 리뷰 삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		response.sendRedirect(uri);
		
	}

}
