package com.ddargiratte.jan192.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("m");	// 로그인에 성공을 했으면 얘가 있을것!
		return(m != null);	// 로그인했다는 뜻으로, true 넘기겠다!
	}
	
	// 로그인 기능
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("EUC-KR");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			// 로그인 성공한 유저 정보
			//		사이트 어디서든지 사용 가능
			//		어디 갔다오면 로그인상태가 풀리게
			//		session소속의 attribute나, cookie도 가능한데,,
			//		cookie는 위험해..! -> 그래서 session을 고름!
			
			if (id.equals("하윙") && pw.equals("바윙")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);	// 유지시간 10초
			}
			
			// 한번 로그인에 성공했으면, 다음에 이 사이트에 들어와을때
			//	<input>에 id가 남아있었으면...
			//	접속을 끊어도, 혹은 재부팅해도 남아있는것... -> cookie였음!
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(15);
			res.addCookie(c);
			
		} catch (Exception e) {

		}
	}
	
}
