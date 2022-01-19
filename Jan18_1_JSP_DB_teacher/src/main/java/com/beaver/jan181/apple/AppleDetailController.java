package com.beaver.jan181.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	// 상세정보 페이지로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().getAppleDetail(request)) {
			request.setAttribute("cp", "apple/detail.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("cp", "apple/apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().update(request)) {
			AppleDAO.getAppledao().getAppleDetail(request);
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("cp", "apple/apple.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("cp", "apple/apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
