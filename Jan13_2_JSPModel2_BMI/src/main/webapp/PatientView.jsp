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
	<h1>결과</h1>
	<%
	request.setCharacterEncoding("EUC-KR");
	Patient p = (Patient)request.getAttribute("p");
	%>
	<!-- 2가지방법! $쓰는거랑 %쓰는거! -->
	${ p.getName()} 님의 결과 <br>
	나이 : ${p.getAge() }세 <br>
	키 : <%=p.getHeight() %>cm <br>
	몸무게 : <%=p.getWeight() %>kg <br>
	BMI 결과 : <%=p.getResult() %> <br>
</body>
</html>