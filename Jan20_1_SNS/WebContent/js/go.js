
function bye() {
	var t = prompt("Ż�� ��? Y/N");
	if (t == "Y") {
		location.href = "DeleteMemberController";
	}
}

function boardDelete(b_no) {
	var t = confirm("��¥ �� ����?");
	if (t) {
		location.href = "BoardDeleteController?b_no=" + b_no;
	}
}

function boardUpdate(b_no, b_text) {
	b_text = prompt("���� ����");
	if (b_text.length < 200) {
		location.href = "BoardUpdateController?b_no=" + b_no + "&b_text=" + b_text;
	}
}

function logout() {
	var really = confirm("�����ٰ�?");
	if (really) {
		location.href = "LoginController";
	}
}

function memberInfoGo() {
	location.href = "MemberInfoController";
}

// �����Ϸ� ���� : goSignUp or signUpGo
function signUpGo() {
	location.href = "SignUpController";
}






