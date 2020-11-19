<%@page import="com.utte.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mvo" class="com.utte.beans.Member"/>
<jsp:setProperty property="*" name="mvo"/>
<%
	int ret = MemberDAO.signUp(mvo);
	if(ret ==0) {
		out.print("alert('회원가입 실패');");
		response.sendRedirect("signup.jsp");
	}else {
		out.print("alert('회원가입 성공하셨습니다.')");
		String uri = (String)session.getAttribute("uri");
		System.out.println(uri);
		response.sendRedirect(uri);
	}
%>