package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.TestDto;

public interface HelloWorldMapper extends SqlMapper{
	
	String selectDual();
	
	List<TestDto> selectTestdto(int pageNo);
	
	void insertTestdto(TestDto testdto);
	
	void updateTestdto(TestDto testdto);
	
	void delTestdto(String delno);
}
