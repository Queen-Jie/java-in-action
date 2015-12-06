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
import java.sql.ResultSet;
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

public class SelectRecord {
	private static final Logger log = LoggerFactory
			.getLogger(SelectRecord.class);
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/queen-test";
	private static String user = "root";
	private static String password = "123456";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String sql = "select 姓名, 科目, 成绩 from class_one where 姓名 = '二二'";
			ResultSet set = st.executeQuery(sql);
			while (set.next()) {
				String name = set.getString("姓名");
				String subject = set.getString("科目");
				int score = set.getInt("成绩");
				log.info("姓名：{} 科目：{} 成绩：{}", name, subject, score);
			}
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
