package com.example.demo.dto;

import java.sql.Date;

public class TestDto {
	private String no;
	private String name;
	private Date todaydate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTodaydate() {
		return todaydate;
	}
	public void setTodaydate(Date todaydate) {
		this.todaydate = todaydate;
	}
}
