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
							<% 	Member mb =(Member)session.getAttribute("mvo");
							   	if(mb != null){
							   		Review myreview= ReviewDAO.getReview(mb.getM_nick(), m.getMv_id());
							   		if(myreview ==null) {%>
						             	<form method="post" action="InsertReview">
							             	<h3>내 리뷰 작성하기</h3>
							             	<input type="hidden" name="m_nick" value="<%=mb.getM_nick()%>">
							             	<input type="hidden" name="mv_id" value="<%=m.getMv_id()%>">
							             	<input type="hidden" name="r_star" value="5">
							             	<input type="hidden" name="uri" id="uri2">
											<textarea name="r_contents" cols="50" rows="5"></textarea>	       	
											<button>등록</button>
					             		</form>
									<%
									}else {
									%>
										<form name="form2" method="post" action="DeleteReview">
											<p> 내가 작성한 리뷰 </p>
											별점: <%= myreview.getR_star() %>&nbsp;&nbsp;&nbsp; 작성일: <%= myreview.getR_date() %> <br/>
											<textarea rows="5" cols="70" style="resize:none;"><%= myreview.getR_contents() %> </textarea>
											<input type="hidden" name ="uri" id="uri3">
											<input type="hidden" name="r_reviewId" value="<%=myreview.getR_reviewId() %>">
											<a href="javascript:document.form2.submit();">삭제</a>
					 					</form>				
									<%
										
									}
							   		
						   		}%>
							<%  int count1 = 0;
								if(r!=null) {
									for(Review r1 : r) {%>
									<p> 작성자 : <%= r1.getM_nick() %> &nbsp;&nbsp;&nbsp;별점: <%= r1.getR_star() %>&nbsp;&nbsp;&nbsp; 작성일: <%= r1.getR_date() %> <br/>
									<textarea rows="5" cols="70" style="resize:none;"><%= r1.getR_contents() %> </textarea> 
									<%
										count1++;
									   if(count1==3){break;}
									}
								}else {
									%><p>리뷰 없음</p><%
								}%>
							</div>
				</div> <!-- wrapper -->
							
			</div> <!-- main -->
</body>
<script>
	window.onload=function() {
		var uri2 =document.getElementById("uri2");
		if(uri2 != null) {
			uri2.value=location.pathname + location.search;
		}
		var uri3 =document.getElementById("uri3");
		if(uri3 != null) {
			uri3.value=location.pathname + location.search;
		}
		//document.getElementById("uri3").value = location.pathname + location.search;
		console.log(location.pathname + location.search);
	};
</script>
	<%@include file="footer.jsp" %>	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/search.js"></script>
	<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>

</html>