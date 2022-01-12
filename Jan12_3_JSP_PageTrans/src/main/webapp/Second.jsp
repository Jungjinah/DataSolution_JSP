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
	<%
		// �� - 2�������
		//	parameter
		//		html���� ���� ��(a, b)
		//		request�� ����
		//		String or String[]
	
		//	attribute
		//		Java���� ���� ��(c)
		//		request�� ����
		//		Object(��ü)
		
		// �̵� - 3�������
		//		first -> second : ����ڰ� ���ʰ� �׼��� �ؼ� �Ѿ��
		//			-request(��û)
		
		//		second -> third : �׳� �Ѿ
		
		//			- redirect : �ܼ� �ڵ��̵�(������)
		//			response.sendRedirect("Third");
		
		//			- forward : �ڵ��̵�(���� ���޵Ǵ�)
		//			RequestDispatcher rd = reqeust.getRequestDispatcher("Third.jsp");
		//			rd.forward(request, response);
		//			(�� ������ ������ �ٴ� / request�� response�� ��ü�ε� third�� ���� �Ű���)
		
		//			- include : �����ϴ� ���(Second�ӿ� Third�� ���ԵǴ� �׷� ����,,)
		//				���� ) ��ġ������ �ȵ� (Third�� ������ ��ܿ� ����) -> ����!
		//				������! ��ġ������ �Ǵ� include�� ���� ����!
		//			RequestDispatcher rd = reqeust.getRequestDispatcher("Third.jsp");
		//			rd.include(request, response);
	%>
 
	<%
		request.setCharacterEncoding("EUC-KR");
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// RequestDispatcher : Ŭ���̾�Ʈ�κ��� ���� ��û�� 
		//						���ϴ� ������ ��û�� �ѱ�� ���
		//	ȣ��� ������������ request.setAttribute(key, value) �޼ҵ帣 �����ؼ�
		//	�Ѱܹ��� �����͸� ó���� �� ����
		//		-> Redirect�ʹ� �ٸ��� request�� response ��ü�� ������ �Ѿ�� ������! �Ѱܹ��� ������ ó�� ����!
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		int c = a + b;
		request.setAttribute("c", c);
		
		String d = "��";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		// rd.forward(request, response);
		rd.include(request, response);	// second�ȿ� third�� ���ԵǾ��ִµ�, ���Ե� �κ��� ���� �߰� ������.
	%>	

	<h1>Second</h1>
	<hr>
	a : <%=a %>
	b : <%=b %>

</body>
</html>