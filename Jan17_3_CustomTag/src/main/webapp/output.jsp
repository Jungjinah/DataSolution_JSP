<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int sum = x+y;
	int minus = x-y;
	int mul = x*y;
	int div = x/y;
	
	%>
	
	<h1><%=x %> + <%=y %> =<%=sum %></h1>
	<h1><%=x %> - <%=y %> =<%=minus %></h1>
	<h1><%=x %> / <%=y %> =<%=mul %></h1>
	<h1><%=x %> * <%=y %> =<%=div %></h1>
	
</body>
</html>