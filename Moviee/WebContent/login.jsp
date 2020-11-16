<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	#section {
		width:400px;
		text-align: center;
		margin: auto;
		padding-top: 50px;
	}
	.input_area {
		height: 40px;
		width: 200;
		margin:20px,0;
		padding:8px;
	}
	.inputbox {
		padding : 0 10px 0;
		font-size: 20px;
		line-height: 40px;
		width: 94%;
		border-radius: 4px;
	}
	.btn_login{
		font-size: 20px;
		margin:0;
		padding:0;
		width: 100%;
		height: 50px;
		background-color: #E91213;
		color : #FFFFFF;
		font-weight: bold;
		border-radius: 4px;
		border-color: #E91213;
	}
	#lgch {
		width: 15px;
		height: 15px;
	}
	.auto_login{
		text-align: left;
		margin : 15px;
		font-size: 18px;
	}
	.space_or {
		font-weight: bold;
   		height: 30px;
    	margin: 60px 10px 0;
	}
	.kakao_btn {
		vertical-align: middle;
		font-size: 20px;
		margin:20px 0;
		padding:0;
		width: 98%;
		height: 50px;
		line-height: 50px;
		color : #000000;
		font-weight: bold;
		border-radius: 4px;
		background-color: #FCE51E;
	}
	.naver_btn {
		padding: 50px;
		font-size: 20px;
		margin:20px 0;
		padding:0;
		width: 98%;
		height: 50px;
		line-height: 50px;
		color : #FFFFFF;
		font-weight: bold;
		border-radius: 4px;
		background-color: #28D111;
	}
	.kakaologo {
		height: 30px;
		vertical-align: middle;
		margin : 0 2px 3px 0;
		
	}
	.naverlogo {
		height:23px;
		vertical-align: middle;
		margin :0 3px 5px 0;
	}
	.titletext {
		font-size: 36px;
	}
	.member_manage{
		
	}
	.signup {
		padding: 0 15px 0;
		float: right;
	}
	.find_password{
		padding: 0 15px 0;
		float : left;
	}
	#section a{
		color : #3181FF;
		text-decoration: none;
	}
</style>
<title>로그인</title>
</head>
<body>
	<section>
		<div id="section">
			<h1 id="section_header">
				<a href="./index.jsp" class="logo_login"><img src="./resources/our_images/mylogo.png" alt ="로고"></a>
			</h1>
			<h1 class="titletext">로그인</h1>
			<form id="frmLogin" name="frmLogin" autocomplete="off" action="LoginServlet" method="POST">
				<div class="input_area">
					<input type="text" id="m_email" name="m_email" class="inputbox" maxlength="50" placeholder="이메일">
				</div>
				<div class="input_area">
					<input type="password" id="m_pwd" name="m_pwd" class="inputbox" maxlength="50" placeholder="비밀번호">
				</div>
				<div class="input_area"><input type="submit" title="로그인" alt="로그인" value="로그인" class="btn_login" id="btn_login"></div>
				<div class="auto_login"><input type="checkbox" value="ok" id="lgch" name="lgch">로그인 상태 유지</div>
				<div class="member_manage">
					<div class="find_password"><a href="./find.html">비밀번호를 잊으셨나요?</a></div>
					<div class="signup"><a href="./singup.html">회원가입</a></div>
				</div>
			</form>
			<p class="space_or"><span>다른 로그인</span></p>
			<div class="kakao_btn"><a href=""><img src="./resources/our_images/kakaologo.png" class="kakaologo">카카오톡으로 로그인</a></div>
			<div class="naver_btn"><a href=""><img src="./resources/our_images/naverlogo.png" class="naverlogo">네이버로 로그인</a></div>
		</div>
	</section>
</body>
</html>