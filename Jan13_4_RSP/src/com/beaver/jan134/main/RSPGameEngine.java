package com.beaver.jan134.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	
	private int t;
	private int win;
	private int draw;
	private int lose;

	// �յ� ����� �ϳ� ����� ���� ��(���ȭ)
	// private : class ���ο����� ��� ����/ �ܺηδ� ����� �Ұ���
	// public static RSPGameEngine rge = new RSPGameEngine();
	private static final RSPGameEngine rge = new RSPGameEngine(); // ���ȭ��Ŵ
	
	private RSPGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	// getteró�� ���ִ� ���� singleton pattern >> C���� ����Ϸ��� public
	public static RSPGameEngine getRge() {
		return rge;
	}

	public void doRSP(HttpServletRequest request) { // static�� �ƴϾ��!(���� �������������)

		// userHand��
		// 1 -> ���� 1 -> s.png 1 -> request.setAttribute("uh, "s,png");
		// comHand��
		// 2 -> ���� 2 -> r.png 2 -> request.setAttribute("ch, "r.png");
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", userHand + ".jpg");

		int comHand = new Random().nextInt(3) + 1;
		request.setAttribute("ch", comHand + ".jpg");

		// ����
		int result = userHand - comHand;
		if (result == 0) {
			request.setAttribute("r", "��");
			draw++;
			t++;
		} else if (result == -1 || result == 2) {
			request.setAttribute("r", "��");
			lose++;
			t++;
		} else {
			request.setAttribute("r", "��");
			win++;
			t++;
		}
		request.setAttribute("t", t);
		request.setAttribute("w", win);
		request.setAttribute("d", draw);
		request.setAttribute("l", lose);

	}

}
