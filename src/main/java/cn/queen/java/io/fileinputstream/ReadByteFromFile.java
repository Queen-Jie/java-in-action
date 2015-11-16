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
 * Read one byte from a file  从文件读取一个字节
 */
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReadByteFromFile {
	private Logger log = LoggerFactory.getLogger(ReadByteFromFile.class);
	public void readOneByte(String path) {
		log.info("读取成功！");
		FileInputStream fis = null;

		byte x = -1;
		try {
			fis = new FileInputStream(path);
			x = (byte) fis.read();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
			}
		}
	}
}
