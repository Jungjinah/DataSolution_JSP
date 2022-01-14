package com.ddargiratte.jan142.main;

import javax.servlet.http.HttpServletRequest;

public class Model {
	private int t;
	private int strike;
	private int ball;

	private static final Model m = new Model();
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public static Model getM() {
		return m;
	}
	
	public void doM(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("EUC-KR");
			int myNumber = Integer.parseInt(request.getParameter("user"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	



}
