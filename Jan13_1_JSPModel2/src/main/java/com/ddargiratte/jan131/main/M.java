package com.ddargiratte.jan131.main;

import javax.servlet.http.HttpServletRequest;

// Model : 일반 Java Class
//		실제 업무(계산, DB, ...)

//		back-end웹개발자B
public class M {
	public static void add(HttpServletRequest request) {		// 요청 객체 자체를 들구 왔어요~
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
		
	}
}
