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

public class createTable {
	private static final Logger log = LoggerFactory
			.getLogger(createTable.class);
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/queen-test";
	static String user = "root";
	static String passWord = "123456";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, passWord);
			st = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS PERSON " + "(id INT AUTO_INCREMENT, "
					+ " NAME VARCHAR (8), " + " age INT ( 2), "
					+ " PRIMARY KEY (id))";
			st.executeUpdate(sql);
			log.info("表创建成功");
			con.close();
			st.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
