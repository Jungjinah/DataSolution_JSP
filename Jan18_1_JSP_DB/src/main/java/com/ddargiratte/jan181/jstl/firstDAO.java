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
			
			//sql�� �ۼ�
			String sql = "select * from blade order by b_person";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()�� ���� -> ������ �� �� ������ �޾Ҵ���
			// R : pstmt.executeQuery()�� ���� -> select����� ResultSet���� ����
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
	
	// ����ϱ� (�����Ͱ� ����� ī��Ʈ�� �������� �ø���)
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			// ������ �Է�
			req.setCharacterEncoding("EUC-KR");
			String location = req.getParameter("b_location");
			String name = req.getParameter("b_name");
			String color = req.getParameter("b_color");
			String gender = req.getParameter("b_gender");
			int person = Integer.parseInt(req.getParameter("b_person"));
			
			// <textArea>���� ����ģ�� : \r\n
			// ������������ �ٹٲٱ� : <br>
			
			// sql�� �ۼ� (�̿ϼ�) -������ � ���� ������ �𸣱� ������
			String sql = "insert into blade values(?, ?, ?, ?, ?)";
			
			// DB�����۾� �Ѱ��Ŵ���(pstmt)
			pstmt.setString(1, location);
			pstmt.setString(2, name);
			pstmt.setString(3, color);
			pstmt.setString(4, gender);
			pstmt.setInt(5, person);
			
			// ���� + ���ó��
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "��ϼ���");
				allBladeCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��Ͻ���");
		}
		DdargiratteDBManager.close(con, pstmt, null);
	}
	
	// �� �����Ͱ� �� �� ����
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
	
	// DB�� �����Ͱ� 100�� �ִ� -> �ش� ������ ��ȣ�� �´� �����͸� ��������
	public void getBaldes(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			// SQL �����ϴµ� �ʿ��� �� ì���
			
			// allBladeCount : ��ü �ι� ��
			int bladePerPage = 4;	// �� ������ �� ������ �ι� ��
			
			// ������ ���� ��������
			// Math.ceil : ���� �ø�(�ݿø� x)
			int pageCount = (int) Math.ceil(allBladeCount / (double) bladePerPage);	// �� ������ ��
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
	
	// ������ ��������(Primary key)
	// ����� �����͸� ���������� : true
	// ���������� : false
	public boolean getBladeDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			
			String location = req.getParameter("b_location");
			
			// ���̺�� / �÷��� / SQL��Ÿ ����!
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
				req.setAttribute("r", "��������");
				allBladeCount--;
			}else {
				req.setAttribute("r", "��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��������");
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