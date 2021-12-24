<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="css/style.css" rel="stylesheet">
    <style>
        .container_visual {
            height: 414px;
        }
    </style>
</head>

<body>
    <div id="container">
        <div class="header fade">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="/reservation/main" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="/reservation/main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="#" class="btn_my"> 
                	<span title="예약확인">예약확인</span> 
               	</a>
            </header>
        </div>
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <header>
                        <h1 class="logo">
                            <a href="/reservation/main" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                            <a href="/reservation/main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                        </h1>
                        <a href="./myreservation.html" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
                    </header>
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num">1</span>
                            <span class="num off">/ 
                            	<span>2</span>
                           </span>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img detail_swipe"></ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a href="#" class="btn_prev" title="이전">
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a href="#" class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_btn_goto"  style="display: none;">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div class="section_store_details">
                    <div class="store_details close3">
                        <p class="dsc"></p>
                    </div>
                    <a href="#" class="bk_more _open"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                </div>
                <div class="section_event">
                    <div class="event_info_box">
                        <div class="event_info_tit">
                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
                        </div>
                        <div class="event_info">
                            <div class="in_dsc">[네이버예약 특별할인]<br>R석 50%, S석 60% 할인</div>
                        </div>
                    </div>
                </div>
                <div class="section_btn"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <span class="graph_mask"> <em class="graph_value"></em> </span>
                                <strong class="text_value"> <span></span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green"></em> 등록</span>
                            </div>
                            <ul class="list_short_review"></ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="/reservation/review"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
                <div class="section_info_tab">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                        <li class="item active _detail">
                            <a href="javascript:void(0);" class="anchor active"> <span>상세정보</span> </a>
                        </li>
                        <li class="item _path">
                            <a class="anchor"> <span>오시는길</span> </a>
                        </li>
                    </ul>
                    <div class="detail_area_wrap"></div>
                    <div class="detail_location hide"></div>
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
    <div id="photoviwer"></div>
    
    <script src="js/common.js"></script>
    <script src="js/detail.js"></script>
    
    <script type="rv-template" id="imageList">
    <li class="item" style="width: 414px;"> 
		<img alt="" class="img_thumb" src="{saveFileName}"> 
		<span class="img_bg"></span>
	    <div class="visual_txt">
	        <div class="visual_txt_inn">
	            <h2 class="visual_txt_tit"> 
	            	<span></span> 
	           	</h2>
	            <p class="visual_txt_dsc"></p>
	        </div>
	    </div>
	</li>
    </script>
    
    <script type="rv-template" id ="hideDetail">
	<div class="store_details close3">
		<p class="dsc">{productContent}</p>
  	</div>
    <a href="#" class="bk_more _open"> 
		<span class="bk_more_txt">펼쳐보기</span> 
		<i class="fn fn-down2"></i> 
	</a>
	</script>
	
	<script type="rv-template" id="showDetail">
	<div class="store_details">
		<p class="dsc">{productContent}</p>
  	</div>
	<a href="#" class="bk_more _close">
		<span class="bk_more_txt">접기</span> 
		<i class="c fn-up2"></i> 
	</a>
	</script>
	<script type="rv-template" id="reviewItem">
	<li class="list_item">
	    <div>
	        <div class="review_area">
	            <div class="thumb_area" style="display: {display};">
	                <a href="#" class="thumb" title="이미지 크게 보기">
						<img width="90" height="90" class="img_vertical_top" src="{commentImage}" alt="리뷰이미지"> 
					</a> 
					<span class="img_count" style="display:none;">1</span>
				</div>
	            <h4 class="resoc_name"></h4>
	            <p class="review">{comment}</p>
	        </div>
	        <div class="info_area">
	            <div class="review_info"> 
				  <span class="grade">{score}</span> 
				  <span class="name">{reservationName}</span> 
			      <span class="date">{reservationDate} 방문</span> 
				</div>
	        </div>
	    </div>
	</li>
	</script>
	<script type="rv-template" id="detailInfo">
   		<div class="detail_area">
    		<div class="detail_info">
            	<h3 class="blind">상세정보</h3>
            	<ul class="detail_info_group">
                	<li class="detail_info_lst">
                    	<strong class="in_tit">[소개]</strong>
                    	<p class="in_dsc">{productContent}</p>
                	</li>
                	<li class="detail_info_lst"> <strong class="in_tit">[공지사항]</strong>
                    	<ul class="in_img_group">
                        	<li class="in_img_lst"> 
								<img alt="" class="img_thumb" src="{saveFileName}">
							</li>
                    	</ul>
                	</li>
            	</ul>
        	</div>
    	</div>
	</script>
	<script type="rv-template" id="locationInfo">
		<div class="box_store_info no_topline">
        	<a href="#" class="store_location" title="지도웹으로 연결">
				<img class="store_map img_thumb" alt="map" src="{saveFileName}">
                <span class="img_border"></span>
				<span class="btn_map">
					<i class="spr_book2 ico_mapview"></i>
				</span>
			</a>
            <h3 class="store_name">{productDescription}</h3>
            <div class="store_info">
            	<div class="store_addr_wrap">
                	<span class="fn fn-pin2"></span>
						<p class="store_addr store_addr_bold">{placeStreet}</p>
                        <p class="store_addr">
							<span class="addr_old">지번</span>
                            <span class="addr_old_detail">{placeLot}</span>
                         </p>
						</div>
                        <div class="lst_store_info_wrap">
                        	<ul class="lst_store_info">
                            	<li class="item"> 
									<span class="item_lt"> 
										<i class="fn fn-call2"></i> 
										<span class="sr_only">전화번호</span> 
									</span> 
									<span class="item_rt"> 
										<a href="tel:{telephone}" class="store_tel">{telephone}</a>
									</span>
								</li>
                            </ul>
						</div>
					</div>
                    <div class="bottom_common_path column2">
                    	<a href="#" class="btn_path">
							<i class="fn fn-path-find2"></i> 
							<span>길찾기</span> 
						</a>
						<a href="#" class="btn_navigation before">
							<i class="fn fn-navigation2"></i> 
							<span>내비게이션</span> 
						</a>
                    </div>
				</div>
			</div>
		</div>
	</script>
</body>


</html>
    