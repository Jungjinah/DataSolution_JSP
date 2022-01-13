<%@page import="java.util.ArrayList"%>
<%@page import="com.ddargiratte.jan133.main.dinosaur"%>
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
		// EL (Expression Language)
		//	�� ������ Java����� ����
		//	.jsp������ ��밡��(.jsp�� ������ Servlet���� �ٲܶ� EL�� Java�ڵ�� �ٲ���)
		//	���� : ${ XXX }
		//		�����ڵ� ��� ����
		//		�� ��ȯ �浿
		//		���� ������ �׳� �Ѿ
		//		import�� ��� ��!
		
		//	�Ķ���Ͱ� �ޱ� : ${param.�Ķ���͸�}
		
		//	��Ʈ����Ʈ�� �ޱ�(�⺻��(int, double, String))
		//				: ${��Ʈ����Ʈ��}
		//	��Ʈ����Ʈ�� �ޱ�(��ü)
		//			�ּҰ� - ${��Ʈ����Ʈ��}
		//			�Ӽ��� - ${��Ʈ����Ʈ��.���������}
		//	��Ʈ����Ʈ�� �ޱ�(List, [])�ޱ�
		//			AL / []��ü			- ${��Ʈ����Ʈ��}
		//			�ε��� ��ġ�� ��ü 		- ${��Ʈ����Ʈ��[�ε���]}
		//			�ε��� ��ġ�� ��ü �Ӽ�	- ${��Ʈ����Ʈ��[�ε���].���������}
		
		//	�ݺ���, ���ǹ� - CustomTag
	%>

	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int z = (Integer) request.getAttribute("z");
		
		dinosaur d = (dinosaur) request.getAttribute("d");
		
		ArrayList<dinosaur> dns = (ArrayList<dinosaur>) request.getAttribute("dns");
	%>
	
	<h1>���</h1>
	<%=x %> x <%=y %> = <%=z %> <p>
	<%=d.getName() %> : <%=d.getAge() %> : <%=d.getStyle() %> : <%=d.getHobby() %> : <%=d.getHeight() %> : <%=d.getWeight() %>
	<%=d %> <p>
	
	<%=dns %> <p>
	<%=dns.get(1) %> <p>
	<%=dns.get(2).getName() %> : <%=dns.get(3).getStyle() %> <p>
	
	<%
		for(int i = 0; i < dns.size(); i++) {
	%>
		<%=dns.get(i).getName()	%> : <%=dns.get(i).getAge()%>�� : <%=dns.get(i).getStyle()%> : <%=dns.get(i).getHobby()%> : <%=dns.get(i).getHeight()%>cm :<%=dns.get(i).getWeight()%>kg <br>
		<% 		
		}
		%>
	<hr>
	${param.x } <p>
	${param.y } <p>
	${param.x * param.y } <p>
	${z } <p>
	<hr>
	${param.x } x ${param.y } = ${z } <p>
	${d.name } : ${d.age } : ${d.style } : ${d.hobby } : ${d.height } : ${d.weight } <p>
	
	<hr>
	${param.jinagzzang } <!-- ���� ������ �׳� �Ѿ�� ����! -->
	<hr>
	${dns } <p>
	${dns[1] } <p> <!-- �ι�°�� �ִ� �ε���!(�ε����� �׻� 0���� ����!) -->
	${dns[2].name }, ${dns[3].age } <p>
</body>
</html>