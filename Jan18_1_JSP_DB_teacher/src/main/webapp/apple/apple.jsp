<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="appleTbl">
		<tr>
			<td align="right">${r }<a href="AppleRegController">등록</a></td>
		</tr>
		<tr>
			<td id="appleboard" align="center">
				<table id="appleContext">
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr id="dataTr" onclick="goAppleDetail('${apple.a_location}')">
							<td>${apple.a_location }</td>
							<td><fmt:formatNumber value="${apple.a_price }" type="number"/></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" id="applePageArea">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="ApplePageController?p=${p }">${p }</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">검색</td>
		</tr>
	</table>
	<img id="imgAp1" src="img/apple1.png">
	<img id="imgAp2" src="img/apple2.jpg">
</body>
</html>






