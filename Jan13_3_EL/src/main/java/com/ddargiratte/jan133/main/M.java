package com.ddargiratte.jan133.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x * y;
		request.setAttribute("z", z);		// attribute형태로 다른페이지에 보내준다! (어디로 보낼진 아직 모르는 상태)
											// 쓸곳을 만들어! jsp파일! (V2.jsp)
		
		// 아무렇게나 하나 만들어서 어트리뷰트로 보내기
		dinosaur d = new dinosaur("공룡", 27, "캐쥬얼", "산책", 179.8, 65.2);
		request.setAttribute("d", d);
		
		// 객체 List
		ArrayList<dinosaur> dns = new ArrayList<dinosaur>();
		dns.add(d);
		dns.add(new dinosaur("사우루스", 26, "꾸안꾸", "음악", 179.7, 65.3));
		dns.add(new dinosaur("티라노", 29, "힙", "게임", 179.6, 65.5));
		dns.add(new dinosaur("벨로키랍토르", 28, "정장", "영화", 179.5, 65.6));
		request.setAttribute("dns", dns);
	}
}
