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
		지역 : <input name="a_location" autocomplete="off" autofocus="autofocus" placeholder="지역" id="inputt">
		<p>
		색 : <select name="a_color" id="slt">
			<option>빨강</option>
			<option>초록</option>
			<option>노랑</option>
			<option>황금</option>
		</select>
		<p>
		맛 : <select name="a_flavor" id="slt">
			<option>단맛</option>
			<option>신맛</option>
			<option>떫은맛</option>
			<option>쓴맛</option>
			<option>노맛</option>
		</select>
		<p>
		가격 : <input name="a_price" autocomplete="off" id="inputt" placeholder="숫자만 입력">
		<p>
		설명 : <textarea name="a_introduce" maxlength="80" autocomplete="off" id="textArea" placeholder="5자 이상"></textarea>
		<p>
		<button id="btn">등록</button>
	</form>
</body>
</html>