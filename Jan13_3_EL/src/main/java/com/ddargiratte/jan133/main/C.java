package com.ddargiratte.jan133.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// � ����Ʈ�� ù ���� : GET���
	// ���࿡ V1.html���� ��ư�� ������ �� GET����� ����Ѵٸ�?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {						// �Ķ���� ��û���� ������!
			request.getRequestDispatcher("V1.html").forward(request, response);		// ù�������� ���ư��ڴ�!
		}else {
			// ��û �Ķ���͸��� ������ -> ����Ʈ�� ���Ȱ���� GET���!
			M.multiply(request);													// �ƴϸ�
			request.getRequestDispatcher("V2.jsp").forward(request, response);		// ����ؼ� v2.jsp�� �����ڴ�!
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
