package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HelloWorldDao;
import com.example.demo.dto.TestDto;

@Service
public class HelloWorldService {

	@Autowired
	private HelloWorldDao hwDao;
	
	public String selectDual() {
		return hwDao.selectDual();
	}
	public List<TestDto> selectTestdto() {
		return hwDao.selectTestdto();
	}
	public void insertTestdto(TestDto testDto) {
		hwDao.insertTestdto(testDto);
	}
	
	public void updateTestdto(TestDto testDto) {
		hwDao.updateTestdto(testDto);
	}
	
	public void delTestdto(String delno) {
		hwDao.delTestdto(delno);
	}
}
