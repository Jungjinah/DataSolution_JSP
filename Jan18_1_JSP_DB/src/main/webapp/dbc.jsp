<%@page import="com.ddargiratte.db.manager.DdargiratteDBManager"%>
<%@page import="java.sql.Connection"%>
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
		// ��Ĺ�� Ʃ��뿩�� ������ �� �� �˾Ƽ�
		// Ʃ�� = Connection ��ü
		
		// ���� : DriverManager.getConnection()�� �����ϴ� ����!
		//	���õ� ��� �۾��� �ؼ� Connection ��ü�� �������! -> ����
		
		// Ŀ�ؼ�Ǯ : �̸� Connection��ü x 100 ��������
		//	Ŭ���̾�Ʈ�� ��û�ϸ� -> ��������� �ϳ� �ָ� �� -> ����
	
		// ���� - context.xml(�����, �����ȹ�� ����)
		// Servers - context.xml
		//		���� �ǵ��,, ��ũ�����̽� �ȿ� �ִ� ��~~�� ������Ʈ�� �� ����!
		//		������Ʈ�� �ٸ��� -> DB������ �ٸ���
		
		// �츮�� ���� context.xml�� �� ������Ʈ�� META-INF ������ ����!
		
		String result="����";
		
		Connection con = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			result = "����";
		} catch(Exception e) {
			e.printStackTrace();
		}
		DdargiratteDBManager.close(con, null, null);
	%>
	<h1><%=result %></h1>
	<h1>DB����</h1>
	
</body>
</html>