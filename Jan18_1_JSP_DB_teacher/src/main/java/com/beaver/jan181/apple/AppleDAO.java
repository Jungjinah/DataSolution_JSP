package com.beaver.jan181.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beaver.db.manager.BeaverDBManager;

public class AppleDAO {
	private int allAppleCount;
	
	private static final AppleDAO AppleDAO = new AppleDAO();
	
	private AppleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static AppleDAO getAppledao() {
		return AppleDAO;
	}

	// 모든 사과 데이터 다 가져오기 (사실상 필요없음)
	public void getAllApples(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// sql문 작성
			String sql = "select * from jan18_apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()로 실행 -> 데이터 몇개 영향을 받았는지
			// R : pstmt.executeQuery()로 실행 -> select결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple);
			}
			req.setAttribute("apples", apples);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	
	// 등록하기 (데이터가 생기면 카운트를 수동으로 올리자)
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// 데이터 입력
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("a_location");
			String color = req.getParameter("a_color");
			String flavor = req.getParameter("a_flavor");
			int price = Integer.parseInt(req.getParameter("a_price"));
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			String introduce = req.getParameter("a_introduce");
			
			// sql문 작성 (미완성) - 값으로 어떤값을 넣을지 모르기 때문에
			String sql = "insert into jan18_apple values(?, ?, ?, ?, ?)";
			
			// DB관련작업 총괄매니저(pstmt)
			pstmt = con.prepareStatement(sql);
			
			// sql완성
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			// 실행 + 결과처리
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "등록성공");
				allAppleCount++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록실패");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	// 총 데이터가 몇 개 인지
	public void countApples() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			String sql = "select count(*) from jan18_apple";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	
	// DB에 데이터가 100개 있다 -> 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getApples(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// SQL 수행하는데 필요한 값 챙기기
			
			// allAppleCount : 전체 사과들 수
			int applePerPage = 4;	// 한 페이지당 보여줄 사과 수
			
			// 페이지 개수 가져오기
			// Math.ceil : 숫자 올림 (반올림 X)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage); // 총 페이지 수
			req.setAttribute("pageCount", pageCount);
			///////////////////////////////////////////
			int start = (applePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			String sql = "select * from ( "
					+ "select rownum as rn, a_location, a_color, a_flavor, a_price, a_introduce "
					+ 	"from ( "
					+ 		"select * "
					+			"from jan18_apple "
					+			"order by a_price "
					+		") "
					+	") "
					+ "where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple);
			}
			req.setAttribute("apples", apples);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	
	
	// 상세정보 가져오기(Primary key)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	public boolean getAppleDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String location = req.getParameter("a_location");
			
			// 테이블명 / 컬럼명 / SQL오타 주의!
			String sql = "select * from jan18_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Apple apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				req.setAttribute("apple", apple);
				return true; // 일반적인 상황 : 데이터가 하나
			}
			return false;	// 다른사람이 그 데이터를 지웠으면 : 데이터 없음
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB서버가 안좋음(안켜짐)
		} finally {
			BeaverDBManager.close(con, pstmt, rs);
		}
	}
	
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String location = req.getParameter("a_location");
			
			String sql = "delete from jan18_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "삭제성공");
				allAppleCount--;
			} else {
				req.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제실패");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	public boolean update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("a_location");
			String color = req.getParameter("a_color");
			String flavor = req.getParameter("a_flavor");
			int price = Integer.parseInt(req.getParameter("a_price"));
			String introduce = req.getParameter("a_introduce").replace("\r\n", "<br>");
			
			String sql = "update jan18_apple set a_color=?, a_flavor=?, a_price=?, a_introduce=? "
					+ "where a_location=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, introduce);
			pstmt.setString(5, location);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "수정성공");
				return true;
			} else {
				req.setAttribute("r", "수정실패");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패");
			return false;
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
		
	}
	
}





















