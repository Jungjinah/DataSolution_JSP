package com.ddargiratte.jan181.jstl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class firstController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (!request.getParameterNames().hasMoreElements()) {
//			request.setAttribute("content", "first.jsp");
//		}else {
//			request.setAttribute("content", "content.jsp");
//		}
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//	}
		firstDAO.getFirstdao().getAllFirst(request);
		request.setAttribute("content", "first.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
