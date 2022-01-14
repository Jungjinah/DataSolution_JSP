package com.ddargiratte.jan141.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Model {
	private int t;
	private int win;
	private int lose;
	
	private static final Model m = new Model();
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	public static Model getM() {
		return m;
	}
	
	public void doM(HttpServletRequest request) {
		
		int computerNum = 0;
		String result = null;
		String computerPick = null;
		
		
		try {
			request.setCharacterEncoding("EUC-KR");
			int userPick = Integer.parseInt(request.getParameter("user"));
			
			Random r = new Random();
			computerNum = r.nextInt(30) + 1;
			String gameAns = (computerNum % 2 == 0) ? "¦" : "Ȧ";
			
			if ((userPick) == (computerNum % 2)) {
				win++;
				t++;
			}else {
				lose++;
				t++;
			}
			
			request.setAttribute("t", t);
			request.setAttribute("w", win);
			request.setAttribute("l", lose);
			request.setAttribute("c", gameAns);
			request.setAttribute("cn", computerNum);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
}