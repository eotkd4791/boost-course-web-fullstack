window.addEventListener('DOMContentLoaded', function () {
	initialize();	
});

function initialize() {
	setEventListener();	
}


function setEventListener() {
	document.querySelector('.ticket_body').addEventListener('click', onClickQuantity);
	document.querySelectorAll('.form_horizontal input').forEach(function(input, index) {
		input.addEventListener('input', validateForm(event)[index]);
	});
	document.querySelector('.agreement.all').addEventListener('click', toggleTotalAgreement);
	document.querySelectorAll('.btn_agreement').forEach(function(agreement){ 
		agreement.addEventListener('click', function(event) {
			event.preventDefault();
			toggleDetailAgreementArticle(event);
		});
	});
}

function onClickQuantity(event) {
	if(event.target.tagName === 'A') {
		const prices = [10200, 6800, 20000, 8500];
		const index = [...this.children].findIndex(child => child === event.target.closest('.qty'));
		const ticketCount = this.children[index].querySelector('input');
		const count = parseInt(ticketCount.value);
		
		if(event.target.getAttribute('title') === '더하기') {
			this.children[index].querySelector('input').value = count + 1;
			this.children[index].querySelector('.btn_plus_minus.spr_book2.ico_minus3').classList.remove('disabled');
			this.children[index].querySelector('.count_control_input').classList.remove('disabled');
			this.children[index].querySelector('.total_price').textContent = (prices[index] * (count + 1)).toLocaleString();
		} else {
			if(count > 0) {
				this.children[index].querySelector('input').value = count - 1;
				this.children[index].querySelector('.total_price').textContent = (prices[index] * (count - 1)).toLocaleString();	
			}
			if(parseInt(ticketCount.value) <= 0) {
				this.children[index].querySelector('.btn_plus_minus.spr_book2.ico_minus3').classList.add('disabled');
				this.children[index].querySelector('.count_control_input').classList.add('disabled');
			}
		}
		
		document.getElementById('totalCount').textContent = [].reduce.call(
			document.querySelectorAll('input.count_control_input'), 
			(acc, cur) =>  acc + parseInt(cur.value), 
			0
		);
		
	}
	
}

function validateForm(event) {
	function validateName() {
		if(/[ㄱ-힣]{2,}/g.test(this.value)) {
			this.classList.add('valid');
			this.classList.remove('invalid');
		} else {
			this.classList.add('invalid');
			this.classList.remove('valid');
		}
		checkIfActivateReserveButton();
	}
	function validatePhoneNumber() {
		if(/^010\-[0-9]{4}\-[0-9]{4}$/g.test(this.value)) {
			this.classList.add('valid');		
			this.classList.remove('invalid');
		} else {
			this.classList.add('invalid');
			this.classList.remove('valid');
		}
		checkIfActivateReserveButton();	
	}
	function validateEmail() {
		if(/^[a-z0-9]+@[a-z0-9]+[a-z0-9.]+$/.test(this.value)) {
			this.classList.add('valid');		
			this.classList.remove('invalid');
		} else {
			this.classList.add('invalid');
			this.classList.remove('valid');	
		}
		checkIfActivateReserveButton();		
	}
	return [
		validateName,
		validatePhoneNumber,
		validateEmail
	];
}

function toggleTotalAgreement() {
	const checked = Boolean(this.checked);
	this.checked = !checked; 
	checkIfActivateReserveButton();
}

function toggleDetailAgreementArticle(event) {
	event.target.closest('.agreement').classList.toggle('open');
}

function checkIfActivateReserveButton () {
	if(document.querySelectorAll('form input.valid').length === 3 && document.querySelector('.agreement.all input').checked) {
		document.querySelector('.bk_btn_wrap').classList.remove('disable');
	} else {
		document.querySelector('.bk_btn_wrap').classList.add('disable');
	}
}
