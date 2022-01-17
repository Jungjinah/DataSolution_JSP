<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// JSP Mdoel 2
		//	V.(jsp)
		//	 값 받기 : EL
		
		// 페이지 이동
		//	redirect, forward, include(위치까지 지정하게,,)
		//	조건문, 반복문
		//	출력형식(소수점, 날짜 형식, ...)
		
		// CustomTag 구현!
		//	생김새는 HTML DOM객체 
		//		.jsp -> servlet으로 바뀔 때 java로 변환!
		//			=> .jsp에서만 사용 가능 o
		//	<접두어:태그명>
		//		<xxx:table></xxx:table>
		
		// JSP표준액션태그
		//	JSP 환경에서 기본적으로 사용가능
		//	접두어가 jsp
		//	forward, include, .... 이런걸 사용!
		// 커스텀태그
		//	외부 .jar를 넣고 사용을 함 (jstl.jar)
		//	접두어가 마음대로(사용자 지정 마음대로!)
		//	반복문, 조건문, 출력형식
	%>
	<h1>First</h1>
	<!-- second.jsp의 소스가 아래에 -->
	<jsp:include page="second.jsp"></jsp:include> <!-- ★★★ 원하는 자리에 넣을 수 있다 장점! -->
	<h2>Third</h2>
	
</body>
</html>