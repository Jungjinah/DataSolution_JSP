<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--
		������ ���ڸ� �־�����, ¦���� Ȧ���� �˷��ִ� ���
	--%>
	
	<%--�޼ҵ� �ֱ� --%>
	<%! 
		public String getOE(int x) {
			return (x % 2 == 0) ? "¦��" : "Ȧ��";
		}
	%>
	<%--��ũ��Ʈ�� --%>
	<% 
	 	Random r = new Random(); 
	 	int x = r.nextInt(100) + 1;
	 %>
	
	<h1>���� ���� : <%=x %></h1>
	<h1>Ȧ¦ ���� : <%=getOE(x) %></h1>
	
</body>
</html>