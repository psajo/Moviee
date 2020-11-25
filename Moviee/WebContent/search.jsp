<%@page import="com.utte.dao.MyConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	String posterAdd = "";
 	String searchWord = "";
	ResultSet rs = null;
%>
<%  searchWord = "";
    searchWord = request.getParameter("searchWord");
	String sql ="SELECT * FROM movie WHERE mv_title LIKE '%" + searchWord +"%'";
	Connection conn = MyConnection.getConnection(); //db랑 연결해주는 객체
	Statement st = conn.createStatement();
	rs = st.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<!-- 타이틀 및 메타데이터 -->
	<head>
		<meta charset="utf-8">
		<title>영화 어때? 최고의 영화 추천 및 리뷰 사이트</title>
		<link rel="stylesheet" href="./resources/css/index02.css" />
	</head>

<!-- 상단바 영역   -->
	<body class="indexbody">
		<div class="header">
				<div class ="navbar">
						<div class="navbar_logo">
							<a href="IndexServlet"><img src="./resources/our_images/mylogo.png" alt="로고"></a>
						</div>
						<form class="search" method="get">
							<input type="search" class="searchbox" name="searchWord" placeholder="영화를 검색하세요">
							<button  href="search.jsp" action="submit" class="searchbtn" ><span></span></button>
						</form>
						<ul class="nav_menu">
							<li><a href="IndexServlet">홈</a></li>
						</ul>
				</div> <!-- navbar  -->
		</div>  <!-- header  -->

<!-- 인덱스 메인 영역    -->
		<div class = "main" >
			<div id ="search_result" >
<% 			if(searchWord=="" | searchWord == null){%>
				<div class = "search_null">
				<font size="200px"><p> </p></font>   <!-- 고릴라 이모티콘 있음 지우지말기!  -->
				검색어를 입력해주세요.
				</div>
<%			}else if(rs.next()==false){%>
				<div class = "search_null">
				<font size="200px"><p>  </p></font>   <!-- 고릴라 이모티콘 있음 지우지말기!  -->
				<font size="6px">	<%= searchWord%> 에 대한 검색결과가 없습니다.</font>
					<p>단어의 철자가 정확한지 확인해 보세요.</p>
					<p>한글을 영어로 혹은 영어를 한글로 입력했는지 확인해 보세요.</p>
					<p>검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해 보세요.</p>
					<p>두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</p>
					<p>검색 옵션을 변경해서 다시 검색해 보세요.</p>
				</div>  <!-- search_null  -->
	
		  <%}else{%>
				<div class = "search_list_wrapper">
					<% while(rs.next()){ %>
					<div class = "search_list">
					    <% posterAdd = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"+ rs.getString("mv_posterpath"); %>
					    <div class="poster">
					    	<a href="getTest.jsp?mv_id=<%=rs.getString("mv_id")%>"><img src="<%= posterAdd%>" width="300" height="400" ></a>
					    </div>
						<div class="posterData">
							<p><%= rs.getString("mv_title") %></p>
							<p>개봉일 : <%= rs.getDate("mv_releasedate") %></p>
							<p>추천지수 : <%=rs.getInt("mv_votecount") %></p>
						    <div class="starRating">
		 						  <span class="starR1 on" value="0.5"></span>
								  <span class="starR2" value="1"></span>
								  <span class="starR1" value="1.5"></span>
								  <span class="starR2" value="2"></span>
								  <span class="starR1" value="2.5"></span>
								  <span class="starR2" value="3"></span>
								  <span class="starR1" value="3.5"></span>
								  <span class="starR2" value="4"></span>
								  <span class="starR1" value="4.5"></span>
								  <span class="starR2" value="5"></span>
								  <p>별점 주기 클릭</p>
							</div>
							<div class="like-content">
								<button class="btn-secondary like-review">
								<i class="fa fa-heart" aria-hidden="true"></i> ♡ Like
								</button>
		                    </div>
	                    </div> <!-- posterData -->
	               	</div> <!-- search list -->
	               	 <%} %>
              </div><!-- search list wrapper : 반복으로 생긴 list들을 감싸주는 역할 -->
		 <% }%>
		</div><!-- search_result -->
	</div><!-- main 끝  -->
<!-- 하단 정보 텍스트 영역    -->
		<footer>
			<div class="intro">
			<!-- Contact -->
				<p class="title">팀프로젝트 영화어때</p>
				주소 : (07702) 서울특별시 강서구 화곡로 179<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대한상공회의소 서울기술교육센터 403호<br>
				팀명 : 영화어때<br>
				조원 : 박상종 이재선 박지원<br>
				문의 : psajo@naver.com
			</div>
		</footer>
	</body>

	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/search.js"/>
	<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
</html>