package com.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class MainMysql {
	public static void main(String[] args) throws Exception {
		// 测试通过jdbc连接数据库mysql
		testJdbc();
	}

	public static void testJdbc() throws Exception {

		long beforeTimeOffset = -1L; // 创建Connection对象前时间
		long afterTimeOffset = -1L; // 创建Connection对象后时间
		long executeTimeOffset = -1L; // 创建Connection对象后时间

		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		// 这里要注意的是需要处理很多的异常try catch
		// 还有注意的是jdbc简单应用里面如何将resultset转换成bean也是比较麻烦的，所以才会要用mybatis
		String url = "jdbc:mysql://localhost:3306/test2?user=root&password=1";
		String sql = "select * from t_user ";
		for (int i = 0; i < 100; i++) {
			beforeTimeOffset = new Date().getTime();
			System.out.println(i + ":before:\t" + beforeTimeOffset);
			con = (Connection) DriverManager.getConnection(url);
			
			afterTimeOffset = new Date().getTime();
			System.out.println(i + ":after:\t" + afterTimeOffset);
			System.out.println(i+":Create Costs:\t" + (afterTimeOffset - beforeTimeOffset) + " ms");


			
			stmt = (Statement) con.createStatement();
			resultSet = stmt.executeQuery(sql);
			
			executeTimeOffset = new Date().getTime();
			System.out.println(i+":Exec Costs:\t" + (executeTimeOffset - afterTimeOffset) + " ms");

//			while (resultSet.next()) {
//				System.out.println(resultSet.getLong(1));
//			}
			con.close();
		}
	}
}
