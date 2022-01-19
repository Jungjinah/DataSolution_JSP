package com.ddargiratte.jan192.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	// ������� �α��� �ؾ��ϳ�? ��й�ȣ ���� �������� -> POST����!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response);
		// 1. �α��� ������ -> loginSuccess.jsp
		// 2. �α��� ���н� -> index.jsp
		if (MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);	// �α��� ������
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);			// �α��� ���н�
		}
	}

}
