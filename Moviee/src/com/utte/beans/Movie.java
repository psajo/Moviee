package com.utte.beans;

import java.sql.Date;

public class Movie {
	private String mv_id;
	private String mv_title;
	private String mv_posterpath;
	private String mv_snapshotpath;
	private String mv_casting;
	private String mv_crew;
	private String mv_genres;
	private String mv_overview;
	private Date mv_releasedate;
	private int mv_votecount;
	
	public Movie() {}
	
	public Movie(String mv_id, String mv_title, String mv_posterpath, String mv_snapshotpath,String mv_casting, String mv_crew, String mv_genres,
			String mv_overview, Date mv_releasedate, int mv_votecount) {
		this.mv_id = mv_id;
		this.mv_title = mv_title;
		this.mv_posterpath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"+ mv_posterpath;
		this.mv_snapshotpath = mv_snapshotpath;
		this.mv_casting = mv_casting;
		this.mv_crew = mv_crew;
		this.mv_genres = mv_genres;
		this.mv_overview = mv_overview;
		this.mv_releasedate = mv_releasedate;
		this.mv_votecount = mv_votecount;
	}

	public String getMv_id() {
		return mv_id;
	}

	public void setMv_id(String mv_id) {
		this.mv_id = mv_id;
	}

	public String getMv_title() {
		return mv_title;
	}

	public void setMv_title(String mv_title) {
		this.mv_title = mv_title;
	}

	public String getMv_posterpath() {
		return mv_posterpath;
	}

	public void setMv_posterpath(String mv_posterpath) {
		this.mv_posterpath = mv_posterpath;
	}

	public String getMv_snapshotpath() {
		return mv_snapshotpath;
	}

	public void setMv_snapshotpath(String mv_snapshotpath) {
		this.mv_snapshotpath = mv_snapshotpath;
	}

	public String getMv_casting() {
		return mv_casting;
	}

	public void setMv_casting(String mv_casting) {
		this.mv_casting = mv_casting;
	}

	public String getMv_crew() {
		return mv_crew;
	}

	public void setMv_crew(String mv_crew) {
		this.mv_crew = mv_crew;
	}

	public String getMv_genres() {
		return mv_genres;
	}

	public void setMv_genres(String mv_genres) {
		this.mv_genres = mv_genres;
	}

	public String getMv_overview() {
		return mv_overview;
	}

	public void setMv_overview(String mv_overview) {
		this.mv_overview = mv_overview;
	}

	public Date getMv_releasedate() {
		return mv_releasedate;
	}

	public void setMv_releasedate(Date mv_releasedate) {
		this.mv_releasedate = mv_releasedate;
	}

	public int getMv_votecount() {
		return mv_votecount;
	}

	public void setMv_votecount(int mv_votecount) {
		this.mv_votecount = mv_votecount;
	}

	@Override
	public String toString() {
		return "Movie [mv_id=" + mv_id + ", mv_title=" + mv_title + ", mv_posterpath=" + mv_posterpath
				+ ", mv_snapshotpath=" + mv_snapshotpath + ", mv_casting=" + mv_casting + ", mv_crew=" + mv_crew
				+ ", mv_genres=" + mv_genres + ", mv_overview=" + mv_overview + ", mv_releasedate=" + mv_releasedate
				+ ", mv_votecount=" + mv_votecount + "]";
	}


	}

	
