package com.example.demoProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.Demo;

@RestController
public class DemoController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	
	//Field Injection
//	@Autowired
	private Demo demo;
	
	//Constructor Injection
	@Autowired
	public DemoController(Demo demo) {
		this.demo = demo;
		logger.info("Creating .. "+this);
	}
	
//	@Value("${customUrl}")
//	String url;
	
//	public DemoController(int demo) {
//		this.demo = demo;
//		logger.info("Creating .. "+this);
//	}
	
	@GetMapping("/demo")
	public Demo getDemo() {
		logger.info("Printing demo"+demo);
		System.out.println();
		return demo;
	}
	
	//com.example.demoProject.controller.DemoController@433ffad1 - created by spring
	//com.example.demoProject.controller.DemoController@cda0432 - Created Manually
	
	//com.example.demoProject.model.Demo@1c7490ac
	//com.example.demoProject.model.Demo@1c7490ac

}
