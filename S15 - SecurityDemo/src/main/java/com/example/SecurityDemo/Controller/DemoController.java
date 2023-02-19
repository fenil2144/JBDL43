package com.example.SecurityDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/home")
	public String greet() {
		return "Hello, Welcome To Home!";
	}
	
	@GetMapping("/developercode")
	public String developercode() {
		return "Welcome Developer!";
	}
	
	@GetMapping("/testcode")
	public String qacode() {
		return "Welcome QA!";
	}
	
	@GetMapping("/generalcode")
	public String generalcode() {
		return "Welcome Dev/QA!";
	}
	
	
	
	
	
//	Request Comes to Backend:
//		1) JSESSIONID sent is of unauthenticated session/user
//			BE: verify the sessionid and redirect to /login api/page
//			FE: Pass the credentials entered by user and calls the login with unauthenticated sessionID
//			BE: Verify on basis of username and password and generate new authenticated JSESSIONID and pass it
//				in the response header as cookie.
//			
//			DBEEEFCBCFA5EDC810CBA597F9B10666
//			DBEEEFCBCFA5EDC810CBA597F9B10666
//			CEBC256A9116DCF9E81D7EEC673231F8
	
//	C83A1A6A888963588837CBADBD88CD8C
	
//		2) JSESSIONID is of authenticated session/user
//			BE: verify the session id, return the response of the requested resource.

}
