package com.ddargiratte.jan215.C;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddargiratte.jan215.memo.MemoDAO;

@WebServlet("/MemoWriteController")
public class MemoWriteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemoDAO.getMemo(request);
		MemoDAO.write(request);
		request.getRequestDispatcher("memoV.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
