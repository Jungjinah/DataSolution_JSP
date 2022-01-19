// 잘못했으면 true값 (무언가 문제가 되면 true, 정상적이면 false인 컨셉)

// <input>을 넣었을때
//	아무것도 안썼으면 true, 뭐라도 썼으면 false
function isEmpty(input) {
	return (!input.value);
}

// <input>, 글자수를 넣었을때
// 그 글자수보다 적으면 true, 그 글자수 이상이면 false
function atLeastLetter(input, len) {
	return (input.value.length < len);
}

// <input> 넣었을때
// 한글/특수문자가 적혀있으면 true, 없으면 false
function containsAnother(input) {
	// pass에 있는것만 쓸 수 있게
	var pass = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@._";

	var iv = input.value;
	for (var i = 0; i < iv.length; i++) {
		if (pass.indexOf(iv[i]) == -1) {
			return true;
			// break; -> 왜 없어도 되는지 생각해보기 !
		}
	}
	return false;
}

// <input> x 2 넣었을때 (PW,PW확인)
// 내용이 다르면 true, 같으면 false
function notEqualPw(input1, input2) {
	return (input1.value != input2.value);
}

// <input>, 문자열세트 넣었을때
// 없으면 true, 있으면 false (입력한 pw에 지정한 문자열이 없는 경우)

function notContains(input, passSet) {
	var iv = input.value;
	for (var i = 0; i < passSet.length; i++) {
		if (iv.indexOf(passSet[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input> 넣었을때
// 숫자 아닌거 있으면 true, 숫자만 있으면 false

function isNotNumber(input) {
	return isNaN(input.value);
}

// <input>, 확장자 넣었을때
// 그거 아니면 true, 맞으면 false

function isNotType(input, type) {
	// type pdf
	type = "." + type;
	// input.value aaa.pdf
	return (input.value.indexOf(type) == -1);
}
