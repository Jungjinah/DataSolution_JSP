<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- core�� �־�� fmt�� �� �� �ִ�( -->
 <!-- ������ �� �� ������ -->
 <!-- prefix="fmt"�� ����! -->
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
		<aa> bb </aa> 	-> �̰� �����ε�,,
		<cc> </cc> 		-> �±׵� ���̿� �� ������ ���ٸ�
		<dd/> 			-> �̷��� �ٿ����°� ����!--> 
	<fmt:formatNumber value="${a }" type="number"/> 	<!-- ���� -->
	
	<hr>
	
	<fmt:formatNumber value="${a }" type="currency"/>	<!-- ��(��ȭ) -->
	
	<hr>
	
	<fmt:formatNumber value="${b }" type="percent"/>	<!-- �ۼ�Ʈ(����� �ݿø�) -->
	
	<hr>
	
	<fmt:formatNumber value="${c }" pattern="#.00"/>	<!-- �Ҽ��� ��°�ڸ����� �ݿø� -->
	
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