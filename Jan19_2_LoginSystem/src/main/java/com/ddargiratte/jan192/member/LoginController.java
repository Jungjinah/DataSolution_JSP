package com.ddargiratte.jan192.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	// 어떤것으로 로그인 해야하나? 비밀번호 유출 위험으로 -> POST선택!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response);
		// 1. 로그인 성공시 -> loginSuccess.jsp
		// 2. 로그인 실패시 -> index.jsp
		if (MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);	// 로그인 성공시
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);			// 로그인 실패시
		}
	}

}
