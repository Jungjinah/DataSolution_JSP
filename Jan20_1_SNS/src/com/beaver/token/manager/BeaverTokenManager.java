package com.beaver.token.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class BeaverTokenManager {
	public static void make(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmssSS");
		request.setAttribute("generatedToken", sdf.format(now));
	}
}
