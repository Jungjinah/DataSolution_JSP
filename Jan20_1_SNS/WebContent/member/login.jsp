<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl">
		<form action="LoginController" name="loginForm" onsubmit="return loginCheck();" method="post">
			<tr>
				<td align="center" id="logintd">Login</td>
			</tr>
			<tr>
				<td align="center"><input autocomplete="off" placeholder="ID"
					name="m_id" maxlength="10" value="${cookie.lastLoginID.value }"></td>
			</tr>
			<tr>
				<td align="center"><input autocomplete="off" type="password"
					placeholder="Password" name="m_pw" maxlength="12"></td>
			</tr>
			<tr>
				<td align="center">
					<button>Login</button>
		</form>
		<button onclick="signUpGo();">Sign Up</button>
		</td>
		</tr>
	</table>
</body>
</html>