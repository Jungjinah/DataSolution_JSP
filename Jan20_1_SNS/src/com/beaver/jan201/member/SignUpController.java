package com.beaver.jan201.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jan201.home.DateManager;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);	// DAO���� loginCheck
		DateManager.getCurYear(request);
		request.setAttribute("cp", "member/signup.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// M��Ÿ����
		MemberDAO.signUp(request);	// DAO���� signUP
		MemberDAO.loginCheck(request);	// DAO���� loginCheck
		// home.jsp ���� -> cp�� ������ ����
		request.setAttribute("cp", "home.jsp");
		// index ���� ��������
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
