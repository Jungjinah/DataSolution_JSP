package com.beaver.jan181.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	// ����Ϸ� form�� �ִ� �������� ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "apple/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// ����ϱ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB�� ���
		AppleDAO.getAppledao().reg(request);
		
		// �Խ��ǿ� ���ð� ������
//		AppleDAO.getAppledao().getAllApples(request);
		AppleDAO.getAppledao().getApples(1, request);
		
		// ����Ŀ� ������ ������ (������ ����)
		request.setAttribute("cp", "apple/apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
