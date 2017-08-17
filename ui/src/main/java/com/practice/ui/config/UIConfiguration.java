package com.practice.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UIConfiguration {
	
	@Bean(name="restTemplate")
	public RestTemplate getRestTemplate(){
		RestTemplate template = new RestTemplate();
		return template;
	}

}
