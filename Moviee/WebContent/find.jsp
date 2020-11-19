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
		padding-top: 10px;
	}
	.input_area {
		height: 50px;
		width: 200;
		margin:10px,0;
		padding:5px;
	}
	.inputbox {
		padding : 0 10px 0;
		font-size: 20px;
		line-height: 40px;
		width: 94%;
		border-radius: 4px;
	}
	.btn_repwd{
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
	.titletext {
		font-size: 22px;
	}
	.commontext{
		text-align: left;
		padding: 0 0 0 10px;
		margin: 0;
		font-size: 20px;
	}
	.chk_result {
		margin: 0px 0 15px 0;
		padding: 0 0 0 10px;
		text-align: left;
		color: red;
		font-size: 15px;
	}
</style>
<title>비밀번호 재설정</title>
</head>
<body>
	<section>
		<div id="section">
			<h1 id="section_header">
				<a href="./index.jsp" class="logo_login"><img src="./resources/our_images/mylogo.png" alt ="로고"></a>
			</h1>
			<h1 class="titletext">비밀번호 재설정</h1>
			<form id="frmLogin" name="frmLogin" autocomplete="off" action="" method="POST">
				<p class="commontext">회원가입 시 등록한 이메일 주소(아이디)를 입력해 주세요</p>
				<div class="input_area">
					<input type="text" id="member_email" name="member_email" class="inputbox" maxlength="50" placeholder="이메일을 입력하세요">
				</div>
				<p class="chk_result" id="id_result">이메일 주소를 입력해주세요</p>
				
				<div class="input_area"><input type="submit" value="비밀번호 재설정" class="btn_repwd" id="btn_repwd"></div>
			</form>
		</div>
	</section>
</body>
</html>