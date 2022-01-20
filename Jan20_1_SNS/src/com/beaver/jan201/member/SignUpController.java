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
		MemberDAO.loginCheck(request);	// DAO에서 loginCheck
		DateManager.getCurYear(request);
		request.setAttribute("cp", "member/signup.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// M나타내기
		MemberDAO.signUp(request);	// DAO에서 signUP
		MemberDAO.loginCheck(request);	// DAO에서 loginCheck
		// home.jsp 내용 -> cp로 변수명 지정
		request.setAttribute("cp", "home.jsp");
		// index 내용 가져오기
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
