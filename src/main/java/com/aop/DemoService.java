package com.aop;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public void update(String id,String name){
		System.out.println("DemoService update function");
	};
	public void create(String id){
		System.out.println("DemoService create function");
	};
}
