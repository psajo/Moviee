package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utte.beans.Member;
import com.utte.beans.Review;

public class ReviewDAO {
	
	public int insertReview(Review review) {
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
		try { //예외처리
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="INSERT INTO reviewTBL(r_memId, r_movieId, r_reviewId, r_contents, r_star, r_date)"+"VALUES(?,?,?,?,?,to_char(sysdate))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getR_memId());
			ps.setString(2, review.getR_movieId());
			ps.setString(3, review.getR_reviewId());
			ps.setString(4, review.getR_contents());
			ps.setString(5, review.getR_star());
			System.out.println(sql);
			ret = ps.executeUpdate(); //sql 실행 결과를 ret(return)에 저장
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}
		return ret;
	}
}


	
		
		

