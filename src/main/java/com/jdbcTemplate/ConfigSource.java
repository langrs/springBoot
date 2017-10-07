package com.jdbcTemplate;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@ImportResource({"classpath:bean.xml"})
//@ComponentScan(basePackages = { "com.datasource" })  
public class ConfigSource {
//	@Bean
	public BasicDataSource basicDataSource(){
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "1";
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverClassName);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource; 
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(basicDataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao();
		userDao.setJdbcTemplate(jdbcTemplate());
		return userDao;
	}
}
