package com.beaver.jan181.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jan181.apple.AppleDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	// 톰캣이 이 프로젝트를 처음 실행시킬때
	public HomeController() {
		AppleDAO.getAppledao().countApples(); // 사과데이터 총 개수 가져오기
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
