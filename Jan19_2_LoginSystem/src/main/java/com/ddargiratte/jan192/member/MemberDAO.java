package com.ddargiratte.jan192.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("m");	// �α��ο� ������ ������ �갡 ������!
		return(m != null);	// �α����ߴٴ� ������, true �ѱ�ڴ�!
	}
	
	// �α��� ���
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("EUC-KR");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			// �α��� ������ ���� ����
			//		����Ʈ ��𼭵��� ��� ����
			//		��� ���ٿ��� �α��λ��°� Ǯ����
			//		session�Ҽ��� attribute��, cookie�� �����ѵ�,,
			//		cookie�� ������..! -> �׷��� session�� ��!
			
			if (id.equals("����") && pw.equals("����")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);	// �����ð� 10��
			}
			
			// �ѹ� �α��ο� ����������, ������ �� ����Ʈ�� ��������
			//	<input>�� id�� �����־�����...
			//	������ ���, Ȥ�� ������ص� �����ִ°�... -> cookie����!
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(15);
			res.addCookie(c);
			
		} catch (Exception e) {

		}
	}
	
}
