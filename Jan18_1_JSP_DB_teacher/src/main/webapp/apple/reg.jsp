<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Apple</h2>
	<form action="AppleRegController" method="post" name="appleRegForm" onsubmit="return appleRegCheck();">
		���� : <input name="a_location" autocomplete="off" autofocus="autofocus" placeholder="����" id="inputt">
		<p>
		�� : <select name="a_color" id="slt">
			<option>����</option>
			<option>�ʷ�</option>
			<option>���</option>
			<option>Ȳ��</option>
		</select>
		<p>
		�� : <select name="a_flavor" id="slt">
			<option>�ܸ�</option>
			<option>�Ÿ�</option>
			<option>������</option>
			<option>����</option>
			<option>���</option>
		</select>
		<p>
		���� : <input name="a_price" autocomplete="off" id="inputt" placeholder="���ڸ� �Է�">
		<p>
		���� : <textarea name="a_introduce" maxlength="80" autocomplete="off" id="textArea" placeholder="5�� �̻�"></textarea>
		<p>
		<button id="btn">���</button>
	</form>
</body>
</html>