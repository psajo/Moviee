<%@page import="com.utte.dao.ReviewDAO"%>
<%@page import="com.utte.dao.MovieDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.utte.beans.Review"%>
<%@page import="com.utte.beans.Movie"%>
<%@page import="com.utte.beans.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html >
<html>
<head>
		<meta charset="utf-8">
		<title>영화 어때? 최고의 영화 추천 및 리뷰 사이트</title>
		<link rel="stylesheet" href="./resources/css/index.css"/>
</head>
		<%@include file="./header.jsp" %>	
<body>
			<div class = "main" >
				<div class="search_list_wrapper">
							<div id="movie_detail">
								<% Movie m = (Movie)request.getAttribute("m"); %>
								<% List<Review> r = (List<Review>)request.getAttribute("r"); %>
								<div class="poster">
								<img src="<%=m.getMv_posterpath() %>" width="300" height="400">
								</div>
								<div class="posterData">
									<p><%= m.getMv_title() %></p>
									<p>배우 : <%= m.getMv_casting() %></p>
									<p>감독 : <%= m.getMv_crew() %></p>
									<p>추천수 : <%= m.getMv_votecount() %></p>
									<p>리뷰 수 : <%=MovieDAO.getReviewCount(m.getMv_id()) %> </p>
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
								</div> <!-- posterdata -->
							</div>  <!-- movie_detail -->
							<div id="overview"> 줄거리 :  <%=m.getMv_overview() %>
							</div>
							<div class="movie_review">
							<% Member mb =(Member)session.getAttribute("mvo");
							   if(mb != null){%>
				             	<form method="post" action="">
					             	<h3>Review</h3>
									<button>수정</button>
									<button>삭제</button>
									<button>등록</button> <br/>
									<textarea name=review_content cols="50" rows="5"></textarea>	       	
			             		</form>
							  <% }%>
							<%  int count1 = 0;
							for(Review r1 : r) {%>
							<p> 작성자 : <%= r1.getM_nick() %> &nbsp;&nbsp;&nbsp;별점: <%= r1.getR_star() %>&nbsp;&nbsp;&nbsp; 작성일: <%= r1.getR_date() %> <br/>
							<textarea rows="5" cols="70" style="resize:none;"><%= r1.getR_contents() %> </textarea> 
							<%
								count1++;
							   if(count1==3){break;}
							} %>
							</div>
				</div> <!-- wrapper -->
							
			</div> <!-- main -->
</body>
	<%@include file="footer.jsp" %>	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/search.js"/>
	<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>

</html>