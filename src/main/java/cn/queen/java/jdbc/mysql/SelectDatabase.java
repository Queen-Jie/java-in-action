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
/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Dec 5, 2015
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SelectDatabase {
	static final String driverName = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/phone_dashboard";
	private static String name = "root";
	private static String passWord = "123456";
	
	private static final Logger log = LoggerFactory.getLogger(SelectDatabase.class);

	public static void main(String[] args) {
		Connection connection = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, name, passWord);
			st= connection.createStatement();
			
			// dynamic SQL: before you executed it, you must specific the arguments
			String sql = "SELECT * FROM TV_DEVICE_COUNT_OBS t WHERE t.SUMMARY_DATE = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, "2015-11-25");
			
			ResultSet set = ps.executeQuery();
			while(set.next()){
				
				int c_device = set.getInt("C_DEVICE");
				log.info("C_DEVICE = {}", c_device);
			}
			
			connection.close();
			st.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
