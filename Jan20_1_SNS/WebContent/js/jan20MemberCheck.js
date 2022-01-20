function signupCheck() {
	var m_id = document.signupForm.m_id;
	var m_pw = document.signupForm.m_pw;
	var m_pwchk = document.signupForm.m_pwchk;
	var m_name = document.signupForm.m_name;
	var m_phone = document.signupForm.m_phone;
	var m_photo = document.signupForm.m_photo;

	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please fill in ID properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pwchk)) {
		alert("Please fill in Password properly.");
		m_pw.value = "";
		m_pw.focus();
		return false;
	} else if (isEmpty(m_name)) {
		alert("Please fill in Name properly.");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please fill in Phone Number properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
	} else if (isEmpty(m_photo) || isNotType(m_photo, "png")
			&& isNotType(m_photo, "gif") && isNotType(m_photo, "jpg")
			&& isNotType(m_photo, "bmp") && isNotType(m_photo, "jpeg")) {
		alert("Please fill in Photo properly.");
		m_photo.value = "";
		m_photo.focus();
		return false;
	}
	return true;
}

function loginCheck() {
	var m_id = document.loginForm.m_id;
	var m_pw = document.loginForm.m_pw;

	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please fill in ID properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw)) {
		alert("Please fill in Password properly.");
		m_pw.value = "";
		m_pw.focus();
		return false;
	}
	return true;
}
function updateCheck() {
	var m_pw = document.updateForm.m_pw;
	var m_pwchk = document.updateForm.m_pwchk;
	var m_name = document.updateForm.m_name;
	var m_phone = document.updateForm.m_phone;
	var m_photo = document.updateForm.m_photo;

	if (isEmpty(m_pw) || notEqualPw(m_pw, m_pwchk)) {
		alert("Please fill in Password properly.");
		m_pw.value = "";
		m_pw.focus();
		return false;
	} else if (isEmpty(m_name)) {
		alert("Please fill in Name properly.");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please fill in Phone Number properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
	} else if (isEmpty(m_photo)) {
		return true;

	} else if (isNotType(m_photo, "png") && isNotType(m_photo, "gif")
			&& isNotType(m_photo, "jpg") && isNotType(m_photo, "bmp")
			&& isNotType(m_photo, "jpeg")) {
		alert("Please fill in Photo properly.");
		m_photo.value = "";
		m_photo.focus();
		return false;
	}
	return true;
}
