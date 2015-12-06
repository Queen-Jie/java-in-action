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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Dec 6, 2015
 */

public class dropDatabase {
	private static final Logger log = LoggerFactory
			.getLogger(dropDatabase.class);
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/STUDENTS";
	private static String user = "root";
	private static String passWord = "123456";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url, user, passWord);
			st = con.createStatement();
			String sql = "DROP DATABASE STUDENTS";

			st.executeUpdate(sql);
			log.info("删除数据库");
			con.close();
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
