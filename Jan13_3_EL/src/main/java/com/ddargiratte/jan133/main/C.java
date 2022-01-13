package com.ddargiratte.jan133.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// 어떤 사이트에 첫 접속 : GET방식
	// 만약에 V1.html에서 버튼을 눌렀을 때 GET방식을 써야한다면?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {						// 파라미터 요청값이 없으면!
			request.getRequestDispatcher("V1.html").forward(request, response);		// 첫페이지로 돌아가겠다!
		}else {
			// 요청 파라미터명이 있으면 -> 사이트의 기능활용을 GET방식!
			M.multiply(request);													// 아니면
			request.getRequestDispatcher("V2.jsp").forward(request, response);		// 계산해서 v2.jsp에 보내겠다!
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
