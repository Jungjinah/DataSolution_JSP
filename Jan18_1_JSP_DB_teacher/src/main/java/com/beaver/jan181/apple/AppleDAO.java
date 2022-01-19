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

	// ��� ��� ������ �� �������� (��ǻ� �ʿ����)
	public void getAllApples(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// sql�� �ۼ�
			String sql = "select * from jan18_apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()�� ���� -> ������ � ������ �޾Ҵ���
			// R : pstmt.executeQuery()�� ���� -> select����� ResultSet���� ����
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
	
	// ����ϱ� (�����Ͱ� ����� ī��Ʈ�� �������� �ø���)
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// ������ �Է�
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("a_location");
			String color = req.getParameter("a_color");
			String flavor = req.getParameter("a_flavor");
			int price = Integer.parseInt(req.getParameter("a_price"));
			
			// <textArea>���� ����ģ�� : \r\n
			// ������������ �ٹٲٱ� : <br>
			String introduce = req.getParameter("a_introduce");
			
			// sql�� �ۼ� (�̿ϼ�) - ������ ����� ������ �𸣱� ������
			String sql = "insert into jan18_apple values(?, ?, ?, ?, ?)";
			
			// DB�����۾� �Ѱ��Ŵ���(pstmt)
			pstmt = con.prepareStatement(sql);
			
			// sql�ϼ�
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			// ���� + ���ó��
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "��ϼ���");
				allAppleCount++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��Ͻ���");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	// �� �����Ͱ� �� �� ����
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
	
	// DB�� �����Ͱ� 100�� �ִ� -> �ش� ������ ��ȣ�� �´� �����͸� ��������
	public void getApples(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			// SQL �����ϴµ� �ʿ��� �� ì���
			
			// allAppleCount : ��ü ����� ��
			int applePerPage = 4;	// �� �������� ������ ��� ��
			
			// ������ ���� ��������
			// Math.ceil : ���� �ø� (�ݿø� X)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage); // �� ������ ��
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
	
	
	// ������ ��������(Primary key)
	// ����� �����͸� ���������� : true
	// ���������� : false
	public boolean getAppleDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String location = req.getParameter("a_location");
			
			// ���̺�� / �÷��� / SQL��Ÿ ����!
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
				return true; // �Ϲ����� ��Ȳ : �����Ͱ� �ϳ�
			}
			return false;	// �ٸ������ �� �����͸� �������� : ������ ����
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB������ ������(������)
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
				req.setAttribute("r", "��������");
				allAppleCount--;
			} else {
				req.setAttribute("r", "��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��������");
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
				req.setAttribute("r", "��������");
				return true;
			} else {
				req.setAttribute("r", "��������");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��������");
			return false;
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
		
	}
	
}





















