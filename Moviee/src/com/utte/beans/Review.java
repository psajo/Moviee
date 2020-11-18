package com.utte.beans;

import java.sql.Date;

public class Review {	
	//테이블명 : review
	//컬럼명 : r_memId, r_movieId, r_contents, r_star, r_date
	private String r_memId;
	private String r_movieId;
	private String r_reviewId; //리뷰 번호
	private String r_contents;
	private String r_star;
	private Date r_date;
	
	
	public String getR_memId() {
		return r_memId;
	}
	public void setR_memId(String r_memId) {
		this.r_memId = r_memId;
	}
	public String getR_movieId() {
		return r_movieId;
	}
	public void setR_movieId(String r_movieId) {
		this.r_movieId = r_movieId;
	}
	public String getR_reviewId() {
		return r_reviewId;
	}
	public void setR_reviewId(String r_reviewId) {
		this.r_reviewId = r_reviewId;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public String getR_star() {
		return r_star;
	}
	public void setR_star(String r_star) {
		this.r_star = r_star;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
}
