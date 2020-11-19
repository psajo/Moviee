<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	#section {
		background-color: aquamarine;
		width:800px;
		text-align: center;
		margin: auto;
		padding-top: 5px;
	}
	.titletext {
		width : 100%;
		font-size: 30px;
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
	.infobox {
		background-color: antiquewhite;
		display: inline-block;
		border :1px solid black;
		border-radius: 5px;
		margin : 20px auto;
		padding : 15px;
		width:300px;
	}
	.info_area{
		font-size: 25px;
		text-align: left;
		height: 40px;
		width: 200;
		margin:3px 0 15px 0;
		padding:3px;
	}
	.mybtn{
		font-size: 20px;
		height: 40px;
		
	}
	
</style>
<title>회원가입</title>
</head>
<body>
	<header>
		<div id="header"></div>
	</header>
	<section>
		<div id="section">
			<h1 class="titletext">
				내정보
			</h1>
			<div class="wrapper">
				<div class="infobox">
					<div class="commontext">아이디</div>
					<div class="info_area">test@test.com</div>
					<div class="commontext">비밀번호</div>
					<div class="info_area"><input type="button" class="mybtn" value="비밀번호 재설정" onclick=""></div>
				</div>
				<div class="infobox">
					<div class="commontext">총 리뷰 수</div>
					<div class="info_area">100</div>
					<div class="info_table">
						<table>
							<tr>
								<th>장르</th><th>내 리뷰 갯수</th>
							</tr>							
							<tr>
								<td>공포</td><td>9</td>
							</tr>
							<tr>
								<td>액션</td><td>7</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div id="footer"></div>
	</footer>
</body>
<script language="javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
	$("#header").load("./header.html");
	$("#footer").load("./footer.html");
</script>
</html>