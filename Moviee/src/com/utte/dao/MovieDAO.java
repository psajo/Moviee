package com.utte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utte.beans.Member;
import com.utte.beans.Movie;

public class MovieDAO {
	
// 인덱스에 뿌려줄 메소드 	
	public static List<Movie> getMovie(Member mvo) {
		
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		ResultSet rs = null; // sql 결과 데이터를 담는 객체
		List<Movie> list= new ArrayList<Movie>();		
		
		try { //예외처리
			if(mvo != null) { //로그인 했을때 
				System.out.println((String)(mvo.getM_fav1()));
				conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
				String sql="select * \r\n" + 
						"from (select * from (select * from movie where mv_genres like ? order by mv_votecount desc) where rownum<=1) \r\n" + 
						"    union (select * from (select * from movie where mv_genres like ? order by mv_votecount desc) where rownum<=1) \r\n" + 
						"    union (select * from (select * from movie where mv_genres like ? order by mv_votecount desc) where rownum<=1)"; //쿼리문 준비
				ps = conn.prepareStatement(sql);
				ps.setString(1,"%"+mvo.getM_fav1()+"%"); 
				System.out.println((String)(mvo.getM_fav1()));
				ps.setString(2,"%"+mvo.getM_fav2()+"%"); 
				ps.setString(3,"%"+mvo.getM_fav3()+"%"); 
//				ps.setString(2,mvo.getM_fav2()); 이렇게 넣으면 '%'장르'%' 이렇게 들어가버려서 결과 안나옴 ㅠ 
//				ps.setString(3,mvo.getM_fav3()); 
				rs = ps.executeQuery();
				while(rs.next()) { //rs -1부터 시작 값 꺼내기 전에 커서 이동
					String mv_id = rs.getString("mv_id");
					String mv_title= rs.getString("mv_title");
				    String mv_posterpath = rs.getString("mv_posterpath");
				    String mv_snapshotpath = rs.getString("mv_snapshotpath");
					String mv_casting= rs.getString("mv_casting");
					String mv_crew= rs.getString("mv_crew");
					String mv_genres= rs.getString("mv_genres");
					String mv_overview= rs.getString("mv_overview");
					Date mv_releasedate= rs.getDate("mv_releasedate");
					int mv_votecount= rs.getInt("mv_votecount");
					Movie m = new Movie(mv_id,mv_title,mv_posterpath,mv_snapshotpath,mv_casting,mv_crew,mv_genres,mv_overview,mv_releasedate,mv_votecount);
					list.add(m);
				}

			}else { //로그인 안했을때
				
				conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
				String sql="SELECT * FROM movie order by mv_votecount"; //쿼리문 준비
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				System.out.println("mvo null ");//수정중입니다
				int x = 0;
				while(rs.next()) {
					if(x>=3) {
						break;
					}
					String mv_id = rs.getString("mv_id");
					String mv_title= rs.getString("mv_title");
				    String mv_posterpath = rs.getString("mv_posterpath");
				    String mv_snapshotpath = rs.getString("mv_snapshotpath");
					String mv_casting= rs.getString("mv_casting");
					String mv_crew= rs.getString("mv_crew");
					String mv_genres= rs.getString("mv_genres");
					String mv_overview= rs.getString("mv_overview");
					Date mv_releasedate= rs.getDate("mv_releasedate");
					int mv_votecount= rs.getInt("mv_votecount");
					Movie m = new Movie(mv_id,mv_title,mv_posterpath,mv_snapshotpath,mv_casting,mv_crew,mv_genres,mv_overview,mv_releasedate,mv_votecount);
					list.add(m);
					x++;
				}
				
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if( conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs!=null)
					rs.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
	    } // finally 
		return list;
	}
	
// 한개만 가져오는 메소드 
	
	public static Movie getMovie(String mv_id) {
		
		Connection conn = null; //db랑 연결해주는 객체
		PreparedStatement ps = null; //sql문장을 실행시키는 객체
		ResultSet rs = null; // sql 결과 데이터를 담는 객체

		
		try { //예외처리
			
			conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
			String sql="SELECT * FROM movie where mv_id=?"; //쿼리문 준비
			ps = conn.prepareStatement(sql);
			ps.setString(1,mv_id); // 오라클 똑똑 인트를 알아서 스트링으로 받아줌
			rs = ps.executeQuery();
			
			if(rs.next()) { //rs -1부터 시작 값 꺼내기 전에 커서 이동
				mv_id = rs.getString("mv_id");
				String mv_title= rs.getString("mv_title");
			    String mv_posterpath = rs.getString("mv_posterpath");
			    String mv_snapshotpath = rs.getString("mv_snapshotpath");
				String mv_casting= rs.getString("mv_casting");
				String mv_crew= rs.getString("mv_crew");
				String mv_genres= rs.getString("mv_genres");
				String mv_overview= rs.getString("mv_overview");
				Date mv_releasedate= rs.getDate("mv_releasedate");
				int mv_votecount= rs.getInt("mv_votecount");
				return new Movie(mv_id,mv_title,mv_posterpath,mv_snapshotpath,mv_casting,mv_crew,mv_genres,mv_overview,mv_releasedate,mv_votecount);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
		}finally {
			try {
				if( conn != null)
					conn.close();
				if(ps != null)
					ps.close();
				if(rs!=null)
					rs.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
	    } // finally 
		return null;
	}
	
//Overloading
	public static Movie getMovie() {
			
			Connection conn = null; //db랑 연결해주는 객체
			PreparedStatement ps = null; //sql문장을 실행시키는 객체
			ResultSet rs = null; // sql 결과 데이터를 담는 객체
	
			
			try { //예외처리
				
				conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
				String sql="SELECT * FROM movie WHERE mv_votecount = (SELECT max(mv_votecount) FROM movie)"; //쿼리문 준비
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				if(rs.next()) { 
					String mv_id = rs.getString("mv_id");
					String mv_title= rs.getString("mv_title");
				    String mv_posterpath = rs.getString("mv_posterpath");
				    String mv_snapshotpath = rs.getString("mv_snapshotpath");
					String mv_casting= rs.getString("mv_casting");
					String mv_crew= rs.getString("mv_crew");
					String mv_genres= rs.getString("mv_genres");
					String mv_overview= rs.getString("mv_overview");
					Date mv_releasedate= rs.getDate("mv_releasedate");
					int mv_votecount= rs.getInt("mv_votecount");
					return new Movie(mv_id,mv_title,mv_posterpath,mv_snapshotpath,mv_casting,mv_crew,mv_genres,mv_overview,mv_releasedate,mv_votecount);
				}
				
			}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
			}finally {
				try {
					if( conn != null)
						conn.close();
					if(ps != null)
						ps.close();
					if(rs!=null)
						rs.close();
				}catch (Exception e2) {
					e2.printStackTrace();
				}
		    } // finally 
			return null;
		}

//별점 가져오는 메소드
	public static int getMovieStar(String mv_id) {
			
			Connection conn = null; //db랑 연결해주는 객체
			PreparedStatement ps = null; //sql문장을 실행시키는 객체
			ResultSet rs = null; // sql 결과 데이터를 담는 객체	
			
			try { //예외처리
				
				conn = MyConnection.getConnection(); //이름에 맞는 클래스 찾아서 객체 생성
				String sql="SELECT mv_id, ROUND(AVG(r_star),1) as avg_star FROM review where mv_id=? group by mv_id"; //쿼리문 준비
				ps = conn.prepareStatement(sql);
				ps.setString(1, mv_id);
				rs = ps.executeQuery();
				
				if(rs.next()) { 
					int avg_star= rs.getInt("avg_star");
					return avg_star;
				}
				
			}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace(); // e로 오류 받아서 오류 어디서 발생했는지 콘솔에 띄우기
			}finally {
				try {
					if( conn != null)
						conn.close();
					if(ps != null)
						ps.close();
					if(rs!=null)
						rs.close();
				}catch (Exception e2) {
					e2.printStackTrace();
				}
		    } // finally 
			return 0;
		}
	

}
