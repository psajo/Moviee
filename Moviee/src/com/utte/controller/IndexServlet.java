package com.utte.controller;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member mvo = (Member)session.getAttribute("mvo");
		List<Movie> list= null ;
		Movie m2 = null;
		List<Review> r = null;
		System.out.println("mvo:"+mvo);
		
		list = MovieDAO.getMovie(mvo);
		m2 = MovieDAO.getMovie();
		r = ReviewDAO.getReviewsByMvId(m2.getMv_id(),1);
		
		System.out.println("IndexServ : " + list.size());
		
		request.setAttribute("movielist", list);
		request.setAttribute("m2", m2);
		request.setAttribute("r", r);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
