package com.ddargiratte.jan134.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ���� ���� : GET��� ��û �Ҷ����� �ٸ������� �����ϰ� �־ ���ڰ� �Ƚ���...
		// �ذ�å : �����ϳ� -> Singleton pattern!!!
		// 		** JSP Model 2�Ҷ� M�� singleton������ ��찡 ���.

		// ���� 2 : Singleton pattern�� ������ ���� �������� �ϳ��� ������ ���Ե� (������ ����)
		//		������� ����? -> Ŭ���̾�Ʈ���� ���� ����
		// GET��� ��û ������
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			if (!request.getParameterNames().hasMoreElements()) {
				request.setAttribute("uh", "11.PNG");
				request.setAttribute("ch", "22.PNG");
			} else {
				// RSPGameEngine rge = new RSPGameEngine(); // ���ο� ���� ����
				RSPGameEngine rge = RSPGameEngine.getRge(); // singleton pattern �ҷ�����
				// ���� ����
				rge.doRSP(request);
			}
			request.getRequestDispatcher("RockScissorsPaperView.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		}

	}