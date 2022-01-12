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
		// 입력Page(Input.html) -> 출력Page(output.jsp)
		// 				점검중(test.jsp)로 보내자
		
		// 페이지 이동
		//	수동(사용자가 뭔가 액션을 하면 이동) - 요청
		//		- <a></a> : 클릭하면 이동
		//		- <form> + <button> : <button> 클릭 or <input>에서 엔터치면 이동
		//		- JavaScript(location.href) : 이벤트를 지정할 수 있음
		//	자동(사용자의 액션과는 상관없이)
		//		- redirect
		//			output.jsp의 <body> 부분 제일 위에(자바코드 안에서! <% 여기 안에!)
		//			response.sendRedirect("test.jsp");
		
	%>
	점검중...(2022/01/12 수요일 PM 15:16 ~???)
</body>
</html>