package com.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainSource {

	public static void main(String[] args) throws Exception {
//		通过配置文件实现的配置
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//		通过config类实现的配置
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ConfigSource.class);
//		DataSource datasource = (DataSource) ctx.getBean("basicDataSource");
		DataSource datasource = (DataSource) ctx.getBean("dataSource");

		BeanClass beanClass = (BeanClass) ctx.getBean("BeanClass");
		
//		DataSourceTransactionManager d;
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "select * from t_user ";
//		String sql = "update t_test set username  ='111' where id='1'";
//		String sql1 = "update t_user set username  ='222' where id='2'";

//		con = datasource.getConnection();
//		con.setAutoCommit(false);
//		stmt = (Statement) con.createStatement();
//		stmt.executeUpdate(sql);
//		con.rollback();
//		stmt.executeUpdate(sql1);
//		con.commit();
//		con.close();
		for (int i = 0; i < 10; i++) {

			long beforeTimeOffset = -1L; // 创建Connection对象前时间
			long afterTimeOffset = -1L; // 创建Connection对象后时间
			long executeTimeOffset = -1L; // 创建Connection对象后时间

			beforeTimeOffset = new Date().getTime();
			System.out.println(i + ":before:\t" + beforeTimeOffset);

			con = datasource.getConnection();

			afterTimeOffset = new Date().getTime();
			System.out.println(i + ":after:\t" + afterTimeOffset);
			System.out.println(i+":Create Costs:\t" + (afterTimeOffset - beforeTimeOffset) + " ms");

			stmt = (Statement) con.createStatement();
			resultSet = stmt.executeQuery(sql);

			executeTimeOffset = new Date().getTime();
			System.out.println(i+":Exec Costs:\t" + (executeTimeOffset - afterTimeOffset) + " ms");

			 while (resultSet.next()) {
			 System.out.println(resultSet.getLong(1));
			 }
			con.close();
		}
		System.out.println("answer is" + beanClass.calc(100, 20));
	}

}
