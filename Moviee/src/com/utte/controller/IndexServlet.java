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
import com.utte.dao.MovieDAO;

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
		
		list = MovieDAO.getMovie(mvo);
		System.out.println("IndexServ : " + list.size());
		request.setAttribute("movielist", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
