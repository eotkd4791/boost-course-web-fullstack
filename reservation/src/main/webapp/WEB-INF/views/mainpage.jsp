<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="#" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="#" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
               	 <c:if test="${not empty reservationEmail}">
                  	<a href="./myreservation" class="btn_my">
                		<span class="viewReservation" title="예약확인">
                			${reservationEmail}
                  		</span> 
                 	</a>
                 </c:if>
                 <c:if test="${empty reservationEmail}">
                 	<a href="./bookinglogin" class="btn_my">
                		<span class="viewReservation" title="예약확인">
                  	 		예약확인
                  		</span> 
                 	</a>
                 </c:if>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e" style="display:none;">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e" style="display:none;">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- 슬라이딩기능: 이미지 (type = 'th')를 순차적으로 노출 -->
                                <ul class="visual_img"></ul>
                            </div>
                            <span class="nxt_fix" style="display:none;"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section_event_tab">
                <ul class="event_tab_lst tab_lst_min"></ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt"></p>
                <div class="wrap_event_box">
                    <ul class="lst_event_box"></ul>
                    <ul class="lst_event_box"></ul>
                    <div class="more">
                        <button class="btn"><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>


    <script type="rv-template" id="promotionItem">
  	 <li class="item" style="background-image: url({productImageUrl});" id="{id}">
		<a href="#">
			<span class="img_btm_border"></span>
			<span class="img_right_border"></span> 
			<span class="img_bg_gra"></span>
		    <div class="event_txt">
				<h4 class="event_txt_tit">{title}</h4>
		    	<p class="event_txt_adr">{placeName}</p>
		    	<p class="event_txt_dsc">{description}</p>
		    </div>
		</a>
    </li>
    </script>

    <script type="rv-template" id="itemList">
        <li class="item">
            <a href="detail.html?id={id}" class="item_book">
                <div class="item_preview">
                    <img alt="{productDescription}" class="img_thumb" src="{productImageUrl}">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> 
						<span>${productDescription}</span>
						<small class="sm">{placeName}</small>
					</h4>
                    <p class="event_txt_dsc">{productContent}</p>
                </div>
            </a>
        </li>
    </script>
   
   	<script src="js/common.js"></script>
    <script src="js/mainpage.js"></script>
</body>

</html>