$(document).ready(function(){
// 좋아요 버튼 쿼리
$('.like-content').one('click','.like-review', function(e) {
$(this).html('<i class="fa fa-heart" aria-hidden="true"></i> You liked this');
$(this).children('.fa-heart').addClass('animate-like');
/*  5 .like-content 클릭시 
 *  6 .like-content 의 html를 변경 (간단하게 문구만 변경)
 *  7 .like-content class의 자식인 .fa-heart의 class를 animate-like로 변경
 *  .one 제이쿼리 함수는 이벤트를 한번만 받아 수행( 다시 눌러도 상태 돌아오지 않음)
 */
});


//별점 버튼 쿼리
$('.starRating span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  var starValue = '별점 : '+ $(this).attr("value");
	  $('.starRating p').html(starValue);
	  return false;
	});
/*
 * 별점 5개 /반개 설정을 위해 반개씩 총 10개의 별을 html에 구성해놓고
 * 이미지는 회색 /파란색 별이 함께 있는 것으로 백그라운드 설정
 * 백그라운드 설정시 floating 및 위치 설정으로 회색으로 지정
 * 제이쿼리로 클릭했을때 백그라운드 위치를 바꿔 채워진 별로 보이는 class(.on)을 추가해주는 함수 구현
 **/

});