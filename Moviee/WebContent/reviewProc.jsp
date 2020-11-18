<%@page import="com.utte.controller.ReviewService" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8"); 
%>

<!--review객체 생성 후 주솟값 저장  -->
<jsp:useBean id="review" class="com.utte.beans.Review" /> 
<!--review가 참조하는 객체 모든 setter 메소드 호출. 인자값으로 r_contents와 동일한 name추출해서 전달 -->
<jsp:setProperty property="*" name="r_contents" />

<!-- review서비스 처리 객체. reviewInsert메소드 처리 -->
<%
	ReviewService service = new ReviewService();
	service.reviewInsert(review);

	RequestDispatcher rd = request.getRequestDispatcher("reviewOutputForm.jsp");
	rd.forward(request, response);
%>

<!-- service.reviewInsert 메소드 실행이 완료된 후 실행되는 부분. 
	처리결과 페이지로 이동하기 위해 RequestDispatcher 객체 생성 후 forward 메소드로 이동 -->	
	