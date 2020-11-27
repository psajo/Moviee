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
	<%@include file="./header.jsp" %>
    <div class="wrap">        
        <div id="container" class="mypage">
            <div class="inner">
                <div class="mypage__profile">
                    <div class="profile__box">
                        <div class="profile__image">
                            <img src="./resources/our_images/profile_image.png" alt="프로필 이미지" />
                        </div>
                        <p class="profile__text">
                            안녕하세요 영화광 <span class="profile__name"><%=mvo.getM_nick() %></span>님!<br>오늘 영화 한편 어떠세요?
                        </p>
                    </div>
                    
                    <div class="profile__button">
                        <input type="file" id="profile_edit"/>
                        <label for="profile_edit">프로필 사진 변경</label>
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
                        <div class="item__title">
                            <h4>비밀번호 변경</h4>
                            <button>변경하기</button>
                        </div>
                        <div class="item__cont">
                            <div class="input__box">
                                <input type="password" placeholder="현재 비밀번호"/>
                            </div>
                            <div class="input__box">
                                <input type="password" placeholder="새 비밀번호" />
                            </div>
                            <div class="input__box">
                                <input type="password" placeholder="새 비밀번호 확인" />
                            </div>
                            
                        </div>
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
</html>