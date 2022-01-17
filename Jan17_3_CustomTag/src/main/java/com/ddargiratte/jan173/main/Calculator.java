package com.ddargiratte.jan173.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculator(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		int a = x - y;
		int b = x / y;
		int c = x * y;
		request.setAttribute("z", z);
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
	}
}
