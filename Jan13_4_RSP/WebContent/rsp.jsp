<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="rsp.css">
</head>
<body>
	<table id="rspTbl">
		<tr>
			<th colspan="3">�� �ڰ���õ ���������� ��</th>
		</tr>
		<tr>
			<td class="td1" colspan="3" align="center">�ܦ�('o' )���ܦ� ( 'o') ����</td>
		</tr>
		<tr>
			<td align="center">
				<a href="HomeController?userHand=1"><img src="1.jpg"></a>
			</td>
			<td align="center">
				<a href="HomeController?userHand=2"><img src="2.jpg"></a>
			</td>
			<td align="center">
				<a href="HomeController?userHand=3"><img src="3.jpg"></a>
			</td>
		</tr>
		<tr>
			<td class="td2" align="center">����(��)</td>
			<td class="td2" align="center">������ ����������...</td>
			<td class="td2" align="center">���(��)</td>
		</tr>
		<tr>
			<td align="center"><img src="${uh }"></td>
			<td><img src="rucrazy.jpg"></td>
			<td align="center"><img src="${ch }"></td>
		</tr>
		<tr>
			<td class="td1" colspan="3" align="center">���� : ${r }</td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">${t }�� ${w }�� ${d }�� ${l }��</td>
		</tr>
	</table>
</body>
</html>