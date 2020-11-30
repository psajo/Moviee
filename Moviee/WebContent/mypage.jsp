<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>영화어때</title>
<link href="./resources/css/mypage.css" rel="stylesheet" />
</head>
<body>
	<%@include file="./header.jsp"%>
    <div class="wrap">        
        <div id="container" class="mypage">
            <div class="inner">
                <div class="mypage__profile">
                    <div class="profile__box">
                        <div id="profile__image" class="profile__image">
                        <%System.out.println("testing : " +mvo.getM_profile()); %>
                            <img src="./resources/upload/<%=mvo.getM_nick()+"/"+mvo.getM_profile() %>" alt="프로필 이미지" />
                        </div>
                        <p class="profile__text">
                            안녕하세요 영화광 <span class="profile__name"><%=mvo.getM_nick() %></span>님!<br>오늘 영화 한편 어떠세요?
                        </p>
                    </div>
                    <div class="wrapper">
                    	<form action="UploadProfile" method="post" enctype="multipart/form-data">
		                    <div class="profile__button">
		                        <input type="file" id="profile_edit" name="profile" onchange="previewImage(this)"/>
		                        <label for="profile_edit">이미지 찾기</label>
		                    </div>
		                    <div class="profile__button">
		                        <input type="submit" id="profile_save"/>
		                        <label for="profile_save">이미지 변경</label>
		                    </div>
	                    </form>
                    </div>
                </div>
                <ul class="mypage__list">
                    <li class="mypage__item item01">
                        <div class="item__title">
                            <h4>아이디</h4>
                        </div>
                        <div class="item__cont">
                            <p><%=mvo.getM_email() %></p>
                        </div>
                    </li>
                    <li class="mypage__item item02">
                    <form name="myPageForm" action="MypageServlet" method="post">
                        <div class="item__title">
                            <h4>비밀번호 변경</h4>
                            <button onclick="checkPassword()">변경하기</button>
                        </div>
                        <div class="item__cont">
                            <div class="input__box">
                                <input type="password" placeholder="현재 비밀번호" name="currPwd" id="currPwd"/>
                            </div>
                            <div class="input__box">
                                <input type="password" placeholder="새 비밀번호" name="newPwd" id="newPwd"/>
                            </div>
                            <div class="input__box">
                                <input type="password" placeholder="새 비밀번호 확인" name="checkPwd" id="checkPwd"/>
                            </div>
                            
                        </div>
                       </form>
                    </li>
                    <li class="mypage__item item03">
                        <div class="item__title">
                            <h4>총 리뷰수</h4>
                            <p class="title__bottom">100</p>
                        </div>
                        <div class="item__cont">
                            <ul class="review__list">
                                <li class="review__item">
                                    <span class="review__genre">장르</span>
                                    <span class="review__count">내 리뷰 개수</span>
                                </li>
                                <li class="review__item">
                                    <span class="review__genre">공포</span>
                                    <span class="review__count">9</span>
                                </li>
                                <li class="review__item">
                                    <span class="review__genre">액션</span>
                                    <span class="review__count">9</span>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="mypage__item item04">
                        <div class="item__title">
                            <h4>내가 추천한 영화 목록</h4>
                        </div>
                        <div class="item__cont">
                        </div>
                    </li>
                </ul>
            </div>
            
        </div>
    </div>
    
    
    <!-- 하단 정보 텍스트 영역    -->
	<%@include file="./footer.jsp" %>
</body>
<script>
	function previewImage(f){
	
		var file = f.files;
	
		// 확장자 체크
		if(!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)){
			alert('gif, jpg, png 파일만 선택해 주세요.\n\n현재 파일 : ' + file[0].name);
	
			// 선택한 파일 초기화
			f.outerHTML = f.outerHTML;
	
			document.getElementById('profile__image').innerHTML = '<img src="./resources/our_images/profile_image.png" alt="프로필 이미지" />';
	
		}
		else {
	
			// FileReader 객체 사용
			var reader = new FileReader();
	
			// 파일 읽기가 완료되었을때 실행
			reader.onload = function(rst){
				document.getElementById('profile__image').innerHTML = '<img src="' + rst.target.result + '">';
			}
	
			// 파일을 읽는다
			reader.readAsDataURL(file[0]);
	
		}
	}
	
</script>
<!-- <script>
	var myPageForm = document.myPageForm;
	var currPwd = myPageForm.currPwd.value;
	var newPwd = myPageForm.newPwd.value;
	var checkPwd = myPageForm.checkPwd.value;
	/* 	var currPwd = $('#currPwd').val();
	var newPwd = $('#newPwd').val();
	var checkPwd = $('#checkPwd').val(); */
	
	console.log("currPwd",currPwd)
	console.log("newPwd",newPwd)
	console.log("checkPwd",checkPwd)
	
	function checkPassword() {
		alert("currPwd : "+currPwd)
		alert("newPwd : "+newPwd)
		alert("checkPwd : "+checkPwd)
	}
</script> -->
</html>