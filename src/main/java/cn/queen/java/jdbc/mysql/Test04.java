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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Dec 6, 2015
 */

public class Test04 {
	private static final Logger log = LoggerFactory.getLogger(Test04.class);
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/queen-test";
	static String user = "root";
	static String password = "123456";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM CLASS_ONE WHERE COURSE=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,"语文");
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String name = set.getString("NAME");
				String subject = set.getString("COURSE");
				String score = set.getString("SCORE");
				log.info("姓名：{} 科目：{} 成绩{}", name, subject, score);
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
