<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" method="post">
	&nbsp;ID : <input name="id" value="${cookie.lastLoginId.value }"> <p>
	PW : <input name="pw"> <p>
	<button>로그인</button>
	
	
	</form>
</body>
</html>