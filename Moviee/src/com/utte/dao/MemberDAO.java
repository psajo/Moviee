package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utte.beans.Member;

public class MemberDAO {
	public static int signUp(Member mvo) { //memver vo 약자
		Connection conn =null; //db랑 연결해주는 객체
		PreparedStatement ps=null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mvo.getM_email());
			ps.setString(2, mvo.getM_pwd());
			ps.setString(3, mvo.getM_nick());
			ps.setString(4, mvo.getM_fav1());
			ps.setString(5, mvo.getM_fav2());
			ps.setString(6, mvo.getM_fav3());
			ret = ps.executeUpdate(); //sql 실행 결과를 ret(return)에 저장
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
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
	public static boolean dup_email(String m_email) {
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean isDup = true;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT m_email FROM member WHERE m_email=?";//사용자 입력에 따른 변수를 ?로!
			ps = conn.prepareStatement(sql); //ps얻는것
			ps.setString(1, m_email); //?채우는 아이
			rs = ps.executeQuery(); //쿼리 실행결과를 resultSet에 저장
			if(rs.next()) { //다음을 가르켰을 때    while문일 때도 rs.next 적어주기
				isDup = true; //무언가 있으면 T
			}else {
				isDup = false; //비어있으면 F
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
			String sql = "SELECT m_nick FROM member WHERE m_email=? and m_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			ps.setString(2,  m_pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				//이메일, 비밀번호가 일치하는 정보가 있는 경우이므로 로그인처리
				login_id = rs.getString("m_nick");
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
