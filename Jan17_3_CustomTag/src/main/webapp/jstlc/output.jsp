<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 3���ٿ��� prefix="c"�� �����Դϴ�~  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.n }</h1>
	<!-- ���ǹ� -->
	<c:if test="${param.n % 2 == 0 }">
		¦��
	</c:if>
	
	<hr>
	
	<!-- if-else + switch-case ���� -->
	<c:choose>
		<c:when test="${param.n >10 }" >
			10���� ũ�� 
		</c:when>
		<c:when test="${param.n > 5 }">
			5 ~ 10 ����
		</c:when>
		<c:otherwise>
			������
		</c:otherwise>
	</c:choose>
	
	<!-- �ݺ��� -->
	<c:forEach var="v" begin="i" end="${param.n }" step="2">	<!-- 2�ܰ辿 �پ�Ѱڴ�! --> 
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