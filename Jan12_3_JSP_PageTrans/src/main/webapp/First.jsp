<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
	function gogo() {
		location.href= "Second.jsp?a=100&b=200";
	}
</script>

</head>
<body>
	<h1>First</h1>
	<hr>	<!-- 1��° ��� -->
	<a href="Second.jsp?a=10&b=20";>&lt;a&gt;�� [GET��� ��û]</a>
	<hr>	<!-- 2��° ��� -->
	<div onclick="gogo();">JavaScript�� [GET��� ��û]</div>
	<hr>	<!-- 3��° ��� -->
	<form action="Second.jsp">
		a: <input name="a"> <br>
		b: <input name="b"> <br>
	
	<button> form + button�������� [GET/POST ��� ��û]</button>
	</form>
</body>
</html>