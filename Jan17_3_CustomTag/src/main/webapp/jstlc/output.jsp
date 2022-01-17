<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 3번줄에서 prefix="c"는 국룰입니다~  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.n }</h1>
	<!-- 조건문 -->
	<c:if test="${param.n % 2 == 0 }">
		짝수
	</c:if>
	
	<hr>
	
	<!-- if-else + switch-case 느낌 -->
	<c:choose>
		<c:when test="${param.n >10 }" >
			10보다 크다 
		</c:when>
		<c:when test="${param.n > 5 }">
			5 ~ 10 사이
		</c:when>
		<c:otherwise>
			나머지
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<c:forEach var="v" begin="i" end="${param.n }" step="2">	<!-- 2단계씩 뛰어넘겠다! --> 
		<marquee>${v }</marquee>
	</c:forEach>
	
	<hr>
	
	<%
		// for(int i : ar) {
		//	System.out.println(i);
		// }
	%>
	<c:forEach var="i" items="${ar }">
		<marquee>${i }</marquee>
	</c:forEach>
	
	<hr>
	
	<c:forEach var="shark" items="${al }">
		${shark.name } - ${shark.age } <br>
	</c:forEach>
	
</body>
</html>