package com.lzm.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {
	public String sayHello(String word){
		return "hello " + word + "!";
	}

}
