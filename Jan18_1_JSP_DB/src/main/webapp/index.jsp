<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://tistory3.daumcdn.net/tistory/941717/skin/images/jquery.min.js" type="text/javascript"></script> 
<script src="https://tistory3.daumcdn.net/tistory/941717/skin/images/snowfall.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
$(document).snowfall({deviceorientation : true, round : true, minSize: 1, maxSize:8,  flakeCount : 250});
});
</script>


<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>

	<table id="titleTbl" border="1" width="700px" height="100px">
		<tr>
			<td align="center"> �ڱ͸���Į���� </td>
		</tr>
	</table>
	
	<table id="contentTbl" border="1" width="700px" height="500px">
		<tr>
			<td align="center" valign="middle">
			<marquee>�ڡ١� �Ϳ����� �ڡ١�</marquee>
			<img name="img" src="img/earzar2.gif" width="75%" height="75%"></img> <br>
			<jsp:include page ="${content }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<table id="indexTbl" border="1" width="700px" height="70px">
		<tr>
			<td align="center"><a href="first">�ι�</a></td>
			<td align="center"><a href="second">����</a></td> 
			<td align="center"><a href="third">���̶���Ʈ</a></td>
			<td align="center"><a href="dbc">DB����</a></td>
		</tr>
	</table>
	
</body>
</html>