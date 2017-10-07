package com.jdbcTemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ConfigSource.class);
		UserDao userDao = ctx.getBean(UserDao.class);
		
		for(int i=0;i<40000;i++){
			User user = new User();
			user.setId(String.valueOf(i));
			user.setUsername("N" + String.valueOf(i));
			userDao.create(user);
			
		}
	}

}
