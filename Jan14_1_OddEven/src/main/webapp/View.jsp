<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel ="stylesheet" href ="OE.css">
</head>
<body>
	<table id="title" border="1" width ="500px" height="40px">
	<tr>
	<td align="center"><h1><a><b>홀이야~ 짝이야~?</b></a></h1></td>
	</tr>
	</table>
	
	
	<table border="1" width="500px" height="250px">
	<tr>
		<td id="picture1" align="center">
		<a href="Controller?user=1"><img src="1.png" width="150px" height="150px"></a>
		</td>
		<td id="picture2" align="center">
		<a href="Controller?user=0"><img src="2.png" width="150px" height="150px"></a>
		</td>
	</tr>
	</table>
	
	<table id="result" border="1" width="500px" height="30px">
	<tr>
		<td class="td1" colspan="3" align="center"><a><b>동전개수 : ${cn }</b></a>
		</td>
	</tr>
	</table>
	
	<table id="result1" border="1" width="500px" height="30px">
	<tr>
		<td class="td3" colspan="3" align="center">답 : ${c }</td>
	</tr>
	</table>
	
	<table id="result2" border="1" width="500px" height="30px">
	<tr>
		<td class="td3" colspan="3" align="center">${t }전 ${w }승 ${l }패</td>
	</tr>
	</table>
</body>
</html>