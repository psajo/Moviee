<%@page import="com.utte.dao.ReviewDAO"%>
<%@page import="com.utte.dao.MovieDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.utte.beans.Review"%>
<%@page import="com.utte.beans.Movie"%>
<%@page import="com.utte.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<!-- 타이틀 및 메타데이터 -->
	<head>
		<meta charset="utf-8">
		<title>영화 어때? 최고의 영화 추천 및 리뷰 사이트</title>
		<link rel="stylesheet" href="./resources/css/index.css"/>
	</head>

<!-- 상단바 영역   -->
	<body>
				<%@include file="./header.jsp" %>	
<!-- 인덱스 메인 영역    -->
		<div class = "main" >
			<div class ="main_content">
					<%if(request.getAttribute("movielist")==null){%><jsp:forward page="IndexServlet"/><%}%>
					<% List<Movie> list = (List<Movie>)request.getAttribute("movielist"); %>
				    <% Member mb =(Member)session.getAttribute("mvo");
					   int c = 0;
			    	for(Movie m : list) {%>
			    	
			    		<div class="main_movie">
			    		<%if (mb!=null) { 
			    			if(c==0){ 
			    				c++; %>
			    				<p><%= mb.getM_nick() %>님이 좋아하는 <%= mb.getM_fav1() %> 영화</p>				    			
							<%}else if(c==1){
								c++; %>
								<p><%= mb.getM_nick() %>님이 좋아하는 <%= mb.getM_fav2() %> 영화</p>
							<%}else{ 
								c++;%>
								<p><%= mb.getM_nick() %>님이 좋아하는 <%= mb.getM_fav3() %> 영화</p>								
							<%}	
				    	  }else{  %>
				    		<p>추천지수가 높은 영화</p>
				    	<%} %>
							<a href = "getTest.jsp?mv_id=<%=m.getMv_id()%>"><img src="<%=m.getMv_posterpath() %>" width="290" height="387"></a>
							<p><%=m.getMv_title() %> </p>
							<p>개봉일 : <%=m.getMv_releasedate() %></p>
							<p>추천지수 : <%=m.getMv_votecount() %></p>
							<div class="starRate" >
								<%   double a = MovieDAO.getMovieStar(m.getMv_id());
									 int b = (int)a*2;
									 
									 for(int i = 1; i<11; i++){
										if(i%2!=0 && i<=b){%>
			 						 		 <span class="starR1 on" ></span>
			 						    <%}else if(i%2==0 && i<=b){%>
									         <span class="starR2 on" ></span>
									    <%}else if(i%2!=0 && i>=b){%>
									  		<span class="starR1" ></span>
									  	<%}else {%>
									  		<span class="starR2" ></span>
									    <%}
									    }%>
							<p>별점 : <%= a %></p>
							</div>
						</div>
			    	<%}%>
			</div>
			
			
			<div class="main_content2">
				<div id="main2-1">
					<p>추천 지수가 가장 높은 영화</p>
							<% Movie m2 = (Movie)request.getAttribute("m2"); %>
							<% List<Review> r = (List<Review>)request.getAttribute("r"); %>
					<img src="<%=m2.getMv_posterpath() %>" width="300" height="400">
					<p><%= m2.getMv_title() %></p>
					<p>추천수 : <%= m2.getMv_votecount() %> &nbsp;&nbsp; 리뷰 수 : <%=MovieDAO.getReviewCount(m2.getMv_id()) %> </p>
					<div class="starRate" >
								<%   double a = MovieDAO.getMovieStar(m2.getMv_id());
									 int b = (int)a*2;
									 
									 for(int i = 1; i<11; i++){
										if(i%2!=0 && i<=b){%>
			 						 		 <span class="starR1 on" ></span>
			 						    <%}else if(i%2==0 && i<=b){%>
									         <span class="starR2 on" ></span>
									    <%}else if(i%2!=0 && i>=b){%>
									  		<span class="starR1" ></span>
									  	<%}else {%>
									  		<span class="starR2" ></span>
									    <%}
									    }%>
							<p>별점 : <%= a %></p>
					</div>
				</div>
				<div id="main2-2">
				<%  int count1 = 0;
				for(Review r1 : r) {%>
				<p> 작성자 : <%= r1.getM_nick() %> &nbsp;&nbsp;&nbsp;별점: <%= r1.getR_star() %>&nbsp;&nbsp;&nbsp; 작성일: <%= r1.getR_date() %> <br/>
				<textarea rows="5" cols="70" style="resize:none;"><%= r1.getR_contents() %> </textarea> 
				
				<%
					count1++;
				   if(count1==3){break;}
				} %>
				</div>
			</div> <!-- main_content2 -->
			
			
		</div><!-- main(content) 끝!! -->
		

<!-- 하단 정보 텍스트 영역    -->
	</body>
	<%@include file="./footer.jsp" %>	
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/search.js"/>
	<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
</html>