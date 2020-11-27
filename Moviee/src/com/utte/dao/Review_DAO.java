package com.utte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import com.utte.dao.*;
import com.utte.beans.*;


public class Review_DAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static Review_DAO instance;
	
	private Review_DAO() {}
	public static Review_DAO getInstance() {
		if(instance==null)
			instance=new Review_DAO();
		return instance;
		
	}
	
	//시퀀스 가져오기
	public int getSeq()
	{
		int result = 1;
		try {
			conn = MyConnection.getConnection();
			
			//시퀀스 값 가져오기 (DUAL : 시퀀스 값 가져오려고 만든 임시 테이블)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT r_reviewId_seq.nextval from dual");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			if (rs.next()) result = rs.getInt(1);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		close();
		return result;
	}
	
	//리뷰 삽입
	public boolean ReviewInsert(Review review)
	{
		boolean result = false;
		
		try {
			conn = MyConnection.getConnection();
			
			//자동 커밋 false로
			conn.setAutoCommit(false);
			//문자열 추가되니까 stringbuffer사용
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO REVIEW");
			sql.append("R_REVIEWID, M_NICK, MV_ID, R_CONTENTS, R_STAR, R_DATE);");
			sql.append(" VALUES(r_reviewId_seq.nextval,?,?,?,?,to_char(sysdate)");	
			
			ps.setString(1, review.getM_nick());
			ps.setInt(2, review.getMv_id());
			ps.setString(3, review.getR_contents());
			ps.setInt(4, review.getR_star());
			
			int flag = ps.executeUpdate();
			if(flag > 0) {
				result = true;
				conn.commit();
			}
		}	catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } 
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;    
	} 
	
	// DB 자원해제
    private void close()
    {
        try {
            if ( ps != null ){ ps.close(); ps=null; }
            if ( conn != null ){ conn.close(); conn=null;    }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
     // end close()    

    }
}

	
