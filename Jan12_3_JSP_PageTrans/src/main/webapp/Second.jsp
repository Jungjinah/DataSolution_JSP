<%@page import="java.util.Random"%>
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
		// 값 - 2가지방법
		//	parameter
		//		html에서 만들어낸 값(a, b)
		//		request에 저장
		//		String or String[]
	
		//	attribute
		//		Java에서 만들어낸 값(c)
		//		request에 저장
		//		Object(객체)
		
		// 이동 - 3가지방법
		//		first -> second : 사용자가 무너가 액션을 해서 넘어옴
		//			-request(요청)
		
		//		second -> third : 그냥 넘어감
		
		//			- redirect : 단순 자동이동(점검중)
		//			response.sendRedirect("Third");
		
		//			- forward : 자동이동(값이 전달되는)
		//			RequestDispatcher rd = reqeust.getRequestDispatcher("Third.jsp");
		//			rd.forward(request, response);
		//			(위 두줄은 쌍으로 다님 / request와 response는 객체인데 third로 같이 옮겨짐)
		
		//			- include : 포함하는 기능(Second속에 Third가 포함되는 그런 개념,,)
		//				단점 ) 위치조절이 안됨 (Third가 무조건 상단에 들어옴) -> 비추!
		//				조만간! 위치조절이 되는 include를 따로 보자!
		//			RequestDispatcher rd = reqeust.getRequestDispatcher("Third.jsp");
		//			rd.include(request, response);
	%>
 
	<%
		request.setCharacterEncoding("EUC-KR");
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// RequestDispatcher : 클라이언트로부터 들어온 요청을 
		//						원하는 쪽으로 요청을 넘기는 기능
		//	호출된 페이지에서는 request.setAttribute(key, value) 메소드르 ㄹ통해서
		//	넘겨받은 데이터를 처리할 수 있음
		//		-> Redirect와는 다르게 request와 response 객체를 가지고 넘어가기 때문에! 넘겨받은 데이터 처리 가능!
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		int c = a + b;
		request.setAttribute("c", c);
		
		String d = "ㅋ";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		// rd.forward(request, response);
		rd.include(request, response);	// second안에 third가 포함되어있는데, 포함된 부분이 위로 뜨게 돼있음.
	%>	

	<h1>Second</h1>
	<hr>
	a : <%=a %>
	b : <%=b %>

</body>
</html>