package com.ddargiratte.jan193.fruit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddargiratte.jan193.DAO.fruitDAO;

@WebServlet("/rgsController")
public class rgsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("rgs.jsp").forward(request, response);
		} else {
			fruitDAO.rgs(request);
			fruitDAO.getFruit(request);
			request.getRequestDispatcher("fruit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
 