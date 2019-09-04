package com.mb.bean;

public class FenLei {
	private int fid;
	private String fname;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public FenLei(int fid, String fname) {
		super();
		this.fid = fid;
		this.fname = fname;
	}
	public FenLei() {
		super();
	}
	@Override
	public String toString() {
		return "FenLei [fid=" + fid + ", fname=" + fname + "]";
	}
	
	

}
