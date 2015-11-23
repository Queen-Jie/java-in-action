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
package cn.queen.java.io.fileinputstream;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 18, 2015
 * Display file contents in hexadecimal 用十六进制显示文件的内容
 */
import java.io.*;
public class DisplayFileContentsInHexadecimal {
	public void displayFile(String path) {
		FileInputStream fis=null;
		int i = 0;
		int count = 0;
		try {
			fis = new FileInputStream(path);
			while ((i = fis.read()) != -1) {
				System.out.printf("%02x", i);
				// printf()一个方便的方法写一个格式化字符串输出流使用指定的格式字符串和参数。
				count++;
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		if (count == 16) {
			System.out.println(" ");
			count = 0;
		}

		try {
			fis.close();
		} catch (IOException e) {
		}
	}
}
