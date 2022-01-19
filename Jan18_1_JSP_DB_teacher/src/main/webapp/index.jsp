<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/apple.css">
<script type="text/javascript" src="js/BeaverValidChecker.js"></script>
<script type="text/javascript" src="js/go.js"></script>
<script type="text/javascript" src="js/jan18Check.js"></script>
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitleArea"><a href="HomeController">Title</a></th>
		</tr>
		<tr>
			<td id="siteContentArea" align="center"><jsp:include page="${cp }"></jsp:include> </td>
		</tr>
	</table>
	<table id="siteMenuTbl">
		<tr>
			<td align="center"><a href="AppleController">Apple</a></td>
			<td align="center"><a href="">Banana</a></td>
			<td align="center"><a href="">Coconut</a></td>
			<td align="center"><a href="DBCController">DB연결</a></td>
		</tr>
	</table>
</body>
</html>