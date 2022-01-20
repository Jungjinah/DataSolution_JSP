package com.beaver.jan201.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jan201.board.BoardDAO;
import com.beaver.jan201.member.MemberDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ���� ������ �� ������� ����
	// ������Ʈ �����Ű�� ��Ĺ�� ��� ��Ʈ�ѷ��� �� ����
	public HomeController() {
		BoardDAO.getBdao().countAllBoardMsg();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
