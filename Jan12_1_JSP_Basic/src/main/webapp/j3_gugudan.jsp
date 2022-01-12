<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%-- 가로버전-왼쪽 정렬 (5줄 추가) --%>
<style type="text/css">
table {
	float: left;
}
</style>
</head>
<body>
	<%
		for(int i = 2; i < 10; i++) {
	
	%>
		<table border="1">
			<tr>
				<th><%=i %>단</th>
			</tr>
	<% 
		for (int j = 1; j < 10; j++) {
	%>	
		<tr>
			<td> <%=i %> x <%=j %> = <%=i * j %> </td>
		</tr>
	<%
		}
	%>
		</table>
	<%
		}
	%>


</body>
</html>