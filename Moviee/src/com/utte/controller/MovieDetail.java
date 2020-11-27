package com.utte.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utte.beans.Member;
import com.utte.beans.Movie;
import com.utte.beans.Review;
import com.utte.dao.MovieDAO;
import com.utte.dao.ReviewDAO;

@WebServlet("/MovieDetail")
public class MovieDetail extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member mvo = (Member)session.getAttribute("mvo");
		Movie m = null;
		List<Review> r = null;
		System.out.println("mvo:"+mvo);
		String mv_id = request.getParameter("mv_id");
		//String mv_id = "12";
		m = MovieDAO.getMovie(mv_id);
		r = ReviewDAO.getReviewsByMvId(mv_id,1);
	
		
		request.setAttribute("m", m);
		request.setAttribute("r", r);
		request.getRequestDispatcher("/movieDetail.jsp").forward(request, response);
	}

	

}
