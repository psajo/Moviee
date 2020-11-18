<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>



<html> 
<head>
<title>Review Input Form :) </title>

<!-- 오류발생시 현재 페이지로 다시 돌아오게 -->
${error} 

<!--review_input"페이지로 입력받은 데이터 전송  -->
<form action="reviewProc.jsp" method="post">
<!-- 리뷰 작성 칸 -->
<h3> Review :) </h3>
<input type="text" name="r_memId" placeholder="id"><br>
<input type="text" name="r_movieId" placeholder="movie_id"><br>
<input type="text" name="r_reviewId" placeholder="review_id"><br>
<input type="text" name="r_star" placeholder="star"><br>
<textarea type="text" name="r_contents" cols="50" row="10" placeholder="리뷰를 작성해주세요!"></textarea>
<input type="submit" value="전송">

</form>
</head>
</html>