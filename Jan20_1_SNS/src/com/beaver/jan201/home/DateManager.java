package com.beaver.jan201.home;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 여기저기서 날짜를 많이 다룰수있기 때문에 home쪽에 놓는것
public class DateManager {
	
	// <select>년도에서 해마다 바꾸지말고 받아오자
	public static void getCurYear(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		request.setAttribute("cy", curYear);
	}
}
