package com.ddargiratte.jan193.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddargiratte.db.manager.DdargiratteDBManager;
import com.ddargiratte.jan193.fruit.Fruit;

public class fruitDAO {
	
	private int allFruitCount;
	
	private static final fruitDAO fruitDAO = new fruitDAO();
	
	public fruitDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static fruitDAO getFruitdao() {
		return fruitDAO;
	}

	public static void getFruit(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			String sql = "select * from fruit order by f_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Fruit> fruits = new ArrayList<Fruit>();
			Fruit fruit = null;
			while (rs.next()) {
				fruit = new Fruit();
				fruit.setF_name(rs.getString("f_name"));
				fruit.setF_price(rs.getInt("f_price"));
				fruits.add(fruit);
			}
			req.setAttribute("fruits", fruits);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdargiratteDBManager.close(con, pstmt, rs);
	}
	
	// 등록하기 (데이터가 생기면 카운트를 수동으로 올리자)
	public static void rgs(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			// 데이터 입력
			req.setCharacterEncoding("EUC-KR");
			String name = req.getParameter("name");
			int price = Integer.parseInt(req.getParameter("price"));
			
			String sql = "insert into fruit values(?, ?)";
			pstmt = con.prepareStatement(sql);
			// DB관련작업 총괄매니저(pstmt)
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.executeUpdate();
			// 실행 + 결과처리
//			if (pstmt.executeUpdate() == 1) {
//				req.setAttribute("r", "등록성공");
//				allFruitCount++;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		DdargiratteDBManager.close(con, pstmt, null);
	}

}