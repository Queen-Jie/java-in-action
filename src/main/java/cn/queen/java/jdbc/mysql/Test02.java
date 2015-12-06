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
 * @since Dec 4, 2015
 */
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test02 {
	private static final Logger log = LoggerFactory.getLogger(Test02.class);
public static void main(String[] args){
	Connection con = null;
	try{String driverName = "com.mysql.jdbc.Driver";
	Class.forName(driverName);
	String url = "jdbc:mysql://localhost:3306/queen-test";
	String userName = "root";
	String passWord = "123456";
	con = DriverManager.getConnection(url,userName,passWord);
	Statement st = con.createStatement();
	String sql = "select * from CLASS_ONE";
	ResultSet  rs= st.executeQuery(sql);
	while(rs.next()){
		String name = rs.getString("姓名");
		String subject = rs.getString("科目");
		String score = rs.getString("成绩");
		log.info("{}=={}=={}",name, subject, score);
		}
	}catch(
				ClassNotFoundException e){
			log.error(e.getMessage(), e);
		}catch(
				SQLException e){
			log.error(e.getMessage(), e);
		}finally{
			try{if(con!=null){
				con.close();
			}
			}catch(
					SQLException e){}
		}
	}
}

