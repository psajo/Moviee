<%@page import="com.utte.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member mvo = (Member)session.getAttribute("mvo");
%>
	<script src="https://kit.fontawesome.com/7878469e76.js" crossorigin="anonymous"></script>
	<style>
		.header a{
			text-decoration: none;
			color : #E91213;
		}
		.header { 
	    	width: 100%; 
			position: fixed; 
			top: 0;  
			background: white;
			text-align: center;
			border-bottom: 2px solid #E91213;
		}
		.navbar {
			margin: 0 auto;
			display:flex;
			justify-content: space-between;
			align-items: center;
			font-size: 24px;
			color : #E91213;
		}
		.navbar_logo{ margin-left:50px; }
		.nav_menu{
			display : flex;
			list-style: none;
			padding-left: 0;
			margin-right:50px;
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
		.searchbtn{ 
			background: url(./resources/our_images/icon2.png) no-repeat;  
            width:35px; height: 35px;  
            border: 0;  
            vertical-align: middle;
        }
	</style>
	<script>
	window.onload=function() {
		document.getElementById("uri").value = location.pathname + location.search;
		console.log(location.pathname + location.search);
	};
	</script>
	<div class="header">
		<div class ="navbar">
			<div class="navbar_logo">
				<a href="index.jsp"><img src="./resources/our_images/mylogo.png" alt="로고"></a>
			</div>
			<form class="search"  action="search.jsp" method="get">
				<input type="search" class="searchbox" name="searchWord" placeholder="영화를 검색하세요" >
				<button  class="searchbtn" ><span></span></button>
			</form>
			<form action="<%if (mvo==null) {out.print("./login.jsp");}else {out.print("LogoutServlet");} %>" method="post" name="navbarForm">
				<ul class="nav_menu">
					<%if (mvo ==null) { %>
					<li><a onclick="javascript:document.navbarForm.submit()">로그인</a></li>
					<%}else { %>
					<li><a href="mypage.jsp"><%=mvo.getM_nick()%></a>
					<li><a href="javascript:document.navbarForm.submit()">로그아웃</a>
					<%} %>
				</ul>
				<input type="hidden" value="${param.uri }" id="uri" name="uri">
				<input type="hidden" value="${param.page }" id="page" name="page">
			</form>
		</div>
	</div>