package com.ddargiratte.jan214.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		SqlSession ss = null;	// db연결
		try {
			// 연결
			InputStream is = Resources.getResourceAsStream("xxx.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			// 값 불러오기
			Scanner k = new Scanner(System.in);
			System.out.print("과일이름 : ");
			String name = k.next();
			System.out.print("가격 : ");
			BigDecimal price = k.nextBigDecimal();
			
			// 입력받은 값들을 JavaBean에 보낼것!
			Fruit f = new Fruit(name, price);
			
			if (ss.insert("yyy.regFruit", f) == 1) {	// 데이터의 수가 하나라면
				System.out.println("성공");
				ss.commit();							// 저장! commit을 해야 적용이 됨!
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
