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
		���� : <input readonly="readonly" autocomplete="off" autofocus="autofocus"
		name="a_location" id="inputt" value="${apple.a_location }"> <p>
		�� : <input autocomplete="off" name="a_color" id="inputt" value="${apple.a_color }"> <p>
		�� : <input autocomplete="off" name="a_flavor" id="inputt" value="${apple.a_flavor }"> <p>
		���� : <input autocomplete="off" name="a_price" id="inputt" value="${apple.a_price }"> <p>
		���� : <textarea id="textArea" autocomplete="off" maxlength="80" name="a_introduce">${apple.a_introduce }</textarea> <p>
		<button id="btn" style="width: 15%;">����</button>
	</form>
		<button id="btn" style="width: 15%;" onclick="deleteApple('${apple.a_location}');">����</button>
</body>
</html>