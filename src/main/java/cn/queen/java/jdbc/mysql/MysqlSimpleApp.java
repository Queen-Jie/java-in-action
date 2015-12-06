package cn.queen.java.jdbc.mysql;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Dec 4, 2015
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlSimpleApp {

	private static final Logger log = LoggerFactory
			.getLogger(MysqlSimpleApp.class);

	public static void main(String[] args) {
		Connection connection = null;
		//connection与一个特定的数据库连接(会话)。执行SQL语句和结果返回一个连接的上下文中。
		try {
			// set driver class name: It provided in pom.xml file's
			//设置驱动器的类名，他在pom.xml中被提供
			// 'mysql-connector-java' section
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			//forName()
			/*
			返回类对象与给定字符串的类或接口的名称。调用这个方法等价于:
			forName(类名,真的,currentLoader)
			在currentLoader表示当前类的定义的类装入器。
			*/

			String serverName = "localhost"; // MySQL DB host （serverName服务器名称）
			String portNumber = "3306"; // MySQL DB port, default is 3306（portNumber连接端口号）
			String dataBase = "phone_dashboard";
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/"
					+ dataBase; // jdbc url, like this:
								// jdbc:mysql://localhost:3306/phone_dashboard
			String username = "root"; // MySQL account
			String password = "123456"; // user password

			// step 1: create connection instance:创建一个链接的实例
			connection = DriverManager.getConnection(url, username, password);
			//driverManager 管理一系列JDBC驱动器的服务
			//getConnection(String url, String username, String password)
			//试图建立一个连接到给定的数据库URL。
			// step 2: get a statement use connection. 使用链接得到一个声明
			Statement stmt = connection.createStatement();
			//createStatement()创建一个声明对象发送到数据库的SQL语句。
			int fetchSize = stmt.getFetchSize();
			//getFetchSize()检索结果集的行数,默认取大小ResultSet对象从这个语句生成对象。

			// Set the fetch size on the statement设置这个声明的大小
			// stmt.setFetchSize(100);

			// step 3: prepare your sql statement:准备sql语句
			String sql = "select * from TV_DEVICE_COUNT";

			// step 4: execute the sql, and get the result by ResultSet
			//执行sql,然后从结果集中得到结果
			ResultSet resultSet = stmt.executeQuery(sql);

			// step 5: eval all items in the result释放结果中的所有条目 
			while (resultSet.next()) {

				String model = resultSet.getString("MODEL");
				String c_device = resultSet.getString("C_DEVICE");
				String c_bootstrap = resultSet.getString("C_BOOTSTRAP");
				String c_heartbeat = resultSet.getString("C_HEARTBEAT");
				String summary_date = resultSet.getString("SUMMARY_DATE");

				log.info("{} -- {} -- {} -- {} -- {}", model, c_device,
						c_bootstrap, c_heartbeat, summary_date);
			}

			// Change the fetch size on the result set
			// resultSet.setFetchSize(100);

		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

}