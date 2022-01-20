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
	<table id="titleTbl" border="1" width="100%" height="100%">
		<tr>
			<td align="center"><a href="HomeController"> Begin Again</a></td>
		</tr>
	</table>
	<table id="chartTbl" border="1" width="100%" height="100%">
		<tr>
			<td align="center"><a href="ChartController"> chart</a></td>
		</tr>
	</table>
	
	<table id="contentTbl" border="1" width="100%"  height="800px">
		<form action="signUpController" method="GET">
		<tr>
		<td align="center" valign="middle"><jsp:include page="${sign }"/></td>
		</tr>
		</form>
	</table>

	<table>
		<tr>
			<td id="loginTbl"><jsp:include page ="${login }"></jsp:include></td>
	</table>
</body>
</html>