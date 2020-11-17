package com.utte.controller;

import java.sql.SQLException;

public class reviewReadService {
	private static reviewReadService instance = new reviewReadService();
	public static reviewReadService getInstance() {
		return instance;
	}
	private reviewReadService() {
		
	}
	
	//method 처리
	public int read(Review review)throws ServiceException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			ReviewDao dao = ReviewDao.getInstance();
			
			int rs = dao.insert(conn, review);
			
			return rs;
		} catch (SQLException e) {
			throw new ServiceException("리뷰 등록 실패:" + e.getMessage(),e);
		}
	}}
	}

}
