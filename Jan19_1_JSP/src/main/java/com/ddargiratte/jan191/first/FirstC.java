package com.ddargiratte.jan191.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller
//	JSPȯ�濡�� ��Ȳ�Ǵ��� �ؼ�..
//	 GET���? POST���? �ϱ⿡�� Servlet�� ����!
//	 ����� �ؾ��ϸ� M(Model)����
//	 �������ϸ� V(View)��
//	�帧����

@WebServlet("/FirstC")	// <- �� ��Ʈ�ѷ��� ������ ���� �ȵ�! / FirstC�� ��Ĺ�� ���
public class FirstC extends HttpServlet {
	
	// �� ������Ʈ���� main�޼ҵ尡 ����
	// ��Ĺ�� ����Ǹ鼭(main�� ��Ĺ�� �ְ�)-> �˾Ƽ� FirstC��ü�� �����...
	// �� ������Ʈ�� ó�� ������ �� 
	public FirstC() {
		super();
		// TODO Auto-generated constructor stub
		// ó�� �������� �� ��� ������ �� ������ �޾ƿ��� ���ؼ� �������!
	}
	// �̰� �������,,
	
	// ������Ʈ�� ������ ��ȯ - 2���� ��û ���! : Controller�� ��û -> Model�� ���� �۾� -> View�� ������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����Ʈ�� ó�� ������ 
		//	FirstC�� ��û�Ķ���� �ϳ��� ���� GET������� ��û�� �ϸ�,
		if (!request.getParameterNames().hasMoreElements()) {
			
			// firstV.jsp�� ���� �Ͼ ��û�� �������ִ� ��ü
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response);	// firstV�� ������
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
