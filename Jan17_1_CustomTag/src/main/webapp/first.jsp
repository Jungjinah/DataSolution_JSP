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
		// JSP Mdoel 2
		//	V.(jsp)
		//	 �� �ޱ� : EL
		
		// ������ �̵�
		//	redirect, forward, include(��ġ���� �����ϰ�,,)
		//	���ǹ�, �ݺ���
		//	�������(�Ҽ���, ��¥ ����, ...)
		
		// CustomTag ����!
		//	������� HTML DOM��ü 
		//		.jsp -> servlet���� �ٲ� �� java�� ��ȯ!
		//			=> .jsp������ ��� ���� o
		//	<���ξ�:�±׸�>
		//		<xxx:table></xxx:table>
		
		// JSPǥ�ؾ׼��±�
		//	JSP ȯ�濡�� �⺻������ ��밡��
		//	���ξ jsp
		//	forward, include, .... �̷��� ���!
		// Ŀ�����±�
		//	�ܺ� .jar�� �ְ� ����� �� (jstl.jar)
		//	���ξ �������(����� ���� �������!)
		//	�ݺ���, ���ǹ�, �������
	%>
	<h1>First</h1>
	<!-- second.jsp�� �ҽ��� �Ʒ��� -->
	<jsp:include page="second.jsp"></jsp:include> <!-- �ڡڡ� ���ϴ� �ڸ��� ���� �� �ִ� ����! -->
	<h2>Third</h2>
	
</body>
</html>