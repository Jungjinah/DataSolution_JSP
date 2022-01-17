package com.ddargiratte.jan173.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calController")
public class calController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//request.setAttribute(", response);
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("detail", "jstlc/input.jsp");			
		} else {
			request.setAttribute("detail", "jstlc/output.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}