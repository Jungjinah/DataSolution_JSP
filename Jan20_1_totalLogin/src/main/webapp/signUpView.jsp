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
	���̵� <input placeholder="ID" name="l_id" autofocus="autofocus"
			autocomplete="off" maxlength="12"></td></tr> 
	<tr><td>
	��й�ȣ <input placeholder="PW" name="l_pw" autofocus="autofocus"
			maxlength="15" type="password"></td></tr> 
	<tr><td>
	��й�ȣ ��Ȯ�� <input placeholder="PWR" autofocus="autofocus" 
			maxlength="15" type="password" name="l_pwr"></td></tr>
	<tr><td>
	�̸� <input placeholder="Name" autocomplete="off" 
			 maxlength="10" name="l_name"></td></tr> 
	<tr><td>
	��ȭ��ȣ <input placeholder="PhoneNumber" autocomplete="off" 
			maxlength="11" name="l_phoneNumber"></td></tr> 
	<tr><td>
	������� <input type="date" name="l_brithday"></td></tr> 
	<tr><td>
	���� <input placeholder="gender" autocomplete="off" 
			maxlength="2" name="l_gender"></td></tr>
	<tr><td>
	�̹��� <input type="file" name="l_photo"></td></tr>
	<tr><td align="center"> <button>Sign Up </button> </td></tr>
	</table>
	</form>
</body>
</html>