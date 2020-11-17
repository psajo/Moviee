<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<style>
		.header a{
			text-decoration: none;
			color : #E91213;
		}
		.header { 
			text-align: center;
			border-bottom: 2px solid #E91213;
		}
		.navbar {
			margin: 0 auto;
			width:1000px;
			display:inline-flex;
			justify-content: space-between;
			align-items: center;
			font-size: 24px;
			color : #E91213;
		}
		.nav_menu{
			display : flex;
			list-style: none;
			padding-left: 0;
		}
		.nav_menu li {
			padding : 8px 12px;
		}
		.searchbox{
			font-size: 20px;
			border-color: #E91213;
			border-radius: 3px;
			width: 400px;
			height: 40px;
			vertical-align: middle;
		}
	</style>
	<title>nav bar</title>
</head>
<body>
<%
	String login_id = session.getAttribute("login_id");
%>
	<div class="header">
		<div class ="navbar">
			<div class="navbar_logo">
				<a href="./index.jsp"><img src="./resources/our_images/mylogo.png" alt="로고"></a>
			</div>
			<div class="search">
				<input type="search" class="searchbox" placeholder="영화를 검색하세요">
				<a href=""><i class="fas fa-search"></i></a>
			</div>
			<ul class="nav_menu">
				<li><a href="">홈</a></li>
				<li><a href="">게시판</a></li>
				<%if (login_id ==null) { %>
				<li><a href="./login.jsp">로그인</a></li>
				<%}else { %>
				<li><a href="./mypage.jsp"><%=login_id%></a>
				<%} %>
			</ul>
		</div>
	</div>
</body>
</html>