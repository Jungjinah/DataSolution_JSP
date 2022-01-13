package com.ddargiratte.jan132.main;

import javax.servlet.http.HttpServletRequest;

public class C_Doctor {
	public static void add(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("EUC-KR");
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			double height = Double.parseDouble(request.getParameter("height"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			
			double bmival = (weight) / (height*height);
			String result = null;
			if (bmival <= 18.5) {
				result = "저체중";
			}else if (bmival > 18.5 && bmival <= 23) {
				result = "정상";
			}else if (bmival > 23 && bmival <= 25) {
				result = "과체중";
			}else if (bmival > 25 && bmival <= 30) {
				result = "비만";
			}else if (bmival > 30) {
				result = "고도비만";
			}
			
			String bmi2 = String.format("%.2f", bmival);
			double bmi3 = Double.parseDouble(bmi2);
			
			Patient p = new Patient(name, age, height, weight, result);
			request.setAttribute("p", p);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
