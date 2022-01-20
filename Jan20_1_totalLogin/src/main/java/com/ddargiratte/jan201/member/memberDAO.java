package com.ddargiratte.jan201.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.ddargiratte.db.manager.DdargiratteDBManager;

public class memberDAO {
	public static void getHome(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DdargiratteDBManager.connect("ddargirattePool");
			Member l = (Member) request.getSession().getAttribute("loginMember");
			String l_id = l.getL_id();
		
			String sql = "select * from login where l_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, l_id);
			
			if (pstmt.executeUpdate() ==1 ) {
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
