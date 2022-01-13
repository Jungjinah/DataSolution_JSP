package com.ddargiratte.jan131.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller : Servlet
//	상황판단을 해서 Model과 View(M/V)를 소환
//		-> 어떤 요청이 들어왔을때 판단해서 M/V를 소환
//	이 사이트의 진입점 (실행 여기서!!!!)

//	Back-end 웹개발자A - PL급 (Project Leader)

@WebServlet("/C")
public class C extends HttpServlet {
	
	// 어떤 사이트에 접속
	//	주소를 직접 입력해서 들어가는 방법
	//	검색 -> <a> 눌러서 들어가는 방법
	//	둘다 GET방식 요청 (어떤 사이트에 POST로 첫 접속 - ?!!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("V1.html");
//		rd.forward(request, response);
		request.getRequestDispatcher("V1.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.add(request);	// 계산을 먼저하고 결과를 봐야!
		request.getRequestDispatcher("V2.jsp").forward(request, response);
		
	}
}
