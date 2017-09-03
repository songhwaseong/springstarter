package com.example.demo.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TestDto {
	private String no;
	private String name;
	private int pagesu;
	private int totalcnt;
	private Date todaydate;
}
