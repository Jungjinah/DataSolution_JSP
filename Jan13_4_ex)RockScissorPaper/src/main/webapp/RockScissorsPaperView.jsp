<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel ="stylesheet" href ="RSP.css">
</head>
<body>
	<table id="title" border="1" width ="500px" height="30px">
	<tr>
	<td align="center"><a><b>����������!</b></a></td>
	</tr>
	</table>

	<table id="main" border="1" width="500px" height="300px">
	<tr>
		<td align="center">
		<a href="HomeController?userHand=1"><img src="CSS/1.PNG" width="150px" height="150px"></a>
		</td>
		
		<td align="center">
		<a href="HomeController?userHand=2"><img src="CSS/2.PNG" width="150px" height="150px"></a>
		</td>
		
		<td align="center">
		<a href="HomeController?userHand=3"><img src="CSS/3.PNG" width="150px" height="150px"></a>
		</td>
	</tr>
	</table>
	
	<table id="game" width="500px" height="30px">
	<tr>
	<td align="center"><a><b>���(��)</b></a>
	</td>
	<td align="center"><a><b>���αٵα٢�</b></a>
	</td>
	<td align="center"><a><b>��ǻ��(��)</b></a>
	</td>
	</tr>
	</table>
	
	<table id="main2" border="1" width="500px" height="300px">
	<tr>
		<td align="center"><img src="${uh }"  width="150px" height="150px"></td>
		
		<td align="center">
		<a href="Controller?userHand=1"><img src="CSS/zza.PNG" width="150px" height="150px"></a>
		</td>
		
		<td align="center"><img src="${ch }" width="150px" height="150px"></td>
	</tr>
	</table>
	
	<table id="result" border="1" width="500px" height="30px">
	<tr>
		<td class="td1" colspan="3" align="center"><a><b>���� : ${r }</b></a>
		</td>
	</tr>
	</table>
	
	<table id="result1" border="1" width="500px" height="30px">
	<tr>
		<td class="td3" colspan="3" align="center">${t }�� ${w }�� ${d }�� ${l }��
		</td>
	</tr>
	</table>
	
</body>
</html>



