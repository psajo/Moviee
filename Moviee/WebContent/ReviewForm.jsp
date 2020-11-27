<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>



<html> 
<head>
<title>Review Input Form :) </title>
</head>
<body>
<!--review_input"페이지로 입력받은 데이터 전송  -->
<form name="review_inputForm" action="InsertReview" method="post"
			onsubmit="return checkValue">
<!-- 리뷰 작성 칸 --> 
<h3> Review :) </h3>
<input type="text" name="M_NICK" placeholder="M_NICK" value="테스터1"><br>
<input type="text" name="MV_ID" placeholder="MV_ID" value="10"><br>
<input type="text" name="R_CONTENTS" placeholder="R_CONTENTS"><br>
<input type="text" name="R_STAR" placeholder="R_STAR"><br>
<input type="hidden" id="uri" name="uri" value="">
<input type="submit" value="등록">
</form>
<script src="./resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	var uri =$(location).attr('pathname');
	var search = $(location).attr('search');
	$("#uri").val(uri+search);
	console.log(uri+", "+ search);
</script>

<!-- 리뷰 목록 칸 -->
<div id ="review_listForm">
	<form method="post" name="listform">
		<input type="hidden" name="pro">
		<div id="review_comment">
			<hr size="1" width="700">
			<label>M_NICK</label>
			<label>r_date</label>
			<label>R_STAR</label>
			<a href="#">[수정]</a>&nbsp;
			<a href="#">[삭제]</a>&nbsp;
			R_CONTENTS <br>
			<hr size="1" width="700">
		</div>	
	</form>
	</div>
</body>

</html>