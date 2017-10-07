package com.beantest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		UseFunctionService useFunctionService = 
				context.getBean(UseFunctionService.class);
		System.out.println("come on...");
		System.out.println(useFunctionService.sayHello("lzm"));
		context.close();
	}
}
