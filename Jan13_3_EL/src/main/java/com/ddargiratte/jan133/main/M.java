package com.ddargiratte.jan133.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int z = x * y;
		request.setAttribute("z", z);		// attribute���·� �ٸ��������� �����ش�! (���� ������ ���� �𸣴� ����)
											// ������ �����! jsp����! (V2.jsp)
		
		// �ƹ����Գ� �ϳ� ���� ��Ʈ����Ʈ�� ������
		dinosaur d = new dinosaur("����", 27, "ĳ���", "��å", 179.8, 65.2);
		request.setAttribute("d", d);
		
		// ��ü List
		ArrayList<dinosaur> dns = new ArrayList<dinosaur>();
		dns.add(d);
		dns.add(new dinosaur("���罺", 26, "�پȲ�", "����", 179.7, 65.3));
		dns.add(new dinosaur("Ƽ���", 29, "��", "����", 179.6, 65.5));
		dns.add(new dinosaur("����Ű���丣", 28, "����", "��ȭ", 179.5, 65.6));
		request.setAttribute("dns", dns);
	}
}
