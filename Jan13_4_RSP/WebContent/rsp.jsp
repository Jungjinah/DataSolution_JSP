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
			<th colspan="3">┏ 자강두천 가위바위보 ┛</th>
		</tr>
		<tr>
			<td class="td1" colspan="3" align="center">♪┏('o' )┛♪┗ ( 'o') ┓♪</td>
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
			<td class="td2" align="center">유저(↓)</td>
			<td class="td2" align="center">가슴이 웅장해진다...</td>
			<td class="td2" align="center">상대(↓)</td>
		</tr>
		<tr>
			<td align="center"><img src="${uh }"></td>
			<td><img src="rucrazy.jpg"></td>
			<td align="center"><img src="${ch }"></td>
		</tr>
		<tr>
			<td class="td1" colspan="3" align="center">판정 : ${r }</td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">${t }전 ${w }승 ${d }무 ${l }패</td>
		</tr>
	</table>
</body>
</html>