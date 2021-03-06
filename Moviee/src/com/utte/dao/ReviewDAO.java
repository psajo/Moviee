package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utte.beans.Member;
import com.utte.beans.Paging;
import com.utte.beans.Review;

public class ReviewDAO {
	//컬럼명 : R_REVIEWID	M_NICK	MV_ID	R_CONTENTS	R_STAR	R_DATE
	//******* 리뷰 삽입 ******//
	public static int insertReview(Review review) {
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO review(R_REVIEWID, M_NICK, MV_ID, R_CONTENTS, R_STAR, R_DATE) VALUES(r_reviewId_seq.nextval,?,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getM_nick());
			ps.setInt(2, review.getMv_id());
			ps.setString(3, review.getR_contents());
			ps.setDouble(4, Double.valueOf(review.getR_star()));
			System.out.println(sql);
			ret = ps.executeUpdate(); //sql 실행 결과를 ret(return)에 저장
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ret;
	}
	//해당 영화의 총 리뷰수
	public static int getReviewCountByMvId(String mv_id) {
		int count=-1;//리뷰 수를 저장
		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;  
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT COUNT(*) FROM review WHERE mv_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,mv_id);
			rs =ps.executeQuery();
			if(rs.next()) {
				count =rs.getInt("COUNT(*)");
				System.out.println("count : "+count);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) 
					conn.close();
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return count;
	}
	//해당 영화의 최신 리뷰순으로 페이징된 결과
	public static List<Review> getReviewsByMvId(String mv_id,int page) {
		int count = getReviewCountByMvId(mv_id);
		Paging paging = new Paging(count);
		paging.setPaging(page);
		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		List<Review> list = null;
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT * FROM (SELECT * FROM review WHERE mv_id=? ORDER BY r_date DESC) WHERE rownum >=? and rownum<= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,mv_id);
			ps.setInt(2, paging.getStartRownum());
			ps.setInt(3, paging.getEndRownum());
			rs =ps.executeQuery();
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					Review rvo = new Review();
					rvo.setR_reviewId(rs.getInt("r_reviewId"));
					rvo.setM_nick(rs.getString("m_nick"));
					rvo.setMv_id(rs.getInt("mv_id"));
					rvo.setR_contents(rs.getString("r_contents"));
					rvo.setR_star(rs.getDouble("r_star"));
					rvo.setR_date(rs.getString("r_date"));
					list.add(rvo);
				}while(rs.next());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) 
					conn.close();
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}
	//내정보에서 최신리뷰 5개//
	public static List<Review> getReviewsByMb(String m_nick){
		List<Review> list = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT * FROM (SELECT * FROM review WHERE m_nick = ? ORDER BY r_date DESC) WHERE rownum <=5";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_nick);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				list= new ArrayList<Review>();
				do {
					Review rvo = new Review();
					rvo.setR_reviewId(rs.getInt("r_reviewId"));
					rvo.setM_nick(rs.getString("m_nick"));
					rvo.setMv_id(rs.getInt("mv_id"));
					rvo.setR_contents(rs.getString("r_contents"));
					rvo.setR_star(rs.getDouble("r_star"));
					rvo.setR_date(rs.getString("r_date"));
					list.add(rvo);
				}while(rs.next());
			}	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		} finally {
			try {
				if(conn!= null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}
	//******* 리뷰 삭제 *******//
	public static int delReview(int R_REVIEWID) {
	
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		int ret =-1;
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="delete from review where R_REVIEWID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, R_REVIEWID);
			ret =ps.executeUpdate();
			ps.close();			
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) {
					conn.close();
				}
				if(ps != null) {
					ps.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ret;
	}
	//사용자의 리뷰 갯수 구하기
	public static int reviewCount(String m_nick) {
		int count=-1;//리뷰 수를 저장
		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;  
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT COUNT(*) FROM review WHERE m_nick=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,m_nick);
			rs =ps.executeQuery();
			if(rs.next()) {
				count =rs.getInt("COUNT(*)");
				System.out.println("count : "+count);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) 
					conn.close();
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return count;
	}
	//사용자의 장르별 리뷰 갯수
	public static int reviewCount(String m_nick, String mv_genres) {
		int count=-1;//리뷰 수를 저장
		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;  
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT COUNT(*) FROM review WHERE m_nick=? AND mv_genres LIKE %?%";
			ps = conn.prepareStatement(sql);
			ps.setString(1,m_nick);
			ps.setString(2,mv_genres);
			rs =ps.executeQuery();
			if(rs.next()) {
				count =rs.getInt("COUNT(*)");
				System.out.println("count : "+count);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) 
					conn.close();
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return count;
	}
	//사용자의 특정 영화의 리뷰 가져오기
	public static Review getReview(String m_nick, String mv_id) {
		Review rvo = null;
		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;  
		try { 
			conn = MyConnection.getConnection(); 
			String sql="SELECT * FROM review WHERE m_nick=? AND mv_id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,m_nick);
			ps.setString(2,mv_id);
			rs =ps.executeQuery();
			if(rs.next()) {
				rvo = new Review();
				rvo.setR_reviewId(rs.getInt("r_reviewId"));
				rvo.setMv_id(rs.getInt("mv_id"));
				rvo.setM_nick(rs.getString("m_nick"));
				rvo.setR_contents(rs.getString("r_contents"));
				rvo.setR_star(rs.getDouble("r_star"));
				rvo.setR_date(rs.getString("r_date"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if(conn!= null) 
					conn.close();
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return rvo;
	}
}
	
	
	


	
		
		

