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
 * @since Nov 16, 2015
 * Read bytes and display their hexadecimal values.
 * 用16进制显示读取的字节
 * 内容输出到控制台
 */

import java.io.FileInputStream;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReadBytes {
private Logger log = LoggerFactory.getLogger(ReadBytes.class);
	public void readBytes(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int temp = 0;
		byte[] bytes = new byte[16];
		do {
			try {
				temp = fis.read(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < temp; j++)
				 // "%"表示进行格式化输出，"%"之后的内容为格式的定义。 
				 // System.out.printf("%#x", i);// "d"表示输出带有十六进制标志的整数。
				System.out.printf("%02X ", bytes[j]);
		} while (temp != -1);
	}
}
