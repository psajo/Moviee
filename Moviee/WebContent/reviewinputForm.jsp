<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html> 
<head>
<title>Review Input Form :) </title>

<!-- 오류발생시 현재 페이지로 다시 돌아오게 -->
${error} 

<!--review_input"페이지로 입력받은 데이터 전송  -->
<form action="reviewProc.jsp" method="post">
<!-- 리뷰 작성 칸 -->
<h3> Review :) </h3>
<textarea type="text" name="review_contents" cols="50" row="5"></textarea>
<input type="submit" value="전송">

</form>
</head>
</html>