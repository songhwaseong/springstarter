package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.TestDto;
import com.example.demo.service.HelloWorldService;

@Controller
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService hwService;
	
	@RequestMapping(value="/abc")
	public ModelAndView root_test(ModelAndView model){
		model.setViewName("body/body");
		
		String a = hwService.selectDual();
		a= "현재시간 : "+a;
		model.addObject("sysdate", a);
		return model;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView selectTestdto(ModelAndView model){
		model.setViewName("body/list");
		List<TestDto> testDto = hwService.selectTestdto();
		model.addObject("test", testDto);
		return model;
	}
	
	@RequestMapping(value="/insert")
	public ModelAndView insert(ModelAndView model){
		model.setViewName("body/insert");
		return model;
	}
	
	@RequestMapping(value="/insertRst")
	public ModelAndView insertTestdto(@RequestParam("name") String name,
			ModelAndView model){
		model.setViewName("body/body");
		TestDto testDto = new TestDto();
		testDto.setName(name);
//		for(int i=0;i<200;i++) {
//			testDto.setNo(""+i);
//			testDto.setName("a"+i);
//			hwService.insertTestdto(testDto);
//		}
		hwService.insertTestdto(testDto);
		return selectTestdto(model);
	}
	
	@RequestMapping(value="/update")
	public ModelAndView updateTestdto(@RequestParam("no") String no, @RequestParam("testName") String name,
			ModelAndView model){
		model.setViewName("body/body");
		TestDto testDto = new TestDto();
		testDto.setNo(no);
		testDto.setName(name);
//		for(int i=0;i<200;i++) {
//			testDto.setNo(""+i);
//			testDto.setName("a"+i);
//			hwService.insertTestdto(testDto);
//		}
		hwService.updateTestdto(testDto);
		return selectTestdto(model);
	}
	
	
	@RequestMapping(value="/delete")
	public ModelAndView delTestdto(@RequestParam("no") String no, ModelAndView model){
		model.setViewName("body/body");
		if(no == null || "".equals(no)) {
			return selectTestdto(model);
		}
		hwService.delTestdto(no);
		return selectTestdto(model);
	}

}
