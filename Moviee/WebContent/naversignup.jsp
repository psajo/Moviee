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
	.btn_submit{
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
	#fav_result{
		color : red;
	}
</style>
<title>네이버회원 추가정보 입력</title>
</head>
<body>
	<section>
		<div id="section">
			<h1 id="section_header">
				<a href="./index.jsp" class="logo_login"><img src="./resources/our_images/mylogo.png" alt ="로고"></a>
			</h1>
			<h1 class="titletext">추가 정보 입력</h1>
			<form id="frmLogin" name="frmLogin" autocomplete="off" action="NaverSignupServlet" method="POST">
				<input type="text" name="nid" value="${nid }">
				<p class="commontext">사용할 닉네임을 입력하세요</p>
				<div class="input_area">
					<input type="text" id="m_nick" name="m_nick" class="inputbox" maxlength="50" placeholder="닉네임을 입력하세요">
				</div>
				<p class="chk_result" id="nick_result">닉네임을 입력하세요</p>
				<p class="commontext">선호 장르<span id="fav_result">(3개를 선택하세요)</span></p>
				<div class="input_area">
					<table>
						<tr>
							<td><input type="checkbox" name="m_fav" value="fav1">fav1 </td>
							<td><input type="checkbox" name="m_fav" value="fav2">fav2 </td>
							<td><input type="checkbox" name="m_fav" value="fav3">fav3 </td>
							<td><input type="checkbox" name="m_fav" value="fav4">fav4 </td>
							<td><input type="checkbox" name="m_fav" value="fav5">fav5 </td>
						</tr>
						<tr>
							<td><input type="checkbox" name="m_fav" value="fav6">fav6 </td>
							<td><input type="checkbox" name="m_fav" value="fav7">fav7 </td>
							<td><input type="checkbox" name="m_fav" value="fav8">fav8 </td>
							<td><input type="checkbox" name="m_fav" value="fav9">fav9 </td>
							<td><input type="checkbox" name="m_fav" value="fav10">fav10 </td>
						</tr>
					</table>
				</div>
				<div class="input_area"><input type="submit" value="회원가입 하기" class="btn_submit" id="btn_submit"></div>
			</form>
		</div>
	</section>
</body>
<script src="./resources/js/jquery-3.5.1.js"></script>
<script>
console.log($("#access_token").val());
var nickChk = false;
var favChk=false;
var m_fav = $("input[name=m_fav]");
var fav_result = $("#fav_result");
var m_nick = $("#m_nick");
var nick_result= $("#nick_result");

function checkFav() {
	console.log("checkFav()!")
	favChk=false;
	fav_result.css("color","red")
	var i=0
	var count=0;
	console.log(m_fav.length);
	for(i=0; i<m_fav.length;i++){
		if(m_fav[i].checked) {
			count++;
		}
	}
	if(count>=3){
		fav_result.css("color","blue");
		favChk = true;
		if(count>=4) {
			this.checked =false;	
			count--;
		}
		
	}
	console.log("취미 갯수 : "+count);
}

function checkNick() {
	nickChk = false;
	nick_result.css("color","red");
	var nick_length = m_nick.val().length;
	if(m_nick.val()=="") {
		nick_result.text("닉네임을 입력하세요!");
	}else if ( (m_nick.val().length <2 || m_nick.val().length>10)) {//수정중
		nick_result.text("닉네임은 2~10글자로 해주세요!");
	}else {
		nick_result.text("닉네임 체크중...");
		$.ajax({
			url:"NickDupChkServlet",
			type:"POST",
			data : {"m_nick":m_nick.val()},
			dataType: "text",
			success: function(data) {
				if(data) {
					console.log(data);
					if(data=="ok"){
						nickChk = true;
						nick_result.css("color","blue");
						nick_result.text("닉네임 사용가능");
					}else {
						nick_result.text("중복된 닉네임 입니다.");
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
	m_nick.on("change keyup paste" ,checkNick);
	m_fav.on("change keyup paste" ,checkFav);
});
</script>
</html>