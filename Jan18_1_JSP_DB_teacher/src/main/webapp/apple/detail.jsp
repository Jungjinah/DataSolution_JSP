<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Apple Information</h2>
	<form action="AppleDetailController" method="post" name="appleUpdateForm" onsubmit="return appleUpdateCheck();">
		지역 : <input readonly="readonly" autocomplete="off" autofocus="autofocus"
		name="a_location" id="inputt" value="${apple.a_location }"> <p>
		색 : <input autocomplete="off" name="a_color" id="inputt" value="${apple.a_color }"> <p>
		맛 : <input autocomplete="off" name="a_flavor" id="inputt" value="${apple.a_flavor }"> <p>
		가격 : <input autocomplete="off" name="a_price" id="inputt" value="${apple.a_price }"> <p>
		설명 : <textarea id="textArea" autocomplete="off" maxlength="80" name="a_introduce">${apple.a_introduce }</textarea> <p>
		<button id="btn" style="width: 15%;">수정</button>
	</form>
		<button id="btn" style="width: 15%;" onclick="deleteApple('${apple.a_location}');">삭제</button>
</body>
</html>