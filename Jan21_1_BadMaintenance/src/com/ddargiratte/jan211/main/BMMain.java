package com.ddargiratte.jan211.main;

import java.util.Scanner;

// 홈플러스 사장(부천)
//	구매금액을 입력하면 적립포인트(구매금액의 1프로) 계산하기
//	개발자에게 의뢰
// 	+ -> 0.7프로로 바꿔줘!

// 개발자(선릉)
//	개발 -> 테스트
//	배포

public class BMMain {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.print("구매금액: ");
		int price = key.nextInt();
	 // double point = price * 0.01;
		double point = price * 0.007;

		System.out.printf("적립포인트 : %.0f원 적립", point);
		
		try {
			Thread.sleep(3000);		// 3초뒤에 꺼짐!
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}