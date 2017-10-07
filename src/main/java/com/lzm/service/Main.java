package com.lzm.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lzm.config.DiConfig;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService = 
				context.getBean(UseFunctionService.class);
		System.out.println("come on...");
		System.out.println(useFunctionService.sayHello("lzm"));
		context.close();
	}

}
