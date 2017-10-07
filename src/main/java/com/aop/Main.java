package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
		DemoService demoService = context.getBean(DemoService.class);
		
		demoAnnotationService.add();
		demoMethodService.add();
		demoService.create("ok");
		demoService.update("ok", "lzm");
		context.close();
		System.out.println("hello world");
	}
	

}
