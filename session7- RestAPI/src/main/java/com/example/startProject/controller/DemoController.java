package com.example.startProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.startProject.config.CustomConfig;
import com.example.startProject.model.Demo;
import com.example.startProject.service.PaymentService;


@RestController
@RequestMapping("/v1")
public class DemoController {
	
//	@Autowired
//	@Qualifier("PaymentServiceImpl2")
//	PaymentService paymentService2;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	CustomConfig customConfig;
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);

	
	@GetMapping("/demo")
	public Demo getDemo() {
		Demo demo = new Demo();
		logger.info("Demo Object is : {}",demo);
		paymentService.printMessage();
		return demo;
	}
	
	@PostMapping("/demo")
	public Demo saveDemo() {
		Demo demo = new Demo();
		logger.info("Demo Object is : {}",demo);
		paymentService.printMessage();
		return demo;
	}
	
//	@RequestMapping("/demo", method = requestmethod.Get)
//	public void getDemo1() {
//		
//	}
	
	@GetMapping("/requestParam")
	public void requestParamMethod(@RequestParam String name) {
		logger.info("Request Param received with : {}",name);
	}
	
	@GetMapping("/pathVariable/{id}/addr/{addrId}")
	public void requestParamMethod(@PathVariable int id,@PathVariable int addrId) {
		logger.info("Path Variable received with : {}",id);
	}
	
	@GetMapping("/requestBody")
	public Demo requestParamMethod(@RequestBody Demo demoObj) {
		logger.info("Request Body received with : {}",demoObj.getName());
		return demoObj;
	}
	
	
	@GetMapping("/getTemplate")
	public void getTemplate() {
		logger.info("In DemoController : {}",customConfig.getTemplate());
	}
	
//In Custom Config : org.springframework.web.client.RestTemplate@7bdf8105
//In Custom Config : org.springframework.web.client.RestTemplate@58aa4a47
}
