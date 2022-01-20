<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="SignUpController" method="post"
		enctype="multipart/form-data" name="signupForm"
		onsubmit="return signupCheck();">
		<table id="signupTbl">
			<tr>
				<td><input placeholder="ID" name="m_id" autofocus="autofocus"
					autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<td><input placeholder="PW" name="m_pw" autocomplete="off"
					maxlength="12" type="password"></td>
			</tr>
			<tr>
				<td><input placeholder="PW Check" name="m_pwchk"
					autocomplete="off" maxlength="12" type="password"></td>
			</tr>
			<tr>
				<td><input placeholder="Name" name="m_name" autocomplete="off"
					maxlength="10"></td>
			</tr>
			<tr>
				<td><input placeholder="Phone Number" name="m_phone"
					autocomplete="off" maxlength="11"></td>
			</tr>
			<tr>
				<td>생년월일<br> <select name="m_y">
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
				</select>&nbsp;년&nbsp;&nbsp;<select name="m_m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
				</select>&nbsp;월&nbsp;&nbsp;<select name="m_d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
				</select>&nbsp;일&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>사진<br> <input type="file" name="m_photo"></td>
			</tr>
			<tr>
				<td align="center">
					<button>Sign Up</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>