/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.queen.java.jdbc.mysql;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Dec 5, 2015
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CreateDatabase {
	private static final Logger log = LoggerFactory
			.getLogger(CreateDatabase.class);
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String userName = "root";
	private static String passWord = "123456";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);
			st = con.createStatement();
			String sql = "create database STUDENTS";
			st.executeUpdate(sql);
			log.info("STUDENTS数据库创建成功");
			st.close();
		    con.close();
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
		
	}
}
