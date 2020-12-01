<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>네이버회원 회원가입</title>
</head>
<body>
	<header>
		<div id="header"></div>
	</header>
	<section>
		<div id="section">
			<h1 class="titletext">
				추가정보 입력
			</h1>
			<div class="wrapper">
				<div class="infobox">
					<div class="commontext">ìì´ë</div>
					<div class="info_area">test@test.com</div>
					<div class="commontext">ë¹ë°ë²í¸</div>
					<div class="info_area"><input type="button" class="mybtn" value="ë¹ë°ë²í¸ ì¬ì¤ì " onclick=""></div>
				</div>
				<div class="infobox">
					<div class="commontext">ì´ ë¦¬ë·° ì</div>
					<div class="info_area">100</div>
					<div class="info_table">
						<table>
							<tr>
								<th>ì¥ë¥´</th><th>ë´ ë¦¬ë·° ê°¯ì</th>
							</tr>							
							<tr>
								<td>ê³µí¬</td><td>9</td>
							</tr>
							<tr>
								<td>ì¡ì</td><td>7</td>
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