<%@page import="com.ddargiratte.jan132.main.Patient"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���</h1>
	<%
	request.setCharacterEncoding("EUC-KR");
	Patient p = (Patient)request.getAttribute("p");
	%>
	<!-- 2�������! $���°Ŷ� %���°�! -->
	${ p.getName()} ���� ��� <br>
	���� : ${p.getAge() }�� <br>
	Ű : <%=p.getHeight() %>cm <br>
	������ : <%=p.getWeight() %>kg <br>
	BMI ��� : <%=p.getResult() %> <br>
</body>
</html>