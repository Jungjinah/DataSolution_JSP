package com.ddargiratte.jan181.jstl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ddargiratte.db.manager.DdargiratteDBManager;
import com.ddargiratte.jan181.jstl.blade;

public class firstDAO {
	private int allBladeCount;
	
	private static final firstDAO firstDAO = new firstDAO();
	
	public firstDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static firstDAO getFirstdao() {
		return firstDAO;
	}

	public void getAllFirst(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			//sql문 작성
			String sql = "select * from blade order by b_person";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()로 실행 -> 데이터 몇 개 영향을 받았는지
			// R : pstmt.executeQuery()로 실행 -> select결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			
			ArrayList<blade> firsts = new ArrayList<blade>();
			blade first = null;
			while (rs.next()) {
				first = new blade();
				first.setB_location(rs.getString("b_location"));
				first.setB_name(rs.getString("b_name"));
				first.setB_color(rs.getString("b_color"));
				first.setB_gender(rs.getString("b_gender"));
				first.setB_person(rs.getInt("b_person"));
				firsts.add(first);
			}
			req.setAttribute("firsts", firsts);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdargiratteDBManager.close(con, pstmt, rs);
	}
	
	// 등록하기 (데이터가 생기면 카운트를 수동으로 올리자)
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			// 데이터 입력
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("b_location");
			String name = req.getParameter("b_name");
			String color = req.getParameter("b_color");
			String gender = req.getParameter("b_gender");
			int person = Integer.parseInt(req.getParameter("b_person"));
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			
			// sql문 작성 (미완성) -값으로 어떤 값을 넣을지 모르기 때문에
			String sql = "insert into blade values(?, ?, ?, ?, ?)";
			
			// DB관련작업 총괄매니저(pstmt)
			pstmt.setString(1, location);
			pstmt.setString(2, name);
			pstmt.setString(3, color);
			pstmt.setString(4, gender);
			pstmt.setInt(5, person);
			
			// 실행 + 결과처리
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "등록성공");
				allBladeCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록실패");
		}
		DdargiratteDBManager.close(con, pstmt, null);
	}
	
	// 총 데이터가 몇 개 인지
	public void countBlades() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			String sql = "select count(*) from blade";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allBladeCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdargiratteDBManager.close(con, pstmt, rs);
	}
	
	// DB에 데이터가 100개 있다 -> 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getBaldes(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			// SQL 수행하는데 필요한 값 챙기기
			
			// allBladeCount : 전체 인물 수
			int bladePerPage = 4;	// 한 페이지 당 보여줄 인물 수
			
			// 페이지 개수 가져오기
			// Math.ceil : 숫자 올림(반올림 x)
			int pageCount = (int) Math.ceil(allBladeCount / (double) bladePerPage);	// 총 페이지 수
			req.setAttribute("pageCount", pageCount);
			//////////////////////////////////////////
			int start = (bladePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allBladeCount : (start + bladePerPage -1);
			
			String sql = "select * from ("
					+ " select rownum as rn, b_location, b_name, b_color, b_gender, b_person "
					+ 	"from ( "
					+ 		"select * "
					+ 			"from blade "
					+ 				"order by b_person "
					+ 			") "
					+ 	") "
					+ "where rn	>= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<blade> firsts = new ArrayList<blade>();
			blade first = null;
			while (rs.next()) {
				first = new blade();
				first.setB_location(rs.getString("b_location"));
				first.setB_name(rs.getString("b_name"));
				first.setB_color(rs.getString("b_color"));
				first.setB_gender(rs.getString("b_gender"));
				first.setB_person(rs.getInt("b_person"));
				firsts.add(first);
			}
			req.setAttribute("firsts", firsts);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		DdargiratteDBManager.close(con, pstmt, rs);
	}
	
	// 상세정보 가져오기(Primary key)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	public boolean getBladeDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			String location = req.getParameter("b_location");
			
			// 테이블명 / 컬럼명 / SQL오타 주의!
			String sql = "select * from blade whrer b_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				blade first = new blade();
				first.setB_location(rs.getString("b_location"));
				first.setB_name(rs.getString("b_name"));
				first.setB_color(rs.getString("b_color"));
				first.setB_gender(rs.getString("b_gender"));
				first.setB_person(rs.getInt("b_person"));
				req.setAttribute("first", first);
				return true;
			}
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DdargiratteDBManager.close(con, pstmt, rs);
		}
	}
	
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			String location = req.getParameter("b_location");
			
			String sql = "delete from blade where b_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "삭제성공");
				allBladeCount--;
			}else {
				req.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제실패");
		}
		DdargiratteDBManager.close(con, pstmt, null);
	}
	
	public boolean update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("b_location");
			String name = req.getParameter("b_name");
			String color = req.getParameter("b_color");
			String gender = req.getParameter("b_gender");
			Int person = req.getParameter("b_person");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}