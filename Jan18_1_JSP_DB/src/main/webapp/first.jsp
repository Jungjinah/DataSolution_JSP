<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="index.css">
<body>

 <table id="signTbl">
	<tr>
		<td class="sign" align="right">${r }<a href="firstController">등록</a></td>
	</tr>
	<tr>
		<td id="firstBoard" align="center">
			<table id="firstContext" width="400px" height="100px">
				<tr>
					<th>이름</th>
					<th>색</th>
				</tr>
				<c:forEach var ="first" items="${firsts }">
					<tr class="dataTr">
						<td align="center">${first.b_name } </td>
						<td align="center">${first.b_color }</td>
					</tr>
				</c:forEach>	
			</table>
		</td>
	</tr>
</table>

<img id="imgB1" src="img/one.PNG" width="200px" height="300px">
<img id="imgB2" src="img/two.PNG" width="200px" height="300px">
<img id="imgB2" src="img/three.PNG" width="200px" height="300px">
<img id="imgB2" src="img/four.PNG" width="200px" height="300px">
</body>
</html>