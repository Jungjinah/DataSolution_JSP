package com.ddargiratte.jan173.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	public static void make(HttpServletRequest req) {
		int[] ar = {123, 456, 78, 91, 234};
		req.setAttribute("ar", ar);
		
		ArrayList<shark> al = new ArrayList<shark>();
		al.add(new shark("��ũ", 3, 50.5 , 14.1));
		al.add(new shark("�ҽ�", 2, 51.5 , 13.1));
		al.add(new shark("���", 5, 49.5 , 12.1));
		al.add(new shark("�ҽ���", 1, 53.5 , 11.1));
		req.setAttribute("al", al);
	}
}
