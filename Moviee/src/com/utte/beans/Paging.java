package com.utte.beans;

public class Paging {
	private int pageNumSize;
	private int pageSize;
	private int count;
	private int pageCount;
	private int startPage;
	private int endPage;
	private int startRownum;
	private int endRownum;
	public Paging(int count) {
		pageSize=5;//한번에 보여지는 리뷰 수
		pageNumSize=10; // 한번에 보여지는 페이지 갯수
		this.count = count; //총 리뷰 수
		pageCount =count/pageSize; //몇개의 페이지가 있는 지
	}
	public void setPaging(int page) {
		startPage = page/ 10 * 10 +1;
		endPage = page / 10 * 10 +10;
		startRownum = (page-1)*pageSize+1;
		endRownum = (page-1)*pageSize +pageSize;
	}
	public int getPageNumSize() {
		return pageNumSize;
	}
	public void setPageNumSize(int pageNumSize) {
		this.pageNumSize = pageNumSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRownum() {
		return startRownum;
	}
	public void setStartRownum(int startRownum) {
		this.startRownum = startRownum;
	}
	public int getEndRownum() {
		return endRownum;
	}
	public void setEndRownum(int endRownum) {
		this.endRownum = endRownum;
	}
}
