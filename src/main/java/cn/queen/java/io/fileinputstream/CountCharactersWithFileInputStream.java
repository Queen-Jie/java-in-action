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
 * Count Characters with FileInputStream 通过文件输入流计算字符数
 */
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountCharactersWithFileInputStream {
	private Logger log = LoggerFactory.getLogger(CountCharactersWithFileInputStream.class);
	public void countChars(InputStream in) {
		int count = 0;

		try {
			while (in.read() != -1)
				// 从输入流中读取下一个字节的数据。字节作为int返回值在0到255之间。如果没有可用的字节,因为已经到达流的末尾,则返回-1。
				count++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Counted " + count + " chars.");
	}

}
