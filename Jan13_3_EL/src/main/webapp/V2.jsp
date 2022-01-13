<%@page import="java.util.ArrayList"%>
<%@page import="com.ddargiratte.jan133.main.dinosaur"%>
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
		// EL (Expression Language)
		//	값 받을때 Java대신이 가능
		//	.jsp에서만 사용가능(.jsp를 톰켓이 Servlet으로 바꿀때 EL을 Java코드로 바꿔줌)
		//	문법 : ${ XXX }
		//		연산자도 사용 가능
		//		형 변환 잦동
		//		값이 없으면 그냥 넘어감
		//		import가 없어도 됨!
		
		//	파라미터값 받기 : ${param.파라미터명}
		
		//	어트리뷰트값 받기(기본형(int, double, String))
		//				: ${어트리뷰트명}
		//	어트리뷰트값 받기(객체)
		//			주소값 - ${어트리뷰트명}
		//			속성값 - ${어트리뷰트명.멤버변수명}
		//	어트리뷰트값 받기(List, [])받기
		//			AL / []자체			- ${어트리뷰트명}
		//			인덱스 위치의 객체 		- ${어트리뷰트명[인덱스]}
		//			인덱스 위치의 객체 속성	- ${어트리뷰트명[인덱스].멤버변수명}
		
		//	반복문, 조건문 - CustomTag
	%>

	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int z = (Integer) request.getAttribute("z");
		
		dinosaur d = (dinosaur) request.getAttribute("d");
		
		ArrayList<dinosaur> dns = (ArrayList<dinosaur>) request.getAttribute("dns");
	%>
	
	<h1>결과</h1>
	<%=x %> x <%=y %> = <%=z %> <p>
	<%=d.getName() %> : <%=d.getAge() %> : <%=d.getStyle() %> : <%=d.getHobby() %> : <%=d.getHeight() %> : <%=d.getWeight() %>
	<%=d %> <p>
	
	<%=dns %> <p>
	<%=dns.get(1) %> <p>
	<%=dns.get(2).getName() %> : <%=dns.get(3).getStyle() %> <p>
	
	<%
		for(int i = 0; i < dns.size(); i++) {
	%>
		<%=dns.get(i).getName()	%> : <%=dns.get(i).getAge()%>살 : <%=dns.get(i).getStyle()%> : <%=dns.get(i).getHobby()%> : <%=dns.get(i).getHeight()%>cm :<%=dns.get(i).getWeight()%>kg <br>
		<% 		
		}
		%>
	<hr>
	${param.x } <p>
	${param.y } <p>
	${param.x * param.y } <p>
	${z } <p>
	<hr>
	${param.x } x ${param.y } = ${z } <p>
	${d.name } : ${d.age } : ${d.style } : ${d.hobby } : ${d.height } : ${d.weight } <p>
	
	<hr>
	${param.jinagzzang } <!-- 값이 없으면 그냥 넘어가는 예시! -->
	<hr>
	${dns } <p>
	${dns[1] } <p> <!-- 두번째에 있는 인덱스!(인덱스는 항상 0부터 시작!) -->
	${dns[2].name }, ${dns[3].age } <p>
</body>
</html>