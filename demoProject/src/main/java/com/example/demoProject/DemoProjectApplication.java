package com.example.demoProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoProject.controller.DemoController;

@SpringBootApplication
public class DemoProjectApplication {
	
	private static Logger logger = LoggerFactory.getLogger(DemoProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
//		System.out.println("Demo Application");
		
//		DemoController obj = new DemoController();
//		logger.info("Manual Object .."+obj);
	}

}
