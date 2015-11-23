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
 * @since Nov 17, 2015
 * Read file character by character读文件的字符
 */
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFileCharacter {
	private Logger log = LoggerFactory.getLogger(ReadFileCharacter.class);

	public void readFileCharacter(String path) {
		File file = new File(path);
		// 第一种情况：文件不存在
		if (!file.exists()) {
			log.info(path + " does not exist.");
			return;
		}
		// 第二种情况：不是文件，或者文件不能读取
		if (!(file.isFile() && file.canRead())) {
			log.info(file.getName() + " cannot be read from.");
			return;
		}
		// 第三种：是文件，且可以读取
		try {
			FileInputStream fis = new FileInputStream(file);
			char current;
			while (fis.available() > 0) {
				// 返回一个剩余的字节数,可以从这个输入流读取(或跳过)没有阻塞的下一个输入流调用的方法。
				//当没有更多的内容可读取的时候返回0
				current = (char) fis.read();
				///Reads a byte of data from this input stream.
				System.out.println(String.valueOf(current));
				// String.valueOf---字符如何转换成字符串
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
