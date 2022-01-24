package com.ddargiratte.jan214.main;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		SqlSession ss = null;	// db연결
		try {
			// 연결
			InputStream is = Resources.getResourceAsStream("xxx.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			// 값 불러오기
			List<Fruit> fruits = ss.selectList("yyy.getAllFruit");
			
			for (Fruit f : fruits) {
				System.out.println(f.getF_name());
				System.out.println(f.getF_price());
				System.out.println("---------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
