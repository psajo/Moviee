package com.utte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utte.dao.MemberDAO;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String test =req.getParameter("test");
		resp.getWriter().print("테스트 서블릿!"+test);
		if(MemberDAO.dup_email("test3@test.com")) {
			System.out.println("중복");
		}else {
			System.out.println("가입가능");
		}
	}

}
