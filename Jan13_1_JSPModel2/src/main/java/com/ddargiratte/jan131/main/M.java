package com.ddargiratte.jan131.main;

import javax.servlet.http.HttpServletRequest;

// Model : �Ϲ� Java Class
//		���� ����(���, DB, ...)

//		back-end��������B
public class M {
	public static void add(HttpServletRequest request) {		// ��û ��ü ��ü�� �鱸 �Ծ��~
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
		
	}
}
