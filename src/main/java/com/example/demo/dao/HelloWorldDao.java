package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.TestDto;
import com.example.demo.mapper.HelloWorldMapper;

@Repository
public class HelloWorldDao {

	@Autowired
	private HelloWorldMapper hwMapper;
	
	public String selectDual() {
		return hwMapper.selectDual();
	}
	public List<TestDto> selectTestdto(int pageNo) {
		return hwMapper.selectTestdto(pageNo);
	}
	
	public void insertTestdto(TestDto testDto) {
		hwMapper.insertTestdto(testDto);
	}
	
	public void updateTestdto(TestDto testDto) {
		hwMapper.updateTestdto(testDto);
	}
	public void delTestdto(String delno) {
		hwMapper.delTestdto(delno);
	}
}
