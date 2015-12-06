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
package cn.queen.java.io.file_writer;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 25, 2015
 * Append or add some contents to the file
 * 在文件中添加内容
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendContents {
	public static void main(String[] args) {
		File file = new File("f:/bc.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
			fw.append("Usename:java  Password:secret"
					+ System.getProperty("line.seperator"));
			//System.getProperty(String key);获取用指定键描述的系统属性。 。
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}