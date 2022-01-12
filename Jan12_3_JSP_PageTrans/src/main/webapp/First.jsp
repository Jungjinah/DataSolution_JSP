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
	<hr>	<!-- 1번째 방법 -->
	<a href="Second.jsp?a=10&b=20";>&lt;a&gt;로 [GET방식 요청]</a>
	<hr>	<!-- 2번째 방법 -->
	<div onclick="gogo();">JavaScript로 [GET방식 요청]</div>
	<hr>	<!-- 3번째 방법 -->
	<form action="Second.jsp">
		a: <input name="a"> <br>
		b: <input name="b"> <br>
	
	<button> form + button조합으로 [GET/POST 방식 요청]</button>
	</form>
</body>
</html>