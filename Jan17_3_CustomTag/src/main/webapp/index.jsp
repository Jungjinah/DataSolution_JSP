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
	<td align="center" width="500px" height="100px">Season</td>
	</tr>
	</table>
	<table id="indexTbl" border="1" width="500px" height="100px">
	<tr>
	<td align="center">Spring</td>
	<td align="center">Summer</td>
	<td align="center">Autumn</td>
	<td align="center">Winter</td>
	</tr>	
	</table>
	
	<table id="commentTbl" border="1" width="500px" height="400px">
	<tr>
	<td> <img name = "img" onclick = "change()" src="white.PNG" width="100%" height="100%"></img>
		 <img name = "img2" onclick = "change2()" width="100%" height="100%"></img>
		 <!--<jsp:include page = "${summer }"></jsp:include>-->	
		
		
	</td>
	</tr>	
	</table>
</body>
</html>