package com.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(* com.aop.DemoService.c*(..))")
	public void lzmBefor(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("before方法規則拦截:" + method.getName());
	}
	@After("execution(* com.aop.DemoService.upd*(..))")
	public void lzmAfter(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("after方法規則拦截:" + method.getName());
		
	}
}
