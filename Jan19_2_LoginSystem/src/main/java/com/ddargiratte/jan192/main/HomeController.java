package com.ddargiratte.jan192.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddargiratte.jan192.member.MemberDAO;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);	// 로그인 성공시
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);			// 로그인 실패시
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
