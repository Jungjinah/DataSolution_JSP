<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<%-- 낙서할 준비! --%>
<script type="text/javascript">
	function getRandomColor() {
		// Math.random()					-> 0.0 ~ 0.9999
		// Math.random() * 255				-> 0.0 ~ 254.9999
		// Math.round(Math.Random() * 255)	-> 0 ~ 255
		
		let r = Math.round(Math.random() * 255);
		let g = Math.round(Math.random() * 255);
		let b = Math.round(Math.random() * 255);
		
		return "rgb(" + r + ", " + g + ", " + b + ")";
	}

	function init() {
		// html5: canvas, IOS: Quartz2D, android : CanvasView 
		let cv =  document.getElementById("cv");
		let pen = cv.getContext("2d");	<%-- 크레파스 준비 --%>
		let x = null;
		let y = null;
		
		setInterval(function() {					// thread랑 같은 느낌 = setInterval
			pen.save();	// 현재 pen상태 저장
			pen.fillStyle= "rgba(0, 0, 0, 0.8)";	// 투명도 a는 0 ~ 1 사이 값 넣기
			pen.fillRect(0, 0, 500, 500);	// 시작 x y축 끝 x y 축 ( 500 500 사이즈!)
			
			pen.shadowOffsetX = 0;	// 그림자효과 x
			pen.shadowOffsetY = 0;	// 그림자 효과 x
			pen.shadowBlur = 5;	// 번짐효과
			pen.shadowColor = "white";

			x = Math.random() * 500;
			y = Math.random() * 500;
			pen.fillStyle = getRandomColor();	// red, #FF0000, rgb(255, 0, 0);
			pen.fillRect(x, y, 20, 20);
			
			pen.restore();
		}, 200);
	}
</script>

</head>
<body onload="init();">
	<canvas id="cv" width="500px" height="500px"></canvas>
	<hr>
	
	<%-- StringTokenizer 버전 --%>
	<%
	response.sendRedirect("test.jsp");
	request.setCharacterEncoding("EUC-KR");
	String s = request.getParameter("number");
	StringTokenizer st = new StringTokenizer(s, ",");
	
	int num = 0;
	int sum = 0;
	
	while (st.hasMoreTokens()) {
		try{
			num = Integer.parseInt(st.nextToken());
			sum += num;
			// sum += Integer.parseInt(st.nextToken());
		} catch (Exception e) {
			
		}
	}
	%>
	
	<h1>합(StringTokenizer) : <%=sum %></h1>
	
	<%-- split 버전 --%>
	<%
	request.setCharacterEncoding("EUC-KR");
	
	String num1 = request.getParameter("number");
	String[] numData = num1.split(",");
	
	int sum1 = 0;
	for (String n : numData) {
		try {
		sum1 += Integer.parseInt(n);
		} catch (Exception e) {

		}
	}
	%>
	
	<h1>합(Split) : <%=sum1 %></h1>
</body>
</html>