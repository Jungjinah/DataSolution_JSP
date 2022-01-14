package com.beaver.jan134.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 지금 문제 : GET방식 요청 할때마다 다른엔진을 생성하고 있어서 숫자가 안쌓임...
	// 해결책 : 엔진하나 -> Singleton pattern!!!
	// 		** JSP Model 2할때 M이 singleton패턴인 경우가 잦다.

	// 문제 2 : Singleton pattern의 엔진을 쓰면 여러명이 하나의 엔진을 쓰게됨 (전적이 공유)
	//		사람별로 따로? -> 클라이언트별로 개별 공간
	// GET방식 요청 받으면
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("uh", "1.jpg");
			request.setAttribute("ch", "2.jpg");
		} else {
			// RSPGameEngine rge = new RSPGameEngine(); // 새로운 엔진 만들어서
			RSPGameEngine rge = RSPGameEngine.getRge(); // singleton pattern 불러오기
			// 한판 진행
			rge.doRSP(request);
		}
		request.getRequestDispatcher("rsp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
