window.addEventListener('DOMContentLoaded', initialize);

function initialize() {
	const displayInfoId = getDisplayInfoId();
	fetchDatailPageData(displayInfoId);	
}

function getDisplayInfoId() {
	return location.search.slice(1).split('=')[1];
}

function fetchDatailPageData(displayInfoId) {
	httpRequest('GET', `/products/${displayInfoId}`, onLoadHandler);	
}

function onLoadHandler(responseString) {
	const {
		productImages,
		displayInfo,
		displayInfoImage,
		comments,
		productPrices,
		averageScore
	} = JSON.parse(responseString);
	
	renderImages(productImages);
	stylePageNum(productImages);
	hideImageChangeButton(productImages);
	toggleImageChangeButton();
	onClickChangeThumbnail();
	renderTitle(displayInfo.productDescription);
	renderSummaryDetail();
	onClickMoreButton();
	renderEventInfo();
	markScore();
	renderTotalCommentCount();
	renderReviews();
	changeDetailInfoTab();
	renderDetailProductInfo();
	renderLocationInfo();
	onClickMoveToMyReservationPage();
	
	function renderImages(images) {
		const swiper = document.querySelector('.visual_img.detail_swipe');
		const template = document.getElementById('imageList').textContent;
		
		swiper.innerHTML = images.map(image => 
			template.replace('{saveFileName}', image.saveFileName)
		).join('');
	}
	
	function stylePageNum(images) {
		if(checkIfExistTypeOf(images, 'et')) {
			const pageNum = document.querySelector('.figure_pagination .num.off'); 
			pageNum.classList.remove('off');
		}
	}
	
	function hideImageChangeButton(images) {
		if(!checkIfExistTypeOf(images, 'et')) { 
			const next = document.querySelector('.nxt .ico_arr6_rt');
			next.classList.add('off');
		}		
	}
	
	function toggleImageChangeButton() {
		const prev = document.querySelector('.prev .ico_arr6_lt');
		const next = document.querySelector('.nxt .ico_arr6_rt');
		
		prev.classList.toggle('off');
		next.classList.toggle('off');
	}
	
	function onClickChangeThumbnail() {
		document.querySelector('.nxt').addEventListener('click', function() {
			const thumbnail = document.querySelector('.visual_img.detail_swipe');
			const pageNumber = document.querySelector('.figure_pagination').firstElementChild;
			if(pageNumber.textContent === '1') {
				thumbnail.style.transform = 'translateX(-414px)';
				thumbnail.style.transition = '0.3s';
				pageNumber.textContent = '2';
			}
		});
		
		document.querySelector('.prev').addEventListener('click', function() {
			const thumbnail = document.querySelector('.visual_img.detail_swipe');
			const pageNumber = document.querySelector('.figure_pagination').firstElementChild;
			if(pageNumber.textContent === '2') {
				thumbnail.style.transform = 'translateX(0px)';
				thumbnail.style.transition = '0.3s';
				pageNumber.textContent = '1';
			}	
		});
		
	}
	
	function checkIfExistTypeOf(images, type) {
		return Boolean(images.find(image => image.type === type));
	}
	
	function renderTitle(productTitle) {
		const title = document.querySelector('.visual_txt_tit');
		title.innerHTML = `<span>${productTitle}</span>`
	}
	
	function renderSummaryDetail() {
		document.querySelector('.section_store_details p').innerHTML = displayInfo.productContent;
	}
	
	function toggleMoreDetail() {
		const storeDetails = document.querySelector('.section_store_details');
		
		if(storeDetails.firstElementChild?.classList.contains('close3')) {
			const template = document.getElementById('showDetail').textContent;
			storeDetails.innerHTML = template.replace('{productContent}', displayInfo.productContent);
		} else {
			const template = document.getElementById('hideDetail').textContent;
			storeDetails.innerHTML = template.replace('{productContent}', displayInfo.productContent);
		}
		
		onClickMoreButton();
	}
	
	function onClickMoreButton() {
		document.querySelector('a.bk_more').addEventListener('click', toggleMoreDetail);
	}
	
	function renderEventInfo() {
		const eventInfo = document.querySelector('.event_info');
		eventInfo.innerHTML = `[네이버예약 특별할인]<br />` + productPrices.map(({ priceTypeName, discountRate }) =>
			`${priceTypeName}석 ${discountRate}% 할인` 
		).join(', ');	
	}
	
	function markScore() {
		const scoreValue = document.querySelector('.graph_value');
		
		scoreValue.style.width = `${averageScore / 5 * 100}%`;
		
		updateScoreText();
		
		function updateScoreText() {
			const scoreText = document.querySelector('.text_value span');
			scoreText.textContent = averageScore.toFixed(1);
		}
	}
	
	function renderTotalCommentCount() {
		document.querySelector('.join_count .green').textContent = `${comments.length}건`;
	}
	
	function renderReviews() {
		const reviewContainer = document.querySelector('.list_short_review');
		const template = document.getElementById('reviewItem').textContent;
		
		reviewContainer.innerHTML = comments.slice(0, 3).map(({
			comment,
			commentImages,
			score,
			reservationName,
			reservationDate
		}) => {
			const commentImage = commentImages[0]?.saveFileName;
			const templateToRender = template
					.replace('{comment}', comment)
					.replace('{score}', score.toFixed(1))
					.replace('{reservationName}', reservationName)
					.replace('{reservationDate}', `${reservationDate.year}.${reservationDate.monthValue}.${reservationDate.dayOfMonth}`);
					
			return commentImage 
				? templateToRender.replace('{commentImage}', commentImage)
								  .replace('{display}', '')
				: templateToRender.replace('{commentImage}', '')
								  .replace('{display}', 'none');
		}).join('');
	}
	
	function changeDetailInfoTab() {
		const tabContainer = document.querySelector('.info_tab_lst');
		const detailInfoWrapper = document.querySelector('.detail_area_wrap');
		const locationInfoWrapper = document.querySelector('.detail_location');
		
		tabContainer.addEventListener('click', function() {
			detailInfoWrapper.classList.toggle('hide');
			locationInfoWrapper.classList.toggle('hide');
			[].forEach.call(this.children, li => {
				li.classList.toggle('active');
				li.firstElementChild.classList.toggle('active');
			});
		});
		
	}
	function renderDetailProductInfo() {
		const detailInfoWrapper = document.querySelector('.detail_area_wrap');
		const template = document.getElementById('detailInfo').textContent;
		detailInfoWrapper.innerHTML = template.replace('{productContent}', displayInfo.productContent)
											  .replace('{saveFileName}', productImages[0].saveFileName); 
	}
	
	function renderLocationInfo() {
		const locationInfoWrapper = document.querySelector('.detail_location');
		const template = document.getElementById('locationInfo').textContent;
		
	 	locationInfoWrapper.innerHTML = template.replace('{saveFileName}', displayInfoImage.saveFileName)
												.replace('{productDescription}', displayInfo.productDescription)
												.replace('{placeStreet}', displayInfo.placeStreet)
												.replace('{placeLot}', displayInfo.placeLot)
												.split('{telephone}').join(displayInfo.telephone);
	}
	
	function onClickMoveToMyReservationPage() {
		document.querySelector('.bk_btn').addEventListener('click', function() {
			location.href = './reserve';
		});
	}
}




