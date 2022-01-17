<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- core가 있어야 fmt을 쓸 수 있다( -->
 <!-- 보통은 둘 다 가져옴 -->
 <!-- prefix="fmt"는 국룰! -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		<aa> bb </aa> 	-> 이게 정석인데,,
		<cc> </cc> 		-> 태그들 사이에 쓸 내용이 없다면
		<dd/> 			-> 이렇게 줄여쓰는거 가능!--> 
	<fmt:formatNumber value="${a }" type="number"/> 	<!-- 숫자 -->
	
	<hr>
	
	<fmt:formatNumber value="${a }" type="currency"/>	<!-- 돈(통화) -->
	
	<hr>
	
	<fmt:formatNumber value="${b }" type="percent"/>	<!-- 퍼센트(쇼수점 반올림) -->
	
	<hr>
	
	<fmt:formatNumber value="${c }" pattern="#.00"/>	<!-- 소수점 둘째자리까지 반올림 -->
	
	<hr>
	
	<fmt:formatDate value="${d }" type="date" dateStyle="long"/> <br>	
	<fmt:formatDate value="${d }" type="date" dateStyle="short"/> <br>
	
	<hr>	
	
	<fmt:formatDate value="${d }" type="time" timeStyle="long"/> <br>	
	<fmt:formatDate value="${d }" type="time" timeStyle="short"/> <br>
	
	<hr>
		
	<fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="short" /> <br>
	
	<hr>
	
	<fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh" /> <br>
	
	<hr>
</body>
</html>