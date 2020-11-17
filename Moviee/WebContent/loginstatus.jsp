<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String status = (String)request.getAttribute("login_result");
	System.out.println("test: "+status);
	System.out.println(request.getParameter("m_email"));
	out.print(status);
%>