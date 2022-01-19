package com.ddargiratte.jan191.third;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddargiratte.jan191.m.M;

@WebServlet("/ThirdC")
public class ThirdC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.printSecondDataNew(request);
		
		request.setAttribute("baby", "thirdVbaby.jsp");
		request.getRequestDispatcher("thirdV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
