package com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop")
//注解开启对AspectJ的支持
@EnableAspectJAutoProxy
public class AopConfig {

}

