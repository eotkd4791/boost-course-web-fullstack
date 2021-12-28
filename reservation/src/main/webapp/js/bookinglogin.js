window.addEventListener('DOMContentLoaded', initialize);

function initialize() {	
	document.getElementById('reservationEmail').addEventListener('invalid', validateEmail);
}

function validateEmail(event) {
	document.forms[0].classList.add('was-validated');
}
