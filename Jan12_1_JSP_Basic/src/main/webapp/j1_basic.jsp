<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� 10�� 28��</h1>
	<h1>JSP ����</h1>
	<marquee><%=123* 87 %></marquee>	<!-- ��Ȳ���� ǥ�����̾�! -->
	HTML : ������Ʈ ���� ����
	--------------------- ������ / �̺�Ʈ ���� : �������, ������ �̺�Ʈ��....
	HTML : ���븦 �����
	CSS : ������
	JavaScript : �̺�Ʈ ó��
	--------------------- �Ķ���� �б�, ���, ���ǹ�, �ݺ� : ���α׷��־���� ��� ����
	Servlet : Ŭ���̾�Ʈ�� ��û -> HTML + CSS + JavaScript�� ���� �����ϴ� �ڹ����α׷�
	--------------------- ��ư�, �۾��� ����
	JSP(Java Servlet/Server Page)
		�۾� ���� : HTML + CSS + JavaScript�� �ʿ��� �κи��� Java�ڵ带 ��¦ ÷��!
		���� ��ü : Tomcat�� Servlet���� �ٲ㼭 ����
		
	Servlet : �ڹ��ڵ� �ȿ��� HTML�� ����
	JSP : HTML�ȿ��� �ڹ��ڵ带 �߰�
	
	<%-- 
		1. ��ũ��Ʈ�� (Scriptlet)
		JSP���� Java�ڵ带 ������ �� ����ϴ� ���
		<% Java�ڵ尡 ���⿡!%>
		
		2. ������
		Ư���� ���ø� ���� �� �ֵ��� �ϴ� ���
		<%@ page / include / taglib %>
		
		3. ǥ����
		� ���� (����������) ��� ����� ���Խ�Ű�� ���� �� ����ϴ� ���
		<%= Value %>
		����, ���ڿ�, ���� �� �� ��� ����
		Servlet�� out.print()�� ���� ���
		
		4. ����
		ǥ���Ŀ��� ����� �� �ִ� Java�� method�� �ۼ��� �� ����Ѵ� ���
		<%! �������, method %>
		Java�� method�� ���� (�̸� ��Ģ�� ����)
		
		5. �ּ�(���� ���°� �ּ�! %�� ���Ѱ�!)

	 --%>
</body>
</html>