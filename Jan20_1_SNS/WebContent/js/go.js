
function bye() {
	var t = prompt("탈퇴 긔? Y/N");
	if (t == "Y") {
		location.href = "DeleteMemberController";
	}
}

function boardDelete(b_no) {
	var t = confirm("진짜 글 삭제?");
	if (t) {
		location.href = "BoardDeleteController?b_no=" + b_no;
	}
}

function boardUpdate(b_no, b_text) {
	b_text = prompt("변경 내용");
	if (b_text.length < 200) {
		location.href = "BoardUpdateController?b_no=" + b_no + "&b_text=" + b_text;
	}
}

function logout() {
	var really = confirm("리얼루다가?");
	if (really) {
		location.href = "LoginController";
	}
}

function memberInfoGo() {
	location.href = "MemberInfoController";
}

// 가입하러 가기 : goSignUp or signUpGo
function signUpGo() {
	location.href = "SignUpController";
}






