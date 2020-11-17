package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utte.beans.Review;

public class ReviewDAO {
	public static int reviewInput(Review rvo) throws ClassNotFoundException, SQLException { // rvo = review vo 약자
		Connection conn =null; //db랑 연결해주는 객체
		PreparedStatement ps=null; //sql문장을 실행시키는 객체
		int ret =-1; //select: 집합으로 resultSet에 담기! 나머지는 int로 받기 (성공여부) 
	
		conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
		String sql="INSERT INTO review(r_memId, r_movieId, r_contents, r_star, r_date) VALUES(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, rvo.getR_memId());
		ps.setString(2, rvo.getR_movieId());
		ps.setString(3, rvo.getR_contents());
		ps.setString(4, rvo.getR_star());
		ps.setString(5, rvo.getR_date());
		return ret = ps.executeUpdate();
	}
}

	
		
		

