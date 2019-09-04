package com.mb.bean;

public class DianYing {
	private int id;
	private String name;
	private String js;
	private String daoyan;
	private String shijian;
	
	private FenLei fenlei;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public String getDaoyan() {
		return daoyan;
	}

	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public FenLei getFenlei() {
		return fenlei;
	}

	public void setFenlei(FenLei fenlei) {
		this.fenlei = fenlei;
	}

	public DianYing(int id, String name, String js, String daoyan,
			String shijian, FenLei fenlei) {
		super();
		this.id = id;
		this.name = name;
		this.js = js;
		this.daoyan = daoyan;
		this.shijian = shijian;
		this.fenlei = fenlei;
	}

	public DianYing() {
		super();
	}

	@Override
	public String toString() {
		return "DianYing [id=" + id + ", name=" + name + ", js=" + js
				+ ", daoyan=" + daoyan + ", shijian=" + shijian + ", fenlei="
				+ fenlei + "]";
	}
	
	

}
