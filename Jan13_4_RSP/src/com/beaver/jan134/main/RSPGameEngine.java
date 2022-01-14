package com.beaver.jan134.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	
	private int t;
	private int win;
	private int draw;
	private int lose;

	// 손도 못대게 하나 만들어 놓을 것(상수화)
	// private : class 내부에서만 사용 가능/ 외부로는 사용이 불가능
	// public static RSPGameEngine rge = new RSPGameEngine();
	private static final RSPGameEngine rge = new RSPGameEngine(); // 상수화시킴
	
	private RSPGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	// getter처리 해주는 것이 singleton pattern >> C에서 사용하려고 public
	public static RSPGameEngine getRge() {
		return rge;
	}

	public void doRSP(HttpServletRequest request) { // static이 아니어야!(위의 멤버변수때문에)

		// userHand가
		// 1 -> 가위 1 -> s.png 1 -> request.setAttribute("uh, "s,png");
		// comHand가
		// 2 -> 바위 2 -> r.png 2 -> request.setAttribute("ch, "r.png");
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", userHand + ".jpg");

		int comHand = new Random().nextInt(3) + 1;
		request.setAttribute("ch", comHand + ".jpg");

		// 판정
		int result = userHand - comHand;
		if (result == 0) {
			request.setAttribute("r", "무");
			draw++;
			t++;
		} else if (result == -1 || result == 2) {
			request.setAttribute("r", "패");
			lose++;
			t++;
		} else {
			request.setAttribute("r", "승");
			win++;
			t++;
		}
		request.setAttribute("t", t);
		request.setAttribute("w", win);
		request.setAttribute("d", draw);
		request.setAttribute("l", lose);

	}

}
