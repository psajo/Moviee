package com.utte.beans;

import java.sql.Date;

public class Review {	
	//테이블명 : review
	//컬럼명 : R_REVIEWID	M_NICK	MV_ID	R_CONTENTS	R_STAR	R_DATE
	private int r_reviewId;
	private String m_nick;
	private int mv_id; //리뷰 번호
	private String r_contents;
	private double r_star;
	private String r_date; //단순한 출력일땐 string 가능
	public int getR_reviewId() {
		return r_reviewId;
	}
	public void setR_reviewId(int r_reviewId) {
		this.r_reviewId = r_reviewId;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public int getMv_id() {
		return mv_id;
	}
	public void setMv_id(int mv_id) {
		this.mv_id = mv_id;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public double getR_star() {
		return r_star;
	}
	public void setR_star(double r_star) {
		this.r_star = r_star;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	
	
	
}
