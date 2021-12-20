function httpRequest(method, url, callback, payload) {
	const baseURL = 'http://localhost:8080/reservation/api';	
 	const xhr = new XMLHttpRequest();

	xhr.onload = function() {
		if(xhr.status === 200) {		
			callback(xhr.response);	
		}
	};	
	xhr.open(method, baseURL + url);
	xhr.send(payload && JSON.stringify(payload));
}