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
		padding-top: 5px;
	}
	.input_area {
		height: 45px;
		width: 200;
		margin:8px,0;
		padding:3px;
	}
	.inputbox {
		padding : 0 10px 0;
		font-size: 18px;
		line-height: 35px;
		width: 94%;
		border-radius: 4px;
	}
	.btn_signup{
		font-size: 20px;
		margin:0;
		padding:0;
		width: 100%;
		height: 45px;
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
	.login_check{
		margin : 15px;
		font-size: 20px;
		text-align: left;
	}
	.space_or {
		font-weight: bold;
   		height: 30px;
    	margin: 60px 10px 0;
	}
	.kakao_btn {
		vertical-align: middle;
		font-size: 20px;
		margin:10px 0;
		padding:0;
		width: 98%;
		height: 45px;
		line-height: 50px;
		color : #000000;
		font-weight: bold;
		border-radius: 4px;
		background-color: #FCE51E;
	}
	.naver_btn {
		padding: 50px;
		font-size: 20px;
		margin:10px 0;
		padding:0;
		width: 98%;
		height: 45px;
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
		font-size: 22px;
	}
	.commontext{
		text-align: left;
		padding: 0 0 0 8px;
		margin: 0;
		font-size: 18px;
	}
	.chk_result {
		margin: 0px 0 15px 0;
		padding: 0 0 0 8px;
		text-align: left;
		color: red;
		font-size: 14px;
	}
</style>
<title>회원가입</title>
</head>
<body>
	<section>
		<div id="section">
			<h1 id="section_header">
				<a href="./index.jsp" class="logo_login"><img src="./resources/our_images/mylogo.png" alt ="로고"></a>
			</h1>
			<div class="kakao_btn"><img src="./resources/our_images/kakaologo.png" class="kakaologo">카카오톡으로 회원가입</div>
			<div class="naver_btn"><img src="./resources/our_images/naverlogo.png" class="naverlogo">네이버로 회원가입</div>
			<h1 class="titletext">회원가입</h1>
			<form id="frmLogin" name="frmLogin" autocomplete="off" action="" method="POST" onsubmit="return false">
				<p class="commontext">아이디</p>
				<div class="input_area">
					<input type="text" id="user_id" name="user_id" class="inputbox" maxlength="50" placeholder="이메일을 입력하세요"><input type="button" onclick=emailChk();>
				</div>
				<p class="chk_result" id="id_result">이메일 주소를 입력해주세요</p>
				<p class="commontext">비밀번호</p>
				<div class="input_area">
					<input type="password" id="user_pwd" name="user_pwd" class="inputbox" maxlength="50" placeholder="비밀번호를 입력하세요">
				</div>
				<p class="chk_result" id ="pwd_result">비밀번호를 입력해주세요</p>
				<p class="commontext">비밀번호 확인</p>
				<div class="input_area">
					<input type="password" id="user_repwd" name="user_repwd" class="inputbox" maxlength="50" placeholder="비밀번호를 입력하세요">
				</div>
				<p class="chk_result" id="repwd_result">비밀번호를 입력해주세요</p>
				<p class="commontext">닉네임</p>
				<div class="input_area">
					<input type="text" id="user_nick" name="user_nick" class="inputbox" maxlength="50" placeholder="닉네임을 입력하세요">
				</div>
				<p class="chk_result" id="nick_result">닉네임을 입력하세요</p>
				<p class="commontext">선호 장르</p>
				<div class="input_area">
					<table>
						<tr>
							<td><input type="checkbox" name="user_fav" value="fav1">fav1 </td>
							<td><input type="checkbox" name="user_fav" value="fav2">fav2 </td>
							<td><input type="checkbox" name="user_fav" value="fav3">fav3 </td>
							<td><input type="checkbox" name="user_fav" value="fav4">fav4 </td>
							<td><input type="checkbox" name="user_fav" value="fav5">fav5 </td>
						</tr>
						<tr>
							<td><input type="checkbox" name="user_fav" value="fav1">fav1 </td>
							<td><input type="checkbox" name="user_fav" value="fav2">fav2 </td>
							<td><input type="checkbox" name="user_fav" value="fav3">fav3 </td>
							<td><input type="checkbox" name="user_fav" value="fav4">fav4 </td>
							<td><input type="checkbox" name="user_fav" value="fav5">fav5 </td>
						</tr>
					</table>
				</div>
				<div class="input_area"><input type="submit" value="회원가입" class="btn_signup" id="btn_signup" onsubmit="formCheck();"></div>
			</form>
		</div>
	</section>
</body>
<script src="./resources/js/jquery-3.5.1.js"></script>
<script>
	var emailChk=false;
	var pwdChk=false;
	var rePwdChk=false;
	var nickChk=false;
	var favChk=false;
	var user_id = $("#user_id");
	var id_result = $("#id_result");
	var user_pwd = $("#user_pwd");
	var pwd_result = $("#pwd_result");
	var repwd_result= $("#repwd_result");
	var user_repwd = $("#user_repwd");
	var user_nick = $("#user_nick");
	var nick_result=$("#nick_result");
	var user_fav = $("input[name=user_fav]");
	function formCheck() {
		checkEmail();
		checkPwd();
		checkRePwd();
		if(emailChk && pwdChk && rePwdChk&&nickChk&&favChk) {
			return true;
		}else {
			return false;
		}
		console.log("f : "+user_fav.length);
	}
	function checkEmail() {
		emailChk = false;
		var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		if(user_id.val()=="") {
			id_result.text("이메일(아이디)를 입력해주세요!");
		}else if(reg_email.test(user_id.val())) {
			var str = "EmailDupChkServlet";
			console.log("ajax..");
			emailChk=false;
			$.ajax({
				url:str,
				type:"POST",
				data : {"m_email":user_id.val()},
				dataType: "text",
				success: function(data) {
					if(data) {
						console.log(data);
						if(data=="ok"){
							emailChk=true;
						}
					}else {
						console.log("값 없음");
					}
				},
				error: function() {
					console.log("er");
				}
			});
	    }
	}
	function checkPwd() {
		pwdChk = false;
		if(user_pwd.val()=="") {
			pwd_result.text("비밀번호를 입력하세요!");
		}else if(user_pwd.val().length<4 || user_pwd.val().length>11) {
			pwd_result.text("비밀번호는 4~10자리로 설정해주세요.");
		}else {
			pwdChk = true;
		}
	}
	function checkRePwd() {
		rePwdChk=false;
		if(user_repwd.val()=="") {
			repwd_result.text("비밀번호를 입력하세요!");
		}else if (user_repwd.val()!= user_pwd.val()) {
			repwd_result.text("비밀번호와 일치하지 않습니다!");
		}else {
			rePwdChk=true;
		}
	}
	function checkFav() {
		console.log("취미0번재 : " +user_fav[0]);
	}
	
	function checkNick() {
		var nick_length = user_nick.val().length;
		if(user_nick.val()=="") {
			nick_result.text("닉네임을 입력하세요!");
		}else if (user_nick.val().length <2) {
			nick_result.text("닉네임은 2~10글자로 해주세요!");
		}else {
			console.log("ajax..");
			nickChk = false;
			$.ajax({
				url:"NickDupChkServlet",
				type:"POST",
				data : {"m_nick":user_nick.val()},
				dataType: "text",
				success: function(data) {
					if(data) {
						console.log(data);
						if(data=="ok"){
							nickChk = true;
						}
					}else {
						console.log("값 없음");
					}
				},
				error: function() {
					console.log("er");
				}
			});
		}
    }
	
	$(document).ready(function(){
		user_id.on("change keyup paste" ,checkEmail);
		user_nick.on("change keyup paste" ,checkNick);
	});
</script>
</html>