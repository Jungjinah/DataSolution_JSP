// M
//	front-end웹개발자B

function check() {
	let x = document.f.x;
	let y = document.f.y;
	
	if (isEmpty(x) || isNotNumber(x)
		|| isEmpty(y)  || isNotNumber(y)) {
			alert("Ouch!");
			return false;
		}
		return true;
}