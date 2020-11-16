package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utte.beans.MemberBean;

public class MemberDAO {
	public static int signUp(MemberBean mvo) {
		Connection conn =null;
		PreparedStatement ps=null;
		int ret =-1;
		try {
			conn = MyConnection.getConnection();
			String sql="INSERT INTO member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mvo.getM_email());
			ps.setString(2, mvo.getM_pwd());
			ps.setString(3, mvo.getM_nick());
			ps.setString(4, mvo.getM_fav1());
			ps.setString(5, mvo.getM_fav2());
			ps.setString(6, mvo.getM_fav3());
			ret = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}
	public static boolean emailDupChk(String m_email) {
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean isDup = true;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT m_email FROM member WHERE m_email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			rs = ps.executeQuery();
			if(rs.next()) {
				isDup = true;
			}else {
				isDup = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return isDup;
	}
	public static String login(String m_email, String m_pwd) {
		String login_id = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT m_email FROM member WHERE m_email=? and m_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			ps.setString(2,  m_pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				rs.getString("m_email");
				///�닔�젙以�
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return login_id;
	}
}
