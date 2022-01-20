<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css" >
</head>
<body>
	<table id="loginSite"  align="right">
		<form action="loginController" name="loginForm" method="post" onsubmit="return loginCheck();">
		<tr>
			<td align="center" id="logintd">
		 	 	<h1>Login</h1></td>
		</tr>
		<tr>
		 	<td>&nbsp;ID&nbsp;&nbsp; <input type="text" name="l_id" autocomplete="off"
		 		maxlength="10" valu="${cookie.lastLoginID.value }"></td>
		 </tr>
		 <tr>
			<td>PW&nbsp; <input type="password" name="l_pw" autocomplete="off"
				placeholder="password" maxlength="12">  </td>
		</tr>
		<tr>
				<td align="center"><button>로그인</button>
		</form>
				<button onclick="signUpGo();">회원가입</button>
			</td>
		</tr>
		</table>
</body>
</html>