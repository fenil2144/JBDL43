package com.example.startProject.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomConfig {
	
	private static Logger logger = LoggerFactory.getLogger(CustomConfig.class);
	
	@Bean
	@Scope("request")
	public RestTemplate getTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("In Custom Config : {}",restTemplate);
		return restTemplate;
	}

}
