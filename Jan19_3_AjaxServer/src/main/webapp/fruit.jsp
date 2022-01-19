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
<body>
	<table id="titleTbl" border="1" width="300px" height="60px">
		<tr>
			<td align="center"> ★과일나라★ </td>
		</tr>
	</table>
	
	<table id="contentTbl" border="1" width="300px" height="100px">
		<tr>
			<td align="center" valign="middle">
			★☆★ 신선해요~ ★☆★
			<img name="img" src="fruit.PNG" width="75%" height="75%"></img> <br>
			<jsp:include page ="${content }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<table id="indexTbl" border="1" width="300px" height="30px">
		<tr>
			<td align="center">이름</td>
			<td align="center">가격</td> 
		</tr>
		<c:forEach var="fruit" items="${fruits }">
			<tr class="dataTr">
				<td>${fruit.f_name } </td> 
				<td><fmt:formatNumber value="${fruit.f_price }" type="number"/> </td>
			</tr>
		</c:forEach>
		<tr>
		<a href="rgsController">등록</a>
		</tr>

	</table>
</body>
</html>