<%@page import="java.util.List"%>
<%@page import="com.utte.dao.ReviewDAO"%>
<%@page import="com.utte.beans.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<Review> list = ReviewDAO.getReviews();
	out.println(list.size());
	out.println(list.get(0).getR_contents());
	%>
</body>
</html>