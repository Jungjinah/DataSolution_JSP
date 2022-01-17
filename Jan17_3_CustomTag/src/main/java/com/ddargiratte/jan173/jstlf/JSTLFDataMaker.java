package com.ddargiratte.jan173.jstlf;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class JSTLFDataMaker {
	public static void make(HttpServletRequest req) {
		int a = 12345678;
		req.setAttribute("a", a);
		
		double b = 10 / 24.0;
		req.setAttribute("b", b);
		
		double c = 123.45678;
		req.setAttribute("c", c);
		
		Date now = new Date();
		req.setAttribute("d", now);
		
	}
}
