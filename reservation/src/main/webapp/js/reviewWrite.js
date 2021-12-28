window.addEventListener('DOMContentLoaded', initialize);

function initialize() {
	onClickRating();
	onClickTextArea();
	onChangeFileUpload();
	onSubmitCommentForm();
}

function onClickRating() {
	const starContainer = document.querySelector('.rating');
	
	starContainer.addEventListener('click', function(event) {
		let target = event.target;
		if(event.target.tagName ==='SPAN') {
			target = event.target.previoueElementSibliing;
		} 
		const children = [].filter.call(starContainer.children, el => el.tagName === 'INPUT');
		const clickedStarIndex = children.findIndex(star => star === target);
		
		children.forEach((star, index) => {
			star.checked = false;
			if(index <= clickedStarIndex) {
				star.checked = true;
			}
		});
		
		renderRatingPoint(clickedStarIndex + 1);
	});
}

function renderRatingPoint(score) {
	const ratingPoint = document.querySelector('.star_rank');
	ratingPoint.textContent = score;
	
	if(score === 0) {
		ratingPoint.classList.add('gray_star');
	} else {
		ratingPoint.classList.remove('gray_star');
	}
}


function onClickTextArea() {
	const reviewWriteInfo = document.querySelector('.review_write_info');
	
	reviewWriteInfo.addEventListener('click', function() {
		hideReviewWriteInfo();
		focusOnTextArea();		
	});
	
	function hideReviewWriteInfo() {
		reviewWriteInfo.style.display = 'none';	
	}
	
	function focusOnTextArea() {
		const textarea = document.querySelector('textarea');
		textarea.focus();
		onBlurTextArea();
		
	}
	
	function onBlurTextArea() {
		const textarea = document.querySelector('textarea');
		textarea.addEventListener('blur', function (event) {
			if(this.value === '' ) {
				reviewWriteInfo.style.display = '';
			}
		});	
	}
}

function onChangeFileUpload() {
	const fileUpload = document.querySelector('input[type="file"]');
	
	fileUpload.addEventListener('change', function (event) {
		const image = event.target.files[0];
		const imgUrl = URL.createObjectURL(image);
		renderImage(imgUrl);
	});
	
	function renderImage(src) {
		const img = new Image();
		img.src = src;
		
		img.onload = function() {			
			const imgContainer = document.querySelector(".item");
			imgContainer.style.display = '';
			deleteImage();
			
			imgContainer.appendChild(img);
			
			document.querySelector('.spr_book.ico_del').addEventListener('click', function() {
				deleteImage();
				imgContainer.style.display = 'none';
			});
		}
		
		function deleteImage() {
			const imgContainer = document.querySelector(".item");
			imgContainer.removeChild(imgContainer.querySelector('img'));			
		}
	}
}

function onSubmitCommentForm() {
	const reservationInfoId = localStorage.getItem('reservationInfoId');
	const form = document.forms[0];
	 
	form.addEventListener('submit', onSubmitHandler);
	
	function onSubmitHandler(event) {
		event.preventDefault();
		httpRequest(
			'POST', 
			`/reservations/${reservationInfoId}/comments`, 
			() => window.history.back(), 
			createFormData()
		);		
	}
	
	function createFormData() {
		const formData = new FormData();
		formData.append('score', parseInt(document.querySelector('.star_rank').textContent));
		formData.append('attachedImage', form[6].files[0]);
		formData.append('reservationInfoId', reservationInfoId);
		formData.append('comment', form[5].value);
		formData.append('productId', 1);
		return formData;
	}
}

