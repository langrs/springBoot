package com.aop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
//声明为切面
@Aspect
//让这个切面成为spring管理的Bean
@Component
public class LogAspect {
//通过注解PointCut声明切点
	@Pointcut("@annotation(com.aop.Action)")
	public void annotationPointCut(){};
//	通过After注解声明一个建言,并使用PointCut定义的切点
		@After("annotationPointCut()")
		public void ater(JoinPoint joinPoint){
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			Method method = signature.getMethod();
			Action action = method.getAnnotation(Action.class);
			System.out.println("註解式攔截:" + action.name());
		}
//		通过Before注解声明一个建言,直接使用拦截规则作为参数
		@Before("execution(* com.aop.DemoMethodService.*(..))")
		public void before(JoinPoint joinPoint){
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			Method method = signature.getMethod();
			System.out.println("方法規則攔截:" + method.getName());
		}
		

	
}
