package com.beaver.jan201.home;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// �������⼭ ��¥�� ���� �ٷ���ֱ� ������ home�ʿ� ���°�
public class DateManager {
	
	// <select>�⵵���� �ظ��� �ٲ������� �޾ƿ���
	public static void getCurYear(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		request.setAttribute("cy", curYear);
	}
}
