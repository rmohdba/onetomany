package com.practice.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.ui.config.UIConfiguration;

public class Application {

	public static void main(String[] args) {
		
//		SpringApplication.run(Application.class, args);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(UIConfiguration.class);
		applicationContext.refresh();
		applicationContext.scan("com.practice.ui");
		TestCall testCall = applicationContext.getBean(TestCall.class);
		testCall.fetchData();
		applicationContext.close();
	}

}
