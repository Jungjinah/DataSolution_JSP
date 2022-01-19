function appleRegCheck() {
	let lBox = document.appleRegForm.a_location;
	let pBox = document.appleRegForm.a_price;
	let iBox = document.appleRegForm.a_introduce;
	
	if (isEmpty(lBox)) {
		alert("Please fill in Location Properly.");
		lBox.value = "";
		lBox.focus();
		return false;
	} else if (isEmpty(pBox) || isNotNumber(pBox)) {
		alert("Please fill in Price Properly.");
		pBox.value = "";
		pBox.focus();
		return false;
	} else if (isEmpty(iBox) || atLeastLetter(iBox, 5)) {
		alert("Please fill in Introduce Properly.");
		iBox.value = "";
		iBox.focus();
		return false;
	}
	return true;
}

function appleUpdateCheck() {
	let cBox = document.appleUpdateForm.a_color;
	let fBox = document.appleUpdateForm.a_flavor;
	let pBox = document.appleUpdateForm.a_price;
	let iBox = document.appleUpdateForm.a_introduce;
	
	if (isEmpty(cBox)) {
		alert("Please fill in Color Properly.");
		cBox.focus();
	} else if (isEmpty(fBox)) {
		alert("Please fill in Flavor Properly.");
		fBox.focus();
	} else if (isEmpty(pBox) || isNotNumber(pBox)) {
		alert("Please fill in Price Properly.");
		fBox.focus();
	} else if (isEmpty(iBox) || atLeastLetter(iBox, 5)) {
		iBox.focus();
	}
	return true;
}






