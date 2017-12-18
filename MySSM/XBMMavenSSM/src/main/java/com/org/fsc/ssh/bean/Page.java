package com.org.fsc.ssh.bean;
public class Page {
	
	//第几页
	private int PageNo;
	//每页查询几条
	private int PageSize;
	public int getPageNo() {
		return PageNo;
	}
	public void setPageNo(int pageNo) {
		PageNo = pageNo;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

}
