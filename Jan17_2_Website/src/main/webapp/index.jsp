<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<script>
function change() {
	document.img.src = "white2.PNG";
}
</script>
<body>
	<table id="siteTbl" border="1" width="500px" height="100px">
		<tr>
			<td align="center" width="500px" height="100px"><a href="SeasonController">Season</a></td>
		</tr>
	</table>
	<table id="indexTbl" border="1" width="500px" height="100px">
		<tr>
			<td align="center"><a href="calController">��Ģ����</a></td>	<!-- ��Ģ���� -->
			<td align="center"><a href = "JSTLCController">JSPL-core</a></td>	
			<td align="center"><a href = "JSTLFController">JSPL-formatting</a></td>	
			<td align="center">Winter</td>	
		</tr>	
	</table>
	
	<table id="commentTbl" border="1" width="500px" height="400px">
		<tr>
			<td> <img name = "img" onclick = "change()" src="white.PNG" width="100%" height="100%"></img>
			</td>
		</tr>	
	</table>
			<jsp:include page="${detail }"></jsp:include>	
</body>
</html>