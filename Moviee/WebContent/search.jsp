<%@page import="com.utte.dao.MovieDAO"%>
<%@page import="com.utte.dao.MyConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  String searchWord = "";
	String posterAdd = "";
	ResultSet rs = null;
	PreparedStatement st = null;
	Connection conn = null; 
	String sql = "";
	
    searchWord = request.getParameter("searchWord");
    conn = MyConnection.getConnection();
	sql ="SELECT * FROM movie WHERE mv_title LIKE ?";
	st = conn.prepareStatement(sql);
	st.setString(1,"%"+searchWord+"%");
	rs = st.executeQuery();
	%>
	
<!DOCTYPE html>
<html>
<!-- 타이틀 및 메타데이터 -->
	<head>
		<meta charset="utf-8">
		<title>영화 어때? 최고의 영화 추천 및 리뷰 사이트</title>
		<link rel="stylesheet" href="./resources/css/index.css" />
	</head>
				<%@include file="./header.jsp" %>	
<!-- 상단바 영역   -->
	<body >
<!-- 인덱스 메인 영역    -->
		<div class = "main" >
			<div id ="search_result" >
<% 			if(searchWord=="" | searchWord == null){%>
				<div class = "search_null">
				<font size="200px"><p> </p></font>   <!-- 고릴라 이모티콘 있음 지우지말기!  -->
				검색어를 입력해주세요.
				</div>
		  <%}else if(rs != null){%>
				<div class = "search_list_wrapper">
					<% while(rs.next()){ %>
					<div class = "search_list">
					    <% posterAdd = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"+ rs.getString("mv_posterpath"); %>
					    <div class="poster">
					    	<a href = "MovieDetail?mv_id=<%=rs.getString("mv_id")%>"><img src="<%= posterAdd%>" width="300" height="400" ></a>
					    </div>
						<div class="posterData">
							<% System.out.print(rs.getString("mv_id"));%>
							<p><%= rs.getString("mv_title") %></p>
							<p>개봉일 : <%= rs.getDate("mv_releasedate") %></p>
							<p>추천지수 : <%=rs.getInt("mv_votecount") %></p>
							
							<div class="starRate" >
								<%   double a = MovieDAO.getMovieStar(rs.getString("mv_id"));
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
							<br/><p>별점 : <%= a %></p>
							</div>
							
	                    </div> <!-- posterData -->
	               	</div> <!-- search list -->
	               	 <%} %>
              </div><!-- search list wrapper : 반복으로 생긴 list들을 감싸주는 역할 -->
		 <%}else{%>
			<div class = "search_null">
			<font size="200px"><p>  </p></font>   <!-- 고릴라 이모티콘 있음 지우지말기!  -->
			<font size="6px">	<%= searchWord%> 에 대한 검색결과가 없습니다.</font>
				<p>단어의 철자가 정확한지 확인해 보세요.</p>
				<p>한글을 영어로 혹은 영어를 한글로 입력했는지 확인해 보세요.</p>
				<p>검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해 보세요.</p>
				<p>두 단어 이상의 검색어인 경우, 띄어쓰기를 확인해 보세요.</p>
				<p>검색 옵션을 변경해서 다시 검색해 보세요.</p>
			</div>  <!-- search_null  -->

		 <%}
	     conn.close();
		 st.close();
		 rs.close();%>
		</div><!-- search_result -->
	</div><!-- main 끝  -->
<!-- 하단 정보 텍스트 영역    -->
	</body>
		<%@include file="footer.jsp" %>	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./resources/js/search.js"></script>
	<script src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
</html>