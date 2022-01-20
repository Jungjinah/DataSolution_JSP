<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="signUpController"
		enctype="multipart/form-data" name="signUpForm" >
	<table id="signupTbl">
	<tr><td>
	아이디 <input placeholder="ID" name="l_id" autofocus="autofocus"
			autocomplete="off" maxlength="12"></td></tr> 
	<tr><td>
	비밀번호 <input placeholder="PW" name="l_pw" autofocus="autofocus"
			maxlength="15" type="password"></td></tr> 
	<tr><td>
	비밀번호 재확인 <input placeholder="PWR" autofocus="autofocus" 
			maxlength="15" type="password" name="l_pwr"></td></tr>
	<tr><td>
	이름 <input placeholder="Name" autocomplete="off" 
			 maxlength="10" name="l_name"></td></tr> 
	<tr><td>
	전화번호 <input placeholder="PhoneNumber" autocomplete="off" 
			maxlength="11" name="l_phoneNumber"></td></tr> 
	<tr><td>
	생년월일 <input type="date" name="l_brithday"></td></tr> 
	<tr><td>
	성별 <input placeholder="gender" autocomplete="off" 
			maxlength="2" name="l_gender"></td></tr>
	<tr><td>
	이미지 <input type="file" name="l_photo"></td></tr>
	<tr><td align="center"> <button>Sign Up </button> </td></tr>
	</table>
	</form>
</body>
</html>