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
			ret = ps.executeUpdate(); //sql 실행 결과를 ret
			conn.commit();
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
	public static boolean dup_nick(String m_nick) {
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean isDup = true;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT m_nick FROM member WHERE m_nick=?";//사용자 입력에 따른 변수를 ?로!
			ps = conn.prepareStatement(sql); //ps얻는것
			ps.setString(1, m_nick); //?채우는 아이
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
	public static Member login(String m_email, String m_pwd) {
		Member mvo = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT * FROM member WHERE m_email=? and m_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			ps.setString(2,  m_pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				//이메일, 비밀번호가 일치하는 정보가 있는 경우이므로 로그인처리
				mvo = new Member();
				mvo.setM_email(rs.getString("m_email"));
				mvo.setM_nick(rs.getString("m_nick"));
				mvo.setM_profile(rs.getString("m_profile"));
				mvo.setM_fav1(rs.getString("m_fav1"));
				mvo.setM_fav2(rs.getString("m_fav2"));
				mvo.setM_fav3(rs.getString("m_fav3"));
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
		return mvo;
	}
	public static int Update_password(String newPwd, String m_email ) {
		System.out.println(newPwd+m_email);
		//Database 접근을 위한 변수 선언
		Connection conn =null;
		PreparedStatement ps=null;
		
		int result = 0;
		String 	sql = "UPDATE member ";
				sql+=" SET m_pwd = ? ";
				sql+=" WHERE m_email=? ";
		try {
			conn = MyConnection.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newPwd);
			ps.setString(2,  m_email);
			System.out.println("업데이트 성공");
			return  ps.executeUpdate();

			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}// The end of method
	
	public static Member select(String m_email, String m_pwd) {
		Member mvo = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT * FROM member WHERE m_email=? and m_pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			ps.setString(2,  m_pwd);
			rs = ps.executeQuery();
			System.out.println("select 성공");
			
			if(rs.next()) {
				//이메일, 비밀번호가 일치하는 정보가 있는 경우이므로 로그인처리
				mvo = new Member();
				mvo.setM_email(rs.getString(1));
				mvo.setM_pwd(rs.getString(2));
				mvo.setM_nick(rs.getString(3));
				mvo.setM_profile(rs.getString(4));
				mvo.setM_fav1(rs.getString(5));
				mvo.setM_fav2(rs.getString(6));
				mvo.setM_fav3(rs.getString(7));
			}
		} catch ( ClassNotFoundException|SQLException e) {
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
		return mvo;
	}
	public static Member useCookie(String m_email) {
		Member mvo = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT * FROM member WHERE m_email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_email);
			rs = ps.executeQuery();
			if(rs.next()) {
				//이메일, 비밀번호가 일치하는 정보가 있는 경우이므로 로그인처리
				mvo = new Member();
				mvo.setM_email(rs.getString("m_email"));
				mvo.setM_nick(rs.getString("m_nick"));
				mvo.setM_profile(rs.getString("m_profile"));
				mvo.setM_fav1(rs.getString("m_fav1"));
				mvo.setM_fav2(rs.getString("m_fav2"));
				mvo.setM_fav3(rs.getString("m_fav3"));
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
		return mvo;
	}
	//프로필 이미지 업데이트
	public static int updateProfile(String m_email,String m_profile) {
		Connection conn =null; //db랑 연결해주는 객체
		PreparedStatement ps=null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="UPDATE member " + 
						"SET m_profile = ?" + 
						"WHERE m_email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_profile);
			ps.setString(2, m_email);
			ret = ps.executeUpdate(); //sql 실행 결과를 ret
			conn.commit();
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
	public static Member getNaver(String nid) {
		Member mvo = null;
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConnection();
			String sql = "SELECT * FROM member WHERE m_email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			rs = ps.executeQuery();
			if(rs.next()) {
				//이메일, 비밀번호가 일치하는 정보가 있는 경우이므로 로그인처리
				mvo = new Member();
				mvo.setM_email(rs.getString("m_email"));
				mvo.setM_nick(rs.getString("m_nick"));
				mvo.setM_profile(rs.getString("m_profile"));
				mvo.setM_fav1(rs.getString("m_fav1"));
				mvo.setM_fav2(rs.getString("m_fav2"));
				mvo.setM_fav3(rs.getString("m_fav3"));
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
		return mvo;
	}
	public static int insertNaver(Member mvo) {
		Connection conn =null; //db랑 연결해주는 객체
		PreparedStatement ps=null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) VALUES(?,1234,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mvo.getM_email());
			ps.setString(2, mvo.getM_nick());
			ps.setString(3, mvo.getM_fav1());
			ps.setString(4, mvo.getM_fav2());
			ps.setString(5, mvo.getM_fav3());
			ret = ps.executeUpdate(); //sql 실행 결과를 ret
			conn.commit();
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
}
