<%@page import="com.utte.beans.Member"%>
<%@page import="com.utte.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member mvo = new Member();
	String m_email = request.getParameter("user_id");
	mvo.setM_email(m_email);
	String m_pwd = request.getParameter("user_pwd");
	mvo.setM_pwd("user_pwd");
	String m_nick = request.getParameter("user_nick");
	mvo.setM_nick("user_nick");
	String[] favs = request.getParameterValues("user_fav");
	mvo.setM_fav1(favs[0]);
	mvo.setM_fav1(favs[1]);
	mvo.setM_fav1(favs[2]);
	int ret = MemberDAO.signUp(mvo);
	if(ret ==0) {
		out.print("alert('회원가입 실패');");
		response.sendRedirect("signup.jsp");
	}else {
		out.print("alert('회원가입에 성공하셨습니다.')");
		String uri = (String)session.getAttribute("uri");
		System.out.println(uri);
		response.sendRedirect(uri);
	}
%>