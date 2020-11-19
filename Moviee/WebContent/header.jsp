<%@page import="com.utte.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	Member mvo = (Member)session.getAttribute("mvo");
%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="./resources/css/header.css" />
	<script>
	window.onload=function() {
		document.getElementById("uri").value = location.pathname + location.search;
		console.log(location.pathname + location.search);
	};
	</script>
	<div class="header">
		<div class ="navbar">
			<div class="navbar_logo">
				<a href="./index.jsp"><img src="./resources/our_images/mylogo.png" alt="로고"></a>
			</div>
			<div class="search">
				<input type="search" class="searchbox" placeholder="영화를 검색하세요">
				<a href=""><i class="fas fa-search"></i></a>
			</div>
			<form action="<%if (mvo==null) {out.print("./login.jsp");}else {out.print("LogoutServlet");} %>" method="post" name="navbarForm">
				<ul class="nav_menu">
					<li><a href="">홈</a></li>
					<li><a href="">게시판</a></li>
					<%if (mvo ==null) { %>
					<li><a href="javascript:document.navbarForm.submit()">로그인</a></li>
					<%}else { %>
					<li><a href="./mypage.jsp"><%=mvo.getM_nick()%></a>
					<li><a href="javascript:document.navbarForm.submit()">로그아웃</a>
					<%} %>
				</ul>
				<input type="hidden" value="${param.uri }" id="uri" name="uri">
				<input type="hidden" value="${param.page }" id="page" name="page">
			</form>
		</div>
	</div>