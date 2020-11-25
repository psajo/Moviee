<%@page import="java.util.List"%>
<%@page import="com.utte.beans.Movie"%>
<%@page import="com.utte.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 타이틀 및 메타데이터 -->
	<head>
		<meta charset="utf-8">
		<title>영화 어때? 최고의 영화 추천 및 리뷰 사이트</title>
		<link rel="stylesheet" href="./index01.css" />
	</head>

<!-- 상단바 영역   -->
	<body>
		<%@include file="./header.jsp" %>
		
		
<!-- 인덱스 메인 영역    -->
		<div class = "main" >
			<div class ="main_content">
				
					<% List<Movie> list = (List<Movie>)request.getAttribute("movielist"); %>
				    <% Member mb =(Member)session.getAttribute("mvo");
				    System.out.print("test: "+list.size());
			    	for(Movie m : list) {%>
			    		<div class="main_movie">
			    		<%if (mb!=null) { %>
				    		<p><%= mb.getM_nick() %>님이 좋아하는 <%= mb.getM_fav1() %> 영화</p>
				    	<%}else{ %>
				    		<p>추천지수가 높은 영화</p>
				    	<%} %>
							<a herf = "review.jsp?mv_id=<%=m.getMv_id() %>"><img src="<%=m.getMv_posterpath() %>" width="300" height="400"></a>
							<p><%=m.getMv_title() %> </p>
							<p>개봉일 : <%=m.getMv_releasedate() %></p>
							<p>추천지수 : <%=m.getMv_votecount() %></p>
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
						</div>
			    	<%}%>
				
			</div>
			<div class="main_content2">
				<div id="main2-1">
					<p>최근 상영작</p>
					<img src="./resources/ext_images/samplePoster1.png" width="300" height="400">
					<p>노트북</p>
					<p>리뷰 수 : 10000</p>
				</div>
				<div id="main2-2">
				<p> 리뷰 1  <br/>
				<textarea rows="5" cols="70" style="resize:none;">와 정말 최고의 영화 정말 재미있어요 ^^ 추천합니다 </textarea> 
				<p> 리뷰 2 <br/>
				<textarea rows="5" cols="70" style="resize:none;">와 정말 최고의 영화 정말 재미있어요 ^^ 추천합니다 </textarea>
				<p> 리뷰 3 <br/>
				<textarea rows="5" cols="70" style="resize:none;" >와 정말 최고의 영화 정말 재미있어요 ^^ 추천합니다 </textarea>
				</div>
			</div>
		</div>

<!-- 하단 정보 텍스트 영역    -->
	</body>
</html>