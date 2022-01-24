package com.ddargiratte.jan212.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;

//홈플러스 사장(부천)
//	구매금액을 입력하면 적립포인트(구매금액의 1프로) 계산하기
//	개발자에게 의뢰
//	+ -> 0.7프로로 바꿔줘!

//개발자(선릉)
//	개발(.java) -compile -> 기계어(.class) -실행 -> 테스 트
//	기계어(.class) -압축 -> 배포파일(.jar)[.bat] -사장님에게 전달 ->

// 유지보수! (사장님 스스로 바꿔서 쓰세요~ 하게 하는 방법이 유지보수다!)
//	IoC (Inversion Of Control) : 제어의 역전
//	.java를 수정 안해도 프로그램이 수정되게

// 프로그램 -> 파일(프로그램의 결과 -> 파일에 저장) : 일반적인 흐름
// 파일 -> 프로그램(파일로 프로그램을 제어)

public class EMMain {
	public static void main(String[] args) {
		
		try {
		Scanner key = new Scanner(System.in);
		System.out.print("구매금액: ");
		int price = key.nextInt();
		FileReader fr = new FileReader("C:\\Users\\wtime\\Desktop\\DS\\pointRate.txt");
		BufferedReader br = new BufferedReader(fr);
		String pr = br.readLine();
		System.out.println("--------------");
		System.out.printf("가격 : %d원\r\n", price);
		double point = price * Double.parseDouble(pr);
		System.out.printf("적립포인트 : %.0f원 적립", point);
		
			Thread.sleep(3000);		// 3초뒤에 꺼짐!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
