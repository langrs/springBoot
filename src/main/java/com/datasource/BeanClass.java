package com.datasource;

import org.springframework.stereotype.Component;

@Component(value="BeanClass")
public class BeanClass {
	public int calc(int a,int b){
		return a+b;
	}
}
