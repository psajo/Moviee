package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utte.beans.Member;
import com.utte.beans.Review;

public class ReviewDAO<Int> {
	//컬럼명 : R_REVIEWID	M_NICK	MV_ID	R_CONTENTS	R_STAR	R_DATE
	//******* 리뷰 삽입 ******//
	public static int insertReview(Review review) {
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO review(R_REVIEWID, M_NICK, MV_ID, R_CONTENTS, R_STAR, R_DATE) VALUES(r_reviewId_seq.nextval,?,?,?,?,to_char(sysdate))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getM_nick());
			ps.setInt(2, review.getMv_id());
			ps.setString(3, review.getR_contents());
			ps.setInt(4, review.getR_star());
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
	
	//******* 리뷰 목록 ******//
	public List<Review> getList(){
		 List<Review> list = new ArrayList<Review>();
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
	        
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO review(R_REVIEWID, M_NICK, MV_ID, R_CONTENTS, R_STAR, R_DATE) VALUES(r_reviewId_seq.nextval,?,?,?,?,to_char(sysdate))";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				ps.setString(1, review.getM_nick());
				ps.setInt(2, review.getMv_id());
				ps.setString(3, review.getR_contents());
				ps.setInt(4, review.getR_star());
				
				list.add(review);
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
	public void delReview(int R_REVIEWID) {
	
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="delete from review"+"where R_REVIEWID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, R_REVIEWID);
			ps.execute();
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
	}
}
	
	
	


	
		
		

