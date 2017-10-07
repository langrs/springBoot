package com.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	protected JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(User user){
		String sql = "insert into t_user(id,username) values(?,?)";
		jdbcTemplate.update(sql, user.getId(),user.getUsername());
	}
	
	public void update(User user){
		String sql = "update t_user set username=? where id=?";
		jdbcTemplate.update(sql,user.getUsername(),user.getId());
	}
}
