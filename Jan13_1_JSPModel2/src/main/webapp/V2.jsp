<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>V2</h1>
	<%
	// V
	//	�������̳�B�� ����.
	
	request.setCharacterEncoding("EUC-KR");
	
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int z = (Integer) request.getAttribute("z");	// autounboxing���� �ڵ�����ȯ!
	%>
	
	<h1> <%=x %> + <%=y %> = <%=z %></h1>
</body>
</html>