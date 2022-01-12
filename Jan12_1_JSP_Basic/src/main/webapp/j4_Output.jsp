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
		// GET / POST
		// 원래 ) 요청파라미터 -> 한글처리
		//		GET - 한글처리 안함
		//		POST - 한글처리 해야함
		//	일단 요청하고 봅시다!
		request.setCharacterEncoding("EUC-KR");
		
		// 원래 > 응답 한글처리 해야하는데.. (위에서 해주고 있어서 필요없다!)
		//		ex) 1번줄, 2번줄, 6번줄
		// response.setCharacterEncoding("EUC-KR");
		
		String name = request.getParameter("name");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x + y;
	%>
	이름 : <%=name %>
	<h1><%=x %> + <%=y %> = <%=z %></h1>
	
	
	
</body>
</html>