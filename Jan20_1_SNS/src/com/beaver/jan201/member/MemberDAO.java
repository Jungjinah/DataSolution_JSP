package com.beaver.jan201.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.db.manager.BeaverDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	public static void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String m_id = m.getM_id();

			String sql = "delete from jan20_sns where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "纏盗失因");
				// 益 噺据戚 彰 越?
				// 益 紫寓戚 臣鍵 督析級?
				// 益 紫寓税 覗紫 -> 走趨醤
// 走榎 DB拭辞 走頗製
// session拭澗 食穿備 益 舛左 害焼赤製(DeleteMemberController税 16腰 是帖 遭楳掻)
//	(18腰匝拭辞 session戚 劾焼姶)				
				String m_photo = m.getM_photo(); // %2D.jpg (廃越坦軒 鞠嬢赤製)
				m_photo = URLDecoder.decode(m_photo, "euc-kr"); // gogae.jpg
				String path = request.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			} else {
				request.setAttribute("r", "戚耕 纏盗坦軒喫");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "纏盗叔鳶(DB辞獄 紫諺)");
		}
		BeaverDBManager.close(con, pstmt, null);
	}

	public static void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");

			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");

			// String sql = "select * from jan20_sns"; - 噺据戚 1000誤戚檎 陥 亜閃神蟹?
			// String sql = "select * from jan20_sns where m_id=? and m_pw=?";
			// SQLInjection因維拭 巷号搾馬陥
			String sql = "select * from jan20_sns where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 汽戚斗亜 赤蟹 + 益 汽戚斗 亜軒徹惟
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(rs.getString("m_id"), dbPw, rs.getString("m_name"), rs.getString("m_phone"),
							rs.getDate("m_birthday"), rs.getString("m_photo"));
					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(600);

					Cookie c = new Cookie("lastLoginID", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					response.addCookie(c);
				} else {
					request.setAttribute("r", "稽益昔叔鳶(PW神嫌)");
				}
			} else { // 汽戚斗亜 蒸陥
				request.setAttribute("r", "稽益昔叔鳶(耕亜脊ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "稽益昔叔鳶(DB辞獄)");
		}
		BeaverDBManager.close(con, pstmt, rs);
	}

	public static boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			// 稽益昔 失因 + 雌殿政走獣
			request.setAttribute("lp", "member/welcome.jsp");
			return true;
		}
		// 稽益昔 叔鳶獣
		request.setAttribute("lp", "member/login.jsp");
		return false;
	}

	public static void logout(HttpServletRequest request) {
		// request.getSession().setMaxInactiveInterval(-1); // 室芝快奄 : 陥献 室芝亀 級嬢亜赤奄凶庚拭 搾蓄
		request.getSession().setAttribute("loginMember", null); // Member拭 企廃 session聖 null稽

	}

	public static void signUp(HttpServletRequest request) {
		// 析舘 督析穣稽球 獣亀
		// 10 * 1024 * 1024
		String path = null;
		MultipartRequest mr = null;
		try {
			path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());

		} catch (Exception e) { // 督析 穣稽球 叔鳶税 井酔
			e.printStackTrace();
			request.setAttribute("r", "噺据亜脊 叔鳶(紫遭督析 遂勲)");
			return; // 穣稽球拭 叔鳶馬檎 及拭 害精 DB拙穣 馬走 源切 (悪薦 曽戟)
		}
		// System.out.println("せせせせ"); -> 穣稽球拭 叔鳶馬檎 戚 採歳精 照蟹神畏走

		// 督析穣稽球 失因獣拭 域紗 遭楳
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool"); // 戚硯 設公処暗蟹

			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			String y = mr.getParameter("m_y"); // 1922 ~ 2022
			int m = Integer.parseInt(mr.getParameter("m_m")); // 1 ~ 12
			int d = Integer.parseInt(mr.getParameter("m_d")); // 1 ~ 31
			String birthday = String.format("%s%02d%02d", y, m, d);
			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "euc-kr").replace("+", " ");

			String sql = "insert into jan20_sns values(?, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birthday);
			pstmt.setString(6, photo);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "噺据亜脊 失因!");
			}
		} catch (Exception e) { // ID掻差, DB辞獄尻衣戚 五荊 :p
			e.printStackTrace();
			// DB楕 庚薦稽 亜脊精 叔鳶走幻 紫遭督析戚 穣稽球澗 鞠嬢赤澗 雌殿
			// 紫遭督析 走趨醤(Java稽 - 督析誤拭 廃越坦軒亜 照鞠嬢赤嬢醤)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			request.setAttribute("r", "噺据亜脊 叔鳶(DB辞獄)");
		}
		BeaverDBManager.close(con, pstmt, null);
	}

	public static void update(HttpServletRequest request) {
		// 督析 穣稽球 叔鳶馬檎(督析 遂勲段引) -> 暗奄辞 強!
		String path = null;
		MultipartRequest mr = null;
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		try {
			path = request.getServletContext().getRealPath("img");
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());

			new_m_photo = mr.getFilesystemName("m_photo"); // 識澱廃 督析誤
			if (new_m_photo != null) { // 戚 赤生檎 (歯稽錘 督析聖 隔醸生檎)
				new_m_photo = URLEncoder.encode(new_m_photo, "euc-kr").replace("+", " ");
			} else { // 戚 蒸生檎 (歯稽錘 督析聖 照隔醸生檎)
				new_m_photo = old_m_photo;
			}

		} catch (Exception e) {
			e.printStackTrace(); // NullPointerException精 食奄辞 襟澗惟 焼艦醤!
			System.out.println("督析遂勲..");
			return;
		}

		// 食奄猿走 遭楳馬澗汽 紺 析 蒸醸陥

		// 督析 紫戚綜亜 10MB左陥 旋精杏稽 設 識澱背辞 - 督析 穣稽球 失因
		// 督析 識澱 照背辞(0MB)

		// 督析 識澱聖 梅陥 : 覗紫 郊荷畏陥 -> 歯 覗紫 督析誤聖 DB拭 隔嬢醤 -> 歯 覗紫 督析誤聖 溌左
		// 奄糎 覗紫 督析 肢薦亀 背醤 -> 据掘 覗紫 督析誤聖 溌左

		// 督析 識澱聖 照馬檎 : 覗紫澗 照郊荷畏陥 -> 奄糎 覗紫 督析誤聖 DB拭 隔嬢醤 -> 据掘 覗紫 督析誤聖 溌左

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			String m_id = mr.getParameter("m_id");
			String m_pw = mr.getParameter("m_pw");
			String m_name = mr.getParameter("m_name");
			String m_phone = mr.getParameter("m_phone");
			String m_y = mr.getParameter("m_y");
			int m_m = Integer.parseInt(mr.getParameter("m_m"));
			int m_d = Integer.parseInt(mr.getParameter("m_d"));
			String m_birthday = String.format("%s%02d%02d", m_y, m_m, m_d);

			String sql = "update jan20_sns set m_pw=?, m_name=?, m_phone=?, m_birthday=to_date(?, 'YYYYMMDD'), m_photo=? where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_pw);
			pstmt.setString(2, m_name);
			pstmt.setString(3, m_phone);
			pstmt.setString(4, m_birthday);
			pstmt.setString(5, new_m_photo); // いしぁ!!
			pstmt.setString(6, m_id);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "舛左呪舛 失因");
				if (!new_m_photo.equals(old_m_photo)) { // 覗紫研 郊峨生檎
					new File(path + "/" + URLDecoder.decode(old_m_photo, "euc-kr")).delete(); // 奄糎 紫遭督析 走酔奄
				}
				SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
				m = new Member(m_id, m_pw, m_name, m_phone, sdf.parse(m_birthday), new_m_photo);
				request.getSession().setAttribute("loginMember", m);
			} else {
				request.setAttribute("r", "舛左呪舛 叔鳶");
				if (!new_m_photo.equals(old_m_photo)) { // 歯稽錘 紫遭 臣虞娃暗 肢薦
					new File(path + "/" + URLDecoder.decode(new_m_photo, "euc-kr")).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "舛左呪舛 叔鳶(DB庚薦)");
			if (!new_m_photo.equals(old_m_photo)) {
				try {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "euc-kr")).delete();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		}
		BeaverDBManager.close(con, pstmt, null);
	}

}
