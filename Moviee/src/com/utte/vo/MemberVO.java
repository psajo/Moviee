package com.utte.vo;

public class MemberVO {
	//테이블명 : member 
	//컬렴명 : m_email, m_pwd, m_nick, m_fav1, m_fav2, m_fav3
	//이메일을 pk로 사용함
	private String m_email;
	private String m_pwd;
	private String m_nick;
	private String m_fav1;
	private String m_fav2;
	private String m_fav3;
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getM_fav1() {
		return m_fav1;
	}
	public void setM_fav1(String m_fav1) {
		this.m_fav1 = m_fav1;
	}
	public String getM_fav2() {
		return m_fav2;
	}
	public void setM_fav2(String m_fav2) {
		this.m_fav2 = m_fav2;
	}
	public String getM_fav3() {
		return m_fav3;
	}
	public void setM_fav3(String m_fav3) {
		this.m_fav3 = m_fav3;
	}
}
