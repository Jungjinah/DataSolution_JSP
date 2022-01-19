function deleteApple(loc) {
	let t = confirm("¤©¤·??");
	if (t) {
		location.href = "AppleDeleteController?a_location=" + loc;
	}
}

function goAppleDetail(loc) {
	location.href = "AppleDetailController?a_location=" + loc;
}